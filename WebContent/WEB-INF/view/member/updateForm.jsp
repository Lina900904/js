<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<meta charset="UTF-8" />
	<title>UPDATE_FORM</title>
<jsp:include page="../common/head.jsp" />
<body>
<form id ="update-Form" name="update-Form">
		<table id="mypage-table">
			<tr>
				<td id="mypage-img" rowspan="8" colspan="2">
				<td>아이디</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td>새비밀번호</td>
				<td><input type="text" name = "newpass" placeholder="password" /></td>
			</tr>
			<tr>
				<td>나이</td>
				<td>${user.age}</td>
			</tr>
			
			<tr>
				<td>성별</td>
				<td>${user.gender}</td>
			</tr>
			
			<tr>
				<td>역할</td>
				<td>		
				
				<select name="roll" id="roll">
<option value="leader" selected="selected">팀장</option>
<option value="front" selected="selected">프론트개발</option>
<option value="back" selected="selected">백단개발</option>
<option value="android" selected="selected">안드로이드 개발</option>
<option value="minfe" selected="selected">민폐</option>
</select>
				</td>				
			</tr>
			
			<tr>
				<td>팀아이디</td>
				<td>

<input type="radio" name = "teamid" value="none" checked="checked"/>없음
<input type="radio" name = "teamid" value="nolja" checked="checked"/>걍놀자
<input type="radio" name = "teamid" value="jieunHouse" checked="checked"/>지은이네
<input type="radio" name = "teamid" value="turtleKing" checked="checked"/>왕거북이
<input type="radio" name = "teamid" value="coddingZzang" checked="checked"/>코딩짱
				</td>
			</tr>
		
			
		</table>

<input id = "updateFormBtn" type="button" value= "전송" /><br />
<input type="hidden" name = "action" value = "update"/><br />
<input type="hidden" name = "page" value = "mypage" />

</form>


<script>

	var form = document.getElementById('update-Form');

	var roll= document.getElementById("roll");
	for(var i =0; i<roll.options.length;i++){
		//alert('team.options[i].value+과 같다')
		if(roll.options[i].value==='${user.roll}'){
			//alert('team.options[i].value+과 같다')
			roll.option[i].setAttribute("selected","selected");
		}
	}
	
	document.getElementById('updateFormBtn')
	.addEventListener('click',function(){
	alert('수정완료버튼 클릭함');
	
	form.action = "${context}/member.do";
	form.method = "post";
	form.submit();

	});


</script>
	
	
</body>
</html>