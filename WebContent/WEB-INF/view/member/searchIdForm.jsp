<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%= application.getContextPath()%>"></c:set>
 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>SEARCH_ID_FROM</title>
<jsp:include page="../common/head.jsp" />
</head>

<body>
<h1>아이디 검색</h1>

<form id="searchIdForm">
아이디 <input type="text" name = "id" />
<input id = "searchIdForm" type="submit"  value = "확인"/>
<input type="hidden" name = "action" value = "retrieve"/>
<input type="hidden" name = "page" value = "searchIdResult" />
</form>	
	
	
	<script>
		member.setId;

		alert(member.loginValidation());
		document.getElementById('searchIdForm').addEventListener('click',
				function() {
					alert('폼태그 내부');
					var form = document.getElementById('searchIdForm');
					form.action = "${context}/member.do";
					form.method = "post";
					var userid = form.id.value;
								
					alert('입력한 id  : ' + userid);
				if(id == ""){
					alert('아이디입력필요');
					return false;
				}
					
					
				return (true);
				});
	</script>
</body>
</html>