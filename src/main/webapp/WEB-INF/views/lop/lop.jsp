<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<spring:url value="resources/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="resources/css/lopstyle.css" var="lopStyle" />
<spring:url value="resources/font-awesome-4.1.0/css/font-awesome.css" var="fontStyle" />

<link href="${bootstrap}" type="text/css" rel="stylesheet" />
<link href="${lopStyle}" type="text/css" rel="stylesheet" />
<link href="${fontStyle}" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lop</title>

<script src="resources/js/libs/jquery-1.9.1.js"></script>
<script src="resources/js/libs/bootstrap.min.js"></script>
</head>
<body>

<div class="wapper">
<!-- header -->
<div id="header">
	<div class="left">
    	<a href="home" class="box1" >
        	<i class="fa fa-3x fa-home"></i>
        </a>
        <div class="box2">
        	<h3>Tiểu Học Imic</h3>
        </div>
        <div class="box3 dropdown-toggle dropdown" data-toggle="dropdown">Năm học 2016 - 2017 <span class="caret"></span></div>
        <ul class="dropdown-menu position">
        	<li><a href="#">Năm học 2016 - 2017</a></li>
            <li class="divider"></li>
            <li><a href="#">Danh sách năm học</a></li>
        </ul> 
    </div>
    <div class="right dropdown">
    	<div class="box1 dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> username <span class="caret"></span></div>
        <ul class="dropdown-menu" style="top:65px; right:0px; left:inherit;">
        	<li><a href="#"><i class="fa fa-cog"></i> Thông tin tài khoản</a></li>
            <li class="divider"></li>
            <li><a href="#"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>
        </ul> 
    </div>
    
    <div class="under"></div>
</div>
<!-- end header -->
<!-- content -->
<div id="content">
	<div class="box1">
    	<div class="text">Danh Sách Lớp Học</div>
    </div>
    <form:form action="lop/xem" commandName="temp" method="POST" id="xem">
    <div class="box2">
    	<div class="text">Điểm Trường : </div>
        <div class="select">
        	<form:select class="form-control" path="diemtruong">
            	<form:options items="${dt}" itemValue="madiemtruong" />
            </form:select>
        </div>
        
        <div class="text">Năm học : </div>
        <div class="select">
        	<form:select class="form-control" path="namhoc">
            	<form:options items="${nam}" itemValue="manamhoc"/>
            </form:select>
        </div>
        
        <div class="text">Học Kỳ :</div>
        <div class="select">
        	<form:select class="form-control" path="hocki">
            	<form:options items="${hk}" itemValue="mahocky" />
            </form:select>
        </div>
    </div>
    
    <div class="but center"><button type="button" class="btn btn-success" onclick="document.getElementById('xem').submit();"><i class="fa fa-pencil"> Xem Danh Sách</i></input></div>
    </form:form>
    
    <div class="box3">
    <form>
    	<div class="left">
        	<ul class="pagination pagination-sm fl-l cl">
            	<li><a href="lop">«</a></li>
				<c:forEach begin="1" end="${lastpage}" var="i">
					<c:choose>
					<c:when test="${act eq i}">
						<li class="active"><a href="#">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="http://localhost:8081/schools/lop?page=${i}">${i}</a></li>
					</c:otherwise>
					</c:choose>
				</c:forEach>
                <li><a href="http://localhost:8081/schools/lop?page=${lastpage}">»</a></li>
            </ul>
     </form>  
		<form style="float:left;" id="row" action="lop/row" method="POST">
            <div class="text">Số Dòng :</div>
            <select class="form-control fl-l autoWidth" id="srow" name="row">
            	<option value="5" >5 dòng</option>
                <option value="10">10 dòng</option>
                <option value="20">20 dòng</option></a>
            </select>
        </div>
    	</form>
    	<script>
    	document.getElementById("srow").onchange = function() {
    document.getElementById("row").submit();
};
</script>
        <div class="right">
        	<button type="button" class="btn btn-outline btn-success fl-r marginR" id="up"> <i class="fa fa-upload"></i> Tải lên</button>
            <a href="/schools/lop/download"><button type="button" class="btn  btn-success btn-outline fl-r marginR"> <i class="fa fa-download"></i> Tải Xuống File Excel</button></a>
        </div>
    </div>
    
    <div class="box4 marginT">
    	<table class="table table-striped table-bordered" aria-describedby="dataTables-example_info">
        <tr>
        	<th class="center">STT</th>
        	<th class="center colp">Học Kỳ</th>
        	<th class="center colp">Năm Học</th>
            <th class="center">Lớp</th>
            <th class="center colp">Điểm Trường</th>
            <th class="center">Chủ Nhiệm</th>
            <th class="center">Sĩ Số</th>
            <th class="center colp">Số Tiết học / Tuần</th>
            <th><a href="lop/add"><button type="button" class="btn btn-success cir"><i class="fa fa-plus"></i></button></a></th>
        </tr>
        
        <c:forEach var="lop" items="${lis}" varStatus="indexes">
        <tr>
        	<td class="center">${indexes.index + 1}</td>
        	<td class="center colp">${lop.hocky.tenhocky}</td>
        	<td class="center colp">${lop.namhoc.thoigian}</td>
            <td class="center"><a href="/schools/lop/${lop.makhoahoc}" style="color: blue;">${lop.lop.tenlop}</a></td>
            <td class="center colp">${lop.lop.diemtruong.tendiemtruong}</td>
            <td class="center"><button type="button" class="clear-but" onclick="gvcn('${lop.chunhiem.ten}','${lop.chunhiem.ngaysinh}','${lop.chunhiem.diachi}','${lop.chunhiem.quequan}','${lop.chunhiem.email}','${lop.chunhiem.sdt}','${lop.chunhiem.namvaonghe}','${lop.chunhiem.trinhdo}')">${lop.chunhiem.ten}</button></td>
            <td class="center">${ss.get(indexes.index)}</td>
            <td class="center colp">${lop.lop.sotiethoc}</td>
            <td class="center"><a href="/schools/lop/edit/${lop.makhoahoc}"><button type="button" class="btn btn-info cir"><i class="fa fa-pencil"></i></button></a> <button type="button" class="btn btn-danger btn-del cir" onclick="fun('${lop.makhoahoc}','${lop.lop.tenlop}')"><i class="fa fa-trash-o"></i></button></td>
        </tr>
        </c:forEach>
        </table>
    </div>
  
