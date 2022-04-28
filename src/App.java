import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class App extends JFrame {

    Canvas canvas;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem save, load, random, clear, run;

    public App() {
        canvas = new Canvas();
        menuBar = new JMenuBar();
        menu = new JMenu("Actions");
        save = new JMenuItem("Save");
        load = new JMenuItem("Load");
        random = new JMenuItem("Random");
        clear = new JMenuItem("Clear");
        run = new JMenuItem("Run");

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("save");
                Saver.save(canvas.getDotsList());
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("load");
                canvas.setDotsList(Loader.load());
                canvas.repaint();
            }
        });
        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("random");
                canvas.setConnections(new ArrayList<>());
                canvas.setDotsList(Randomizer.randomize(canvas.getWidth(), canvas.getHeight()));
                canvas.repaint();
                
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("clear");
                canvas.setDotsList(new ArrayList<>());
                canvas.setConnections(new ArrayList<>());
                canvas.repaint();
            }
        });
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DbScan.setEpsilon()) {
                    canvas.setConnections(DbScan.scan(canvas.getDotsList()));
                    canvas.repaint();
                }
            }
        });

        menu.add(save);
        menu.add(load);
        menu.add(random);
        menu.add(clear);
        menu.add(run);
        menuBar.add(menu);

        this.getContentPane().add(canvas);
        this.setJMenuBar(menuBar);
        this.setTitle("Dots App");
    }

    public static void main(String[] args) {
        App win = new App();
        win.setSize(500, 500);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
