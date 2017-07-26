var initBar = {
    url: {
        //获取导航栏所有内容信息
        getBars: function () {
            return "/navbar/getbars.do";

        }
    },
    init: function () {
        $.get(initBar.url.getBars(), {}, function (result) {
            if (result.status == 0) {
                var list = result.data.list;
                for (var i = 0; i < list.length; i++) {
                    $(".navbar-nav").append('<li><a href="' + list[i].nPath + '">' + list[i].nName + '</a></li>');
                }
                $(".navbar-nav li:first-child").addClass("active");
                //todo 点击哪个导航将该导航激活为活动状态 active
            }
        });
    }
};