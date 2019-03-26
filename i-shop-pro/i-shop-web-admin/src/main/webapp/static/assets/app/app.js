var App = function () {
    //ICheck
    var _masterCheckbox;
    var _checkbox;
    //存放ID的数组
    var _idArray;

    // 默认的 Dropzone 参数
    var defaultDropzoneOpts = {
        url: "",
        paramName: "dropFile",
        maxFiles: 1, // 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true,
        parallelUploads: 1, // 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传 1 个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消"
    };
    /**
     * 查看用户详情
     * @param url
     */
    var handlerShowDetail = function (url) {
        //使用Ajax将JSP装载进模态框
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success: function (data) {
                $('#modal-detail-body').html(data);
                $('#modal-detail').modal("show");
            }
        })
    }
    /**
     * 初始化分页表格
     */
    var handlerInitDataTables = function (url, columns) {
        var _dataTable = $("#dataTable").DataTable({
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
        });
        return _dataTable;
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
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new Array();

        // 将选中元素的 ID 放入数组中
        _checkbox.each(function () {
            var _id =$(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        // 判断用户是否选择了数据项
        if (_idArray.length === 0) {
            $("#modal-message").html("您还没有选择任何数据项，请至少选择一项");
        }
        else {
            $("#modal-message").html("您确定删除数据项吗？");
        }

        // 点击删除按钮时弹出模态框
        $("#modal-default").modal("show");

        // 如果用户选择了数据项则调用删除方法
        $("#btnModalOk").bind("click", function () {
            handlerDeleteData(url);
        });
    };

    /**
     * AJAX 异步删除
     * @param url
     */
    var handlerDeleteData = function (url) {
        $("#modal-default").modal("hide");

        if (_idArray.length > 0) {
            // AJAX 异步删除操作
            setTimeout(function () {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids" : _idArray.toString()},
                    "dataType": "JSON",
                    "success": function (data) {
                        // 请求成功后，无论是成功或是失败都需要弹出模态框进行提示，所以这里需要先解绑原来的 click 事件
                        $("#btnModalOk").unbind("click");

                        // 请求成功
                        if (data.status === 200) {
                            // 刷新页面
                            $("#btnModalOk").bind("click", function () {
                                window.location.reload();
                            });
                        }

                        // 请求失败
                        else {
                            // 确定按钮的事件改为隐藏模态框
                            $("#btnModalOk").bind("click", function () {
                                $("#modal-default").modal("hide");
                            });
                        }

                        // 因为无论如何都需要提示信息，所以这里的模态框是必须调用的
                        $("#modal-message").html(data.message);
                        $("#modal-default").modal("show");
                    }
                });
            }, 500)
        }
    };

    /**
     * 初始化 zTree
     * @param url
     * @param autoParam
     * @param callback
     */
    var handlerInitZTree = function (url, autoParam, callback) {
        var setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                url: url,
                autoParam: autoParam
            }
        };

        $.fn.zTree.init($("#myTree"), setting);

        $("#btnModalOk").bind("click", function () {
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            var nodes = zTree.getSelectedNodes();

            // 未选择
            if (nodes.length == 0) {
                alert("请选择一个节点");
            }
            // 已选择
            else {
                callback(nodes);
            }
        });
    };
    /**
     * 初始化 Dropzone
     * @param opts
     */
    var handlerInitDropzone = function (opts) {
        // 关闭 Dropzone 的自动发现功能
        Dropzone.autoDiscover = false;
        // 继承默认参数 获取默认属性
        $.extend(defaultDropzoneOpts, opts);
        new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);
    };

    /**
     * 向外暴露的方法
     */
    return {
        /**
         * 初始化
         */
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },
        /**
         * 批量删除
         * @param url
         */
        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        },
        /**
         * 初始化DataTables
         * @param url
         * @param columns
         * @returns {jQuery|*}
         */
        initDataTables: function (url, columns) {
            return handlerInitDataTables(url, columns);
        },
        /**
         * 初始化 zTree
         * @param url
         * @param autoParam
         * @param callback
         */
        initZTree: function(url, autoParam, callback) {
            handlerInitZTree(url, autoParam, callback);
        },
        /**
         * 查看用户详情
         * @param url
         */
        showDetail: function (url) {
            handlerShowDetail(url);
        },
        /**
         * 初始化 Dropzone
         * @param opts
         */
        initDropzone: function(opts) {
            handlerInitDropzone(opts);
        }
    }
}();

$(document).ready(function () {
    App.init();
});
