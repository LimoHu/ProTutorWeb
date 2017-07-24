var ShareInfoDetail = {};
ShareInfoDetail.initPage = function(){
	var shareId = GetQueryString("shareId");
	var param = {
		"url":"/TutorWebsite/ShareInfo/shareInfoSingle.do",
		"shareId":shareId
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".shareinfo-content").empty().append($("#shareContent").render(data.data));
			ShareInfoDetail.commentList();
			$(".left>p").text(data.data.username);
		}else{
			alert("出现系统故障，请稍后再试！");
		}
	});
};

ShareInfoDetail.addComment = function(){
	if(!CheckLogined()){
		alert("您未登陆！");
	}else{
		var shareId = GetQueryString("shareId");
		var userId = sessionStorage["userId"];
		var comment = $("textarea[name='comment-content']").val();
		console.log();
		var param = {
				"url":"/TutorWebsite/ShareComment/insertComment.do",
				"shareId":shareId,
				"userId":userId,
				"comment":comment
		};
		doInvoke(param,function(data){
			if(data.code == "0000"){
				ShareInfoDetail.commentList();
				$("#comment-content").empty();
			}else{
				alert("出现系统故障，请稍后再试！");
			}
		});
	}
};

ShareInfoDetail.commentList = function(obj){
	var pageNumer = $(obj).val() || "1";
	var shareId = GetQueryString("shareId");
	var param = {
		"url":"/TutorWebsite/ShareComment/commentList.o",
		"shareId":shareId,
		"currentPage":pageNumer,
		"pageSize":5
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".comment-list").empty().append($("#commentList").render(data.data));
			
			if(data.data.length == 0){
				$(".pages").html("<span style='margin-left:15px;margin-top:5px;'>暂无评论</span>");
				return;
			}
			
			var totalPage = data.totalPage;
			if(totalPage == 1){
				$(".pages").hide();
			}else{
				var _liTotal = "";
				for(var i = 0; i<totalPage; i++){
					if(i == pageNumer-1){
						_liTotal += '<li><input type="button" value="'+(i+1)+'" class="active-page" onclick="TutorInfo.initPage(this);"></li>';
					}else{
						_liTotal += '<li><input type="button" value="'+(i+1)+'" onclick="TutorInfo.initPage(this);"></li>';
					}
				}
				$(".tutor-pages").empty().append(_liTotal);
			}
		}else{
			alert("出现系统故障，请稍后再试！");
		}
	});
};


