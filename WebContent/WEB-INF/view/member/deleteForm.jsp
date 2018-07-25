<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%= application.getContextPath()%>"></c:set>
  
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>DELETE_FORM</title>
<jsp:include page="../common/head.jsp" />
</head>

<body>


<h1>회원 삭제</h1>

<form id = "deleteForm" >
아이디: <input type="text" name = "id" />
비밀번호:<input type="text" name = "pass" />
<input type="hidden" name = "action" value = "delete"/>
<input type="hidden" name = "page" value = "delete" />
<input id = "deleteFormBtn" type="submit" value= "전송" />
</form>

<script>
member.setId;
member.setPassword;
alert(member.loginValiation());
document.getElementById('deleteFormBtn').addEventListener('click',
		function() {
			alert('회원삭제 태그 내부');
			var form = document.getElementById('deleteForm');
			form.action="${context}/member.do";
			form.method = "post";
			var userid = form.userid.value;
			var pass = form.pass.value;
			
			if(userid == ""){
				alert('아이디입력필요');
				return false;
			}
			var password = form.password.value;
			if(password == ""){
				alert('비밀번호입력필요');
				return false;
			}
				
			return (true);
			
			alert('입력한 id password  : ' + userid+pass);
});
</script>	
	
	
	
</body>
</html>