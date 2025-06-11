import static java.lang.Math.*;

public class OrderedPair {
    private int xpos;
    private int ypos;
    
    public OrderedPair(int xpos, int ypos){
        this.xpos = xpos;
        this.ypos = ypos;
    }
    
    public void set_xpos(int xpos){
        this.xpos = xpos;
    }
    
    public void set_ypos(int ypos){
        this.ypos = ypos;
    }
    
    public int get_xpos(){
        return xpos;
    }
    
    public int get_ypos(){
        return ypos;
    }
    
    public double distance(OrderedPair destination){
        return Math.sqrt(Math.pow(destination.get_xpos() - this.xpos, 2) 
            + Math.pow(destination.get_ypos() - this.ypos, 2));
    }
    
    public static double distance(int initxpos, int initypos, int finalxpos, int finalypos){
        return Math.sqrt(Math.pow(finalxpos - initxpos, 2) 
            + Math.pow(finalypos - initypos, 2));
    }
}

class Vector extends OrderedPair{
    private OrderedPair coords;
    private int dir;//10-up, 11-down, 00-right, 01-left
    
    public Vector(int xpos, int ypos, int dir){
        super(xpos, ypos);
        this.dir = dir;
    }
    
    public void set_dir(int dir){
        this.dir = dir;
    }
    
    public int get_dir(){
        return dir;
    }
}
