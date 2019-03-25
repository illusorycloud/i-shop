<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<title>我的商城 | 控制面板</title>

<jsp:include page="../includes/header.jsp"/>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <!--顶部导航-->
    <jsp:include page="../includes/nav.jsp"/>
    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small>Control panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>首页</a></li>
                <li class="active">用户管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult!=null}">
                        <div class="alert alert-${baseResult.status==200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <%--<h4><i class="icon fa fa-ban"></i>提示</h4>--%>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>

                            <div class="row" style="margin-top: 20px">
                                <div class="col-xs-12">
                                    <a href="/user/form" type="button" class="btn btn-sm btn-default"><i
                                            class="fa fa-plus" style="margin-right: 5px"></i>新增</a>&nbsp;&nbsp;&nbsp;
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i
                                            class="fa fa-trash" style="margin-right: 5px"></i>删除</a>&nbsp;&nbsp;&nbsp;
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i
                                            class="fa fa-download" style="margin-right: 5px"></i>导入</a>&nbsp;&nbsp;&nbsp;
                                    <a href="#" type="button" class="btn btn-sm btn-default"><i
                                            class="fa fa-upload" style="margin-right: 5px"></i>导出</a>&nbsp;&nbsp;&nbsp;
                                </div>

                            </div>
                            <div class="row" style="margin-top: 20px;">
                                <form:form cssClass="form-horizontal" action="/user/search" method="post"
                                           modelAttribute="tbUser">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="username" class="col-sm-4 control-label">姓名</label>
                                                <div class="col-sm-8">
                                                    <form:input cssClass="form-control required email" path="username"
                                                                placeholder="姓名"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="email" class="col-sm-4 control-label">邮箱</label>
                                                <div class="col-sm-8">
                                                    <form:input cssClass="form-control required email" path="email"
                                                                placeholder="邮箱"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-3">
                                            <div class="form-group">
                                                <label for="phone" class="col-sm-4 control-label">手机号</label>
                                                <div class="col-sm-8">
                                                    <form:input cssClass="form-control required email" path="phone"
                                                                placeholder="手机号"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" style="padding-right: 77px">
                                            <div class="col-xs-12">
                                                <button type="submit" class="btn btn-info pull-right">提交</button>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                            <!-- /.modal -->
                            <%--<div class="box-tools">--%>
                            <%----%>
                            <%--</div>--%>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <!--主要的CheckBox-->
                                    <th><input type="checkbox" class="minimal icheck_master"></th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>邮箱</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbUsers}" var="tbUser">
                                    <tr>
                                        <!--用userId做为checkbox的ID 方便删除操作-->
                                        <th><input id="${tbUser.id}" type="checkbox" class="minimal"></th>
                                        <td>${tbUser.id}</td>
                                        <td>${tbUser.username}</td>
                                        <td>${tbUser.phone}</td>
                                        <td>${tbUser.email}</td>
                                        <td><fmt:formatDate value="${tbUser.updated}"
                                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                            <%--<span class="label label-success">Approved</span>--%>
                                        <td>
                                            <a href="#" type="button"
                                               class="btn btn-sm btn-default"><i
                                                    class="fa fa-search"
                                                    style="margin-right: 5px"></i>查看</a>
                                            <a href="#" type="button"
                                               class="btn btn-sm btn-primary"><i class="fa fa-edit"
                                                                                 style="margin-right: 5px"></i>编辑</a>
                                            <a href="#" type="button" class="btn btn-sm btn-danger"><i
                                                    class="fa fa-trash"
                                                    style="margin-right: 5px"></i>删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/footer.jsp"/>
<script>
    var _checkbox=App.getCheckbox();
    console.log(_checkbox.length);
</script>
</body>
</html>

