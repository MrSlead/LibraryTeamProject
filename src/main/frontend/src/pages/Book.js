import React from 'react';

const Book = ({ results }) => {
  return (
    <article className="section__article">
      <h3 className="section__article__title">Рекомендовано</h3>
      {results.map((item) => (
        <div className="card" key={item}>
          <img src="img/java.jpg" alt="card image" className="card__image" />
          <div className="card__info">
            <h4 className="card__info__title">{item}</h4>
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
                  Lorem ipsum dolor sit amet consectetur adipisicing elit. Error voluptatibus illum
                  neque quaerat inventore eum sed tempora delectus consequatur?
                </p>
              </div>
            </div>
          </div>
        </div>
      ))}
    </article>
  );
};

export default Book;
