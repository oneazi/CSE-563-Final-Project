import java.util.ArrayList;
import java.util.Random;

public class Randomizer {
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
