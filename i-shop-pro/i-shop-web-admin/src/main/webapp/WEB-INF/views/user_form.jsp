<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<title>我的商城 | 用户管理</title>

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
                <small> </small>
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
                  <!-- Horizontal Form -->
                  <div class="box box-info">
                      <div class="box-header with-border">
                          <h3 class="box-title">  ${tbUser.id==null? "新增":"编辑"}用户</h3>
                      </div>
                      <!-- /.box-header -->
                      <!-- form start -->
                      <form class="form-horizontal" action="/user/save" method="post">
                          <div class="box-body">
                              <div class="form-group">
                                  <label for="inputEmail" class="col-sm-2 control-label">邮箱</label>
                                  <div class="col-sm-10">
                                      <input type="text" class="form-control" id="inputEmail" name="email" value="${tbUser.email}" placeholder="请输入邮箱">
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                                  <div class="col-sm-10">
                                      <input type="password" class="form-control" id="inputPassword" name="password" value="${tbUser.password}" placeholder="请输入密码">
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label for="inputUsername" class="col-sm-2 control-label">姓名</label>
                                  <div class="col-sm-10">
                                      <input type="text" class="form-control" id="inputUsername" name="username" value="${tbUser.username}" placeholder="请输入用户姓名">
                                  </div>
                              </div>
                              <div class="form-group">
                                  <label for="inputPhone" class="col-sm-2 control-label">手机</label>
                                  <div class="col-sm-10">
                                      <input type="text" class="form-control" id="inputPhone" name="phone" value="${tbUser.phone}" placeholder="请输入用户手机号">
                                  </div>
                              </div>
                          </div>
                          <!-- /.box-body -->
                          <div class="box-footer">
                              <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                              <button type="submit" class="btn btn-info pull-right">提交</button>
                          </div>
                          <!-- /.box-footer -->
                      </form>
                  </div>
              </div>
          </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>

