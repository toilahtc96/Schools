<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang Chủ</title>
</head>
<body>
	<jsp:include page="../layouts/header.jsp" />
	<div id="content">
		<div class="row">
		
			<div class="danhmuc_qualy">
				<a class="truong_hoc">
					<i class="fa fa-university icon"></i>
					<span>Thông Tin Trường Học</span>
				</a>
				<a class="truong_hoc">
					<i class="fa fa-group icon"></i>
					<span>Danh Sách Đội Ngũ</span>
				</a>
				<a class="truong_hoc">
					<i class="fa fa-th-large icon"></i>
					<span>Danh Mục Lớp Học</span>
				</a>
				<a class="truong_hoc">
					<i class="fa fa-calendar icon"></i>
					<span>Phân Công Giảng Dạy</span>
				</a>
				<a class="truong_hoc">
					<i class="fa fa-child icon"></i>
					<span>Danh Sách Học Sinh</span>
				</a>
				<a class="truong_hoc">
					<i class="fa fa-archive icon"></i>
					<span>Cơ Sở Vật Chất</span>
				</a>
				<a class="truong_hoc">
					<i class="fa fa-bar-chart-o icon"></i>
					<span>Báo Cáo Thống Kê</span>
				</a>
			</div>
	
		</div>
		
		<div class="row tong_quan">
			<div class="nhan_xet">
				<h3>Tổng Quan Nhận Xét Đánh Giá<br></br><a href="">Xem Chi Tiết Tại Đây</a></h3>
				<div class="danh_gia">
					<p>Tổng Số Giáo Viên: <span>25</span></p>
					<p>Tổng Số Học Sinh: <span>1000</span></p>
					<p>Số giáo viên tham gia nhận xét: <span>4</span> (1 trong 30 ngày gần đây)</p>
					<p>Số học sinh được nhận xét: <span>108</span> (1 trong 30 ngày gần đây)</p>
					<p>Tổng số nhận xét: <span>530</span> (1 trong 30 ngày gần đây)</p>
				</div>
			</div>
		</div>
	
	</div>
	
	<jsp:include page="../layouts/footer.jsp" />
</body>
</html>