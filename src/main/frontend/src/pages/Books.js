import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import AuthService from '../services/authservice';
import Book from './Book';

const Books = () => {
  const [currentUser, setCurrentUser] = useState(undefined);
  const [searchTerm, setSearchTerm] = React.useState('');

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

  const people = ['Siri', 'Alexa', 'Google', 'Facebook', 'Twitter', 'Linkedin', 'Sinkedin'];

  const handleChange = (event) => {
    setSearchTerm(event.target.value);
  };

  const results = !searchTerm
    ? people
    : people.filter((person) => person.toLowerCase().includes(searchTerm.toLocaleLowerCase()));
  return (
    <>
      <nav class="navbar navbar-light bg-dark">
        <div class="container-fluid">
          <form class="d-flex">
            <input
              class="form-control me-2"
              type="search"
              placeholder="Search"
              aria-label="Search"
              value={searchTerm}
              onChange={handleChange}
            />
            <button class="btn btn-dark" type="submit">
              Search
            </button>
          </form>
          <a class="navbar-brand text-light" href="#">
            {currentUser ? (
              <div className="ml-auto" style={{ display: 'flex' }}>
                <li className="nav-item">
                  <Link to={'/profile'} className="nav-link text-white">
                    {currentUser.username}
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to="/" className="nav-link text-white" onClick={logOut}>
                    Logout
                  </Link>
                </li>
              </div>
            ) : (
              <>
                <div className="ml-auto" style={{ display: 'flex' }}>
                  <li className="nav-item">
                    <Link to={'/login'} className="nav-link text-white">
                      Log in
                    </Link>
                  </li>

                  <li className="nav-item">
                    <Link to={'/register'} className="nav-link text-white">
                      Registration
                    </Link>
                  </li>
                </div>
              </>
            )}
          </a>
        </div>
      </nav>
      <section>
        <div className="section__wrapper container">
          <aside className="section__aside">
            <div className="aside__filter">
              <h3 className="aside__filter__title">Книга по жанру</h3>
              <a href="#" className="aside__filter__item">
                Все жанры
              </a>
              <a href="#" className="aside__filter__item">
                Философия
              </a>
              <a href="#" className="aside__filter__item">
                Наука
              </a>
              <a href="#" className="aside__filter__item">
                Биография
              </a>
              <a href="#" className="aside__filter__item">
                Ужасы
              </a>
            </div>
            <hr className="aside__line" />
            <div className="aside__filter">
              <h3 className="aside__filter__title">Книга по автору</h3>
              <a href="#" className="aside__filter__item">
                Все авторы
              </a>
              <a href="#" className="aside__filter__item">
                Новые авторы
              </a>
              <a href="#" className="aside__filter__item">
                Классики
              </a>
              <a href="#" className="aside__filter__item">
                Популярные авторы
              </a>
              <a href="#" className="aside__filter__item">
                Ужасы
              </a>
            </div>
          </aside>
          <Book results={results} />
        </div>
      </section>
      <footer className="footer">
        <div className="footer__wrapper">
          <p className="copyright">
            &copy; 2021 Library <br /> All Rights Reserved.
          </p>
        </div>
      </footer>
    </>
  );
};

export default Books;
