package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Item;

public class ItemExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition", "attachment;filename=Item.xls");
		
		Sheet sheet=workbook.createSheet("Items");
		CellStyle cs=workbook.createCellStyle();
		cs.setAlignment(CellStyle.VERTICAL_CENTER);
		
		@SuppressWarnings("unchecked")
		List<Item> items=(List<Item>)model.get("items");		
		setHead(sheet,cs);
		setBody(items,sheet);
	}

	

	private void setHead(Sheet sheet,CellStyle cs) {
		sheet.addMergedRegion(new CellRangeAddress(0,1,0,0));
		sheet.addMergedRegion(new CellRangeAddress(0,1,1,1));
		sheet.addMergedRegion(new CellRangeAddress(0,0,2,4));
		sheet.addMergedRegion(new CellRangeAddress(0,1,5,5));
		sheet.addMergedRegion(new CellRangeAddress(0,1,6,6));
		sheet.addMergedRegion(new CellRangeAddress(0,1,7,7));
		sheet.addMergedRegion(new CellRangeAddress(0,1,8,8));
		
		
		Row row=sheet.createRow(0);
		Row subRow=sheet.createRow(1);
		System.out.println("......Row Style......."+row.getRowStyle());
		Cell cell=row.createCell(0);
		cell.setCellValue("ID");
		cell.setCellStyle(cs);
		
		Cell cell1=row.createCell(1);
		cell1.setCellValue("CODE");
		cell1.setCellStyle(cs);
		Cell cell2=row.createCell(2);
		cell2.setCellValue("Dimentions");
		cell2.setCellStyle(cs);;
		subRow.createCell(2).setCellValue("w");			
		subRow.createCell(3).setCellValue("w");			
		subRow.createCell(4).setCellValue("w");			
		row.createCell(5).setCellValue("Base Cost");
		row.createCell(6).setCellValue("Base Currency");
		row.createCell(7).setCellValue("UOM");
		row.createCell(8).setCellValue("Description");
	}
	
	private void setBody(List<Item> items, Sheet sheet) {
		
		int rowNum=2;		
		for(Item i:items)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(i.getId());
			row.createCell(1).setCellValue(i.getiCode());			
			row.createCell(2).setCellValue(i.getWid());			
			row.createCell(3).setCellValue(i.getLen());			
			row.createCell(4).setCellValue(i.getHgt());			
			row.createCell(5).setCellValue(i.getBaseCost());
			row.createCell(6).setCellValue(i.getBaseCurrency());
			row.createCell(7).setCellValue(i.getUom().getModel());
			row.createCell(8).setCellValue(i.getDsc());
			sheet.autoSizeColumn(8);
		}
		
	}

}
