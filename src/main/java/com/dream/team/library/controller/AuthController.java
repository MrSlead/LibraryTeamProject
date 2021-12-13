package com.dream.team.library.controller;

import com.dream.team.library.entity.authorization.Client;
import com.dream.team.library.entity.authorization.converter.Role;
import com.dream.team.library.payload.AuthApiString;
import com.dream.team.library.payload.request.LoginRequest;
import com.dream.team.library.payload.request.RegistrationRequest;
import com.dream.team.library.payload.response.JwtResponse;
import com.dream.team.library.payload.response.MessageResponse;
import com.dream.team.library.security.jwt.JwtUtils;
import com.dream.team.library.security.userdetails.UserDetailsImpl;
import com.dream.team.library.service.interf.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin(origins = "${cross.origin.path}")
@RestController
@RequestMapping("${auth.api.begin}")
public class AuthController {
    private AuthenticationManager authenticationManager;

    private ClientService clientService;

    private PasswordEncoder encoder;

    private JwtUtils jwtUtils;

    private AuthApiString authApiString;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Autowired
    public void setJwtUtils(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Autowired
    public void setAuthApiString(AuthApiString authApiString) {
        this.authApiString = authApiString;
    }


    @PostMapping("${auth.api.login}")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        log.info("API was called: " + authApiString.getAuthApiLogin());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        log.info("The client has successfully logged in, login: " + loginRequest.getLogin());
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles.get(0)));
    }

    @PostMapping("${auth.api.registration}")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        log.info("API was called: " + authApiString.getAuthApiRegistration());

        if (clientService.findByLogin(registrationRequest.getLogin()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Login is already taken!"));
        }

        if (clientService.findByEmail(registrationRequest.getEmail()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new client's account
        Client client = new Client(registrationRequest.getLogin(), registrationRequest.getEmail(), encoder.encode(registrationRequest.getPassword()));
        client.setRole(Role.ORDINARY);
        clientService.save(client);

        log.info("The client registered successfully, login: " + registrationRequest.getLogin() + ", email: " + registrationRequest.getEmail());
        return ResponseEntity.ok(new MessageResponse("Client registered successfully!"));
    }
}
