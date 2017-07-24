


//通用的ajax，post方式取数据
function doInvoke(param, callback){
   var url = "";
   if(param.url && null != param.url && "" != param.url){
	   url = param.url;
   }
   $.ajax({
		type:"post",
		url:url,
		data:param,
		dataType:'json',
			success:function(respData) {
				callback(respData);
			},
			error : function(data) {
				//errorAlert("网络貌似不给力哦，再试试！");
			}
        });
};

//html中获取 页面传过来的 参数
function GetQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return decodeURI(r[2]); return null;   //若用unescape获取的地址栏参数若是中文会乱码
};

function CheckInputCntent(name){
	var text = $("input[name='"+name+"']").val();
	var re_text = $("input[name='"+name+"']").attr("placeholder");
	if( null == text || "" == text || re_text == text){
		return re_text;
	}else{
		return text;
	};
};

function CheckLogined(){
	if(sessionStorage["isRegister"] == "1" || sessionStorage["isLogin"] == "1"){
		return true;
	}else{
		return false;
	}
};


