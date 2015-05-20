// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// H�gskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen � s198524
// Roger Bl�tekj�r Johannessen � s186571
// Halvor R�nneseth � s172589

////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen lager panelet hvor publikum kan orientere seg om 		//
//  hvilke Arrangement som holdes p� Kulturhuset, kj�pe, avbestille og	//
//	s�ke p� Billetter													//
//////////////////////////////////////////////////////////////////////////

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Brukervindu extends JPanel implements Serializable{
	private static final long serialVersionUID = 6885055091284757299L;
	Kulturhus k;
	Personregister pr;
	
	//////////////////
	//	KONSTRUKT�R	//
	//////////////////
	
	public Brukervindu( Kulturhus inn ){	// Kulturhuset m� opprettes og sendes med fra main
		//konstrukt�r fra JPanel
		super(new GridLayout(1,1));
		k = inn;
		
		//Oppretter et vindu med faner
		JTabbedPane faneVindu = new JTabbedPane();
		faneVindu.setPreferredSize(new Dimension(550,500));
		
		//Oppretter vinduer for Oversikt og Billettbestilling
		Oversiktsvindu ov = new Oversiktsvindu(k);
		Billettvindu bv = new Billettvindu(k);
		
		//Knytter Oversiktsvindu til Oversiktsfane
		faneVindu.addTab("Oversikt",null,ov,"Oversikt over arrangement p� Kulturhuset");
		faneVindu.setMnemonicAt(0, KeyEvent.VK_1);
		
		//Knytter Billettvindu til Billettfane
		faneVindu.addTab("Billetter",null,bv,"Bestill billetter til arrangement");
		faneVindu.setMnemonicAt(0, KeyEvent.VK_2);
		
		faneVindu.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		//Setter fanevindu inn i Brukervinduet
		add(faneVindu);
	}
	/////////////////////////
	//	KONSTRUKT�R	SLUTT  //
	/////////////////////////
	
   protected JComponent makeTextPanel(String text)
   {
     JPanel panel = new JPanel(false);
     JLabel filler = new JLabel(text);
     filler.setHorizontalAlignment(JLabel.CENTER);
     panel.setLayout(new GridLayout(1, 1));
     panel.add(filler);
     return panel;
   }
	
	//Oppretter og viser Bruikervindu
	public void createAndShowGUI()
    {
      //Instansierer og lager brukervindu
      JFrame brukervindu = new JFrame("Publikumsportal");
      
      //setter parametere for brukervindu
      brukervindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //henter innholdet til brukervindu
      brukervindu.getContentPane().add(new Brukervindu(k), BorderLayout.CENTER);
      
      brukervindu.addWindowListener(new WindowAdapter()
      {
          public void windowClosing(WindowEvent e)
          {
        	  k.lagreLokaler();
          }
      });
      
      // Viser vinduet.
      brukervindu.pack();
      brukervindu.setLocationRelativeTo(null);
      brukervindu.setVisible(true);
    }
}
