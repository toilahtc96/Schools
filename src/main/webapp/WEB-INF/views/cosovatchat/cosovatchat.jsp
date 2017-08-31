<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<spring:url value="resources/css/lopstyle.css" var="lopStyle" />
<spring:url value="resources/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="resources/font-awesome-4.1.0/css/font-awesome.css"
	var="fontStyle" />

<link href="${bootstrap}" type="text/css" rel="stylesheet" />

<link href="${fontStyle}" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${lopStyle}" type="text/css" rel="stylesheet" />
<title>Cosovatchat</title>

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

		<div class="main">
			<div class="row">
				<div class="col-md-12">
					<ul class="nav nav-tabs h-tab-selection"
						style="text-align: center;">
						<li role="presentation" class="active"><a data-toggle
							href="#">Khuôn Viên</a></li>
						<li role="presentation" class="active"><a data-toggle
							href="#">Phòng Học</a></li>
						<li role="presentation" class="active"><a data-toggle
							href="#">Bàn Ghế</a></li>
						<li role="presentation" class="active"><a data-toggle
							href="#">Nhà Vệ Sinh</a></li>
						<li role="presentation" class="active"><a data-toggle
							href="#">Nhà Xe</a></li>
					</ul>
				</div>
				<div class="col-md-12">
					<div class="tab-content">
						<div id="/cosovatchat" class="tab-pane fade in active">
							<div id="infracstructure_save" class="btn btn-default pull-right"
								style="display: none">
								<i class="fa fa-remove"></i>"Hủy"
							</div>

							<form id="form_infrastructure" action="/cosovatchat/khuonvien"
								accept-charset="UTF-8" method="post">
								<input name="utf8" style="display: none" value="✓"><input
									style="display: none" name="authenticity_token"
									value="i/3TTTJqr9LdcTlTDM8ZHupvQyeYQwCVofvpaYR82gMvvhgF3d5hqsBZ33nxAOTu00V8KOc+nKsLAYDbHykNBQ==">
								<input style="display: none" name="category" id="category"
									value="khuonvien"> <input style="display: none"
									name="content_csv" id="content_csv" value="">
								<div id="infrastructures_save"
									class="btn btn-default pull-right" style="display: none">
									<i class="fa fa-save"></i> Lưu
								</div>
								<div id="infrastructures_edit"
									class="btn btn-default pull-right">
									<i class="fa fa-pencil"></i> Sửa
								</div>
							</form>
							<div class="table-responsive">
								<table
									class="table table-bordered table-condensed table-infrastructure">
									<thead>
										<tr>
											<th rowspan="2">Điểm trường</th>
											<th rowspan="2">Tổng diện tích (m2)</th>
											<th rowspan="2">Được cấp (m2)</th>
											<th rowspan="2">Đi thuê (m2)</th>
											<th rowspan="2">Sân chơi (m2)</th>
											<th rowspan="2">Sân tập (m2)</th>
											<th colspan="2">Vườn trường</th>
										</tr>
										<tr>
											<th>Số lượng</th>
											<th>
												<div data-toggle="tooltip" data-placement="top" title=""
													data-original-title="Điền 'x' nếu có.
Để trống nếu không.">
													Đủ điều kiện tổ chức dạy ngoài trời? (x)</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listdt}" var="dt" varStatus="s">
											<tr>
												<td class="cell-header">${dt.tendiemtruong}</td>
												<td class="cell-edit" id="infrast_info_0_0">34</td>

											</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>