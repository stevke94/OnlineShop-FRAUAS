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

public class LaptopsController implements Initializable {

    ObservableList<String> filter_name_laptops = FXCollections.observableArrayList("Apple","ASUS","HP","Lenovo");
    ObservableList<String> filter_display_size = FXCollections.observableArrayList("10.1", "12.2", "13", "14,2");

    private Stage stage;
    private Scene scene;
    @FXML
    private Label menu_back_laptop;

    @FXML
    private Label menu_laptop;

    @FXML
    private AnchorPane slider_laptop;

    @FXML
    private ChoiceBox<String> brand_choice;

    @FXML
    private ChoiceBox<String> display_size_choice;

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
    void registerPage(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        brand_choice.setItems(filter_name_laptops);
        display_size_choice.setItems(filter_display_size);

        slider_laptop.setTranslateX(-176);
        menu_laptop.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider_laptop);

            slide.setToX(0);
            slide.play();

            slider_laptop.setTranslateX(-176);

            slide.setOnFinished((ActionEvent e) -> {
                menu_laptop.setVisible(false);
                menu_back_laptop.setVisible(true);
            });
        });

        menu_back_laptop.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider_laptop);

            slide.setToX(-176);
            slide.play();

            slider_laptop.setTranslateX(0);

            slide.setOnFinished((ActionEvent e) -> {
                menu_laptop.setVisible(true);
                menu_back_laptop.setVisible(false);
            });
        });

    }
}
