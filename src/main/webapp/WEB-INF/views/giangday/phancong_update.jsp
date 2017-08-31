<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Phân Công</title>
</head>
<body>
	<jsp:include page="../layouts/header.jsp"></jsp:include>
	<div class="clear"></div>
	<div id="content">
		<div id="phancong_update">
			<h2 style="text-align: center;">${giaoVien.ten}-PhânCôngGiảng
				Dạy - 2015-2016</h2>
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<spring:url value="/phancong/confirmUpdate" var="confirmUpdate"></spring:url>
						<s:form modelAttribute="giaoVien" method="POST"
							class="form-horizontal" action="${confirmUpdate}">
							<s:hidden readonly="true" path="magiaovien" />
							<div class="panel panel-default form_updatex">
								<div class="panel-heading">
									<div class="form-group">
										<label class="control-label col-sm-3">Chủ Nhiệm</label>
										<div class="col-sm-9">
											<select name="khoahoc[0].makhoahoc"
												class="selectpicker form-control chunhiem_selector"
												data-live-search="true">
												<option value="0">--------</option>
												<c:forEach items="${khoaHocs}" var="khoaHoc" varStatus="s">
													<c:choose>
														<c:when
															test="${giaoVien.khoahoc[0].makhoahoc==khoaHoc.makhoahoc}">
															<option selected="selected" value="${khoaHoc.makhoahoc}">
																${khoaHoc.lop.tenlop} -
																${khoaHoc.lop.diemtruong.tendiemtruong} - Mã Khóa học:
																${khoaHoc.makhoahoc}</option>
														</c:when>
														<c:otherwise>
															<option value="${khoaHoc.makhoahoc}">
																${khoaHoc.lop.tenlop} -
																${khoaHoc.lop.diemtruong.tendiemtruong} - Mã Khóa học:
																${khoaHoc.makhoahoc}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="panel-body">
									<div class="col-sm-6">
										<span>Lớp</span>
									</div>
									<div class="col-sm-6">
										<span>MônHoc</span>
									</div>
									<div class="clear"></div>
									<div id="phancong-box" style="float: left;width: 100%;">
										<c:forEach items="${giaoVien.giangday}" var="giangDay"
											varStatus="s">
											<div style="float: left; width: 80%; margin-top: 10px;"
												class="giangDay${s.index}">
												<div class="col-sm-6">
													<select name="giangday[${s.index}].khoahoc.makhoahoc"
														onchange="changeKhoaHoc(this)"
														class="selectpicker form-control khoahoc-selector"
														data-live-search="true">
														<c:forEach items="${khoaHocs}" var="khoaHoc">
															<c:choose>
																<c:when
																	test="${giangDay.khoahoc.makhoahoc==khoaHoc.makhoahoc}">
																	<option selected="selected"
																		value="${khoaHoc.makhoahoc}">
																		${khoaHoc.lop.tenlop} - Mã Khóa học:
																		${khoaHoc.makhoahoc}</option>
																</c:when>
																<c:otherwise>
																	<option value="${khoaHoc.makhoahoc}">
																		${khoaHoc.lop.tenlop} - Mã Khóa học:
																		${khoaHoc.makhoahoc}</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
												<div class="col-sm-6">
													<select name="giangday[${s.index}].monhoc.mamonhoc"
														id="giangday${s.index}" onchange="changeMonHoc(this)"
														class="selectpicker form-control monhoc-selector"
														data-live-search="true">
														<c:forEach items="${monHocs}" var="monHoc">
															<c:choose>
																<c:when
																	test="${giangDay.monhoc.mamonhoc==monHoc.mamonhoc}">
																	<option selected="selected" value="${monHoc.mamonhoc}">${monHoc.tenmonhoc}(
																		ma:${monHoc.mamonhoc})</option>
																</c:when>
																<c:otherwise>
																	<option value="${monHoc.mamonhoc}">${monHoc.tenmonhoc}(ma:${monHoc.mamonhoc})</option>
																</c:otherwise>
															</c:choose>
														</c:forEach>
													</select>
												</div>
											</div>
											<span
												style="float: left; margin-left: 10px; margin-top: 18px; color: red; font-style: italic;"
												class="giangday${s.index}"></span>
											<button type="button"
												style="float: right; margin-top: 15px; margin-right: 10px;"
												onclick="xoa(${s.index})"
												class="btn btn-sm btn-danger fa fa-times giangDay${s.index}">
											</button>

										</c:forEach>
									</div>
									<div class="clear"></div>
									<button type="button" onclick="them()"
										style="float: right; margin: 20px; margin-right: 10px;"
										class="btn btn-sm btn-success fa fa-plus"></button>
								</div>
								<div class="panel-footer">
									<c:if test="${erros.keySet().size()>0}">
										<div style="margin-top: 10px;">
											<div class="alert alert-danger">
												<b>Đã xảy ${erros.keySet().size()} lỗi khi phân công
													giảng dạy </b>
												<hr>
												<c:forEach items="${erros}" var="erro" varStatus="s">
													${erro.key}. ${erro.value}<br>
												</c:forEach>
											</div>
										</div>
									</c:if>
									<div class="form-group">
										<div class="col-sm-3">
											<input type="submit" value="Update" class="btn btn-success" />
										</div>
										<div class="col-sm-3" style="float: right;">
											<a style="float: right;" value="Update"
												class="btn btn-success"
												href='<spring:url value="/phancong"></spring:url>'>Cancel</a>
										</div>
									</div>
								</div>
							</div>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../layouts/footer.jsp"></jsp:include>
	<script type="text/javascript">
		var gSize = parseInt('${giaoVien.giangday.size()}');
		function them(){
			gSize++;
			var str = "";
			str = str+"<div style=\"float: left; width: 80%; margin-top: 10px;\" class=\"giangDay"+gSize+"\">";
			str=str+"<div class=\"col-sm-6\">";
			str=str+"<select id='slectpicker_khoahoc" + gSize +"' name=\"giangday["+gSize+"].khoahoc.makhoahoc\" onchange=\"changeKhoaHoc(this)\" class=\"selectpicker form-control khoahoc-selector\" data-live-search=\"true\">";
			<c:forEach items="${khoaHocs}" var="khoaHoc">
				str += '<option value="${khoaHoc.makhoahoc}">${khoaHoc.lop.tenlop} - Mã Khóa học:${khoaHoc.makhoahoc}</option>';
			</c:forEach>
			str = str+"";
			str = str+"</select></div>";
			str = str+"<div class=\"col-sm-6\">";
			str = str+"<select id='giangday" + gSize +"' name=\"giangday["+gSize+"].monhoc.mamonhoc\" onchange=\"changeMonHoc(this)\" class=\"selectpicker form-control monhoc-selector\" data-live-search=\"true\">";
			<c:forEach items="${monHocs}" var="monHoc">
				str += '<option value="${monHoc.mamonhoc}">${monHoc.tenmonhoc}(ma:${monHoc.mamonhoc})</option>';
			</c:forEach>
			str = str+"	</select></div>";
			str=str+"</div>";
			str=str+'<span style="float: left; margin-left: 10px; margin-top: 18px; color: red; font-style: italic;" class="giangday'+gSize+'"></span>';
			str=str+'<button type="button" style="float: right; margin-top: 15px; margin-right: 10px;" onclick="xoa('+gSize+')" class="btn btn-sm btn-danger fa fa-times giangDay'+gSize+'"></button>';
			str=str+'<div class="clear"></div>';
			$("#phancong-box").append($.parseHTML(str));
			$('#slectpicker_khoahoc'+gSize).selectpicker('refresh');
			$('#slectpicker_khoahoc'+gSize).selectpicker('render');
			
			$('#giangday'+gSize).selectpicker('refresh');
			$('#giangday'+gSize).selectpicker('render');
		}
		function xoa(index) {
			$(".giangDay"+index).remove();
		}
