package com.skycers;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.input.*;

public class AddressBar extends TextField{
    public AddressBar(TabManager manager){
        
         
        TextField self = this;
        
        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)) {
                    boolean resultFound = false;
                    String easyUrl = self.getText();
                    for (Sites site : Sites.values()) { 
                        if(!resultFound){
                            boolean tip = site.match(self.getText());
                            System.out.println(tip);
                        if(tip){
                            resultFound = true;
                            easyUrl = site.url();
                        }
                        }
                    }
                    
                    if(( easyUrl.contains(".") || easyUrl.contains("http://") || easyUrl.contains("https://") ) && !resultFound ){
                        easyUrl = "https://google.com/search?q=" + self.getText();
                    }
                    
                     manager.set(easyUrl);
                }
            }
        });
    }
}
