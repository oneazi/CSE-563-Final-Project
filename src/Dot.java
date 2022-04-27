import java.awt.*;

public class Dot implements Drawable{
    private int x, y;
    private boolean visited;

    public Dot(int x, int y) {
        System.out.println("dot created");
        this.x = x;
        this.y = y;
        visited = false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 10, 10);
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit() {
        visited = true;
    }
}
