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

import java.io.IOException;

public class DeleteController extends StudentLinkedList {

    @FXML
    private AnchorPane DeleteAnchor;

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



    public void confirmDelete(ActionEvent event) throws IOException {
        allStudents.deleteBetweenNodes();

        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Menu/MenuUI.fxml"));
        DeleteAnchor.getChildren().setAll(nextAnchorPane);
    }

    @FXML
    private AnchorPane DeleteIntroAnchor;

    @FXML
    private TextField searchName;

    @FXML
    private Text searchError;
/*
    public void initialize(){
        givenName.setText(nameSearch);
        givenYearLevel.setText(yearLevelSearch);
        givenProgram.setText(programSearch);
    }
 */
    public void searchStudentName(ActionEvent event) throws IOException {
        allStudents.search(searchName.getText());

        if (nameSearch.equals("")) {
            System.out.println("Error");

            FadeTransition fadeInMark = new FadeTransition(Duration.seconds(0.2), searchError);
            fadeInMark.setFromValue(0.0);
            fadeInMark.setToValue(1.0);
            fadeInMark.play();
        } else {
            AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("DeleteSearch.fxml"));
            DeleteAnchor.getChildren().setAll(nextAnchorPane);
        }
    }

    public void deleteStudent(ActionEvent event) throws IOException {

        if (nameSearch.equals("")) {
            System.out.println("Error");

            FadeTransition fadeInMark = new FadeTransition(Duration.seconds(0.2), searchError);
            fadeInMark.setFromValue(0.0);
            fadeInMark.setToValue(1.0);
            fadeInMark.play();
        }
        else {
            allStudents.deleteBetweenNodes();
            System.out.println("student deleted");
        }



    }
    // upon mouse click, this goes to the previous page, which is the main menu
    public void back (ActionEvent event) throws IOException {
        // this is the usual way to go from the "current page" to the "next page"
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Menu/MenuUI.fxml"));
        DeleteAnchor.getChildren().setAll(nextAnchorPane);
    }
}