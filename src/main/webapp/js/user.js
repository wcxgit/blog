/**
 * Created by 76339 on 2017/7/23.
 */
//注册相关js
var regist = {
    //跳转和请求路径
    url: {
        //跳转到首页
        toIndex: function () {
            return "/index.jsp";
        },

        //请求跳转controller,跳转到注册页面
        toRegisterJsoController: function () {
            return "/forward/regist.do";
        },

        //跳转到注册controller
        toRegisterController: function () {
            return "/user/register.do";
        }
    },
    data: {},
    //注册数据校验
    validate: function () {

        var username = $("#username").val();
        var password = $("#password").val();
        var rePassword = $("#rePassword").val()
        var email = $("#email").val();
        var reg = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
        if (username.length == 0) {
            return "用户名不能为空";
        } else if (email.length == 0) {
            return "邮箱不能为空";
        } else if (!reg.test(email)) {
            return "邮箱地址不合法";
        } else if (password.length == 0) {
            return "密码不能为空";
        } else if (password.length > 16 || password < 6) {
            return "密码长度要再6-16位之间";
        } else if (rePassword.length == 0) {
            return "确认密码不能为空";
        } else if (rePassword != password) {
            return "两次密码输入不一致";
        }
        return true;
    },
    init: function () {
        //点击注册按钮,跳转到注册页面
        location.href = regist.url.toRegisterJsoController();
    },

    //注册流程
    register: function () {
        //点击提交按钮,进行数据校验
        var result = regist.validate();
        if (result != true) {
            $("#test").html(result);
        } else {
            $.post(regist.url.toRegisterController(), $("#form").serialize(), function (result) {
                if (result && result.status == 0) {
                    //注册成功后跳转到首页
                    history.back(-1);
                }
            }, 'json');
        }
    }
};

//登陆相关
var login = {
    url: {
        //请求跳转controller,跳转到登陆页面
        toRegisterJsoController: function () {
            return "/forward/login.do";
        },

        //获取验证码
        getCheckImage: function () {
            return "/getCheckImage?" + new Date().getTime();
        },

        //登录
        login: function () {
            return "/user/login.do";
        },

        //注销
        signOut: function () {
            return "/user/signOut.do";
        }

    },
    //调换到登录页面
    toLogin: function () {
        location.href = login.url.toRegisterJsoController();
    },

    //切换验证码
    toGetCheckImage: function (node) {
        node.attr("src", login.url.getCheckImage());
    },

    //验证表单信息
    validate: function () {

        $("#username").blur(function () {
            $("#name").html("");
        });
        $("#password").blur(function () {
            $("#word").html("");
        });
        $("#code").blur(function () {
            $("#chkLogin").html("");
        });
        var name = $("#username").val();
        var password = $("#password").val();
        var code = $("#code").val();
        if (name.length == 0) {
            $("#name").html("用户名不能为空!");
            return false;
        } else if (password.length == 0) {
            $("#word").html("密码不能为空");
            return false;
        }
        return true;
    },

    //提交表单信息
    login: function () {
        if (login.validate()) {
            $.post(login.url.login(), $("#form").serialize(), function (result) {
                if (result && result.status == 0) {
                    history.back(-1);
                } else if (result.status == 3) {
                    $("#chkLogin").html("验证码错误!");
                } else {
                    $("#chkLogin").html('用户名或密码错误');
                }
            }, 'json');
        }
    },

    //注销
    signOut: function () {
        $.post(login.url.signOut(), {}, function (result) {
            if (result.status == 0) {
                //注销成功
                Location.href = regist.url.toIndex();
            }
        });
    }
};

//心情相关
var mood = {
    url: {
        addMood: function () {
            return "/content/addMood.do";
        },
    },

    //保存心情
    saveMood: function () {
        //获取文本框内容
        var content = $("#saytext").val();
        //保存内容到心情
        $.post(mood.url.addMood(), $("#form").serialize(), function (result) {

        });
    }
};