<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrap" />
<spring:url value="/resources/css/lopstyle.css" var="lopStyle" />
<spring:url value="/resources/font-awesome-4.1.0/css/font-awesome.css" var="fontStyle" />

<link href="${bootstrap}" type="text/css" rel="stylesheet" />
<link href="${lopStyle}" type="text/css" rel="stylesheet" />
<link href="${fontStyle}" type="text/css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lop</title>

</head>
<body>
<div class="wapper">
<!-- header -->
<div id="header">
	<div class="left">
    	<a href="#" class="box1" >
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
    	<div class="text">Danh Sách Học Sinh Lớp ${khoahoc.lop.tenlop}</div>
    </div>
    
    <div class="box3">
    <form>
    	<div class="left">
        	<ul class="pagination pagination-sm fl-l cl">
            	<li><a href="/schools/lop/${khoahoc.makhoahoc}">«</a></li>
				<c:forEach begin="1" end="${count}" var="i">
					<c:choose>
					<c:when test="${act eq i}">
						<li class="active"><a href="#">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="http://localhost:8081/schools/lop?page=${i}">${i}</a></li>
					</c:otherwise>
					</c:choose>
				</c:forEach>
                <li><a href="/schools/lop/${khoahoc.makhoahoc}?page=${count}">»</a></li>
            </ul>
     </form>  
		<form style="float:left;" id="hsrow" action="lop/row" method="POST">
            <div class="text">Số Dòng :</div>
            <select class="form-control fl-l autoWidth" id="row" name="row">
            	<option value="5" >5 dòng</option>
                <option value="10">10 dòng</option>
                <option value="20">20 dòng</option></a>
            </select>
        </div>
    	</form>
    	<script>
    	document.getElementById("row").onchange = function() {
    document.getElementById("hsrow").submit();
};
</script>
        
    
    <div class="box4 marginT">
    	<table class="table table-striped table-bordered" aria-describedby="dataTables-example_info" style="margin-bottom: 200px;">
        <tr>
        	<th class="center">STT</th>
        	<th class="center colp">Mã Học Sinh</th>
        	<th class="center">Họ Và Tên</th>
            <th class="center">Ngày Sinh</th>
            <th class="center">Địa Chỉ</th>
            <th class="center colp">Quê Quán</th>
            <th class="center colp">Họ Tên Bố</th>
            <th class="center colp">Họ Tên Mẹ</th>
            <th><button id="addIn" type="button" class="btn btn-success cir" onclick="selector()"><i class="fa fa-plus"></i></button></th>
        </tr>
        
        <c:forEach var="hocsinh" items="${lis}" varStatus="indexes">
        <tr>
        	<td class="center">${indexes.index + 1}</td>
        	<td class="center colp">${hocsinh.maso}</td>
        	<td class="center">${hocsinh.ten}</td>
            <td class="center"><fmt:formatDate pattern="dd-MM-yyyy" value="${hocsinh.ngaysinh}"/></td>
            <td class="center">${hocsinh.diachi}</td>
            <td class="center colp">${hocsinh.quequan}</td>
            <td class="center colp">${hocsinh.bo}</td>
            <td class="center colp">${hocsinh.me}</td>
            <td class="center"><button type="button" class="btn btn-danger btn-del cir" onclick="fun('${khoahoc.makhoahoc}','${hocsinh.maso}','${hocsinh.ten}')"><i class="fa fa-trash-o"></i></button>
            	<button type="button" class="btn btn-info btn-del cir" onclick="change('${hocsinh.maso}','${khoahoc.makhoahoc}','${hocsinh.ten}')"><i class="fa fa-sign-out"></i></button>
            </td>
        </tr>
        </c:forEach>
        </table>
    </div>
  
</div>

<!-- end content -->




</div>


<div class="deleteClass"></div>
<form id="change" action="" method="POST">
<div class="deleteBox delete">
	<div class="quest delete"><b id="del"></b></div>
    <hr class="divider delete" style="margin-top:10px;" />
    <div class="deleteBut delete">
    	<a href="" id="aaa"><button id="dele" type="button" class="btn btn-info" onclick="delLop()"><i class="fa fa-trash-o"> Xóa</i></button></a>
        <button id="changeb" type="button" class="btn btn-info" onclick="document.getElementById('change').submit();"><i class="fa fa-trash-o"> Chuyển</i></button>
        <button type="button" class="btn btn-default btn-can"><i class="fa fa-ban"> Hủy</i></button>
    </div>
</div>
</form>

