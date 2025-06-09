public class Pacman extends Entity {
    int pellets_eaten;
    
    public Pacman(){
        set_dir(10);
        set_xpos(27);
        set_ypos(23);
    }
    
    public boolean eat_dot(Board board){
        //returns true if power pellet
        
        boolean isPowerPellet = false;
        if(board.board_at(get_xpos(), get_ypos()) == '◍'){
            isPowerPellet = true;
            pellets_eaten++;
        } else if (board.board_at(get_xpos(), get_ypos()) == '●'){
            pellets_eaten++;
        }
        
        board.edit_board(get_xpos(), get_ypos(), ' ');
        
        return isPowerPellet;
    }
    
    public boolean win(){
        if(pellets_eaten == 244){
            System.out.println("\033[32;1HYOU WIN!");
            return true;
        }
        return false;
    }
}
