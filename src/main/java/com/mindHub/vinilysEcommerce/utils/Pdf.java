package com.mindHub.vinilysEcommerce.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mindHub.vinilysEcommerce.dtos.ProductSelectDTO;
import com.mindHub.vinilysEcommerce.models.Bill;

import com.mindHub.vinilysEcommerce.models.Product;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class Pdf {
    public static void createPDF(List<Product> products, Bill bill) throws DocumentException, FileNotFoundException {

        var doc = new Document();
        String route = System.getProperty("user.home");
        PdfWriter.getInstance(doc, new FileOutputStream("bill.pdf"));
        PdfWriter.getInstance(doc, new FileOutputStream(route + "/Desktop/bill.pdf"));

        doc.open();

        var bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        var paragraph = new Paragraph("factura");

        var table = new PdfPTable(2);
        Stream.of("Producto", "precio").forEach(table::addCell);

        products.forEach(product-> {
            table.addCell(product.getName());
            table.addCell("$" + product.getPrice());
        });


        paragraph.add(table);
        doc.add(paragraph);
        doc.close();}
}
