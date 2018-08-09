<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%= application.getContextPath()%>"></c:set>
 

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

