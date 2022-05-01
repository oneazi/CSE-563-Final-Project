import java.util.ArrayList;
import java.util.Random;

public class Randomizer {
    /**
     * Creates a list of 100 dots to be drawn in random locations on the canvas
     * @param x upper bound on x value to be randomly produced
     * @param y upper bound on y value to be randomly produced
     * @return list of dots to be drawn on the screen
     */
    public static ArrayList<Dot> randomize(int x, int y){
        ArrayList<Dot> dotList = new ArrayList<>();
        int randX;
        int randY;
        for (int i = 0; i <100; i++){
            Random rand = new Random();
            randX = rand.nextInt(x);
            randY = rand.nextInt(y);
            dotList.add(new Dot(randX, randY));
        }
        return dotList;
    }
}
