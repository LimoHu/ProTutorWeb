var RecruitInfo={};

/**
 * 初始化页面数据
 */
RecruitInfo.initPage=function(obj){
	var pageNumer = $(obj).val() || "1";
	var param={
		"url":"/TutorWebsite/RecruitInfo/recruitInfoList.do",
		"currentPage":pageNumer,
		"pageSize":8
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".recruit-list").empty().append($("#showRecruitInfo").render(data.data));
			var totalPage = data.totalPage;
			if(totalPage == 1){
				$(".part3").hide();
			}else{
				var _liTotal = "";
				for(var i = 0; i<totalPage; i++){
					if(i == pageNumer-1){
						_liTotal += '<li><input type="button" value="'+(i+1)+'" class="active-page" onclick="RecruitInfo.initPage(this);"></li>';
					}else{
						_liTotal += '<li><input type="button" value="'+(i+1)+'" onclick="RecruitInfo.initPage(this);"></li>';
					}
				}
				$(".recurit-pages").empty().append(_liTotal);
			}
			
		}
	});
};

RecruitInfo.showOverlay = function(recruitId){
	$(".over").show();
	$(".over-content").show();
	$("#recruitId_submit").val(recruitId);
};

RecruitInfo.closeOverLay = function(){
	$(".over").hide();
	$(".over-content").hide();
};


RecruitInfo.submitApply = function(){
	var userId = sessionStorage["userId"];
	var recruitId = $("#recruitId_submit").val();
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

RecruitInfo.searchRecruit = function(obj){
	
	var ckClass = $(obj).parent().parent().attr("class");
	
	$("."+ckClass).find("a").each(function(){
		if($(this).hasClass("active-choice")){
			$(this).removeClass("active-choice");
		}
	});
	
	$(obj).addClass("active-choice");
	
	var classType = $(".subject-choice").find("a.active-choice").text();
	var region = $(".location").find("a.active-choice").text();
	
	var param = {
		"url":"/TutorWebsite/RecruitInfo/queryRecruitInfoList.do",
		"classType":classType == "不限" ? "": RecruitInfo.ChangeType(classType),
		"region":region == "不限" ? "":region,
		"currentPage":1,
		"pageSize":8
	};
	
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".recruit-list").empty().append($("#showRecruitInfo").render(data.data));
			var totalPage = data.totalPage;
			if(totalPage == 1){
				$(".part3").hide();
			}else{
				var _liTotal = "";
				for(var i = 0; i<totalPage; i++){
					if(i == 0){
						_liTotal += '<li><input type="button" value="'+(i+1)+'" class="active-page" onclick="RecruitInfo.searchRecuitBtn(this);"></li>';
					}else{
						_liTotal += '<li><input type="button" value="'+(i+1)+'" onclick="RecruitInfo.searchRecuitBtn(this);"></li>';
					}
				}
				$(".tutor-pages").empty().append(_liTotal);
			}
		}
	});
};

RecruitInfo.searchRecuitBtn = function(obj){
	
	var classType = $(".subject-choice").find("a.active-choice").text();
	var region = $(".location").find("a.active-choice").text();
	var pageNumer = $(obj).val();
	
	var param = {
		"url":"/TutorWebsite/RecruitInfo/queryRecruitInfoList.do",
		"classType":classType == "不限" ? "": classType,
		"region":region == "不限" ? "":region,
		"currentPage":pageNumer,
		"pageSize":8
	};
	
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".recruit-list").empty().append($("#showRecruitInfo").render(data.data));
			var totalPage = data.totalPage;
			if(totalPage == 1){
				$(".part3").hide();
			}else{
				var _liTotal = "";
				for(var i = 0; i<totalPage; i++){
					if(i == pageNumer-1){
						_liTotal += '<li><input type="button" value="'+(i+1)+'" class="active-page" onclick="RecruitInfo.searchRecuitBtn(this);"></li>';
					}else{
						_liTotal += '<li><input type="button" value="'+(i+1)+'" onclick="RecruitInfo.searchRecuitBtn(this);"></li>';
					}
				}
				$(".tutor-pages").empty().append(_liTotal);
			}
		}
	});
};

RecruitInfo.ChangeType = function(text){
	var teachtype = "";
	if(text == "学前教育"){
		teachtype = "1";
	}else if(text == "小学家教"){
		teachtype = "2";
	}else if(text == "初中家教"){
		teachtype = "3";
	}else if(text == "高中家教"){
		teachtype = "4";
	}else if(text == "外语家教"){
		teachtype = "5";
	}else if(text == "特长家教"){
		teachtype = "6";
	}else{
		teachtype = "";
	}
	return teachtype;
};


