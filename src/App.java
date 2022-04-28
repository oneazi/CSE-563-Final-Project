import javax.swing.*;
import java.awt.event.*;

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
                System.out.println("save");
                Saver.save(canvas.getDotsList());
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("load");
                canvas.setDotsList(Loader.load());
                canvas.repaint();
            }
        });
        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("random");
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clear");
            }
        });
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DbScan.scan(canvas.getDotsList(), 50);
                System.out.println("run");
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
