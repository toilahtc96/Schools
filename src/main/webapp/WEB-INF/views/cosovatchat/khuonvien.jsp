<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Khuôn Viên</title>
</head>
<body>
	<jsp:include page="../layouts/header.jsp"></jsp:include>
	<div id="content">
		<div class="main">
			<div class="row">
				<div class="col-md-12 abc">
					<ul class="nav nav-tabs h-tab-selection">
						<li role="presentation" class="active"><a data-toggle
							href="khuonvien">Khuôn Viên</a></li>
						<li role="presentation"><a data-toggle href="phonghoc">Phòng
								Học</a></li>
						<li role="presentation"><a data-toggle href="banghe">Bàn
								Ghế</a></li>
						<li role="presentation"><a data-toggle href="nhavesinh">Nhà
								Vệ Sinh</a></li>
						<li role="presentation"><a data-toggle href="nhaxe"">Nhà
								Xe</a></li>
						<li role="presentation"><a data-toggle href="thietbi">Thiết
								Bị</a></li>
					</ul>
				</div>
				<div class="col-md-12">
					<div class="tab-content">
						<div class="table-responsive" style="margin-top: 20px;">
							<table id="khuonvien-table"
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
										<th colspan="2" rowspan="2" style="width: auto;">Thao Tác</th>
									</tr>
									<tr>
										<th>Số lượng</th>
										<th><span data-toggle="tooltip" data-placement="top"
											title=""
											data-original-title="Điền 'x' nếu có.
Để trống nếu không.">
												Đủ điều kiện dạy ngoài trời? (x)</span></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${khuonviens}" var="khuonvien" varStatus="s">
										<form:form action="khuonvien" modelAttribute="khuonvientemp"
											method="POST">
											<tr id="data_${khuonvien.makhuonvien}">
												<form:input path="makhuonvien" style="display:none;"
													value="${khuonvien.makhuonvien}" />
												<td style="background-color: lightyellow !important;">${khuonvien.cosovatchat.diemtruong.tendiemtruong}</td>
												<td style="background-color: lightyellow !important;">
												 ${listsum.get(s.index)} 
												</td>
												<td class="ip"><form:input
														style="display:none;margin-left: 0px !important;" pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$"
														path="duoccap" value="${khuonvien.duoccap}" /> <span
													class="tdtext">${khuonvien.duoccap}</span></td>

												<td class="ip"><form:input
														style="display:none;margin-left: 0px !important;"
														pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$" path="dithue"
														value="${khuonvien.dithue}" /> <span class="tdtext">${khuonvien.dithue}
												</span></td>

												<td class="ip"><form:input
														style="display:none;margin-left: 0px !important;"
														pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$" path="sanchoi"
														value="${khuonvien.sanchoi}" /> <span class="tdtext">${khuonvien.sanchoi}</span></td>

												<td class="ip"><form:input
														style="display:none;margin-left: 0px !important;"
														pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$" path="santap"
														value="${khuonvien.santap}" /> <span class="tdtext">${khuonvien.santap}
												</span></td>

												<td class="ip"><form:input
														style="display:none;margin-left: 0px !important; "
														pattern="^[0-9]{1,6}$" path="soluonvuon"
														value="${khuonvien.soluonvuon}" /> <span class="tdtext">${khuonvien.soluonvuon}</span></td>

												<td class="ip"><form:input
														style="display:none; margin-left: 0px !important; "
														path="dieukienngoaitroi"
														value="${khuonvien.dieukienngoaitroi}" /> <span
													class="tdtext">${khuonvien.dieukienngoaitroi}</span></td>
												<td class="buttonedit">
													<button type="button"
														class="editbutton btn btn-default pull-left"
														onclick="editkv(${khuonvien.makhuonvien});">
														<i class="fa fa-edit"></i>
													</button>
													<button style="display: none;" type="button"
														class="cancelbutton btn btn btn-default pull-left"
														onclick="cancelkv(${khuonvien.makhuonvien});">
														<i class="fa fa-undo"></i>
													</button>
												</td>
												<td colspan="1" class="buttonupdate"><button
														type="submit" class=" btn btn-default pull-left">
														<i class="fa fa-upload"></i>
													</button></td>
											</tr>
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
	function editkv(makhuonvien){
		$("#khuonvien-table tr").removeClass('canceltable');
		var id = '#data_'+makhuonvien;
		$(id).addClass('editable');
	};
	function cancelkv(makhuonvien) {
		$("#khuonvien-table tr").removeClass('editable');
		var id = '#data_'+makhuonvien;
		$(id).addClass("canceltable");
	};
</script>

</body>
</html>