public class Board {
    private char[][] map;
    
    int score = 0;
    int lives = 2;

    //creates board set for level 1
    //x's distinguish increased entrance gaps
    //p is for ghosts to enter ghost house
    // ● are pellets
    //◍ are power pellets
    //⬤ is pacman
    
    public Board(){
        
        map = new char[31][55];
        
        //MAP
        
        String row = "╔═════════════════════════╕ ╒═════════════════════════╗";
        
        for(int i = 0; i < 55; i++){
            map[0][i] = row.charAt(i);
        }
        
        row = "║ ● ● ● ● ● ● ● ● ● ● ● ● │ │ ● ● ● ● ● ● ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[1][i] = row.charAt(i);
        }
        
        row = "║x●x┌─────┐x●x┌───────┐x●x│ │x●x┌───────┐x●x┌─────┐x●x║";
        
        for(int i = 0; i < 55; i++){
            map[2][i] = row.charAt(i);
        }
        
        row = "║ ◍ │     │ ● │       │ ● │ │ ● │       │ ● │     │ ◍ ║";
        
        for(int i = 0; i < 55; i++){
            map[3][i] = row.charAt(i);
        }
        
        row = "║x●x└─────┘x●x└───────┘x●x└─┘x●x└───────┘x●x└─────┘x●x║";
        
        for(int i = 0; i < 55; i++){
            map[4][i] = row.charAt(i);
        }
        
