public class Ghost extends Entity {
    private int mode; //0-scatter, 1-chase, 2-frightened, 3-eaten
    private int tar_xpos;
    private int tar_ypos;
    
    public void update_tar_chase(){ }
    
    public void update_tar_scatter(){ }
    
    public void set_mode(int mode){
        this.mode = mode;
    }
    
    public void set_tar_xpos(int tar_xpos){
        this.tar_xpos = tar_xpos;
    }
    
    public void set_tar_ypos(int tar_ypos){
        this.tar_ypos = tar_ypos;
    }
    
    public int get_mode(){
        return mode;
    }
    
    public int get_tar_xpos(){
        return tar_xpos;
    }
    
    public int get_tar_ypos(){
        return tar_ypos;
    }
}

class Blinky extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater){
        //sets target to pacman
        set_tar_xpos(pellet_eater.get_xpos());
        set_tar_ypos(pellet_eater.get_ypos());
    }
    
    public void update_tar_scatter(){
        //sets target to top right
        set_tar_xpos(54);
        set_tar_ypos(0);
    }
}

class Pinky extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater){
        //sets target to 2 in front of pacman
        set_tar_xpos(pellet_eater.get_xpos());
        set_tar_ypos(pellet_eater.get_ypos());
        if(pellet_eater.get_dir() == 00){
            set_tar_xpos(get_tar_xpos() + 4);
        } else if (pellet_eater.get_dir() == 01){
            set_tar_xpos(get_tar_xpos() - 4);
        } else if (pellet_eater.get_dir() == 10){
            set_tar_ypos(get_tar_ypos() - 4);
        } else if (pellet_eater.get_dir() == 11){
            set_tar_ypos(get_tar_ypos() + 4);
        }
    }
    
    public void update_tar_scatter(){
        //sets target to top left
        set_tar_xpos(0);
        set_tar_ypos(0);
    }
}

class Inky extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater, Blinky reddie){
        //sets target to end of 180degree rotation of vector btwn pacman & blinky
        int PMxpos = pellet_eater.get_xpos();
        int PMypos = pellet_eater.get_ypos();
        int Bxpos = reddie.get_xpos();
        int Bypos = reddie.get_ypos();
        
        set_tar_xpos(PMxpos - (PMxpos - Bxpos));
        set_tar_ypos(PMypos - (PMypos - Bypos));
    }
    
    public void update_tar_scatter(){
        set_tar_xpos(54);
        set_tar_ypos(30);
    }
}

class Clyde extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater){
        //sets target to pacman when outside of 16un, otherwise sets to bottom left corner
        if(Math.pow((pellet_eater.get_xpos() - get_xpos()), 2) 
            + Math.pow((pellet_eater.get_ypos() - get_ypos()), 2) >= 16){
            set_tar_xpos(pellet_eater.get_xpos());
            set_tar_ypos(pellet_eater.get_ypos());
        } else {
            set_tar_xpos(0); 
            set_tar_ypos(30);
        }
    }
    
    public void update_tar_scatter(){
        set_tar_xpos(0); 
        set_tar_ypos(30);
    }
}
