<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bàn Ghế</title>
</head>
<body>
	<jsp:include page="../layouts/header.jsp"></jsp:include>
	<div id="content">
		<div class="main">
			<div class="row">
				<div class="col-md-12 abc" >
					<ul class="nav nav-tabs h-tab-selection">
						<li role="presentation"  style=""><a
							data-toggle href="khuonvien">Khuôn Viên</a></li>
						<li role="presentation" ><a data-toggle
							href="phonghoc">Phòng Học</a></li>
						<li role="presentation" class="active"><a data-toggle
							href="banghe">Bàn Ghế</a></li>
						<li role="presentation" ><a data-toggle
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
							<table id="banghe-table"
								class="table table-bordered table-condensed table-infrastructure">
								<thead>
									<tr>
										<th>Điểm trường</th>
										<th>Số bàn 4 chỗ</th>
										<th>Số bàn 2 chỗ</th>
										<th>Số ghế 4 chỗ</th>
										<th>Số ghế 2 chỗ</th>
										<th colspan="2">Thao Tác</th>
									</tr>

								</thead>
								<tbody>
									<c:forEach items="${banghes}" var="banghe" varStatus="s">
										<form:form action="banghe" modelAttribute="banghetemp"
											method="POST">
											<tr id="data_${banghe.maBanGhe}">
												<td class="diemtruong"
													style="background-color:lightyellow !important;">${banghe.cosovatchat.diemtruong.tendiemtruong }</td>
												<form:input path="maBanGhe" value="${banghe.maBanGhe}" pattern="^[0-9]{1,6}$"
													style="display:none;" />
												<td><form:input   style="display:none; "
														path="banBon" value="${banghe.banBon}" pattern="^[0-9]{1,6}$" /> <span
													class="tdtext">${banghe.banBon}</span></td>
												<td><form:input   style="display:none; "
														path="banHai" value="${banghe.banHai }"  pattern="^[0-9]{1,6}$"/> <span
													class="tdtext">${banghe.banHai }</span></td>
												<td><form:input   style="display:none; "
														path="gheBon" value="${banghe.gheBon }"  pattern="^[0-9]{1,6}$"/> <span
													class="tdtext">${banghe.gheBon }</span></td>
												<td><form:input   style="display:none; "
														path="gheHai" value="${banghe.gheHai }"  pattern="^[0-9]{1,6}$"/> <span
													class="tdtext">${banghe.gheHai }</span></td>
												<td class="buttonedit">
													<button type="button"
														class="editbutton btn btn-default pull-left"
														onclick="editbg(${banghe.maBanGhe});">
														<i class="fa fa-edit"></i>
													</button>
													<button style="display: none;" type="button"
														class="cancelbutton btn btn btn-default pull-left"
														onclick="cancelbg(${banghe.maBanGhe});">
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
	function editbg(mabanghe){
		$("#banghe-table tr").removeClass('canceltable');
		var id = '#data_'+mabanghe;
		$(id).addClass('editable');
	};
	function cancelbg(mabanghe) {
		$("#banghe-table tr").removeClass('editable');
		var id = '#data_'+mabanghe;
		$(id).addClass("canceltable");
	};
</script>

</body>
</html>