package com.skycers;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.input.KeyCombination.*;
import javafx.event.*;
import javafx.stage.*;
import java.io.*;

public class MenuInt{
    public MenuBar bar = new MenuBar();
    
    public MenuInt(TabManager manager,Stage stage){
        // File
        Menu file = new Menu("File");
        

            // New Page
            MenuItem newPage = new MenuItem("New Page");
            newPage.setAccelerator(KeyCombination.keyCombination("Shortcut+T"));
            newPage.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    manager.open();
                }
            });
            // New Page
            MenuItem openFile = new MenuItem("Open File");
            openFile.setAccelerator(KeyCombination.keyCombination("Shortcut+O"));
            openFile.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                     FileChooser fileChooser = new FileChooser();
                     fileChooser.setTitle("Open Local File");
                     File selectedFile = fileChooser.showOpenDialog(stage);
                     if (selectedFile != null) {
                         
                     }
                }
            });
        
        
        file.getItems().addAll(newPage,openFile);
        
        
        // Edit
        Menu edit = new Menu("Edit");
        Menu view = new Menu("View");
        Menu history = new Menu("History");
        Menu bookmarks = new Menu("Bookmarks");
        
        bar.getMenus().addAll(file,edit,view,history,bookmarks);
    }
}
