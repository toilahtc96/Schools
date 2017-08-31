package vn.com.imic.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import vn.com.imic.model.Giaovien;

public class ExcelDowLoad extends AbstractExcelView {

	public ExcelDowLoad() {
		System.out.println("Khoi Tao ExcelDowLoad");
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Giaovien> giaoViens = (List<Giaovien>) model.get("giaoViens");
		HSSFSheet sheet = workbook.createSheet("Danh Sach Giao Vien");
		int count = 0;
		HSSFRow row = sheet.createRow(count);
		row.createCell(0).setCellValue("Mã Giáo Viên");
		row.createCell(1).setCellValue("Họ Và Tên");
		row.createCell(2).setCellValue("Ngày Sinh");
		row.createCell(3).setCellValue("Địa Chỉ");
		row.createCell(4).setCellValue("Quê Quán");
		row.createCell(5).setCellValue("Email");
		row.createCell(6).setCellValue("Số Điện Thoại");
		row.createCell(7).setCellValue("Năm Vào Nghề");
		row.createCell(8).setCellValue("Trình Độ");
		for (Giaovien giaovien : giaoViens) {
			count++;
			HSSFRow rown = sheet.createRow(count);
			rown.createCell(0).setCellValue(giaovien.getMagiaovien());
			rown.createCell(1).setCellValue(giaovien.getTen());
			rown.createCell(2).setCellValue(giaovien.getNgaysinh());
			rown.createCell(3).setCellValue(giaovien.getDiachi());
			rown.createCell(4).setCellValue(giaovien.getQuequan());
			rown.createCell(5).setCellValue(giaovien.getEmail());
			rown.createCell(6).setCellValue(giaovien.getSdt());
			rown.createCell(7).setCellValue(giaovien.getNamvaonghe());
			rown.createCell(8).setCellValue(giaovien.getTrinhdo());
		}
	}

}
