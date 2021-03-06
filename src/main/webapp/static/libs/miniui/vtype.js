/**
 * miniui公共校验方法
 */
/* 自定义vtype */

/**
 * 校验18位身份证号 备注：<input class="mini-textbox" vtype="IdCard"/>
 */
mini.VTypes["IdCardErrorText"] = "请输入正确的身份证号";
mini.VTypes["IdCard"] = function (v) {
    return $.trim(v) == "" || IsIdCard(v);
}
/**
 * 校验必须输入汉字 备注：<input class="mini-textbox" vtype="chinese"/>
 */
mini.VTypes["chineseErrorText"] = "请输入汉字";
mini.VTypes["chinese"] = function (v) {
    if ($.trim(v) == "") {
        return true;
    }
    var re = /^[\u4e00-\u9faf]+$/;
    if (re.test(v)) return true;
    return false;
}
/**
 * 校验不允许输入汉字 备注：<input class="mini-textbox" vtype="nochinese"/>
 */
mini.VTypes["nochineseErrorText"] = "不允许输入汉字";
mini.VTypes["nochinese"] = function (v) {
    if ($.trim(v) == "") {
        return true;
    }
    var re = /^[^\u4e00-\u9faf]+$/;
    if (re.test(v)) return true;
    return false;
}
/**
 * 校验居住地址不允许输入全数字和特殊字符 备注：<input class="mini-textbox" vtype="noAllNum">
 * @type {string}
 */
