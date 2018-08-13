<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%=application.getContextPath()%>"></c:set>



<div id ="content-box">
		<h1>로그인</h1>

		<form id="login" name = "login">
			ID : <br>
			<input type="text" name="userid" /><br /> 
			PassWord: <br />
			<input type="text" name="password" /><br /> <br /> 
			<input id="loginFormBtn" type="button" value="전송" /> 
				<!-- <input type="hidden" name="action" value="login" />  -->
		<!-- 		<input type="hidden" name="page"value="mypage" /> -->


		</form>
	</div>


