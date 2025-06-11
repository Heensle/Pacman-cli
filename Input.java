import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.terminal.Terminal;

public class Input {
    private static BindingReader reader;
    private static KeyMap<String> keyMap;
    
    public static void init_reader(Terminal terminal){
        reader = new BindingReader(terminal.reader());
        keyMap = new KeyMap<>(); //binds characters to meaning

        keyMap.bind("up", "\u001B[A");
        keyMap.bind("down", "\u001B[B");
        keyMap.bind("left", "\u001B[D");
        keyMap.bind("right", "\u001B[C");
        keyMap.bind("quit", "q");
        keyMap.bind("up", "w");
        keyMap.bind("down", "s");
        keyMap.bind("left", "a");
        keyMap.bind("right", "d");
        keyMap.bind("pause", "p");
    }
    
    public static int peek_char(int ms){//check how many char in isteam without taking them
        return reader.peekCharacter(ms);
    }
    
    public static String read_binding(){//reads from keymap
        return reader.readBinding(keyMap);
    }
}
