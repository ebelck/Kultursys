import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Bildehandler extends JPanel {
    	
	private BufferedImage placeholder_img;
	
	public File hentFil() {
		File filHandler = new File("");
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG eller GIF", "jpg", "png", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
        	filHandler = chooser.getSelectedFile();
        	return filHandler;
        } else {
        	return filHandler;
        }
	}
}
