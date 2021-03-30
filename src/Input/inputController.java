package Input;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import javax.swing.*;
import java.io.IOException;

public class inputController extends StudentLinkedList {
    ObservableList<String> programs = FXCollections.observableArrayList("Chemical Engineering",
            "Civil Engineering", "Computer Engineering", "Electronics & Communications Engineering",
            "Industrial Engineering", "Manufacturing Engineering", "Mechanical Engineering");

    @FXML
    private AnchorPane inputAnchor;

    @FXML
    private TextField studentName;

    @FXML
    private ChoiceBox<String> programChoice;

    @FXML
    private ToggleGroup yearLevelChoice;

    @FXML
    private TextField courseChoice1;

    @FXML
    private TextField courseChoice2;

    @FXML
    private TextField courseChoice3;

    @FXML
    private TextField courseChoice4;

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

    public void initialize(){
        programChoice.setItems(programs);
    }


    public void getStudentData(ActionEvent event) throws IOException{
        String name = studentName.getText();

        RadioButton yearLevel = (RadioButton) yearLevelChoice.getSelectedToggle();
        String year = yearLevel.getText();
        String program= programChoice.getValue();

        String course1 = courseChoice1.getText();
        String course2 = courseChoice2.getText();
        String course3 = courseChoice3.getText();
        String course4 = courseChoice4.getText();

        StudentLinkedList.allStudents.read = false;
        StudentLinkedList.allStudents.pushStudentData(name, program, year, course1, course2, course3, course4);

        System.out.println(name);
        System.out.println(program);
        System.out.println(year);
        System.out.println(" ");
    }

    public void back(ActionEvent event) throws IOException {
        // this is the usual way to go from the "current page" to the "next page"
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Menu/MenuUI.fxml"));
        inputAnchor.getChildren().setAll(nextAnchorPane);


    }
}
