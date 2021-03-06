// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// H�gskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen � s198524
// Roger Bl�tekj�r Johannessen � s186571
// Halvor R�nneseth � s172589
//
////////////////////////////////BESKRIVELSE///////////////////////////////
// Denne klassen lager panelet hvor administrator kan opprette,			// 
// endre og slette Lokaler, Arrangement og Kontaktpersoner				// 
// samt hente ut informasjon og statistikk.								//
//////////////////////////////////////////////////////////////////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

 public class Adminvindu extends JPanel implements Serializable {
 private static final long serialVersionUID = -6455247982999758395L;
 Kulturhus k;
 Personregister pr;
 Lokalvindu lokalV;
 Arrangementvindu arrangementV;
 Kontaktvindu kontaktV;
 Statistikkvindu statVindu;
 Brukervindu brukerV;
	
 
 // Oppretter tabs for Lokalvindu, Arrangementvindu, 
 // Kontaktvindu og Statistikkvindu
public Adminvindu( Kulturhus hus,Personregister reg)
   {
     super(new GridLayout(1, 1));

    JTabbedPane tabbedPane = new JTabbedPane();
    
    k = hus;
	pr = reg;
	lokalV = new Lokalvindu(k);
	arrangementV = new Arrangementvindu(k,pr);
	kontaktV = new Kontaktvindu(pr,k);
	statVindu = new Statistikkvindu(k);
	
	try { 
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (Exception e) {
	    e.printStackTrace();
	}
	
    tabbedPane.addTab("Administrer lokaler", 
    		null, 
    		lokalV, 
    		"Administrasjon av kulturhusets lokaler");
    
    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

    tabbedPane.addTab("Administrer arrangementer", 
    		null, 
    		arrangementV,
            "Administrasjon av kulturhusets arrangementer");
    
    tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

    tabbedPane.addTab("Administrer kontaktpersoner", 
    		null, 
    		kontaktV, 
    		"Administrasjon av kulturhusets kontaktpersoner");
    
    tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

    tabbedPane.addTab("Statistikk", 
    		null, 
    		statVindu, 
    		"Statistikk over Kultuhusets billettsalg");
    
    tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

    tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

    tabbedPane.setPreferredSize(new Dimension(1500, 750));
    add(tabbedPane);
   }
	
   protected JComponent makeTextPanel(String text)
   {
     JPanel panel = new JPanel(false);
     JLabel filler = new JLabel(text);
     filler.setHorizontalAlignment(JLabel.CENTER);
     panel.setLayout(new GridLayout(1, 1));
     panel.add(filler);
     return panel;
   }
   
   // Lager GUI og viser dette
   public void createUser() {

	   brukerV = new Brukervindu(k);
	   brukerV.createAndShowGUI();   
   }
    public void createAdmin()
    {
      // Oppretter og setter opp vinduet.
      JFrame frame = new JFrame("Kulturhuset " + k.get_Navn());
      frame.getContentPane().add(new Adminvindu(k,pr), BorderLayout.CENTER);
      
      frame.addWindowListener(new WindowAdapter()
      {
          public void windowClosing(WindowEvent e)
          {
        	  pr.lagrePersonregister();
        	  k.lagreLokaler();
          }
      });
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
      // Viser vinduet.
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    }
 }
