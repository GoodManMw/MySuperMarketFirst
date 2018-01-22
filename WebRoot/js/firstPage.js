/*
 * 作用 :
 * 		根据传进来的data创建商品卡片element
 *  param :
 *  	data
 * */ 
 function createGoodCard(data){
 
 	console.log(JSON.stringify(data));
 	console.log(data);
 	//console.log(data.data[0].good_name);
 	
 	var good_card_content = document.getElementById("good_card_content");
 	for(var i = 0; i < data.data.length; i++){
 	
 		var mui_card = document.createElement("div");
 		var mui_card_content = document.createElement("div");
 		var mui_card_footer = document.createElement("div");
 		
 		//mui_card属性
 		mui_card.setAttribute("class", "mui-card good_card");
 		
 		//mui_card_content属性
 		mui_card_content.setAttribute("class", "mui-card-content");
 		var img = document.createElement("img");
 		img.setAttribute("src", data.data[i].good_url);
 		mui_card_content.appendChild(img);
 		
 		//mui_card_footer属性
 		mui_card_footer.setAttribute("class", "mui-card-footer");
 		var a = document.createElement("a");
 		a.setAttribute("id", data.data[i].good_id);
 		mui_card_footer.appendChild(a);
 		var good_content = document.createElement("div")
 		good_content.style.width =  "52%";
 		good_content.innerText = data.data[i].good_name;
 		mui_card_footer.appendChild(good_content)
 		var good_price = document.createElement("div");
 		good_price.style.width = "10%";
 		var good_price_span = document.createElement("span");
 		good_price_span.style.marginLeft = "4%";
 		good_price_span.innerText = '¥' + data.data[i].good_price;
 		good_price.appendChild(good_price_span);
 		mui_card_footer.appendChild(good_price);
 		var good_sales = document.createElement("div");
 		good_sales.style.width = "30%";
 		var good_sales_span = document.createElement("span");
 		good_sales_span.style.marginLeft = "10%";
 		good_sales_span.innerText = data.data[i].good_sales + '付款';
 		good_sales.appendChild(good_sales_span);
 		mui_card_footer.appendChild(good_sales);
 		
 		mui_card.appendChild(mui_card_content);
 		mui_card.appendChild(mui_card_footer);
 		
 		console.log("获取到的good_card_content : " + good_card_content);
 		good_card_content.appendChild(mui_card);
 		
 	}
 	 	
 }

/*
  * 作用 : 
  * 	根据传进来的参数跳转到Good_Details.html页面
  * param : 
  * 		
  * */
 function goodDetail(good_card){
 	
 	console.log("进来goodDetails 了 ");
 	//从点击事件源获取商品id, 传递给Good_Detail.html页面 (这里必须是window.parent.location, 否则顶部的首页导航栏仍会保留)
 	window.parent.location = "Good_Details.html?id="+good_card.children[1].children[0].id;
 	//alert("执行到跳转了啊");
 	
 }
 
 /*
  * 作用 : 向服务器请求新的商品数据添加到容器中
  * 
  * */
 function Refresh(){
 	console.log("进来refresh函数中了");
 	
 	//页面数据请求
 	var lastid = sessionStorage.getItem("loadlastid");
// 	lastid = 0;
 	var datanum = 4;
 	var dataload = "{'datanum' : " + datanum + ", 'lastid' : " + lastid + "}";
 	var dataload = "{'datanum' : 4, 'lastid' : 0}";
			 $.post("loadgooddata.spring", {
			 	
			 	'dataload' : dataload
			 	
			 }, function(data, status){
			 				 	
			 	//调用createGoodCard创建商品浏览卡片
			 	createGoodCard(data);
			 	//停止圆圈加载提示
				window.setTimeout('endRefresh()',3000);
			 });

 	//记录lastid
 	sessionStorage.setItem("loadlastid", parseInt(lastid) + parseInt(datanum)); 	
 }
 
 function endRefresh(){
 	mui('#good_content').pullRefresh().endPullupToRefresh(false);
 }
 