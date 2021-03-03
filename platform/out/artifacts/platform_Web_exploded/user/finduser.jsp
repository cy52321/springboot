<%--
  Created by IntelliJ IDEA.
  User: chenyi
  Date: 2021/1/31
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <base href="<%=basepath%>">
    <script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url:"queryall",
                type:"get",/*
                data:{"name":"sds"},*/
                dataType:"json",
                success:function (resp) {
                    $("#tab").empty();
                    $.each(resp,function (i,n) {
                        var href1="/userdelete?name="+n.name+"&password="+n.password;
                        $("#tab").append("<tr>").
                        append("<td>"+n.name+"</td>").
                        append("<td>"+n.password+"</td>").
                        append("<td>"+n.sex+"</td>").
                        append("<td>"+n.email+"</td>").
                        append("<td>").append("<a href="+href1+">删除</a>").append("</td>").
                        append("</tr>")
                    })
                }
            })
            $("#btn").click(function () {
                $.ajax({
                    url:"queryall",
                    type:"get",
                    dataType:"json",
                    success:function (resp) {
                        $("#tab").empty();
                        $.each(resp,function (i,n) {
                            var href1="/userdelete?name="+n.name+"&password="+n.password;
                            $("#tab").append("<tr>").
                            append("<td>"+n.name+"</td>").
                            append("<td>"+n.password+"</td>").
                            append("<td>"+n.sex+"</td>").
                            append("<td>"+n.email+"</td>").
                            append("<td>").append("<a href="+href1+">删除</a>").append("</td>").
                            append("</tr>")
                        })
                    }
                })
            })
        })
    </script>
</head>
<body>

    <div align="center">
        <table align="center">
            <thead style="font-size: 30px;color: red" align="center">
            <tr>
                <td>姓名</td>
                <td>密码</td>
                <td>性别</td>
                <td>邮箱</td>
                <td>删除</td>
            </tr>
            </thead>
            <tbody id="tab" align="center">

            </tbody>
        </table>
        <input type="button" id="btn" value="查询数据">
    </div>
</body>
</html>
