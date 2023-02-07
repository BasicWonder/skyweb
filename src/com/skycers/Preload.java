package com.skycers;

import javafx.scene.control.*;
import javafx.scene.web.*;
import javafx.scene.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.event.*;
import java.util.*;
import javafx.concurrent.Task;
import java.util.concurrent.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Preload{
    private ProgressBar p2;
    private TabManager manager;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public Preload(TabManager mang){
    p2 = new ProgressBar(0);

    manager = mang;
    
    p2.toFront();

    }
    public ProgressBar get(){
        p2.progressProperty().bind(manager.selected().getEngine().getLoadWorker().progressProperty());

        return p2;
    }
    
}

