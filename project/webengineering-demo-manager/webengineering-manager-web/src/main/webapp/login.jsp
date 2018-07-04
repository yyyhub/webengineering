<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%-->

<html lang="zh-CN">

	<head>
		<meta charset="UTF-8">
		<title>用户登录</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="Keywords" content="网站关键词">
		<meta name="Description" content="网站介绍">
		<link rel="stylesheet" href="css/base.css">
		<link rel="stylesheet" href="css/iconfont.css">
		<link rel="stylesheet" href="css/reg.css">
		<link rel="stylesheet" href="css/selectResigter.css" />
		<script src="js/jquery.js"></script>
		<!--导入选择界面-->
		<link rel="stylesheet" href="css/dialog.css" />
		<script src="js/mDialog.js"></script>
		<script src="js/mDialogMin.js"></script>

		<script src="js/agree.js"></script>
		<!--导入密码加密-->
		<script src="js/jquery.md5.js"></script>
		<script src="js/login.js"></script>
	</head>

	<body>
		<div id="ajax-hook"></div>
		<div class="wrap">
			<div class="wpn">
				<div class="form-data pos">
					<a href=""><img src="./img/logo.png" class="head-logo"></a>
					<div class="change-login">
						<p class="account_number on">账号登录</p>
						<p class="message">短信登录</p>
					</div>
					<div class="form1">
						<p class="p-input pos">
							<label for="num">请输入用户名</label>
							<input type="text" id="num">
							<span class="tel-warn num-err hide" id="userNameErrorSpan"><em id="userNameErrorInfo">账号或密码错误，请重新输入</em><i class="icon-warn"></i></span>
						</p>
						<p class="p-input pos">
							<label for="pass">请输入密码</label>
							<input type="password" style="display:none" />
							<input type="password" id="pass" autocomplete="new-password">
							<span class="tel-warn pass-err hide" id="passwordErrorSpan"><em id="passwordErrorInfo">账号或密码错误，请重新输入</em><i class="icon-warn"></i></span>
						</p>
						<p class="p-input pos code ">
							<label for="veri">请输入验证码</label>
							<input type="text" id="veri">
							<!--设置验证码的src-->
							<img src="${pageContext.request.contextPath}/getLoginCheckCode.action" title="点击换图片" id="checkCodeImg">
							<span class="tel-warn img-err hide" id="checkcodeErrorSpan"><em id="checkcodeErrorInfo">验证码错误，请重新输入</em><i class="icon-warn"></i></span>
							<!--a href="javascript:;" id="changeCheckImg">换一换</a-->
						</p>
						<!--账号操作-->
						<div class="r-forget cl">
							<!--记住密码和自动登陆-->
							<p class="z" style="display: inline-block;">
								<input type="checkbox" value="" class="check_input" style="position:static ;width: 15px;" />
								<span class="check_login_remember">记住密码</span>

								<input type="checkbox" value="" class="check_input" style="position:static ;width: 15px;" />
								<span class="check_login_remember">自动登陆</span>

							</p>

							<!--注册和忘记密码-->
							<a href="javascript:void(0)" onclick="showResigter()" class="y">账号注册</a>
							<!--<span name="user_resigter" onclick="userResigter()" class="y" style="cursor:pointer;">账号注册</span>-->
							<a href="javascript:;" class="y"> <span style="color: red;">忘记密码?</span> </a>
						</div>
					</div>
					<!--短信登陆-->
					<div class="form2 hide">
						<p class="p-input pos">
							<label for="num2">手机号</label>
							<input type="number" id="num2">
							<span class="tel-warn num2-err hide"><em>账号或密码错误</em><i class="icon-warn"></i></span>
						</p>
						<p class="p-input pos">
							<label for="veri-code">输入验证码</label>
							<input type="number" id="veri-code">
							<a href="javascript:;" class="send" id="sendPhoneCheckCode">发送验证码</a>
							<span class="time hide"><em>120</em>s</span>
							<span class="tel-warn error hide">验证码错误</span>
						</p>
						<!--账号操作-->
						<div class="r-forget cl">
							<!--注册和忘记密码-->
							<a href="javascript:void(0)" onclick="showResigter()" class="z">账号注册</a>
							<a href="" class="y"> <span style="color: red;">忘记密码?</span> <span style="color: #3498DB;"></span></a>
						</div>
					</div>
					<!--登陆按钮-->
					<button href="javascript:;" class="lang-btn off log-btn" id="loginbutton">登录</button>
					<div class="third-party">
						<a href="#" class="log-qq icon-qq-round"></a>
						<a href="#" class="log-qq icon-weixin"></a>
						<a href="#" class="log-qq icon-sina1"></a>
					</div>
					<p class="right">Powered by © 2018</p>
				</div>
			</div>
		</div>
		<script>
			//换一张验证码
			$('.code').find('img').attr('src', '/getLoginCheckCode.action').click(function(event) {
				$(this).attr('src', '/getLoginCheckCode.action?' + Math.random());
			});

			



			//展示选择注册项 ,弹框
			function showResigter() {
				Dialog.init(
					'<img src="img/register.jpg" style="margin:8px 0;width:100%;padding:11px 8px;font-size:15px; border:0px solid #999;">', {
						title: '欢迎来到注册页面！',
						button: {
							教师注册: function() {

								Dialog.init('你点击了教师注册', 2000);
								Dialog.close(this);
								teacherRegister();
							},
							学生注册: function() {
								Dialog.init('你点击了学生注册', 2000);
								Dialog.close(this);
								studentRegister();
							}
						}
					});
			}
			//2秒后跳转教师注册页面 
			function teacherRegister() {
				window.location.href="teacherreg.action";
				//setTimeout(function() {
//					$.ajax({
//						type: "post",
//						url: "/teacherreg.action",
//						async: false,
//						data: {
//							"register": "teacher"
//						},
//						success: function() {
//							//window.location.href="http://www.baidu.com";
//						},
//						error: function() {
//							alert("跳转失败");
//						}
//					});
//				}, 2000);
				
			}
			//2秒后跳转学生注册页面 
			function studentRegister() {
				window.location.href="studentreg.action";
//				setInterval(function() {
//					$.ajax({
//						type: "post",
//						url: "/teacherreg.action",
//						async: true,
//						data: {
//							"register": "student"
//						},
//						success: function() {
//
//						},
//						error: function() {
//					
//						}
//					});
//				}, 2000);
			}
		</script>

	</body>

</html>