mini.VTypes["noAllNumErrorText"] = "请输入正确的地址";
mini.VTypes["noAllNum"] = function (v) {
    if ($.trim(v) == "") {
        return true;
    }
    return /^(?!\d*$)/.test(v)&&/^([^><$_%?*'"])+$/.test(v);
}
/**
 * 校验名字
 */
mini.VTypes["name"] = function (v) {
    if ($.trim(v) == "") {
        return true;
    }
    var length = v.length;
    if (length >= 32) {
        mini.VTypes["nameErrorText"] = "输入名字过长";
        return false;
    }
    var re = /^[\u4e00-\u9fafa-zA-Z]+$/;
    if (re.test(v)) return true;
    mini.VTypes["nameErrorText"] = "名字只能输入汉字和字母";
    return false;
}
/**
 * 远程校验 备注：<input class="mini-textbox" vtype="remote:'url';"/>
 */
mini.VTypes["remote"] = function (v, param) {
    if (param == undefined || param.length == 0) {
        mini.VTypes["remoteErrorText"] = "没有配置url参数";
        return false;
    }
    var flag = undefined;
    $.ajax({
        async: false,
        url: param[0],
        data: {
            value: v
        },
        success: function (rs) {
            rs = eval(rs);
            mini.VTypes["remoteErrorText"] = rs.message;
            flag = rs.ok;
        }
    });
    return flag;
}
/**
 * 校验必须移动电话 备注：<input class="mini-textbox" vtype="chinese"/>
 */
mini.VTypes["mobileErrorText"] = "手机格式不正确";
mini.VTypes["mobile"] = function (value) {
    var length = value.length;
    return $.trim(value) == "" || (length == 11 && /^(1\d{10})$/.test(value));
}

/**
 * 校验必须移动电话 备注：<input class="mini-textbox" vtype="chinese"/>
 */
mini.VTypes["mobile1ErrorText"] = "手机格式不正确";
mini.VTypes["mobile1"] = function (value) {
    var length = value.length;
    return $.trim(value) == "" || (length == 11 && /^(1\d{10})$/.test(value) && 13000000000<parseInt(value) && parseInt(value)<18999999999 && checkNum5(value));
}

function checkNum5(value){
    if(value.indexOf("00000")>-1){
        return false;
    }
    for(var i=1;i<10;i++){
        var marchNum = String(i*10000+i*1000+i*100+i*10+i*1);
        if(value.indexOf(marchNum)>-1){
            return false;
        }
    }
    return true;
}
/**
 * 校验必须移动电话 备注：<input class="mini-textbox" vtype="chinese"/>
 */
mini.VTypes["phoneErrorText"] = "电话格式不正确";
mini.VTypes["phone"] = function (value) {
    //var length = value.length;
    //return $.trim(value) == "" || (/^(0[\d]{2,3}-[\d]{7,8})$/.test(value));
    var regEx= /^[0-9][0-9-]+$/;
    if($.trim(value) == "" || regEx.test(value))return true;
    return false;
}

/**
 * 校验必须移动电话 备注：<input class="mini-textbox" vtype="chinese"/>
 */
mini.VTypes["phone1ErrorText"] = "电话格式不正确";
mini.VTypes["phone1"] = function (value) {
    var regEx= /^[0-9][0-9-]+$/;
    if($.trim(value) == "" || regEx.test(value) || checkNum5(value))return true;
    return false;
}

/**
 * 校验必须输入0或者正数，可保留小数点后一位 备注：<input class="mini-textbox" vtype="decimal1"/>
 */
mini.VTypes["decimal1ErrorText"] = "必须输入正数，可保留小数点后一位";
mini.VTypes["decimal1"] = function (value) {
    if ($.trim(value) != '') {
        var arr = value.split('\.');
        if (arr[0].length > 1 && arr[0][0] == '0') {
            return false;
        }
    }
    return $.trim(value) == '' || /^\d+$/.test(value) || /^\d+\.{1}\d{1}$/.test(value);
}
function initDecimal1(formId) {
    var form = new mini.Form("#" + formId);
    var fields = form.getFields();
    for (var i = 0; i < fields.length; i++) {
        var vtype = fields[i].vtype;
        if (vtype != undefined && vtype.indexOf("decimal1") >= 0) {
            fields[i].on("blur", function (e) {
                var text = this.getValue();
                if ($.trim(text) == "") {
                    return;
                }
                var arr = text.split('\.');
                if (arr.length == 2) {
                    if (arr[1].length == 0) {
                        this.setValue(text + "0");
                    }
                } else if (arr.length == 1) {
                    this.setValue(text + ".0");
                }
            });
        }
    }
}
/**
 * 校验必须输入0或者正数，可保留小数点后二位 备注：<input class="mini-textbox" vtype="decimal2"/>
 */
mini.VTypes["decimal2ErrorText"] = "必须输入正数，可保留小数点后两位";
mini.VTypes["decimal2"] = function (value) {
    if ($.trim(value) != '') {
        var arr = value.split('\.');
        if (arr[0].length > 1 && arr[0][0] == '0') {
            return false;
        }
    }
    return $.trim(value) == '' || /^\d+$/.test(value) || /^\d+\.{1}\d{2}$/.test(value);
}
/**
 * 校验必须输入0或者正数，可保留小数点后一位或后二位 备注：<input class="mini-textbox" vtype="decimal2or1"/>
 */
mini.VTypes["decimal2or1ErrorText"] = "必须输入正数，可保留小数点后两位";
mini.VTypes["decimal2or1"] = function (value) {
    if ($.trim(value) != '') {
        var arr = value.split('\.');
        if (arr[0].length > 1 && arr[0][0] == '0') {
            return false;
        }
    }
    return $.trim(value) == '' || /^\d+$/.test(value) || /^\d+\.{1}\d{2}$/.test(value)|| /^\d+\.{1}\d{1}$/.test(value);
}
function initDecimal2(formId) {
    var form = new mini.Form("#" + formId);
    var fields = form.getFields();
    for (var i = 0; i < fields.length; i++) {
        var vtype = fields[i].vtype;
        if (vtype != undefined && vtype.indexOf("decimal2") >= 0) {
            fields[i].on("blur", function (e) {
                var text = this.getValue();
                if ($.trim(text) == "") {
                    return;
                }
                var arr = text.split('\.');
                if (arr.length == 2) {
                    if (arr[1].length == 1) {
                        this.setValue(text + "0");
                    } else if (arr[1].length == 0) {
                        this.setValue(text + "00");
                    }
                } else if (arr.length == 1) {
                    this.setValue(text + ".00");
                }
            });
        }
    }
}
/**
 * 群组中至少有一个是必填校验 备注：<input class="mini-textbox" vtype="group:fid,sid;"/>
 */
mini.VTypes["groupErrorText"] = "群组内组件至少有一个必填";
mini.VTypes["group"] = function (v, param) {
    if (param == undefined || param.length == 0) {
        mini.VTypes["groupErrorText"] = "id配置参数错误";
        return false;
    }
    var rs = false;
    for (var i = 0; i < param.length; i++) {
        if (param[0] == "mobile" && param[1] == "telephone") {
            mini.VTypes["groupErrorText"] = "手机号和固定电话至少填写一个";
        } else if (param[0] == "mobilePhone" && param[1] == "phone") {
            mini.VTypes["groupErrorText"] = "手机号和联系电话至少填写一个";
        } else if (param[0] == "phone" && param[1] == "mobilePhone") {
            mini.VTypes["groupErrorText"] = "手机号和固定电话至少填写一个";
        } else if (param[0] == "mobile" && param[1] == "phone") {
            mini.VTypes["groupErrorText"] = "手机号和固定电话至少填写一个";
        } else if (param[0] == "fpg" && param[1] == "fpg2h" && param[2] == "fpgRan") {
            mini.VTypes["groupErrorText"] = "血糖(随机)、血糖(空腹)和血糖(餐后2h)至少填写一个";
        } else if (param[0] == "fpg" && param[1] == "fpg2hOgtt" && param[2] == "fpgRan") {
            mini.VTypes["groupErrorText"] = "空腹血糖、餐后血糖和随机血糖至少填写一个";
        } else if (param[0] == "fpg" && param[1] == "glu" && param[2] == "pbg2h") {
            mini.VTypes["groupErrorText"] = "空腹血糖、餐后血糖和随机血糖至少填写一个";
        } else if (param[0] == "nation" && param[1] == "nationOther") {
            mini.VTypes["groupErrorText"] = "民族和其他民族至少填写一个";
        } else {
            mini.VTypes["groupErrorText"] = "群组内组件至少有一个必填";
        }

        var value = "";
        var pi = mini.get(param[i]);
        if (pi == undefined || pi == null) {
            value = $("#" + param[i]).val();
        } else {
            value = pi.getValue();
        }
        //mini.VTypes["remoteErrorText"] = "id配置参数错误";
        //return false;
        if ($.trim(value) != "") {
            rs = true;
        }
    }
    if(rs){
        for (var i = 0,len =param.length ; i < len; i++) {
            mini.get(param[i]).setIsValid(true);
        }
    }
    return rs;
}
/**
 * 校验不允许输入数字 备注：<input class="mini-textbox" vtype="mustGroup:pI,pK,mI1,mI2,mI3..."/>
 * 其中pI为条件源控件ID，pK为对应pI控件的值，mI1、mI2、mI3...都是为当pI控件对应的值为pK值得时候，这些mI1、mI2...等ID对应的控件至少填写一个
 */
mini.VTypes["mustGroupErrorText"] = "群组内组件至少有一个必填";
mini.VTypes["mustGroup"] = function (v, param) {
    if (param == undefined || param.length < 3) {
        mini.VTypes["mustGroupErrorText"] = "配置参数错误";
        return false;
    }
    var pi = mini.get(param[0]);
    var value = undefined;
    if (pi == undefined) {
        if ($("input[name='" + param[0] + "']").size() > 0) {
            value = $("input[name='" + param[0] + "']").val();
        } else {
            mini.VTypes["mustGroupErrorText"] = "配置参数错误";
            return false;
        }
    } else {
        value = pi.getValue();
    }
    if (value == param[1]) {
        for (var i = 2; i < param.length; i++) {
            var p = mini.get(param[i]);
            if (p != undefined && !$.isEmpty(p.getValue())) {
                return true;
            }
        }
        return false;
    }
    return true;
}
/**
 * 校验不允许输入数字 备注：<input class="mini-textbox" vtype="nonum"/>
 */
mini.VTypes["nonumErrorText"] = "不允许输入数字";
mini.VTypes["nonum"] = function (v) {
    if ($.trim(v) == "") {
        return true;
    }
    var re = new RegExp("^[0-9]*$");
    if (re.test(v)) return false;
    return true;
}
function IsIdCard(numberTmp) {
    var number = numberTmp;
    var date, Ai;
    var verify = "10X98765432";
    var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2];
    var area = ['', '', '', '', '', '', '', '', '', '', '', '北京', '天津', '河北', '山西', '内蒙古', '', '', '', '', '', '辽宁', '吉林', '黑龙江', '', '', '', '', '', '', '', '上海', '江苏', '浙江', '安微', '福建', '江西', '山东', '', '', '', '河南', '湖北', '湖南', '广东', '广西', '海南', '', '', '', '重庆', '四川', '贵州', '云南', '西藏', '', '', '', '', '', '', '陕西', '甘肃', '青海', '宁夏', '新疆', '', '', '', '', '', '台湾', '', '', '', '', '', '', '', '', '', '香港', '澳门', '', '', '', '', '', '', '', '', '国外'];
    var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/i);
    if (re == null)
        return false;
    if (re[1] >= area.length || area[re[1]] == "")
        return false;
    if (re[2].length == 12) {
        Ai = number.substr(0, 17);
        date = [re[9], re[10], re[11]].join("");
    }
    else {
        Ai = number.substr(0, 6) + "19" + number.substr(6);
        date = ["19" + re[4], re[5], re[6]].join("");
    }
    if (!CheckyyyyMMdd(date))
        return false;
    var sum = 0;
    for (var i = 0; i <= 16; i++) {
        sum += Ai.charAt(i) * Wi[i];
    }
    Ai += verify.charAt(sum % 11);
    return (number.length == 18 && number == Ai);
}
function CheckyyyyMMdd(dayString) {
    // 年月日检验函数
    var digit = "0123456789";
    datelist = new Array(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    if (dayString.length != 8)
        return (false);
    for (i = 0; i < 8; i++) {
        if (digit.indexOf(dayString.charAt(i), 0) == -1)
            return (false);
    }
    year = dayString.substr(0, 4); // 截取年部分
    month = dayString.substr(4, 2); // 截取月部分
    date = dayString.substr(6, 2); // 截取日部分
    if (year > 2200 || year < 1900 || month > 12 || month < 1 || date > 31 ||
        date < 1)
        return (false);
    if (date > datelist[month - 1])
        return (false);

    yyyy = eval(year);
    if (month == "02") {
        if ((yyyy % 400) == 0) {
            if (date > 29)
                return (false);
        }
        else if ((yyyy % 4) == 0 && (yyyy % 100) != 0) {
            if (date > 29)
                return (false);
        }
        else {
            if (date > 28)
                return (false);
        }
    }
    return (true);
} // end function CheckyyyyMMdd

