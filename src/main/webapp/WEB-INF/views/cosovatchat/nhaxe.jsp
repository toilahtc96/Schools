<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nhà Xe</title>
</head>
<body>
	<jsp:include page="../layouts/header.jsp"></jsp:include>
	<div id="content">
		<div class="main">
			<div class="row">
				<div class="col-md-12 abc">
					<ul class="nav nav-tabs h-tab-selection">
						<li role="presentation" style=""><a data-toggle
							href="khuonvien">Khuôn Viên</a></li>
						<li role="presentation"><a data-toggle href="phonghoc">Phòng
								Học</a></li>
						<li role="presentation"><a data-toggle href="banghe">Bàn
								Ghế</a></li>
						<li role="presentation"><a data-toggle href="nhavesinh">Nhà
								Vệ Sinh</a></li>
						<li role="presentation" class="active"><a data-toggle
							href="nhaxe"">Nhà Xe</a></li>
						<li role="presentation"><a data-toggle href="thietbi">Thiết
								Bị</a></li>
					</ul>
				</div>
				<div class="col-md-12">
					<div class="8">
						<div class="table-responsive" style="margin-top: 20px;">
							<table id="nx-table"
								class="table table-bordered table-condensed table-infrastructure">
								<thead>
									<tr>
										<th rowspan="3">Điểm trường</th>
										<th colspan="4">Nhà Xe</th>
										<th colspan="2" rowspan="3">Thao Tác</th>
									</tr>
									<tr>
										<th colspan="2">Giáo Viên</th>
										<th colspan="2">Học Sinh</th>
									</tr>
									<tr>
										<th colspan="1">Số Lượng</th>
										<th colspan="1">Diện Tích</th>
										<th colspan="1">Số Lượng</th>
										<th colspan="1">Diện Tích</th>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${nhaxes}" var="nhaxe" varStatus="s">
										<form:form action="nhaxe" modelAttribute="nhaxetemp" id="add"
											method="POST">
											<tr id="data_${nhaxe.maNhaxe}" class="canceltable">
												<form:input path="manhaxe" value="${nhaxe.maNhaxe}"
													style="display:none;" />
												<td colspan="1">${nhaxe.cosovatchat.diemtruong.tendiemtruong}</td>
												<td class="ip" colspan="1"><form:input path="nhaxegv"
														pattern="^[0-9]{1,6}$" style="display: none;" type="text"
														value="${nhaxe.nhaxegv}" /><span class="text">
														${nhaxe.nhaxegv}</span></td>
												<td class="ip" colspan="1"><form:input path="sgv"
														pattern="^[0-9]{1,6}[.][0-9]{1,6}$" style="display: none;"
														type="text" value="${nhaxe.sgv}" /><span class="text">
														${nhaxe.sgv}</span></td>
												<td class="ip" colspan="1"><form:input path="nhaxehs"
														pattern="^[0-9]{1,6}$" style="display: none;" type="text"
														value="${nhaxe.nhaxehs}" /><span class="text">
														${nhaxe.nhaxehs}</span></td>
												<td class="ip" colspan="1"><form:input path="shs"
														id="db" pattern="^[0-9]{1,6}[.][0-9]{1,6}$"
														style="display: none;" type="text" value="${nhaxe.shs}" /><span
													class="text"> ${nhaxe.shs}</span></td>
												<td class="buttonedit">
													<button type="button"
														class="editbutton btn btn-default pull-left"
														onclick="editnx(${nhaxe.maNhaxe});">
														<i class="fa fa-edit"></i>
													</button>
													<button style="display: none;" type="button"
														class="cancelbutton btn btn btn-default pull-left"
														onclick="cancelnx(${nhaxe.maNhaxe});">
														<i class="fa fa-undo"></i>
													</button>
												</td>
												<td colspan="1"><button type="submit"
														onclick="buttonSM(${nhaxe.maNhaxe})"
														class="btn btn-default pull-left">
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
	function editnx(maNhaxe){
		$("#nx-table tr").removeClass('canceltable');
		var id = '#data_'+maNhaxe;
		$(id).addClass('editable');
	};
	function cancelnx(maNhaxe) {
		$("#nx-table tr").removeClass('editable');
		var id = '#data_'+maNhaxe;
		$(id).addClass("canceltable");
	};
	function buttonSM(maNhaxe){
	}
</script>
</body>
</html>