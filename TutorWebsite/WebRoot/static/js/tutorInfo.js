var TutorInfo={};

/**
 * 初始化页面数据
 */
TutorInfo.initPage=function(obj){
	var pageNumer = $(obj).val() || "1";
	var param={
		"url":"/TutorWebsite/TutorDetailInfo/tutorDetailInfoList.do",
		"currentPage":pageNumer,
		"pageSize":5
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".tutor-list").empty().append($("#showTutorInfo").render(data.data));
			var totalPage = data.totalPage;
			if(totalPage == 1){
				$(".part3").hide();
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
		}
	});
};

TutorInfo.searchTutor = function(obj){
	
	var ckClass = $(obj).parent().parent().attr("class");
	$("."+ckClass).find("a").each(function(){
		if($(this).hasClass("active-choice")){
			$(this).removeClass("active-choice");
		}
	});
	
	$(obj).addClass("active-choice");
	
	var teachtype = $(".subject-choice").find("a.active-choice").text();
	var sex = $(".sex-choice").find("a.active-choice").text();
	var identity = $(".indentity").find("a.active-choice").text();
	
	var param = {
		"url":"/TutorWebsite/TutorDetailInfo/queryTutorInfoList.do",
		"teachtype":teachtype == "不限" ? "": TutorInfo.ChangeType(teachtype),
		"sex":sex == "不限" ? "":sex,
		"identity":identity == "不限" ? "":identity,
		"currentPage":1,
		"pageSize":5
	};

	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".tutor-list").empty().append($("#showTutorInfo").render(data.data));
			var totalPage = data.totalPage;
			if(totalPage == 1){
				$(".part3").hide();
			}else{
				var _liTotal = "";
				for(var i = 0; i<totalPage; i++){
					if(i == 0){
						_liTotal += '<li><input type="button" value="'+(i+1)+'" class="active-page" onclick="TutorInfo.searchTutorBtn(this);"></li>';
					}else{
						_liTotal += '<li><input type="button" value="'+(i+1)+'" onclick="TutorInfo.searchTutorBtn(this);"></li>';
					}
				}
				$(".tutor-pages").empty().append(_liTotal);
			}
		}
	});
};

TutorInfo.searchTutorBtn = function(obj){
	
	var teachtype = $(".subject-choice").find("a.active-choice").text();
	var sex = $(".sex-choice").find("a.active-choice").text();
	var identity = $(".indentity").find("a.active-choice").text();
	var pageNumer = $(obj).val();
	
	var param = {
		"url":"/TutorWebsite/TutorDetailInfo/queryTutorInfoList.do",
		"teachtype":teachtype == "不限" ? "": TutorInfo.ChangeType(teachtype),
		"sex":sex == "不限" ? "":sex,
		"identity":identity == "不限" ? "":identity,
		"currentPage":pageNumer,
		"pageSize":5
	};
	
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".tutor-list").empty().append($("#showTutorInfo").render(data.data));
			var totalPage = data.totalPage;
			if(totalPage == 1){
				$(".part3").hide();
			}else{
				var _liTotal = "";
				for(var i = 0; i<totalPage; i++){
					if(i == pageNumer-1){
						_liTotal += '<li><input type="button" value="'+(i+1)+'" class="active-page" onclick="TutorInfo.searchTutorBtn(this);"></li>';
					}else{
						_liTotal += '<li><input type="button" value="'+(i+1)+'" onclick="TutorInfo.searchTutorBtn(this);"></li>';
					}
				}
				$(".tutor-pages").empty().append(_liTotal);
			}
		}
	});
};

TutorInfo.ChangeType = function(text){
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