/**
 * 檔名只允許大小寫英文字母,0~9,-,_
 */
function checkFileName(s) {
	if (s != "") {
		var str = s.slice(s.lastIndexOf("\\") + 1, s.lastIndexOf("."));
		re = /^[\w\u002D\u002E]+$/;
		if (!re.test(str)) {
			return false;
		}
	}
	return true;
}

// 檢查檔案副檔名型態
function checkFileType(filevalue, ext) {
	if (ext == "") {
		ext = "*.txt";
	}

	var chkdata = filevalue.substr(filevalue.lastIndexOf(".") + 1)
			.toLowerCase();
	if ((chkdata == ext)) {
		return true;
	} else {
		return false;
	}
}

/*
 * 判斷是否為數字(包含小數點)
 */
/*
 * function checkNumber(data){
 * 
 * //var reg = /^[0-9]+.?[0-9]*$/; return isNaN(data);
 * 
 * //return reg.test(data); }
 */

/*
 * 判斷是否為正整數字
 */
function checkNumber(strString) {
	// var strValidChars = "0123456789.-";
	var strValidChars = "0123456789";
	var strChar;
	var blnResult = true;

	if (strString.length == 0)
		return false;

	// test strString consists of valid characters listed above
	for ( var i = 0; i < strString.length && blnResult == true; i++) {
		strChar = strString.charAt(i);
		if (strValidChars.indexOf(strChar) == -1) {
			blnResult = false;
		}
	}
	return blnResult;
}

/**
 * 數字格式化
 */
function numberFormat(number, pattern) {
	var str = number.toString();
	var strInt;
	var strFloat;
	var formatInt;
	var formatFloat;
	if (/\./g.test(pattern)) {
		formatInt = pattern.split('.')[0];
		formatFloat = pattern.split('.')[1];
	} else {
		formatInt = pattern;
		formatFloat = null;
	}
	if (/\./g.test(str)) {
		if (formatFloat != null) {
			var tempFloat = Math.round(parseFloat('0.' + str.split('.')[1])
					* Math.pow(10, formatFloat.length))
					/ Math.pow(10, formatFloat.length);
			strInt = (Math.floor(number) + Math.floor(tempFloat)).toString();
			strFloat = /\./g.test(tempFloat.toString()) ? tempFloat.toString()
					.split('.')[1] : '0';
		} else {
			strInt = Math.round(number).toString();
			strFloat = '0';
		}
	} else {
		strInt = str;
		strFloat = '0';
	}
	if (formatInt != null) {
		var outputInt = '';
		var zero = formatInt.match(/0*$/)[0].length;
		var comma = null;
		if (/,/g.test(formatInt)) {
			comma = formatInt.match(/,[^,]*/)[0].length - 1;
		}
		var newReg = new RegExp('(\\d{' + comma + '})', 'g');

		if (strInt.length < zero) {
			outputInt = new Array(zero + 1).join('0') + strInt;
			outputInt = outputInt.substr(outputInt.length - zero, zero)
		} else {
			outputInt = strInt;
		}

		var outputInt = outputInt.substr(0, outputInt.length % comma)
				+ outputInt.substring(outputInt.length % comma).replace(newReg,
						(comma != null ? ',' : '') + '$1')
		outputInt = outputInt.replace(/^,/, '');

		strInt = outputInt;
	}

	if (formatFloat != null) {
		var outputFloat = '';
		var zero = formatFloat.match(/^0*/)[0].length;

		if (strFloat.length < zero) {
			outputFloat = strFloat + new Array(zero + 1).join('0');
			// outputFloat = outputFloat.substring(0,formatFloat.length);
			var outputFloat1 = outputFloat.substring(0, zero);
			var outputFloat2 = outputFloat.substring(zero, formatFloat.length);
			outputFloat = outputFloat1 + outputFloat2.replace(/0*$/, '');
		} else {
			outputFloat = strFloat.substring(0, formatFloat.length);
		}

		strFloat = outputFloat;
	} else {
		if (pattern != '' || (pattern == '' && strFloat == '0')) {
			strFloat = '';
		}
	}

	return strInt + (strFloat == '' ? '' : '.' + strFloat);
}

/**
 * 數字格式化
 */
