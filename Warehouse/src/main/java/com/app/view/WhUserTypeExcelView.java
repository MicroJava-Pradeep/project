package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment;filename=WhUserType.Xls");
		Sheet sheet=workbook.createSheet("WhUser");
		@SuppressWarnings("unchecked")
		List<WhUserType> whUsers=(List<WhUserType>)model.get("whUsers");
		
		setHead(sheet);
		setBody(sheet,whUsers);
		
		
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Type");
		row.createCell(2).setCellValue("Code");
		row.createCell(3).setCellValue("For Type");
		row.createCell(4).setCellValue("Email");
		row.createCell(5).setCellValue("Contact");
		row.createCell(6).setCellValue("ID Type");
		row.createCell(7).setCellValue("If Other");
		row.createCell(8).setCellValue("ID Number");
		
	}

	private void setBody(Sheet sheet, List<WhUserType> whUsers) {
		
		int numRow=1;
		
		for(WhUserType w:whUsers)
		{
			Row row=sheet.createRow(numRow++);
			row.createCell(0).setCellValue(w.getId());
			row.createCell(1).setCellValue(w.getType());
			row.createCell(2).setCellValue(w.getCode());
			row.createCell(3).setCellValue(w.getForType());
			row.createCell(4).setCellValue(w.getEmail());
			row.createCell(5).setCellValue(w.getContact());
			row.createCell(6).setCellValue(w.getIdType());
			row.createCell(7).setCellValue(w.getIfOther());
			row.createCell(8).setCellValue(w.getIdNum());
			
			sheet.autoSizeColumn(8);
		}
		
	}

}
