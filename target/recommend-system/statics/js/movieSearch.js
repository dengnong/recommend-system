/**
 * Created by 54472 on 2018/2/27.
 */
document.write("<script language=javascript src='../js/jquery-3.2.1.min.js'></script>");
function movieSearch() {
    var key = $("#searchKey").val().trim();
    if(key === "" || key === undefined || key === null) {
        return false;
    } else {
        window.top.location = "/movieSearch?key=" + key;
    }
    return false;
}