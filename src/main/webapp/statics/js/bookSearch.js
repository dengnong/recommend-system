/**
 * Created by 54472 on 2018/2/27.
 */
document.write("<script language=javascript src='../js/jquery-3.2.1.min.js'></script>");
function bookSearch() {
    var key = $("#searchKey").val().trim();
    window.top.location = "/bookSearch?key=" + key;
    return false;
}