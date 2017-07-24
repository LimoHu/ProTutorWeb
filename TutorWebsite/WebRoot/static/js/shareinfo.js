var ShareInfo = {};
ShareInfo.initPage = function(obj){
	var pageNumer = $(obj).val() || "1";
	var param={
		"url":"/TutorWebsite/ShareInfo/shareInfoList.do",
		"currentPage":pageNumer,
		"pageSize":5,
	};
	
	if($(".choice>a.active-choice").text() == "我的帖子"){
		if(!CheckLogined()){
			alert("您未登陆！");
			return;
		}
		param.userId = sessionStorage["userId"];
	}
	
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".shareinfo-list").empty().append($("#shareinfoList").render(data.data));
			if(data.data.length == 0){
				$(".shareinfo-list").html("<span style='margin-top:5px;'>暂无帖子</span>");
				return;
			}
			
			var totalPage = data.totalPage;
			if(totalPage == 1){
				$(".part2").hide();
			}else{
				var _liTotal = "";
				for(var i = 0; i<totalPage; i++){
					if(i == pageNumer-1){
						_liTotal += '<li><input type="button" value="'+(i+1)+'" class="active-page" onclick="ShareInfo.initPage(this);"></li>';
					}else{
						_liTotal += '<li><input type="button" value="'+(i+1)+'" onclick="ShareInfo.initPage(this);"></li>';
					}
				}
				$(".tutor-pages").empty().append(_liTotal);
			}
		}else{
			alert("出现系统故障，请稍后再试！");
		}
	});
};



ShareInfo.submitShareInfo = function(){
	var shareInfo = $("textarea[name='share-content']").val()||"";
	userId = sessionStorage["userId"];
	if(CheckLogined()){
		var param={
			"url":"/TutorWebsite/ShareInfo/insertShareInfo.do",
			"shareinfo":shareInfo,
			"userId":userId
		};
		doInvoke(param,function(data){
			if(data.code == "0000"){
				location.reload(true);
			}else{
				alert("出现系统故障，请稍后再试！");
			}
		});
	}else{
		alert("您还未登陆！");
	}
	

};