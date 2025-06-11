import java.util.ArrayList;
import static java.lang.Math.*;

public class Ghost extends Entity {
    private int mode; //0-scatter, 1-chase, 2-frightened, 3-eaten, -1 pregame
    private OrderedPair tar;
    
    public Ghost(int xpos, int ypos, int dir, String color){
        super(xpos, ypos, dir, 'ᗣ', color);
        mode = -1;
        tar = new OrderedPair(0, 0);
    }
    
    public void update_tar_chase(){ }
    
    public void update_tar_scatter(){ }
    
    public void face_tar(Board board){
        double[] aval_moves = {0.0, 0.0, 0.0, 0.0}; //right, down, left, up
        if(get_dir() == 10){ // cannot turn around
            aval_moves[1] = 1000.0;
        } else if (get_dir() == 11){
            aval_moves[3] = 1000.0;
        } else if (get_dir() == 01){
            aval_moves[0] = 1000.0;
        } else if (get_dir() == 00){
            aval_moves[2] = 1000.0;
        }
        
        //cant move anywhere illegal
        if(board.can_move_ghost_ed(this.get_xpos(), this.get_ypos(), 00, this.get_mode()).equals("no")){
            aval_moves[0] = 1000.0;
        }
        if(board.can_move_ghost_ed(this.get_xpos(), this.get_ypos(), 11, this.get_mode()).equals("no")){
            aval_moves[1] = 1000.0;
        }
        if(board.can_move_ghost_ed(this.get_xpos(), this.get_ypos(), 01, this.get_mode()).equals("no")){
            aval_moves[2] = 1000.0;
        }
        if(board.can_move_ghost_ed(this.get_xpos(), this.get_ypos(), 10, this.get_mode()).equals("no")){
            aval_moves[3] = 1000.0;
        }
        
        //asigns distance to avaliable moves
        if(aval_moves[0] != 1000.0){
            aval_moves[0] = OrderedPair.distance(this.get_xpos() + 1, this.get_ypos(), tar.get_xpos(), tar.get_ypos());
        } 
        if (aval_moves[1] != 1000.0){
            aval_moves[1] = OrderedPair.distance(this.get_xpos(), this.get_ypos() + 1, tar.get_xpos(), tar.get_ypos());
        } 
        if (aval_moves[2] != 1000.0){
            aval_moves[2] = OrderedPair.distance(this.get_xpos() - 1, this.get_ypos(), tar.get_xpos(), tar.get_ypos());
        } 
        if (aval_moves[3] != 1000.0){
            aval_moves[3] = OrderedPair.distance(this.get_xpos(), this.get_ypos() - 1, tar.get_xpos(), tar.get_ypos());
        }
        
        double min = 1000.0; //finds move that puts ghost closest to target
        int min_index = -1;
        
        for(int i = 0; i < 4; i++){
            if(aval_moves[i] < min){
                min = aval_moves[i];
                min_index = i;
            }
        }
        
        if(min_index == 0){
            set_dir(00);
        } else if (min_index == 1){
            set_dir(11);
        } else if (min_index == 2){
            set_dir(01);
        } else {
            set_dir(10);
        }
    }
    
    public void one_eighty(){
        if(get_dir() == 10){
            set_dir(11);
        } else if (get_dir() == 11){
            set_dir(10);
        } else if (get_dir() == 01){
            set_dir(00);
        } else {
            set_dir(01);
        }
    }
    
    public static void frighten_all(ArrayList<Ghost> ghosts){
        for(Ghost gh : ghosts){
            gh.set_mode(2);
            gh.one_eighty();
        }
        Timing.set_frightened_start();
    }
    
    public void fix_overflow(){ //keeps target from leaving map
        if(tar.get_xpos() > 54){
            tar.set_xpos(54);
        }
        if(tar.get_xpos() < 0){
            tar.set_xpos(0);
        }
        if(tar.get_ypos() > 30){
            tar.set_ypos(30);
        }
        if(tar.get_ypos() < 0){
            tar.set_ypos(0);
        }
    }
    
    public void set_mode(int mode){
        if(mode == 3){ // if eaten
            super.set_appearance('∞');
            set_tar_xpos(27);
            set_tar_ypos(13);
        } else {
            set_appearance('ᗣ');
        }
        this.mode = mode;
    }
    
