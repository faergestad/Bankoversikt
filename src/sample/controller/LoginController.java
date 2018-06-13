package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Constants;
import sample.model.Kunde;


public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label loggInnBeskjed;

    @FXML
    private TextField brukernavn;

    @FXML
    private Button loggInnBtn;

    @FXML
    private TextField passord;

    @FXML
    void loggInn(ActionEvent e) throws IOException {

        String kundeID = getBrukernavn().getText();
        String passord = getPassord().getText();

        String sql = "SELECT * FROM kunde WHERE kundeID = " + kundeID + " AND passord = " + "'" + passord + "'";

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/layouts/Hjem.fxml")));
        Scene hjem = new Scene(root);

        // Dette henter informasjon om stagen
        Stage vindu = (Stage) ((Node) e.getSource()).getScene().getWindow();

        try {
            Connection con = DriverManager.getConnection(
                    Constants.URL, Constants.UNAME, Constants.PWD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {

                if (rs.getString(1).equals(kundeID) && rs.getString(3).equals(passord)) {
                    System.out.println("logg inn");
                    // Logger inn brukeren og bytter scene
                    vindu.setScene(hjem);
                    vindu.show();
                }
            } else {
                System.out.println("feil innlogging");
            }
            con.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }


    @FXML
    void initialize() {
        assert brukernavn != null : "fx:id=\"brukernavn\" was not injected: check your FXML file 'Login.fxml'.";
        assert loggInnBtn != null : "fx:id=\"loggInnBtn\" was not injected: check your FXML file 'Login.fxml'.";
        assert passord != null : "fx:id=\"passord\" was not injected: check your FXML file 'Login.fxml'.";


    }

    private TextField getBrukernavn() {
        return brukernavn;
    }

    private TextField getPassord() {
        return passord;
    }

}