// SK Chon KhoaHoc
	function changeKhoaHoc(element){
		var listKhoaHoc = $('#phancong-box select.khoahoc-selector');
		var khoaHocChon = $(element);
		var listMonHoc = $('#phancong-box select.monhoc-selector');
		var viTriMonHocKiemTra;
		for(var i=0; i< listKhoaHoc.length;i++){
			if(khoaHocChon.prop('name')==$(listKhoaHoc[i]).prop('name')){
				viTriMonHocKiemTra = i;
			}
		}
		for(var i=0; i< listKhoaHoc.length;i++){
			if(!(khoaHocChon.prop('name')==$(listKhoaHoc[i]).prop('name')) && khoaHocChon.val()==$(listKhoaHoc[i]).val()
			&& 	$(listMonHoc[viTriMonHocKiemTra]).val()== $(listMonHoc[i]).val()){
				var trung = $(listMonHoc[viTriMonHocKiemTra]).prop('id');
				$("span."+trung).text("Đã Trùng");
				return;
			}else{
				var trung = $(listMonHoc[viTriMonHocKiemTra]).prop('id');
				$("span."+trung).text("");
			}
		}
	}
	// Su Kien Chon Mon Hoc
	
	function changeMonHoc(element){
		var listMonHoc = $('#phancong-box select.monhoc-selector');
		var monHocChon = $(element);
		var listKhoaHoc = $('#phancong-box select.khoahoc-selector');
		var viTriKhoaHocKiemTra;
		
		for(var i=0; i< listMonHoc.length;i++){
			if(monHocChon.prop('name')==$(listMonHoc[i]).prop('name')){
				viTriKhoaHocKiemTra = i;
			}
		}
		for(var i=0; i< listMonHoc.length;i++){
			if(!(monHocChon.prop('name')==$(listMonHoc[i]).prop('name')) && monHocChon.val()== $(listMonHoc[i]).val()
			&& $(listKhoaHoc[i]).val()==$(listKhoaHoc[viTriKhoaHocKiemTra]).val()){
				var trung = $(listMonHoc[viTriKhoaHocKiemTra]).prop('id');
				$("span."+trung).text("Đã Trùng");
				return;
			}else{
				var trung = $(listMonHoc[viTriKhoaHocKiemTra]).prop('id');
				$("span."+trung).text("");
			}
		}
		
	}
	
		
	</script>
