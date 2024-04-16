package com.example.csit228_f1_v2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class HelloController {
    public GridPane pnLogin;
    public AnchorPane pnMain;
    public VBox pnHome;
    @FXML
    private Label welcomeText;
    public TextField login_inputUsername;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onSigninClick() throws IOException {
        Parent homeview = FXMLLoader.load(HelloApplication.class
                .getResource("home-view.fxml"));
        AnchorPane p = (AnchorPane) pnLogin.getParent();
        p.getChildren().remove(pnLogin);
        p.getChildren().add(homeview);


    }
    protected void registerUser() {
        try (Connection c = MySQLConnection.getConnection();
             PreparedStatement statement = c.prepareStatement(
                     "INSERT INTO users (name, email, password) VALUES (?,?,?)"
             )) {
            String name = ;
            String email =;
            String password = ;
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            int rowsInserted = statement.executeUpdate();
            System.out.println("User successfully registered");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}