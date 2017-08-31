<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nhà Vệ Sinh</title>
</head>
<body>
	<jsp:include page="../layouts/header.jsp"></jsp:include>
	<div id="content">
		<div class="main">
			<div class="row">
				<div class="col-md-12 abc">
					<ul class="nav nav-tabs h-tab-selection">
						<li role="presentation"><a
							data-toggle href="khuonvien">Khuôn Viên</a></li>
						<li role="presentation" ><a data-toggle
							href="phonghoc">Phòng Học</a></li>
						<li role="presentation" ><a data-toggle
							href="banghe">Bàn Ghế</a></li>
						<li role="presentation" class="active"><a data-toggle
							href="nhavesinh">Nhà Vệ Sinh</a></li>
						<li role="presentation" ><a data-toggle
							href="nhaxe"">Nhà Xe</a></li>
						<li role="presentation" ><a data-toggle
							href="thietbi">Thiết Bị</a></li>
					</ul>
				</div>
				<div class="col-md-12">
					<div class="tab-content">
						<div class="table-responsive" style="margin-top: 20px;">
							<table id="nvs-table"
								class="table table-bordered table-condensed table-infrastructure">
								<thead>
									<tr>
										<th rowspan="3">Điểm trường</th>
										<th colspan="8">Nhà Vệ Sinh Đạt Chuẩn</th>
										<th colspan="8">Nhà Vệ Sinh Chưa Chuẩn</th>
										<th rowspan="3" colspan="2">Xác Nhận</th>
									</tr>
									<tr>
										<th colspan="2">Giáo Viên Nam</th>
										<th colspan="2">Giáo Viên Nữ</th>
										<th colspan="2">Học Sinh Nam</th>
										<th colspan="2">Học Sinh Nữ</th>
										<th colspan="2">Giáo Viên Nam</th>
										<th colspan="2">Giáo Viên Nữ</th>
										<th colspan="2">Học Sinh Nam</th>
										<th colspan="2">Học Sinh Nữ</th>

									</tr>
									<tr>
										<th colspan="1">Số Lượng</th>
										<th colspan="1">Diện Tích</th>
										<th colspan="1">Số Lượng</th>
										<th colspan="1">Diện Tích</th>
										<th colspan="1">Số Lượng</th>
										<th colspan="1">Diện Tích</th>
										<th colspan="1">Số Lượng</th>
										<th colspan="1">Diện Tích</th>
										<th colspan="1">Số Lượng</th>
										<th colspan="1">Diện Tích</th>
										<th colspan="1">Số Lượng</th>
										<th colspan="1">Diện Tích</th>
										<th colspan="1">Số Lượng</th>
										<th colspan="1">Diện Tích</th>
										<th colspan="1">Số Lượng</th>
										<th colspan="1">Diện Tích</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${nhavss}" var="nhavs">
										<form:form action="nhavesinh" modelAttribute="nhavesinhtemp"
											method="POST">
											<tr id="data_${nhavs.maNvs}">
												<td style="background-color: lightyellow !important;">${nhavs.cosovatchat.diemtruong.tendiemtruong}</td>
												<form:input path="maNvs" value="${nhavs.maNvs}" type="text"
													size="3" style="display:none;" />
												<td><form:input
														style="display: none; margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}$" size="3"
														value="${nhavs.gvnamdatchuan }" path="gvnamdatchuan" /> <span>${nhavs.gvnamdatchuan }</span></td>
												<td><form:input
														style="display: none; margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$"
														size="3" value="${nhavs.sgvnamchuan}" path="sgvnamchuan" />
													<span>${nhavs.sgvnamchuan }</span></td>

												<td><form:input
														style="display: none; margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}$" size="3"
														value="${nhavs.gvnudatchuan }" path="gvnudatchuan" /> <span>${nhavs.gvnudatchuan }</span></td>

												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$"
														size="3" value="${nhavs.sgvnnuchuan }" path="sgvnnuchuan" />
													<span>${nhavs.sgvnnuchuan }</span></td>

												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}$" size="3"
														value="${nhavs.hsnamdatchuan }" path="hsnamdatchuan" /> <span>${nhavs.hsnamdatchuan }</span></td>
												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$"
														size="3" value="${nhavs.shsnamchuan }" path="shsnamchuan" />
													<span>${nhavs.shsnamchuan }</span></td>
												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}$" size="3"
														value="${nhavs.hsnudatchuan }" path="hsnudatchuan" /> <span>${nhavs.hsnudatchuan }</span></td>
												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$"
														size="3" value="${nhavs.shsnuchuan }" path="shsnuchuan" />
													<span>${nhavs.shsnuchuan }</span></td>

												<td c><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}$" size="3"
														value="${nhavs.gvnamchuadatchuan }"
														path="gvnamchuadatchuan" /> <span>${nhavs.gvnamchuadatchuan }</span></td>
												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$"
														size="3" value="${nhavs.sgvnamchuachuan }"
														path="sgvnamchuachuan" /> <span>${nhavs.sgvnamchuachuan }</span></td>

												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}$" size="3"
														value="${nhavs.gvnuchuadatchuan }" path="gvnuchuadatchuan" />
													<span>${nhavs.gvnuchuadatchuan }</span></td>
												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$"
														size="3" value="${nhavs.sgvnuchuachuan }"
														path="sgvnuchuachuan" /> <span>${nhavs.sgvnuchuachuan }</span></td>

												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}$" size="3"
														value="${nhavs.hsnamchuadatchuan }"
														path="hsnamchuadatchuan" /> <span>${nhavs.hsnamchuadatchuan }</span></td>
												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$"
														size="3" value="${nhavs.shsnamchuachuan }"
														path="shsnamchuachuan" /> <span>${nhavs.shsnamchuachuan }</span></td>

												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}$" size="3"
														value="${nhavs.hsnuchuadatchuan }" path="hsnuchuadatchuan" />
													<span>${nhavs.hsnuchuadatchuan }</span></td>
												<td><form:input
														style="display: none;margin-left:0px !important;"
														type="text" pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$"
														size="3" value="${nhavs.shsnuchuachuan }"
														path="shsnuchuachuan" /> <span>${nhavs.shsnuchuachuan }</span></td>

												<td class="buttonedit"><button type="button"
														class="editbutton btn btn-default pull-right"
														onclick="edit(${nhavs.maNvs});">
														<i class="fa fa-pencil"></i>
													</button>
													<button type="button"
														class="cancelbutton btn btn-default pull-right"
														style="display: none;" onclick="cancel(${nhavs.maNvs});">
														<i class="fa fa-undo"></i>
													</button></td>
												<td class="buttonupdate"><button type="submit"
														class="fa fa-upload btn btn-default pull-right"></button></td>
										</form:form>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div style="text-align: center">${EMPTY}</div>
	<jsp:include page="../layouts/footer.jsp"></jsp:include>

	<script>
	function edit(maNvs) {
		$("#nvs-table tr").removeClass('canceltable');
		var id = '#data_'+ maNvs;
		$(id).addClass("editable");
	};
	
	function cancel(maNvs) {
		$("#nvs-table tr").removeClass('editable');
		var id = '#data_'+ maNvs;
		$(id).addClass('canceltable');
	};
		
	</script>
</body>
</html>