<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="${contextPath}/model/dashboard/BS3/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Insert</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="${contextPath}/model/dashboard/BS3/assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="${contextPath}/model/dashboard/BS3/assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="${contextPath}/model/dashboard/BS3/assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${contextPath}/model/dashboard/BS3/assets/css/demo.css" rel="stylesheet" />

    <%--    <script src="${contextPath}/model/layer/layer/layer.js" charset="utf-8"></script>--%>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<%--    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>--%>
<%--    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="${contextPath}/model/dashboard/BS3/assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
</head>
<body>

Role List:
<select id="leftSelect" style="width: 300px;height:200px" multiple='multiple' >
    <c:forEach items="${notHave}" var="role">
        <option value="${role.roleId}">${role.roleName}</option>
    </c:forEach>


</select>
<button id="btn-l" class="btn btn-default">btn btn-default</button>
<button id="btn-r" class="btn btn-primary">btn btn-primary</button>


Current Roles:
<select id="rightSelect" style="width: 300px;height: 200px" multiple >
    <c:forEach items="${have}" var="role">
        <option value="${role.roleId}">${role.roleName}</option>
    </c:forEach>
</select>
</body>

<!--   Core JS Files   -->
<script src="${contextPath}/model/dashboard/BS3/assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="${contextPath}/model/dashboard/BS3/assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="${contextPath}/model/dashboard/BS3/assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="${contextPath}/model/dashboard/BS3/assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="${contextPath}/model/dashboard/BS3/assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>
<script src="${contextPath}/model/layer/layer/layer.js" charset="utf-8"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="${contextPath}/model/dashboard/BS3/assets/js/demo.js"></script>
<script>
$(function () {
    $("#btn-r").click(function () {
        let integerList=[]
        let index
        $.each($("#leftSelect option:selected"),function (i,n) {
           integerList.push(n.value)
        })

        $.ajax({
            beforeSend:()=>index= layer.msg('Processing', {icon: 6}),
            url:'${contextPath}/user/confirmAssign',
            method:'post',
            <%--data:{userId:${userId},integerList},--%>
            contentType:'application/json;charset=UTF-8',
            dataType:'json',
            data:JSON.stringify({userId:${userId},integerList}),
            success:(res)=>{
                console.log(res)
                $("#rightSelect").append($("#leftSelect option:selected"))
            },
            error:(e)=>{
                console.log(e)
            }
        })

    })
    $("#btn-l").click(function () {
        let integerList=[]
        let index

        $.each($("#rightSelect option:selected"),(function (i,n) {
             integerList.push(  n.value)
        }))
        $.ajax({
            url:'${contextPath}/user/deleteRoles',
            method: 'post',
            contentType:'application/json;charset=UTF-8',
            data:JSON.stringify({userId:${userId},integerList}),
            success:(res)=>{
                console.log(res)
                $("#leftSelect").append($("#rightSelect option:selected"))
            },
            error:(e)=>{
                console.log(e)
            }
        })
    })
})
</script>

</html>
