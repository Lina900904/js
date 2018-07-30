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
<jsp:include page="../common/head.jsp" /> <!-- 헤드에서 펑션을 만들었기 때문에 아래서 쓸수있음 -->
</head>

<body>

	<div id="user-Login-Layout">
		<h1>로그인</h1>

		<form id="user_login_form" name = "user_login_form">
			ID : <br>
			<input type="text" name="userid" /><br /> 
			PassWord: <br />
			<input type="text" name="password" /><br /> <br /> 
			<input id="loginFormBtn" type="button" value="전송" /> 
				<input type="hidden" name="action" value="login" /> 
		<!-- 		<input type="hidden" name="page"value="mypage" /> -->


		</form>
	</div>

	<script>
	
		document.getElementById('loginFormBtn').addEventListener('click',
				function() {	
			var form = document.getElementById('user_login_form');
			var x = service.nullChecker(
					[form.userid.value,form.password.value]);
					/* var userid = form.userid.value;		
					var password = form.password.value; */
			/* 		member.setId(form.userid.value);
					member.setPassword(form.password.value); */
					
					if(x.checker){		
					
						form.action = "${context}/member.do";
						form.method = "post";
						form.submit();
					}else{
						alert(x.text);
					}
				});
	</script>

</body>
</html>