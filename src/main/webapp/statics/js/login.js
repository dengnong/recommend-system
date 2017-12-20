/**
 * Created by 54472 on 2017/12/20.
 */
//登录表单校验
function submit(){
    $('#form').form({
        account: {
            identifier: 'account',
            rules: [
                {
                    type: 'empty',
                    prompt: '用户名必填！'
                }
            ]
        },
        password: {
            identifier: 'password',
            rules: [
                {
                    type: 'length[6]',
                    prompt: '密码最少6位！'
                }
            ]
        },
    }, {
        inline: true,
        on: 'submit'
    });
}

//注册表单校验
function regSubmit(){
    $('#registerForm').form({
        account: {
            identifier: 'regAccount',
            rules: [
                {
                    type: 'empty',
                    prompt: '用户名必填！'
                }
            ]
        },
        password: {
            identifier: 'regPassword',
            rules: [
                {
                    type: 'length[6]',
                    prompt: '密码最少6位！'
                }
            ]
        },
        match: {
            identifier: 'regRePassword',
            rules: [
                {
                    type: 'match[regPassword]',
                    prompt: '两次密码输入不一致！'
                }
            ]
        }
    }, {
        inline: true,
        on: 'blur',
        onSuccess:submitForm
    });
}

// 注册信息提交
function submitForm() {
    var account = $("#regAccount").val();
    var password = $("#regPassword").val();
    $.ajax({
        type: "POST",
        url: "/userRegister",
        headers: {'Content-type': 'application/json'},
        data:JSON.stringify( {
            "account":account,
            "password":password
        }),
        dataType: 'json',
        success:function(data){
            if(data.success) {
                window.top.location = "/homepage";
            }else{
                alert("发生错误");
            }
        },
        error:function()
        {
            alert("服务器无响应");
        },
    });
    return false;
}

// 注册模态框
function register(){
    $('.small.modal')
        .modal('show')
    ;
}

function cancel(){
    $('.small.modal')
        .modal('hide')
    ;
}

