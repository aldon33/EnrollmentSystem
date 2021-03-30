package SearchEditDelete;

import Input.StudentLinkedList;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;


import javax.swing.*;
import java.io.IOException;



public class SearchIntroController extends Input.StudentLinkedList {

    @FXML
    private AnchorPane SearchAnchor;

    @FXML
    private Text givenName;

    @FXML
    private Text searchError;

    @FXML
    private Text givenYearLevel;

    @FXML
    private Text givenProgram;

    @FXML
    private TextField searchName;

    public void back(ActionEvent event) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Menu/MenuUI.fxml"));
        SearchAnchor.getChildren().setAll(nextAnchorPane);
    }


    public void searchStudentName(ActionEvent event) throws IOException{
        allStudents.search(searchName.getText());

        if(nameSearch.equals("")){
            System.out.println("Error");

            FadeTransition fadeInMark = new FadeTransition(Duration.seconds(0.2), searchError);
            fadeInMark.setFromValue(0.0);
            fadeInMark.setToValue(1.0);
            fadeInMark.play();
        }
        else{
            AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("SearchUIResult.fxml"));
            SearchAnchor.getChildren().setAll(nextAnchorPane);

        }
    }
}
