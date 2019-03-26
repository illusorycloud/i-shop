var App = function () {
    //ICheck
    var _masterCheckbox;
    var _checkbox;
    //存放ID的数组
    var _idArray;


    /**
     * 初始化分页表格
     */
    var handlerInitDataTables = function (url, columns) {
        $("#dataTable").DataTable({
            // 是否开启本地分页
            "paging": true,
            // 是否开启本地排序
            "ordering": false,
            // 是否显示左下角信息
            "info": true,
            // 是否允许用户改变表格每页显示的记录数
            "lengthChange": false,
            // 是否显示处理状态(排序的时候，数据很多耗费时间长的话，也会显示这个)
            "processing": true,
            // 是否允许 DataTables 开启本地搜索
            "searching": false,
            // 是否开启服务器模式
            "serverSide": true,
            // 控制 DataTables 的延迟渲染，可以提高初始化的速度
            "deferRender": true,
            // 增加或修改通过 Ajax 提交到服务端的请求数据
            "ajax": {
                "url": url
            },
            // 分页按钮显示选项
            "pagingType": "full_numbers",
            // 设置列的数据源
            "columns": columns,
            // 表格重绘的回调函数
            "drawCallback": function (settings) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            },
            // 国际化
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        })
    };

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
        },
        initDataTables: function (url, columns) {
            handlerInitDataTables(url, columns);
        }
    }
}();

$(document).ready(function () {
    App.init();
});
