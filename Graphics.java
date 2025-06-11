import java.util.ArrayList;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import java.io.IOException;

public class Graphics {
    
    private static Terminal terminal;

    public static void init_terminal() {
        if (terminal == null) {
            try {
                terminal = TerminalBuilder.builder().system(true).jna(false).build();
                terminal.enterRawMode(); //turn off input buffering
                terminal.writer().print("\u001B[?25l"); //hide cursor
                terminal.flush();
            } catch (IOException e) {
                throw new RuntimeException("Failed to initialize terminal", e);
            }
        }
    }
    
    public static void move_cursor_print(Entity thing) {
    // move cursor to xpos ypos of entity and prints appearance
    terminal.writer().print(String.format("\u001B[%d;%dH%s", thing.get_ypos() + 1, thing.get_xpos() + 1, thing.get_color() + thing.get_appearance()));
    terminal.flush();
    }
    
    public static void move_cursor_print(int xpos, int ypos, String text) {
    // move cursor to xpos ypos and print the text
    terminal.writer().print(String.format("\u001B[%d;%dH%s", ypos + 1, xpos + 1, text));
    terminal.flush();
    }
    
    public static void print_board(Board map){ 
        //prints board, one time use
        for(int i = 0; i < 31; i++){
            for(int j = 0; j < 55; j++){
                if(map.board_at(j, i) == 'x' || map.board_at(j, i) == '/'){
                    System.out.print(' ');   
                } else if (map.board_at(j, i) == '⬤'){
                    System.out.print("\u001b[33;1m⬤\u001b[38;5;18m");
                } else if (map.board_at(j, i) == '●'){
                    System.out.print("\u001b[0m●");
                } else if (map.board_at(j, i) == 'p'){
                    System.out.print("\u001b[0m▬");
                /*} else if (map[i][j] == '✰'){
                    System.out.print("\u001b[0m✰");*/
                } else {
                    System.out.print("\u001b[38;5;18m" + map.board_at(j, i));
                }
            }
            System.out.print("\n");
        }
        System.out.print("\u001b[0m");
    }
    
    public static void flush(){
        //flushes ostream
        terminal.flush();
    }
    
    public static void close(){
        try {
            terminal.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to close terminal", e);
        }
    }
    
    public static Terminal return_term(){
        return terminal;
    }
}