</div>

<!-- end content -->




</div>


<div class="deleteClass" id="div"></div>
<form>
<div class="deleteBox delete">
	<div class="quest delete"><b id="del"></b></div>
    <hr class="divider delete" style="margin-top:10px;" />
    <div class="deleteBut delete">
    	<a href="" id="aaa"><button type="button" class="btn btn-info" onclick="delLop()"><i class="fa fa-trash-o"> Xóa</i></button></a>
        <button type="button" class="btn btn-default btn-can"><i class="fa fa-ban"> Hủy</i></button>
    </div>
</div>
</form>

<div class="showClass" id="sh"></div>
<div class="showBox show" id="info"></div>

<div class="uploadClass"></div>
<form id="uploadFile" action="/schools/lop/upload" enctype="multipart/form-data"  method="POST">
<div class="uploadBox upload" id="upload">
	
		<div class="quest"><b>Chọn File Upload : </b><input type="file" name="file" style="margin-left: 20%;"/></div>
		 <hr class="divider" style="margin-top:10px;" />
    	<div class="uploadBut">
    		<input type="submit" value="upload" onclick="document.getElementById('uploadFile').submit();" class="btn btn-info"/>
    		<button id="cancel" type="button" class="btn btn-default"><i class="fa fa-ban"> Hủy</i></button>
    	</div>
	
</div>
</form>

<!-- <script src="resources/js/libs/jquery-1.9.1.js"></script> -->
<!-- <script src="resources/js/libs/bootstrap.min.js"></script> -->
<script>
$(document).ready(function(){
    $(".btn-del").click(function(){
        $(".deleteClass").fadeToggle("slow");
		$(".delete").fadeToggle("1000");
    });
});

$(document).ready(function(){
    $(".btn-can").click(function(){
        $(".deleteClass").fadeToggle("slow");
		$(".delete").fadeToggle("1000");
    });
});

$(document).ready(function(){
    $("#up").click(function(){
        $(".uploadClass").fadeToggle("slow");
		$("#upload").fadeToggle("1000");
    });
});

$(document).ready(function(){
    $("#cancel").click(function(){
        $(".uploadClass").fadeToggle("slow");
		$("#upload").fadeToggle("1000");
    });
});

var maso;
var link;
function fun(id,lop){
	var x = "Bạn có chắc chắn muốn xóa lớp " +lop+ " ?"
	document.getElementById("del").innerHTML = x;
	maso = id;
	var l = "http://localhost:8081/schools/lop/delete/"+id;
	link = l;
}		

function delLop(){
	document.getElementById("aaa").setAttribute("href",link);
}

function gvcn(ten,ngaysinh,diachi,quequan,email,sdt,namvaonghe,trinhdo){
		var box = '</div><div class="quest show-none"><b id="del" style="font-size:20px;">Giáo Viên : '+ten+' </b></div><hr class="divider show-none" style="margin-top:10px;" /><p class="mar">Tên giáo viên : '+ten+'</p><p class="mar">Ngày sinh : '+ngaysinh+'</p><p class="mar">Địa Chỉ : '+diachi+'</p><p class="mar">Quê quán : '+quequan+'</p><p class="mar">Email : '+email+'</p><p class="mar">Sđt : '+sdt+'</p><p class="mar">Năm vào nghề : '+namvaonghe+'</p><p class="mar">Trình độ : '+trinhdo+'</p><div class="showBut show-none"><button type="button" class="btn btn-info" onclick="ok()"><i class="fa fa-check"> OK</i></button></div>';
	document.getElementById("sh").setAttribute("class","showClass show-none");
	document.getElementById("info").setAttribute("class","showBox show-none");
	document.getElementById("info").innerHTML=box;
	}

function ok(){
	document.getElementById("sh").setAttribute("class","showClass showex");
	document.getElementById("info").setAttribute("class","showBox showex");
}

</script>
</body>
</html>