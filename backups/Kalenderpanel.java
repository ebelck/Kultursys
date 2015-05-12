import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
//import org.jdesktop.swingx.JXDatePicker;
import java.awt.image.BufferedImage;
import java.io.*;

public class Kalenderpanel extends JPanel {
	
	static Bildehandler bh = new Bildehandler();

    public static void main(String[] args) {
    	
    	System.out.println(bh.hentFil().getName());
    	
        /*JFrame frame = new JFrame("JXPicker Example");
               
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 400, 250, 100);

        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

        panel.add(picker);
        frame.getContentPane().add(panel);

        frame.setVisible(true);*/
        
    }
}