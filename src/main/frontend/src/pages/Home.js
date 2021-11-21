import React, { useState, useEffect } from 'react';
import '../style/style.css';
import { Link } from 'react-router-dom';
import AuthService from '../services/authservice';

const Home = () => {
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
      <header>
        <div className="header__wrapper container">
          <div className="header__wrapper__menu">
            <div className="header__wrapper__menu__left">
              <a href="index.html" className="logo">
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50">
                  <defs></defs>
                  <g id="Capa_2" data-name="Capa 2">
                    <g id="Layer_3" data-name="Layer 3">
                      <path
                        className="cls-1"
                        d="M39.35,16.24v17a1.08,1.08,0,0,1-1.08,1.08H26.19a1.21,1.21,0,0,1-1.19,1,1.23,1.23,0,0,1-1.2-1H11.73a1.13,1.13,0,0,1-.67-.23,1.08,1.08,0,0,1-.41-.85v-17a1.08,1.08,0,0,1,1.08-1.08h2c-.42.16-.84.34-1.25.53a.65.65,0,0,0-.35.55v17a.35.35,0,0,0,.53.32,13.82,13.82,0,0,1,12,0,.41.41,0,0,0,.19,0,.35.35,0,0,0,.14,0,.34.34,0,0,0,.31,0,13.82,13.82,0,0,1,12,0,.41.41,0,0,0,.19,0,.35.35,0,0,0,.34-.37v-17a.67.67,0,0,0-.35-.55c-.41-.19-.83-.37-1.25-.53h2a1.08,1.08,0,0,1,.86.43A1.13,1.13,0,0,1,39.35,16.24Zm-14.56,0V33.18a14.21,14.21,0,0,0-12.26,0V16.24a.23.23,0,0,1,.11-.17,13.72,13.72,0,0,1,6-1.39,13.72,13.72,0,0,1,6,1.39A.23.23,0,0,1,24.79,16.24Zm-.62.28a13.15,13.15,0,0,0-11,0V32.23a14.72,14.72,0,0,1,11,0Zm13.3-.28V33.18a14.21,14.21,0,0,0-12.26,0V16.24a.23.23,0,0,1,.11-.17,13.83,13.83,0,0,1,2.42-.91,13.73,13.73,0,0,1,9.62.91A.23.23,0,0,1,37.47,16.24Zm-.62.28a13.15,13.15,0,0,0-11,0V32.23a14.72,14.72,0,0,1,11,0ZM14.64,28.87a9.65,9.65,0,0,1,8,0,.42.42,0,0,0,.55-.21.41.41,0,0,0-.21-.55,10.48,10.48,0,0,0-8.73,0,.41.41,0,0,0,.18.79A.51.51,0,0,0,14.64,28.87Zm0-3.16a9.72,9.72,0,0,1,8,0A.41.41,0,1,0,23,25a10.48,10.48,0,0,0-8.73,0,.41.41,0,0,0,.18.79A.35.35,0,0,0,14.64,25.71Zm0-3.15a9.72,9.72,0,0,1,8,0,.41.41,0,1,0,.34-.75,10.48,10.48,0,0,0-8.73,0,.41.41,0,0,0,.18.79A.35.35,0,0,0,14.64,22.56Zm0-3.15a9.72,9.72,0,0,1,8,0,.41.41,0,1,0,.34-.75,10.48,10.48,0,0,0-8.73,0,.41.41,0,0,0,.18.79A.35.35,0,0,0,14.64,19.41Zm12.68,9.46a9.65,9.65,0,0,1,8,0,.42.42,0,1,0,.34-.76,10.48,10.48,0,0,0-8.73,0,.41.41,0,0,0-.2.55.42.42,0,0,0,.38.24Zm0-3.16a9.72,9.72,0,0,1,8,0,.41.41,0,0,0,.55-.2A.42.42,0,0,0,35.7,25,10.48,10.48,0,0,0,27,25a.41.41,0,0,0-.2.55.42.42,0,0,0,.38.24A.38.38,0,0,0,27.32,25.71Zm0-3.15a9.72,9.72,0,0,1,8,0,.41.41,0,0,0,.55-.2.42.42,0,0,0-.21-.55,10.48,10.48,0,0,0-8.73,0,.41.41,0,0,0-.2.55.42.42,0,0,0,.38.24A.38.38,0,0,0,27.32,22.56Zm0-3.15a9.72,9.72,0,0,1,8,0,.41.41,0,0,0,.55-.2.42.42,0,0,0-.21-.55,10.48,10.48,0,0,0-8.73,0,.41.41,0,0,0-.2.55.42.42,0,0,0,.38.24A.38.38,0,0,0,27.32,19.41Z"
                      />
                      <path
                        className="cls-1"
                        d="M25,3.15A21.87,21.87,0,0,1,46.85,25c0,.34,0,.65,0,.95V26a.66.66,0,0,1,0,.14c0,.27,0,.5-.05.73a21.83,21.83,0,0,1-20,19.87h0l-.69,0h-.05l-.93,0h-.06A21.85,21.85,0,0,1,25,3.15M25,0a25,25,0,0,0-.06,50H25c.37,0,.74,0,1.1,0s.57,0,.85,0a25,25,0,0,0,23-22.74l.06-.84c0-.08,0-.15,0-.22,0-.37,0-.74,0-1.12A25,25,0,0,0,25,0Z"
                      />
                    </g>
                  </g>
                </svg>
              </a>
            </div>
            <div className="header__wrapper__menu__right">
              <Link to="/books" className="header__wrapper__menu__right__item">
                Книги
              </Link>
              <a href="#" className="header__wrapper__menu__right__item">
                Пользователи
              </a>
              {currentUser ? (
                <div className="ml-auto">
                  <li className="nav-item">
                    <Link to={'/profile'} className="nav-link text-black">
                      {currentUser.username}
                    </Link>
                  </li>
                  <li className="nav-item">
                    <a href="/login" className=" nav-link text-black" onClick={logOut}>
                      Logout
                    </a>
                  </li>
                </div>
              ) : (
                <>
                  <button className="header__wrapper__menu__right__button">
                    <Link to={'/login'} className="login-button-text">
                      Log in
                    </Link>
                  </button>

                  <button className="header__wrapper__menu__right__button">
                    <Link to={'/register'} className="login-button-text">
                      Registration
                    </Link>
                  </button>
                </>
              )}
            </div>
          </div>
          <h1 className="header__wrapper__title">
            ONLINE <br /> LIBRARY
          </h1>
          <h3 className="header__wrapper__text">Найди свою книгу и читай ее здесь!</h3>
          <div className="header__wrapper__search">
            <input type="text" placeholder="Search Book" />
            <svg
              width="24"
              height="24"
              viewBox="0 0 24 24"
              fill="none"
              xmlns="http://www.w3.org/2000/svg">
              <path
                d="M11 19C15.4183 19 19 15.4183 19 11C19 6.58172 15.4183 3 11 3C6.58172 3 3 6.58172 3 11C3 15.4183 6.58172 19 11 19Z"
                stroke="black"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
              <path
                d="M21 21L16.65 16.65"
                stroke="black"
                stroke-width="2"
                stroke-linecap="round"
                stroke-linejoin="round"
              />
            </svg>
          </div>
        </div>
      </header>
    </div>
  );
};

export default Home;
