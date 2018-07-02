<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
		<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
		<link href="css/gloab.css" rel="stylesheet">
		<link href="css/index.css" rel="stylesheet">
		<script src="js/jquery-1.11.1.min.js"></script>
		<!--导入选择学校的css-->
		<link href="css/school.css" rel="stylesheet" />
		<!--导入选择学校的js-->
		<script src="js/jquery.min.js"></script>
		<script src="js/school.js"></script>
		<script src="js/register.js"></script>
		<!--导入密码加密-->
		<script src="js/jquery.md5.js"></script>
    </head>
    <body class="bgf4">
		<div class="login-box f-mt10 f-pb50">
			<div class="main bgf">
				<div class="reg-box-pan display-inline">
					<div class="step">
						<ul>
							<li class="col-xs-4 on">
								<span class="num">
                                <em class="f-r5"></em>
                                <i>1</i>
                            </span>
								<span class="line_bg lbg-r"></span>
								<p class="lbg-txt">填写账户基本信息</p>
							</li>
							<li class="col-xs-4">
								<span class="num">
                                <em class="f-r5"></em>
                                <i>2</i>
                            </span>
								<span class="line_bg lbg-l"></span>
								<span class="line_bg lbg-r"></span>
								<p class="lbg-txt">验证及完善账户信息</p>
							</li>
							<li class="col-xs-4">
								<span class="num">
                                <em class="f-r5"></em>
                                <i>3</i>
                            </span>
								<span class="line_bg lbg-l"></span>
								<p class="lbg-txt">注册成功</p>
							</li>
						</ul>
					</div>

					<!--开始注册信息-->

					<div class="reg-box" id="verifyCheck" style="margin-top:20px;">
						<form action="javascript:;" method="post" id="Form" onsubmit="return beforeSubmit()">
							<!--第一步，填写账户信息-->
							<div class="part1">
								<!--用户姓名-->
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>用户名：</span>
									<div class="f-fl item-ifo">
										<input type="text" maxlength="20" class="txt03 f-r3 required" tabindex="1" data-valid="isNonEmpty||between:3-20||isUname" data-error="用户名不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" name="username" />
										<span class="ie8 icon-close close hide"></span>
										<label class="icon-sucessfill blank hide"></label>
										<label class="focus">
                                    <span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span>
                                </label>
										<label class="focus valid" id="usernameerror"></label>
									</div>
								</div>
								<!--手机号-->
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>手机号：</span>
									<div class="f-fl item-ifo">
										<input type="text" class="txt03 f-r3 required" keycodes="tel" tabindex="2" data-valid="isNonEmpty||isPhone" data-error="手机号码不能为空||手机号码格式不正确" maxlength="11" id="phone" name="phone" />
										<span class="ie8 icon-close close hide"></span>
										<label class="icon-sucessfill blank hide"></label>
										<label class="focus">请填写11位有效的手机号码</label>
										<label class="focus valid" id="phoneerror"></label>
									</div>
								</div>
								<!--密码-->
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>密码：</span>
									<div class="f-fl item-ifo">
										<input type="password" id="password" maxlength="20" class="txt03 f-r3 required" tabindex="3" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-20||level:2" data-error="密码不能为空||密码长度6-20位||该密码太简单，有被盗风险，建议字母+数字的组合" name="password" />
										<span class="ie8 icon-close close hide" style="right:55px"></span>
										<span class="showpwd" data-eye="password"></span>
										<label class="icon-sucessfill blank hide"></label>
										<label class="focus">6-20位英文（区分大小写）、数字、字符的组合</label>
										<label class="focus valid"></label>
										<span class="clearfix"></span>
										<label class="strength">
                                    <span class="f-fl f-size12">安全程度：</span>
                                    <b>
                                        <i>弱</i>
                                        <i>中</i>
                                        <i>强</i>
                                    </b>
                                </label>
									</div>

								</div>
								<!--确认密码-->
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>确认密码：</span>
									<div class="f-fl item-ifo">
										<input type="password" maxlength="20" class="txt03 f-r3 required" tabindex="4" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-16||isRepeat:password" data-error="密码不能为空||密码长度6-16位||两次密码输入不一致" id="rePassword" />
										<span class="ie8 icon-close close hide" style="right:55px"></span>
										<span class="showpwd" data-eye="rePassword"></span>
										<label class="icon-sucessfill blank hide"></label>
										<label class="focus">请再输入一遍上面的密码</label>
										<label class="focus valid"></label>
									</div>
								</div>
								<!--验证码-->
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>验证码：</span>
									<div class="f-fl item-ifo">
										<input type="text" maxlength="4" class="txt03 f-r3 f-fl" tabindex="4" style="width:167px" id="randCode" name="checkcode" />
										<span class="ie8 icon-close close hide"></span>
										<label class="f-size12 c-999 f-fl f-pl10">
                                    <img src="${pageContext.request.contextPath}/getcheckcode.action" id="checkCodeImg"/>
                                </label>
										<label class="icon-sucessfill blank hide" style="left:380px"></label>
										<label class="focusa">看不清？
                                    <a href="javascript:;" class="c-blue" id="changeCheckImg">换一张</a>
                                </label>
										<label class="focus valid" style="left:370px" id="checkCodeMsg"></label>
									</div>
								</div>
								<!--同意条款-->
								<div class="item col-xs-12" style="height:auto">
									<span class="intelligent-label f-fl">&nbsp;</span>
									<p class="f-size14 required" data-valid="isChecked" data-error="请先同意条款">
										<input type="checkbox" checked />
										<a href="javascript:showoutc();" class="f-ml5">我已阅读并同意条款</a>
									</p>
									<label class="focus valid"></label>
								</div>
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">&nbsp;</span>
									<div class="f-fl item-ifo">
										<a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1">下一步</a>
									</div>
								</div>
							</div>
							<!--第二部分，验证账户信息-->
							<div class="part2" style="display:none">
								<div class="alert alert-info" style="width:700px">短信已发送至您手机，请输入短信中的验证码，确保您的手机号真实有效。</div>
								<div class="item col-xs-12 f-mb10" style="height:auto">
									<span class="intelligent-label f-fl">手机号：</span>
									<div class="f-fl item-ifo c-blue" id="phonenum">
										<!--获取前面填写的电话号码-->
									</div>
								</div>
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>验证码：</span>
									<div class="f-fl item-ifo">
										<input type="text" maxlength="6" id="verifyNo" class="txt03 f-r3 f-fl" tabindex="4" style="width:167px" name="phoneCheckCode" />
										<span class="btn btn-gray f-r3 f-ml5 f-size13" id="time_box" disabled style="width:97px;display:none;">发送验证码</span>
										<span class="btn btn-gray f-r3 f-ml5 f-size13" id="verifyYz" style="width:97px;">发送验证码</span>
										<span class="ie8 icon-close close hide" style="right:130px"></span>
										<label class="icon-sucessfill blank hide" id="phonecodesuccess"></label>
										<label class="focus" id="phonecodetip">
                                    <span>请查收手机短信，并填写短信中的验证码（此验证码3分钟内有效）</span>
                                </label>
										<label class="focus valid" id="phonecodeerror"></label>
									</div>
								</div>
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">&nbsp;</span>
									<div class="f-fl item-ifo">
										<a href="javascript:;" class="btn btn-blue f-r3" id="btn_part2">注册</a>
									</div>
								</div>
							</div>
							<!--第三部分，完善个人信息-->
							<div class="part3" style="display:none">
								<!--姓名-->
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>真实姓名：</span>
									<div class="f-fl item-ifo">
										<input type="text" maxlength="10" class="txt03 f-r3 required" tabindex="1" data-valid="isNonEmpty||between:2-10||isZh" data-error="真实姓名不能为空||真实姓名长度2-10位||只能输入中文" id="realname" name="realname" />
										<span class="ie8 icon-close close hide"></span>
										<label class="icon-sucessfill blank hide"></label>
										<label class="focus">2-10位，中文真实姓名</label>
										<label class="focus valid"></label>
									</div>
								</div>

								<!--工号-->
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>工号：</span>
									<div class="f-fl item-ifo">
										<input type="text" class="txt03 f-r3 required" tabindex="2" data-valid="isNonEmpty||isInt" data-error="工号不能为空||工号格式只能为数字" maxlength="11" id="staffid" name="teacher_id" />
										<span class="ie8 icon-close close hide"></span>
										<label class="icon-sucessfill blank hide"></label>
										<label class="focus">请填写有效的工号(最多11位)</label>
										<label class="focus valid"></label>
									</div>
								</div>
								<!--邮箱-->
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>邮箱：</span>
									<div class="f-fl item-ifo">
										<input type="text" class="txt03 f-r3 required" tabindex="3" data-valid="isNonEmpty||isEmail" data-error="email不能为空||email格式不正确" id="email" name="email" />
										<span class="ie8 icon-close close hide"></span>
										<label class="icon-sucessfill blank hide"></label>
										<label class="focus">请填写有效的email</label>
										<label class="focus valid"></label>
									</div>
								</div>
								<!--所在学校-->
								<div class="item col-xs-12" style="z-index: 99;">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>学校名称：</span>
									<div class="f-fl item-ifo">
										<input type="text" class="txt03 f-r3 required" tabindex="4" data-valid="isNonEmpty" data-error="不能为空" id="school" placeholder="请点击选择学校" style="background-color: white;" name="schooladdr" readonly />
										<span class="ie8 icon-close close hide"></span>
										<label class="icon-sucessfill blank hide"></label>
										<label class="focus" id="shcool-right-icon">点击选择学校</label>
										<label class="focus valid"></label>

										<div id="proSchool" class="provinceSchool" style="background-color: white;">
											<div class="title">
												<span>请选择学校</span>
											</div>
											<div class="proSelect">
												<select></select>
												<span>如没找到选择项，请选择其他手动填写</span>
												<input type="text" />
											</div>
											<div class="schoolList">
												<ul></ul>
											</div>
											<div class="button">
												<button flag='0'>取消</button>
												<button flag='1'>确定</button>
											</div>
										</div>
									</div>
								</div>
								<!--所在学院-->
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">
                                <b class="ftx04">*</b>所在学院：</span>
									<div class="f-fl item-ifo">
										<input type="text" class="txt03 f-r3 required" tabindex="5" data-valid="isNonEmpty" data-error="学院不能为空" id="college_id" name="collegeName" />
										<span class="ie8 icon-close close hide"></span>
										<label class="icon-sucessfill blank hide"></label>
										<label class="focus">请输入有效的学院</label>
										<label class="focus valid"></label>
									</div>
								</div>

								<!--下一步-->
								<div class="item col-xs-12">
									<span class="intelligent-label f-fl">&nbsp;</span>
									<div class="f-fl item-ifo">
										<a href="javascript:;" class="btn btn-blue f-r3" id="btn_part3" onclick="mysubmit()">下一步</a>
										<!--添加提交按钮，隐藏-->
										<input type="submit" class="hide" id="submitBtn" />
									</div>
								</div>
							</div>
							<!--第四部分，注册成功后跳转页面-->
							<div class="part4 text-center" style="display:none">
								<h3>您已注册成功！</h3>
								<p class="c-666 f-mt30 f-mb50">页面将在
									<strong id="times" class="f-size18">10</strong> 秒钟后，跳转到
									<a href="http://www.17sucai.com/" class="c-blue">用户中心</a>
								</p>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="m-sPopBg" style="z-index:998;"></div>
		<div class="m-sPopCon regcon">
			<div class="m-sPopTitle">
				<strong>服务协议条款</strong>
				<b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b>
			</div>
			<div class="apply_up_content">
				<pre class="f-r0">
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
			</div>
			<center>
				<a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">已阅读并同意此条款</a>
			</center>
		</div>
		<script>
			//用户名判重
				$("#adminNo").change(function(){
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/checkusername.action",
						async:true,
						dataType:"json",
						data:{"username":$("#adminNo").val()},
						success:function(result){
							if(result.isnameexist==true){
								$("#adminNo").addClass("v_error");
								$("#usernameerror").addClass("error");
								$("#usernameerror").html("用户名已经存在");
							}
						},
						error:function(result){
							alert("错误");
						}
					});
				});
				
				//手机号判重
				$("#phone").change(function(){
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/checkphonenumber.action",
						async:true,
						dataType:"json",
						data:{"phonenumber":$("#phone").val()},
						success:function(result){
							if(result.isphoneexist){
								$("#phone").addClass("v_error");
								$("#phoneerror").addClass("error");
								$("#phoneerror").html("电话号码已经存在");
							}
						},
						error:function(result){
							alert("错误");
						}
					});
				});
				
				//换一张验证码
				$("#changeCheckImg").click(function(){
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/getcheckcode.action",
						async:true,
						success:function(result){
							$("#checkCodeImg").attr("src","${pageContext.request.contextPath}/getcheckcode.action");
						}
					
					});
					
					//alert("haha");
				});

			$(function() {
				
				//第一页的确定按钮
				$("#btn_part1").click(function() {
					if(!verifyCheck._click()) return;
					var checkCodeSign=false;
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/checkccode.action",
						async:false,
						dataType:"json",
						data:{"checkcode":$("#randCode").val()},
						success:function(result){
							if(result.ischeckcoderight){
								checkCodeSign=true;
								
							}
							else{
								$("#randCode").addClass("v_error");
								$("#checkCodeMsg").addClass("error");
								$("#checkCodeMsg").html("验证码错误");	
							}
						},
						error:function(result){
							alert("错误");
						}
					
					});
					//alert(checkCodeSign);
					
					if(!checkCodeSign){
						return;
					}
					
					$(".part1").hide();
					$("#password").val($.md5($("#password").val())); //密码md5加密
					getPhone();
					$(".part2").show();
					$(".step li").eq(1).addClass("on");
					
				});
				//第二页的确定按钮
				$("#verifyNo").click(function(){
					$("#phonecodesccess").hide();
					$("#verifyNo").removeClass("v_error");
					$("#phonecodeerror").removeClass("error");
					$("#phonecodeerror").html("");
					$("#phonecodetip span").show();
				});
				$("#btn_part2").click(function() {
					if(!verifyCheck._click()) return;
					var isRight = false;
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/checkPhoneCode.action",
						async:false,
						dataType:"json",
						data:{"phoneCode":$("#verifyNo").val()},
						success:function(data){
							if (data.isRight){
								isRight = true;
							}else{
								isRight = false;
								$("#phonecodesccess").hide();
								$("#phonecodetip span").hide();
								$("#phonecodesccess").html("");
								$("#verifyNo").addClass("v_error");
								$("#phonecodeerror").addClass("error");
								$("#phonecodeerror").html("验证码错误");
							}
						},
						error:function(){
							isRight = false;
							alert("验证码发送失败");
						}
					});
					if (!isRight){
						return;
					}
					$("#verifyNo").removeClass("v_error");
					$("#phonecodeerror").removeClass("error");
					$("#phonecodeerror").html("");
					$("#phonecodesccess").show();
					$("#phonecodesccess").html("::befor ::after");
					$("#phonecodetip span").hide();
					$(".part2").hide();
					$(".part3").show();
				});
				//第三页的确定按钮
				$("#btn_part3").click(function() {
					if(!verifyCheck._click()) return;
					$.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/addNewTeacher.action",
						async:false,
						dataType:"json",
						data:{"username":$("#adminNo").val(),"password":$("#password").val(),"phone":$("#phone").val(),"name":$("#realname").val(),"staffid":$("#staffid").val(),
						"mail":$("#email").val(),"schoolName":$("#school").val(),"collegeName":$("#college_id").val()},
						success:function(){
							alert("成功")
						},
						error:function(){
							alert("添加失败");
						}
					});
					$(".part3").hide();
					$(".part4").show();
					$(".step li").eq(2).addClass("on");
					countdown({
						maxTime: 99,
						ing: function(c) {
							$("#times").text(c);
						},
						after: function() {
							window.location.href = "my.html";
						}
					});
				});
			});

			function showoutc() {
				$(".m-sPopBg,.m-sPopCon").show();
			}
			//获取电话号码并写入确定位置
			function getPhone() {
				phonenum = $("#phone").val();
				$("#phonenum").html(phonenum);
			}

			function closeClause() {
				$(".m-sPopBg,.m-sPopCon").hide();
			}
			//添加一个隐藏的提交按钮,然后默认点击
			function mysubmit() {
				//点击隐藏的提交按钮 
				$("#submitBtn").click();
			}
			//表单提交返回值
			function beforeSubmit() {
				return true;
			}
		</script>
	</body>

</html>