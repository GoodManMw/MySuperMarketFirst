/**
 * 作用 : 用于获取登录页面的账号密码用于登录
 * param :
 * 		username, password
 * return :
 * 		status
 */
function login(){
 		var login_button = document.getElementById("login_button");
 		var json = "{'username' : 1561234567, 'password':'12345678mw'}"
	 		$.post("login.spring",{
	 			'account' : json	 	
	 		},function(data,status){
	 			//console.log("提交完成了");
	 			console.log(JSON.stringify(data));
	 			var info = JSON.stringify(data);
	 			//console.log(data.info.status);
	 			if(data.info.status == 'success'){
	 				window.location = "Nav_FirstPage.html";
	 			}else{
	 				mui.alert("密码错误", "sorry","确认");
	 			}
	 		});	

}