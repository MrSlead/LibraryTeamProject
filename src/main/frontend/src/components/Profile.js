import React, { useState, useEffect } from "react";
import authHeader from "../services/authHead";
import UserService from "../services/userService";
import axios from "axios";
import AuthService from "../services/authservice";

const Profile = () => {
  const currentUser = AuthService.getCurrentUser();

  const [userList, setUserList] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/v1/client/all", { headers: authHeader() })
      .then((res) => {
        console.log(res.data);
        setUserList(res.data);
      });
  }, []);
  return (
    <div className="container">
      <header className="jumbotron">
        <h3>
          <strong>{currentUser.username}</strong> Profile
        </h3>
      </header>
      <p>
        <strong>Token:</strong> {currentUser.token.substring(0, 20)} ...{" "}
        {currentUser.token.substr(currentUser.token.length - 20)}
      </p>
      <p>
        <strong>Id:</strong> {currentUser.id}
      </p>
      <p>
        <strong>Email:</strong> {currentUser.email}
      </p>
      <strong>Authorities:</strong>
      <ul>
        {currentUser.roles &&
          currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
      </ul>
    </div>
  );
};

export default Profile;
