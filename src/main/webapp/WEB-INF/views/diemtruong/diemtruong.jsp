<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="resources/font-awesome-4.1.0/css/font-awesome.css"
	var="fontStyle" />
<spring:url value="resources/css/bootstrap.min.css" var="bootstrap" />

<link href="${bootstrap}" type="text/css" rel="stylesheet" />
<link href="${fontStyle}" type="text/css" rel="stylesheet" />
<link href="${Style}" type="text/css" rel="stylesheet" />
<title>Diem Truong</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="resources/js/libs/jquery-1.9.1.js"></script>
<script src="resources/js/libs/bootstrap.min.js"></script>
</head>
<body>

	<!-- header -->
	<div id="header">
		<div class="left">
			<a href="<spring:url value="/home"></spring:url>" class="box1"> <i
				class="fa fa-3x fa-home"></i>
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

	<!-- end header -->


	<!-- Content -->

	<div class="row"">
		<div class="col-md-12" style="margin-top: 50px;">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#page1" data-toggle="tab">Thông
						Tin Chung</a></li>
				<li><a href="#page2" data-toggle="tab">Điẻm Trường</a></li>
				<li><a href="#page3" data-toggle="tab">Năm Học</a></li>
				<li><a href="#page4" data-toggle="tab">Môn Học</a></li>
			</ul>
		</div>
	</div>
	<div class="col-md-12" style="text-align: center;">
		<div class="tab-content">
			<div class="tab-pane fade active in" id="page1">
				<div class="truong-info-box">
					<div class="line" style="padding-top: 30px;">
						<div class="left">Tên Trường :</div>
						<div class="right">Tiểu Học Imic</div>
					</div>

					<div class="line">
						<div class="left">Thành Phố :</div>
						<div class="right">Hà Nội</div>
					</div>

					<div class="line">
						<div class="left">Quận :</div>
						<div class="right">Cầu Giấy</div>
					</div>

					<div class="line">
						<div class="left">Loại Trường :</div>
						<div class="right">Tiểu Học</div>
					</div>

					<div class="line">
						<div class="left">Loại Hình :</div>
						<div class="right">Công Lập</div>
					</div>

					<div class="line">
						<div class="left">Hiệu Trưởng :</div>
						<div class="right">Nguyễn Văn Đoàn</div>
					</div>

					<div class="line">
						<div class="left">Số ĐIện Thoại :</div>
						<div class="right">1900561252</div>
					</div>

					<div class="line">
						<div class="left">Email :</div>
						<div class="right">imic@edu.vn</div>

					</div>

					<div class="line">
						<hr />
					</div>

					<div class="line" style="margin-top: 0px;">
						<button class="btn btn-success but">
							<i class="fa fa-edit"></i> Sửa
						</button>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="page2">
				<div class="row">
					<div id="dt" class="col-md-12 E-info">
						<div class="line">
							<div class="count">Số Điểm Trường :</div>
							<button id="tab" class="btn btn-default edit-but">
								<i class="fa fa-edit"></i> Sửa
							</button>
						</div>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-condensed">
								<thead>
									<tr style="text-align: center;">
										<th>STT</th>
										<th>Tên Điểm Trường</th>
										<th>Địa Chỉ</th>
										<th>Email</th>
										<th>SĐT</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="diemtruong" items="${diemtruongs}"
										varStatus="indexes">
										<tr>
											<td>${indexes.index + 1}</td>
											<td>${diemtruong.tendiemtruong}</td>
											<td>${diemtruong.diachi}</td>
											<td>${diemtruong.email}</td>
											<td>${diemtruong.sdt}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div id="edit-dt" class="col-md-12 E-info edit">
						<div class="edit-box">

							<div id="edit-box">
								<div class="line">
									<div class="tit">Tên ĐIểm Trường</div>
									<div class="tit">Email</div>
									<div class="tit">SĐT</div>
								</div>

								<c:forEach var="diemtruong" items="${diemtruongs}"
									varStatus="indexes">

									<div class="line">
										<input type="text" class="form-control item"
											placeholder="Tên Điểm Trường"
											value="${diemtruong.tendiemtruong}" name="tendiemtruong"
											disabled="true" /> <input type="text"
											class="form-control item" placeholder="Email"
											value="${diemtruong.email}" name="email" /> <input
											type="text" class="form-control item" placeholder="SĐT"
											value="${diemtruong.sdt}" name="sdt" />
										<div class="butItem">
											<button id="but" type="button" class="btn btn-danger but"
												disabled="true">
												<i class="fa fa-trash-o"></i>
											</button>
										</div>
									</div>

								</c:forEach>

							</div>

							<form action="/schools/diemtruong/updatedt" method="post" id="sub">
								<input type="hidden" name="listen" id="x" /> 
								<input type="hidden" name="lisemail" id="y" /> 
								<input type="hidden" name="lissdt" id="z" />
							</form>

							<div class="line">
								<div class="add-but">
									<button id="add-but" type="button" class="btn btn-success">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</div>

							<div class="line">
								<button id="cancle-dt" type="button"
									class="btn btn-default under-but fl-l">
									<i class="fa fa-ban"></i> Hủy
								</button>
								<button type="button" class="btn btn-info under-but fl-r"
									onclick="getInfo()">
									<i class="fa fa-wrench"></i> OK
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="tab-pane fade" id="page3">
				<div class="row">
					<div id="namhoc" class="col-md-12 E-info">
						<div class="line">
							<div class="count">Số Năm Học :</div>
							<button id="editnam-but" class="btn btn-default edit-but">
								<i class="fa fa-edit"></i> Sửa
							</button>
						</div>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-condensed">
								<thead>
									<tr style="text-align: center;">
										<th>STT</th>
										<th>Thời gian</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="namhoc" items="${namhocs}" varStatus="indexes">
										<tr>
											<td>${indexes.index + 1}</td>
											<td>${namhoc.thoigian}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div id="edit-namhoc" class="col-md-12 E-info edit">
						<div class="edit-box">

							<div class="line">
								<div class="tit">Năm học</div>
							</div>
							<c:forEach var="namhoc" items="${namhocs}" varStatus="indexes">
								<div class="line">
									<input type="text" id="disabledInput"
										class="form-control oitem" placeholder="Thời Gian Học"
										value="${namhoc.thoigian}" disabled="true" />
									<div class="butItem">
										<button id="but" type="button" class="btn btn-danger but"
											disabled="true">
											<i class="fa fa-trash-o"></i>
										</button>
									</div>
								</div>
							</c:forEach>

							<div id="nedit-box"></div>

							<div class="line">
								<div class="add-but">
									<button id="nadd-but" type="button" class="btn btn-success">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</div>

							<form action="/schools/diemtruong/updatenh" method="post"
								id="subnh">
								<input type="hidden" name="lisnh" id="fnamhoc" value="" />
							</form>

							<div class="line">
								<button id="cancle-nam" type="button"
									class="btn btn-default under-but fl-l">
									<i class="fa fa-ban"></i> Hủy
								</button>
								<button type="button" class="btn btn-info under-but fl-r"
									onclick="getInfoNh()">
									<i class="fa fa-wrench"></i> OK
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="page4">
				<div class="row">
					<div id="monhoc" class="col-md-12 E-info">
						<div class="line">
							<div class="count">Số Môn Học :</div>
							<button id="editmonhoc-but" class="btn btn-default edit-but">
								<i class="fa fa-edit"></i> Sửa
							</button>
						</div>
						<div class="table-responsive">
							<table class="table table-bordered table-hover table-condensed">
								<thead>
									<tr style="text-align: center;">
										<th>STT</th>
										<th>Tên Môn Học</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="monhoc" items="${monhocs}" varStatus="indexes">
										<tr>
											<td>${indexes.index + 1}</td>
											<td>${monhoc.tenmonhoc}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div id="edit-monhoc" class="col-md-12 E-info edit">
						<div class="edit-box">

							<div class="line">
								<div class="tit">Môn Học</div>
							</div>

							<c:forEach var="monhoc" items="${monhocs}" varStatus="indexes">
								<div class="line">
									<input type="text" id="disabledInput"
										class="form-control oitem" placeholder="Tên Môn Học"
										value="${monhoc.tenmonhoc}" disabled="true" />
									<div class="butItem">
										<button id="but" type="button" class="btn btn-danger but"
											disabled="true">
											<i class="fa fa-trash-o"></i>
										</button>
									</div>
								</div>
							</c:forEach>

							<div id="medit-box"></div>

							<form action="/schools/diemtruong/updatemh" method="post"
								id="submh">
								<input type="hidden" name="lismh" id="fmonhoc" value="" />
							</form>

							<div class="line">
								<div class="add-but">
									<button id="madd-but" type="button" class="btn btn-success">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</div>

							<div class="line">
								<button id="cancle-monhoc" type="button"
									class="btn btn-default under-but fl-l">
									<i class="fa fa-ban"></i> Hủy
								</button>
								<button type="button" class="btn btn-info under-but fl-r"
									onclick="getInfoMh()">
									<i class="fa fa-wrench"></i> OK
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		//diemtruong
$(document).ready(function() {
	$("#edit-but").click(function() {
	$("#dt").fadeToggle("fast");
	$("#edit-dt").fadeToggle("slow");
	});

$("#cancle-dt").click(function() {
	$("#dt").fadeToggle("fast");
	$("#edit-dt").fadeToggle("slow");
	});

$(".but").on("click", function(e) {
	e.preventDefault();
    ($(this).parent()).parent().remove();
	});

$("#add-but").click(function(e) { 
	e.preventDefault();
	var x = '<div class="line">'
			+ '<input type="text" class="form-control item" placeholder="Tên Điểm Trường" name="tendiemtruong" />'
			+ '<input type="text" class="form-control item" placeholder="Email" name="email" />'
			+ '<input type="text" class="form-control item" placeholder="SĐT" name="sdt" />'
			+ '<div class="butItem">'
			+ '<button id="but" type="button" class="btn btn-danger but"><i class="fa fa-trash-o"></i>'
			+ '</button></div></div>';

			$("#edit-box").append(x);
			$(document).ready(function() {(".but").on("click",function(e) {e.preventDefault();($(this).parent()).parent().remove();});});
				});

							//namhoc 
							$("#editnam-but").click(function() {
								$("#namhoc").fadeToggle("fast");
								$("#edit-namhoc").fadeToggle("slow");
							});

							$("#cancle-nam").click(function() {
								$("#namhoc").fadeToggle("fast");
								$("#edit-namhoc").fadeToggle("slow");
							});

							$("#nadd-but")
									.click(
											function(e) {
												e.preventDefault();
												var x = '<div class="line">'
														+ '<input type="text" class="form-control oitem" placeholder="Thời Gian Học" name="inputnamhoc" />'
														+ '<div class="butItem"><button id="but" type="button" class="btn btn-danger but"><i class="fa fa-trash-o"></i></button></div>'
														+ '</div>';

												$("#nedit-box").append(x);
												$(document)
														.ready(
																function() {
																	$(".but")
																			.on(
																					"click",
																					function(
																							e) {
																						e
																								.preventDefault();
																						($(this)
																								.parent())
																								.parent()
																								.remove();
																					});
																});
											});

							// mon hoc

							$("#editmonhoc-but").click(function() {
								$("#monhoc").fadeToggle("fast");
								$("#edit-monhoc").fadeToggle("slow");
							});

							$("#cancle-monhoc").click(function() {
								$("#monhoc").fadeToggle("fast");
								$("#edit-monhoc").fadeToggle("slow");
							});

							$("#madd-but")
									.click(
											function(e) {
												e.preventDefault();
												var x = '<div class="line">'
														+ '<input type="text" class="form-control oitem" placeholder="Tên Môn Học" name="inputmonhoc" />'
														+ '<div class="butItem"><button id="but" type="button" class="btn btn-danger but"><i class="fa fa-trash-o"></i></button></div>'
														+ '</div>';

												$("#medit-box").append(x);
												$(document)
														.ready(
																function() {
																	$(".but")
																			.on(
																					"click",
																					function(
																							e) {
																						e
																								.preventDefault();
																						($(this)
																								.parent())
																								.parent()
																								.remove();
																					});
																});
											});

						});

		var s = new Array();
		<c:forEach items="${namhocs}" var="nh">
		var nam = new Object();
		nam = '${nh.thoigian}';

		s.push(nam);
		</c:forEach>

		function getInfoNh() {
			var namhoc = document.getElementsByName("inputnamhoc");

			for (var i = 0; i < namhoc.length; i++) {
				if ((namhoc.item(i).value == "")) {
					alert("chưa điền đầy đủ thông tin");
					return;
				}
			}

			var pat = /[0-9]{4}\s*-{1}\s*[0-9]{4}/;

			for (var i = 0; i < namhoc.length; i++) {
				if (!pat.test(namhoc.item(i).value)) {
					alert("Nhập sai thời gian học !!!!");
					return;
				}
			}

			for (var i = 0; i < namhoc.length - 1; i++) {
				for (var j = i + 1; j < namhoc.length; j++) {
					if (namhoc.item(i).value == namhoc.item(j).value) {
						alert("năm học đã nhập bị trùng ");
						return;
					}
				}
			}

			for (var i = 0; i < namhoc.length; i++) {
				for (var j = 0; j < s.length; j++) {
					if (namhoc.item(i).value == s[j]) {
						alert("năm học đã nhập bị trùng");
						return;
					}
				}
			}

			var arry = new Array();
			for (var i = 0; i < namhoc.length; i++) {
				var v = namhoc.item(i).value;
				arry.push(v);
			}

			document.getElementById("fnamhoc").setAttribute("value", arry);
			document.getElementById("subnh").submit();
		}

		var mons = new Array();
		<c:forEach items="${monhocs}" var="mh">
		var mon = new Object();
		mon = '${mh.tenmonhoc}';

		s.push(mon);
		</c:forEach>

		function getInfoMh() {
			var monhoc = document.getElementsByName("inputmonhoc");

			for (var i = 0; i < monhoc.length; i++) {
				if ((monhoc.item(i).value == "")) {
					alert("chưa điền đầy đủ thông tin");
					return;
				}
			}

			var pat = /[a-z A-Z]{2,}/i;

			for (var i = 0; i < monhoc.length; i++) {
				if (!pat.test(monhoc.item(i).value)) {
					alert("Nhập sai Tên Môn Học !!!!");
					return;
				}
			}

			for (var i = 0; i < monhoc.length - 1; i++) {
				for (var j = i + 1; j < monhoc.length; j++) {
					if (monhoc.item(i).value == monhoc.item(j).value) {
						alert("Môn học đã nhập bị trùng ");
						return;
					}
				}
			}

			for (var i = 0; i < monhoc.length; i++) {
				for (var j = 0; j < s.length; j++) {
					if (monhoc.item(i).value == mons[j]) {
						alert("Môn học đã nhập bị trùng");
						return;
					}
				}
			}

			var arry = new Array();
			for (var i = 0; i < monhoc.length; i++) {
				var v = monhoc.item(i).value;
				arry.push(v);
			}

			document.getElementById("fmonhoc").setAttribute("value", arry);
			document.getElementById("submh").submit();
		}

		function getInfo() {
			var ten = document.getElementsByName("tendiemtruong");
			var email = document.getElementsByName("email");
			var sdt = document.getElementsByName("sdt");

			for (var i = 0; i < ten.length; i++) {
				if ((ten.item(i).value == "") || (email.item(i).value == "")
						|| (sdt.item(i).value == "")) {
					alert("chưa điền đầy đủ thông tin");
					return;
				}
			}

			var pattern = /[0-9]{9,12}/;
			for (var i = 0; i < sdt.length; i++) {
				if (!pattern.test(sdt.item(i).value)) {
					alert("Số điện thoại không đúng");
					return;
				}
			}

			var mailpattern = /[a-z 0-9]{1,}@{1}[a-z]{1,}\.{1}[a-z \.]{1,}/i;
			;
			for (var i = 0; i < email.length; i++) {
				if (!mailpattern.test(email.item(i).value)) {
					alert("Email không đúng");
					return;
				}
			}

			for (var i = 0; i < ten.length - 1; i++) {
				for (var j = i + 1; j < ten.length; j++) {
					if (ten.item(i).value == ten.item(j).value) {
						alert("Điểm trường bị trùng ở vị trí số " + (i + 1)
								+ " và " + (j + 1));
						return;
					}
				}
			}

			var x = new Array();
			var y = new Array();
			var z = new Array();
			for (var i = 0; i < ten.length; i++) {
				var v = ten.item(i).value;
				var f = email.item(i).value;
				var a = sdt.item(i).value;
				x.push(v);
				y.push(f);
				z.push(a);
			}

			document.getElementById("x").setAttribute("value", x);
			document.getElementById("y").setAttribute("value", y);
			document.getElementById("z").setAttribute("value", z);
			document.getElementById("sub").submit();
		}
	</script>

	<!-- End Content -->


</body>
</html>