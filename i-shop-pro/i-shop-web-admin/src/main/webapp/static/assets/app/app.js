var App = function () {
    //ICheck
    var _masterCheckbox;
    var _checkbox;
    //存放ID的数组
    var _idArray;
    /**
     * 私有方法 激活ICheck
     */
    var handlerInitCheckbox = function () {
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');
        _checkbox = $('input[type="checkbox"].minimal');
    };
    /**
     * Checkbox全选功能
     */
    var handlerCheckboxAll = function () {
        _masterCheckbox.on("ifClicked", function (e) {
            // 当前状态已选中，点击后应取消选择
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }
            // 当前状态未选中，点击后应全选
            else {
                _checkbox.iCheck("check");
            }
        });
    };
    /**
     * 批量删除
     * @param url
     */
    var handlerDeleteMulti = function (url) {
        console.log(url);
        _idArray = new Array();
        //将选中元素的ID放入数组中
        _checkbox.each(function () {
            var _id = $(this).attr("id");
            if (_id != null && _id !== "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });
        if (_idArray.length === 0) {
            $('#modal-message').html("您还没有选中任何数据,请至少选中一项");
        } else {
            $('#modal-message').html("您确定删除数据项吗？");
        }
        $('#modal-default').modal("show");
        $('#btnModalOk').bind('click', function () {
            del();
        });

        /**
         * 私有方法 删除
         * @param _idArray
         * @param url
         */
        function del() {
            $('#modal-default').modal("hide");
            //如果没选数据的处理
            if (_idArray.length === 0) {
                // TODO
            }
            //如果选了数据点OK就Ajax请求传到后台
            else {
                //延迟500ms 优化用户体验
                setTimeout(function () {
                    $.ajax({
                        "url": url,
                        "type": "POST",
                        "data": {"ids": _idArray.toString()},
                        "dataType": "JSON",
                        "success": function (data) {
                            //删除成功
                            if (data.status === 200) {
                                $('#btnModalOk').unbind("click");
                                $('#btnModalOk').bind('click', function () {
                                    $('#modal-default').modal("hide");
                                    window.location.reload();
                                });
                                $("#modal-message").html(data.message);
                                $('#modal-default').modal("show");
                            }
                            //删除失败
                            else {
                                $('#btnModalOk').unbind("click");
                                $('#btnModalOk').bind('click', function () {
                                    $('#modal-default').modal("hide");
                                });
                                $("#modal-message").html(data.message);
                                $('#modal-default').modal("show");

                            }
                        }
                    })
                }, 500);
            }
        }
    };
    /**
     * 向外暴露的方法
     */
    return {
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },
        getCheckbox: function () {
            return _checkbox;
        },
        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        }
    }
}();

$(document).ready(function () {
    App.init();
});
