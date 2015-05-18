////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen panelet hvor publikum kan orientere seg om hvilke		//
//	arrangement som holder på kulturhuset, kjøpe og avbestille			//
//	billetter															//
//////////////////////////////////////////////////////////////////////////
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.Date;

public class Brukervindu extends JPanel implements Serializable{
	private static final long serialVersionUID = 6885055091284757299L;
	Kulturhus k;
	Personregister pr;
	
	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Brukervindu( Kulturhus inn ){	// Kulturhuset må opprettes og sendes med fra main
		//konstruktør fra JPanel
		super(new GridLayout(1,1));
		k = inn;
		
		//Oppretter et vindu med faner
		JTabbedPane faneVindu = new JTabbedPane();
		faneVindu.setPreferredSize(new Dimension(1000,1000));
		
		//Oppretter vinduer for Oversikt og Billettbestilling
		Oversiktsvindu ov = new Oversiktsvindu(k);
		Billettvindu bv = new Billettvindu(k);
		
		//Knytter Oversiktsvindu til Oversiktsfane
		faneVindu.addTab("Oversikt",null,ov,"Oversikt over arrangement på Kulturhuset");
		faneVindu.setMnemonicAt(0, KeyEvent.VK_1);
		
		//Knytter Billettvindu til Billettfane
		faneVindu.addTab("Billetter",null,bv,"Bestill billetter til arrangement");
		faneVindu.setMnemonicAt(0, KeyEvent.VK_2);
		
		faneVindu.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		//Setter fanevindu inn i Brukervinduet
		add(faneVindu);
	}
	/////////////////////////
	//	KONSTRUKTØR	SLUTT  //
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
      
 
      //Display the window.
      brukervindu.pack();
      brukervindu.setVisible(true);
    }
}
