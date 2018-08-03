<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%=application.getContextPath()%>" />

<div id="contentbox">
<div id = "seachBox">
<input type="button" id = 'searchBtn' value = '검색'/>
<input type="text" id  = 'searchWord' name='searchWord' placeholder="검색어 입력" />

<select name="searchOption" id="searchOption">
<option value="none">검색조건</option>
<option value="userid">아이디</option>
<option value="name">이름</option>
<option value="team_id">팀명</option>
</select>

</div>

	<table id="content-boxTab">
		<tr id="contentBoxMeta">
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
			<th>역할</th>
			<th>팀 명</th>
		</tr>
		<c:forEach items="${list}" var="member"> 

			<tr>
				<td>${member.id}</td>
				<td><a class = "username" id="${member.id}" >${member.name}</a></td> 
				<td>${member.age}</td>
				<td>${member.gender}</td>
				<td>${member.roll}</td>
				<td>${member.teamId}</td>
				<%-- <td><a style="cursor:pointer;" 
			href = "${context}/admin.do?action=retrieve&page=memberDetail&id=${member.id}" >${member.name}</a></td>  --%>
			</tr>
		</c:forEach>
		<tr>
		<td colspan = "6">
		전체회원수: 	${list.size()}<br /><br />
		<c:forEach begin="1" end="${list.size()%5==0?list.size()/5 :list.size()/5+1}" step="1" var="i">
			<span>${i}</span>
		</c:forEach>
		</td>
		</tr>
	</table>

</div>
	
		<script>
	admin.main('${context}');
	</script>
	
	
	
	
