/**
 * 
 */

function Common() {
	this.move= function (t,x,y,z) {
		location.href = t+'/'+x+'.do?action='+y+'&page='+z;
	}
};
	
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
