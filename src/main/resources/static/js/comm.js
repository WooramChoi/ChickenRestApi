Date.prototype.format = function(f){
		if (!this.valueOf()) return " ";
		let weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
		let d = this;
		return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1){
				switch ($1) {
						case "yyyy": return d.getFullYear();
						case "yy": return (d.getFullYear() % 1000).zf(2);
						case "MM": return (d.getMonth() + 1).zf(2);
						case "dd": return d.getDate().zf(2);
						case "E": return weekName[d.getDay()];
						case "HH": return d.getHours().zf(2);
						case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
						case "mm": return d.getMinutes().zf(2);
						case "ss": return d.getSeconds().zf(2);
						case "a/p": return d.getHours() < 12 ? "오전" : "오후";
						default: return $1;
				}
		});
};
String.prototype.string = function(len){var s='',i=0;while(i++<len){s+=this;}return s;};
String.prototype.zf = function(len){return '0'.string(len-this.length)+this;};
Number.prototype.zf = function(len){return this.toString().zf(len);};

const HttpUtil = {
	sendAsync : function(method, url, params, onSuccess, onFailed){
		$.ajax({
			method: method,
			url: url,
			data: params,
			contentType: 'application/json; charset=UTF-8',
			success: function(data, textStatus, jqXHR) {
				HttpUtil.jqXHRHandler(jqXHR, data);
				if(onSuccess){
					onSuccess(data);
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				HttpUtil.jqXHRHandler(jqXHR, textStatus);
				if(onFailed){
					onFailed(jqXHR);
				}
			}
		});
	},
	jqXHRHandler: function(jqXHR, data){
		// TODO 원래는 accepts, dataType, converters 를 통해 분기 및 세팅해줘야 하는 듯 하다. 안해
		var contentType = jqXHR.getResponseHeader('content-type');
		if(contentType){
			if(contentType.startsWith('text/html')){
				// TODO 팝업이 아니라 모달로 그려야하는데.. HTML 내용이 모두 그려지는게 문제
				var popup = window.open("", "popup", "");
				popup.document.write(data);
			}else if(contentType.startsWith('application/json') || contentType.startsWith('application/hal+json')){
				// 아 상태에 따라서 처리해야한다.
			}
		}
	}
};

const CodeUtil = {
	getOptions : function(strGroup, strKey, selector){
		HttpUtil.sendAsync("GET", "/api/codes/search/findByStrGroup?strGroup="+strGroup, null, function(resp){
			if ( resp && resp._embedded && resp._embedded.codes ) {
				resp._embedded.codes.forEach(function(currentValue, index, array){
					let code = currentValue;
					if ( code.strKey != '0000' ) {
						let option = document.createElement('option');
						option.value = code.strKey;
						option.innerHTML = code.strValue;
						if ( strKey && code.strKey == strKey ) {
							option.selected = true;
						}
						document.querySelector(selector).appendChild(option);
					}
				});
			}
		}, console.log);
	}
};