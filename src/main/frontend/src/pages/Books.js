import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import AuthService from '../services/authservice';
import Book from './Book';
import axios from 'axios';

import authHeader from '../services/authHead';

const API_URL_BOOK = 'http://localhost:8080/api/v1/book/';

const Books = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [value, setValue] = useState('');
  const [currentUser, setCurrentUser] = useState(undefined);

  const getData = () => {
    axios.get(API_URL_BOOK + 'all', { headers: authHeader() }).then((response) => {
      setData(response.data);
      setLoading(false);
    });
  };

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    getData();
    if (user) {
      setCurrentUser(user);
      // setShowModeratorBoard(user.roles.includes("ROLE_MODERATOR"));
      // setShowAdminBoard(user.roles.includes("ROLE_ADMIN"));
    }
  }, []);

  const logOut = () => {
    AuthService.logout();
  };

  const sortByAge = () => {
    const sorted = [...data].sort((a, b) => {
      return b.age - a.age;
    });
    setData(sorted);
  }; // need fix

  const results = data.filter((person) => person.name.toLowerCase().includes(value.toLowerCase()));

  return (
    <>
      <button onClick={sortByAge}>sort</button>
      <nav class="navbar navbar-light bg-dark">
        <div class="container-fluid">
          <form class="d-flex">
            <input
              class="form-control me-2"
              type="search"
              placeholder="Search"
              aria-label="Search"
              onChange={(event) => setValue(event.target.value)}
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
                Жанры
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
          <Book results={results} loading={loading} error={error} />
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
