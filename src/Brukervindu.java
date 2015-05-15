////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen panelet hvor publikum kan orientere seg om hvilke		//
//	arrangement som holder på kulturhuset, kjøpe og avbestille			//
//	billetter															//
//////////////////////////////////////////////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Date;

public class Brukervindu extends JPanel{

	private static final long serialVersionUID = 1L; //hva skal jeg sette her?

	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Brukervindu(){	// Kulturhuset må opprettes og sendes med fra main
		//konstruktør fra JPanel
		super(new GridLayout(1,1));
		Kulturhus k = new Kulturhus("Test","Testesen");
		
		//Oppretter et vindu med faner
		JTabbedPane faneVindu = new JTabbedPane();
		
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
      brukervindu.getContentPane().add(new Brukervindu(/*Kulturhus k*/), BorderLayout.CENTER);
      
 
      //Display the window.
      brukervindu.pack();
      brukervindu.setVisible(true);
    }
	
	//Testmetode som oppretter et Kulturhus
	public Kulturhus test(){
		
		//lager et Kulturhus
		Kulturhus k = new Kulturhus("Bortibygda kulturhus", "Et sted langt ut i gokk");
		Personregister pr = new Personregister();
		
		//Oppretter og legger til Lokale
		Lokale kino1, kino2, kino3, scene, konf1, konf2, cafe;
		
		k.leggTilLokale(new Lokale("Sal 1", "Stor kinosal"));
		k.leggTilLokale(new Lokale("Sal 2", "Liten kinosal"));
		k.leggTilLokale(new Lokale("Sal 3", "Liten kinosal"));
		k.leggTilLokale(new Lokale("Storstuen", "Stort konferanserom"));
		k.leggTilLokale(new Lokale("Lillestuen", "Lite konferanserom"));
		k.leggTilLokale(new Lokale("Revyscenen", "Scene for teater, revy og konserter"));
		k.leggTilLokale(new Lokale("Kaffekroken", "Bokkafe"));
		
		//Oppretter og legger til Kontaktpersoner
		pr.leggTilKontaktperson(new Kontaktperson("Per","Hansen","per@hansen.no", "12345678"));
		pr.leggTilKontaktperson(new Kontaktperson("Finn","Normann","finn@normann.no", "22334455"));
		pr.leggTilKontaktperson(new Kontaktperson("Kirsten","Giftekniv","kirsten@giftekniv.no", "90099009"));
		
		String beskrivelse;
		Date dato = new Date();
		
		
		//Oppretter og legger til Arrangement
		beskrivelse = "Batman (også kjent som Tim Burton's Batman) er en amerikansk actionthriller og film noir fra 1989 regissert av Tim Burton.";
		k.finnLokale(1).leggTilArrangement(new Arrangement("Film: Batman (1989)", pr.finnKontaktpersonViaTlf("12345678"), dato, beskrivelse, 100, 200));
		
		k.finnLokale(1).leggTilArrangement(new Arrangement("Film: Batman (1989)", pr.finnKontaktpersonViaTlf("12345678"), dato, beskrivelse, 100, 200));
		k.finnLokale(1).leggTilArrangement(new Arrangement("Film: Batman (1989)", pr.finnKontaktpersonViaTlf("12345678"), dato, beskrivelse, 100, 200));
		
		beskrivelse = "Tatt av vinden (originaltittel Gone with the Wind) er en amerikansk film fra 1939";
		k.finnLokale(2).leggTilArrangement(new Arrangement("Film: Tatt av Vinden (1939)", pr.finnKontaktpersonViaTlf("12345678"), dato, beskrivelse, 100, 100));
		k.finnLokale(2).leggTilArrangement(new Arrangement("Film: Tatt av Vinden (1939)", pr.finnKontaktpersonViaTlf("12345678"), dato, beskrivelse, 100, 100));
		k.finnLokale(2).leggTilArrangement(new Arrangement("Film: Tatt av Vinden (1939)", pr.finnKontaktpersonViaTlf("12345678"), dato, beskrivelse, 100, 100));
		
		beskrivelse = "Toy Story er en amerikansk dataanimert (CGI) film produsert av Pixar Animation Studios og gitt ut av Walt Disney Pictures og Buena Vista Distribution i USA den 22. november 1995 og i Europa den 22. mars 1996.";
		k.finnLokale(3).leggTilArrangement(new Arrangement("Film: Toy Story (1996)", pr.finnKontaktpersonViaTlf("12345678"), dato, beskrivelse, 100, 100));
		k.finnLokale(3).leggTilArrangement(new Arrangement("Film: Toy Story (1996)", pr.finnKontaktpersonViaTlf("12345678"), dato, beskrivelse, 100, 100));
		k.finnLokale(3).leggTilArrangement(new Arrangement("Film: Toy Story (1996)", pr.finnKontaktpersonViaTlf("12345678"), dato, beskrivelse, 100, 100));
		
		beskrivelse = "Behandlinjg av Kulturhusets budsjett og presentasjon av det nye IT-systemet";
		k.finnLokale(4).leggTilArrangement(new Arrangement("Kommunestyremøte nr. 15/08", pr.finnKontaktpersonViaTlf("22334455"), dato, beskrivelse));
		
		beskrivelse = "Styremøte i velforeningen Heisann";
		k.finnLokale(5).leggTilArrangement(new Arrangement("Styremøte i velforeningen Heisann", pr.finnKontaktpersonViaTlf("22334455"), dato, beskrivelse));
		
		beskrivelse = "Mannskoret Fjørnissene synger kjente og kjære nasjonalromantiske sanger";
		k.finnLokale(6).leggTilArrangement(new Arrangement("17. Mai-konsert", pr.finnKontaktpersonViaTlf("90099009"), dato, beskrivelse, 200, 300));
		
		beskrivelse = "Trude Bollerud leser fra den nye boken sin \"Vår i Bortibygda\"";
		k.finnLokale(7).leggTilArrangement(new Arrangement("Månedes forfatter", pr.finnKontaktpersonViaTlf("90099009"), dato, beskrivelse));
		
		//Bestiller billett
		k.bestillBillett(1, 15, new Person("Jan","Olsen","mail1@norge.no","20010001"));
		k.bestillBillett(2, 24, new Person("Knut","Jensen","mail2@norge.no","20010002"));
		k.bestillBillett(1, 17, new Person("Lene","Sæter","mail3@norge.no","20010003"));
		k.bestillBillett(3, 8, new Person("Ingrid","Korneliussen","mail4@norge.no","20010004"));
		
		return k;
	}
}
