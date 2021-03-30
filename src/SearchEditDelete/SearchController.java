package SearchEditDelete;

import Input.StudentLinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class SearchController extends StudentLinkedList {
    @FXML
    private AnchorPane SearchResultAnchor;

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
        givenName.setText(nameSearch);
        givenYearLevel.setText(yearLevelSearch);
        givenProgram.setText(programSearch);
    }

    public void back(ActionEvent event) throws IOException {
        AnchorPane nextAnchorPane = FXMLLoader.load(getClass().getResource("../Menu/MenuUI.fxml"));
        SearchResultAnchor.getChildren().setAll(nextAnchorPane);
    }

}
