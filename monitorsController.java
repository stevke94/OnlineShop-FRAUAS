package com.example.probe;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class monitorsController implements Initializable {

    ObservableList<String> filter_name_monitors = FXCollections.observableArrayList("Apple","ASUS","HP","Lenovo");
    ObservableList<String> filter_display_monitors = FXCollections.observableArrayList("10.1", "12.2", "13", "14,2");

    private Stage stage;
    private Scene scene;
    @FXML
    private Label menu_back_monitors;

    @FXML
    private Label menu_monitors;

    @FXML
    private AnchorPane slider_monitors;

    @FXML
    private ChoiceBox<String> monitors_brand_choice;

    @FXML
    private ChoiceBox<String> monitors_display_choice;

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
    void registerPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
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

        monitors_brand_choice.setItems(filter_name_monitors);
        monitors_display_choice.setItems(filter_display_monitors);

        slider_monitors.setTranslateX(-176);
        menu_monitors.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider_monitors);

            slide.setToX(0);
            slide.play();

            slider_monitors.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e) -> {
                menu_monitors.setVisible(false);
                menu_back_monitors.setVisible(true);
            });
        });

        menu_back_monitors.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider_monitors);

            slide.setToX(-176);
            slide.play();

            slider_monitors.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                menu_monitors.setVisible(true);
                menu_back_monitors.setVisible(false);
            });
        });


    }
}
