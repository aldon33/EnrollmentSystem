package Menu;

import Input.StudentLinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuController extends StudentLinkedList {

    @FXML
    private AnchorPane  MenuAnchor;

    public void registerStudent(ActionEvent event) throws IOException {
        // this is the usual way to go from the "current page" to the "next page"
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Input/InputStudent.fxml"));
        MenuAnchor.getChildren().setAll(nextAnchorPane);
    }

    public void searchStudent(ActionEvent event) throws IOException {
        // this is the usual way to go from the "current page" to the "next page"
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../SearchEditDelete/SearchUI.fxml"));
        MenuAnchor.getChildren().setAll(nextAnchorPane);
    }

    public void printStudent(ActionEvent event) throws IOException {
        // this is the usual way to go from the "current page" to the "next page"
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Receipt/ReceiptUIIntro.fxml"));
        MenuAnchor.getChildren().setAll(nextAnchorPane);
    }

    public void deleteStudent(ActionEvent event) throws IOException {
        // this is the usual way to go from the "current page" to the "next page"
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../SearchEditDelete/DeleteSearch.fxml"));
        MenuAnchor.getChildren().setAll(nextAnchorPane);
    }

    public void editStudent(ActionEvent event) throws IOException {
        // this is the usual way to go from the "current page" to the "next page"
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../SearchEditDelete/EditIntroUI.fxml"));
        MenuAnchor.getChildren().setAll(nextAnchorPane);
    }

    public void selectCourses(ActionEvent event) throws IOException{
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Courses/AddCoursesUI.fxml"));
        MenuAnchor.getChildren().setAll(nextAnchorPane);
    }
}
