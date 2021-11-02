import axios from "axios";

const API_URL = "http://localhost:8080/api/v1/auth/";

const register = (username, email, password) => {
  return axios.post(API_URL + "registration", {
    username,
    email,
    password,
  });
};

const login = (username, password) => {
  return axios
    .post(API_URL + "login", {
      username,
      password,
    })
    .then((response) => {
      if (response.data.accessToken) {
        localStorage.setItem("username", JSON.stringify(response.data));
      }
      return response.data;
    });
};

const logout = (username, password) => {
  localStorage.removeItem("username");
};

const getCurrentUser = () => {
  return JSON.parse(localStorage.getItem("username"));
};

export default {
  register,
  login,
  logout,
  getCurrentUser,
};
