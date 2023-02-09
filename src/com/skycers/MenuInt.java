package com.skycers;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.web.*;
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
                         System.out.println("Internal File: "  + selectedFile.getPath());
                         
                         manager.open(selectedFile.getPath());
                     }
                }
            });
            // Save Page
            MenuItem saveFile = new MenuItem("Save File");
            saveFile.setAccelerator(KeyCombination.keyCombination("Shortcut+S"));
            saveFile.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    WebView selected = manager.selected();
                     
                    try (BufferedReader reader = new BufferedReader(new FileReader(new File(selected.getEngine().getLocation())))) {
                        String line;
                        while ((line = reader.readLine()) != null)
                            System.out.println(line);
                        
                    }
                    catch(IOException exc){
                        exc.printStackTrace();
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
