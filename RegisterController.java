package com.example.probe;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Label menu_back_registration;

    @FXML
    private Label menu_registration;

    @FXML
    private AnchorPane slider_registration;

    @FXML
    void homePage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void loginPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
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

        slider_registration.setTranslateX(-176);
        menu_registration.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider_registration);

            slide.setToX(0);
            slide.play();

            slider_registration.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e) -> {
                menu_registration.setVisible(false);
                menu_back_registration.setVisible(true);
            });
        });

        menu_back_registration.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider_registration);

            slide.setToX(-176);
            slide.play();

            slider_registration.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                menu_registration.setVisible(true);
                menu_back_registration.setVisible(false);
            });
        });

    }
}
