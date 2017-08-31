<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title>Giáo Viên</title>
    <script src="<c:url value="/resources/js/libs/jquery.min.js"/>" />
    <script src="resources/js/libs/jquery-1.9.1.js"></script>
    <script type="text/javascript">
        function showInfo(ten,ngaysinh,diachi,email,quequan,sdt,trinhdo,namvaonghe){

            $(".tenGV").text(ten);
            $(".ngaySinh").text(ngaysinh);
            $(".diaChi").text(diachi);
            $(".email").text(email);
            $(".queQuan").text(quequan);
            $(".sdt").text(sdt);
            $(".trinhDo").text(trinhdo);
            $(".vaoNghe").text(namvaonghe);
        }
    </script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="clear"></div>
    <div id="content">
        <div id="giaovien">
            <div class="container">
                <div style="float: left; z-index: 9999;margin-top: 20px;"
                     id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title tenGV"
                                    style="text-align: center;font-family: Georgia,Serif;"></h4></div>
                            <div class="modal-body">
                                <p>
                                    Họ Và Tên: <span class="tenGV" style="font-weight: bold"></span>
                                </p>
                                <p>
                                    Ngày Sinh: <span class="ngaySinh" style="font-weight: bold"></span>
                                </p>
                                <p>
                                    Địa Chỉ: <span class="diaChi" style="font-weight: bold"></span>
                                </p>
                                <p>
                                    Quê Quán:<span class="queQuan" style="font-weight: bold"></span>
                                </p>
                                <p>
                                    Email: <span class="email" style="font-weight: bold"></span>
                                </p>


                                <p>
                                    Số Điện Thoại : <span class="sdt" style="font-weight: bold"></span>
                                </p>
                                <p>
                                    Trình Độ: <span class="trinhDo" style="font-weight: bold"></span>
                                </p>
                                <p>
                                    Năm Vào Nghề: <span class="vaoNghe" style="font-weight: bold"></span>
                                </p>
                            </div>
                            <div class="modal-footer">
                                <a type="button" class="btn btn-success" data-dismiss="modal">Close</a>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <h3 style="text-align: center;">Quản lý Giáo Viên</h3>
                    <div class="pages">
                        <ul class="pagination">
                            <c:forEach begin="1" end="${totalPage}" var="pageLoop">
                                <c:choose>
                                    <c:when test="${page== pageLoop}">
                                        <li class="active">
                                            <a href='<spring:url value="/giaovien?page=${pageLoop}"></spring:url>'>${pageLoop}</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href='<spring:url value="/giaovien?page=${pageLoop}"></spring:url>'>${pageLoop}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ul>
                        <div class="clear"></div>
                        <div class="curentLine">
                            <div class="col-sm-6">
                                <div class="dropdown" style="float: left;">
                                    <button class="btn btn-default dropdown-toggle" type="button"
                                            id="menu1" data-toggle="dropdown">
                                            ${record} dòng<span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a
                                                href='<spring:url value="/pagerows?record=5"></spring:url>'>5
                                            dòng</a></li>
                                        <li><a
                                                href='<spring:url value="/pagerows?record=10"></spring:url>'>10
                                            dòng</a></li>
                                        <li><a
                                                href='<spring:url value="/pagerows?record=20"></spring:url>'>20
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
                                                style="float: left; margin-left: 10px; margin-top: 10px;">${(page-1)*record+1} - ${totalRecord}/${totalRecord}
											Giáo Viên</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="col-sm-6">
                                <div class="controlFile">
                                    <a style="float: right;" class="btn btn-sm btn-default" href='<spring:url value="/giaovien"></spring:url>'>
                                        <span style="color:#337ab7;font-size:14px;" class="fa fa-upload"></span>
                                        <span>Upload</span>
                                    </a>
                                    <a style="float: right;margin-right:10px;" class="btn btn-sm btn-default" href='<spring:url value="/phancong/dowload"></spring:url>'>
                                        <span style="color:#337ab7;font-size:14px;" class="fa fa-download"></span>
                                        <span>Download</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <table  class="table table-bordered table-hover table-condensed">
                     <thead>
                            <tr align="center" class="active">
                                <th>STT</th>
                                <th>Họ và Tên</th>
                                <th>Ngày Sinh</th>
                                <th>Địa Chỉ</th>
                                <th>Quê Quán</th>
                                <th>Email</th>
                                <th>Số Điện Thoại</th>
                                <th>Trình Độ</th>
                                <th>Năm Kinh Ngiệm</th>
                                <td align="center" width="90px"><a href="giaovien/addGiaoVien"><button type="button" class="btn btn-success btn-lg"><i class="fa fa-plus"></i></button></a></td>
                            </tr>
                     </thead>
                     <tbody>
                        <c:forEach items="${giaovienList}" var="giaoVien" varStatus="s">
                            <tr>
                                <td>${s.count}</td>
                                <td><a data-toggle="modal" data-target="#myModal"
                                      onclick="showInfo('${giaoVien.ten}','${giaoVien.ngaysinh}','${giaoVien.diachi}','${giaoVien.quequan}','${giaoVien.email}',
                                              '${giaoVien.sdt}','${giaoVien.trinhdo}','${giaoVien.namvaonghe}');"
                                        style="text-decoration: none;" href="#">${giaoVien.ten}</a>
                                </td>
                                <td>${giaoVien.ngaysinh}</td>
                                <td>${giaoVien.diachi}</td>
                                <td>${giaoVien.quequan}</td>
                                <td>${giaoVien.email}</td>
                                <td>${giaoVien.sdt}</td>
                                <td>${giaoVien.trinhdo}</td>
                                <td >${giaoVien.namvaonghe}</td>
                                <td >
                                   <a   style="float: left" href="<spring:url value="/giaovien/editGiaoVien/${giaoVien.magiaovien}"></spring:url> ">
                                       <button type="button" class="btn btn-info"><i class="fa fa-pencil"></i></button></a>

                                    <a  style="float: right"> <button type="submit" onclick="comfirmDelete('${giaoVien.magiaovien}')" class="btn btn-primary btn-md" data-toggle="modal" data-target="#confirm-delete"><i class="fa fa-trash-o"></i></button></a>
                                </td>

                            </tr>
                        </c:forEach>
                     </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>

<script type="text/javascript">
//    let currentComfirmDeleteGV = void(0);
//		function go_Click(e){
//            console.log(e);
//            return currentComfirmDeleteGV = e;
//			}
        function comfirmDelete(maGV){
           // console.log(currentComfirmDeleteGV);
                $("#urlDelete").attr("href","giaovien/delete/" +maGV);
            document.getElementById("close-modal").click();
        }
		
</script>

<div class="modal fade" id="confirm-delete" style="margin-top: 200px" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Comfirm Delete </h4>
      </div>
        <div class="modal-body">
            <p>Bạn có chắc chắn xóa chứ ?&hellip;</p>
        </div>
      <div class="modal-footer">
        <button id="close-modal" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
       <a class="btn btn-primary"  id="urlDelete">Xóa ngay và luôn</a>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	function remove(index) {
		
		$(".giaovien.magiaovien").remove();
	}

</script>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