function numberFormat2(val, formatString) {
	var re = /%/;
	if (re.test(formatString)) {
		val = val * 100;
	}

	var patterns = formatString.split(".");
	var numbers = (val + "").split(".");
	var lpatterns = patterns[0].split("");
	var lpatternsbak = patterns[0].split("");

	var lkeep = "";
	var rkeep = "";

	// 小數點後大於樣式長度進行四捨五入
	if (numbers[1]) {
		var rnumbers = numbers[1].split("");
		var count = 0;
		if (patterns[1]) {
			var rpatterns = patterns[1].split("");

			for ( var i = 0; i < rpatterns.length; i++) {
				if (rpatterns[i] == "#" || rpatterns[i] == "0") {
					count++;
				}
			}
		}
		if (rnumbers.length > count) {
			numbers = (val.toFixed(count) + "").split(".");
		}

	}
	var lnumbers = numbers[0].split("");

	// 得到左側要替換的部分
	var lplaces = [];
	for ( var i = 0; i < lpatterns.length; i++) {
		var parternchar = lpatterns[i];

		if (parternchar == "#" || parternchar == "0") {
			lplaces.push(i);
		}
	}

	// 替換左側，左側有數字才要替換，以避免v = .99型的數字而產生錯誤
	if (lnumbers[0] && lnumbers[0].length > 0) {
		var numberIndex = lnumbers.length - 1;
		var replaced = 0;
		for ( var i = lplaces.length - 1; i >= 0; i--) {
			replaced++; // 被替換的字符數量
			var place = lplaces[i];
			lpatterns[place] = lnumbers[numberIndex];

			if (numberIndex == 0) {
				break;
			}
			numberIndex--;
		}

		// 處理以#為第一個格式（#前可能有非0的其他串也在此範圍）的格式串，對於以#開頭的格式串，將不會截取數字串，要補齊
		var lstartIdx = lplaces[0];

		// 補漏
		var nlen = lnumbers.length;
		var plen = lplaces.length;
		if (nlen > plen)
			lpatternsbak.splice(lstartIdx, 0, "#");

		if (lpatternsbak[lstartIdx] == "#") {
			if (lnumbers.length > replaced) {
				var idx = lnumbers.length - replaced;
				for ( var i = 0; i < idx; i++) {
					lkeep += lnumbers[i];
				}

				lpatterns[lstartIdx] = lkeep + lpatterns[lstartIdx];
			}
		}
	}

	// 替換右側
	if (patterns[1] && patterns[1].length > 0) {
		var rpatterns = patterns[1].split("");
		if (numbers[1] && numbers[1].length > 0) {
			var rnumbers = numbers[1].split("");

			// 得到右側將要替換的部分
			var rplaces = [];
			for ( var i = 0; i < rpatterns.length; i++) {
				var parternchar = rpatterns[i];
				if (parternchar == "#" || parternchar == "0") {
					rplaces.push(i);
				}
			}

			var replaced = 0;
			for ( var i = 0; i < rplaces.length; i++) {
				replaced++; // 被替換的字符數量
				var place = rplaces[i];
				rpatterns[place] = rnumbers[i];

				if (i == rnumbers.length - 1) {
					break;
				}
			}

		}
	}

	for ( var i = 0; i < lpatterns.length; i++) {
		if (lpatterns[i] == "#") {
			lpatterns[i] = "";
		}
	}

	var result = lpatterns.join("");
	if (patterns[1]) {
		for ( var i = 0; i < rpatterns.length; i++) {
			if (rpatterns[i] == "#") {
				rpatterns[i] = "";
			}
		}
		result += "." + rpatterns.join("");
	}

	// 第一位不能為,號
	if (result.substring(0, 1) == ",") {
		result = result.substring(1);
	}

	// 最後一位也不能為,號
	if (result.substring(result.length - 1) == ",") {
		result = result.substring(0, result.length);
	}
	return result;
}

/**
 * 判斷字的長度
 * @param field
 * @param fieldname
 * @param Maxlen
 * @returns {Boolean}
 */
function checkWordingMaxLen(fieldVal, fieldname, Maxlen) {
	
	var i, f_len, strPN;
	f_len = 0;
	for (i = 0; i < fieldVal.length; i++) {
		strPN = escape(fieldVal.charAt(i));
		if ((strPN.indexOf('%u')) != -1) {
			f_len = f_len + 1; // 若為中文,長度+1
		} else {
			f_len = f_len + 1; // 若為英文,長度+1
		} 
	}

	if (f_len > Maxlen) {
		alert("[" + fieldname + "] 超出最大可輸入字數，請確認！");
		return true;
	}
}


//判斷只能輸入中英文數字
function checkWord(data) {
	
	var isValid = false;
	var regExp = /[\a-\z\A-\Z0-9\u4E00-\u9FA5]+$/g;
	if (regExp.test(data)){
		isValid = true;
	} else{
		isValid = false;
	}
	if(!isValid){
		alert("只能請輸入中英文數字");
	}
}