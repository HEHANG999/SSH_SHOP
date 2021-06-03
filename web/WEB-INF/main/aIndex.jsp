<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <%@ include file="/public/head.jspf" %>
  <style type="text/css">
		#menu {
			width:200px;
			/*border:1px solid red;*/
		}
		#menu ul {
			list-style: none;
			padding: 0px;
			margin: 0px;
		}
		#menu ul li {
			border-bottom: 1px solid #fff;
			
		}
		#menu ul li a {
			/*先将a标签转换为块级元素，才能设置宽和内间距*/
			display: block;
			background-color: #00a6ac;
			color: #fff;
			padding: 5px;
			text-decoration: none;
		}
		#menu ul li a:hover {
			background-color: #008792;
		}
  </style>
  
  <script type="text/javascript">
		$(function(){
			$("a[title]").click(function(){
				var text = $(this).text();
				var href = $(this).attr("title");
				//判断当前右边是否已有相应的tab
				if($("#tt").tabs("exists", text)) {
					$("#tt").tabs("select", text);
				} else {
					//如果没有则创建一个新的tab，否则切换到当前tag
					$("#tt").tabs("add",{
						title:text,
						closable:true,
						content:'<iframe title='+text+' src='+href+' frameborder="0" width="100%" height="100%" />'
						//href:默认通过url地址加载远程的页面，但是仅仅是body部分
						//href:'send_category_query.action'
					});
				}
				
			});
		});
  </script>

 </head>
 
 <body class="easyui-layout">
 
  <div data-options="region:'north',title:'飞灵后台管理',split:true" style="height:100px;"></div>  
   
  <!-- 左侧菜单 --> 
  <div data-options="region:'west',title:'系统操作',split:true" style="width:200px;">
	  <!-- 此处显示的是系统菜单 -->
	  <div id="menu" class="easyui-accordion" data-options="fit:true">   
	  
		   <div title="基础操作" data-options="iconCls:'icon-save'">   
			    <ul>
					<li><a href="#" title="send_category_query.action">类别管理</a>
					<li><a href="#" title="send_product_query.action">商品管理</a>
			    </ul>   
		   </div>
          <div title="销售管理">
              <ul>
                  <li><a href="#" title="send_sale_sale.action">销售管理</a>
              </ul>
          </div>
		  
	  </div>   
  </div>   
  
  <div data-options="region:'center',title:'后台操作页面'" style="padding:1px;background:#eee;">
     <div id="tt" class="easyui-tabs" data-options="fit:true">   
	    <div title="系统缺省页面" style="padding:10px;">
	       此处以后显示系统信息（当前操作系统类型，当前项目的域名，硬件相关配置或报表）
	    </div>
	 </div>
  </div>  
  
  <!-- 用于query.jsp中添加商品时锁屏 -->
  <div id="win" data-options="collapsible:false,minimizable:false,maximizable:false,modal:true"></div>  
  
   
 </body>  




</html>