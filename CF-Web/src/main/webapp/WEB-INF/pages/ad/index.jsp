<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Index</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="${contextPath}/model/login/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="${contextPath}/model/layer/layer/layer.js" charset="utf-8"></script>

    <style type="text/css">
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }
        .table-wrapper {
            background: #fff;
            padding: 20px 25px;
            margin: 30px 0;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0,0,0,.05);
        }
        .table-title {
            padding-bottom: 15px;
            background: #435d7d;
            color: #fff;
            padding: 16px 30px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }
        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }
        .table-title .btn-group {
            float: right;
        }
        .table-title .btn {
            color: #fff;
            float: right;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }
        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }
        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }
        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }
        table.table tr th:first-child {
            width: 60px;
        }
        table.table tr th:last-child {
            width: 100px;
        }
        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }
        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }
        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }
        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }
        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }
        table.table td a:hover {
            color: #2196F3;
        }
        table.table td a.edit {
            color: #FFC107;
        }
        table.table td a.delete {
            color: #F44336;
        }
        table.table td i {
            font-size: 19px;
        }
        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }
        .pagination {
            float: right;
            margin: 0 0 5px;
        }
        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }
        .pagination li a:hover {
            color: #666;
        }
        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }
        .pagination li.active a:hover {
            background: #0397d6;
        }
        .pagination li.disabled i {
            color: #ccc;
        }
        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }
        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }
        /* Custom checkbox */
        .custom-checkbox {
            position: relative;
        }
        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            position: absolute;
            margin: 5px 0 0 3px;
            z-index: 9;
        }
        .custom-checkbox label:before{
            width: 18px;
            height: 18px;
        }
        .custom-checkbox label:before {
            content: '';
            margin-right: 10px;
            display: inline-block;
            vertical-align: text-top;
            background: white;
            border: 1px solid #bbb;
            border-radius: 2px;
            box-sizing: border-box;
            z-index: 2;
        }
        .custom-checkbox input[type="checkbox"]:checked + label:after {
            content: '';
            position: absolute;
            left: 6px;
            top: 3px;
            width: 6px;
            height: 11px;
            border: solid #000;
            border-width: 0 3px 3px 0;
            transform: inherit;
            z-index: 3;
            transform: rotateZ(45deg);
        }
        .custom-checkbox input[type="checkbox"]:checked + label:before {
            border-color: #03A9F4;
            background: #03A9F4;
        }
        .custom-checkbox input[type="checkbox"]:checked + label:after {
            border-color: #fff;
        }
        .custom-checkbox input[type="checkbox"]:disabled + label:before {
            color: #b8b8b8;
            cursor: auto;
            box-shadow: none;
            background: #ddd;
        }
        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }
        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }
        .modal .modal-content {
            border-radius: 3px;
        }
        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }
        .modal .modal-title {
            display: inline-block;
        }
        .modal .form-control {
            border-radius: 2px;
            box-shadow: none;
            border-color: #dddddd;
        }
        .modal textarea.form-control {
            resize: vertical;
        }
        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }
        .modal form label {
            font-weight: normal;
        }
        .td-btn{
            width: 150px;
        }
    </style>
    <style>
        .col-sm-6{
            width: 31%;
            padding: 0;
        }
        /*.col-sm-6>h2{*/
        /*    width: 200px;*/
        /*    margin-block-end: 0em;*/

        /*}*/
        .search-div{
         padding: 0;
            margin: 0;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function(){
            // Activate tooltip
            $('[data-toggle="tooltip"]').tooltip();

            // Select/Deselect checkboxes
            var checkbox = $('table tbody input[type="checkbox"]');
            // $("#selectAll").click(function(){
            //     if(this.checked){
            //         checkbox.each(function(){
            //             this.checked = true;
            //         });
            //     } else{
            //         checkbox.each(function(){
            //             this.checked = false;
            //         });
            //     }
            // });
            // checkbox.click(function(){
            //     if(!this.checked){
            //         $("#selectAll").prop("checked", false);
            //     }
            // });
        });
    </script>
