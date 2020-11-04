<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="${contextPath}/model/member/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="${contextPath}/model/member/assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        Now UI Dashboard by Creative Tim
    </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <!-- CSS Files -->
    <link href="${contextPath}/model/member/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${contextPath}/model/member/assets/css/now-ui-dashboard.css?v=1.5.0" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="${contextPath}/model/member/assets/demo/demo.css" rel="stylesheet" />
    <style>
        .active{
            color: #6ef01d;
        }
    </style>
</head>

<body class="">

<table>
    <tr>
        <th>member Username</th>
        <th>member ID</th>
    </tr>
    <tr>
        <td>${member.username}</td>
        <td>${member.id}</td>
    </tr>

</table>  <c:forEach items="${certi}" var="i">
    <div>${i.name}</div>
    <img width="100px" src="${contextPath}/upload/certiPics/${i.img_name}" alt="">
</c:forEach>

<div><button id="pass">Pass</button></div>
<div><button id="notPass">Not Pass</button></div>
<!--   Core JS Files   -->
<script src="${contextPath}/model/member/assets/js/core/jquery.min.js"></script>
<script src="${contextPath}/model/member/assets/js/core/popper.min.js"></script>
<script src="${contextPath}/model/member/assets/js/core/bootstrap.min.js"></script>
<script src="${contextPath}/model/member/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!--  Google Maps Plugin    -->
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Chart JS -->
<script src="${contextPath}/model/member/assets/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="${contextPath}/model/member/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script src="${contextPath}/model/member/assets/js/now-ui-dashboard.min.js?v=1.5.0" type="text/javascript"></script><!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
<script src="http://malsup.github.com/jquery.form.js"></script>

<script src="${contextPath}/model/member/assets/demo/demo.js"></script>
<script>
    let typeId=''
    $(document).ready(function() {
        // Javascript method's body can be found in assets/js/demos.js

        // demo.initDashboardPageCharts();

        $("#submit").click(function () {
            var options = {

                success:    function(res) {
                    console.log(res)
                    if (res.res){
                        window.location.href='${contextPath}/member/toFinish'

                    }
                },
                error(e){
                    console.log(e)
                }
            };

            $('form').ajaxForm(options);
        })
$("#pass").click(function () {
$.ajax({
    url:'${contextPath}/verify/pass',
    data:{memberId:${member.id},taskId:${param.taskId}},
    success(s){
        console.log(s)
        if (s.res) window.location.href='${contextPath}/verify/toIndex'
    },
    error(e) {
        console.log(e)
    }
})
})
        $("#notPass").click(function () {
            $.ajax({
                url:'${contextPath}/verify/notPass',
                data:{memberId:${member.id},taskId:${param.taskId}},
                success(s){
                    console.log(s)
                    if (s.res) window.location.href='${contextPath}/verify/toIndex'
                },
                error(e) {
                    console.log(e)
                }
            })
        })
    });

</script>
</body>

</html>