/**
 * Created by 54472 on 2018/3/7.
 */
document.write("<script language=javascript src='../js/jquery-3.2.1.min.js'></script>");

function submitComment() {
    var user = $('#userInfo').val();
    var itemId = $('#itemId').val();
    var type = $('#type').val();
    var content = $('#content').val();
    var score = $('#rating').rating('get rating');

    if(user !== "") {
        $.ajax({
            type: "POST",
            url: "/saveComment",
            headers: {'Content-type': 'application/json'},
            data: JSON.stringify({
                "userId": user,
                "itemId": itemId,
                "type": type,
                "content": content,
                "score": score
            }),
            dataType: 'json'
        })
        window.location.reload();
    } else {
        window.top.location = "/login";
    }
    return false;
}