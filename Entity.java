public class Entity {
    private int xpos;
    private int ypos;
    private int dir; //10-up, 11-down, 00-right, 01-left
    
    public void set_xpos(int xpos){
        this.xpos = xpos;
    }
    public void set_ypos(int ypos){
        this.ypos = ypos;
    }
    public void set_dir(int dir){
        this.dir = dir;
    }
    public int get_xpos(){
        return this.xpos;
    }
    public int get_ypos(){
        return this.ypos;
    }
    public int get_dir(){
        return dir;
    }
}
