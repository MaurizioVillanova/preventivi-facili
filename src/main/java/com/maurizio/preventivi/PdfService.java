package com.maurizio.preventivi;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.ByteArrayOutputStream;

public class PdfService {

    public static byte[] generaPdf(PreventivoForm p) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter writer = new PdfWriter(out);
            Document document = new Document(new com.itextpdf.kernel.pdf.PdfDocument(writer));

            document.add(new Paragraph("PREVENTIVO"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Cliente: " + p.getNomeCliente()));
            document.add(new Paragraph("Servizio: " + p.getDescrizioneServizio()));
            document.add(new Paragraph("Prezzo: " + p.getPrezzo() + " €"));
            document.add(new Paragraph("IVA: " + p.getIva() + " €"));
            document.add(new Paragraph("Totale: " + p.getTotale() + " €"));

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toByteArray();
    }
}