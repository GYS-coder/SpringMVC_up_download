<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Starter Template Â· Bootstrap v4.6</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.6/examples/starter-template/">

    

    <!-- Bootstrap core CSS -->
<link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/assets/dist/js/jquery-3.6.0.min.js"></script>	


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="/assets/dist/css/starter-template.css" rel="stylesheet">
  </head>
  <body>
    
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <a class="navbar-brand" href="#">GYS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/jsp/mainpage.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/jsp/upload.jsp">上传</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/jsp/download.jsp">下载</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-expanded="false">用户</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="/jsp/signin.jsp">注销</a>
          <a class="dropdown-item" href="/jsp/signin.jsp">切换账号</a>
          <a class="dropdown-item" href="#">我的</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

<div role="main" class="container">

  <h1>下载页面</h1><h5>(按下载次数降序排列)</h5>
  
  <!-- 模态弹出窗内容 -->
<div class="modal" tabindex="-1" id="mymodal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">操作成功</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>冻结or锁定文件成功</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="location.reload()">关闭</button>
      </div>
    </div>
  </div>
</div>
  <!-- 模态弹出窗内容 4-->
<div class="modal" tabindex="-1" id="mymoda4">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">操作成功</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>删除文件成功</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="location.reload()">关闭</button>
      </div>
    </div>
  </div>
</div>
<!-- 模态弹出窗内容2 -->
<div class="modal" tabindex="-1" id="mymoda2">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">操作失败</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>你不是文件上传者，无权限执行此操作</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="location.reload()">关闭</button>
      </div>
    </div>
  </div>
