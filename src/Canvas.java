import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Canvas extends JPanel implements MouseListener {

    private ArrayList<Dot> dotsList;
    public Canvas() {
        dotsList = new ArrayList<>();
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        System.out.println("in paintComponent");
        super.paintComponent(g);
        for(Dot dot : dotsList) {
            dot.draw(g);
        }
    }

    public void addDot(Dot dot) {
        System.out.println("dot added");
        dotsList.add(dot);
    }

    public ArrayList<Dot> getDotsList() {
        return this.dotsList;
    }

    public void setDotsList(ArrayList<Dot> dotsList) {
        this.dotsList = dotsList;
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