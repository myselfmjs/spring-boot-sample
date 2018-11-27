/**
*时间轴插件
data:[{date:'',name:''},{date:'',name:''}]
*/

(function ($) {
	var methods = {
		settings : {},
        init: function (options) {
        	settings = $.extend({data:[{}]}, options);
        },
        getTime:function(dateStr) {
        	var s = dateStr.split("-");
        	return new Date(s[0],s[1],s[2]).getTime();
        },
        getWdith:function(w){
            return parseInt(w.substring(w,w.indexOf("px")));
        },
        horizontal:function(options){
        	$(this).css("height","4px");
        	$(this).css("width","100%");
        	$(this).css("background","#ccc");
        	$(this).css("margin-top","29px");

        	var min = undefined;
        	var max = new Date().getTime();
            var datas = settings.data;
            for (var i = 0; i < datas.length; i++) {
                var data = datas[i];
                var value = data.date;
                if(value != undefined) {
                    data.datetime = methods.getTime(value);
                    if(min == undefined || min > data.datetime) {
                        min = data.datetime;
                    }
                }
            }
            datas.sort(function(o1,o2){
                return o1.datetime - o2.datetime;
            });
            var last_width = 75;
            var width = methods.getWdith($(this).css("width"))-30-last_width;
            if(min != undefined && max != undefined) {
                var i = 0;
                for (i = 0; i < datas.length; i++) {
                    var left = (datas[i].datetime - min) / (max - min);
                    var lw = (width * left).toFixed(0);
                    var li = $(methods.horizontalElement(i,datas[i].date,datas[i].name));
                    $(this).append(li);
                    var right = parseInt(lw) + methods.getWdith(li.css("width"));
                    datas[i].right = right.toFixed(0);
                    datas[i].left = lw;
                }
                datas[i] = {};
                datas[i].right = width + last_width + 28;
                datas[i].left = width + last_width;
                $(this).append(methods.horizontalElement(i,'至今','&nbsp;'));
            }

            //var children = $(this).children();

            for (var i = 1; i < datas.length - 1; i++) {
                methods.setPosition(datas,i);
            }
            for (var i = 0; i < datas.length; i++) {
                $("#time-axis-div"+i).css("left",datas[i].left+"px");
            }
        },
        horizontalYear:function(options){
        	$(this).css("width","100%");
        	$(this).css("position","relative");
        	
        	$(this).append("<div style='width:80px;position: absolute;margin-top: 16px;'><select style='width:80px;margin:0px;padding:0px;padding-left:10px;'></select></div>");
        	$(this).append("<div style='top:0px;left:80px;position: absolute;'></div>");
        	
        	var selectDiv = $(this).children("div:first-child");
        	var select = selectDiv.find("select");
        	var axisDiv = $(this).children("div:last-child");
        	
        	axisDiv.css("height","4px");
        	axisDiv.css("background","#ccc");
        	axisDiv.css("margin-top","29px");
        	//axisDiv.css("position","relative");
        	
        	var datas = settings.data;
        	datas.sort(function(o1,o2){
                return o2.year - o1.year;
            });
        	
        	$.each(datas,function(k,v){
        		select.append("<option value='"+k+"'>"+v.year+"</option>");
        	});

        	var width = methods.getWdith($(this).css("width")) - 80 ;
        	axisDiv.css("width",width +"px")
    		methods.initAxisDatas(axisDiv,width,datas[0].dates);
        	select.change(function(){
        		var key = $(this).val();
        		methods.initAxisDatas(axisDiv,width,datas[key].dates);
        	})
        },
        initAxisDatas:function(axisDiv,width,datas){
        	axisDiv.empty();
        	var min = undefined;
        	var max = undefined;
        	for (var i = 0; i < datas.length; i++) {
        		var data = datas[i];
        		var value = data.date;
        		if(value != undefined) {
        			data.datetime = methods.getTime(value);
        			if(min == undefined || min > data.datetime) {
        				min = data.datetime;
        			}
        			if(max == undefined || max < data.datetime) {
        				max = data.datetime;
        			}
        		}
        	}
        	datas.sort(function(o1,o2){
        		return o1.datetime - o2.datetime;
        	});
        	if(min != undefined && max != undefined) {
        		for (var i = 0; i < datas.length; i++) {
        			var li = $(methods.horizontalYearElement(i,datas[i].date,datas[i].name));
        			axisDiv.append(li);
        			var lw = methods.getWdith(li.css("width"));
        			datas[i].lw = lw;
        		}
        		width = width - datas[datas.length - 1].lw;
        		for (var i = 0; i < datas.length; i++) {
        			var left = (datas[i].datetime - min) / (max - min);
        			var lw = (width * left).toFixed(0);
        			var right = parseInt(lw) + datas[i].lw;
        			datas[i].right = right.toFixed(0);
        			datas[i].left = lw;
        		}
        	}
        	
        	for (var i = 1; i < datas.length - 1; i++) {
        		methods.setPosition(datas,i);
        	}
			for (var i = 0; i < datas.length; i++) {
				$("#time-axis-div" + i).css("left", datas[i].left + "px");
				if (settings.click != undefined && $.isFunction(settings.click)) {
					$("#time-axis-div" + i).click(function() {
						var index = parseInt($(this).attr("index"));
						settings.click.apply(this,[datas[index]]);
					})
				}
			}
        },
        setPosition:function(datas,i){
            var r1 = parseInt(datas[i-1].right);
            var l2 = parseInt(datas[i].left);
            var r2 = parseInt(datas[i].right);
            var l3 = parseInt(datas[i+1].left);
            if(r1 > l2) {
                var rt = datas[i].right - datas[i].left;
                datas[i].left = r1 + 2;
                datas[i].right = datas[i].left + rt;
            } else if (r2 > l3) {
                var rt = datas[i].right - datas[i].left;
                datas[i].left = l2 - (r2 - l3) - 2;
                datas[i].right = datas[i].left + rt;
                if(i > 1){
                    methods.setPosition(datas,i-1);
                }
            }
        },
        horizontalElement:function(index,date,name){
        	return "<div id='time-axis-div"+index+"' style='height:60px;position:absolute;top:0px;float:left;text-align:center;'>"
                   + "<div>"+name+"</div>"
                   + "<div><img src='"+ctxStatic+"/main/wd_images/img7.png'></div>"
                   + "<div>"+date+"</div>"
                   + "</div>";
        },
        horizontalYearElement:function(index,date,name){
        	return "<div id='time-axis-div"+index+"' index='"+index+"' style='height:60px;position:absolute;top:-29px;float:left;text-align:center;cursor:pointer;'>"
                   + "<div>"+name+"</div>"
                   + "<div><img src='"+ctxStatic+"/main/wd_images/img7.png'></div>"
                   + "<div>"+date+"</div>"
                   + "</div>";
        }
    };
    //水平时间轴
    $.fn.horizontalAxis = function (options) {
        methods.init(options);
        methods.horizontal.apply(this,[options]);
    };
    $.fn.horizontalYear = function(options){
        methods.init(options);
        methods.horizontalYear.apply(this,[options]);
    }
    //垂直时间轴
    $.fn.verticalAxis = function (options) {

    };
})(jQuery);