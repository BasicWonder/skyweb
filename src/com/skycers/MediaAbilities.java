package com.skycers;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.web.*;
import javafx.scene.shape.*;
import javafx.stage.*;
import com.skycers.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import org.w3c.dom.*;
import org.jsoup.*;

public class MediaAbilities{
    public MediaAbilities(WebEngine webEngine){
     Document doc = webEngine.getDocument();
     
     System.out.println(doc);
     
     try{
     NodeList videos = doc.getElementsByTagName("video");
     System.out.println(videos);
        }
        catch(Exception err){
            
     System.out.println("Error");
        }
     
    }
}
