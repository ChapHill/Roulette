
import java.util.Hashtable;

public class Table {
    private Hashtable<Integer, String> roulette;

    //sets the number to it's corresponding colour
    public void setNumbers(){
        roulette = new Hashtable<>();
        roulette.put(0, "GREEN");
        roulette.put(1, "RED");
        roulette.put(2, "BLACK");
        roulette.put(3, "RED");
        roulette.put(4, "BLACK");
        roulette.put(5, "RED");
        roulette.put(6, "BLACK");
        roulette.put(7, "RED");
        roulette.put(8, "BLACK");
        roulette.put(9, "RED");
        roulette.put(10, "BLACK");
        roulette.put(11, "BLACK");
        roulette.put(12, "RED");
        roulette.put(13, "BLACK");
        roulette.put(14, "RED");
        roulette.put(15, "BLACK");
        roulette.put(16, "RED");
        roulette.put(17, "BLACK");
        roulette.put(18, "RED");
        roulette.put(19, "RED");
        roulette.put(20, "BLACK");
        roulette.put(21, "RED");
        roulette.put(22, "BLACK");
        roulette.put(23, "RED");
        roulette.put(24, "BLACK");
        roulette.put(25, "RED");
        roulette.put(26, "BLACK");
        roulette.put(27, "RED");
        roulette.put(28, "BLACK");
        roulette.put(29, "BLACK");
        roulette.put(30, "RED");
        roulette.put(31, "BLACK");
        roulette.put(32, "RED");
        roulette.put(33, "BLACK");
        roulette.put(34, "RED");
        roulette.put(35, "BLACK");
        roulette.put(36, "RED");
    }

    public Hashtable<Integer, String> getRoulette() {
        return roulette;
    }

    //generates a random number from 0-36. Acts as the ball landing on a specific number
    public int randomNumber(){
        int max = 36;
        int min = 0;
        int range = max - min + 1;

        int random = (int)(Math.random() * range) + min;
        return random;
    }

}
