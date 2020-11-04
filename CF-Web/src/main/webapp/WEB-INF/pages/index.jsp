<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<%--    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">--%>
<%--    </script>--%>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> <!-- font-awesome icons -->
    <link href="//fonts.googleapis.com/css?family=Open+Sans+Condensed:300,300i,700" rel="stylesheet">
    <link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link href="${contextPath}/model/css/style.css" type="text/css" rel="stylesheet" media="all">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <title>Home</title>


</head>
<body>
<div class="agileits-banner">
    <!-- navigation -->
    <div class="top-nav w3-agiletop">
        <div class="container">
            <div class="navbar-header w3llogo">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <h1><a href="index.html"><span class="glyphicon glyphicon-signal" aria-hidden="true"></span> Invent</a></h1>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <div class="w3menu navbar-left">
                    <ul class="nav navbar">
                        <li><a href="index.html" class="active">Home</a></li>
                        <li><a href="about.html">About</a></li>
                        <li><a href="gallery.html">Gallery</a></li>
                        <li><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span data-letters="Pages">Pages</span><span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="icons.html">Web Icons</a></li>
                                <li><a href="codes.html">Short Codes</a></li>
                            </ul>
                        </li>

                        <li><a href="${contextPath}/gotologin">Login</a></li>
                    </ul>
                </div>

                <div class="w3ls-bnr-icons social-icon navbar-right">
                    <a href="#" class="social-button twitter"><i class="fa fa-twitter"></i></a>
                    <a href="#" class="social-button facebook"><i class="fa fa-facebook"></i></a>
                    <a href="#" class="social-button google"><i class="fa fa-google-plus"></i></a>
                    <a href="#" class="social-button dribbble"><i class="fa fa-dribbble"></i></a>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
    </div>
    <!-- //navigation -->
    <div class="banner-w3text w3layouts">
        <h2>Welcome To <span>Invent</span></h2>
        <div class="wthree-bnr-login">
            <form action="#" method="post">
                <ul>
                    <li><input type="text" name="Name" placeholder="Your Name" required=""></li>
                    <li><input type="email" name="Email" placeholder="Your Email" required=""> </li>
                    <li><input type="submit" value="Register"></li>
                </ul>
            </form>
        </div>
        <h6>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit</h6>
    </div>
</div>
<!-- //banner -->
<!-- banner-bottom -->
<div class="banner-bottom w3-agileits-bnr-btm">
    <div class="col-sm-6 col-xs-6 bnr-btm-left">
        <h5>Lorem ipsum </h5>
        <p>Duis aute irure dolor in reprehenderit</p>
    </div>
    <div class="col-sm-6 col-xs-6 bnr-btm-right">
        <h5>Reprehen</h5>
        <p>Voluptate velit esse cillum dolore eu</p>
    </div>
    <div class="clearfix"> </div>
</div>
<!-- //banner-bottom -->
<!-- about -->
<div class="about">
    <div class="container">
        <h3 class="agileits-title">About Us</h3>
        <div class="about-agileinfo">
            <div class="col-md-6 agileits_about_right">
                <div class="w3ls_about_right">
                    <img src="${contextPath}/model/images/img2.jpg" alt=" " class="img-responsive" />
                    <div class="w3ls_about_right_pos">
                        <img src="${contextPath}/model/images/img1.jpg" alt=" " class="img-responsive" />
                    </div>
                </div>
            </div>
            <div class="col-md-6 agileits_about_left">
                <p class="w3l_para">Curabitur nec purus eget urna pulvinar placerat. Integer varius est vitae iaculis
                    suscipit. Nam libero tempore cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus omnis optio cumque nihil impedit quo minus id quod maxime placeat facere possimus.</p>
                <div class="w3l_social_icons">
                    <div class="w3l_social_icon_grid">
                        <div class="w3l_social_icon_gridl w3_facebook">
                            <a href="#">
                                <i class="fa fa-cogs" aria-hidden="true"></i>
                            </a>
                        </div>
                        <div class="w3l_social_icon_gridr">
                            <p class="counter">23,536</p>
                        </div>
                        <div class="clearfix"> </div>
                        <div class="w3l_social_icon_grid_pos">
                            <label>-</label>
                        </div>
                    </div>
                    <div class="w3l_social_icon_grid w3ls_social_icon_grid">
                        <div class="w3l_social_icon_gridl w3_dribbble">
                            <a href="#">
                                <i class="fa fa-group" aria-hidden="true"></i>
                            </a>
                        </div>
                        <div class="w3l_social_icon_gridr">
                            <p class="counter">13,676</p>
                        </div>
                        <div class="clearfix"> </div>
                        <div class="w3l_social_icon_grid_pos">
                            <label>-</label>
                        </div>
                    </div>
                    <div class="w3l_social_icon_grid">
                        <div class="w3l_social_icon_gridl w3_instagram">
                            <a href="#">
                                <i class="fa fa-cubes" aria-hidden="true"></i>
                            </a>
                        </div>
                        <div class="w3l_social_icon_gridr">
                            <p class="counter">45,342</p>
                        </div>
                        <div class="clearfix"> </div>
                        <div class="w3l_social_icon_grid_pos">
                            <label>-</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //about -->
