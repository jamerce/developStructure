/*
 * --------------------------------------------------------------------
 * jQuery-Plugin - $.ifrmDownload - 使用iframe來進行檔案下載
 * by kait
 * Copyright (c) 2012
 * --------------------------------------------------------------------
 */

jQuery.ifrmDownload = function(url, data){
	//url and data options required
	if( url && data ){
		//data can be string of parameters or array/object
		data = typeof data == 'string' ? data : jQuery.param(data);
		//split params into form inputs
		
		var ifrm = $("<iframe style='display:none' />");
		ifrm.attr("src", url + "?" + data);
		ifrm.appendTo("body");
		ifrm.load(function (msg) {
			
	    });
	}
};
