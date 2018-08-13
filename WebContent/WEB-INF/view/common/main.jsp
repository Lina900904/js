<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<title>COMMON MAIN</title>
<jsp:include page="head.jsp" />

<body>
<div id = "wrapper">

		<div id = "header">
	<jsp:include page ="titlebox.jsp"/>
	<jsp:include page ="loginbox.jsp"/>			
		</div> <!-- header end -->
	<jsp:include page ="menubox.jsp"/>
	<jsp:include page ="contentbox.jsp"/>

		
	</div>
	
	<div id = "footer"></div>


<script>
common.main('${context}');
</script>




</body>
</html>

