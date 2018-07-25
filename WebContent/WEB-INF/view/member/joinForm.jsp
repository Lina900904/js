<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- String memName, 생년월일 800101-1,  password, teamId ; -->
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%= application.getContextPath()%>"></c:set>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>JOIN</title>
<jsp:include page="../common/head.jsp" />
</head>
<body>

<div id = "join-Layout">
<h1> 회원가입</h1>

<form id="join-Form">
ID <input type="text" name = "userid"/><br />
NAME <input type="text" name = "name" /><br />
PASSWORD <input type="text" name = "password" /><br />
주민등록번호 <input type="text" name = "ssn" /><br />
<br />
<input type="hidden" name = "action" value = "join" />
<input type="hidden" name = "page" value = "joinResult" />
<input id = "joinFormBtn" type="button" value = "전송" />
</form>
</div>

<script>
document.getElementById('joinFormBtn')
.addEventListener('click', 
		function () {
	alert('조인폼태그내부');
	var form = document.getElementById('join-Form');
	form.action="${context}/member.do";
	form.method="post"
	var userid=form.userid.value;
	var password=form.password.value;
	var ssn=form.ssn.value;
	member.setId(userid);
	member.setPassword(password);
	member.setSsn(ssn);
	alert(userid);
	if(member.joinValidation()){
		form.submit();
	}
	
	
});


</script>






</body>
</html>