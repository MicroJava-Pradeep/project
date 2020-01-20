package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition", "attachment;filename=ShipmentType.pdf");
		
		@SuppressWarnings("unchecked")
		List<ShipmentType> sTypes=(List<ShipmentType>)model.get("sType");
		
		PdfPTable t=new PdfPTable(6);
		
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("ENABLED");
		t.addCell("GRADE");
		t.addCell("DESCRIPTION");
		
		for(ShipmentType s:sTypes)
		{
			t.addCell(s.getId().toString());
			t.addCell(s.getMode());
			t.addCell(s.getCode());
			t.addCell(s.getEnabled());
			t.addCell(s.getGrade());
			t.addCell(s.getDsc());
		}
		
		document.add(t);
	}

}