</div>
<!-- 模态弹出窗内容3 -->
<div class="modal fade" id="mymoda3" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
        <form action="/NOfreeze"  method="post">
          <div class="form-group">
            <label for="message-text" class="col-form-label">fid:</label>
            <input class="form-control" name="fid" id="fid"></input>
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">comment:</label>
            <input class="form-control" name="acomment" id="message-text"></input>
          </div>
          <button type="submit" class="btn btn-primary">Send comment</button>
        </form>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">
	//冻结or解冻
	function freeze(obj){
		var nowuid = <%= session.getAttribute("uid")%>;
		var fmasterid = $(obj).parent().siblings().eq(3).text();
		//判断是否是文件主人
		if(nowuid==fmasterid){
			var fid = $(obj).parent().siblings().eq(0).text();
		    console.log(fid); 
		     $.ajax({ 
		          url:"/freeze?fid="+fid, 
		          type:"post" , 
		          dataType:"json",
		          success:function(data){ //整个接受叫data并不是后台的res叫data
		        	                
		               	            	  
		            	  var  fres= data.res; 
		                  
			              if(fres==1){
			            	  console.log("成功"); 
			            	  $("#mymodal").modal();
			              }else if(fres==0){
			            	  console.log("失败"); 
			              }else{
			            	  console.log("错误"); 
			              }

		              
		          }, 
		      error:function(XMLHttpRequest,textStatus, errorThrown) { 
		          // alert(errorThrown);
		         }
		      }); 
		}else{
			$("#mymoda2").modal();
		}
	}
	
	//评论解冻
	function NOfreeze(obj){
		    var fidd = $(obj).parent().siblings().eq(0).text();
		    var moda3 = $("#mymoda3");
		    
		    console.log(fidd);
		    console.log(moda3);
		    moda3.find('#fid').val(fidd);
			$("#mymoda3").modal();
			
		
	}
	//删除文件
	function mydelete(obj){
		var nowuid = <%= session.getAttribute("uid")%>;
		var fmasterid = $(obj).parent().siblings().eq(3).text();
		//判断是否是文件主人
		if(nowuid==fmasterid){
			var fid = $(obj).parent().siblings().eq(0).text();
			var fname=$(obj).parent().siblings().eq(2).text();
		    console.log(fid); 
		     $.ajax({ 
		          url:"/mydelete?fid="+fid+"&fname="+fname, 
		          type:"post" , 
		          dataType:"json",
		          success:function(data){ //整个接受叫data并不是后台的res叫data
		        	                
		               	            	  
		            	  var  fres= data.res; 
		                  
			              if(fres==1){
			            	  console.log("成功"); 
			            	  $("#mymoda4").modal();
			              }else if(fres==0){
			            	  console.log("失败"); 
			              }else{
			            	  console.log("错误"); 
			              }

		              
		          }, 
		      error:function(XMLHttpRequest,textStatus, errorThrown) { 
		          // alert(errorThrown);
		         }
		      }); 
		}else{
			$("#mymoda2").modal();
		}
	}
	//加载表格数据
	$(document).ready(function () {
		//加载nav用户信息
		var uuid=<%= session.getAttribute("uid")%>;
		$("#dropdown01").text("当前用户："+uuid);
		
	      //清空原有的数据
	      $("#tbody").empty();
	      //获取requestcontext，为缩略图显示时备用
	      var path = "${request.getContextPath()}";
	      $.ajax({ 
	          url:"/QuerryAllFile", 
	          type:"post" , 
	          dataType:"json",
	          success:function(data){ //整个接受叫data并不是后台的res叫data
	        	  var size=1;	
	        	  var tdArr = document.getElementById('tbody');
	              $.each(data.res, function (index, item) { 
	            	  var fid=data.res[index].fid;
	            	  var  fname= data.res[index].fname; 
	                  var fuid = data.res[index].fuid; 
	                  var fdowntimes = data.res[index].fdowntimes; 
	                  var fstate=data.res[index].fstate; 
   
	                  var tr = document.createElement("tr");
	                  var td = document.createElement("td");
	                  var tdd = document.createElement("td");
	                  var tddd = document.createElement("td");
	                  var tdddd = document.createElement("td");
	                  
		              if(fstate==1){
		            	  td.innerHTML="<td>"+"<a href='download?fname="+fname+"&fid="+fid+"&fuid="+fuid+"'>下载</a>"+"</td>";
		              }else if(fstate==0){
		            	  td.innerHTML ="<td>"+"不允许下载"+"</td>";
		              }else{
		            	  td.innerHTML ="<td>"+"错误"+"</td>";
		              }
		              
	                  tr.innerHTML ="<th scope='row'>"+fid+"</th>"+
		              
		              				"<td>"+"<img width='50' height='50' src='"+path+"/file/"+fuid+"/"+fname+"'/>"+"</td>"+
		              
		              				"<td>"+fname+"</td>"+
		              				"<td>"+fuid+"</td>"+
		              				"<td>"+fdowntimes+"</td>";
		              tr.appendChild(td);
		              				
		              tdd.innerHTML="<td>"+"<button class='btn btn-outline-primary' onclick='freeze(this)'>冻结or解冻</button>"+"</td>";
		              tr.appendChild(tdd);
		              
		              tddd.innerHTML="<td>"+"<button class='btn btn-outline-primary' onclick='NOfreeze(this)'>点击评论</button>"+"</td>";
		              tr.appendChild(tddd);
		              
		              tdddd.innerHTML="<td>"+"<button class='btn btn-outline-primary' onclick='mydelete(this)'>删除</button>"+"</td>";
		              tr.appendChild(tdddd);
		              
		             tdArr.appendChild(tr);
		             size++;
	              }); 
	          }, 
	      error:function(XMLHttpRequest,textStatus, errorThrown) { 
	          // alert(errorThrown);
	         }
	      });
	});
	
	//加载评论
	$(document).ready(function () {
	     
	      $.ajax({ 
	          url:"/QuerryAllComments", 
	          type:"post" ,
	          dataType:"json",
	          success:function(data){ //整个接受叫data并不是后台的res叫data
	        	  var tindex=0;
	        	  $.each(data.res, function (index, item) {
	        		  tindex++;
	              });
	        	  console.log(tindex);
	        	  var id0 = document.getElementById('id0');
	        	  var ffid0= document.getElementById('ffid0');
	        	  var ct0 = document.getElementById('ct0');
	        	  
	        	  var id1 = document.getElementById('id1');
	        	  var ffid1= document.getElementById('ffid1');
	        	  var ct1 = document.getElementById('ct1');
	        	  
	        	  var id2 = document.getElementById('id2');
	        	  var ffid2= document.getElementById('ffid2');
	        	  var ct2 = document.getElementById('ct2');
	              
	            	  var cuid0=data.res[tindex-1].cuid;
	            	  var  content0= data.res[tindex-1].ccontent; 
	                  var cfid0 = data.res[tindex-1].cfid; 
	                  
	                  var cuid1=data.res[tindex-2].cuid;
	            	  var  content1= data.res[tindex-2].ccontent; 
	                  var cfid1 = data.res[tindex-2].cfid;
	                  
	                  var cuid2=data.res[tindex-3].cuid;
	            	  var  content2= data.res[tindex-3].ccontent; 
	                  var cfid2 = data.res[tindex-3].cfid;
	                  
	                  id0.innerText="@"+cuid0;
	                  ffid0.innerText="对文件"+cfid0+"评论：";
	                  ct0.innerText=content0;
	                  
	                  id1.innerText="@"+cuid1;
	                  ffid1.innerText="对文件"+cfid1+"评论：";
	                  ct1.innerText=content1;
	                  
	                  id2.innerText="@"+cuid2;
	                  ffid2.innerText="对文件"+cfid2+"评论：";
	                  ct2.innerText=content2;
	              
	          }, 
	      error:function(XMLHttpRequest,textStatus, errorThrown) { 
	          // alert(errorThrown);
	         }
	      });
	});
