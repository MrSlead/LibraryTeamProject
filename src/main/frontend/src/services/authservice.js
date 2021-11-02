import axios from "axios";

const API_URL = "http://localhost:8080/api/v1/auth/";

const register = (login, email, password) => {
  return axios.post(API_URL + "registration", {
    login,
    email,
    password,
  });
};

const login = (login, password) => {
  return axios
    .post(API_URL + "login", {
      login,
      password,
    })
    .then((response) => {
      if (response.data.token) {
        localStorage.setItem("user", JSON.stringify(response.data));
      }
      return response.data;
    });
};

const logout = (login, password) => {
  localStorage.removeItem("user");
};

const getCurrentUser = () => {
  return JSON.parse(localStorage.getItem("user"));
};

export default {
  register,
  login,
  logout,
  getCurrentUser,
};
