<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thiết Bị</title>
</head>
<body>
	<jsp:include page="../layouts/header.jsp"></jsp:include>
	<div id="content">
		<div class="main">
			<div class="row">
				<div class="col-md-12 abc">
					<ul class="nav nav-tabs h-tab-selection">
						<li role="presentation"><a data-toggle href="khuonvien">Khuôn
								Viên</a></li>
						<li role="presentation"><a data-toggle href="phonghoc">Phòng
								Học</a></li>
						<li role="presentation"><a data-toggle href="banghe">Bàn
								Ghế</a></li>
						<li role="presentation"><a data-toggle href="nhavesinh">Nhà
								Vệ Sinh</a></li>
						<li role="presentation"><a data-toggle href="nhaxe"">Nhà
								Xe</a></li>
						<li role="presentation" class="active"><a data-toggle
							href="thietbi">Thiết Bị</a></li>
					</ul>
				</div>
				<div class="col-md-12">
					<div class="col-md-12">
						<div class="table-responsive" style="margin-top: 20px;">
							<table id="thietbi-table"
								class="table table-bordered table-condensed table-infrastructure">
								<thead>
									<tr>
										<th>Điểm trường</th>
										<th>Số máy tính cho HS học</th>
										<th>Số máy tính dùng cho CBGV</th>
										<th>Số máy chiếu</th>
										<th>Có kết nối Internet? (x)</th>
										<th colspan="2">Thao Tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${thietbis}" var="thietbi" varStatus="s">
										<form:form action="thietbi" modelAttribute="thietbitemp"
											method="POST">
											<tr id="data_${thietbi.maTbi}" class="canceltable">
												<form:input path="maTbi" value="${thietbi.maTbi}"
													style="display:none;" />
												<td colspan="1"
													style="background-color: lightyellow !important;">${thietbi.cosovatchat.diemtruong.tendiemtruong}</td>
												<td colspan="1"><form:input path="mayhs"
														pattern="^[0-9]{1,6}$" style="display: none;" type="text"
														value="${thietbi.mayhs}" /><span class="text">
														${thietbi.mayhs}</span></td>
												<td colspan="1"><form:input path="maygv"
														pattern="^[0-9]{1,6}$" style="display: none;" type="text"
														value="${thietbi.maygv}" /><span class="text">
														${thietbi.maygv}</span></td>
												<td colspan="1"><form:input path="maychieu"
														pattern="^[0-9]{1,6}$" style="display: none;" type="text"
														value="${thietbi.maychieu}" /><span class="text">
														${thietbi.maychieu}</span></td>
												<td colspan="1"><form:input path="internet"
														style="display: none;" type="text"
														value="${thietbi.internet}" /><span class="text">
														${thietbi.internet}</span></td>
												<td class="buttonedit">
													<button type="button"
														class="editbutton btn btn-default pull-left"
														onclick="edittb(${thietbi.maTbi});">
														<i class="fa fa-edit"></i>
													</button>
													<button style="display: none;" type="button"
														class="cancelbutton btn btn btn-default pull-left"
														onclick="canceltb(${thietbi.maTbi});">
														<i class="fa fa-undo"></i>
													</button>
												</td>
												<td class="buttonupdate" colspan="1"><button
														style="display: block;" type="submit"
														class="updatebutton btn btn-default pull-left">
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
	function edittb(matb){
		$("#thietbi-table tr").removeClass('canceltable');
		var id = '#data_'+matb;
		$(id).addClass('editable');
	};
	function canceltb(matb) {
		$("#thietbi-table tr").removeClass('editable');
		var id = '#data_'+matb;
		$(id).addClass("canceltable");
	};
</script>
</body>
</html>