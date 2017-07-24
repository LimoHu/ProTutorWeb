var ManageCenter = {};
ManageCenter.userList = function(obj){
	var pageNumer = $(obj).val() || "1";
	var param = {
		"url":"/TutorWebsite/User/list.do",
		"currentPage":pageNumer,
		"pageSize":10
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".user-list>tbody").empty().append($("#userList").render(data.data));
			var totalPage = data.totalPage;
			var _li = "";
			for(var i = 0 ; i < totalPage ; i++){
				if(i == pageNumer-1){
					_li += '<li><input type="button" value="'+(i+1)+
					'" class="active-page" onclick="ManageCenter.userList(this)"></li>';
				}
				else{
					_li += '<li><input type="button" value="'+(i+1)+'" onclick="ManageCenter.userList(this)"></li>';
				}
			}
			$(".user-pages").empty().append(_li);
		}
	});
};

ManageCenter.infoList = function(obj){
	var pageNumer = $(obj).val() || "1";
	var param = {
		"url":"/TutorWebsite/RecruitInfo/infoList.do",
		"currentPage":pageNumer,
		"pageSize":10
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			$(".info-list>tbody").empty().append($("#infoList").render(data.data));
			var totalPage = data.totalPage;
			var _li = "";
			for(var i = 0 ; i < totalPage ; i++){
				if(i == pageNumer-1){
					_li += '<li><input type="button" value="'+(i+1)+
					'" class="active-page" onclick="ManageCenter.userList(this)"></li>';
				}
				else{
					_li += '<li><input type="button" value="'+(i+1)+'" onclick="ManageCenter.infoList(this)"></li>';
				}
			}
			$(".info-pages").empty().append(_li);
		}
	});
};



ManageCenter.deleteUser = function(userId){
	var param = {
		"url":"/TutorWebsite/User/delete.do",
		"userId":userId
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			ManageCenter.userList();
		}
	});
};

ManageCenter.disableUser = function(userId,status){
	var param = {
		"url":"/TutorWebsite/User/disable.do",
		"userId":userId,
		"status":status
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			ManageCenter.userList();
		}
	});
};

ManageCenter.deleteRecruitInfo = function(recruitId){
	var param = {
		"url":"/TutorWebsite/RecruitInfo/deletInfo.do",
		"recruitId":recruitId
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			ManageCenter.infoList();
		}
	});
};

ManageCenter.drowLine = function(){
	var param = {
			"url":"/TutorWebsite/RecruitInfo/classType.do"
		};
	doInvoke(param,function(data){
		
		if(data.code == "0000"){
			var _data = [];
			var reData = data.data;
			var name = ['学前教育','小学家教','初中家教','高中家教','外语家教','特长家教'];
			for(var i=0;i<name.length;i++){
				for(var j=0;j<reData.length;j++){
					if(reData[j].classType == name[i]){
						_data.push(reData[j].total);
						break;
					}else{
						if(j==reData.length-1){
							_data.push(0);
						}
					}
				}
			}
			var lineChart = echarts.init(document.getElementById('line'));

		    option = {
		    	    title: {
		    	        text: '课程类别统计',
		    	    },
		    	    tooltip: {
		    	        trigger: 'axis'
		    	    },
		    	    legend: {
		    	        data:['课程类别']
		    	    },
		    	    toolbox: {
		    	        show: true,
		    	        feature: {
		    	            dataView: {readOnly: false},
		    	            magicType: {type: ['line', 'bar']},
		    	            saveAsImage: {}
		    	        }
		    	    },
		    	    xAxis:  {
		    	        type: 'category',
		    	        boundaryGap: false,
		    	        data: ['学前教育','小学家教','初中家教','高中家教','外语家教','特长家教']
		    	    },
		    	    yAxis: {
		    	        type: 'value',
		    	        axisLabel: {
		    	            formatter: '{value} 人'
		    	        }
		    	    },
		    	    series: [
		    	        {
		    	            name:'招聘数量',
		    	            type:'line',
		    	            barWidth:50,
		    	            data:_data,
		    	            markPoint: {
		    	                data: [
		    	                    {type: 'max', name: '最大值'},
		    	                    {type: 'min', name: '最小值'}
		    	                ]
		    	            },
		    	            markLine: {
		    	                data: [
		    	                    {type: 'average', name: '平均值'}
		    	                ]
		    	            }
		    	        }
		    	    ]
		    	};

		    // 使用刚指定的配置项和数据显示图表。
		    lineChart.setOption(option);
		}
	});
};


ManageCenter.drowPie = function(){
	var param = {
		"url":"/TutorWebsite/RecruitInfo/mark.do"
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			var _data = [];
			var reData = data.data;
			var name = ['E','D','C','B','A'];
			for(var i=0;i<name.length;i++){
				for(var j=0;j<reData.length;j++){
					if(reData[j].mark == name[i]){
						_data.push(reData[j].total);
						break;
					}else{
						if(j==reData.length-1){
							_data.push(0);
						}
					}
				}
			}
			var pieChart = echarts.init(document.getElementById('pie'));
			option = {
				    title : {
				        text: '成绩统计',
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    series : [
				        {
				            name: '统计数量',
				            type: 'pie',
				            radius : '55%',
				            center: ['50%', '60%'],
				            data:[
				                {value:_data[0], name:'60分以下'},
				                {value:_data[1], name:'60-70分'},
				                {value:_data[2], name:'70-80分'},
				                {value:_data[3], name:'80-90分'},
				                {value:_data[4], name:'90-100分'}
				            ],
				            itemStyle: {
				                emphasis: {
				                    shadowBlur: 10,
				                    shadowOffsetX: 0,
				                    shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				            }
				        }
				    ]
				};
			pieChart.setOption(option);
		}
	});
};

ManageCenter.drowBar = function(){
	var param = {
		"url":url,
	};
	doInvoke(param,function(data){
		if(data.code == "0000"){
			var showData = data.data;
			var pieChart = echarts.init(document.getElementById('bar'));
			var option = {
		            title: {
		                text: '上课时间统计'
		            },
		            tooltip: {},
		            legend: {
		                data:['数量']
		            },
		            xAxis: {
		                data: ["周一","周二","周三","周四","周五","周六","周日"]
		            },
		            yAxis: {},
		            series: [{
		                name: '销量',
		                type: 'bar',
		                barWidth:30,
		                data: showData,
			            itemStyle:{
			                	normal:{
			                		color:'#32CD32',
			                  }
			            }
		            }]
		        };
			pieChart.setOption(option);
		}
	});
};
