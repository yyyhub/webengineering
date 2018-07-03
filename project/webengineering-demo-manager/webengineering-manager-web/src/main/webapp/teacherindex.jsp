<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<head>
			<meta charset="UTF-8">
			<title>我的主页</title>
			<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
			<script type="text/javascript" src="js/bootstrap.min.js"></script>
			<link rel="stylesheet" href="css/bootstrap2.min.css" />
			<link rel="stylesheet" href="css/学生主页.css" />
			<link rel="stylesheet" href="css/demo.css" />
			<link rel="stylesheet" href="css/normalize.css" />
			<link rel="stylesheet" href="css/searchstyle.css" />
			<link rel="stylesheet" href="css/导航栏样式.css" />

			<link rel="stylesheet" href="css/消息组件.css" />
		</head>

		<body class="container">
			<c:if test="${!empty user }">
				<!--logo部分-->
				<div class="container">
					<div class="row" style="background: #c4c4c4; margin-left: 0px; margin-right: 0px; border-radius: 8px;">
						<div class="col-lg-8">
							<img src="images/logo3.png" style="height: 70px;" />
						</div>
						<div class="col-lg-4 text-right" style="padding-top: 30px;">
							<c:if test="${empty user }">
								<a href="#">登录</a>
								<a href="#">注册</a>
							</c:if>
							<c:if test="${!enpty user }">
								<a href="#">个人中心</a>
								<a href="/logoutUser.action">注销</a>
							</c:if>
						</div>
					</div>
				</div>

				<!--导航栏-->
				<div class="container" style="margin-top: 10px;">
					<nav class="navbar navbar-default nav1 green" style="margin-top: 0px;">
						<div class="container-fluid">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#ToBeHidden" aria-expanded="false" style="color: white;">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
								<a class="navbar-brand" href="#" style="color: white; font-size: 25px;">首页</a>
							</div>

							<div class="collapse navbar-collapse" id="ToBeHidden">
								<ul class="nav navbar-nav">
									<li>
										<a href="#" style="color: white; font-size: 20px;">管理课程
											<span class="sr-only">(current)</span>
										</a>
									</li>
									<li>
										<a href="#" style="color: white; font-size: 20px;">学生问题</a>
									</li>
									<li>
										<a href="#" style="color: white; font-size: 20px;">批改作业</a>
									</li>
									<li>
										<a href="#" style="color: white; font-size: 20px;">我的讨论</a>
									</li>

								</ul>

								<form class="navbar-form navbar-right" role="search" style="margin-top: 5px; margin-bottom: 5px;">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="搜索您想要的内容" style="border: 2px solid #324b4e; background: #F9F0DA; border-radius: 24px;">
									</div>
									<button type="submit" class="btn btn-default" style="border: 1px solid #324b4e; margin-left: 5px;">搜索</button>
								</form>
							</div>
						</div>
					</nav>
				</div>

				<div class="row" id="main" style="padding-left: 0px; padding-right: 0px;">
					<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12" id="mainLeft" style="padding-left: 0px; padding-right: 20px;">

						<div class="bloglist" style="margin-left: 0px; padding-right: 0px; background-image: url(images/消息背景2.jpg); border-radius: 8px;">
							<c:forEach var="message" items="${messages }">
								<div class="messageBox">
									<h3>
							<a href="#">【${message.subject}】${message.title}</a>
						</h3>
									<!--头像-->
									<figure>
										<img src="images/头像.jpg" style="width: 150px; height: 150px;"></figure>
									<ul>
										<div class="dot-ellipsis dot-height-50 dot-resize-update">
											<p id="1">
												消息内容摘要：
												<!--描述：最多70个字，最后要加上...-->
												${message.shortMsg}...
											</p>
										</div>
										<a href="#" class="readmore">查看&gt;&gt;</a>
									</ul>
									<p class="dateview">
										<span> ${message.sendtime }</span><span>发送人： ${message.sendusername }</span><span>消息状态：[<a
								href="#"> ${message.state } </a>]
							</span>
									</p>

								</div>
							</c:forEach>

							<div class="row text-center" style="padding-bottom: 10px;">
								<div class="col-lg-3 col-md-3 col-sm-3 hidden-xs"></div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-center col-center-block" style="text-align: center;">
									<div class="row" style="text-align: center;">
										<ul class="pager" style="text-align: center; width: 100%; margin-bottom: 5px;">
											<li>
												<a><span aria-hidden="true">&laquo;</span> </a>
											</li>
											<li>
												<a href="#">&lt;</a>
											</li>
											
												<c:if test="${messagebean.pageIndex <=2 }">
													<c:forEach var = "i" begin="1" end="5">
														<c:if test="${messagebean.pageIndex == i }">
															<li>
																<a href="#"> 0 </a>
															</li>
														</c:if>
														<c:if test="${messagebean.pageIndex != i }">
															<li>
																<a href="#"> ${i } </a>
															</li>
														</c:if>
													</c:forEach>
												</c:if>
												<c:if test="${messagebean.pageIndex >= messagebean.totalPages - 2 }">
													<c:forEach var = "i" begin="${messagebean.totalPages - 4 }" end="${messagebean.totalPages }">
														<c:if test="${messagebean.pageIndex == i }">
															<li>
																<a href="#"> 0 </a>
															</li>
														</c:if>
														<c:if test="${messagebean.pageIndex != i }">
															<li>
																<a href="#"> ${i } </a>
															</li>
														</c:if>
													</c:forEach>
												</c:if>
												<c:if test="${messagebean.pageIndex < messagebean.totalPages - 2 && messagebean.pageIndex > 2}">
													<c:forEach var = "i" begin="${messagebean.pageIndex - 2 }" end="${messagebean.pageIndex + 2 }">
														<c:if test="${messagebean.pageIndex == i }">
															<li>
																<a href="#"> 0 </a>
															</li>
														</c:if>
														<c:if test="${messagebean.pageIndex != i }">
															<li>
																<a href="#"> ${i } </a>
															</li>
														</c:if>
													</c:forEach>
												</c:if>
											<li>
												<a href="#">&gt;</a>
											</li>
											<li>
												<a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a>
											</li>
										</ul>
										<p style="text-align: center; font-family: '微软雅黑'; margin-top: 0px;">
											共<span>几</span>页&nbsp;&nbsp;&nbsp;共<span>几</span>条
										</p>
									</div>
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 hidden-xs"></div>

							</div>

						</div>
					</div>

					<div class="col-lg-3 col-md-3 col-sm-3 hidden-xs" style="align-content: center; padding-left: 0px; padding-right: 0px;">
						<div id="personalBox" style="padding-left: 0px; padding-right: 0px; padding-bottom: 10px; background-image: url(img/背景1.jpg); width: auto;">
							<div class="text-center">
								<img src="images/头像.jpg" class="img-circle" id="touxiang" style="height: 100px; width: 100px;" />
							</div>
							<div class="text-center">
								<p></p>
								<p>
									账户名称：<span> ${user.username }</span>
								</p>
								<p>
									姓名：<span> ${user.name }</span>
								</p>
								<p>
									所在院校：<span> ${user.schoolName } <br/>  ${user.collegeName } </span>
								</p>
								<!--<p>所在专业：<span>xxx</span></p>-->
								<a type="button" class="btn btn-default" href="#">我的课程</a>
							</div>
						</div>

					</div>

				</div>

				<div class="row text-center" id="below" style="margin-left: 0px; margin-right: 0px; border-radius: 8px; height: 50px;">
					<p>版权声明</p>
				</div>
			</c:if>
		</body>

</html>