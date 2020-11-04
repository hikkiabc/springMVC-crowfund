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
<div class="alert alert-info option" typeName="1">
    <span>Company</span>
</div><div class="alert alert-info option" typeName="2">
    <span>Individual</span>
</div><div class="alert alert-info option" typeName="3">
    <span>This is a plain notification</span>
</div><div class="alert alert-info option" typeName="4">
    <span>This is a plain notification</span>
</div>
<div class="alert alert-info alert-with-icon" onclick="submitForm()" data-notify="container">
    <button type="button" aria-hidden="true" class="close">
        <i class="now-ui-icons ui-1_simple-remove"></i>
    </button>
    <span data-notify="icon" class="now-ui-icons ui-1_bell-53"></span>
    <span data-notify="message">Submit</span>
</div>
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
<script src="${contextPath}/model/member/assets/demo/demo.js"></script>
<script>
    let typeId=''
    $(document).ready(function() {
        // Javascript method's body can be found in assets/js/demos.js

        // demo.initDashboardPageCharts();

$(".option").click(function () {
   $(".option").removeClass("active")
        $(".active").remove()
    $(this).addClass("active")
    typeId=$(this).attr("typeName")

})

    });
    function submitForm() {
        if (!typeId) return false;
        $.ajax({
            url:'${contextPath}/member/updateAccType',
            data:{typeId},
            success(s){

                window.location.href='${contextPath}/member/toUpload'
            },
            error(e){
                console.log(e)
            }
        })
    }
</script>
</body>

</html>