<!-- services -->
<div class="services">
    <div class="container">
        <h3 class="agileits-title">Services</h3>
        <div class="services-row-agileinfo">
            <div class="col-sm-4 col-xs-6 services-w3grid">
                <span class="glyphicon glyphicon-heart hi-icon" aria-hidden="true"></span>
                <h5>Cum soluta nobis</h5>
                <p>Itaque earum rerum hic a sapiente delectus</p>
            </div>
            <div class="col-sm-4 col-xs-6 services-w3grid">
                <span class="glyphicon glyphicon-list-alt hi-icon" aria-hidden="true"></span>
                <h5>Soluta vum nobis</h5>
                <p>Itaque earum rerum hic a sapiente delectus</p>
            </div>
            <div class="col-sm-4 col-xs-6 services-w3grid">
                <span class="glyphicon glyphicon-leaf hi-icon" aria-hidden="true"></span>
                <h5>Nobis cum soluta</h5>
                <p>Itaque earum rerum hic a sapiente delectus</p>
            </div>
            <div class="col-sm-4 col-xs-6 services-w3grid bottom-grids wow fadeInUp animated" data-wow-delay=".5s">
                <span class="glyphicon glyphicon-globe hi-icon" aria-hidden="true"></span>
                <h5>Taaum solu nobis</h5>
                <p>Itaque earum rerum hic a sapiente delectus</p>
            </div>
            <div class="col-sm-4 col-xs-6 services-w3grid bottom-grids">
                <span class="glyphicon glyphicon-cutlery hi-icon" aria-hidden="true"></span>
                <h5>Vum soluta nobis</h5>
                <p>Itaque earum rerum hic a sapiente delectus</p>
            </div>
            <div class="col-sm-4 col-xs-6 services-w3grid bottom-grids">
                <span class="glyphicon glyphicon-th-large hi-icon" aria-hidden="true"></span>
                <h5>Bisno cum soluta</h5>
                <p>Itaque earum rerum hic a sapiente delectus</p>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!-- //services -->
<!-- events -->
<div class="events">
    <div class="container">
        <h3 class="agileits-title">Our Latest Events</h3>
        <div class="agile_banner_bottom_grids">
            <div class="col-sm-6 col-xs-6 agile_events_grid">
                <img src="${contextPath}/model/images/img1.jpg" alt=" " class="img-responsive" />
                <div class="agile_events_grid_pos agile_events_grid_pos1">
                    <h5><span>01</span> 02 / 2017</h5>
                    <h4><a href="single.html">nunc malesuada lacinia</a></h4>
                    <p>Nunc non maximus augue, sit amet dictum diam. Etiam ultrices hendrerit sapien,
                        id volutpat tortor viverra et.</p>
                </div>
                <div class="agileits_w3layouts_events_grid_social">
                    <div class="social-icon evnts-w3lsicons">
                        <a href="#" class="social-button twitter"><i class="fa fa-twitter"></i></a>
                        <a href="#" class="social-button facebook"><i class="fa fa-facebook"></i></a>
                        <a href="#" class="social-button dribbble"><i class="fa fa-dribbble"></i></a>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-xs-6 agile_events_grid">
                <img src="${contextPath}/model/images/img2.jpg" alt=" " class="img-responsive" />
                <div class="agile_events_grid_pos_sub agile_events_grid_pos1">
                    <h5 class="w3_agileits_event_head"><span>05</span> 02 / 2017</h5>
                    <h4><a href="single.html">consequat dictum sodales</a></h4>
                    <p>Nunc non maximus augue, sit amet dictum diam. Etiam ultrices hendrerit sapien,
                        id volutpat tortor viverra et.</p>
                </div>
                <div class="agileits_w3layouts_events_grid_social">
                    <div class="social-icon evnts-w3lsicons">
                        <a href="#" class="social-button twitter"><i class="fa fa-twitter"></i></a>
                        <a href="#" class="social-button facebook"><i class="fa fa-facebook"></i></a>
                        <a href="#" class="social-button dribbble"><i class="fa fa-dribbble"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- //events -->
