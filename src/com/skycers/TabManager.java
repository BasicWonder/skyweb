package com.skycers;
import javafx.scene.control.*;
import javafx.scene.web.*;
import javafx.stage.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class TabManager{
    private TabPane tabs = new TabPane();
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private String defaultUrl = "https://google.com";
        
     public TabManager(String defaultUrlD){
         defaultUrl = defaultUrlD;
         this.open(defaultUrl);
     }
     public void set(String url){
         WebView selected = (WebView) tabs.getSelectionModel().getSelectedItem().getContent();
    
         tabs.getSelectionModel().getSelectedItem().textProperty().bind(selected.getEngine().titleProperty());
         
         selected.getEngine().load(url);
     }
     public TabPane asNode(){
         return tabs;
     }
     public void open(){
         WebView viewer = new WebView();
         
         viewer.getEngine().load(defaultUrl);
         
         Tab tab = new Tab("New Tab", viewer);
        tab.textProperty().bind(viewer.getEngine().titleProperty());
         
            tabs.getTabs().add(tab);
     }
     public void open(String url){
         WebView viewer = new WebView();
         
         viewer.getEngine().load(url);
         
         Tab tab = new Tab("New Tab", viewer);
        tab.textProperty().bind(viewer.getEngine().titleProperty());
         
            tabs.getTabs().add(tab);
     }
     public WebView selected(){
         WebView sel = (WebView) tabs.getSelectionModel().getSelectedItem().getContent();

         return sel;
     }
}
