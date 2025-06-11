public class Timing {
    private static final long game_start = System.currentTimeMillis();
    private static long loop_start;
    private static int phase;
    private static long frightened_start;
    
    public static void update_phase(){
        int game_duration = (int) (current_time() - game_start);
        if(0 <= game_duration && game_duration <= 7000){
            phase = 0;
        } else if (7000 < game_duration && game_duration <= 27000){
            phase = 1;
        } else if (27000 < game_duration && game_duration <= 34000){
            phase = 2;
        } else if (34000 < game_duration && game_duration <= 54000){
            phase = 3;
        } else if (54000 < game_duration && game_duration <= 59000){
            phase = 4;
        } else if (59000 < game_duration && game_duration <= 79000){
            phase = 5;
        } else if (79000 < game_duration && game_duration <= 84000){
            phase = 6;
        } else if (game_duration > 84000){
            phase = 7;
        }
    }
    
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static long current_time(){
        return System.currentTimeMillis();
    }
    
    public static int time_diff(){
        return (int) (System.currentTimeMillis() - loop_start);
    }
    
    public static void set_loop_start(){
        loop_start = System.currentTimeMillis();
    }
    
    public static void set_phase(int ph){
        phase = ph;
    }
    
    public static void set_frightened_start(){
        frightened_start = System.currentTimeMillis();
    }
    
    public static long get_loop_start(){
        return loop_start;
    }
    
    public static int get_phase(){
        return phase;
    }
    
    public static int time_since_frightened(){
        return (int) (System.currentTimeMillis() - frightened_start);
    }
}
