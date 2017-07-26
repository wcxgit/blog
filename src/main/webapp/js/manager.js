//管理员登录
var managerLogin = {
    url: {
        //跳转到后台管理的index页面
        toIndex: function () {
            return "/forward/managerIndex.do";
        }
    },

    //登录验证
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

    //管理员登录
    login: function () {
        if (managerLogin.validate()) {
            $.post(login.url.login(), $("#form").serialize(), function (result) {
                if (result && result.status == 0) {
                    location.href = managerLogin.url.toIndex();
                } else if (result.status == 3) {
                    $("#chkLogin").html("验证码错误!");
                } else {
                    $("#chkLogin").html('用户名或密码错误');
                }
            }, 'json');
        }
    }
};

/*导航管理*/
var manageNavBar = {
    url: {
        //添加导航栏内容
        addNavBar: function () {
            return "/manage/addNavBar.do";
        },

        //根据id查找navbar信息
        getById: function () {
            return "/manage/getById.do";
        },

        //据id修改navbar内容
        updateById: function () {
            return "/manage/updateById.do";
        },

        //据id删除navbar内容
        delById: function () {
            return "/manage/delById.do";
        }


    },

    //添加导航卡
    addNavBar: function () {
        $.get(manageNavBar.url.addNavBar(), $("#form").serialize(), function (result) {
            //隐藏添加模态框
            $("#add").modal("hide");
            //弹出信息提示模态框
            $('#add').on('hidden.bs.modal', function () {
                $("#info").modal();
                $(".info").html(result.msg);
                if (result.status != 0) {
                    $("#errLabel").addClass("text-danger");
                    $("#errLabel").html("出错啦!");
                } else {
                    $("#errLabel").addClass("text-success");
                    $("#errLabel").html("成功");
                    //关闭模态框之后重新加载本页
                    $("#info").on('hidden.bs.modal', function () {
                        location.reload();
                    });
                }
            })
        }, 'json');
    },

    //填充需要修改的导航信息
    editNavBar: function (id) {
        //根据id查询出需要修改的信息
        $.get(manageNavBar.url.getById(), {uId: id}, function (result) {
            if (result.status != 0) {
                //查询出错
                $("#info").modal();
                $(".info").html(result.msg);
                $("#errLabel").addClass("text-danger");
                $("#errLabel").html("出错啦!");
            } else {
                //查询成功
                //弹出修改模态框
                $("#edit").modal();
                //填充数据
                $("#editName").val(result.data.nName);
                $("#editPath").val(result.data.nPath);
                $("#nId").val(result.data.nId);

                //点击确认修改按钮
                $("#editSubmit").click(function () {
                    //更新数据库记录
                    $.get(manageNavBar.url.updateById(), $("#editForm").serialize(), function (result) {
                        if (result.status != 0) {
                            //查询出错
                            $("#info").modal();
                            $(".info").html("提交的数据不合法!");
                            $("#errLabel").addClass("text-danger");
                            $("#errLabel").html("出错啦!");
                        } else {
                            //查询成功
                            //隐藏修改模态框
                            $("#edit").modal("hide");
                            //弹出提示信息
                            $("#edit").on('hidden.bs.modal', function () {
                                $("#info").modal();
                                $(".info").html("修改成功!");
                                $("#errLabel").addClass("text-success");
                                $("#errLabel").html("修改成功");
                                location.reload();
                            })

                        }
                    }, 'json');
                });
            }
        }, 'json');
    },

    //删除指定信息
    delById: function (id) {
        //todo 删除有问题,没有提示了
        $("#del").modal();
        //点击确认删除按钮
        $("#isDel").click(function () {
            //关闭模态框
            $("#del").modal("hide");
            //执行删除操作
            $.get(manageNavBar.url.delById(), {nId: id}, function (result) {
                $("#info").modal();
                $(".info").html(result.msg);
                if (result.status != 0) {
                    $("#errLabel").html("提示信息!");
                }
                location.reload();
            }, 'json');
        });
    },
};

/*用户管理*/
var manageUser = {
    url: {
        //封号
        remove: function () {
            return "/manage/removeUser.do";
        }
    },

    //封号或解封
    removeOrUndoUser: function (uId, type) {
        //封号
        $.get(manageUser.url.remove(), {uId: uId, type: type}, function (result) {
            $("#info").modal();
            $(".info").html(result.msg);
            $("#info").on('hidden.bs.modal', function () {
                location.reload();
            });
        });
    }
};