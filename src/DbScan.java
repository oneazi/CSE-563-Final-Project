import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class DbScan {
    public static ArrayList<ArrayList<Integer>> scan(ArrayList<Dot> dots, int epsilon) {
        Random rng = new Random();
        ArrayList<ArrayList<Integer>> connections = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> unvisited = new ArrayList<Integer>();
        ArrayList<Integer> neighbors = new ArrayList<Integer>();

        for(int i = 0; i < dots.size(); ++i) {
            connections.add(new ArrayList<Integer>());
            unvisited.add(i);

            // reset Dots
            dots.get(i).setVisit(false);
            dots.get(i).setConnected(false);
        }

        int index;
        int selection;

        while(unvisited.size() > 0) {
            index = rng.nextInt(unvisited.size());
            selection = unvisited.get(index);

            Dot selected = dots.get(selection);
            selected.visit();

            unvisited.remove(index);

            // find list of neighbors
            for(int i = 0; i < unvisited.size(); ++i) {
                if(DbScan.dist(selected, dots.get(unvisited.get(i))) < epsilon) {
                    neighbors.add(unvisited.get(i));

                    if(!dots.get(unvisited.get(i)).isConnected()) {
                        dots.get(unvisited.get(i)).connect();
                        connections.get(selection).add(unvisited.get(i));
                    }
                }
            }

            DbScan.cluster(dots, unvisited, connections, neighbors, epsilon, rng);
        }

        return connections;
    }

    private static void cluster(ArrayList<Dot> dots, ArrayList<Integer> unvisited,
                                ArrayList<ArrayList<Integer>> connections,
                                ArrayList<Integer> neighbors, int epsilon, Random rng) {
        if(neighbors.size() == 0) {
            return;
        }

        int index = rng.nextInt(neighbors.size());
        int selection = neighbors.get(index);

        Dot selected = dots.get(selection);
        selected.visit();

        neighbors.remove(index);
        unvisited.remove(Integer.valueOf(selection));

        for(int i = 0; i < unvisited.size(); ++i) {
            if(DbScan.dist(selected, dots.get(unvisited.get(i))) < epsilon) {
                neighbors.add(unvisited.get(i));

                if(!dots.get(unvisited.get(i)).isConnected()) {
                    dots.get(unvisited.get(i)).connect();
                    connections.get(selection).add(unvisited.get(i));
                }
            }
        }

        cluster(dots, unvisited, connections, neighbors, epsilon, rng);
    }

    /**
     * Calculate the Euclidean distance of two Dots.
     *
     * @param d1 The first Dot
     * @param d2 The second Dot
     * @return distance between the first and second Dot
     */
    private static double dist(Dot d1, Dot d2) {
        return Math.hypot
            (Math.abs(d2.getX() - d1.getX()), Math.abs(d2.getY() - d1.getY()));
    }
}
