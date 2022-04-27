public class Dot {
    private int x, y;
    private boolean visited;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit() {
        visited = true;
    }
}
