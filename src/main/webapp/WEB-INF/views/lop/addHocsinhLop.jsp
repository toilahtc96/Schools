<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="/resources/css/lopstyle.css" var="lopStyle" />
<spring:url value="/resources/font-awesome-4.1.0/css/font-awesome.css" var="fontStyle" />

<link href="${bootstrap}" type="text/css" rel="stylesheet" />
<link href="${lopStyle}" type="text/css" rel="stylesheet" />
<link href="${fontStyle}" type="text/css" rel="stylesheet" />

<script src="/schools/resources/js/libs/bootstrap.min.js"></script>
<script src="/schools/resources/js/libs/jquery-1.9.1.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Untitled Document</title>
</head>
<body>

<div class="wapper">
<!-- header -->
<div id="header">
	<div class="left">
    	<a href="#" class="box1" >
        	<i class="fa fa-3x fa-home"></i>
        </a>
        <div class="box2">
        	<h3>Tiểu Học Imic</h3>
        </div>
        <div class="box3 dropdown-toggle dropdown" data-toggle="dropdown">Năm học 2016 - 2017 <span class="caret"></span></div>
        <ul class="dropdown-menu position">
        	<li><a href="#">Năm học 2016 - 2017</a></li>
            <li class="divider"></li>
            <li><a href="#">Danh sách năm học</a></li>
        </ul> 
    </div>
    
    <div class="right dropdown">
    	<div class="box1 dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> username <span class="caret"></span></div>
        <ul class="dropdown-menu" style="top:65px; right:0px; left:inherit;">
        	<li><a href="#"><i class="fa fa-cog"></i> Thông tin tài khoản</a></li>
            <li class="divider"></li>
            <li><a href="#"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>
        </ul> 
    </div>
    
    <div class="under"></div>
</div>

<!-- end header -->

<!-- content -->
<div id="addCotent">
	<div class="addBox">
    	<div class="head">Thêm Học Sinh Lớp ${khoahoc.lop.tenlop}</div>
        
        <div class="tit">
        	<div class="text">Họ và Tên :</div>
            <div class="text">Ngày Sinh :</div>
            <div class="text">Địa Chỉ :</div>
            <div class="text">Quê Quán :</div>
            <div class="text">Họ Tên Bố :</div>
            <div class="text">Họ Tên Mẹ :</div>
        </div>
        
        <div class="add">
        <form:form action="/schools/lop/${khoahoc.makhoahoc}/addHocsinh" commandName="hocsinh" method="POST" id="addhs">
        	<form:input type="text" class="form-control item" placeholder="Họ và Tên" path="ten" value="${hocsinh.ten}"/>
			<form:errors cssClass="error" path="ten" />
            
           <!--   <fmt:formatDate pattern="dd/mm/yyyy" var="birth" value="${date}"/> -->
            <form:input type="text" class="form-control item" placeholder="Ngày Sinh" path="ngaysinh"  />	
            <form:errors cssClass="error" path="ngaysinh" />
            
            <form:input type="text" class="form-control item" placeholder="Địa Chỉ" path="diachi" value="${hocsinh.diachi}"/>
            <form:errors cssClass="error" path="diachi" />
            
            <form:input type="text" class="form-control item" placeholder="Quê Quán" path="quequan" value="${hocsinh.quequan}"/>
            <form:errors cssClass="error" path="quequan" />
            
            <form:input type="text" class="form-control item" placeholder="Họ Tên Bố" path="bo" value="${hocsinh.bo}"/>
            <form:errors cssClass="error" path="bo" />
            
            <form:input type="text" class="form-control item" placeholder="Họ Tên Mẹ" path="me" value="${hocsinh.me}"/>
            <form:errors cssClass="error" path="me" />
        </form:form>
        
        </div>
        <button type="button" class="btn btn-success btn-block item fsize" style="height:50px;width:90%;margin-left:5%;" onclick="document.getElementById('addhs').submit();"><i class="fa fa-plus-square-o"> Thêm Học Sinh</i></button>
    </div>
 

<!-- content -->

<div class="deleteClass"></div>
<form>
<div class="deleteBox ${check == 0 ? 'delete' : 'delete-none'}">
	<div class="quest ${check == 0 ? 'delete' : 'delete-none'}"><b id="del">Học sinh này đã có trong cơ sở dữ liệu</b></div>
	<div class="quest ${check == 0 ? 'delete' : 'delete-none'}"><b id="del">Bạn có muốn thay đổi thông tin đã có không ?</b></div>
    <hr class="divider ${check == 0 ? 'delete' : 'delete-none'}" style="margin-top:10px;" />
    <div class="deleteBut ${check == 0 ? 'delete' : 'delete-none'}">
    	<a href="" id="aaa"><button type="button" class="btn btn-info" onclick="checkOK('${khoahoc.makhoahoc}')"><i class="fa fa-trash-o"> Đồng ý</i></button></a>
        <button type="button" class="btn btn-default btn-can" onclick="checkNone('${khoahoc.makhoahoc}')"><i class="fa fa-ban"> Hủy</i></button>
    </div>
</div>
</form>
</div>

</div>

<script>
$(document).ready(function(){
    $(".btn-del").click(function(){
        $(".deleteClass").fadeToggle("slow");
		
    });
});

$(document).ready(function(){
    $(".btn-can").click(function(){
        $(".deleteClass").fadeToggle("slow");
		
    });
});

function checkOK(id){
	document.getElementById("aaa").setAttribute("href","/schools/lop/"+id+"/addHocsinhLop");
}


</script>
</body>
</html>