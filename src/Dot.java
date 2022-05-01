import java.awt.*;
import java.io.Serializable;

public class Dot implements Drawable, Serializable {
    private int x, y;
    private boolean visited;
    private boolean connected;

    /**
     * Initializes a Dot object which holds the x,y coordinates of the dot on the canvas and whether
     * it has been visited and added to a tree in DBSCAN
     * @param x x coordinate on the canvas
     * @param y y coordinate on the canvas
     */
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
        connected = false;
    }

    /**
     * Allows the dots to be drawn on the screen
     * @param g
     */
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
