package com.example.probe;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    private Label menu_back_login;

    @FXML
    private Label menu_login;

    @FXML
    private AnchorPane slider_login;

    @FXML
    void homePage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void registerPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void monitorsPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("monitors.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void laptopsPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("laptops.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        slider_login.setTranslateX(-176);
        menu_login.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider_login);

            slide.setToX(0);
            slide.play();

            slider_login.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e) -> {
                menu_login.setVisible(false);
                menu_back_login.setVisible(true);
            });
        });

        menu_back_login.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider_login);

            slide.setToX(-176);
            slide.play();

            slider_login.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                menu_login.setVisible(true);
                menu_back_login.setVisible(false);
            });
        });

    }
}
