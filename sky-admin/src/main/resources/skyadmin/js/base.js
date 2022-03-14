<!-- 1.导入css文件 -->
document.write('<link rel="stylesheet" type="text/css" href="../../skyadmin/easyui/themes/default/easyui.css">');
document.write('<link rel="stylesheet" type="text/css" href="../../skyadmin/easyui/themes/icon.css">');

document.write('<link rel="stylesheet" type="text/css" href="../../skyadmin/css/main.css">');
<!-- 2.导入js文件 -->
document.write('<script type="text/javascript" src="../../skyadmin/easyui/jquery.min.js"></script>');
document.write('<script type="text/javascript" src="../../skyadmin/easyui/jquery.easyui.min.js"></script>');

/**
 * 页面加载完毕
 */
window.onload = function () {
    $.ajaxSetup({
        complete: function (xmlHttpRequest, status) {
            console.info("这里是统一拦截，状态码：" + status);
        }
    })
};

/**
 * 发送get请求
 * @param url 请求地址
 * @param callback 回调函数
 */
function sendGet(url, callback) {
    $.ajax({
        url: url,
        method: 'GET',
        success: function (res) {
            callback && callback(res);
        }
    });
}

/**
 * 发送post请求
 * @param url 请求地址
 * @param bodyObj 请求体对象
 * @param callback 回调函数
 */
function sendPost(url, bodyObj, callback) {
    $.ajax({
        url: url,
        method: 'POST',
        contentType: 'application/json;charset=UTF-8',
        data: JSON.stringify(bodyObj),
        success: function (res) {
            callback && callback(res);
        }
    });
}

/**
 * 加载下拉框
 * @param type 下拉框类型
 * @param callback 回调函数
 */
function loadCombobox(type, callback) {
    sendGet("/common/dropdown/" + type, callback);
}