</head>
<body>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <div>Manage <b>Employees</b></div>
                </div>
                <div class="col-sm-6 search-div">
                    <input type="text" id="searchInput">
                    <a id="searchBtn" href="javascript:void(0)" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Search</span></a>

                </div>
                <div class="col-sm-6">
                    <a href="javascript:void(0)" class="btn btn-success" onclick="window.location.href='${contextPath}/ad/toAdd'" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New adv</span></a>
                    <a href="javascript:void(0)" onclick="deleteBatch()" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
                </th>
                <th>Account Name</th>
                <th>Username</th>
                <th>Account Type</th>
                <th>Create Time</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody class="tbody-main">
<%--            <c:forEach items="${page.data}" var="item" varStatus="status">--%>
<%--                <tr>--%>
<%--                    <td>${page.pageSize*(page.pageNum-1)+1+status.index}</td>--%>
<%--                    <td>--%>
<%--							<span class="custom-checkbox">--%>
<%--								<input type="checkbox" id="checkbox1" name="options[]" value="1">--%>
<%--								<label for="checkbox1"></label>--%>
<%--							</span>--%>
<%--                    </td>--%>

<%--                    <td>${item.accname}</td>--%>
<%--                    <td>${item.username}</td>--%>
<%--                    <td>${item.type}</td>--%>
<%--                    <td>${item.createtime}</td>--%>
<%--                    <td>--%>
<%--                        <a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>--%>
<%--                        <a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>


            </tbody>
        </table>
        <div class="clearfix">
            <div class="hint-text">Showing <b>${page.pageSize*(page.pageNum-1)+1}-${page.pageSize*(page.pageNum-1)+10}</b> out of <b>${page.totalCount}</b> entries</div>
            <ul class="pagination">
