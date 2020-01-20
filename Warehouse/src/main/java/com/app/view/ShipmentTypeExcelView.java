package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachement;filename=ShipmentType.xls");
		
		Sheet sheet = workbook.createSheet("ShpmentTypes");
		@SuppressWarnings("unchecked")
		List<ShipmentType> sts = (List<ShipmentType>) model.get("sType");
		setHead(sheet);
		setBody(sheet, sts);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Model");
		row.createCell(2).setCellValue("Code");
		row.createCell(3).setCellValue("Enable");
		row.createCell(4).setCellValue("Grade");
		row.createCell(5).setCellValue("Description");

	}

	private void setBody(Sheet sheet, List<ShipmentType> sts) {
		
		int rowNum=1;
		
		for(ShipmentType sType:sts){
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(sType.getId());
			row.createCell(1).setCellValue(sType.getMode());
			row.createCell(2).setCellValue(sType.getCode());
			row.createCell(3).setCellValue(sType.getEnabled());
			row.createCell(4).setCellValue(sType.getGrade());
			row.createCell(5).setCellValue(sType.getDsc());
			
			sheet.autoSizeColumn(5);
		}
		

	}

}
