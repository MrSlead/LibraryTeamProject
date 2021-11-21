import React, { useState, useEffect } from 'react';
import { Switch, Route, Link } from 'react-router-dom';

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import Home from './pages/Home.js';
import AuthService from './services/authservice';
import Login from './components/Login';
import Register from './components/Register';
import Profile from './components/Profile';
import BoardUser from './components/user';
import Books from './pages/Books';

// import Home from "./pages/Home";
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
      <div>
        <Switch>
          <Route exact path={['/', '/home']} component={Home} />
          <Route exact path="/books" component={Books} />

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
