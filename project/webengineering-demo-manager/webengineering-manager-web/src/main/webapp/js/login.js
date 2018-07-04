$(function(){
	var tab = 'account_number';
	// 选项卡切换
	$(".account_number").click(function () {
		$('.tel-warn').addClass('hide');
		tab = $(this).attr('class').split(' ')[0];
		checkBtn();
        $(this).addClass("on");
        $(".message").removeClass("on");
        $(".form2").addClass("hide");
        $(".form1").removeClass("hide");
    });
	// 选项卡切换
	$(".message").click(function () {
		$('.tel-warn').addClass('hide');
		tab = $(this).attr('class').split(' ')[0];
		checkBtn();
		$(this).addClass("on");
        $(".account_number").removeClass("on");
		$(".form2").removeClass("hide");
		$(".form1").addClass("hide");
		
    });

	$('#num').keyup(function(event) {
		$('.tel-warn').addClass('hide');
		checkBtn();
	});

	$('#pass').keyup(function(event) {
		$('.tel-warn').addClass('hide');
		checkBtn();
	});

	$('#veri').keyup(function(event) {
		$('.tel-warn').addClass('hide');
		checkBtn();
	});

	$('#num2').keyup(function(event) {
		$('.tel-warn').addClass('hide');
		checkBtn();
	});

	$('#veri-code').keyup(function(event) {
		$('.tel-warn').addClass('hide');
		checkBtn();
	});

	// 按钮是否可点击
	function checkBtn()
	{
		$(".log-btn").off('click');
		if (tab == 'account_number') {
			var inp = $.trim($('#num').val());
			var pass = $.trim($('#pass').val());
			if (inp != '' && pass != '') {
				if (!$('.code').hasClass('hide')) {
					code = $.trim($('#veri').val());
					if (code == '') {
						$(".log-btn").addClass("off");
					} else {
						$(".log-btn").removeClass("off");
						sendBtn();
					}
				} else {
					$(".log-btn").removeClass("off");
						sendBtn();
				}
			} else {
				$(".log-btn").addClass("off");
			}
		} else {
			var phone = $.trim($('#num2').val());
			var code2 = $.trim($('#veri-code').val());
			if (phone != '' && code2 != '') {
				$(".log-btn").removeClass("off");
				sendBtn();
			} else {
				$(".log-btn").addClass("off");
			}
		}
	}

	function checkAccount(username){
		
		if (username == '123') {
			$('.num-err').removeClass('hide').find("em").text('请输入账户');
			return false;
		} 
		//验证用户名是否合法，首位为字母
		var user=/^[一-龥a-zA-Z][一-龥a-zA-Z0-9_]*$/;
		if (!user.test(username)) {
			$('.num-err').removeClass('hide').find("em").text('用户名不合法！');
			return false;
		} 
		
		else {
			$('.num-err').addClass('hide');
			return true;
		}
	}
	
	//验证密码
	function checkPass(pass){
		if (pass == '') {
			$('.pass-err').removeClass('hide').text('请输入密码');
			return false;
		}
		//验证密码长度6-20位
		var password=/^[a-zA-Z0-9]{6,20}$/;
		if (!password.test(pass)) {
			$('.pass-err').removeClass('hide').find("em").text('密码长度错误！');
			return false;
		} 	
		else {
			$('.pass-err').addClass('hide');
			return true;
		}
	}

	function checkCode(code){
		if (code == '') {
			$('.img-err').removeClass('hide').text('请输入验证码');
			return false;
		} 
		//验证 验证码长度 4位
		var checkcode=/^[a-zA-Z0-9]{4}$/;
		if (!checkcode.test(code)) {
			$('.img-err').removeClass('hide').find("em").text('验证码长度错误！');
			return false;
		} 
		else {
			// $('.tel-warn').addClass('hide');
			return true;
		}
	}

	function checkPhone(phone){
		var status = true;
		if (phone == '') {
			$('.num2-err').removeClass('hide').find("em").text('请输入手机号');
			return false;
		}
		var param = /^1[34578]\d{9}$/;
		if (!param.test(phone)) {
			// globalTip({'msg':'手机号不合法，请重新输入','setTime':3});
			$('.num2-err').removeClass('hide');
			$('.num2-err').text('手机号不合法，请重新输入');
			return false;
		}
		
		return status;
	}
	//手机验证码验证
	function checkPhoneCode(pCode){
		if (pCode == '') {
			$('.error').removeClass('hide').text('请输入验证码');
			return false;
		} 
		
		//验证 验证码长度 6位
		var checkphonecode=/^[0-9]{6}$/;
		if (!checkphonecode.test(pCode)) {
			$('.error').removeClass('hide').text('验证码格式错误！');
			return false;
		} 	
		else {
			$('.error').addClass('hide');
			return true;
		}
	}

	// 登录点击事件
	function sendBtn(){
		if (tab == 'account_number') { 
			$(".log-btn").click(function(){
				// var type = 'phone';
				alert("点击按钮");
				var inp = $.trim($('#num').val());
				var pass = $.trim($('#pass').val());
				if (checkAccount(inp) && checkPass(pass)) {
					var encodepass = $.md5(pass);
					var ldata = {userinp:inp,password:encodepass};
					if (!$('.code').hasClass('hide')) {
						code = $.trim($('#veri').val());
						if (!checkCode(code)) {
							return false;
						}
						ldata.code = code;
					}
					$.ajax({
			            url: "/checkUserNameLoginInfo.action",
			            type: 'post',
			            dataType: 'json',
			            async: false,
			            data: ldata,
			            success:function(data){
			                if (data.code == '0') {
			                    // globalTip({'msg':'登录成功!','setTime':3,'jump':true,'URL':'http://www.ui.cn'});
			                    //globalTip(data.msg);
			                    alert("跳转首页");
			                    window.location.href="/jumpToUserIndex.action";
			                } else if(data.code == '2') {
			                	$(".log-btn").off('click').addClass("off");
			                    $('.pass-err').removeClass('hide').find('em').text(data.msg);
			                    $('.pass-err').find('i').attr('class', 'icon-warn').css("color","#d9585b");
			                    $('.code').removeClass('hide');
			                    $('.code').find('img').attr('src','/getLoginCheckCode.action?'+Math.random()).click(function(event) {
			                    	$(this).attr('src', '/getLoginCheckCode.action?'+Math.random());
			                    });;
			                    return false;
			                } else if(data.code == '3') {
			                	$(".log-btn").off('click').addClass("off");
			                    $('.img-err').removeClass('hide').find('em').text(data.msg);
			                    $('.img-err').find('i').attr('class', 'icon-warn').css("color","#d9585b");
			                    $('.code').removeClass('hide');
			                    $('.code').find('img').attr('src','/getLoginCheckCode.action?'+Math.random()).click(function(event) {
			                    	$(this).attr('src', '/getLoginCheckCode.action?'+Math.random());
			                    });
			                    return false;
			                } else if(data.code == '1'){
			                	$(".log-btn").off('click').addClass("off");
			                	$('.num-err').removeClass('hide').find('em').text(data.msg);
			                	$('.num-err').find('i').attr('class', 'icon-warn').css("color","#d9585b");
			                	return false;
			                }
			            },
			            error:function(){
			                
			            }
			        });
				} else {
					return false;
				}
			});
		} else {
			$(".log-btn").click(function(){
				// var type = 'phone';
				var phone = $.trim($('#num2').val());
				var pcode = $.trim($('#veri-code').val());
				if (checkPhone(phone) && checkPhoneCode(pcode)) {
					$.ajax({
			            url: "/checkPhoneLoginInfo",
			            type: 'post',
			            dataType: 'json',
			            async: false,
			            data: {phone:phone,code:pcode},
			            success:function(data){
			                if (data.code == '0') {
			                	// globalTip({'msg':'登录成功!','setTime':3,'jump':true,'URL':'http://www.ui.cn'});
			                	//globalTip(data.msg);
			                	alert("跳转首页");
			                	window.location.href="/jumpToUserIndex.action";
			                } else if(data.code == '1') {
			                	$(".log-btn").off('click').addClass("off");
			                    $('.num2-err').removeClass('hide').text(data.msg);
			                    return false;
			                } else if(data.code == '2') {
			                	$(".log-btn").off('click').addClass("off");
			                    $('.error').removeClass('hide').text(data.msg);
			                    return false;
			                }
			            },
			            error:function(){
			                
			            }
			        });
				} else {
					$(".log-btn").off('click').addClass("off");
					// $('.tel-warn').removeClass('hide').text('登录失败');
					return false;
				}
			});
		}
	}

	// 登录的回车事件
	$(window).keydown(function(event) {
    	if (event.keyCode == 13) {
    		$('.log-btn').trigger('click');
    	}
    });


	$(".form-data").delegate(".send","click",function () {
		var phone = $.trim($('#num2').val());
		if (checkPhone(phone)) {
				$.ajax({
					type: "post",
					url: "/sendLoginPhoneCheckCode.action",
					async: false,
					dataType: "json",
					data: {
						"phone": phone
					},
					success: function(data) {
						if(!data.isSuccess) {
							$('.num2-err').removeClass('hide').text("发送失败，请输入已注册的手机号");
						}
					},
					error: function() {
						alert("验证码发送失败");
					}
				});
	       	var oTime = $(".form-data .time"),
			oSend = $(".form-data .send"),
			num = parseInt(oTime.text()),
			oEm = $(".form-data .time em");
		    $(this).hide();
		    oTime.removeClass("hide");
		    var timer = setInterval(function () {
		   	var num2 = num-=1;
	            oEm.text(num2);
	            if(num2==0){
	                clearInterval(timer);
	                oSend.text("重新发送验证码");
				    oSend.show();
	                oEm.text("120");
	                oTime.addClass("hide");
	            }
	        },1000);
		}
    });



});