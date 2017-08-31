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

<script src="/resources/js/libs/bootstrap.min.js"></script>
<script src="/resources/js/libs/jquery-1.9.1.js"></script>


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
    	<div class="head">Sửa Thông Tin Lớp Học</div>
        
        <div class="tit">
        	<div class="text">Tên Lớp Học :</div>
            <div class="text">Năm Học :</div>
            <div class="text">Học Kỳ :</div>
            <div class="text">Số Tiết Học :</div>
        </div>
        
        <div class="add">
        <form:form action="/schools/lop/update" commandName="update" method="POST" id="update">
        	<form:label class="form-control item" path="tenlop">${khoahoc.lop.tenlop}</form:label>
            
           <form:select class="form-control item" path="namhoc">
            	<c:forEach items="${nam}" var="n" varStatus="status">
            	<c:choose>
            			<c:when test="${n.manamhoc eq khoahoc.namhoc.manamhoc}">
                			<option value="${n.manamhoc}" selected="true">${n}</option>
            			</c:when>
            			<c:otherwise>
                			<option value="${n.manamhoc}">${n}</option>
            			</c:otherwise>
        			</c:choose>
        		</c:forEach> 
            </form:select>
            
            <form:select class="form-control item" path="hocky">
            	<c:forEach items="${hk}" var="h" varStatus="status">
            		<c:choose>
            			<c:when test="${h.mahocky eq khoahoc.hocky.mahocky}">
                			<option value="${h.mahocky}" selected="true">${h}</option>
            			</c:when>
            			<c:otherwise>
                			<option value="${h.mahocky}">${h}</option>
            			</c:otherwise>
        			</c:choose> 
        		</c:forEach>
            </form:select>
            
            <form:input type="text" class="form-control item" placeholder="${khoahoc.lop.sotiethoc}" path="sotiethoc" />
        </form:form>
        
        </div>
        <button type="button" class="btn btn-success btn-block item fsize" style="height:50px;width:90%;margin-left:5%;" onclick="document.getElementById('update').submit();"><i class="fa fa-pencil"> Cập Nhật</i></button>
    </div>
 
</div>
<!-- content -->

</div>
</body>
</html>