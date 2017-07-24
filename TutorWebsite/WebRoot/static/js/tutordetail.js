var TutorDetail = {};
TutorDetail.initPage = function(){
	var userId = GetQueryString("userId");
	var param={
		"url":"/TutorWebsite/TutorDetailInfo/tutorDetail.do",
		"userId":userId
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".tutor-info-content").empty().append($("#showtutorInfo").render(data.data));
			$(".name").html(data.data.username);
		}
	});
};

TutorDetail.CheckCollected = function(){
	var userId = GetQueryString("userId");
	var userId_login = sessionStorage["userId"];
	
	var param={
		"url":"/TutorWebsite/Collect/checkCollected.do",
		"tutorId":userId,
		"userId":userId_login
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			if(data.data.total != "0"){
				$(".collected").show();
				$(".not-collect").hide();
			}
		}
	});
};

TutorDetail.Collect = function(){
	var userId = GetQueryString("userId");
	var userId_login = sessionStorage["userId"];
	var userType = sessionStorage["userType"];
	
	if(null == userId_login || "" == userId_login){
		alert("您还未登陆！");
		return;
	}else if(userType == "2"){
		alert("只有家长能收藏教员信息！");
		return;
	}
	
	var param={
		"url":"/TutorWebsite/Collect/insertCollectInfo.do",
		"tutorId":userId,
		"userId":userId_login
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			TutorDetail.CheckCollected();
		}
	});
};