<%--                <c:if test="${page.pageNum==1}">--%>
<%--                    <li class="page-item disabled"><a href="#">Previous</a></li>--%>
<%--                </c:if>--%>
<%--                <c:if test="${page.pageNum!=1}">--%>
<%--                    <li class="page-item "><a href="${contextPaht}/user/queryPages?pageNum=${page.pageNum-1}">Previous</a></li>--%>
<%--                </c:if>--%>
<%--                <c:forEach begin="1" end="${page.totalPages}" var="num">--%>
<%--                    <li--%>
<%--                            <c:if test="${num==page.pageNum}">--%>
<%--                                    class="active"--%>
<%--                            </c:if>class="page-item"><a href="${contextPaht}/user/queryPages?pageNum=${num}" class="page-link">${num}</a></li>--%>
<%--                </c:forEach>--%>
<%--                <c:if test="${page.pageNum>=page.totalPages}">--%>
<%--                    <li class="page-item disabled"><a href="#">Next</a></li>--%>
<%--                </c:if>--%>
<%--                <c:if test="${page.pageNum<page.totalPages}">--%>
<%--                    <li class="page-item "><a href="${contextPaht}/user/queryPages?pageNum=${page.pageNum+1}">Next</a></li>--%>
<%--                </c:if>--%>

            </ul>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Add Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <textarea class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-success" value="Add">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Edit Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Address</label>
                        <textarea class="form-control" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" class="form-control" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input type="submit" class="btn btn-info" value="Save">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <form>
                <div class="modal-header">
                    <h4 class="modal-title">Delete Employee</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete these Records?</p>
                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                    <input  type="submit" class="btn btn-danger" value="Delete">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>

    $( function () {

        queryPages(1)
        $("#searchBtn").click(()=>{

            queryPages(1)
        })

    })
            function deleteBatch() {
                let checkitems = $('table tbody input:checked');
                if (checkitems.length==0) {
                    layer.msg('Please select some', {
                        icon: 1,
                        time: 2000
                    })
                    return false
                }
               let index= layer.confirm('delete not?', {icon: 3, title:'提示'}, function(){
                    let checkitems = $('table tbody input:checked');
                    let id=''
                    $.each(checkitems,function (i,n) {
                        if(i!=0) id+="&"
                       id+="id="+n.id
                    })

                    $.ajax({
                        url:'${contextPath}/user/deleteBatchUser',
                        data:id,
                        method:'post',
                        success(res){
                            console.log(res)
                            if(res.res) window.location.href='${context}/user/goUserIndex'
                        },
                        error(e) {
                            console.log(e)
                        }
                    })

                    layer.close(index);
                },()=>{
                    layer.close(index);
                });

            }
        function deleteUser(id,accname) {
            layer.confirm('delete'+accname+' not?', {icon: 3, title:'提示'}, function(index){
               $.ajax({
                   url:'${contextPath}/user/deleteUser',
                   data:{id},
                   method:'post',
                   success(res){
                       if(res.success) window.location.href='${context}/user/goUserIndex'
                   },
                   error(e) {
                       console.log(e)
                   }
               })

                layer.close(index);
            },()=>{
                layer.close(index);
            });
        }

    function queryPages(pageNum,pageSize) {

        let keywords=  $("#searchInput").val()
        $.ajax({
            url:'${contextPath}/ad/queryPages',
            data:{pageNum,pageSize,keywords},
            type:'post',
            beforeSend:()=>{
                return true
            },
            success:(res)=>{
                console.log(res)

                let contentMain=''
                            res.res.data.forEach((i,index)=>{
                                contentMain+='                                <tr>\n' +
                                    '                                    <td>'+(res.res.pageSize*(res.res.pageNum-1)+1+index)+'</td>\n' +
                                    '                                    <td>\n' +
                                    '                \t\t\t\t\t\t\t<span class="custom-checkbox">\n' +
                                    '                \t\t\t\t\t\t\t\t<input type="checkbox" id="'+i.id+'" name="options[]" value="1">\n' +
                                    '                \t\t\t\t\t\t\t\t<label for="checkbox1"></label>\n' +
                                    '                \t\t\t\t\t\t\t</span>\n' +
                                    '                                    </td>\n' +
                                    '\n' +
                                    '                                    <td>'+i.name+'</td>\n' +
                                    '                                    <td>'+i.url+'</td>\n' +

                                    '                                    <td>'+i.iconpath+'</td>\n' +
                                    '                                    <td class=\'td-btn\'>\n' +
                                    '                                        <a href="javascript:void(0)" onclick="window.location.href=\'${contextPath}/user/roleAssign?id='+i.id+'\'" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>\n' +
                                    '                                        <a href="${contextPath}/user/toEdit?id='+i.id+'"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>\n' +
                                    '                                        <a href="javascript:void(0)" onclick="deleteUser('+i.id+',\''+i.accname+'\')" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>\n' +
                                    '                                    </td>\n' +
                                    '                                </tr>'
                            })

                $(".tbody-main").html(contentMain)
                let content=''
                if(res.res.pageNum<2){
                    content+='<li class="page-item disabled"><a>Previous</a></li>'
                }else{
                    content+='<li  class="page-item "><a onclick="queryPages('+(res.res.pageNum-1)+')" href="javascript:void(0)">Previous</a></li>'
                }

                for(let i=1;i<res.res.totalPages+1;i++){
                    content+= '<li onclick="queryPages('+i+')" class="page-item "><a  href="javascript:void(0)">'+i+'</a></li>'
                }

                if(res.res.pageNum>=res.res.totalPages){
                    content+='<li class="page-item disabled"><a>Next</a></li>'
                }else{
                    content+='<li  class="page-item "><a onclick="queryPages('+(res.res.pageNum+1)+')" href="javascript:void(0)">Next</a></li>'
                }

                $(".pagination").html(content)
                let checkitems = $('table tbody input[type="checkbox"]');
                $("#selectAll").click(function(){
                    let selectALl=this.checked
                    $.each(checkitems,function (i,n) {
                       n.checked=selectALl
                    })
                })

                checkitems.click(function () {
                    let allchecked=true
                    $.each(checkitems,function (i,n) {
                        if(!n.checked) allchecked=false
                    })
                    $("#selectAll")[0].checked=allchecked
                })
            },
            error(e){
                console.log(e)

            }
        })

        return false

    }
</script>
</html>