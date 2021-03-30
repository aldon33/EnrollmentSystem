package SearchEditDelete;

import Input.StudentLinkedList;
import com.jfoenix.controls.JFXRadioButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class EditController extends StudentLinkedList {
    ObservableList<String> programs = FXCollections.observableArrayList("Chemical Engineering",
            "Civil Engineering", "Computer Engineering", "Electronics & Communications Engineering",
            "Industrial Engineering", "Manufacturing Engineering", "Mechanical Engineering");

    @FXML
    private AnchorPane EditAnchor;

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
    private TextField studentName;

    @FXML
    private ToggleGroup yearLevelChoice;

    @FXML
    private ChoiceBox<String> programChoice;

    @FXML
    private TextField courseChoice1;

    @FXML
    private TextField courseChoice2;

    @FXML
    private TextField courseChoice3;

    @FXML
    private TextField courseChoice4;

    public void initialize(){
        programChoice.setItems(programs);
    }





    public void editStudent(ActionEvent event) throws IOException {

        String name =  studentName.getText();
        RadioButton selectedYearLevel = (RadioButton) yearLevelChoice.getSelectedToggle();
        String yearLevel = selectedYearLevel.getText();
        String program = (String) programChoice.getValue();
        String course1 = (String) courseChoice1.getText();
        String course2 = (String) courseChoice2.getText();
        String course3 = (String) courseChoice3.getText();
        String course4 = (String) courseChoice4.getText();




        allStudents.read = false;
        allStudents.editBetweenNodes(name, yearLevel, program, course1, course2, course3, course4);

        studentName.setText("");



    }

    public void back(ActionEvent event) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Menu/MenuUI.fxml"));
        EditAnchor.getChildren().setAll(nextAnchorPane);
    }

}
