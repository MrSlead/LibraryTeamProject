import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import AuthService from '../services/authservice';

const Books = () => {
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
    <>
      <nav class="navbar navbar-light bg-dark">
        <div class="container-fluid">
          <form class="d-flex">
            <input
              class="form-control me-2"
              type="search"
              placeholder="Search"
              aria-label="Search"
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
          <article className="section__article">
            <h3 className="section__article__title">Рекомендовано</h3>
            <div className="card">
              <img src="img/java.jpg" alt="card image" className="card__image" />
              <div className="card__info">
                <h4 className="card__info__title">Java For Absolute Beginners</h4>
                <div className="card__info__main">
                  <div className="card__info__left">
                    <p className="card__info__item">Автор: Maxim Dorofeev</p>
                    <p className="card__info__item">Жанр: Porno</p>
                    <p className="card__info__item">Язык книги: Русский | страниц 0</p>
                    <p className="card__info__item">Книга закончена || Книга не закончена</p>
                    <div className="read-button">
                      <a href="#" className="card__info__read">
                        Читать
                      </a>
                    </div>
                  </div>
                  <div className="card__info__right">
                    <p className="card__info__item">Формат:</p>
                    <div className="card__info__radios">
                      <input type="radio" name="format" value="epub" />
                      <span className="radio-text">epub</span>
                      <input type="radio" name="format" value="fb2" />
                      <span className="radio-text">fb2</span>
                    </div>
                    <p className="card__info__item">
                      Lorem ipsum dolor sit amet consectetur adipisicing elit. Error voluptatibus
                      illum neque quaerat inventore eum sed tempora delectus consequatur?
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </article>
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
