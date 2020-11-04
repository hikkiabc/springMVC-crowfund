<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="${contextPath}/model/dashboard/BS3/assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Main</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link rel="stylesheet" href="${contextPath}/model/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <!-- Bootstrap core CSS     -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- Animation library for notifications   -->
    <link href="${contextPath}/model/dashboard/BS3/assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="${contextPath}/model/dashboard/BS3/assets/css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${contextPath}/model/dashboard/BS3/assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="${contextPath}/model/dashboard/BS3/assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
    <style>
        .glyphicon{
            /*top:-21px;*/
        }
        .togle-child{
            margin-left: 20px;      }
        #docCollapse{
            margin-top: 1px;
        }
        .point-down{
            top: -21px;
        }
    </style>
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="${contextPath}/model/dashboard/BS3/assets/img/sidebar-5.jpg">

        <!--

            Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
            Tip 2: you can also add an image using data-image tag

        -->

        <div class="sidebar-wrapper">
            <div class="logo">
                <a href="http://www.creative-tim.com" class="simple-text">
                    Creative Tim
                </a>
            </div>
            <%--            <ul class="nav nav-pills nav-stacked">--%>
            <%--                <li role="presentation" id="bar-1"><a href="bar-1">Bar 1</a></li>--%>
            <%--                <li role="presentation" id="bar-2">--%>
            <%--                    <a href="#docCollapse" class="nav-header collapsed" data-toggle="collapse" id="collapseParent" onclick="chevron_toggle()">Bar 2<span class="pull-right glyphicon glyphicon-chevron-down"></span></a>--%>
            <%--                    <ul id="docCollapse" class="nav nav-list collapse">--%>
            <%--                        <li><a href="#">Child Bar 1</a></li>--%>
            <%--                        <li><a href="#">Child Bar 2</a></li>--%>
            <%--                    </ul>--%>
            <%--                </li>--%>
            <%--                <li role="presentation" id="bar-3"><a href="bar-3">Bar 3</a></li>--%>
            <%--            </ul>--%>
            <ul class="nav">
                <li class="active">
                    <a href="dashboard.html">
                        <i class="pe-7s-graph"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li >
                    <a href="#docCollapse" class="nav-header collapsed" data-toggle="collapse" id="collapseParent" onclick="chevron_toggle()">    <i class="pe-7s-graph"></i><p>User Management</p> <span class="point-down pull-right glyphicon glyphicon-chevron-down"></span></a>

                    <ul id="docCollapse" class="nav nav-list collapse">
                        <li class="togle-child">
                            <a href="${contextPath}/user/goUserIndex">
                                <i class="pe-7s-user"></i>
                                <p>User Information</p>
                            </a>
                        </li>
                        <li class="togle-child">
                            <a href="${contextPath}/user/toUpdate">
                                <i class="pe-7s-user"></i>
                                <p>User Profile</p>
                            </a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="${contextPath}/permission/toIndex">
                        <i class="pe-7s-user"></i>
                        <p>Permissions</p>
                    </a>
                </li>
                <li>
                    <a href="table.html">
                        <i class="pe-7s-note2"></i>
                        <p>Table List</p>
                    </a>
                </li>
                <li>
                    <a href="typography.html">
                        <i class="pe-7s-news-paper"></i>
                        <p>Typography</p>
                    </a>
                </li>
                <li>
                    <a href="icons.html">
                        <i class="pe-7s-science"></i>
                        <p>Icons</p>
                    </a>
                </li>
                <li>
                    <a href="maps.html">
                        <i class="pe-7s-map-marker"></i>
                        <p>Maps</p>
                    </a>
                </li>
                <li>
                    <a href="notifications.html">
                        <i class="pe-7s-bell"></i>
                        <p>Notifications</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="upgrade.html">
                        <i class="pe-7s-rocket"></i>
                        <p>Upgrade to PRO</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Dashboard</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-dashboard"></i>
                                <p class="hidden-lg hidden-md">Dashboard</p>
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-globe"></i>
                                <b class="caret hidden-lg hidden-md"></b>
                                <p class="hidden-lg hidden-md">
                                    5 Notifications
                                    <b class="caret"></b>
                                </p>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">
                                <i class="fa fa-search"></i>
                                <p class="hidden-lg hidden-md">Search</p>
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <%--                        <li>--%>
                        <%--                            <a href="">--%>
                        <%--                                <p>${user.username}</p>--%>
                        <%--                            </a>--%>
                        <%--                        </li>--%>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <p>
                                    ${user.username}
                                    <b class="caret"></b>
                                </p>

                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="${contextPaht}/logout">Log out</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">
                                <p>Log out</p>
                            </a>
                        </li>
                        <li class="separator hidden-lg"></li>
                    </ul>
                </div>
            </div>
        </nav>
        <ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>





            </div>


        </div>


        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>
                        <li>
                            <a href="#">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Company
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Portfolio
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Blog
                            </a>
                        </li>
                    </ul>
                </nav>
                <p class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script> <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                </p>
            </div>
        </footer>

    </div>
</div>


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

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="${contextPath}/model/dashboard/BS3/assets/js/demo.js"></script>
<script type="text/javascript" src="${contextPath}/model/zTree/js/jquery.ztree.all.js"></script>
<script type="text/javascript">
    $(document).ready(function(){

        let   setting = {
                view: {
                    dblClickExpand: false,
                    showLine: true,
                    selectedMulti: false,
                    addDiyDom: addDiyDom,
                    addHoverDom:function (treeId,treeNode) {

var obj=$("#"+treeNode.tId+"_a")
                        if($("#btngrp"+treeNode.tId).length>0) return
                        let s='<span id="btngrp'+treeNode.tId+'"> '
                        s+='<a  onclick="window.location.href=\'${contextPath}/permission/toAdd?pId='+treeNode.id+'\'" >add</a>'+'<a onclick="window.location.href=\'${contextPath}/permission/toUpdate?id='+treeNode.id+'\'" >edit</a>'
                        s+='</span>'
                        obj.after(s)
                    },
                    removeHoverDom:function (treeId,treeNode) {

                        $("#btngrp"+treeNode.tId).remove()
                    }
                },
                data: {
                    simpleData: {
                        enable: true,
                        idKey: "id",
                        pIdKey: "pId",
                        rootPId: ""
                    }
                }}
       $.ajax({
           url:'${contextPaht}/permission/getData',
           success(res){
            console.log(res)
               let zNodes=res.res

               let zTreeObj = $.fn.zTree.init($("#tree"), setting, zNodes);
        },
           error(e){
               console.log(e)
           }
       })


    });
    function addDiyDom(treeId, treeNode) {
        // console.log(treeNode)
        var aObj = $("#" + treeNode.tId + "_ico");
        if(treeNode.icon){
            aObj.removeClass().addClass(treeNode.icon)

        }
    };
    function chevron_toggle(){
        console.log(1)
        $("#collapseParent").find("span").toggleClass("glyphicon-chevron-up");
        $("#collapseParent").find("span").toggleClass("glyphicon-chevron-down");
    }

</script>

</html>