<!-- footer -->
<div class="footer">
    <div class="container">
        <div class="footer-row w3l-newsletter">
            <div class="col-md-6 w3_agile_newsletter_left">
                <h4>Subscribe Newsletter</h4>
            </div>
            <div class="col-md-6 w3_agile_newsletter_right">
                <form action="#" method="post">
                    <input type="email" name="Email" placeholder="Email..." required="">
                    <input type="submit" value="Subscribe">
                </form>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="footer-bottom">
            <div class="col-sm-4 col-xs-4 footer-grids">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                    eiusmod tempor incididunt ut labore et dolore magna aliqua.
                    Ut enim ad minim veniam.</p>
                <h6>consectetur<a href="#"> Christ Richard.</a> </h6>
            </div>
            <div class="col-sm-4 col-xs-4 footer-grids footer-mdl">
                <div class="col-md-6 col-xs-6 grid-left">
                    <ul>
                        <li><a href="index.html"><i class="fa fa-angle-right"></i>Home</a></li>
                        <li><a href="about.html"><i class="fa fa-angle-right"></i>About</a></li>
                        <li><a href="gallery.html"><i class="fa fa-angle-right"></i>Gallery</a></li>
                        <li><a href="icons.html"><i class="fa fa-angle-right"></i>Web Icons</a></li>
                    </ul>
                </div>
                <div class="col-md-6 col-xs-6 grid-left">
                    <ul>
                        <li><a href="codes.html"><i class="fa fa-angle-right"></i>Short Codes</a></li>
                        <li><a href="contact.html"><i class="fa fa-angle-right"></i>Contact</a></li>
                        <li><a href="about.html"><i class="fa fa-angle-right"></i>Team</a></li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="col-sm-4 col-xs-4 footer-grids">
                <ul>
                    <li class="phn"><i class="fa fa-phone"></i>1111-111-111</li>
                    <li><a href="mailto:example@mail.com"><i class="fa fa-envelope-o"></i> mail@example.com</a></li>
                </ul>
                <p>© 2017 Invent . All rights reserved | Design by <a href="http://www.xmoban.cn">xmoban.cn</a></p>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- footer -->
<!-- Stats -->
<script src="${contextPath}/model/js/waypoints.min.js"></script>
<script src="${contextPath}/model/js/counterup.min.js"></script>
<script>
    jQuery(document).ready(function( $ ) {
        $('.counter').counterUp({
            delay: 10,
            time: 2000
        });
    });
</script>
<!-- //Stats -->
<!-- start-smooth-scrolling -->
<script src="${contextPath}/model/js/SmoothScroll.min.js"></script>
<script type="text/javascript" src="${contextPath}/model/js/move-top.js"></script>
<script type="text/javascript" src="${contextPath}/model/js/easing.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function($) {
        $(".scroll").click(function(event){
            event.preventDefault();

            $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
        });
    });
</script>
<!-- //end-smooth-scrolling -->
<!-- smooth-scrolling-of-move-up -->
<script type="text/javascript">
    $(document).ready(function() {
        /*
        var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
        };
        */

        $().UItoTop({ easingType: 'easeOutQuart' });

    });
</script>
</body>
</html>