package com.mindHub.vinilysEcommerce.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mindHub.vinilysEcommerce.dtos.ProductSelectDTO;
import com.mindHub.vinilysEcommerce.models.Bill;
import com.mindHub.vinilysEcommerce.models.Client;
import com.mindHub.vinilysEcommerce.models.Product;
import com.mindHub.vinilysEcommerce.models.ProductBill;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Pdf {
    public static void createPDF(Set<ProductSelectDTO> productSelectDTOSet,List<Product> products, Bill bill) throws DocumentException, FileNotFoundException {

        var doc = new Document();
        String route = System.getProperty("user.home");
        PdfWriter.getInstance(doc, new FileOutputStream("bill.pdf"));
        PdfWriter.getInstance(doc, new FileOutputStream(route + "/Desktop/bill.pdf"));

        doc.open();

        var bold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
        var paragraph = new Paragraph("hola");

        var table = new PdfPTable(3);
        Stream.of("Producto", "precio", "cantidad").forEach(table::addCell);



        products.forEach(product-> {
            table.addCell(product.getName());
            table.addCell("$" + product.getPrice());
        });

        productSelectDTOSet.forEach(product-> {
            table.addCell(product.getQuantity().toString());
        });

        paragraph.add(table);
        doc.add(paragraph);
        doc.close();}
}
