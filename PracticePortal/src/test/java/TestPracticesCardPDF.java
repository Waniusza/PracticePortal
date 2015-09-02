/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author kongo
 */
public class TestPracticesCardPDF {
    private static String INPUTFILE = "src/main/resources/PracticesCard.pdf";
    private static String OUTPUTFILE = "src/main/resources/OutPut.pdf";
    private static int gapLeft = 1;
    private static int gapDown = 2;
    
    public static void main(String[] arg) {
        try {
            PdfReader pdfReader = new PdfReader(INPUTFILE);
        
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(OUTPUTFILE));
            

            PdfContentByte content = pdfStamper.getUnderContent(1);

            BaseFont bf = BaseFont.createFont("src/main/resources/DejaVuSans.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            content.beginText();
            content.setFontAndSize(bf, 10);
            // Student
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, "Jan Kowalski", 145 + gapLeft, 585 + gapDown, 0);
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, "1234567", 122 + gapLeft, 555 + gapDown, 0);
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, "33", 427 + gapLeft, 555 + gapDown, 0);
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, "FT-IS", 176 + gapLeft, 526 + gapDown, 0);
            // Pracodawca
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, "Dariusz Kowalski", 71 + gapLeft, 459 + gapDown, 0);
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, "Gdańsk", 71 + gapLeft, 430 + gapDown, 0);
            // poczatek praktyk
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, "12 12 2000", 155 + gapLeft, 389 + gapDown, 0);

            content.showTextAligned(PdfContentByte.ALIGN_LEFT, "11 11 2100", 145 + gapLeft, 260 + gapDown, 0);

            content.endText();

            pdfStamper.close();
            

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
