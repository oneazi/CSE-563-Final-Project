import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Loader {
    public static ArrayList<Dot> load() {
        ArrayList<Dot> dotsList = new ArrayList<>();
        // allow the user select the file they would like to load
        JFileChooser fc = new JFileChooser();
        int i = fc.showOpenDialog(null);
        String filePath = "";
        if(i == JFileChooser.APPROVE_OPTION)
        {
            File f = fc.getSelectedFile();
            filePath = f.getPath();
        }
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            dotsList = (ArrayList<Dot>) ois.readObject();
            System.out.println("List saved successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return dotsList;
    }
}