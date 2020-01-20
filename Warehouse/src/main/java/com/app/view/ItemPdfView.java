package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=Item.pdf");
		@SuppressWarnings("unchecked")
		List<Item> items=(List<Item>)model.get("items");
		
		PdfPTable pt=new PdfPTable(7);
		
		pt.addCell("ID");
		pt.addCell("Item Code");
		pt.addCell("Item Dimensions");		
		pt.addCell("Base Cost");
		pt.addCell("Base Currency");
		pt.addCell("Uom");
		pt.addCell("Description");
		
		
		for(Item i:items)
		{
			pt.addCell(i.getId().toString());
			pt.addCell(i.getiCode());		
			pt.addCell(i.getWid()+","+i.getLen()+","+i.getHgt());		
			pt.addCell(""+i.getBaseCost());
			pt.addCell(i.getBaseCurrency());
			pt.addCell(i.getUom().getModel());
			pt.addCell(i.getDsc());
			
			
		}
		
		
		document.add(pt);
	
		
	}

}
