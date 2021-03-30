package Receipt;

import Input.StudentLinkedList;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Random;
import javafx.util.Duration;

import java.io.FileOutputStream;
import java.io.IOException;

public class ReceiptController extends StudentLinkedList {


    public static int receiptsGenerated = 0;

    @FXML
    private TextField searchName;

    @FXML
    private AnchorPane ReceiptAnchor;

    @FXML
    private Text givenName;

    @FXML
    private Text givenYearLevel;

    @FXML
    private Text givenProgram;

    @FXML
    private Text givenCourse1;

    @FXML
    private Text givenCourse2;

    @FXML
    private Text givenCourse3;

    @FXML
    private Text givenCourse4;

    @FXML
    private Text searchError;


    public void initialize(){
        givenName.setText(nameSearch);
        givenYearLevel.setText(yearLevelSearch);
        givenProgram.setText(programSearch);
        givenCourse1.setText(courseSearch1);
        givenCourse2.setText(courseSearch2);
        givenCourse3.setText(courseSearch3);
        givenCourse4.setText(courseSearch4);
    }




/*
    public void savePDF(ActionEvent event) throws IOException, DocumentException{
        Document document = new Document(PageSize.LETTER);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Receipts/Receipt#" + receiptsGenerated +  ".pdf"));
        document.open();

        PdfPTable logoAndName = new PdfPTable(2);
        logoAndName.setWidthPercentage(100);
        logoAndName.setWidths(new int[]{1, 6});

        Font title = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
        Font fontBase = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
        Font fontGrand = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);

        Chunk progName = new Chunk("Enrollment System", title);
        Chunk chunkName = new Chunk("Student Name:\t\t\t" + nameSearch, fontBase);
        Chunk chunkYearLevel = new Chunk("Student Year Level:\t\t\t" + yearLevelSearch, fontBase);
        Chunk chunkProgram = new Chunk("Student Program:\t\t\t" + programSearch, fontBase);
        Chunk spacing = new Chunk("\n");

        Phrase phrase = new Phrase();
        phrase.add("\n\n\n");
        phrase.add(chunkName +"\n\n");
        phrase.add(chunkYearLevel+"\n\n");
        phrase.add(chunkProgram+"\n\n");
        phrase.add("\n\n==========================\n\n");
        logoAndName.addCell(createTextCell(progName));
        document.add(spacing);
        document.add(logoAndName);
        document.add(spacing);
        document.add(phrase);
        document.close();
        receiptsGenerated = receiptsGenerated + 1;
    }

 */

    public static PdfPCell createTextCell(Chunk text) throws DocumentException, IOException {
        PdfPCell cell = new PdfPCell();
        Paragraph p = new Paragraph(text);
        p.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(p);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }

    public static PdfPCell createImageCell(Image img) throws DocumentException, IOException {
        PdfPCell cell = new PdfPCell(img, false);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }

    public void printReceipt(ActionEvent event) throws IOException, DocumentException {
        if (givenName.getText().equals("")){
            System.out.println("Error");
        }
        else{

            Document document = new Document(PageSize.LETTER);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Receipts/Receipt#" + receiptsGenerated +  ".pdf"));
            document.open();

            Image img = Image.getInstance("src/Assets/school_logo_small.png");
            PdfPTable logoAndName = new PdfPTable(2);


            logoAndName.setWidthPercentage(100);
            logoAndName.setWidths(new int[]{1, 6});

            Font title = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
            Font fontBase = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
            Font fontGrand = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);

            Chunk progName = new Chunk("Enrollment System", title);
            Chunk chunkName = new Chunk("Student Name:\t\t\t" + nameSearch, fontBase);
            Chunk chunkYearLevel = new Chunk("Student Year Level:\t\t\t" + yearLevelSearch, fontBase);
            Chunk chunkProgram = new Chunk("Student Program:\t\t\t" + programSearch, fontBase);
            Chunk chunkCourses = new Chunk("Student Courses:\t\t\t" + courseSearch1 + ", " + courseSearch2 + ", " + courseSearch3 + ", " + courseSearch4, fontBase);
            /*
            Chunk chunkProgram = new Chunk("Student Program:\t\t\t" + courseSearch2, fontBase);
            Chunk chunkProgram = new Chunk("Student Program:\t\t\t" + courseSearch3, fontBase);
            Chunk chunkProgram = new Chunk("Student Program:\t\t\t" + courseSearch4, fontBase);

             */

            Chunk spacing = new Chunk("\n");




            Phrase phrase = new Phrase();
            phrase.add("\n\n\n");
            phrase.add(chunkName +"\n\n");
            phrase.add(chunkYearLevel+"\n\n");
            phrase.add(chunkProgram+"\n\n");
            phrase.add(chunkCourses+"\n\n");
            phrase.add("\n\n");
            phrase.add("\n\n");
            phrase.add("\n\n=============================================================================\n\n");
            logoAndName.addCell(createImageCell(img));
            logoAndName.addCell(createTextCell(progName));



            document.add(spacing);
            document.add(logoAndName);
            document.add(spacing);
            document.add(phrase);

            document.close();

            receiptsGenerated = receiptsGenerated + 1;
        }
    }




    public void back(ActionEvent event) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Menu/MenuUI.fxml"));
        ReceiptAnchor.getChildren().setAll(nextAnchorPane);
    }
}
