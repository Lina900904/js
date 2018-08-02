<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="menu-box">
	<ul id="menu">
		<li><a href="${context}/common.do">HOME</a></li>
		<li><a href="">ABOUT</a></li>
		<li><a id="moveToAdminMain" >ADMIN</a></li>
<%-- 		<li><a href="${context}/admin.do?action=move&page=main">ADMIN</a></li> --%>

	</ul>
</div>

<script>
document.getElementById('moveToAdminMain')
//document.querySelector('#moveToAdminMain') < getElementById가 더빠름
.addEventListener('click',function(){  //콜백함수(연이어서 호출되는 함수)
	admin.check('${context}');
	
});
</script>
