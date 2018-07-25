<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%=application.getContextPath()%>"></c:set>
<%-- 
<% 
String ctx = application.getContextPath();  //서블릿의 설정값을 가져옴
%> --%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>USERLOGIN</title>
<jsp:include page="../common/head.jsp" />
</head>

<body>

	<div id="user-Login-Layout">
		<h1>로그인</h1>

		<form id="user_login_form">
			ID : <br>
			<input type="text" name="userid" /><br /> 
			PassWord: <br />
			<input type="text" name="password" /><br /> <br /> 
			<input id="loginFormBtn" type="button" value="전송" /> 
				<input type="hidden" name="action" value="login" /> 
				<input type="hidden" name="page"value="mypage" />


		</form>
	</div>

	<script>

	
		document.getElementById('loginFormBtn').addEventListener('click',
				function() {
					alert('폼태그 내부');
					var form = document.getElementById('user_login_form');
					form.action = "${context}/member.do";
					form.method = "post";
					var userid = form.userid.value;		
					var password = form.password.value;
					member.setId(userid);
					member.setPassword(password);

					
					if(member.loginValidation()){
						form.submit();
					}
				});
	</script>

</body>
</html>