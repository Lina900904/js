<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>

<div id ="content-box">
	<form id="mypage">	
	
	<h1> retrieve PAGE </h1>
	
		<table id="mypage-table">
			<tr>
				<td id="mypage-img" rowspan="7" colspan="2" >
				<img src="${img}/${profile}"/>
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

	 <a id="updateBtn">	<input type="button"  value="정보수정" /></a>

		<a id="deleteBtn">	<input type="button"  value="회원탈퇴" /></a>

	</form>
	</div>

