package com.mycompany.javafx.database;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Login implements Initializable {

    @FXML
    private Label dbConlb;
    @FXML
    private Label check;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void statusDB(ActionEvent e) throws IOException, SQLException {
        if (AdminDB.getConnection().isClosed()) {
            dbConlb.setTextFill(Color.RED);
            dbConlb.setText("Not Connected !");
        } else {
            dbConlb.setTextFill(Color.GREEN);
            dbConlb.setText("Connected !");
        }
    }

    public void enterCP(ActionEvent e) throws IOException, SQLException {
        List<Admins> list = AdminDB.getAdmins();
        Map<String, String> map = new HashMap<>();
        for (Admins a : list) {
            map.put(a.getUsername(), a.getPassword());
        }
        if(map.containsKey(username.getText())){
            String val2 = map.get(username.getText());
            if(val2.equals(password.getText())){
                check.setTextFill(Color.GREEN);
                check.setText("Success !");
                App.setRoot("ControlPanel");
            }
        }else{
            check.setTextFill(Color.RED);
            check.setText("Failed try again !");
        }
    }

}
