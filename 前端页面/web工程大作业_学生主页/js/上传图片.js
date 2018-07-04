//选择图片
var loadImg = function(obj) {
	$(obj).parent().find(".upload_input").click();
}
//删除
var deleteImg = function(obj) {
	$(obj).parent().find('input').val('');
	$(obj).parent().find('.preview').html('');
	$(obj).hide();
}

function preview(file) {
	var prevDiv = $(file).parent().find('.preview');
	if(file.files && file.files[0]) {
		var reader = new FileReader();
		reader.onload = function(evt) {
			prevDiv.html('<img src="' + evt.target.result + '" />');
		}
		reader.readAsDataURL(file.files[0]);
	} else { //IE
		prevDiv.html('<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>');
	}
	$(file).parent().find('.delete').show();
}