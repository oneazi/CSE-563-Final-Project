import java.awt.*;
import java.io.Serializable;

public class Dot implements Drawable, Serializable {
    private int x, y;
    private boolean visited;
    private boolean connected;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
        connected = false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 7, 7);
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isConnected() {
        return connected;
    }

    public void visit() {
        visited = true;
    }

    public void connect() {
        connected = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setVisit(boolean visited) {
        this.visited = visited;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }
}
