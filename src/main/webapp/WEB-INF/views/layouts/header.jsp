<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css" />

<link
	href="<c:url value="/resources/font-awesome-4.1.0/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css" />

	
<link
	href="<c:url value="/resources/font-awesome-4.1.0/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/bootstrap-select.css"/>"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/vuong.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/cosovatchat.css"/>" rel="stylesheet"
	type="text/css" />
<script src="<c:url value="/resources/js/libs/jquery-1.9.1.js"/>"
		type="text/javascript"></script>

<script src="<c:url value="/resources/js/libs/bootstrap.min.js"/>"
	type="text/javascript"></script>

<script src="<c:url value="/resources/js/libs/jquery.min.js"/>"
	type="text/javascript"></script>

<script src="<c:url value="/resources/js/libs/bootstrap-select.js"/>"
	type="text/javascript"></script>
<div id="header">
	<div class="col-lg-6">
		<div class="header_left">
			<ul class="nav navbar-nav">
				<li><a data-toggle="tooltip" title="Trở Về Trang Chủ"
					href='<spring:url value="/home"></spring:url>' class="logo"><i
						class="fa fa-home"></i></a></li>
				<li><p class="ten_truong">Tiểu Học An Khánh</p></li>
				<li>
					<div class="dropdown nam_hoc">
						<a href="#" class="dropdown-toggle namhoc_title"
							data-toggle="dropdown">Năm Học 2015-2016 <i class="caret"></i>
						</a>
						<ul class="dropdown-menu nav navbar-nav namhoc_content">
							<li><a href="#">2015-2016</a></li>
							<li class="divider"></li>
							<li><a href="#">Danh Sách Năm Học</a></li>
						</ul>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<div class="col-lg-6">
		<div class="header_right">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Hello: Bùi Văn Vượng</a></li>
				<li class="dropdown"><a data-toggle="dropdown" href="#"
					class="setting dropdown-toggle"><i class="fa fa-user"></i><i
						class="caret"></i></a>
					<ul class="dropdown-menu nav navbar-nav setting_content">
						<li><a href="#"><i class="fa fa-gear"></i>Cài Đặt</a></li>
						<li><a href="#"><i class="fa fa-user"></i>Thông Tin Cá
								Nhân</a></li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-power-off"></i>Đăng Xuất</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</div>
<div class="clear"></div>
