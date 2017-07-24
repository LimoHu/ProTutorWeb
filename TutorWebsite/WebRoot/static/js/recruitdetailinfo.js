RecruitDetailInfo={};
RecruitDetailInfo.initPage=function(){
	
	var recruitId = GetQueryString("recruitId");
	var param = {
		"url":"http://localhost:4343/TutorWebsite/RecruitInfo/recruitDetailInfo.do",
		"recruitId":recruitId
	};
	doInvoke(param, function(data){
		if(data.code == "0000"){
			$(".recruit-detail-info").empty().append($("#recruitDetailInfo").render(data.data));
			var login_userId = sessionStorage["userId"];
			var recruit_userId = data.data.userId;
			if(recruit_userId == login_userId){
				$(".apply-list").show();
				RecruitDetailInfo.initApplyTable(recruitId);
			}
			
			$(".sub-btn").click(function(){
				$(".over").show();
				$(".over-content").show();
			});
			$("#cencel").click(function(){
				$(".over").hide();
				$(".over-content").hide();
			});
			if(sessionStorage["userType"]=="1"){
				$(".sub-btn").hide();
			}
		}
	});
};

RecruitDetailInfo.initApplyTable=function(recruitId){
	var param = {
		"url":"http://localhost:4343/TutorWebsite/Apply/applyInfoList.do",
		"recruitId":recruitId
	};
	doInvoke(param, function(data){
		if(data.code == "0000"){
			var _html = $("#applyInfolist").render(data.data);
			$(".apply-info-list").empty().append(_html);
		}
	});
};

RecruitDetailInfo.chooseApplicant = function(applyId){
	var param = {
		"url":"http://localhost:4343/TutorWebsite/Apply/chooseApplicant.do",
		"applyId":applyId
	};
	doInvoke(param, function(data){
		if(data.code == "0000"){
			
		}
	});
};

RecruitDetailInfo.submitApply = function(){
	var userId = sessionStorage["userId"];
	var recruitId = GetQueryString("recruitId");
	var param = {
		"url":"/TutorWebsite/Apply/insertApplyInfo.do",
		"userId":userId,
		"recruitId":recruitId
	};
	doInvoke(param, function(data){
		if(data.code == "0000"){
			alert("预约成功！");
		}else if(data.code == "0002"){
			$(".over").hide();
			$(".over-content").hide();
			alert("您已预约！");
		}else{
			alert("出现系统故障，请稍后再试！");
		};
		
		
	});
};