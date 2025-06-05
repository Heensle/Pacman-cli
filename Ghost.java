public class Ghost extends Entity {
    private int mode; //0-scatter, 1-chase, 2-frightened, 3-eaten
    private int tar_xpos;
    private int tar_ypos;
    
    public void update_tar_chase(){ }
    
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
        set_tar_xpos(pellet_eater.get_xpos());
        set_tar_ypos(pellet_eater.get_ypos());
    }
}

class Pinky extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater){
        set_tar_xpos(pellet_eater.get_xpos());
        set_tar_ypos(pellet_eater.get_ypos());
        if(pellet_eater.get_dir() == 00){
            set_tar_xpos(get_tar_xpos() + 4);
        } else if (pellet_eater.get_dir() == 01){
            set_tar_xpos(get_tar_xpos() - 4);
        } else if (pellet_eater.get_dir() == 10){
            set_tar_ypos(get_tar_xpos() + 4);
        } else if (pellet_eater.get_dir() == 11){
            set_tar_ypos(get_tar_xpos() - 4);
        }
    }
}

class Inky extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater){
        
    }
}

class Clyde extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater){
        if(Math.pow((pellet_eater.get_xpos() - get_xpos()), 2) 
            + Math.pow((pellet_eater.get_ypos() - get_ypos()), 2) >= 8){
            set_tar_xpos(pellet_eater.get_xpos());
            set_tar_ypos(pellet_eater.get_ypos());
        } else {
            set_tar_xpos(0); 
            set_tar_ypos(0);
        }
    }
}
