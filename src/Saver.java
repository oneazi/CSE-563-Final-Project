import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Saver {
    /**
     * Serializes a list of dots and allows the user to select a file in their filesystem where they
     * would like to save the list of dots
     * @param dotsList the list of dots to be saved to the file
     */
    public static void save(ArrayList<Dot> dotsList){
        // allow the user to enter the location and file name
        JFileChooser fc = new JFileChooser();
        int i = fc.showSaveDialog(null);
        String filePath = "";
        if(i == JFileChooser.APPROVE_OPTION)
        {
            File f = fc.getSelectedFile();
            filePath = f.getPath();
        }
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dotsList);
            oos.close();
            fos.close();
            System.out.println("List saved successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
