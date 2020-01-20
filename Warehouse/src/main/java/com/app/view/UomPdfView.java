package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=Uoms.pdf");

		// create Element
		Paragraph p = new Paragraph("Welcome");

		// add To doc
		document.add(p);

		// read data from map
		@SuppressWarnings("unchecked")
		List<Uom> uoms = (List<Uom>) model.get("uoms");

		// create table
		System.out.println("Uoms Data.." + uoms);

		PdfPTable t = new PdfPTable(4);

		// add heading Columns
		t.addCell("ID");
		t.addCell("Type");
		t.addCell("Model");
		t.addCell("dsc");

		// Add DB Data to Table
		for (Uom u : uoms) {
			t.addCell(u.getId().toString());
			t.addCell(u.getUtype());
			t.addCell(u.getModel());
			t.addCell(u.getDsc());
		}

		// add to document

		document.add(t);

		// add Date and Time
		// document.add(new Paragraph(new Date().toString()));
	}
}
