import java.util.ArrayList;

public class Pacman extends Entity {
    int pellets_eaten;
    int score;
    
    public Pacman(){
        super(27, 23, 10, '⬤', "\u001b[0m\u001b[33;1m");
        score = 0;
    }
    
    public void move(ArrayList<Ghost> ghosts, Board board, String move_dir){
        int prevxpos = get_xpos();
        int prevypos = get_ypos();
        Graphics.move_cursor_print(get_xpos(), get_ypos(), "\u001b[0m "); //erase pacman on screen

        if(move_dir.contains("up")){
            set_ypos(get_ypos() - 1);
        }
        if(move_dir.contains("down")){
            set_ypos(get_ypos() + 1);
        }
        if(move_dir.contains("left")){
            set_xpos(get_xpos() - 1);
        }
        if(move_dir.contains("right")){
            set_xpos(get_xpos() + 1);
        }
        
        if(get_xpos() > 53){
            set_xpos(0);
        } else if(get_xpos() < 0){
            set_xpos(53);
        }
        
        if(eat_dot(board)){ // if powerpellet eaten, frighten ghosts
            Ghost.frighten_all(ghosts);
        }
        
        board.edit_board(get_xpos(), get_ypos(), get_appearance()); // add pacman on board
        board.edit_board(prevxpos, prevypos, ' '); // erase pacman in board
        Graphics.move_cursor_print(this); // add pacman on screen
    }
    
    public boolean eat_dot(Board board){
        //returns true if power pellet
        
        boolean isPowerPellet = false;
        if(board.board_at(get_xpos(), get_ypos()) == '◍'){
            isPowerPellet = true;
            pellets_eaten++;
            score += 50;
        } else if (board.board_at(get_xpos(), get_ypos()) == '●'){
            pellets_eaten++;
            score += 10;
        }
        
        board.edit_board(get_xpos(), get_ypos(), ' ');
        
        return isPowerPellet;
    }
    
    public boolean eat_ghost(ArrayList<Ghost> ghosts){
        for(Ghost ghost : ghosts){
            if(ghost.get_mode() == 2 && ghost.get_xpos() == this.get_xpos() && ghost.get_ypos() == this.get_ypos()){
                ghost.set_mode(3);
                return true;
            }
        }
        return false;
    }
    
    public boolean has_won(){
        if(pellets_eaten == 244){
            System.out.println("\u001b[0m\033[32;1HYOU WIN!");
            return true;
        }
        return false;
    }
    
    public boolean has_lost(ArrayList<Ghost> ghosts){
        boolean has_lost = false;
        for(Ghost gh : ghosts){
            if(get_xpos() == gh.get_xpos() && get_ypos() == gh.get_ypos() && gh.get_mode() != 2 && gh.get_mode() != 3){
                System.out.println("\u001b[0m\033[32;1HYOU LOSE!");
                has_lost = true;
            }
        }
        return has_lost;
    }
    
    public void add_score(int increase){
        score += increase;
    }
    
    public int get_score(){
        return score;
    }
}
