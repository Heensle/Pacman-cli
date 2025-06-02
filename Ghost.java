public class Ghost extends Entity {
    private int mode; //0-scatter, 1-chase, 2-frightened, 3-eaten
    private tar_xpos;
    private tar_ypos;
    
    public void update_tar_chase(){ }
}

class Blinky extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater){
        tar_xpos = pellet_eater.get_xpos();
        tar_ypos = pellet_eater.get_ypos();
    }
}

class Pinky extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater){
        tar_xpos = pellet_eater.get_xpos();
        tar_ypos = pellet_eater.get_ypos();
        if(pellet_eater.get_dir() == 00){
            tar_xpos += 4;
        } else if (pellet_eater.get_dir() == 01){
            tar_xpos -= 4;
        } else if (pellet_eater.get_dir() == 10){
            tar_ypos += 4;
        } else if (pellet_eater.get_dir() == 11){
            tar_ypos -= 4;
        }
    }
}

class Inky extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater){
        
    }
}

class Clyde extends Ghost{
    
    public void update_tar_chase(Pacman pellet_eater){
        if(Math.pow((pellet_eater.get_xpos() - xpos), 2) 
            + Math.pow((pellet_eater.get_ypos() - ypos), 2) >= 8){
            tar_xpos = pellet_eater.get_xpos();
            tar_ypos = pellet_eater.get_ypos();
        } else {
            tar_xpos = 0; 
            tar_ypos = 0;
        }
    }
}