    public void set_tar_xpos(int tar_xpos){
        tar.set_xpos(tar_xpos);
    }
    
    public void set_tar_ypos(int tar_ypos){
        tar.set_ypos(tar_ypos);
    }
    
    public int get_mode(){
        return mode;
    }
    
    public int get_tar_xpos(){
        return tar.get_xpos();
    }
    
    public int get_tar_ypos(){
        return tar.get_ypos();
    }
    
    public OrderedPair get_tar(){
        return tar;
    }
}

class Blinky extends Ghost{
    
    public Blinky(){
        super(27, 11, 10, "\u001b[31m");
    }
    
    public void update_tar_chase(Pacman pacman){
        //sets target to pacman
        set_tar_xpos(pacman.get_xpos());
        set_tar_ypos(pacman.get_ypos());
    }
    
    public void update_tar_scatter(){
        //sets target to top right
        set_tar_xpos(54);
        set_tar_ypos(0);
    }
    
    public void set_mode(int mode){
        if(mode == 2){
            set_color("\u001b[33m\u001b[44m");
        } else {
            set_color("\u001b[0m\u001b[31m");
        }
        super.set_mode(mode);
    }
}

class Pinky extends Ghost{
    
    public Pinky(){
        super(27, 11, 10, "\u001b[38;5;200m");
    }
    
    public void update_tar_chase(Pacman pacman){
        //sets target to 4 in front of pacman
        set_tar_xpos(pacman.get_xpos());
        set_tar_ypos(pacman.get_ypos());
        if(pacman.get_dir() == 00){
            set_tar_xpos(get_tar_xpos() + 4);
        } else if (pacman.get_dir() == 01){
            set_tar_xpos(get_tar_xpos() - 4);
        } else if (pacman.get_dir() == 10){
            set_tar_ypos(get_tar_ypos() - 4);
        } else if (pacman.get_dir() == 11){
            set_tar_ypos(get_tar_ypos() + 4);
        }
        
        fix_overflow();
    }
    
    public void update_tar_scatter(){
        //sets target to top left
        set_tar_xpos(0);
        set_tar_ypos(0);
    }
    
    public void set_mode(int mode){
        if(mode == 2){
            set_color("\u001b[33m\u001b[44m");
        } else {
            set_color("\u001b[0m\u001b[38;5;200m");
        }
        super.set_mode(mode);
    }
}

class Inky extends Ghost{
    
    public Inky(){
        super(27, 11, 10, "\u001b[36m");
    }
    
    public void update_tar_chase(Pacman pacman, Blinky blinky){
        //sets target to end of 180degree rotation of vector btwn pacman & blinky
        int PMxpos = pacman.get_xpos();
        int PMypos = pacman.get_ypos();
        int Bxpos = blinky.get_xpos();
        int Bypos = blinky.get_ypos();
        
        set_tar_xpos(PMxpos + (PMxpos - Bxpos));
        set_tar_ypos(PMypos + (PMypos - Bypos));
        
        fix_overflow();
    }
    
    public void update_tar_scatter()//sets target to bottom right
        set_tar_xpos(54);
        set_tar_ypos(30);
    }
    
    public void set_mode(int mode){
        if(mode == 2){
            set_color("\u001b[33m\u001b[44m");
        } else {
            set_color("\u001b[0m\u001b[36m");
        }
        super.set_mode(mode);
    }
}

class Clyde extends Ghost{
    
    public Clyde(){
        super(27, 11, 10, "\u001b[38;5;208m");
    }
    
    public void update_tar_chase(Pacman pacman){
        //sets target to pacman when outside of 16un, otherwise sets to bottom left corner
        if(OrderPair.distance(get_xpos(), get_ypos(), pacman.get_xpos(), pacman.get_ypos()) >= 16){
            set_tar_xpos(pacman.get_xpos());
            set_tar_ypos(pacman.get_ypos());
        } else {
            set_tar_xpos(0); 
            set_tar_ypos(30);
        }
    }
    
    public void update_tar_scatter(){
        //sets target to bottom left
        set_tar_xpos(0); 
        set_tar_ypos(30);
    }
    
    public void set_mode(int mode){
        if(mode == 2){
            set_color("\u001b[33m\u001b[44m");
        } else {
            set_color("\u001b[0m\u001b[38;5;208m");
        }
        super.set_mode(mode);
    }
}
