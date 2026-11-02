/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.lab10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
/**
 * FXML Controller class
 *
 * @author 2539556
 */
public class MainViewController implements Initializable {


    @FXML
    private BorderPane mainPane;
    @FXML
    private MenuItem newItem;
    @FXML
    private MenuItem openItem;
    @FXML
    private MenuItem closeItem;
    @FXML
    private MenuItem saveItem;
    @FXML
    private CheckMenuItem gridItem;
    @FXML
    private MenuItem copyItem;
    @FXML
    private Menu searchMenu;
    @FXML
    private MenuItem findItem;
    @FXML
    private MenuItem replaceItem;
    @FXML
    private RadioMenuItem smallItem;
    @FXML
    private RadioMenuItem mediumItem;
    @FXML
    private RadioMenuItem largeItem;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //ToggleGroup setup
        ToggleGroup tg = new ToggleGroup();
        smallItem.setToggleGroup(tg);
        mediumItem.setToggleGroup(tg);
        largeItem.setToggleGroup(tg);
        smallItem.setSelected(true);
        
        //Initial menu setup
        closeItem.setDisable(true);
        saveItem.setDisable(true);
        copyItem.setDisable(true);
        searchMenu.setDisable(true);
        
        //Set shortcuts for some options
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        openItem.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        closeItem.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
        saveItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        gridItem.setAccelerator(KeyCombination.keyCombination("Ctrl+G"));
        copyItem.setAccelerator(KeyCombination.keyCombination("Ctrl+C"));
        findItem.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
        replaceItem.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
        
        //Popup menu
        ContextMenu popup = new ContextMenu();
        MenuItem help = new MenuItem("Help");
        MenuItem inspect = new MenuItem("Inspect");
        popup.getItems().addAll(help, inspect);
        
        //
        help.setOnAction(event -> {System.out.println("HELP has been pressed");});
        inspect.setOnAction(event -> {System.out.println("INSPECT has been pressed");});
        
        //For popup menu to showup
        mainPane.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.SECONDARY){
                popup.show(mainPane, event.getScreenX() - 50, event.getScreenY() - 25);
            }
        });
    }    
    
    @FXML
    private void handleNew() {
        System.out.println("NEW has been pressed");
        closeItem.setDisable(false);
        newItem.setDisable(true);
        openItem.setDisable(true);
        saveItem.setDisable(false);
        searchMenu.setDisable(false);
        copyItem.setDisable(false);
    }

    @FXML
    private void handleOpen() {
        System.out.println("OPEN has been pressed");
        closeItem.setDisable(false);
        newItem.setDisable(true);
        openItem.setDisable(true);
        saveItem.setDisable(false);
        searchMenu.setDisable(false);
        copyItem.setDisable(false);
    }

    @FXML
    private void handleClose() {
        System.out.println("CLOSE has been pressed");
        closeItem.setDisable(true);
        newItem.setDisable(false);
        openItem.setDisable(false);
        saveItem.setDisable(true);
        searchMenu.setDisable(true);
        copyItem.setDisable(true);
    }

    @FXML
    private void handleSaveAs() {
        System.out.println("SAVE AS... has been pressed");
    }

    @FXML
    private void handleGrid() {
        if(gridItem.isSelected()){
            System.out.println("USE GRIDLINES selected");
        }else{
            System.out.println("USE GRIDLINES unselected");
        }
    }

    @FXML
    private void handleCopy() {
        System.out.println("COPY has been pressed");
    }

    @FXML
    private void handleFind() {
        System.out.println("FIND has been pressed");
    }

    @FXML
    private void handleReplace() {
        System.out.println("REPLACE has been pressed");
    }

    @FXML
    private void handleSizeSmall() {
        System.out.println("SMALL has been selected");
    }

    @FXML
    private void handleSizeMedium() {
        System.out.println("MEDIUM has been selected");
    }

    @FXML
    private void handleSizeLarge() {
        System.out.println("LARGE has been selected");
    }

}
