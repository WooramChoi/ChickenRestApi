Date.prototype.format = (f)=>{
		if (!this.valueOf()) return " ";
		let weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
		let d = this;
		return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, ($1)=>{
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
String.prototype.string = (len)=>{var s='',i=0;while(i++<len){s+=this;}return s;};
String.prototype.zf = (len)=>{return '0'.string(len-this.length)+this;};
Number.prototype.zf = (len)=>{return this.toString().zf(len);};

$(document).pjax('a[data-pjax]', '#container', {
	url: '/views/trade/list.html'
});

const HttpUtil = {
	sendAsync : (method, url, params, onSuccess, onFailed)=>{
		let xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4) {
				if (this.status == 200) {
					onSuccess(this.responseText);
				} else {
					onFailed(this.status);
				}
			}
		};
		xhttp.open(method, url, true);
		xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhttp.send(JSON.stringify(params));
	}
};

const CodeUtil = {
	getOptions : (strGroup, strKey, selector)=>{
		HttpUtil.sendAsync("GET", "/api/codes/search/findByStrGroup?strGroup="+strGroup, {}, (message)=>{
			if ( message ) {
				let jsonObj = JSON.parse(message);
				if ( jsonObj && jsonObj._embedded && jsonObj._embedded.codes ) {
					jsonObj._embedded.codes.forEach((currentValue, index, array)=>{
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
			}
		}, console.log);
	}
};