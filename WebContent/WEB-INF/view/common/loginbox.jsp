<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath()%>" /> --%>

<div id = "login-box">
			<a id= "moveLoginForm" >LOGIN</a>&nbsp;&nbsp;&nbsp;
			<a id="moveJoinForm">JOIN</a>
		</div >
		
		
		
			
<script>
document.getElementById('moveLoginForm')
.addEventListener('click',function(){  //콜백함수(연이어서 호출되는 함수)
	router.move({context : '${context}',
		domain : 'member',
		action : 'move',
		page : 'user_login_form'}); //배열 json
	alert('클릭 이벤트 체크!');
	//new Common().move('${context}','member','move','user_login_form');	
	
		});
		
 document.getElementById('moveJoinForm')
.addEventListener('click',function(){  //콜백함수(연이어서 호출되는 함수)
	router.move({context :'${context}',
		domain:'member',
		action:'move',
		page:'joinForm'});
	
	alert('클릭 이벤트 체크!');
		});
 
 
 
 
</script>



