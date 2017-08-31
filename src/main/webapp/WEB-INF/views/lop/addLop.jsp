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
    	<div class="head">Thêm Lớp</div>
        
        <div class="tit">
        	<div class="text">Tên Lớp Học :</div>
            <div class="text">Điểm Trường :</div>
            <div class="text">Năm Học :</div>
            <div class="text">Học Kỳ :</div>
            <div class="text">Số Tiết Học :</div>
        </div>
        
        <div class="add">
        <form:form action="/schools/lop/addLop" commandName="loptemp" method="POST" id="add">
        	<form:input type="text" class="form-control item" placeholder="Tên Lớp" path="tenlop" />
			<form:errors cssClass="error" path="tenlop" />
            <form:select class="form-control item" path="diemtruong">
            	<form:options items="${dt}" itemValue="madiemtruong"  />
            </form:select>
            <form:errors cssClass="error" path="diemtruong" />
            
           <form:select class="form-control item" path="namhoc">
            	<form:options items="${nam}" itemValue="manamhoc"/>
            </form:select>
            <form:errors cssClass="error" path="namhoc" />
            
            <form:select class="form-control item" path="hocky">
            	<form:options items="${hk}" itemValue="mahocky" />
            </form:select>
            <form:errors cssClass="error" path="hocky" />
            
            <form:input type="text" class="form-control item" placeholder="Số Tiết Học" path="sotiethoc" />
            <form:errors cssClass="error" path="sotiethoc" />
        </form:form>
        
        </div>
        <button type="button" class="btn btn-success btn-block item fsize" style="height:50px;width:90%;margin-left:5%;" onclick="document.getElementById('add').submit();"><i class="fa fa-plus-square-o"> Thêm Lớp</i></button>
    </div>
 
</div>
<!-- content -->

</div>
</body>
</html>