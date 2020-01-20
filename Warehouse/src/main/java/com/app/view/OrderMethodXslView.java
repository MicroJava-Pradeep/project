package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.OrderMethod;
import com.app.model.Uom;

public class OrderMethodXslView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.xls");
		
		Sheet sheet = workbook.createSheet("OrderMethod");

		setHead(sheet);
		@SuppressWarnings("unchecked")
		List<OrderMethod> oms = (List<OrderMethod>) model.get("oms");
		System.out.println("data...." + oms);
		setBody(sheet, oms);

	}
	
	private void setHead(Sheet sheet) {

		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Order Mode");
		row.createCell(2).setCellValue("Order code");
		row.createCell(3).setCellValue("Order method");
		row.createCell(4).setCellValue("Order Accept");
		row.createCell(5).setCellValue("Order Description");
	}

	private void setBody(Sheet sheet, List<OrderMethod> oms) {

		int rowNum = 1;
		for (OrderMethod om : oms) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(om.getId());
			row.createCell(1).setCellValue(om.getMode());
			row.createCell(2).setCellValue(om.getCode());
			row.createCell(3).setCellValue(om.getMethod());
			row.createCell(4).setCellValue(om.getAccept().toString());
			row.createCell(5).setCellValue(om.getDsc());
			sheet.autoSizeColumn(5);
		}

	}

	

}
