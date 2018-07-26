/**
 * 
 */

var router = (()=> { // 싱글쓰레드모드
	return {move : x => { //파라미터는 오직하나, 어려개일 경우 배열
		location.href = 
			x[0]+'/'
			+ x[1]
			+ '.do?action='+x[2]
			+ '&page='+x[3]
	//	location.href = t+'/'+x+'.do?action='+y+'&page='+z;
	}};

})();

var service= (()=>{
	return {
		loginValidation: x=>{
			var ok= false;
			if(x.getId() ===''){ 
				alert('아이디입력필요');
				return false;
			}else if(x.getPassword() ===''){
				alert('비밀번호입력필요');
				return false;
			}else{
				return ok;
			}
	
		},
		joinValidation: x=>{
			var ok= false;
			if(x.getId() ===''){ 
				alert('아이디입력필요');
				return false;
			}else if(x.getPassword() ===''){
				alert('비밀번호입력필요');
				return false;
			}else if(x.getSsn() ===''){
				alert('ssn 입력필요');
				return false;
			}else{
				return ok;
			}
		

		}
	};
})();

function Member() {
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
	
	};
