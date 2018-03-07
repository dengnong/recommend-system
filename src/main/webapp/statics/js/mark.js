/**
 * Created by 54472 on 2018/3/1.
 */
document.write("<script language=javascript src='../js/jquery-3.2.1.min.js'></script>");

function mark(init) {
    var user = $('#userInfo').val();
    var itemId = $('#itemId').val();
    var type = $('#type').val();
    if(user !== "") {
        if (init === 1) {
            $.ajax({
                type: "POST",
                url: "/markCancel",
                headers: {'Content-type': 'application/json'},
                data: JSON.stringify({
                    "userId": user,
                    "itemId": itemId,
                    "type": type
                }),
                dataType: 'json'
            })
        } else {
            $.ajax({
                type: "POST",
                url: "/markItem",
                headers: {'Content-type': 'application/json'},
                data: JSON.stringify({
                    "userId": user,
                    "itemId": itemId,
                    "type": type
                }),
                dataType: 'json'
            })
        }
    } else {
        window.top.location = "/login";
        return false;
    }
    return false;
}

function active() {
    var flag = $('#markInit').val();
    if(flag === "true") {
        $('#markTag')
            .rating({
                initialRating: 0,
                maxRating: 1
            })
        ;
    } else {
        $('#markTag')
            .rating({
                initialRating: 1,
                maxRating: 1
            })
        ;
    }
}

