<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>index</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
  
  <body>
   
  	<%--<form action="trade_data/trade_datalist"  method="post">
  	  	<input type="hidden" name="id" value="-1" />
  	
  	<table>
  		
  		<tr>
  			 
  			<th>关键词</th>
  			<td><input type="text"  name="id" /></td>
  		</tr>
  		<tr>
  			<td colspan="2"><input type="submit" value="添加"> </td>
  		</tr>
  		
  		
  	</table>
  	</form>
  	
  	--%><table>
  		<tr>
  			<th>id</th>
  			<th>账号</th>
			<th>手机</th>
			<th>时间</th>
			<th>内容</th>
			<th>地区</th>
			<th>供应商</th>
			<th>回复</th>
			<th>标签</th>
			<th>等级</th>
			<th>入库时间</th>
  		</tr>
  		</tr>
  		 
  		<c:forEach items="${trade_datalist}"  var="trade_datalist">
     	<tr>
  			<td>${trade_datalist.id}</td>
			<td>${trade_datalist.username}</td>
			<td>${trade_datalist.phone}</td>
			<td>${trade_datalist.time}</td>
			<td>${trade_datalist.content}</td>
			<td>${trade_datalist.address}</td>
			<td>${trade_datalist.supplier}</td>
			<td>${trade_datalist.reply}</td>
			<td>${trade_datalist.tag}</td>
			<td>${trade_datalist.grade}</td>
			<td>${trade_datalist.entry_time}</td>

  			<%--<td><a href="keyword/editkeyword?id=${keyword.id}">修改</a>&nbsp;&nbsp;&nbsp;<a href="keyword/delkeyword?id=${keyword.id}">删除</a> </td>
  		
  		--%></tr>
     </c:forEach>
  	</table>
  	
  	
  	<%--<table>
  		<tr>
  			<th><a id="d1" href="">关键词查询</a></th>
  			<td><input type="text"  name="keys1" id="keys1" onblur="find1(this)"/></td>
  		</tr>
  		<tr>
  			<td colspan="2"><input type="button" onclick="find()" value="查询关键词" title="" /></a> </td>
  		</tr>
  	</table>
    
  --%></body>
  
  <script type="text/javascript">
  
  function find1(whichpic){
	    var rr = $('#keys1').val();
	    var placerholder = document.getElementById("d1");
	    placerholder.setAttribute("src","keyword/ajaxlist?keys="+rr);
	  
	 // $('#d1').setAttribute('href',src);
	  
  }
  
  	function find(){
  		// var input = document.getElementById("keys1").value;   //获取用户在Info上
  		var r = $('#keys1').val();
  		//alert(r);
  		// return input;
  		$.ajax({
  		type:"get",
  		url:"keyword/ajaxlist",
  		data:{"keys":r},
  		dataType:"json",
  		success:function(data){
  			alert(data);
  		}
  		});
  		<%-- ajax({    
  			 type:"POST",    
  			 url:"keyword/keyslist",    
  			 dataType:"json",    
  			 //data:input,    
  			 beforeSend:function(){      
  				 //some js code    
  				 },    
  				 success:function(){      
  					 
  				 },    
  				 error:function(){      
  				        
  				 }  
  		 });  --%>

  	}
 </script>
</html>
