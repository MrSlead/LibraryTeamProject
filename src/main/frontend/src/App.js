import React, { useState, useEffect } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import Logo from "./images/logo.png";

import AuthService from "./services/authservice";

import Login from "./components/Login";
import Register from "./components/Register";
import Home from "./pages/Home";
import Profile from "./components/Profile";
import BoardUser from "./components/user";
// import BoardModerator from "./components/BoardModerator";
// import BoardAdmin from "./components/BoardAdmin";

const App = () => {
  const [showModeratorBoard, setShowModeratorBoard] = useState(false);
  const [showAdminBoard, setShowAdminBoard] = useState(false);
  const [currentUser, setCurrentUser] = useState(undefined);

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setCurrentUser(user);
      // setShowModeratorBoard(user.roles.includes("ROLE_MODERATOR"));
      // setShowAdminBoard(user.roles.includes("ROLE_ADMIN"));
    }
  }, []);

  const logOut = () => {
    AuthService.logout();
  };

  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-primary d-flex justify-content-evenly">
        <Link to={"/"} className="navbar-brand">
          <img style={{ width: 50 }} src={Logo} alt="" />
        </Link>
        <div className="navbar-nav mr-auto">
          <nav className="navbar">
            <li className="nav-item">
              <Link to={"/home"} className="nav-link">
                Home
              </Link>
            </li>

            <li className="nav-item">
              <Link to={"/#"} className="nav-link">
                Genre
              </Link>
            </li>

            <li className="nav-item">
              <Link to={"/#"} className="nav-link">
                Books
              </Link>
            </li>
          </nav>

          {showModeratorBoard && (
            <li className="nav-item">
              <Link to={"/mod"} className="nav-link">
                Moderator Board
              </Link>
            </li>
          )}

          {showAdminBoard && (
            <li className="nav-item">
              <Link to={"/admin"} className="nav-link">
                Admin Board
              </Link>
            </li>
          )}

          {currentUser && (
            <li className="nav-item">
              <Link to={"/user"} className="nav-link">
                {/* User */}
              </Link>
            </li>
          )}
        </div>
        {currentUser ? (
          <div className="ml-auto">
            <li className="nav-item">
              <Link to={"/profile"} className="nav-link text-white">
                {currentUser.username}
              </Link>
            </li>
            <li className="nav-item">
              <a
                href="/login"
                className=" nav-link text-white"
                onClick={logOut}
              >
                LogOut
              </a>
            </li>
          </div>
        ) : (
          <div className="navbar-nav ml-auto">
            <li className="nav-item">
              <Link to={"/login"} className="nav-link">
                Login
              </Link>
            </li>

            <li className="nav-item">
              <Link to={"/register"} className="nav-link">
                Sign Up
              </Link>
            </li>
          </div>
        )}{" "}
        <nav class="navbar navbar-primary bg-primary">
          <div class="container-fluid">
            <form class="d-flex">
              <input
                class="form-control me-2"
                type="search"
                placeholder="Search"
                aria-label="Search"
              />
              <button class="btn btn-primary" type="submit">
                Search
              </button>
            </form>
          </div>
        </nav>
      </nav>

      <div className="container mt-3">
        <Switch>
          <Route exact path={["/", "/home"]} component={Home} />
          <Route exact path="/login" component={Login} />
          <Route exact path="/register" component={Register} />
          <Route exact path="/profile" component={Profile} />
          <Route path="/user" component={BoardUser} />
          {/* <Route path="/mod" component={BoardModerator} /> */}
          {/* <Route path="/admin" component={BoardAdmin} /> */}
        </Switch>
      </div>
    </div>
  );
};

export default App;
