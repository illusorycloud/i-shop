<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<title>我的商城 | 用户详情</title>

<jsp:include page="../includes/header.jsp"/>

<body class="hold-transition skin-blue sidebar-mini">
<form:form id="inputForm" cssClass="form-horizontal" action="/content/save" method="post"
           modelAttribute="tbContent">

    <div class="box-body">

        <div class="form-group">
            <label class="col-sm-2 control-label">父级类目</label>

            <div class="col-sm-10">
                    <%--<form:hidden id="categoryId" path="tbContentCategory.id" />--%>
                <input id="categoryName" class="form-control required" placeholder="请选择"
                       readonly="true" data-toggle="modal" data-target="#modal-default"
                       value="${tbContent.tbContentCategory.name}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">标题</label>

            <div class="col-sm-10">
                <form:input path="title" class="form-control required" placeholder="标题"/>
            </div>
        </div>

        <div class="form-group">
            <label for="subTitle" class="col-sm-2 control-label">子标题</label>

            <div class="col-sm-10">
                <form:input path="subTitle" class="form-control required" placeholder="子标题"/>
            </div>
        </div>

        <div class="form-group">
            <label for="titleDesc" class="col-sm-2 control-label">标题描述</label>

            <div class="col-sm-10">
                <form:input path="titleDesc" class="form-control required" placeholder="标题描述"/>
            </div>
        </div>

        <div class="form-group">
            <label for="url" class="col-sm-2 control-label">链接</label>

            <div class="col-sm-10">
                <form:input path="url" class="form-control" placeholder="链接"/>
            </div>
        </div>

        <div class="form-group">
            <label for="url" class="col-sm-2 control-label">图片1</label>

            <div class="col-sm-10">
                <form:input path="pic" class="form-control" placeholder="图片1"/>
                <div id="dropz" class="dropzone"></div>
            </div>
        </div>

        <div class="form-group">
            <label for="url" class="col-sm-2 control-label">图片2</label>

            <div class="col-sm-10">
                <form:input path="pic2" class="form-control" placeholder="图片2"/>
                <div id="dropz2" class="dropzone"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">详情</label>

            <div class="col-sm-10">
                <form:hidden path="content"/>
                <div id="editor">${tbContent.content}</div>
            </div>
        </div>
    </div>
</form:form>

<jsp:include page="../includes/footer.jsp"/>

</body>
</html>