</script>
<table class="table">
  <thead>
    <tr>
      <th scope="col">文件id</th>
      <th scope="col">缩略图</th>
      <th scope="col">文件名</th>
      <th scope="col">上传人</th>
      <th scope="col">下载次数</th>
      <th scope="col">是否可下载</th>
      <th scope="col">冻结/解冻</th>
      <th scope="col">进行评论后解冻</th>
      <th scope="col">删除文件</th>
    </tr>
  </thead>
  <tbody id="tbody">
    
  </tbody>
</table>
<br/>

<div class="my-3 p-3 bg-white rounded shadow-sm">
    <h6 class="border-bottom border-gray pb-2 mb-0">最新评论</h6>
    <div class="media text-muted pt-3">
      <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"></rect><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

      <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
        <strong class="d-block text-gray-dark" id="id0">@username</strong>
        <strong class="d-block text-gray-dark" id="ffid0">@fileid</strong>
        <span id="ct0">Playing ping pong all night long, everything's all neon and hazy. Yeah, she's so in demand. She's sweet as pie but if you break her heart. But down to earth. It's time to face the music I'm no longer your muse. I guess that I forgot I had a choice.</span>
      </p>
    </div>
    <div class="media text-muted pt-3">
      <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#e83e8c"></rect><text x="50%" y="50%" fill="#e83e8c" dy=".3em">32x32</text></svg>

      <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
        <strong class="d-block text-gray-dark" id="id1">@username</strong>
        <strong class="d-block text-gray-dark" id="ffid1">@fileid</strong>
        <span id="ct1">Playing ping pong all night long, everything's all neon and hazy. Yeah, she's so in demand. She's sweet as pie but if you break her heart. But down to earth. It's time to face the music I'm no longer your muse. I guess that I forgot I had a choice.</span>
      </p>
    </div>
    <div class="media text-muted pt-3">
      <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#6f42c1"></rect><text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>

      <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
        <strong class="d-block text-gray-dark" id="id2">@username</strong>
        <strong class="d-block text-gray-dark" id="ffid2">@fileid</strong>
        <span id="ct2">Playing ping pong all night long, everything's all neon and hazy. Yeah, she's so in demand. She's sweet as pie but if you break her heart. But down to earth. It's time to face the music I'm no longer your muse. I guess that I forgot I had a choice.</span>
      </p>
    </div>
    <small class="d-block text-right mt-3">
      <a href="#">All comments</a>
    </small>
  </div>
</div><!-- /.container -->


    
      <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

      
  </body>
</html>
