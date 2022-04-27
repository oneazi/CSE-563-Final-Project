import java.awt.*;
import java.io.Serializable;

public class Dot implements Drawable, Serializable {
    private int x, y;
    private boolean visited;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 7, 7);
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit() {
        visited = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}