import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Canvas extends JPanel {

    private ArrayList<Dot> dotsList;
    public Canvas() {
        dotsList = new ArrayList<>();
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
}
