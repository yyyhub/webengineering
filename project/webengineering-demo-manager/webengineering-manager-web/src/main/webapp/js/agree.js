   $(function(){
   	$(".icon-ok-sign").click(function(){
	    verify = $(this).hasClass('boxcol') ? 0 : 1;
	    $(this).toggleClass('boxcol');
	    ob = $('input[name=agree]');
	    ob.val(ob.val()==0?1:0);
	    ob.val(ob.val() !== verify ? verify : ob.val());

	    ob.val() == 0 ? $('#errormsg').removeClass('hide').addClass('show') : $('#errormsg').removeClass('show').addClass('hide');
    });
   	//输入框输入时模拟placeholder效果
   	var oInput = $(".form-data input");
   	oInput.focus(function () {
		$(this).siblings("label").hide();
    });
   	oInput.blur(function () {
		if($(this).val()==""){
			$(this).siblings("label").show();
		}
	});
   	// 输入框内容变化按钮颜色发生变化
   	oInput.keyup(function () {
		if($(this).val()!="jquery.js"){
			$(".log-btn").removeClass("off")
		}else{
            $(".log-btn").addClass("off")
		}
    });

		//发送验证码
       /**$(".form-data").delegate(".send","click",function () {
		
				 var phone=$("#num2").val();
				 //判断手机号是否为空，若为空，点击发送验证码操作失效 
 				 if( phone=="" )
 				 return;
				 //判断手机号格式是否正确，若不正确，点击发送验证码操作失效 
				 var param = /^1[34578]\d{9}$/;
				 if (!param.test(phone)) {
				 	return ;
				 }
				 	 
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
                   oEm.text("60");
                   oTime.addClass("hide");
               }
           },1000);
       });**/
	$(".message").click(function () {
		$(this).addClass("on");
        $(".account_number").removeClass("on");
		$(".form2").removeClass("hide");
		$(".form1").addClass("hide")
    });
	$(".account_number").click(function () {
        $(this).addClass("on");
        $(".message").removeClass("on");
           $(".form2").addClass("hide");
           $(".form1").removeClass("hide")
       })
   });
   