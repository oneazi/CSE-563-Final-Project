import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Canvas extends JPanel implements MouseListener {

    private ArrayList<Dot> dotsList;
    private ArrayList<ArrayList<Integer>> connections;

    public Canvas() {
        dotsList = new ArrayList<>();
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        for(Dot dot : dotsList) {
            dot.draw(g);
        }

        g.setColor(Color.BLACK);
        if(connections != null) {
            for(int i = 0; i < connections.size(); ++i) {
                Dot source = dotsList.get(i);

                for(int j = 0; j < connections.get(i).size(); ++j) {
                    Dot target = dotsList.get(connections.get(i).get(j));

                    g.drawLine(source.getX(),
                               source.getY(),
                               target.getX(),
                               target.getY());
                }
            }
        }
    }

    public void addDot(Dot dot) {
        dotsList.add(dot);
    }

    public ArrayList<Dot> getDotsList() {
        return this.dotsList;
    }

    public void setDotsList(ArrayList<Dot> dotsList) {
        this.dotsList = dotsList;
    }


    public void setConnections(ArrayList<ArrayList<Integer>> connections) {
        this.connections = connections;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int actualX = e.getX();
        int actualY = e.getY();
        System.out.print(actualX + ", " + actualY + "\n");
        Dot dot = new Dot(actualX, actualY);
        this.addDot(dot);
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
