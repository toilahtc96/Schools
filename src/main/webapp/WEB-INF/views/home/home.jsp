<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<html>
<head>
<link href="resources/css/bootstrap.min.css" type="text/css"
	rel="stylesheet" />
<link href="resources/css/homestyle.css" type="text/css"
	rel="stylesheet" />
<link href="resources/font-awesome-4.1.0/css/font-awesome.css"
	type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Untitled Document</title>

<script src="resources/js/libs/jquery-1.9.1.js"></script>
<script src="resources/js/libs/bootstrap.min.js"></script>

</head>

<body>
	<div class="wapper">
		<!-- header -->
		<div id="header">
			<div class="left">
				<a href="#" class="box1"> <i class="fa fa-3x fa-home"></i>
				</a>
				<div class="box2">
					<h3>Tiểu Học Imic</h3>
				</div>
				<div class="box3 dropdown-toggle dropdown" data-toggle="dropdown">
					Năm học 2016 - 2017 <span class="caret"></span>
				</div>
				<ul class="dropdown-menu position">
					<li><a href="#">Năm học 2016 - 2017</a></li>
					<li class="divider"></li>
					<li><a href="#">Danh sách năm học</a></li>
				</ul>
			</div>

			<div class="right dropdown">
				<div class="box1 dropdown-toggle" data-toggle="dropdown">
					<i class="fa fa-user"></i> username <span class="caret"></span>
				</div>
				<ul class="dropdown-menu"
					style="top: 65px; right: 0px; left: inherit;">
					<li><a href="#"><i class="fa fa-cog"></i> Thông tin tài
							khoản</a></li>
					<li class="divider"></li>
					<li><a href="#"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>
				</ul>
			</div>

			<div class="under"></div>
		</div>

		<!-- content -->
		<div id="content">

			<div class="main">

				<div class="box1 row">
					<div class="center">
						<a href='<spring:url value="/diemtruong"></spring:url>' class="box">
						<div>
								<i class="fa fa-2x fa-university inside"></i>
							</div>
							<div class="space">Thông tin nhà trường</div> </a>
						<a href='<spring:url value="/giaovien"></spring:url>'	class="box"><div>
								<i class="fa fa-2x fa-users inside"></i>
							</div>
							<div class="space">Danh sách đội ngũ</div></a>
						<a
							href='<spring:url value="/lop"></spring:url>' class="box"><div>
								<i class="fa fa-2x fa-th-large inside"></i>
							</div>
							<div class="space">Danh mục lớp học</div></a>
						<a
							href='<spring:url value="/phancong"></spring:url>' class="box"><div>
								<i class="fa fa-2x fa-calendar inside"></i>
							</div>
							<div class="space">Phân công giảng dạy</div></a>
						<a
							href="#" class="box"><div>
								<i class="fa fa-2x fa-child inside"></i>
							</div>
							<div class="space">Danh sách học sinh</div></a> <a href="cosovatchat/khuonvien"
							class="box"><div>
								<i class="fa fa-2x fa-archive inside"></i>
							</div>
							<div class="space">Cơ sở vật chất</div></a>
					</div>
				</div>

				<div class="box2">
					<div class="mainContent">
						<div class="header">Tổng quan nhận xét và đánh giá</div>
						<div class="session">Tổng số giáo viên :</div>
						<div class="session">Tổng số lớp học :</div>
						<div class="session">Tổng số học viên :</div>
						<div class="session">Tổng số thiết bị cơ sở vật chất :</div>
						<div class="session"></div>
					</div>
				</div>
			</div>

		</div>
		<!-- end content -->
	</div>
	<!-- script -->

</body>
</html>