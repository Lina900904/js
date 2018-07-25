<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=application.getContextPath()%>" /> --%>
<head>
<meta charset="UTF-8" />
<title>HELLO</title>

<link rel="stylesheet" href="${context}/resources/css/style.css" />
<body>

<script>

/* 	this.3name, ssn, roll, id, password, teamId */

/* var loginValiation = function loginValiation() {
	return ;
} */

/* function Common() {
	this.move=function (domain, action, page) {			
		location.href = "${context}/" + domain + ".do?action=" + action
				+ "&page=" + page;
	}
}
function Member(){
this.loginValiation= function(){
	return "test";
}

 */
 
var common = new (function () {
	this.move= function (x,y,z) {
		location.href = '${context}/'+x+'.do?action='+y+'&page='+z;
	}
});
	
	var member= new function () {
		var id,ssn,password; // 중복된 정보인지 체크함
		
		this.setId= function(x){
			this.id=x;
		}
		this.setSsn= function(x){
			this.ssn=x;
		}
		this.setPassword= function(x){
			this.password=x;
		}
		this.getId= function(){
			return this.id;
		}
		this.getSsn= function(){
			return this.ssn;
		}
		this.getPassword= function(){
			return this.password;
		}
		this.loginValidation= function(){	
			if(this.id ===''){ 
				alert('아이디입력필요');
				return false;
			}else if(this.password ===''){
				alert('비밀번호입력필요');
				return false;
			}else{
				return true;
			}
		}
		this.joinValidation = function () {
			if(this.id ===''){ 
				alert('아이디입력필요');
				return false;
			}else if(this.password ===''){
				alert('비밀번호입력필요');
				return false;
			}else if(this.ssn ===''){
				alert('ssn 입력필요');
				return false;
			}else{
				return true;
			}
		}
	
	};

	

</script>


</body>
</html>