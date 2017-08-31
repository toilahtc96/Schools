<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	
<title>Thêm Giáo Viên</title>
<!-- <link rel="stylesheet" href="/resources/css/jquery-ui.css">

<script src="/resources/js/libs/jquery-1.9.1.js"></script>
<script src="/resources/js/libs/jquery-ui.js"></script>
<script src="/resources/js/libs/jquery.min.js"></script>
 -->
<link rel="stylesheet" href="/resources/css/style.css">


</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div id="content">
		<div class="addGiaoVien">
			<h2 style="text-align: center;">Thêm Giáo Viên</h2>
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-md-offset-3 well form-small">
						<spring:url value="/giaovien/addGV" var="addGvAction"></spring:url>
						<form:form	modelAttribute="giaovien" class="form-horizontal" role="form" id="addGV" action="${addGvAction}"
									  accept-charset="UTF-8" method="POST" >
							<div class="form-group">
								<label class="control-label col-sm-4" for="ten">Họ và Tên</label>
								<div class="col-sm-8">

									<form:input class="form-control" placeholder="Họ và tên" type="text"  path="ten" id="ten"/>
									<form:errors path="ten" cssClass="error" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="datepicker">Ngày sinh</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Ngày sinh" type="text" path="ngaysinh" id="datepicker"/>

									<form:errors  path="ngaysinh" cssClass="error"	/>
								</div>
								
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="diachi">Địa chỉ</label>
								<div class="col-sm-8">
								<form:input class="form-control" placeholder="Địa chỉ" type="text" path="diachi"  id="diachi"/>
									<form:errors path="diachi" cssClass="error"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="quenquan">Quê quán</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Quê quán" type="text" path="quequan" id="quenquan"/>
									<form:errors path="quequan" cssClass="error"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="email">Email</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Email" type="text" path="email" id="email"/>
									<form:errors path="email" cssClass="error" />
								</div>

							</div>
							<div class="form-group">
								<label class="control-label col-sm-4" for="sdt">Số điện thoại</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Số điện thoại" type="text" path="sdt" id="sdt"/>
									<form:errors path="sdt" cssClass="error" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="sdt">Năm vào nghề</label>
								<div class="col-sm-8">
									<form:input class="form-control" placeholder="Năm vào nghề" type="sdt" path="namvaonghe" id="sdt"/>
									<form:errors path="namvaonghe" cssClass="error" />
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-sm-4" for="trinhdo">Trình độ đào tạo</label>
								<div class="col-sm-8">
									<form:select class="form-control selectpicker bs-select-hidden" path="trinhdo" id="trinhdo" ><option value=""/>------</option>
										<option value="Cấp tốc">Cấp tốc</option>
										<option value="Sơ cấp">Sơ cấp</option>
										<option value="TH 12+2">TH 12+2</option>
										<option value="TH 9+3">TH 9+3</option>
										<option value="Trung cấp">Trung cấp</option>
										<option value="Cao đẳng">Cao đẳng</option>
										<option value="Đại học">Đại học</option>
										<option value="Thạc sĩ">Thạc sĩ</option>
										<option value="Tiến sĩ">Tiến sĩ</option></form:select>

								<form:errors path="trinhdo" cssClass="error" />
								</div>
							</div>

							<hr>
							<div class="row no-margin">
								<div class="pull-left">
									<a class="btn btn-info	item btn-lg" href="../giaovien">Hủy</a>
								</div>
								<div class="pull-right" >
									<button type="button"  class="btn btn-success btn-block btn-lg "  onclick="document.getElementById('addGV').submit();"> Hoàn Tất</button>
								</div>
							</div>
						</form:form>  </div>
				</div>

				<form id="esc_cancel" action="../giaovien" method="GET">
					<script type="text/javascript">
						$('body').keyup(function(e) {
							if (e.keyCode == 27) {$("#esc_cancel").submit();}
						});
					</script>
				</form>
			</div>


		</div>


	</div>




<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>