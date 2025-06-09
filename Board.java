public class Board {
    private char[][] map;
    
    //creates board set for level 1
    //x's distinguish increased entrance gaps
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
                                           
        row = "          ║ ● │ │x  x╔════▬▬▬════╗x  x│ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[12][i] = row.charAt(i);
        }
                                 
        row = "══════════╝x●x└─┘x  x║           ║x  x└─┘x●x╚══════════";
        
        for(int i = 0; i < 55; i++){
            map[13][i] = row.charAt(i);
        }
        
        row = "            ●        ║ ᗣ ᗣ  ᗣ  ᗣ ║        ●            ";
                                                 
        for(int i = 0; i < 55; i++){
            map[14][i] = row.charAt(i);
        }
        
        row = "══════════╗x●x┌─┐x  x║           ║x  x┌─┐x●x╔══════════";
        
        for(int i = 0; i < 55; i++){
            map[15][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ │x  x╚═══════════╝x  x│ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[16][i] = row.charAt(i);
        }
                                 
        row = "          ║ ● │ │x                   x│ │ ● ║          ";
        
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
    
    //returns true if pacman can continue to move in a given direction
    public boolean can_move(Pacman pellet_eater){
        int PMxpos = pellet_eater.get_xpos();
        int PMypos = pellet_eater.get_ypos();
        if(pellet_eater.get_dir() == 10){
            PMypos--;
        } else if (pellet_eater.get_dir() == 11){
            PMypos++;
        } else if (pellet_eater.get_dir() == 00){
            PMxpos+=2;
        } else if (pellet_eater.get_dir() == 01){
            PMxpos-=2;
        }
        if(PMxpos < 0 || PMxpos > 54){
            return true;
        }
        if(map[PMypos][PMxpos] != ' ' && map[PMypos][PMxpos] != '●' && map[PMypos][PMxpos] != '◍'){
            return false;
        }
        
        return true;
    }
    
    //returns true if pacman can move up/down modified for 
    //increased movement (3 wide entrances instead of 1 wide).
    public boolean can_move_up_down(Pacman pellet_eater){
        int PMxpos = pellet_eater.get_xpos();
        int PMypos = pellet_eater.get_ypos();
        if(pellet_eater.get_dir() == 10){
            PMypos--;
        } else if (pellet_eater.get_dir() == 11){
            PMypos++;
        }
        if(map[PMypos][PMxpos] != 'x'){
            return false;
        }
        
        return true;
    }
    
    public void print_board(){ 
        for(int i = 0; i < 31; i++){
            for(int j = 0; j < 55; j++){
                if(map[i][j] == 'x'){
                    System.out.print(' ');   
                } else if (map[i][j] == '⬤'){
                    System.out.print("\u001b[33;1m⬤\u001b[38;5;18m");
                } else if (map[i][j] == '●'){
                    System.out.print("\u001b[0m●");
                } /*else if (map[i][j] == '✰'){
                    System.out.print("\u001b[0m✰");
                } */else {
                    System.out.print("\u001b[38;5;18m" + map[i][j]);
                }
            }
            System.out.print("\n");
        }
        System.out.print("\u001b[0m");
    }
    
    public void edit_board(int xpos, int ypos, char change){
        map[ypos][xpos] = change;
    }
    
    public char board_at(int xpos, int ypos){
        return map[ypos][xpos];
    }
}
