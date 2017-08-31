<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phân Công</title>
<script type="text/javascript">
	function showInfo(ten, diachi, email, ngaysinh, quequan, sdt, trinhdo,
			namvaonghe) {
		$(".tenGV").text(ten);
		$(".ho_va_ten").text(ten);
		$(".dia_chi").text(diachi);
		$(".email").text(email);
		$(".ngay_sinh").text(ngaysinh);
		$(".quen_quan").text(quequan);
		$(".sdt").text(sdt);
		$(".trinh_do").text(trinhdo);
		$(".vaonghe").text(namvaonghe);
	}
</script>
</head>
<body>
	<jsp:include page="../layouts/header.jsp"></jsp:include>
	<div class="clear"></div>
	<div id="content">
		<div id="phancong">
			<div class="container">
				<div style="float: left; z-index: 9999; margin-top: 20px;"
					id="myModal" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title tenGV"
									style="text-align: center; font-family: Georgia, Serif;"></h4>
							</div>
							<div class="modal-body">
								<p>
									Họ Và Tên: <span class="ho_va_ten" style="font-weight: bold"></span>
								</p>
								<p>
									Địa Chỉ: <span class="dia_chi" style="font-weight: bold"></span>
								</p>
								<p>
									Email: <span class="email" style="font-weight: bold"></span>
								</p>
								<p>
									Ngày Sinh: <span class="ngay_sinh" style="font-weight: bold"></span>
								</p>
								<p>
									Quê Quán:<span class="quen_quan" style="font-weight: bold"></span>
								</p>
								<p>
									Số Điện Thoại : <span class="sdt" style="font-weight: bold"></span>
								</p>
								<p>
									Trình Độ: <span class="trinh_do" style="font-weight: bold"></span>
								</p>
								<p>
									Năm Vào Nghề: <span class="vaonghe" style="font-weight: bold"></span>
								</p>
							</div>
							<div class="modal-footer">
								<a type="button" class="btn btn-success" data-dismiss="modal">Đóng</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<h3 style="text-align: center;">Phân Công Giảng Dạy 2010-2011</h3>
					<div class="phantrang">
						<ul class="pagination">
							<c:forEach begin="1" end="${totalPage}" var="pageLoop">
								<c:choose>
									<c:when test="${page == pageLoop}">
										<li class="active"><a
											href='<spring:url value="/phancong?page=${pageLoop}"></spring:url>'>${pageLoop}</a></li>
									</c:when>
									<c:otherwise>
										<li><a
											href='<spring:url value="/phancong?page=${pageLoop}"></spring:url>'>${pageLoop}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
						<div class="clear"></div>
						<div class="sodong_tai">
							<div class="col-sm-6">
								<div class="dropdown" style="float: left;">
									<button class="btn btn-default dropdown-toggle" type="button"
										id="menu1" data-toggle="dropdown">
										${record} dòng<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a
											href='<spring:url value="/pagesize?record=3"></spring:url>'>3
												dòng</a></li>
										<li><a
											href='<spring:url value="/pagesize?record=5"></spring:url>'>5
												dòng</a></li>
										<li><a
											href='<spring:url value="/pagesize?record=7"></spring:url>'>7
												dòng</a></li>
									</ul>
								</div>
								<c:choose>
									<c:when test="${page<totalPage}">
										<span
											style="float: left; margin-left: 10px; margin-top: 10px;">${(page-1)*record+1}
											- ${((page-1)*record)+record} /${totalRecord} Giáo Viên</span>
									</c:when>
									<c:otherwise>
										<span
											style="float: left; margin-left: 10px; margin-top: 10px;">${(page-1)*record+1}
											- ${totalRecord}/${totalRecord} Giáo Viên</span>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="col-sm-6">
								<div class="taifile">
									<a style="float: right;" class="btn btn-sm btn-default"
										href='<spring:url value="/phancong/dowload"></spring:url>'>
										<span style="color: #337ab7; font-size: 14px;"
										class="fa fa-upload"></span> <span>UpLoad</span>
									</a> <a style="float: right; margin-right: 10px;"
										class="btn btn-sm btn-default"
										href='<spring:url value="/phancong/dowload"></spring:url>'>
										<span style="color: #337ab7; font-size: 14px;"
										class="fa fa-download"></span> <span>DownLoad</span>
									</a>
								</div>
							</div>
						</div>
					</div>
					<table class="table table-bordered table-hover table-condensed">
						<thead>
							<tr class="active">
								<th>STT</th>
								<th>Họ Tên</th>
								<th>Chủ Nhiệm</th>
								<c:forEach items="${monHocs}" var="monHoc">
									<th>${monHoc.tenmonhoc}</th>
								</c:forEach>
								<td>Action</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${giaoViens}" var="giaoVien" varStatus="s">
								<tr>
									<td>${s.count}</td>
									<td><a data-toggle="modal" data-target="#myModal"
										onclick="showInfo('${giaoVien.ten}','${giaoVien.diachi}','${giaoVien.email}','${giaoVien.ngaysinh}','${giaoVien.quequan}',
										'${giaoVien.sdt}','${giaoVien.trinhdo}','${giaoVien.namvaonghe}'
										);"
										style="text-decoration: none;" href="#">${giaoVien.ten}</a></td>
									<td><c:forEach items="${giaoVien.khoahoc}" var="khoaHoc">
											<c:if test="${khoaHoc.namhoc.manamhoc==1}">
												${khoaHoc.lop.tenlop}-${khoaHoc.lop.diemtruong.tendiemtruong}
											</c:if>
										</c:forEach></td>
									<c:forEach items="${monHocs}" var="monHoc">
										<td><c:forEach items="${giaoVien.giangday}"
												var="giangDay">
												<c:if test="${giangDay.monhoc.mamonhoc == monHoc.mamonhoc}">
													<c:if test="${giangDay.khoahoc.namhoc.manamhoc==manamhoc}">
														${giangDay.khoahoc.lop.tenlop}
													</c:if>
												</c:if>
											</c:forEach></td>
									</c:forEach>
									<td><spring:url
											value="/phancong/${giaoVien.magiaovien}/update" var="edGV"></spring:url>
										<a href="${edGV}" class="btn btn-xs btn-primary"
										title="Phân Công Giáo Viên"> <span class="fa fa-pencil"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp"></jsp:include>
</body>
</html>