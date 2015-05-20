// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// Høgskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen – s198524
// Roger Bløtekjær Johannessen – s186571
// Halvor Rønneseth – s172589
//
////////////////////////////////BESKRIVELSE///////////////////////////////
// Denne klassen håndterer bildefiler									//
//////////////////////////////////////////////////////////////////////////

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
