<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%=application.getContextPath()%>" />



<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Document</title>
<link rel="stylesheet" href="${css}/style.css" />
<jsp:include page="../common/head.jsp" />
</head>

<body>

	<form id="mypage">	
	
	<h1> MY PAGE </h1>
	
		<table id="mypage-table">
			
				
			<tr>
	
				<td id="mypage-img" rowspan="7" colspan="2" >
				<img src="resources/img/home/turtle.PNG" />
				<td>아이디</td>
				<td>${member.id}</td>
				
			</tr>
			<tr>
				
				<td>이름</td>
				<td>${member.name}</td>
			</tr>
			
			<tr>
				
				<td>비밀번호</td>
				<td>${member.password}</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>${member.age}</td>
			</tr>
			
			<tr>
				<td>성별</td>
				<td>${member.gender}</td>
			</tr>
			
			<tr>
				<td>역할</td>
				<td>${member.roll}</td>
				
			</tr>
			
			<tr>
				<td>팀아이디</td>
				<td>${member.teamId}</td>
			</tr>

		</table>
	<a id="updateBtn">
		<input type="button"  value="정보수정" /></a>
		<a id="deleteBtn">	
		<input type="button"  value="회원탈퇴" /></a>

		<script>
			document.getElementById('updateBtn').addEventListener(
					'click', function() {
						alert('수정확인버튼 클릭함');
						router.move({context : '${context}',
							domain : 'member',
							action : 'move',
							page : 'updateForm'}); 
						submit();
					
					});
			document.getElementById('deleteBtn').addEventListener(
					'click', function() {
						alert('수정확인버튼 클릭함');
						router.move({context : '${context}',
							domain : 'member',
							action : 'move',
							page : 'deleteForm'}); 
						submit();
					
					});
		</script> 

		



	</form>
</body>
</html>







<%--      <h1>아이디 : ${user.id}</h1>
    <h1>비밀번호 : ******</h1>
    <h1>이름 : ${user.name} </h1>
    <h1>나이 : ${user.age} </h1>
    <h1>성별 : ${user.gender}</h1>
    <h1>주민번호 : ${user.ssn} </h1>
    <h1>직책 : ${user.roll} </h1>
    <h1>팀 아이디: ${user.teamId} </h1>
    <h1>수강과목 : ${user.subject} </h1> --%>




<%-- <!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>MYPAGE</title>
	
</head>
<body>

	<%
	MemberBean user = (MemberBean)request.getAttribute("user");
	%>
	<h1> <%=user.getName() %>마이페이지 진입</h1>
</body>
</html> --%>