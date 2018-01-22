/**
 * 作用 :
 * 		根据传进来的data初始化页面
 * 	param :
 * 		data
 */
 function initialPage(data){
 	
// 	console.log(JSON.stringify(data));
// 	console.log(data);
 	
 	//为商品展示图片添加URL
 	for(var i = 0; i < 5; i++){
 		
 		var show_image = document.getElementById('show_image_' + ( parseInt(i) + parseInt(1) )); 		
 		show_image.setAttribute("src", data.infodata.good_url[i].url);
 		
 	}
 	
 	//为商品添加商品介绍
 	var good_name_span = document.getElementById("good_name_span");
 	good_name_span.innerText = data.infodata.good_name;
 	var good_price_a = document.getElementById("good_price_a");
 	good_price_a.innerText = "¥" + data.infodata.good_price;
 	var good_primeprice_span = document.getElementById("good_primeprice_span");
 	good_primeprice_span.innerText = "原价 : ¥" +data.infodata.good_primeprice ;
 	var good_freight_span = document.getElementById("good_freight_span");
 	good_freight_span.innerText = "快递 : " + data.infodata.good_freight;
 	var good_sales_span = document.getElementById("good_sales_span");
 	good_sales_span.innerText = "月销" + data.infodata.good_sales + "笔";
 	var good_from_span = document.getElementById("good_from_span");
 	good_from_span.innerText = data.infodata.good_from;
 	
 	//为商品添加评论
// 	console.log("商品评论element");
 	for(var i = 0; i < 3; i++){
 		
 		var good_evaluate = document.getElementById("good_evaluate_" + ( parseInt(i) + parseInt(1)))
// 		console.log(good_evaluate.children);
//	 	console.log(good_evaluate.children[0].children);
//	 	console.log(good_evaluate.children[1].children);
//	 	console.log(good_evaluate.children[2].children);
	 	
	 	var ev = data.infodata.good_evaluate[i];
	 	
	 	//设置评论昵称及购买的类型
	 	var mui_media_body = good_evaluate.children[0].children[1];
//	 	console.log(mui_media_body.children[0].innerText);
	 	var gc = ev.good_choose;	 	
	 	var choose_content = " ";
//	 	console.log("评论类型" + gc[0].choose_name);
	 	for(var i_g = 0 ; i_g < gc.length; i_g++){
//	 		console.log("choos_content : " + choose_content);
	 		choose_content = choose_content + gc[i_g].choose_name + " : " + gc[i_g].choose_value + " ";
	 	}
	 	mui_media_body.innerHTML = ev.username + '<p>' +  ev.evaluate_date + choose_content + '</p>';
	 	
	 	//设置评论内容
	 	var mui_card_content = good_evaluate.children[1];
	 	mui_card_content.innerText = ev.evaluate_content;
 		
 	}
 	
 	//为商品类型选择添加内容
 	var choose_popover = document.getElementById("popover");
// 	console.log("商品类型选择element");
// 	console.log(choose_popover.children);
 	
 	//添加照片以及商品价格
 	var ul_a = choose_popover.children[0].children[0].children[0]
// 	console.log("ul_a : ");
// 	console.log(ul_a.children);
 	var ul_a_img = ul_a.children[0];
 	ul_a_img.setAttribute("src", data.infodata.good_url[0].url);
 	var ul_a_span = ul_a.children[1];
 	ul_a_span.innerText = "¥" + data.infodata.good_price + " 请选择";
 	
 	//为商品添加类型选择
 	var good_choose = data.infodata.good_choose;
// 	console.log("good_choose : ");
// 	console.log(JSON.stringify(good_choose));
 	for(var i = 0; i < good_choose.length; i ++){
 	
 		//取得类型名,以及值的数组
 		var choose_name = good_choose[i].choose_name;
 		var choose_kind = good_choose[i].choose_kind;
 		
 		//创建标签
 		var choose_element = document.createElement("div");
 		choose_element.setAttribute("class", "mui-row");
 		
 		var choose_name_element = document.createElement("div");
 		choose_name_element.setAttribute("class", "mui-row");
 		choose_name_element.style.marginLeft = "6%";
 		choose_name_element.style.marginTop = "3%";
 		choose_name_element.innerText = choose_name;
 		
 		var choose_kind_element = document.createElement("div");
 		choose_kind_element.setAttribute("class", "mui-row");
 		for(var i_k = 0; i_k < choose_kind.length; i_k++){
 		
 			//添加每一个choose_kind_element
 			var choose_kind_span = document.createElement("span");
 			choose_kind_span.setAttribute("class", "choose_item");
 			choose_kind_span.style.marginLeft = "1%";
 			choose_kind_span.innerText = choose_kind[i_k].value + "  ";
 			choose_kind_element.appendChild(choose_kind_span);
 		
 		}
 		
 		choose_element.appendChild(choose_name_element);
 		choose_element.appendChild(choose_kind_element);
 		
 		//先popover添加choose_element
 		var choose_num = choose_popover.children[1];
// 		console.log("choose_num : ");
// 		console.log(choose_num);
 		choose_popover.insertBefore(choose_element, choose_num);
 		
 	}
 	
 }
 
 
 /*
  * 作用 : 绑定类型选择监听
  * */
 function chooseSelect(){
 	
 	//类型选择被点击
 	mui('.mui-popover').on('tap', '.choose_item', function(event){
					
//			alert("另一种方式点击");
// 		console.log("点击类型选择事件 : ");
// 		console.log(event);
// 		console.log(event.detail.target);
 		//获取点击元素
 		var tap_element = event.detail.target;
 		
 		var tap_parent = tap_element.parentNode;
// 		console.log("点击的父元素");
// 		console.log(tap_parent.childNodes);
 		//获取到点击元素的父元素, 将其所有子元素设置为黑色(避免同时重复选择)
 		var childNodes = tap_parent.childNodes; 
 		for(var i = 0; i < childNodes.length; i++){ 			
 			//将节点的颜色设置为黑色
 			childNodes[i].style.color = "black"; 			
 		}
 		//选中的设置为蓝色
 		tap_element.style.color = "blue";
 
 		//在选择栏显示选择的类型
 		var choose_kind = document.getElementById("choose_kind");
 		var choose_kind_li = choose_kind.children[0].children[0];
 		var choose_kind_a = choose_kind_li.children[0];
 		
 		//获取选择类型名字
// 		console.log("tap_parent的兄弟元素是");
// 		console.log(tap_parent.previousSibling);
 		var choose_name = tap_parent.previousSibling;
 		
 		//判断该类型是否已被选择
// 		console.log("a中的子元素有");
// 		console.log(choose_kind_a.children);
 		var choose_status = false;
 		for(var i = 0; i < choose_kind_a.children.length; i++){
// 					console.log("原来选择的类型");
// 					console.log(choose_kind_a.children[i].innerText);
// 					console.log("现在选择的类型");
// 					console.log(choose_name.innerText);
 				if(choose_kind_a.children[i].innerText.indexOf(choose_name.innerText) >= 0){
 					choose_status = true;
 					choose_kind_a.children[parseInt(i) + parseInt(1)].innerText = tap_element.innerText;//修改其值
 				}	
 		}
 		
 		//该类型还没被选择
 		if(!choose_status){
	 		//创建选择栏的element
	 		var choose_name_element = document.createElement("a");
	 		choose_name_element.setAttribute("class", "choose_kind_name");
	 		choose_name_element.innerText = choose_name.innerText + ":";
	 		var choose_kind_element = document.createElement("a");
	 		choose_value_element = document.createElement("a");
	 		choose_value_element.setAttribute("class", "choose_kind_value");
	 		choose_value_element.innerText = tap_element.innerText;
	 		choose_kind_a.appendChild(choose_name_element);
	 		choose_kind_a.appendChild(choose_value_element);
 		}
					
	});
 	
	//数量被选择 
	mui('.mui-popover').on('tap', '.mui-numbox', function(event){
		
		 //获取点击元素
//		console.log("event : ");
//		console.log(event.detail.target.parentNode);
 		var tap_element = event.detail.target.parentNode;
// 		console.log("choose_num_input");
// 		console.log(tap_element.children);
 		var choose_num = tap_element.children[1].value;
 		//获取选择栏显示选择的元素
 		var choose_kind = document.getElementById("choose_kind");
 		var choose_kind_li = choose_kind.children[0].children[0];
 		var choose_kind_a = choose_kind_li.children[0];
 		
 		//判断是否之前是否选择过数量
 		var choose_num_status = false;
 		for(var i = 0; i < choose_kind_a.children.length; i++){
 			if(choose_kind_a.children[i].innerText.indexOf("数量") >= 0){
 				choose_num_status = true;
 				choose_kind_a.children[parseInt(i) + parseInt(1)].innerText = choose_num;
 			}
 		}
 		
 		//创建用于显示数量的元素
 		if(!choose_num_status){
 			var choose_num_name = document.createElement("a");
 			choose_num_name.setAttribute("class", "good_num_name");
 			choose_num_name.innerText = "数量:";
 			var choose_num_value = document.createElement("a");
 			choose_num_value.setAttribute("class", "good_num_value");
 			choose_num_value.innerText = choose_num;
 			choose_kind_a.appendChild(choose_num_name);
 			choose_kind_a.appendChild(choose_num_value);
 		}
		
	})
	
	//点击立即购买购买
	mui('#bottom_navigation').on('tap', '#buy_rightrow', function(){
	
//		alert("进来立即购买了");
		
		//获取选择商品的类型数量
		var choose_kind = document.getElementById("choose_kind");
//		console.log("choose_kind children : ");
//		console.log(choose_kind.children);
		var choose_kind_a = choose_kind.children[0].children[0].children[0];
//		console.log(choose_kind_a);
		if(choose_kind_a.children.length == 0){//暂未进行类型选择
			mui.toast('请选择类型选择', {duration : 'short', type : 'div'})
		}else{
			var choose_string = "";//用于记录类型选择字串
			if(choose_kind_a.children.length == (parseInt(sessionStorage.getItem("good_choose_num") * 2) + parseInt(2) )){			
				for(var i = 0; i < choose_kind_a.children.length; i = i + 2){//遍历选择
					if(choose_kind_a.children[i].innerText.indexOf("数量") >= 0){//遍历到数量选择
						sessionStorage.setItem("good_num", choose_kind_a.children[parseInt(i) + parseInt(1)].innerText);
					}else{//遍历到类型选择
						choose_string = choose_string + ";" + choose_kind_a.children[i].innerText + choose_kind_a.children[parseInt(i) + 1].innerText;
						sessionStorage.setItem("good_choose", choose_string);
					}
				}
				window.location.href = "ConfirmOrder.html";
			}else{//类型选择不全或为选 数量
				var choose_num_status = false;
				for(var i = 0; i < choose_kind_a.children.length; i = i + 2){//遍历是否选择了数量
					if(choose_kind_a.children[i].innerText.indexOf("数量") >= 0){
						choose_num_status = true;
					}
				}
				if(choose_num_status){
					mui.toast('请选择类型选择', {duration : 'short', type : 'div'})
				}else{
					mui.toast('请选择数量', {duration : 'short', type : 'div'})
				}
			}
		}
		
	})
	
 }
 
 
 /*
  * 作用 : 上拉评论区加载商品评论
  * 
  */
 function RefreshEvaluate(){
// 	console.log("进来刷新商品评论了");
 	
 	//获取商品评论加载的lastid
 	var lastid = sessionStorage.getItem("good_evaluate_lastid");
 	var loadnum = 3;
 	var good_id = sessionStorage.getItem("good_id");
 	var evaluateload = "{'goodid' : " + good_id + ", 'loadnum' : " + loadnum + ", 'lastid' : " + lastid + "}";
 	evaluateload = "{'goodid' : " + good_id + ", 'loadnum' : 3, 'lastid' : 0}";
 	//获取评论数据
 	$.post("loadevaluate.spring",{
 		'evaluateload' : evaluateload
 	},function(data, status){
 		console.log(JSON.stringify(data));
 		CreateEvaluate(data);
 		//设置多长时间后刷新圆圈消失
 		window.setTimeout('endRefreshCirle()', 4000);
 	});
 	
 	
 }
 
 /*
  * 作用 : 根据获取的评论数据为评论区添加评论标签
  * 	param : data
  * */
 function CreateEvaluate(data){
 	//获取评论区容器
 	var evaluate_container = document.getElementById("good_evaluate_container");
 	//创建评论的卡片
 	for(var i = 0; i < data.good_evaluate.length; i++){
 		var gv = data.good_evaluate[i];
 		
 		 var m_c = document.createElement("div");
 		 m_c.setAttribute("id", "good_evaluate_" + gv.evaluate_id);
 		 m_c.setAttribute("class", "mui-card");
 		 
 		 var m_c_h = document.createElement("div");
 		 m_c_h.setAttribute("class", "mui-card-header mu-card-media");
 		 
 		 var img = document.createElement("img");
 		 img.setAttribute("src", "user_image/userlogo_default.png");
 		 
 		 var m_m_b = document.createElement("div");
 		 m_m_b.setAttribute("class", "mui-media-body");
 		 var choose_string = "";
 		 for(var ci = 0; ci < gv.good_choose.length; ci++){
 		 	choose_string = choose_string + gv.good_choose[ci].choose_name + " : " +
 		 	gv.good_choose[ci].choose_value + " ";
 		 }
 		 m_m_b.innerHTML = gv.username + '<p> ' + gv.evaluate_date + choose_string + '</p>'
 		 
 		 var m_c_c = document.createElement("div");
 		 m_c_c.setAttribute("class", "mui-card-content");
 		 m_c_c.innerText = gv.evaluate_content;
 		 
 		 var m_c_f = document.createElement("div");
 		 m_c_f.setAttribute("class", "mui-card-footer");
 		 var s_mb = document.createElement("span");
 		 s_mb.setAttribute("class", "mui-badge");
 		 s_mb.style.marginLeft = "72%";
 		 s_mb.innerText = "评论"; 		 
 		 var sm_b = document.createElement("span");
 		 sm_b.setAttribute("class", "mui-badge");
 		 sm_b.innerText = "点赞";
 		 
 		 m_c_h.appendChild(img);
 		 m_c_h.appendChild(m_m_b);
 		 
 		 m_c_f.appendChild(s_mb);
 		 m_c_f.appendChild(sm_b);
 		 
 		 m_c.appendChild(m_c_h);
 		 m_c.appendChild(m_c_c);
 		 m_c.appendChild(m_c_f);
 		 
 		 evaluate_container.appendChild(m_c);
 		 
 		 if(i == (data.good_evaluate.length - 1)){
 		 	sessionStorage.setItem("good_evaluate_lastid", gv.evaluate_id);
 		 }
 		 
 	}
 	
 }
 
 function endRefreshCirle(){
 	mui('#good_details').pullRefresh().endPullupToRefresh(false);
 }