        row = "║ ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[5][i] = row.charAt(i);
        }
        
        row = "║x●x┌─────┐x●x┌─┐x●x┌─────────────┐x●x┌─┐x●x┌─────┐x●x║";
        
        for(int i = 0; i < 55; i++){
            map[6][i] = row.charAt(i);
        }
        
        row = "║x●x└─────┘x●x│ │x●x└─────┐ ┌─────┘x●x│ │x●x└─────┘x●x║";
        
        for(int i = 0; i < 55; i++){
            map[7][i] = row.charAt(i);
        }
        
        row = "║ ● ● ● ● ● ● │ │ ● ● ● ● │ │ ● ● ● ● │ │ ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[8][i] = row.charAt(i);
        }
        
        row = "╚═════════╗x●x│ └─────┐x x│ │x x┌─────┘ │x●x╔═════════╝";
        
        for(int i = 0; i < 55; i++){
            map[9][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ ┌─────┘x x└─┘x x└─────┐ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[10][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ │                     │ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[11][i] = row.charAt(i);
        }
                                          
        row = "          ║ ● │ │x //╔════▬p▬════╗// x│ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[12][i] = row.charAt(i);
        }
                                 
        row = "══════════╝x●x└─┘x //║    x x    ║// x└─┘x●x╚══════════";
        
        for(int i = 0; i < 55; i++){
            map[13][i] = row.charAt(i);
        }

        row = "            ●       /║           ║/       ●            ";
                                                 
        for(int i = 0; i < 55; i++){
            map[14][i] = row.charAt(i);
        }
        
        row = "══════════╗x●x┌─┐x //║           ║// x┌─┐x●x╔══════════";
        
        for(int i = 0; i < 55; i++){
            map[15][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ │x //╚═══════════╝// x│ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[16][i] = row.charAt(i);
        }
                                 
        row = "          ║ ● │ │                     │ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[17][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ │x x┌─────────────┐x x│ │ ● ║           ";
        
        for(int i = 0; i < 55; i++){
            map[18][i] = row.charAt(i);
        }
        
        row = "╔═════════╝x●x└─┘x x└─────┐ ┌─────┘x x└─┘x●x╚═════════╗";
        
        for(int i = 0; i < 55; i++){
            map[19][i] = row.charAt(i);
        } 
        
        row = "║ ● ● ● ● ● ● ● ● ● ● ● ● │ │ ● ● ● ● ● ● ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[20][i] = row.charAt(i);
        }
        
        row = "║x●x┌─────┐x●x┌───────┐x●x│ │x●x┌───────┐x●x┌─────┐x●x║";
        
        for(int i = 0; i < 55; i++){
            map[21][i] = row.charAt(i);
        }
        
        row = "║x●x└───┐ │x●x└───────┘x●x└─┘x●x└───────┘x●x│ ┌───┘x●x║";
        
        for(int i = 0; i < 55; i++){
            map[22][i] = row.charAt(i);
        }
        
        row = "║ ◍ ● ● │ │ ● ● ● ● ● ● ●  ⬤  ● ● ● ● ● ● ● │ │ ● ● ◍ ║";
        
        for(int i = 0; i < 55; i++){
            map[23][i] = row.charAt(i);
        }
        
        row = "╙───┐x●x│ │x●x┌─┐x●x┌─────────────┐x●x┌─┐x●x│ │x●x┌───╜";
        
        for(int i = 0; i < 55; i++){
            map[24][i] = row.charAt(i);
        }
        
        row = "╓───┘x●x└─┘x●x│ │x●x└─────┐ ┌─────┘x●x│ │x●x└─┘x●x└───╖";
        
        for(int i = 0; i < 55; i++){
            map[25][i] = row.charAt(i);
        }
        
        row = "║ ● ● ● ● ● ● │ │ ● ● ● ● │ │ ● ● ● ● │ │ ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[26][i] = row.charAt(i);
        }
        
        row = "║x●x┌─────────┘ └─────┐x●x│ │x●x┌─────┘ └─────────┐x●x║";
        
        for(int i = 0; i < 55; i++){
            map[27][i] = row.charAt(i);
        }
        
        row = "║x●x└─────────────────┘x●x└─┘x●x└─────────────────┘x●x║";
        
        for(int i = 0; i < 55; i++){
            map[28][i] = row.charAt(i);
        }
        
        row = "║ ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[29][i] = row.charAt(i);
        }
        
        row = "╚═════════════════════════════════════════════════════╝";
        
        for(int i = 0; i < 55; i++){
            map[30][i] = row.charAt(i);
        }
        
    }
    
    public String can_move(int xpos, int ypos, int dir){
        //checks dir facing to see if blocked
        //2 horizontal and 1 vertical because of double horizontal spacing
        //diagonal moves possible to make it easier to turn up and down
        if(dir == 00){
            if(xpos + 2 > 54){
                return "right";
            }
            if(map[ypos][xpos + 2] == ' ' 
                || map[ypos][xpos + 2] == '●' 
                || map[ypos][xpos + 2] == '◍'
                || map[ypos][xpos + 2] == 'x'){
                return "right";
            }
        } else if (dir == 01){
            if(xpos - 2 < 0){
                return "left";
            }
            if(map[ypos][xpos - 2] == ' ' 
                || map[ypos][xpos - 2] == '●' 
                || map[ypos][xpos - 2] == '◍'
                || map[ypos][xpos - 2] == 'x'){
                return "left";
            }
        } else if (dir == 10){
            if(map[ypos - 1][xpos] == ' ' 
                || map[ypos - 1][xpos] == '●' 
                || map[ypos - 1][xpos] == '◍'){
                return "up";
            }
            if(map[ypos - 1][xpos] == 'x'){
                if(map[ypos - 1][xpos - 1] == ' ' 
                || map[ypos - 1][xpos - 1] == '●' 
                || map[ypos - 1][xpos - 1] == '◍'){
                    return "upleft";
                } else if(map[ypos - 1][xpos + 1] == ' ' 
                || map[ypos - 1][xpos + 1] == '●' 
                || map[ypos - 1][xpos + 1] == '◍'){
                    return "upright";
                }
            }
        } else if (dir == 11){
            if(map[ypos + 1][xpos] == ' ' 
                || map[ypos + 1][xpos] == '●' 
                || map[ypos + 1][xpos] == '◍'
                ){
                return "down";
            }
            if(map[ypos + 1][xpos] == 'x'){
                if(map[ypos + 1][xpos - 1] == ' ' 
                || map[ypos + 1][xpos - 1] == '●' 
                || map[ypos + 1][xpos - 1] == '◍'){
                    return "downleft";
                } else if(map[ypos + 1][xpos + 1] == ' ' 
                || map[ypos + 1][xpos + 1] == '●' 
                || map[ypos + 1][xpos + 1] == '◍'){
                    return "downright";
                }
            }
        }
        return "no";
    }
    
    public String can_move_ghost_ed(int xpos, int ypos, int dir, int mode){
        //movement check for ghosts 
        //(lets move into pacman, gets rid of diagonal movement, 
        //lets move through 'p' under certain circumstances)
        if(dir == 00){
            if(xpos + 2 > 54){
                return "right";
            }
            if(map[ypos][xpos + 2] == ' ' 
                || map[ypos][xpos + 2] == '●' 
                || map[ypos][xpos + 2] == '◍'
                || map[ypos][xpos + 2] == '⬤'){
                return "right";
            }
        } else if (dir == 01){
            if(xpos - 2 < 0){
                return "left";
            }
            if(map[ypos][xpos - 2] == ' ' 
                || map[ypos][xpos - 2] == '●' 
                || map[ypos][xpos - 2] == '◍'
                || map[ypos][xpos - 2] == '⬤'){
                return "left";
            }
        } else if (dir == 10){
            if(map[ypos - 1][xpos] == ' ' 
                || map[ypos - 1][xpos] == '●' 
                || map[ypos - 1][xpos] == '◍'
                || map[ypos - 1][xpos] == '⬤'
                || map[ypos - 1][xpos] == 'p'){
                return "up";
            }
        } else if (dir == 11){
            if(map[ypos + 1][xpos] == ' ' 
                || map[ypos + 1][xpos] == '●' 
                || map[ypos + 1][xpos] == '◍'
                || map[ypos + 1][xpos] == '⬤'
                || (map[ypos + 1][xpos] == 'p' && mode == 3)){
                return "down";
            }
        }
        return "no";
    }
    
    public void edit_board(int xpos, int ypos, char change){
        map[ypos][xpos] = change;
    }
    
    public char board_at(int xpos, int ypos){
        return map[ypos][xpos];
    }
    
    public void set_score(int score){
        this.score = score;
    }
    
    public void set_lives(int lives){
        this.lives = lives;
    }
    
    public int get_score(){
        return score;
    }
    
    public int get_lives(){
        return lives;
    }
}
