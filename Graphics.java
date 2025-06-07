import java.util.ArrayList;

public class Graphics {
    int score;
    int lives;
    ArrayList<Character> fruits;
    
    public Graphics(){
        score = 0;
        lives = 2;
        ArrayList<Character> fruits = new ArrayList<Character>();
    }
    
    public void set_score(int score){
        this.score = score;
    }
    
    public void set_lives(int lives){
        this.lives = lives;
    }
    
    public void add_fruit(char fruit){
        fruits.add(fruit);
    }
    
    public int get_score(){
        return score;
    }
    
    public int get_lives(){
        return lives;
    }
    
    public char get_fruit(int index){
        return fruits.get(index);
    }
}
