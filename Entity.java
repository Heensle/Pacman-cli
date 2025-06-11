public class Entity {
    private Vector vector; //position & direction facing
    private char appearance;
    private String color;
    
    public Entity(int xpos, int ypos, int dir, char looks, String color){
        vector = new Vector(xpos, ypos, dir);
        appearance = looks;
        this.color = color;
    }
    
    public void update_pos(){
        //advances 1 place in direciton facing
        if(vector.get_dir() == 10){
            vector.set_ypos(vector.get_ypos() - 1);
        } else if (vector.get_dir() == 11){
            vector.set_ypos(vector.get_ypos() + 1);
        } else if (vector.get_dir() == 00){
            vector.set_xpos(vector.get_xpos() + 1);
        } else if (vector.get_dir() == 01){
            vector.set_xpos(vector.get_xpos() - 1);
        }
        
        if(vector.get_xpos() < 0){//allows for wrapping on left
            vector.set_xpos(53);
        }
        if(vector.get_xpos() > 53){//and right sides of map
            vector.set_xpos(0);
        }
    }
    
    public double distance(OrderedPair destination){
        return vector.distance(destination); //calculates distance between two points
    }
    
    public void set_xpos(int xpos){
        vector.set_xpos(xpos);
    }
    public void set_ypos(int ypos){
        vector.set_ypos(ypos);
    }
    public void set_dir(int dir){
        vector.set_dir(dir);
    }
    public void set_vector(int xpos, int ypos, int dir){
        vector.set_xpos(xpos);
        vector.set_ypos(ypos);
        vector.set_dir(dir);
    }
    public void set_appearance(char looks){
        appearance = looks;
    }
    public void set_color(String color){
        this.color = color;
    }
    public int get_xpos(){
        return vector.get_xpos();
    }
    public int get_ypos(){
        return vector.get_ypos();
    }
    public int get_dir(){
        return vector.get_dir();
    }
    
    public Vector get_vector(){
        return vector;
    }
    public char get_appearance(){
        return appearance;
    }
    public String get_color(){
        return color;
    }
}
