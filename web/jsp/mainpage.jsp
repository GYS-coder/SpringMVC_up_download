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
    <title>2 0 1 9 4 1 6 7 高 钰 森</title>

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

<main role="main" class="container">

  <div class="jumbotron">
  <h1 class="display-4">Hello !</h1>
  <p class="lead">本项目采用bootstrap+ajax+springmvc+mybaties来构建，本学期所有框架内容应该都有用到且不含其他框架技术</p>
  <p>本项目主要实现了文件的上传和下载，另外实现了（1）每个用户有单独的文件上传位置、（2）下拉菜单的文件类型为数据库查询得到、
  （3）每个人限制5m空间大小，上传页面显示剩余容量，超出则不被上传、（4）下载页面按下载次数降序排列（mapper中order by fdowntimes DESC）、
  （5）文件上传者可以解冻或冻结文件（非文件所有者不允许）、（6）可以对文件进行评论来解冻文件，下方会显示最新的3条评论
  （7）上传或下载前会过滤器验证session里信息来检测是否登录 （8）删除文件和容量恢复</p>
  <p><del>PS: 用户注册主要是插入数据库信息，上传文件也要插入数据库信息；navbar用户下拉菜单“我的”也是数据库增删改查，对文件也有类似操作，所以就懒得写了。。。_(:з)∠)_</del></p>
  <hr class="my-4">
  <p>点击下方按钮开始体验hhhh</p>
  <a class="btn btn-primary btn-lg" href="/jsp/upload.jsp" role="button">Start</a>
  </div>

</main><!-- /.container -->
<script type="text/javascript">
$(document).ready(function () {
		//加载nav用户信息
		var uuid=<%= session.getAttribute("uid")%>;
		$("#dropdown01").text("当前用户："+uuid);
		});
</script>

  <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

      
  </body>
</html>
