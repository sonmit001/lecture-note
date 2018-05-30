var ajaxPostSend =  function() {
	
	parent.startLayer();
	var url = "joinAjax.blog";
	var postString = "";
	postString   = "id=" + $('#id').val();
	postString += "&password=" + $('#password').val();
	postString += "&name=" + $('#name').val();
	postString += "&email=" + $('#email').val();
    
	$.ajax({

		type: "POST",
		url: url,
		data: postString,
		success: function(msg) {
			setTimeout('parent.stopLayer('+msg+')',2500);
	   }
	});
	
 };