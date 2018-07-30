/**
 * 
 */
"use strict;" //에러가 나면 바로 보여줌
var router = (()=> { // 싱글쓰레드모드
	return {
		move : x => { //파라미터는 오직하나, 어려개일 경우 배열
		location.href = 
			x.context +'/'
			+ x.domain
			+ '.do?action='+x.action
			+ '&page='+x.page
	//	location.href = t+'/'+x+'.do?action='+y+'&page='+z;
	}};

})();

/*var service= (()=>{
	return {
		nullChecker: x=>{
			for(var i =0;i<x.length; i++){					
				if(x[i] ===''){ 
					
					alert(i+'입력필요');
					return false;					
				}}	return true;	
			}
	}})();
*/
/*var service= (()=>{
	return {
		nullChecker: x=>{
			var i =0;
			for(i in x){	//for each loop					
				if(x[i] ===''){ 					
					alert(i+'입력필요');
					return false;					
				}}	return true;	
			}
	}})();
*/

var service= (()=>{
	return {
		nullChecker: x=>{
			var i =0;
			var j = {
					checker : true,
					text: '필수입력값이 없습니다'
			};
			for(i in x){									
				if(x[i] ===''){ 					
					j.checker= false;					
				}
			}
			return j;	
			}
	};
	})();





var member=(()=> { //클로져를 사용한 객체 (보안을 위해)
		var _id,_ssn,_password,_name, _roll,  _teamId, _age, _gender, _subject; // 중복된 정보인지 체크함
		var setId = (userid)=>{this._userid= userid;};
		var setSsn = (ssn)=>{this._ssn=ssn;};
		var setPassword = (password)=>{this._password=password;};
		var setName = (name)=>{this._name=name;};
		var setRoll = (roll)=>{this._roll=roll};	
		var setTeamId =  (teamid)=>{this._teamid=teamid;};	
		var setSubject = (subject)=>{this._subject=subject;};	
		var setGender = x=>{		
			if(x[2].substr(7, 1)==='1') {
				this._gender='남자';
			}else {
				this._gender='여자';
			}
			};	
			
		var setAge = x=>{
			var date = new Date().getFullYear()- 1899- (x[2].substr(0,2));
			this._age=date;
			};	
		
		var getId = ()=>{return this._id;};
		var getSsn=  ()=>{return this._ssn;};
		var getPassword=  ()=>{return this._password;};
		var getName=  ()=>{return this._name;};
		var getGender=  ()=>{return this._gender;};
		var getAge=  ()=>{return this._age;};
		var getRoll=  ()=>{return this._roll;};
		var getTeamId=  ()=>{return this._teamId;}
		var getSubject = ()=>{return this._subject;};
		
		return{ //오픈된 공간
			setId :setId,
			setSsn:setSsn,
			setPassword :setPassword,
			setName :setName,
			setRoll :setRoll,
			setTeamId :setTeamId,
			setGender :setGender,
			setAge :setAge,
			setSubject:setSubject,
			getId :getId, // getId(String값) :getId(위에서 선언된set값)
			getSsn : getSsn,
			getPassword :getPassword,
			getName :getName,
			getGender :getGender,
			getAge :getAge,
			getRoll :getRoll,
			getTeamId :getTeamId,
			getSubject:getSubject,
			join:x=>{
				member.setAge(x); //값은 없고 틀만 있음
				member.setGender(x);

				
			}
	
				
				
				};
		})();
		
		
		/*this.setId= function(x){
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
		}*/
		/*this.loginValidation= function(){	
			if(this.id ===''){ 
				alert('아이디입력필요');
				return false;
			}else if(this.password ===''){
				alert('비밀번호입력필요');
				return false;
			}else{
				return true;
			}
		}*/
/*		this.joinValidation = function () {
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
		}*/
