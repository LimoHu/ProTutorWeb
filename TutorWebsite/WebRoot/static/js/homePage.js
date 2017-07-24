var HomePage = {};
/**
 * 登陆
 */
HomePage.login = function(){
	var tel = $("#userName").val();
	var psd = $("#password").val();
	
	if(null == tel || "" == tel || null == psd || "" == psd){
		alert("手机号或密码为空");
	}
	else if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(tel))){
		alert("请输入正确的手机号！");
	}
	else{
		var param = {
			"url":"/TutorWebsite/User/login.do",
			"phonenumber":tel,
			"password":psd,
		};
		doInvoke(param,function(data){
			if(data.code == "0000"){
				if(data.data.status == "0"){
					alert("您已被禁用！");
				}else{
					sessionStorage["userId"] = data.data.userId;
					sessionStorage["userName"] = data.data.userName;
					sessionStorage["userType"] = data.data.usertype;
					sessionStorage["isLogin"] = "1";
					
					location.replace(document.referrer);
				}
			}else if(data.code == "0002"){
				alert("您未注册，请先行注册再登陆！");
			}else{
				alert("出现系统故障！");
			}
		});
	}
};

/**
 * 家教急聘
 */
HomePage.GetUrgencyRecruitInfo = function(){
	var param = {
		"url":"/TutorWebsite/RecruitInfo/recruitInfoThree.do",
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			var html = $("#showUrgencyRecruitInfo").render(data.data);
			$(".recruit").empty().append(html);
		}
	});
};

/**
 * 优质家教
 */
HomePage.GetTutorInfo = function(){
	var param = {
		"url":"/TutorWebsite/TutorDetailInfo/tutorDetailInfoFour.do",
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			var html = $("#showTutorInfo").render(data.data);
			$(".tutor").empty().append(html);
		}
	});
};

/**
 * 最新的十条家教招聘信息
 */
HomePage.GetRecruitInfo = function(){
	var param = {
		"url":"/TutorWebsite/RecruitInfo/recruitInfoTen.do",
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			var html = $("#showLatestRecruitInfo").render(data.data);
			$(".update-recruit").empty().append(html);
		}
	});
};

HomePage.SearchFast = function(){
	var str = "";
	var subject = $("#subject-choice").val();
	var indentity = $("#indentity").val();
	var sex = $("#sex-choice").val();
	
	if(subject != ""){
		str += "&subject="+subject;
	}
	if(indentity != ""){
		str += "&indentity="+indentity;
	}
	if(sex != ""){
		str += "&sex="+sex;
	}
	if(str == ""){
		window.location.href="/TutorWebsite/pages/TutorInfo.html";
	}else{
		window.location.href="/TutorWebsite/pages/TutorInfo.html?"+str.substring(1);
	}
	
	
};
