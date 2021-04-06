package CPA2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LoginController {

    public TextField password_field;
    public TextField ID_numberfield;
    public Button login_button;
    public Text forget;
    public Text signup;

    public void click(MouseEvent mouseEvent) throws IOException {
        OpenRegister();
    }
    public void OpenRegister() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/Register.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void close_function(){
        Stage stage = (Stage) login_button.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void OpenNext() throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Menu/MenuUI.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void click1(MouseEvent mouseEvent) {
    }


    public void Success(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("SUCCESS");
        alert.setHeaderText("SUCCESS!");
        alert.setContentText("Login is successfull");
        alert.showAndWait();

    }
    public void Error(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR!");
        alert.setContentText("FILL ALL THE BLANKS");
        alert.showAndWait();
        set_blank();
    }

    public void Error2(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR!");
        alert.setContentText("LOGIN FAILED");
        alert.showAndWait();
        set_blank();
    }
    public void set_blank(){
        ID_numberfield.setText("");
        password_field.setText("");

    }



    //------------------------------------------MAIN FUNCTION----------------------------------------------
    public void load_file(){
        String user = new String(ID_numberfield.getText());
        String pass = new String(password_field.getText());
        File myObj = new File(user);
        if (myObj.exists())
        {
            System.out.println("THE FILE EXIST");
            try{
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()){
                    String data = myReader.nextLine();
                    if (data.equals(pass))
                    {
                        Success();
                        set_blank();
                        OpenNext();
                    }
                    else
                    {
                        Error2();
                    }
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                Error2();
                e.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR!");
            alert.setContentText("FILE DID NOT EXIST");
            alert.showAndWait();
        }
    }


}
