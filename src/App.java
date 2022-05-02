import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * This class provides the base GUI for the entire dots drawing application
 */
public class App extends JFrame {

    Canvas canvas;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem save, load, random, clear, run;

    static int sourceIndex, targetIndex;
    static boolean drawing;

    /**
     * This is the constructor for the App class which initializes the entire GUI and adds
     * action listeners to the buttons to enable interaction with the GUI
     */
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
                drawing = false;
                Saver.save(canvas.getDotsList());
            }
        });
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawing = false;

                canvas.setDotsList(Loader.load());
                canvas.repaint();
            }
        });
        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawing = false;

                canvas.setConnections(new ArrayList<>());
                canvas.setDotsList(Randomizer.randomize(canvas.getWidth(), canvas.getHeight()));
                canvas.repaint();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawing = false;

                canvas.setDotsList(new ArrayList<>());
                canvas.setConnections(new ArrayList<>());
                canvas.repaint();
            }
        });

        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawing = false;

                if (DbScan.setEpsilon()) {
                    ArrayList<ArrayList<Integer>> connections;
                    connections = DbScan.scan(canvas.getDotsList());

                    if(connections.size() > 0) {
                        drawing = true;
                        canvas.initConnections(connections.size());

                        (new Thread(() -> {
                                try {
                                    for(sourceIndex = 0; drawing && sourceIndex < connections.size(); ++sourceIndex) {
                                        for(targetIndex = 0; drawing && targetIndex < connections.get(sourceIndex).size(); ++targetIndex) {
                                            SwingUtilities.invokeAndWait(() -> {
                                                    canvas.addConnection
                                                        (sourceIndex, connections.get(sourceIndex).get(targetIndex));
                                                    canvas.repaint();
                                                });

                                            Thread.sleep(100);
                                        }
                                    }
                                } catch(Exception exception) {
                                    System.out.println("unable to interrupt first invoke...");
                                }
                        })).start();
                    }
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

    /**
     * the main point of entry for the program
     * @param args an array of strings provided as parameters to the program
     */
    public static void main(String[] args) {
        App win = new App();
        win.setSize(500, 500);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
