package com.gut.practice.service.user;

import com.gut.practice.entity.Practice;
import com.gut.practice.entity.user.Student;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.ejb.Stateless;

/**
 *
 * @author kongo
 */
@Stateless
@Deprecated
public class StudentService  {
    private static String INPUTFILE = "src/main/resources/PracticesCard.pdf";
    private static String OUTPUTFILE = "src/main/resources/OutPut.pdf";
    private static int gapLeft = 1;
    private static int gapDown = 2;
    
    public boolean addPratice(Practice practice){
        try { 
            Student student = new Student();//FIXME
            student.getPracticeList().add(practice);
            return true; } 
        catch (Exception e) { 
            System.out.printf("Sorry, can't add Pratice ", e); 
        }; 
        return false; 
    }
    
    public boolean generatePracticesCardPDF(Student student){
        try {
            PdfReader pdfReader = new PdfReader(INPUTFILE);
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(OUTPUTFILE));
            PdfContentByte content = pdfStamper.getUnderContent(1);

            BaseFont bf = BaseFont.createFont("src/main/resources/DejaVuSans.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            content.beginText();
            content.setFontAndSize(bf, 10);
            // Student
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, student.getFirstName() + " " + student.getLastName(), 145 + gapLeft, 585 + gapDown, 0);
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, Integer.toString(student.getIndexID()), 122 + gapLeft, 555 + gapDown, 0);
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, "Stopień", 427 + gapLeft, 555 + gapDown, 0);
            content.showTextAligned(PdfContentByte.ALIGN_LEFT, "Specializacja", 176 + gapLeft, 526 + gapDown, 0);
            // Pracodawca
            // TODO if(text.lenght>) split to two lines
            if(student.getPracticeList().size() >0){
//                content.showTextAligned(PdfContentByte.ALIGN_LEFT, student.getPracticeList().get(0).getEmployer().getComapnyName(), 71 + gapLeft, 459 + gapDown, 0);
                content.showTextAligned(PdfContentByte.ALIGN_LEFT, "adres firmy", 71 + gapLeft, 430 + gapDown, 0);
                // poczatek praktyk
                content.showTextAligned(PdfContentByte.ALIGN_LEFT, student.getPracticeList().get(0).getDateFrom().toString(), 155 + gapLeft, 389 + gapDown, 0);
                // TODO BHP 
                // koniec praktyk
                content.showTextAligned(PdfContentByte.ALIGN_LEFT, student.getPracticeList().get(0).getDateTo().toString(), 145 + gapLeft, 260 + gapDown, 0);
            }

            content.endText();

            pdfStamper.close();
            
            return true;
            
	} catch (IOException e) {
            e.printStackTrace();
	} catch (DocumentException e) {
            e.printStackTrace();
	}
        return false;
    }
}
