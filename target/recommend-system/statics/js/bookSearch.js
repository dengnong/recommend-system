/**
 * Created by 54472 on 2018/2/27.
 */
function bookSearch() {
    var key = $("#searchKey").val();
    window.top.location = "/bookSearch?key=" + key;
    return true;
}