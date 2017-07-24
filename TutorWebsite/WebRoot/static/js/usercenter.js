var UserCenter = {};
UserCenter.initPage = function(){
	var url = "";
	
	var userId = sessionStorage["userId"];
	var userType = sessionStorage["userType"];
	
	if(userType == "1"){
		url = "/TutorWebsite/User/studentInfo.do";
	}
	else{
		$(".detail").show();
		url = "/TutorWebsite/User/tutorInfo.do";
	}
	var param = {
		"url":url,
		"userId":userId
	};
	
	doInvoke(param, function(data){
		if(data.code == "0000"){
			$(".basic").empty().append($("#showBasicInfo").render(data.data));
			$(".user-name").text(data.data.realname);
			
			$("#editBasicInfo").click(function(){
				$(".basic>p>em").hide();
				$(".basic>p>input").show();
				$(".basic>p>input+span").show();
				$(".location-choice").show();
			});
			
			if(userType == "2"){
				$(".detail").empty().append($("#showDetailInfo").render(data.data));
				$("#editDetailInfo").click(function(){
					$(".detail>p>em").hide();
					$(".detail>p>input").show();
					$(".detail>p>input+span").show();
					$("select[name='identity']").show();
					$("select[name='experience']").show();
					$("select[name='price']").show();
					$(".teach-time>tbody>tr>td>span").hide();
					$("input[name='time-detail']").show();
				});
			}
		}
	});
};

UserCenter.cancelEdit = function(type){
	if(type==1){
		$(".basic>p>em").show();
		$(".basic>p>input").hide();
		$(".basic>p>input+span").hide();
		$(".location-choice").hide();
	}else{
		$(".detail>p>em").show();
		$(".detail>p>input").hide();
		$(".detail>p>input+span").hide();
		$("select[name='identity']").hide();
		$("select[name='experience']").hide();
		$("select[name='price']").hide();
		$(".teach-time>tbody>tr>td>span").show();
		$("input[name='time-detail']").hide();
	}
}


UserCenter.SubmitBasicInfo = function(){
	var userId = sessionStorage["userId"];
	var userName = CheckInputCntent("username");
	var password = CheckInputCntent("psd");
	var phonenumber = CheckInputCntent("tel");
	var region = $(".location-choice").val();
	var address = CheckInputCntent("address");
	
	var param = {
		"url":"/TutorWebsite/User/update.do",
		"userId":userId,
		"username":userName,
		"password":password,
		"phonenumber":phonenumber,
		"region":region,
		"address":address
	};
	doInvoke(param, function(data){
		location.reload(true);
	});
};

UserCenter.SubmitDetailInfo = function(){
	var teachType = "";
	var teachTime = "";
	var userId = sessionStorage["userId"];
	var realname = CheckInputCntent("realname");
	var tel_info = CheckInputCntent("tel_info");
	var sex = $("input[name='sex']:checked").val();
	var identity = $("select[name='identity']").val();
	var time = $("input[name='time']:checked").val();
	var price = $("select[name='price']").val();
	var rule = $("input[name='rule']:checked").val();
	var experience = $("select[name='experience']").val();
	
	$("input:checkbox[name='teach-type']:checked").each(function(i){
		if(0 == i){
			teachType = $(this).val();
       	}else{
       		teachType += (","+$(this).val());
       	}
	});
	
	$("input:checkbox[name='time-detail']:checked").each(function(index){
		if(0 == index){
			teachTime = $(this).val();
       	}else{
       		teachTime += (","+$(this).val());
       	}
	});
	
	var param = {
		"url":"/TutorWebsite/TutorDetailInfo/updateDetail.do",
		"userId":userId,
		"realname":realname,
		"phonenumber":tel_info,
		"sex":sex,
		"identity":identity,
		"try_teachtime":time,
		"try_price":price,
		"try_rule":rule,
		"teachexperience":experience,
		"teachtype":teachType,
		"teachtime":teachTime
	};
	doInvoke(param, function(data){
		location.reload(true);
	});
};

UserCenter.GetCollectInfo = function(){
	var userId = sessionStorage["userId"];
	var param={
			"url":"/TutorWebsite/Collect/collectList.do",
			"userId":userId
		};
		doInvoke(param,function(data){
			if(data.code == "0000"){
				$(".collect-list").empty().append($("#showCollectlist").render(data.data));
			}
		});
};

UserCenter.GetApplyInfo = function(){
	var userId = sessionStorage["userId"];
	var param={
			"url":"/TutorWebsite/Apply/applyList.do",
			"userId":userId
		};
		doInvoke(param,function(data){
			if(data.code == "0000"){
				$(".apply-list").empty().append($("#showApplylist").render(data.data));
			}
		});
};

UserCenter.GetRecruitInfo = function(){
	var userId = sessionStorage["userId"];
	var param={
		"url":"/TutorWebsite/RecruitInfo/recruitSample.do",
		"userId":userId
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".recruit-list").empty().append($("#showRecruitlist").render(data.data));
		}
	});
};

