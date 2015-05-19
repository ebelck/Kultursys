import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class Bildehandler  extends JPanel implements Serializable{
   
	private static final long serialVersionUID = -947839549918466106L;
	
	public File hentFil() {
		File filHandler = new File("");
        JFileChooser chooser = new JFileChooser();
        
        // Bestemmer tillatte filtyper for bilde
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
