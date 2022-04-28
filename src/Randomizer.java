import java.util.ArrayList;
import java.util.Random;

public class Randomizer {
    public static ArrayList<Dot> randomize(){
        System.out.println("In Randomizer");
        ArrayList<Dot> dotList = new ArrayList<>();
        int randX;
        int randY;
        for (int i = 0; i <100; i++){
            Random rand = new Random();
            randX = rand.nextInt(500);
            randY = rand.nextInt(500);
            System.out.println(randX + ", " + randY);
            dotList.add(new Dot(randX, randY));
        }
        return dotList;
    }
}
