import React from 'react';
import {Button} from "@mui/material";
import {styled} from '@mui/styles';
import Logo from '../../images/logo.png'
import './styles.css'

const MyButton = styled(Button)({
	width: "30%",
	background: "#C4C4C4",
	boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25)",
	borderRadius: "20px",
});
const Register = () => {
	return (
		<div className="container">
			<div className="register">
				<img className="img" src={Logo} alt=""/>
				<MyButton sx={{my: 1}}>Вход</MyButton>
				<MyButton sx={{my: 1}}>Регистрация</MyButton>
				<MyButton sx={{my: 1}}>Регистрация с помощью Google</MyButton>
				<MyButton sx={{my: 1}}>Библиотека</MyButton>
				<span>Уже зарегистрированы? <span className='enter'>Войдите</span></span>
			</div>
		</div>
	);
};
export default Register;
