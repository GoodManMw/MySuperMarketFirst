/*
 * 作用 : 页面数据加载
 * 
 * */
 function loadData(){
 	
 	 	//获取,初始化收货信息
 	$.post("getreceiveinfo.spring", {
 		
 	},function(data, status){
// 		alert(JSON.stringify(data));
 		sessionStorage.setItem("receive_name", data.info.name);
 		sessionStorage.setItem("receive_phone", data.info.phone);
 		sessionStorage.setItem("receive_address", data.info.address);
 	});
 	
 	//获取支付账号信息
 	$.post("getpayaccount.spring", {
 	
 	}, function(data, status){
// 		console.log(JSON.stringify(data));
 		//记录支付账号
 		sessionStorage.setItem("pay_account", data.payaccount.pay_account);
 	});
 
 }


/**
 * 作用 :
 * 		初始化订单确认页面
 */
 function initialPage(){
 
// 	console.log("初始化订单确认页面了");

 	//初始化收货信息
	var receiveInfo_element = document.getElementById("receiveInfo");
// 		console.log("receiveInfo_element 的子元素是 : ");
// 		console.log(receiveInfo_element);
 		receiveInfo_element.children[0].children[0].children[0].innerText = sessionStorage.getItem("receive_name");
 		receiveInfo_element.children[0].children[1].innerText = sessionStorage.getItem("receive_phone");
 		receiveInfo_element.children[1].children[1].children[0].innerText = sessionStorage.getItem("receive_address");
 	
 	//初始化商品信息
 	var goodInfo_element = document.getElementById("goodInfo");
 	console.log("good_info");
 	console.log(goodInfo_element);
 	//初始化商店名称
 	goodInfo_element.children[0].children[1].innerText = sessionStorage.getItem("shop_name");
 	//初始化商品照片URL
 	goodInfo_element.children[1].children[0].children[0].children[1].setAttribute("src", sessionStorage.getItem("good_default_url"));
 	//初始化商品名称
 	goodInfo_element.children[1].children[0].children[0].children[2].children[0].innerText = sessionStorage.getItem("good_name");
 	//初始化类型选择
 	var choose_element = goodInfo_element.children[1].children[0].children[0].children[2].children[1];
 	var choose_array = sessionStorage.getItem("good_choose").split(";");
 	var choose_string = "";
 	for(var i = 0; i < choose_array.length; i++){
// 		console.log("类型选择" + i + ":");
// 		console.log(choose_array[i]);
 		choose_string = choose_string + choose_array[i] + " ";
 	}
 	choose_element.innerText = choose_string;
 	//初始化商品价格,数量
 	goodInfo_element.children[1].children[0].children[0].children[2].children[2].children[0].innerText = "¥" + sessionStorage.getItem("good_price");
 	goodInfo_element.children[1].children[0].children[0].children[2].children[2].children[1].innerText = "x" + sessionStorage.getItem("good_num");
 	
 	//初始化购买数量框
 	var buyNum_element = document.getElementById("buyNum");
// 	console.log("购买数量框");
// 	console.log(buyNum_element);
 	//填充购买数量
 	buyNum_element.children[1].value = sessionStorage.getItem("good_num");
 	//填充商品小计
 	var sumMoney = (sessionStorage.getItem("good_num") * sessionStorage.getItem("good_price")).toFixed(2);
 	sessionStorage.setItem("sum_price", sumMoney);
 	var buySubtotal_element = document.getElementById("buySubtotal");
 	buySubtotal_element.children[0].children[0].innerText = sessionStorage.getItem("good_num");
 	buySubtotal_element.children[0].children[1].innerText = sumMoney;
 	//填充合计
 	var buyTotal_element = document.getElementById("buyTotal");
 	buyTotal_element.children[0].innerText = sumMoney;
 	
 	//点击修改购买数量款
 	mui('.mui-table-view').on('tap', '#buyNum', function(){
// 		console.log("点击购买数量框了");
// 		console.log(buyNum_element.children[1].value);
 		//修改购买数量
 		sessionStorage.setItem("good_num", buyNum_element.children[1].value);
 		//修改商品信息商品数量
 		goodInfo_element.children[1].children[0].children[0].children[2].children[2].children[1].innerText = "x" + sessionStorage.getItem("good_num");
 		//修改购买金额
 		sumMoney = (sessionStorage.getItem("good_num") * sessionStorage.getItem("good_price")).toFixed(2);
 		sessionStorage.setItem("sum_price", sumMoney);
 		//修改购买小计
 		buySubtotal_element.children[0].children[0].innerText = sessionStorage.getItem("good_num");
 		buySubtotal_element.children[0].children[1].innerText = sumMoney;
 		//修改合计
 		buyTotal_element.children[0].innerText = sumMoney;
 	})
 	
 	//点击商家留言
 	mui('.mui-table-view').on('tap', '#goodComment', function(){
 		console.log("进来商家留言了");
 		var comment_element = document.getElementById("goodComment").children[1].children[0];
 		comment_element.focus(); 		
 		console.log("留言是 : ");
 		console.log(comment_element.value);
 	})
 	
 	//点击立即购买按键
 	mui('.mui-row').on('tap', '#openPopover', function(){
// 		console.log("点击立即购买了");
 		//获取支付框元素
 		var pay_element = document.getElementById("popover");
 		//修改支付账号
 		pay_element.children[0].children[1].children[1].innerText = sessionStorage.getItem("pay_account");
 		//修改支付金额
 		pay_element.children[0].children[2].children[1].children[0].innerText = sumMoney;
 		
 		//存储商家留言
 		var comment_element = document.getElementById("goodComment").children[1].children[0];
 		sessionStorage.setItem("good_comment", comment_element.value);
 		
 	})

 	//点击支付密码输入框
 	mui('#popover').on('tap', '#payPassword_numbox', function(){
 		console.log("进来支付密码输入框了");
 		var numBox = document.getElementById("payPassword_numbox");
 		var i = 0;
 		numBox.children[0].focus();//第一个密码输入框取得焦点
 		window.document.onkeydown = function(event){
	 				numBox.children[i].focus(); 		 				
	 			if(i == numBox.children.length - 1){//支付密码输入完毕提交订单
	//						console.log("提交订单了");	 						
							i = -1;
	 					}
	 					
	 			i++;
 			}
 	});

 	//点击确认按钮提交订单
 	mui('#popover').on('tap', '#postBtn', function(){
 	
//							console.log("提交订单了");
 							//获取密码输入框
 							var numBox = document.getElementById("payPassword_numbox");
 							
							var name = sessionStorage.getItem("receive_name");
	 						var phone = sessionStorage.getItem("receive_phone");
	 						var address = sessionStorage.getItem("receive_address");
	 						var shop_id = sessionStorage.getItem("shop_id");
	 						var good_id = sessionStorage.getItem("good_id");
	 						
	 						var good_choose = "[";
	 						var choose_string = sessionStorage.getItem("good_choose");//从sessionStorage获取choose字符串
	 						var choose_kind = choose_string.split(";");
	 						for(var ci = 1; ci < choose_kind.length; ci++){
	 							good_choose = good_choose + "{" + "'choose_name' : '" + choose_kind[ci].split(":")[0] + "',";
	 							if( ci == (choose_kind.length - 1)){//最后一个choose
	 								good_choose = good_choose + "'choose_value' : '" + choose_kind[ci].split(":")[1] + "'}";
	 							}else{
	 								good_choose = good_choose + "'choose_value' : '" + choose_kind[ci].split(":")[1] + "'},";
	 							}
	 						}
	 						good_choose = good_choose + "]";
	 						
	 						var good_num = sessionStorage.getItem("good_num");
	 						var sum_price = sessionStorage.getItem("sum_price");
	 						var good_comment = sessionStorage.getItem("good_comment");
	 						var pay_account = sessionStorage.getItem("pay_account");
	 						
	 						var pay_password = "";
//	 						console.log(numBox.children);
	 						for(var nbi = 0; nbi < numBox.children.length; nbi++){	 							
	 							pay_password = pay_password + numBox.children[nbi].value;
	 						}
//	 						console.log("获取到的密码为 : " + pay_password);
	 						
	 						var datapost = "{'name' : '" + name + "', 'phone' : " + phone + ", 'address' : '" + address + "', 'shop_id' : "
	 						+ shop_id +", 'good_id' : " + good_id + ", 'choose' : " + good_choose + ", 'good_num' : " 
	 						+ good_num + ", 'sum_price' : " + sum_price + ", 'good_comment' : '" + good_comment + 
	 						"', 'pay_account' : " + pay_account + ", 'pay_password' : '" + pay_password + "'}";
	 						
	 						$.post("postorder.spring",{
	 						
	 							'order' : datapost
	 							
	 						}, function(data, status){
//	 							console.log(JSON.stringify(data));
	 							if(data.info.status == 'success'){
	 								 mui.toast('购买成功',{ duration:'long', type:'div' });
	 								 window.location.href = "Nav_FirstPage.html";
	 							}else{
	 								if(data.info.pay_status == 'errorpaypassword'){
	 									mui.alert('支付密码错误', 'ERROR', '确认', null, 'div');
	 								}else if(data.info.pay_status == 'frozenpayaccount'){
	 									mui.alert('支付账户被冻结', 'ERROR', '确认', null, 'div');
	 								}else if(data.info.pay_status == 'noexistpayaccount'){
	 									mui.alert('支付账户不存在', 'ERROR', '确认', null, 'div');
	 								}else if(data.info.post_status == 'notsufficientfunds'){
	 									mui.alert('支付余额不足', 'ERROR', '确认', null, 'div');
	 								}else if(data.info.post_status == 'errorreceiveinfo'){
	 									mui.alert('收获信息错误', 'ERROR', '确认', null, 'div');
	 								}else if(data.info.post_status == 'payexception'){
	 									mui.alert('支付异常,稍后再试', 'ERROR', '确认', null, 'div');
	 								}else if(data.info.post_status == 'unknown'){
	 									mui.alert('未知异常,稍后再试', 'ERROR', '确认', null, 'div');
	 								}else{
	 									mui.alert('订单提交失败', 'ERROR', '确认', null, 'div');
	 								}
	 								
	 							
	 							}
	 						});
 		
 	})
 	
 }