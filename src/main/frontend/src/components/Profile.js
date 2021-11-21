import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import authHeader from '../services/authHead';
import UserService from '../services/userService';
import axios from 'axios';
import AuthService from '../services/authservice';

const Profile = () => {
  const currentUser = AuthService.getCurrentUser();

  const [userList, setUserList] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/v1/client/all', { headers: authHeader() }).then((res) => {
      console.log(res.data);
      setUserList(res.data);
    });
  }, []);
  return (
    <>
      <nav className="navbar navbar-dark bg-primary">
        <div className="container">
          <div className="ml-auto" style={{ display: 'flex' }}>
            <li className="nav-item">
              <Link to={'/books'} className="nav-link text-white">
                Books
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/" className="nav-link text-white">
                Home
              </Link>
            </li>
          </div>

          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarText"
            aria-controls="navbarText"
            aria-expanded="false"
            aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarText">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <a className="nav-link active" aria-current="page" href="#">
                  Home
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">
                  Features
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">
                  Pricing
                </a>
              </li>
            </ul>
            <span className="navbar-text">Navbar text with an inline element</span>
          </div>
        </div>
      </nav>

      <section className="section about-section gray-bg" id="about">
        <div className="container">
          <div className="row align-items-center flex-row-reverse">
            <div className="col-lg-6">
              <div className="about-text go-to">
                <strong>{currentUser.username}</strong> Profile
                <div className="row about-list">
                  <div className="col-md-6">
                    <div className="media">
                      <p classNameName="media">
                        <strong>Token:</strong> {currentUser.token.substring(0, 20)} ...{' '}
                        {currentUser.token.substr(currentUser.token.length - 20)}
                      </p>

                      <strong>Authorities:</strong>
                      <ul>
                        {currentUser.roles &&
                          currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
                      </ul>
                      <label>Birthday</label>
                      <p>...</p>
                    </div>
                    <div className="media">
                      <label>Age</label>
                      <p>...</p>
                    </div>
                  </div>
                  <div className="col-md-6">
                    <div className="media">
                      <p>
                        <strong>Email:</strong> {currentUser.email}
                      </p>
                    </div>
                    <div className="media">
                      <label>Phone</label>
                      <p>...</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="col-lg-6">
              <div className="about-avatar">
                <img src="https://bootdey.com/img/Content/avatar/avatar7.png" title="" alt="" />
              </div>
            </div>
          </div>
          <div className="counter">
            <div className="row">
              <div className="col-6 col-lg-3">
                <div className="count-data text-center">
                  <h6 className="count h2" data-to="500" data-speed="500">
                    500
                  </h6>
                  <p className="m-0px font-w-600">Books</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
};

export default Profile;
