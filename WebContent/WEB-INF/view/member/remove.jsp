<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%= application.getContextPath()%>"></c:set>
  

<div id ="content-box"> 

<h1>회원 삭제</h1>

<form id = "deleteForm" >
<!-- 아이디: <input type="text" name = "id" /> -->
비밀번호재입력:<input type="text" name = "pass" id = "pass" />
<!-- <input type="hidden" name = "action" value = "delete"/>
<input type="hidden" name = "page" value = "delete" /> -->
<input id = "deleteFormBtn" type="button" value= "전송" />
</form>

<script>


document.getElementById('deleteFormBtn').addEventListener('click',
		function() {
	var form = document.getElementById('deleteForm');
	var pass = form.pass.value;
			if(pass ==='' ){
				alert('비밀번호를 입력하세요');
	/* 			펑션 안에 들어와 있으면 동적인 코딩
				실행이 끝나면 메모리는 사라짐 (자바의 메소드와 동일함)
				펑션 밖에 있거나, ""으로 String값을 주면 정적인 코딩 */
			}else if(pass !=='${user.password}'){
				alert('비밀번호가 다릅니다');
			}else if(pass==='${user.password}'){
				form.action="${context}/member.do";
				form.method = "post";
				// var userid = form.userid.value;
				
				var node = document.createElement('input'); //input태그를 만들거야 createElement은 set과 같은 개념
				node.innerHTML = '<input type="hidden" name="action" value="delete" />'; 
				//hidden은 보여주는것아니아니라 넘기는 것이기 때문에 위에는 보여주는 값만 만들기 위해 따로 뺌
				form.appendChild(node); //폼태그 자식으로 넣어줘야 실행이 되기 때문에 
				form.submit();
			
				
			};
				
			
			alert('입력한 id password  : ' + userid+pass);
});
</script>	
	</div>
	
