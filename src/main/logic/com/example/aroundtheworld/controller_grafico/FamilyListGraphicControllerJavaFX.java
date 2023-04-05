package com.example.aroundtheworld.controller_grafico;

import com.example.aroundtheworld.model.Family;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class FamilyListGraphicControllerJavaFX implements Initializable {
    Stage stage;
    Scene scene;
    @FXML
    private GridPane familyGrid;

    @FXML
    private ScrollPane familyScroll;

    private List<Family> families = new ArrayList<>();

    private List<Family> getData(){
        List<Family> families = new ArrayList<>();
        Family family;

        for (int i=0; i<20; i++){
            family = new Family(1, 2,null,null,null, null, null, null, null, null, null, null, null);
            families.add(family);
        }
        return families;
    }

    public void backToForm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("contactFamilyForm.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root,918,560));
        stage.centerOnScreen();
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        families.addAll(getData());
        int column = 0;
        int row = 1;

        try {

            for (int i = 0; i < families.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("familyItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                FamilyItemGraphicControllerJavaFX familyItemController = fxmlLoader.getController();
                familyItemController.setData(families.get(i));

                if (column == 3){
                    column = 0;
                    row++;
                }

                familyGrid.add(anchorPane,column++,row);

                familyGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                familyGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                familyGrid.setMaxWidth(Region.USE_PREF_SIZE);

                familyGrid.setMinHeight(Region.USE_COMPUTED_SIZE);
                familyGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                familyGrid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane,new Insets(10));

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
