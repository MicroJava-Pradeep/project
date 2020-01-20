package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.pdf");

		// create Element
		Paragraph p = new Paragraph("Welcome");

		// add To doc
		document.add(p);

		// read data from map
		@SuppressWarnings("unchecked")
		List<OrderMethod> oms = (List<OrderMethod>) model.get("oms");

		// create table
		System.out.println("OrderMethods Data.." + oms);

		PdfPTable t = new PdfPTable(6);

		// add heading Columns
		t.addCell("ID");
		t.addCell("Mode");
		t.addCell("Code");
		t.addCell("Method");
		t.addCell("Accept");
		t.addCell("Description");

		// Add DB Data to Table
		for (OrderMethod o : oms) {
			t.addCell(o.getId().toString());
			t.addCell(o.getMode());
			t.addCell(o.getCode());
			t.addCell(o.getMethod());
			t.addCell(o.getAccept().toString());
			t.addCell(o.getDsc());
		}

		// add to document

		document.add(t);

		// add Date and Time
		// document.add(new Paragraph(new Date().toString()));
	}

}
