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


public class Window extends Application{
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public void start(Stage stage) {
        TabManager manager = new TabManager("https://www.google.com");
        
        Package config = new Package();
        
        Preload preloader = new Preload(manager);
        MenuInt menus = new MenuInt(manager,stage);
        HBox menu = new HBox();
        menu.getChildren().add(menus.bar);
        menu.getChildren().add(preloader.get());
        
        TextField textBar = new AddressBar(manager);
        
        VBox box = new VBox();
        box.getChildren().add(menu);
        box.getChildren().add(textBar);
        box.getChildren().add(manager.asNode());
        
        
        Group root = new Group(box);
        
        Scene scene = new Scene(root, screenSize.getWidth()/1.5, screenSize.getHeight()/1.75);

        box.prefWidthProperty().bind(scene.widthProperty());
        box.prefHeightProperty().bind(scene.heightProperty());
        
        stage.setTitle(config.TITLE);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
}
