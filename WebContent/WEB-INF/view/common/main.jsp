<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath()%>" />
 --%>
<!doctype html>
<html lang="en">
<title>ADMIN</title>
<jsp:include page="head.jsp" />
<script>

</script>
	<script> /* 전역메소드, body안에 두어야함 */


	</script>
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
common.main('${context}')
</script>




</body>
</html>