</body>
</html>
<!--
		$(document).ready(function(){
			$('.khoahoc-selector').on('change', function(){
				var check = false;
				var self = $(this);
				var khoahoc_selector = $('#phancong-box select.khoahoc-selector');
				var monhoc_selector = $('#phancong-box select.monhoc-selector');
				$.each(khoahoc_selector, function(index_khoahoc, item_khoahoc){
					var selfName = self.prop('name');
					var itemName = $(item_khoahoc).prop('name');
					if(!(selfName == itemName) && $(item_khoahoc).val() == self.val()) {
						$.each(monhoc_selector,function(index_monhoc,item_monhoc){
							var imonhoc = $(item_monhoc);
							$.each(monhoc_selector,function(index_monhoc1,item_monhoc1){
								if( !(imonhoc.prop('name')==$(item_monhoc1).prop('name')) && imonhoc.val()==$(item_monhoc1).val() ){
									check = true;
								}
							});
						});
					}
				});
				alert(check);
			});
		});
		-->

<!-- 		$(document).ready(function(){ -->
<!-- 			$('.monhoc-selector').on('change', function(){ -->
<!-- 				var listMonHoc = $('#phancong-box select.monhoc-selector'); -->
<!-- 				var monHocChon = $(this); -->
<!-- 				var listKhoaHoc = $('#phancong-box select.khoahoc-selector'); -->
<!-- 				var viTriKhoaHocKiemTra; -->

<!-- 				for(var i=0; i< listMonHoc.length;i++){ -->
<!-- 					if(monHocChon.prop('name')==$(listMonHoc[i]).prop('name')){ -->
<!-- 						viTriKhoaHocKiemTra = i; -->
<!-- 					} -->
<!-- 				} -->
<!-- 				for(var i=0; i< listMonHoc.length;i++){ -->
<!-- 					if(!(monHocChon.prop('name')==$(listMonHoc[i]).prop('name')) && monHocChon.val()== $(listMonHoc[i]).val() -->
<!-- 					&& $(listKhoaHoc[i]).val()==$(listKhoaHoc[viTriKhoaHocKiemTra]).val()){ -->
<!-- 						var trung = $(listMonHoc[viTriKhoaHocKiemTra]).prop('id'); -->
<!-- 						$("span."+trung).text("Đã Trùng"); -->
<!-- 						return; -->
<!-- 					}else{ -->
<!-- 						var trung = $(listMonHoc[viTriKhoaHocKiemTra]).prop('id'); -->
<!-- 						$("span."+trung).text(""); -->
<!-- 					} -->
<!-- 				} -->
<!-- 			}); -->
<!-- 		}); -->
