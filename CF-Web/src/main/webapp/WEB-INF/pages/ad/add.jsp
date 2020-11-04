<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${contextPath}/ad/add" method="post" enctype="multipart/form-data">
    name:<input type="text" name="name">
    url:<input type="text" name="url" id="">
    upload:<input type="file" name="file" >
    <input id="submit" type="submit" value="submit">
</form>
</body>
<script src="${contextPath}/model/dashboard/BS3/assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script>
    $(function () {
        $("#submit").click(function () {
            // prepare Options Object
            var options = {

                success:    function(res) {
                    console.log(res)
                }
            };

            $('form').ajaxForm(options);
        })

    })
</script>
</html>