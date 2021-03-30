package Receipt;

import Input.StudentLinkedList;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;

public class ReceiptIntro extends StudentLinkedList {

    @FXML
    private AnchorPane ReceiptIntroAnchor;

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

    @FXML
    private TextField searchName;




    public void searchStudentName(ActionEvent event) throws IOException {
        allStudents.search(searchName.getText());

        if(nameSearch.equals("")){
            System.out.println("Error");

            FadeTransition fadeInMark = new FadeTransition(Duration.seconds(0.2), searchError);
            fadeInMark.setFromValue(0.0);
            fadeInMark.setToValue(1.0);
            fadeInMark.play();
        }
        else {
            AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("ReceiptUI.fxml"));
            ReceiptIntroAnchor.getChildren().setAll(nextAnchorPane);


        }

    }




    public void back(ActionEvent event) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Menu/MenuUI.fxml"));
        ReceiptIntroAnchor.getChildren().setAll(nextAnchorPane);
    }
}
