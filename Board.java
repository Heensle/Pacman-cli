public class Board {
    private char[][] map;
    
    
    
    public Board(){
        
        map = new char[31][55];
        
        String row = "╔═════════════════════════╕ ╒═════════════════════════╗";
        
        for(int i = 0; i < 55; i++){
            map[0][i] = row.charAt(i);
        }
        
        row = "║ ● ● ● ● ● ● ● ● ● ● ● ● │ │ ● ● ● ● ● ● ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[1][i] = row.charAt(i);
        }
        
        row = "║ ● ┌─────┐ ● ┌───────┐ ● │ │ ● ┌───────┐ ● ┌─────┐ ● ║";
        
        for(int i = 0; i < 55; i++){
            map[2][i] = row.charAt(i);
        }
        
        row = "║ ◍ │     │ ● │       │ ● │ │ ● │       │ ● │     │ ◍ ║";
        
        for(int i = 0; i < 55; i++){
            map[3][i] = row.charAt(i);
        }
        
        row = "║ ● └─────┘ ● └───────┘ ● └─┘ ● └───────┘ ● └─────┘ ● ║";
        
        for(int i = 0; i < 55; i++){
            map[4][i] = row.charAt(i);
        }
        
        row = "║ ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[5][i] = row.charAt(i);
        }
        
        row = "║ ● ┌─────┐ ● ┌─┐ ● ┌─────────────┐ ● ┌─┐ ● ┌─────┐ ● ║";
        
        for(int i = 0; i < 55; i++){
            map[6][i] = row.charAt(i);
        }
        
        row = "║ ● └─────┘ ● │ │ ● └─────┐ ┌─────┘ ● │ │ ● └─────┘ ● ║";
        
        for(int i = 0; i < 55; i++){
            map[7][i] = row.charAt(i);
        }
        
        row = "║ ● ● ● ● ● ● │ │ ● ● ● ● │ │ ● ● ● ● │ │ ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[8][i] = row.charAt(i);
        }
        
        row = "╚═════════╗ ● │ └─────┐   │ │   ┌─────┘ │ ● ╔═════════╝";
        
        for(int i = 0; i < 55; i++){
            map[9][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ ┌─────┘   └─┘   └─────┐ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[10][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ │                     │ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[11][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ │    ╔════▬▬▬════╗    │ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[12][i] = row.charAt(i);
        }
        
        row = "══════════╝ ● └─┘    ║           ║    └─┘ ● ╚══════════";
        
        for(int i = 0; i < 55; i++){
            map[13][i] = row.charAt(i);
        }
        
        row = "            ●        ║           ║        ●            ";
        
        for(int i = 0; i < 55; i++){
            map[14][i] = row.charAt(i);
        }
        
        row = "══════════╗ ● ┌─┐    ║           ║    ┌─┐ ● ╔══════════";
        
        for(int i = 0; i < 55; i++){
            map[15][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ │    ╚═══════════╝    │ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[16][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ │          🍒          │ │ ● ║          ";
        
        for(int i = 0; i < 55; i++){
            map[17][i] = row.charAt(i);
        }
        
        row = "          ║ ● │ │   ┌─────────────┐   │ │ ● ║           ";
        
        for(int i = 0; i < 55; i++){
            map[18][i] = row.charAt(i);
        }
        
        row = "╔═════════╝ ● └─┘   └─────┐ ┌─────┘   └─┘ ● ╚═════════╗";
        
        for(int i = 0; i < 55; i++){
            map[19][i] = row.charAt(i);
        } 
        
        row = "║ ● ● ● ● ● ● ● ● ● ● ● ● │ │ ● ● ● ● ● ● ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[20][i] = row.charAt(i);
        }
        
        row = "║ ● ┌─────┐ ● ┌───────┐ ● │ │ ● ┌───────┐ ● ┌─────┐ ● ║";
        
        for(int i = 0; i < 55; i++){
            map[21][i] = row.charAt(i);
        }
        
        row = "║ ● └───┐ │ ● └───────┘ ● └─┘ ● └───────┘ ● │ ┌───┘ ● ║";
        
        for(int i = 0; i < 55; i++){
            map[22][i] = row.charAt(i);
        }
        
        row = "║ ◍ ● ● │ │ ● ● ● ● ● ● ●  ⬤  ● ● ● ● ● ● ● │ │ ● ● ◍ ║";
        
        for(int i = 0; i < 55; i++){
            map[23][i] = row.charAt(i);
        }
        
        row = "╙───┐ ● │ │ ● ┌─┐ ● ┌─────────────┐ ● ┌─┐ ● │ │ ● ┌───╜";
        
        for(int i = 0; i < 55; i++){
            map[24][i] = row.charAt(i);
        }
        
        row = "╓───┘ ● └─┘ ● │ │ ● └─────┐ ┌─────┘ ● │ │ ● └─┘ ● └───╖";
        
        for(int i = 0; i < 55; i++){
            map[25][i] = row.charAt(i);
        }
        
        row = "║ ● ● ● ● ● ● │ │ ● ● ● ● │ │ ● ● ● ● │ │ ● ● ● ● ● ● ║";
        
        for(int i = 0; i < 55; i++){
            map[26][i] = row.charAt(i);
        }
        
        row = "║ ● ┌─────────┘ └─────┐ ● │ │ ● ┌─────┘ └─────────┐ ● ║";
        
        for(int i = 0; i < 55; i++){
            map[27][i] = row.charAt(i);
        }
        
        row = "║ ● └─────────────────┘ ● └─┘ ● └─────────────────┘ ● ║";
        
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
    
    public void print_board(){
        for(int i = 0; i < 31; i++){
            for(int j = 0; j < 55; j++){
                System.out.print(map[i][j]);
            }
            System.out.print("\n");
        }
    }
}
