package CPA2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterController {
    public TextField fname_field;
    public TextField lname_field;
    public TextField IDnumber_field;
    public TextField email_field;
    public TextField newp_field;
    public TextField rp_field;
    public Button sign_up_button;
    public ImageView exit_button;

    //-------------------------------------------------PROMPT MESSAGES------------------------------------
    public void Error(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR!");
        alert.setContentText("FILL ALL THE BLANKS");
        alert.showAndWait();
    }

    public void Error2(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR!");
        alert.setContentText("PASSWORD DID NOT MATCH");
        alert.showAndWait();
    }
    public void Error3(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("ERROR");
        alert.setContentText("An error occurred");
        alert.showAndWait();
    }
    public void Success(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("SUCCESS");
        alert.setHeaderText("SUCCESS!");
        alert.setContentText("Your registration is successfull");
        alert.showAndWait();
    }
    //----------------------------------------------------------------------------------------------

    public void hello(){
        System.out.println("Hello");
    }
    public void getText(){
        String fname = fname_field.getText();
        String lname = lname_field.getText();
        String email = email_field.getText();
        String IDnum = IDnumber_field.getText();
        String pass = newp_field.getText();
        String pass2 = rp_field.getText();
        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || IDnum.isEmpty() || (pass.isEmpty()) || (pass2.isEmpty())){
            Error();
        }
        else{
            save_file();
        }
    }
    public void save_file(){
        String user = new String(lname_field.getText());
        String pass = new String(newp_field.getText());
        String IDnum = new String(IDnumber_field.getText());
        String pass2 = new String(rp_field.getText());
        Object myObj = new File(IDnum);
        if (pass.equals(pass2)) {
            try {
                if (((File) myObj).createNewFile()) {
                    File file = new File(IDnum);
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    Success();
                    br.write(pass);
                    br.close();
                    fr.close();
                    close_function();
                } else {
                    Error3();
                }
            } catch (IOException e) {
                Error3();
                e.printStackTrace();
            }

        }
        else {
            Error2();
        }
    }
    public void close_function(){
        Stage stage = (Stage) sign_up_button.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
    public void close_function1(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) exit_button.getScene().getWindow();
        // do what you have to do
        stage.close();
        openMain();
    }
    public void openMain() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
