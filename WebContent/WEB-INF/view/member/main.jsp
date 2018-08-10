<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<title>MEMBER MAIN</title>
<jsp:include page="../common/head.jsp" />
<body>
	<div id="wrapper">
		<div id="header">
			<h1>관리자용 페이지</h1>
			<c:choose>
				<c:when test="${pagename eq 'add'} ">
					<jsp:include page="add.jsp" />
				</c:when>
				<c:when test="${pagename eq 'login'} ">
					<jsp:include page="login.jsp" />
				</c:when>
				<c:when test="${pagename eq 'search'} ">
					<jsp:include page="search.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="retrieve.jsp" />
				</c:otherwise>
			</c:choose>


			<jsp:include page="../common/loginbox.jsp" />
		</div>
		<!-- header end -->
		<jsp:include page="../member/search.jsp" />
	</div>
	<div id="footer"></div>

	<script>
		member.main('${context}');
	</script>

</body>
</html>