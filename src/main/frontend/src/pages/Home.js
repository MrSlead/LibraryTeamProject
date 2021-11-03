import React, { useState, useEffect } from "react";
import UserService from "../services/userService";

const Home = () => {
  const [content, setContent] = useState("");
  const [loading, setLoading] = useState(true);
  const [userList, setUserList] = useState([]);

  useEffect(() => {
    UserService.getPublicContent().then(
      (response) => {
        console.log(response.data, "home");
        setContent(response.data);
        setLoading(false);
      },
      (error) => {
        const _content =
          (error.response && error.response.data) ||
          error.message ||
          error.toString();

        setContent(_content);
      }
    );
  }, []);

  if (loading) return <div>loading</div>;

  return (
    <div className="container">
      <header className="jumbotron">
        <h3>
          {content.map((item) => (
            <div>{item.login}</div>
          ))}
        </h3>
        <div>books</div>
      </header>
    </div>
  );
};

export default Home;
