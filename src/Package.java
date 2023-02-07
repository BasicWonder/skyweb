import java.util.*;

public class Package{
    public String TITLE = "Skyweb Beta Client";
    public String VERSION = "beta-candidate-0.1";
    public String TYPE = "exp";
    public String UPDATED = "2023-02-07";
    
    public Package(){
        
        System.out.print(this.TITLE + ": " + this.VERSION + " (" + UPDATED + ")" + " " + TYPE);
    }
    
    
}
