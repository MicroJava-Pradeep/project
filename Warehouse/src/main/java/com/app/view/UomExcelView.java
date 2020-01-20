package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=Uom.xls");
		
		Sheet sheet = workbook.createSheet("Uoms");

		setHead(sheet);
		@SuppressWarnings("unchecked")
		List<Uom> uoms = (List<Uom>) model.get("uoms");
		System.out.println("data...." + uoms);
		setBody(sheet, uoms);

	}

	private void setBody(Sheet sheet, List<Uom> uoms) {

		int rowNum = 1;
		for (Uom u : uoms) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(u.getId());
			row.createCell(1).setCellValue(u.getUtype());
			row.createCell(2).setCellValue(u.getModel());
			row.createCell(3).setCellValue(u.getDsc());
			sheet.autoSizeColumn(3);
		}

	}

	private void setHead(Sheet sheet) {

		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Uom Type");
		row.createCell(2).setCellValue("Uom Model");
		row.createCell(3).setCellValue("Description");
	}

}
