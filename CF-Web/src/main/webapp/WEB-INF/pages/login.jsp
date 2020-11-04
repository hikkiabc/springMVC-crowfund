<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>Login V18</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> <!-- font-awesome icons -->
<%--    <link rel="stylesheet" href="${contextPath}/model/layui/css/layui.css"  media="all">--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="${contextPath}/model/login/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/model/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/model/login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/model/login/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/model/login/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/model/login/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/model/login/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/model/login/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${contextPath}/model/login/css/util.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/model/login/css/main.css">
    <!--===============================================================================================-->
    <style>
        .limiter{
            height: 100%;
        }
        .container-login100{
            height: 100%;
        }
        .wrap-login100{ height: 100%;}

        .select1{
            width: 100% !important;
            outline: none!important;
            border: none!important;
        }
        .show{
            box-sizing: border-box;
        }
        .select1 .btn{
            outline: none!important;
            background-color: #6675df!important;
            border-radius: 10px;
            line-height: 1.5;
            font-size: 1.5rem;
            color: #f7f7f7!important;
        }
        .select1 a{
            font-size: 14px;
            line-height: 2.2!important;
        }
        .bootstrap-select .dropdown-toggle:focus, .bootstrap-select>select.mobile-device:focus+.dropdown-toggle{
            /*border: none!important;*/
            outline: none!important;
        }

        .select1 .dropdown-item:focus, .dropdown-item:hover{
            background-color: #bccbf1!important;
            color: #ffffff!important;
            border-radius: 10px;
        }
        .dropdown-menu>.active>a{
            background-color: transparent;
            border-radius: 10px;
            color: #000000;
        }

        .select1 .dropdown-item{
            transition:border-radius 0s!important;
            /*transition:background-color 0s;*/
        }
        .glyphicon{
            position: absolute;
            top: 50%;
            right: 30px;

        }
        .glyphicon:before{
            font-size: 23px;
            position: absolute;
color:#5d73e0;
            transform: translate(-50%,-40%);

        }
        .selectDiv{
            margin: 20px 0;
            margin-bottom: 40px;
        }

    </style>
</head>
<body style="background-color: #666666;">

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <form action="/login" method="post" class="login100-form validate-form">
					<span class="login100-form-title p-b-43">
						Login to continue
					</span>
                <span>${exception.message}</span>

                <div class="inputusername wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
                    <input class="input100" type="text" value="test1" id="accname" name="accname">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>

                    <span class="focus-input100"></span>
                    <span class="label-input100">Username</span>
                </div>


                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <input class="input100" value="1" type="password" id="password" name="password">
                    <span class="
glyphicon glyphicon-lock" aria-hidden="true"></span>

                    <span class="focus-input100"></span>
                    <span class="label-input100">Password</span>
                </div>
                <div class="selectDiv" data-validate="Password is required">
                    <select id="type" class="selectpicker select1" data-style="btn-primary"
                            title="Choose Type"  name="type">
                        <option value="admin">Admin</option>
                        <option selected value="user">User</option>

                    </select>

                </div>
                <div class="flex-sb-m w-full p-t-3 p-b-32">
                    <div class="contact100-form-checkbox">
                        <input class="input-checkbox100" id="remember" type="checkbox" name="remember">
                        <label class="label-checkbox100" for="remember">
                            Remember me
                        </label>
                    </div>

                    <div>
                        <a href="${contextPath}/model/login/#" class="txt1">
                            Forgot Password?
                        </a>
                    </div>
                </div>


                <div id="sumbit1" class="container-login100-form-btn">
                    <button id="submit" class="login100-form-btn">
                        Login
                    </button>
                </div>

                <div class="text-center p-t-46 p-b-20">
						<span class="txt2">
							or sign up using
						</span>
                </div>

                <div class="login100-form-social flex-c-m">
                    <a href="${contextPath}/model/login/#" class="login100-form-social-item flex-c-m bg1 m-r-5">
                        <i class="fa fa-facebook-f" aria-hidden="true"></i>
                    </a>

                    <a href="${contextPath}/model/login/#" class="login100-form-social-item flex-c-m bg2 m-r-5">
                        <i class="fa fa-twitter" aria-hidden="true"></i>
                    </a>
                </div>
            </form>

            <div class="login100-more" style="background-image: url('${contextPath}/model/login/images/bg-01.jpg');">
            </div>
        </div>
    </div>
</div>




<!--===============================================================================================-->
<script src="${contextPath}/model/login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="${contextPath}/model/login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="${contextPath}/model/login/vendor/bootstrap/js/popper.js"></script>
<script src="${contextPath}/model/login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="${contextPath}/model/login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="${contextPath}/model/login/vendor/daterangepicker/moment.min.js"></script>
<script src="${contextPath}/model/login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="${contextPath}/model/login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="${contextPath}/model/login/js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
<script src="${contextPath}/model/layer/layer/layer.js" charset="utf-8"></script>

<script>
    $(function () {
        $("#submit").click((event)=>{

        if($.trim($("#accname").val())==""){
            layer.msg('Input Accname and Password', {
                icon: 5,
                time: 2000
            }, function(){
                $("#accname").val("")
                $("#accname").focus()
            });

            return false
        }

            var index = null
          $.ajax({
              beforeSend:()=>index= layer.msg('Logging', {icon: 6}),
              type:"post",
              url:"${contextPath}/login",
              data:{accname:$("#accname").val(),password:$("#password").val(),type:$("#type").val(),remember:$("#remember")[0].checked},
              success:(res)=>{

                  layer.close(index)
                 if(res.success){
                     layer.msg(res.msg, {
                         icon: 1,
                         time: 2000
                     })
                     console.log($("#type").val())
                     if ($("#type").val()=="user"){

                         window.location.href='${contextPath}/toMemberIndex'
                     }
                      else window.location.href='${contextPath}/goToMain'
                 }else    layer.msg(res.msg, {
                     icon: 5,
                     time: 2000
                 }, function(){
                     $("#accname").val("")
                     $("#accname").focus()
                 });

              },
              error:(e)=>{

              }
          })

            return false

        })

    })
</script>

</body>
</html>