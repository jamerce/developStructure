/*
 * init 2011/05/26 kait 
 */

/**
 * window.open with post method
 */
function openWindowWithPost(url, name, keys, values, openStyle) {

	var newWindow = window.open('', name, openStyle);
	if (!newWindow){
		return false;
	}
	
	var html = "";
	html += "<html><head></head><body><form id='formid' method='post' action='"	+ url + "'>";
	if (keys && values && (keys.length == values.length)){
		for ( var i = 0; i < keys.length; i++){
			html += "<input type='hidden' name='" + keys[i] + "' value='" + values[i] + "'/>";
		}
	}
	html += "</form><script type='text/javascript'>document.getElementById(\"formid\").submit()</script></body></html>";
	
	newWindow.document.write(html);
	return newWindow;
}
