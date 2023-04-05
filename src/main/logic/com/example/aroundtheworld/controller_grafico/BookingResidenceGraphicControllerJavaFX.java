package com.example.aroundtheworld.controller_grafico;

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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class BookingResidenceGraphicControllerJavaFX implements Initializable {

    Scene scene;
    Stage stage, stage2;

    @FXML
    ChoiceBox cityBox = new ChoiceBox();

    @FXML
    Rectangle quote1 = new Rectangle();

    @FXML
    Label quote2 = new Label();

    @FXML
    ObservableList cityList = FXCollections.observableArrayList("London","Rome","Paris","New York","Valencia");

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){
        quote1.setVisible(false);
        quote2.setVisible(false);
        cityBox.setItems(cityList);
    }


    public void toQuote(ActionEvent event) throws IOException {
        quote1.setVisible(true);
        quote2.setVisible(true);
    }

    public void toModifyPreferences(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("residenceForm.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void backButton(ActionEvent event) throws IOException {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

}