<div class="bg"></div>
<div class="box non">
	<h3 style="text-align:center">Chuyển học sinh vào lớp ${khoahoc.lop.tenlop}</h3>
	<button id="btn" type="button" class="selector" onclick="selector()" >Chọn học sinh <span class="caret fl-r" style="margin-top: 10px;"></span></button>
	<div id="selectBox" class="selectBox none-display">
		<input id="search" type="text" class="form-control inputStyle" onkeydown="searchName()"/>
        <ul id="lisHS">

        </ul>
       
	</div>
	 <form id="adIn" action="/schools/lop/${khoahoc.makhoahoc}/addIn" method="post">
        	<input type="hidden" name="addHS" value="" id="pos"/>
        </form>
    <button type="button" class="btn btn-info but-design" onclick="document.getElementById('adIn').submit();">Chuyển</button>
    <button id="a" type="button" class="btn btn-default but-design">Hủy</button>
</div>

<script src="/schools/resources/js/libs/jquery-1.9.1.js"></script>
<script src="/schools/resources/js/libs/bootstrap.min.js"></script>
<script>

var z=1;
if('${checkadd}' == 1 && z == 1){
	alert("Học sinh đã có trong lớp , bạn hãy thử lại với học sinh khác");
	z=0;
}
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


var link;
var ac;
function fun(lopid,id,hs){
	var x = "Bạn có chắc chắn muốn xóa học sinh " +hs+ " ?"
	document.getElementById("del").innerHTML = x;
	document.getElementById("changeb").setAttribute("style","display:none;");
	document.getElementById("dele").setAttribute("style","display:inline-block;");
	var l = "http://localhost:8081/schools/lop/"+lopid+"/delete/"+id;
	link = l;
}		

function delLop(){
	document.getElementById("aaa").setAttribute("href",link);
}


function change(id,lopid,name){
	var x = 'Chuyển học sinh '+name+' đến lớp : <select name="chang" class="form-control fl-r" style="width:100px;margin-right:10%;"><c:forEach var="lop" items="${lisLop}" varStatus="indexes"><option value="${lop.makhoahoc}" >${lop.lop.tenlop}</option></c:forEach></select>';
	document.getElementById("del").innerHTML = x;
	var l = "/schools/lop/"+lopid+"/change/"+id;
	document.getElementById("dele").setAttribute("style","display:none;");
	document.getElementById("changeb").setAttribute("style","display:inline-block;");
	ac = l;
	document.getElementById("change").setAttribute("action",ac);
}


$(document).ready(function(){
    $("#btn").click(function(){
        $("#selectBox").fadeToggle();
    });
});

$(document).ready(function(){
    $("#addIn").click(function(){
        $(".bg").fadeToggle();
		$(".box").fadeToggle();
		
    });
});


$(document).ready(function(){
    $("#a").click(function(){
        $(".bg").fadeToggle();
		$(".box").fadeToggle();
		
    });
});



var hocsinh = new Array();
var mahocsinh = new Array();
var inp = 0;

<c:forEach items="${lisHS}" var="hs">
var ten = new Object();
var maso = new Object();
ten = '${hs.ten}';
maso = '${hs.maso}';

hocsinh.push(ten);
mahocsinh.push(maso);
</c:forEach>

function selector(){
if(inp == 0)
var x = "";
		for(var i=0;i<hocsinh.length;i++){
			x+='<li class="item" value="'+mahocsinh[i]+'" onclick="selectHS('+mahocsinh[i]+')">'+hocsinh[i]+' - '+mahocsinh[i]+'</li>';	
		}
		document.getElementById("lisHS").innerHTML = x;
}

function searchName(){
	var sh = document.getElementById("search").value;
	if(sh == "")
		selector();
	var temp = new Array();
	var idtemp = new Array();
	var index = 0;
	for(var i=0;i<hocsinh.length;i++){
		if(	hocsinh[i].search(sh) != -1){
			temp[index] = hocsinh[i];
			idtemp[index] = mahocsinh[i];
			index++;
		}
	}
	var x="";
	for(var i=0;i<temp.length;i++){
		x+='<li class="item" value="'+idtemp[i]+'" onclick="selectHS('+idtemp[i]+')">'+temp[i]+' - '+idtemp[i]+'</li>';	
		}
		document.getElementById("lisHS").innerHTML = x;
}


function selectHS(maso){
	var x = hocsinh[maso-1]+" - "+maso+"<span class='caret fl-r' style='margin-top: 10px;'></span>";
	document.getElementById("btn").innerHTML = x;
	document.getElementById("pos").setAttribute("value",maso);
	document.getElementById("selectBox").setAttribute("style","display:none;");
}

</script>
</body>
</html>