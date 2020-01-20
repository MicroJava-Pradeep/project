package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment;filename=WhUserType.pdf");
		
		List<WhUserType> whUsers=(List<WhUserType>)model.get("whUsers");
		
		PdfPTable pf=new PdfPTable(9);
		
		pf.addCell("ID");
		pf.addCell("Type");
		pf.addCell("Code");
		pf.addCell("For Type");
		pf.addCell("Email");
		pf.addCell("Contact");
		pf.addCell("ID Type");
		pf.addCell("If Other");
		pf.addCell("ID Number");
		
		for(WhUserType w:whUsers)
		{
			pf.addCell(w.getId().toString());
			pf.addCell(w.getType());
			pf.addCell(w.getCode());
			pf.addCell(w.getForType());
			pf.addCell(w.getEmail());
			pf.addCell(w.getContact());
			pf.addCell(w.getIdType());
			pf.addCell(w.getIfOther());
			pf.addCell(w.getIdNum());
		}
		
		document.add(pf);
		
	}

}
