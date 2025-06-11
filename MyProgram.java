import static java.lang.Math.*;
import java.util.ArrayList;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import java.io.IOException;

import java.io.InputStream;


public class MyProgram {
    public static void main(String[] args) throws IOException, InterruptedException
    {
        Graphics.init_terminal();
        Graphics.flush();
        
        Board board = new Board();
            
        Graphics.print_board(board);

        Pacman pacman = new Pacman();
        
        ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
        
        Ghost blinky = new Blinky();
        Ghost pinky = new Pinky();
        Ghost inky = new Inky();
        Ghost clyde = new Clyde();
        
        ghosts.add(blinky);
        ghosts.add(pinky);
        ghosts.add(inky);
        ghosts.add(clyde);
        
        Input.init_reader(Graphics.return_term());

        String key = null;
        
        boolean play = true;
        
        boolean ghosts_move = false;
        boolean frightened_move = false;
        
        while(play){
            Timing.set_loop_start();
            key = null;
            
            if(pacman.has_won()){
                play = false;
                break;
            }
            
            while(Timing.time_diff() < 30 && key == null){ // for 30 ms or until input
                if (Input.peek_char(10) > -1) { // check if input is available
                    key = Input.read_binding(); //take input
                }
            }
            
            if(key != null){
                switch(key) {
                    case "quit":
                        play = false;
                        break;
                    case "right":
                        if(!board.can_move(pacman.get_xpos(), pacman.get_ypos(), 00).equals("no")){
                            pacman.set_dir(00);
                        }
                        break;
                    case "left":
                        if(!board.can_move(pacman.get_xpos(), pacman.get_ypos(), 01).equals("no")){
                            pacman.set_dir(01);
                        }
                        break;
                    case "down":
                        if(!board.can_move(pacman.get_xpos(), pacman.get_ypos(), 11).equals("no")){
                            pacman.set_dir(11);
                        }
                        break;
                    case "up":
                        if(!board.can_move(pacman.get_xpos(), pacman.get_ypos(), 10).equals("no")){
                            pacman.set_dir(10);
                        }
                        break;
                }
            }
            
            if(pacman.get_dir() == 11 || pacman.get_dir() == 10){
                //slows up and down movement to make movement equal
                Timing.sleep(50);
            }
            
            String move_dir = board.can_move(pacman.get_xpos(), pacman.get_ypos(), pacman.get_dir());
            if(!move_dir.equals("no")){ //basic pacman movement
                pacman.move(ghosts, board, move_dir);
            } 
            
            if(pacman.eat_ghost(ghosts)){
                pacman.add_score(300);
            }
            
            if(pacman.has_lost(ghosts)){
                play = false;
                break;
            }
            
            Timing.update_phase();
            
            for(Ghost ghost : ghosts){
                if(Timing.get_phase() % 2 == 0){
                    if(((ghost.get_mode() != 2 && ghost.get_mode() != 0 && ghost.get_mode() != 3))
                        || (ghost.get_mode() == 2 && Timing.time_since_frightened() > 6000)
                        || (ghost.get_mode() == 3 && (ghost.get_xpos() == 27 && ghost.get_ypos() > 11 && ghost.get_ypos() < 15))){
                        ghost.one_eighty();
                        ghost.set_mode(0);
                        ghost.update_tar_scatter();
                        ghost.set_appearance('ᗣ');
                    }
                } else {
                    if((ghost.get_mode() != 2 && ghost.get_mode() != 1 && ghost.get_mode() != 3)
                    || (ghost.get_mode() == 2 && Timing.time_since_frightened() > 6000)
                    || (ghost.get_mode() == 3 && (ghost.get_xpos() == 27 && ghost.get_ypos() > 11 && ghost.get_ypos() < 15))){
                        ghost.one_eighty();
                        ghost.set_mode(1);
                        ghost.set_appearance('ᗣ');
                    }
                }
            }
            
            if(Timing.get_phase() % 2 == 1){
                if(blinky.get_mode() != 2 && blinky.get_mode() != 3){
                    ((Blinky) blinky).update_tar_chase(pacman);
                }
                if(pinky.get_mode() != 2 && pinky.get_mode() != 3){
                    ((Pinky) pinky).update_tar_chase(pacman);
                }
                if(inky.get_mode() != 2 && inky.get_mode() != 3){
                    ((Inky) inky).update_tar_chase(pacman, (Blinky) blinky);
                }
                if(clyde.get_mode() != 2 && clyde.get_mode() != 3){
                    ((Clyde) clyde).update_tar_chase(pacman);
                }
            }
            
            
            if(ghosts_move){
                for(Ghost ghost : ghosts){
                    if(ghost.get_mode() != 2){
                        for(int i = 0; i < 2; i++){
                            ghost.face_tar(board);
                            if(board.board_at(ghost.get_xpos(), ghost.get_ypos()) == 'p'){
                                Graphics.move_cursor_print(ghost.get_xpos(), ghost.get_ypos(), 
                                    "\u001b[0m▬");
                            } else {
                                Graphics.move_cursor_print(ghost.get_xpos(), ghost.get_ypos(), 
                                    "\u001b[0m" + board.board_at(ghost.get_xpos(), ghost.get_ypos()));
                            }
                            if(!board.can_move_ghost_ed(ghost.get_xpos(), ghost.get_ypos(), ghost.get_dir(), ghost.get_mode()).equals("no")){
                                ghost.update_pos();
                            }
                            Graphics.move_cursor_print(ghost);
                            if(ghost.get_mode() != 3 || OrderedPair.distance(ghost.get_xpos(), ghost.get_ypos(), 27, 13) < 4){
                                i++;
                            }
                        }
                    } else {
                        if(frightened_move){
                            boolean find_move = true;
                            while(find_move){
                                int move = (int) (Math.random() * 4);
                                switch(move){
                                    case 0:
                                        if(!board.can_move_ghost_ed(ghost.get_xpos(), ghost.get_ypos(), 00, ghost.get_mode()).equals("no")
                                            && ghost.get_dir() != 01){
                                            ghost.set_dir(00);
                                            find_move = false;
                                        }
                                        break;
                                    case 1:
                                        if(!board.can_move_ghost_ed(ghost.get_xpos(), ghost.get_ypos(), 01, ghost.get_mode()).equals("no")
                                            && ghost.get_dir() != 00){
                                            ghost.set_dir(01);
                                            find_move = false;
                                        }
                                        break;
                                    case 2:
                                        if(!board.can_move_ghost_ed(ghost.get_xpos(), ghost.get_ypos(), 10, ghost.get_mode()).equals("no")
                                            && ghost.get_dir() != 11){
                                            ghost.set_dir(10);
                                            find_move = false;
                                        }
                                        break;
                                    case 3:
                                        if(!board.can_move_ghost_ed(ghost.get_xpos(), ghost.get_ypos(), 11, ghost.get_mode()).equals("no")
                                            && ghost.get_dir() != 10){
                                            ghost.set_dir(11);
                                            find_move = false;
                                        }
                                        break;
                                }
                            }
                            
                            if(board.board_at(ghost.get_xpos(), ghost.get_ypos()) == 'p'){
                                Graphics.move_cursor_print(ghost.get_xpos(), ghost.get_ypos(), 
                                    "\u001b[0m▬");
                            } else {
                                Graphics.move_cursor_print(ghost.get_xpos(), ghost.get_ypos(), 
                                    "\u001b[0m" + board.board_at(ghost.get_xpos(), ghost.get_ypos()));
                            }
                            
                            ghost.update_pos();
                            Graphics.move_cursor_print(ghost);
                        }
                    }
                }
                ghosts_move = false;
            } else {
                ghosts_move = true;
            }
            
            if(frightened_move){
                frightened_move = false;
            } else {
                frightened_move = true;
            }
            
            Graphics.move_cursor_print(50, 33, "\u001b[0m" + pacman.get_score());
            
            if(pacman.eat_ghost(ghosts)){
                pacman.add_score(300);
            }
            
            if(pacman.has_lost(ghosts)){
                play = false;
                break;
            }
            
            Graphics.flush();
        }
        
        
        Graphics.close();

    }
}
