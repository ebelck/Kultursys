////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen panelet hvor publikum kan orientere seg om hvilke		//
//	arrangement som holder p� kulturhuset, kj�pe og avbestille			//
//	billetter															//
//////////////////////////////////////////////////////////////////////////
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Date;

public class Brukervindu extends JPanel{

	private static final long serialVersionUID = 1L; //hva skal jeg sette her?

	//////////////////
	//	KONSTRUKT�R	//
	//////////////////
	
	public Brukervindu(){	// Kulturhuset m� opprettes og sendes med fra main
		//konstrukt�r fra JPanel
		super(new GridLayout(1,1));
		Kulturhus k = new Kulturhus("Test","Testesen");
		
		//////////////////////////////////////
		//////////	TESTKODE START  //////////
		//////////////////////////////////////
		
		
		//////////////////////////////////////
		//////////	TESTKODE START  //////////
		//////////////////////////////////////
		
		//Oppretter et vindu med faner
		JTabbedPane faneVindu = new JTabbedPane();
		
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
      brukervindu.getContentPane().add(new Brukervindu(/*Kulturhus k*/), BorderLayout.CENTER);
      
 
      //Display the window.
      brukervindu.pack();
      brukervindu.setVisible(true);
    }	
}
