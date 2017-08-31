<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phòng Học</title>
</head>
<body>
	<jsp:include page="../layouts/header.jsp"></jsp:include>
	<div id="content">
		<div class="main">
			<div class="row">
				<div class="col-md-12 abc">
					<ul class="nav nav-tabs h-tab-selection">
						<li role="presentation" style=""><a href="khuonvien">Khuôn
								Viên</a></li>
						<li role="presentation" class="active"><a href="phonghoc">Phòng
								Học</a></li>
						<li role="presentation"><a href="banghe">Bàn Ghế</a></li>
						<li role="presentation"><a href="nhavesinh">Nhà Vệ Sinh</a></li>
						<li role="presentation"><a href="nhaxe"">Nhà Xe</a></li>
						<li role="presentation"><a href="thietbi">Thiết Bị</a></li>
					</ul>
				</div>
				<div class="col-md-12">
					<div class="tab-content" style="margin-top: 20px;">
						<div class="table-responsive">
							<table id="phonghoc-table"
								class="table table-bordered table-condensed table-infrastructure">
								<thead>
									<tr>
										<th colspan="1">Điểm trường</th>
										<th colspan="1">Tên Phòng</th>
										<th colspan="1">Cấp độ xây dựng (3->6?)</th>
										<th colspan="1">Diện tích (m2)</th>
										<th colspan="1">Xây mới? (x)</th>
										<th colspan="2">Thao Tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${phonghocs}" var="phonghoc" varStatus="s">
										<form:form action="phonghoc" modelAttribute="phonghoctemp"
											method="POST">
											<tr id="data_${phonghoc.maP}">
												<form:input path="maP"
													style="display:none;magin-left:30px; margin-top:-10px;"
													value="${phonghoc.maP}" />
												<td class="diemtruong"
													style="background-color: lightyellow !important;">${phonghoc.cosovatchat.diemtruong.tendiemtruong}</td>
												<td><form:input style="display:none;" path="tenPhong"
														value="${phonghoc.tenPhong}" /> <span>${phonghoc.tenPhong}</span></td>
												<td><form:input style="display:none; " path="capdoxd"
														pattern="^[3-6]{1}$" value="${phonghoc.capdoxd}" /> <span>${phonghoc.capdoxd}</span></td>
												<td><form:input style="display:none;" path="dientich"
														pattern="^[0-9]{1,6}[.]{0,1}[0-9]{0,6}$"
														value="${phonghoc.dientich}" /> <span>${phonghoc.dientich}</span></td>
												<td><form:input style="display:none;" path="xaymoi"
														value="${phonghoc.xaymoi}" /> <span>${phonghoc.xaymoi}</span></td>
												<td class="buttonedit">
													<button type="button"
														class="editbutton btn btn-default pull-left"
														onclick="editph(${phonghoc.maP});">
														<i class="fa fa-edit"></i>
													</button>
													<button style="display: none;" type="button"
														class="cancelbutton btn btn btn-default pull-left"
														onclick="cancelph(${phonghoc.maP});">
														<i class="fa fa-undo"></i>
													</button>
												</td>
												<td colspan="1" class="buttonedit"><button
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
	function editph(maP){
		$("#phonghoc-table tr").removeClass('canceltable');
		var id = '#data_'+maP;
		$(id).addClass('editable');
	};
	function cancelph(maP) {
		$("#phonghoc-table tr").removeClass('editable');
		var id = '#data_'+maP;
		$(id).addClass("canceltable");
	};
</script>
</body>
</html>