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
    <title>upload</title>

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
        <a class="nav-link" href="/jsp/upload.jsp">??????</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/jsp/download.jsp">??????</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-expanded="false">??????</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="/jsp/signin.jsp">??????</a>
          <a class="dropdown-item" href="/jsp/signin.jsp">????????????</a>
          <a class="dropdown-item" href="#">??????</a>
        </div>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

<div class="container">
<script type="text/javascript">
	$(document).ready(function () {
		//??????nav????????????
		var uuid=<%= session.getAttribute("uid")%>;
		$("#dropdown01").text("???????????????"+uuid);
		
	      //?????????????????????
	      $("#inputState").empty();
	      $.ajax({ 
	          url:"/QuerryType", 
	          type:"post" , 
	          dataType:"json",
	          success:function(data){ //???????????????data??????????????????res???data
	              $("#inputState").append("<option value='-1'>--?????????--</option>");
	              
	              $.each(data.res, function (index, item) {  
	                  var tid = data.res[index].tid; 
	                  var tname = data.res[index].tname; 
	                  $("#inputState").append("<option value='"+tid+"'>"+tname+"</option>");
	              }); 
	          }, 
	      error:function(XMLHttpRequest,textStatus, errorThrown) { 
	          // alert(errorThrown);
	         }
	      });
	});
</script>

<script type="text/javascript">
	$(document).ready(function () {
	      //????????????select????????????
	      $("#remain").text("");
	      $.ajax({ 
	          url:"/Remain", 
	          type:"post" , 
	          dataType:"json",
	          success:function(data){ //???????????????data??????????????????res???data
	              
	                  var remainspace = data.res;
	                  
	                  $("#remain").text("????????????????????????"+remainspace);
	              
	          }, 
	      error:function(XMLHttpRequest,textStatus, errorThrown) { 
	          // alert(errorThrown);
	         }
	      });
	});
</script>


	<div class="row">
		<div class="col-md-12 order-md-1">
			<form action="/Upload" enctype="multipart/form-data" method="post">
		  
		    <!-- <div class="form-group">
    			<label for="exampleInputEmail1">uid</label>
    			<input type="text" class="form-control" name="uid" id="exampleInputEmail1" aria-describedby="emailHelp">
    			<small id="emailHelp" class="form-text text-muted">?????????????????????id?????????</small>
  			</div>
  			<div class="form-group">
    			<label for="exampleInputPassword1">??????</label>
    			<input type="password" class="form-control" name="upassword" id="exampleInputPassword1">
  			</div> -->
	

		  <div class="form-row">
		    <div class="form-group col-md-4">
		      <label for="inputState">????????????</label>
		      <select id="inputState" class="form-control" name="filetypeId">
		        <option selected>Choose...</option>
		        <option>...</option>
		      </select>
		    </div>
		    
		  </div>

		<div class="form-row">
			<div class="form-group">
			 <label for="exampleFormControlFile1" id="remain">??????????????????????????????</label>
			 
			 <input type="file" name="myfile" class="form-control-file" id="exampleFormControlFile1">
			</div>
	    </div>
	     
		  <div class="form-group">
		    <div class="form-check">
		      <input class="form-check-input" type="checkbox" id="gridCheck">
		      <label class="form-check-label" for="gridCheck">
		        	????????????
		      </label>
		    </div>
		  </div>
		  <button type="submit" class="btn btn-primary">??????</button>
		</form>
	
	  </div>
	</div>

</div><!-- /.container -->


 <script>window.jQuery || document.write('<script src="/assets/dist/js/jquery-3.6.0.min.js"><\/script>')</script><script src="/assets/dist/js/bootstrap.bundle.min.js"></script>




  </body>
</html>
