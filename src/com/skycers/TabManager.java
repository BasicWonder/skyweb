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
    
         selected.getEngine().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");
         tabs.getSelectionModel().getSelectedItem().textProperty().bind(selected.getEngine().titleProperty());
         
         
         selected.getEngine().load(url);
         
        MediaAbilities ability = new MediaAbilities(selected.getEngine());
        

     }
     public TabPane asNode(){
         return tabs;
     }
     public void open(){
         WebView viewer = new WebView();
         viewer.getEngine().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");
         
         viewer.getEngine().load(defaultUrl);
         
         Tab tab = new Tab("New Tab", viewer);
        tab.textProperty().bind(viewer.getEngine().titleProperty());
         MediaAbilities ability = new MediaAbilities(viewer.getEngine());
         
            tabs.getTabs().add(tab);        
     }
     public void open(String url){
         WebView viewer = new WebView();
         
         
         viewer.getEngine().setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");
         viewer.getEngine().load(url);
         
         MediaAbilities ability = new MediaAbilities(viewer.getEngine());
         
         Tab tab = new Tab("New Tab", viewer);
        tab.textProperty().bind(viewer.getEngine().titleProperty()); 
         
            tabs.getTabs().add(tab);
     }
     public WebView selected(){
         WebView sel = (WebView) tabs.getSelectionModel().getSelectedItem().getContent();

         
         
        MediaAbilities ability = new MediaAbilities(sel.getEngine());
         return sel;
     }
     public void undo(){
        WebView sel = (WebView) tabs.getSelectionModel().getSelectedItem().getContent();

                    sel.getEngine().executeScript("history.back()");
     }
     public void redo(){
        WebView sel = (WebView) tabs.getSelectionModel().getSelectedItem().getContent();

                    sel.getEngine().executeScript("history.forward()");
     }
     public void refresh(){
        WebView sel = (WebView) tabs.getSelectionModel().getSelectedItem().getContent();

                    sel.getEngine().reload();
     }
     public void reload(){
        this.refresh();
     }
}
