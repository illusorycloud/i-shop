<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
          name="viewport"/>
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="assets/bower_components/bootstrap/dist/css/bootstrap.min.css"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="assets/bower_components/font-awesome/css/font-awesome.min.css"/>
    <!-- Ionicons -->
    <link rel="stylesheet" href="assets/bower_components/Ionicons/css/ionicons.min.css"/>
    <!-- Theme style -->
    <link rel="stylesheet" href="assets/css/AdminLTE.min.css"/>
    <!-- iCheck -->
    <link rel="stylesheet" href="assets/plugins/iCheck/square/blue.css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="#">我的商城</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">用户登录</p>

        <form action="/login" method="post">
            <%--错误提示 jstl--%>
            <%--<c:if test="${message!=null}">--%>
            <%--<div class="alert alert-danger alert-dismissible">--%>
            <%--<button type="button" class="close" data-dismiss="alert" aria-hidden="true">--%>
            <%--&times;--%>
            <%--</button>--%>
            <%--${message}--%>
            <%--</div>--%>
            <%--</c:if>--%>
            <%--错误提示 ${message == null ? "style='display:none'":""}--%>
            <div class="alert alert-danger alert-dismissible" ${message == null ? "style='display:none'":""}>
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">
                    &times;
                </button>
                ${message}
            </div>
            <div class="form-group has-feedback">
                <input name="email" type="email" value="${email}" class="form-control" placeholder="请输入邮箱">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input name="password" type="password" value="${password}" class="form-control" placeholder="请输入密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input name="isRememberMe" type="checkbox" ${isRememberMe == true ? "checked" : ""}> 记住我
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
                <!-- /.col -->
            </div>
        </form>
        <%--其他登录方式--%>
        <%--<div class="social-auth-links text-center">--%>
        <%--<p>- OR -</p>--%>
        <%--<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i--%>
        <%--class="fa fa-facebook"></i> Sign in using--%>
        <%--Facebook</a>--%>
        <%--<a href="#" class="btn btn-block btn-social btn-google btn-flat"><i--%>
        <%--class="fa fa-google-plus"></i> Sign in using--%>
        <%--Google+</a>--%>
        <%--</div>--%>
        <!-- /.social-auth-links -->

        <a href="#">I forgot my password</a><br>
        <a href="#" class="text-center">Register a new membership</a>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 3 -->
<script src="assets/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="assets/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    });
</script>
</body>
</html>
