import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;



public class Billettvindu extends JApplet {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel tomrom = new JLabel(" ");
	private JPanel top, lokvalg, arrvalg, billvalg, kundeinfo1, kundeinfo2, knapprad, tekstvindu;
	private JComboBox<String> velgLokale, velgArrangement;
	private String[] lokalvalg, arrangementvalg;
	private JLabel antallL, fnavnL,enavnL,epostL,telefonL;
	private JTextField antall, fnavn, enavn, epost, telefon;
	private JButton bestillKnapp, avbestillKnapp, søkKnapp;
	private JTextArea melding;
	private JScrollPane meldingsområde;

	private Kulturhus k;
	private ActionListener lytter;

	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Billettvindu(Kulturhus hus) {
		
		k = hus;
		lytter = new Knappelytter();
		
		/////////////////////////////
		/////	SETTER OPP GUI	/////
		/////////////////////////////
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		/////////////////////////////////////
		/////		TOP-PANEL START		/////
		
		top = new JPanel();
		getContentPane().add(top, BorderLayout.NORTH);
		top.setLayout(new GridLayout(6,1));
		
			/////	LOKALEVELGER START	/////
		
			lokvalg = new JPanel();
			top.add(lokvalg);
			lokvalg.setLayout(new GridLayout(1,1));
			
			//lokalvalg = k.lokalListe();
			lokalvalg = k.lokaleCombo();
			velgLokale = new JComboBox<String>(lokalvalg);
			velgLokale.addActionListener(lytter);
			lokvalg.add(velgLokale);
					
			/////	LOKALEVELGER SLUTT	/////
		
		
			/////	ARRANGEMENTVELGER START	/////
		
			arrvalg = new JPanel();
			top.add(arrvalg);
			arrvalg.setLayout(new GridLayout(1,1));
			
			arrangementvalg = k.arrangementCombo(velgLokale.getSelectedIndex()); 
			velgArrangement = new JComboBox<String>(arrangementvalg);
			velgArrangement.addActionListener(lytter);
			arrvalg.add(velgArrangement);
			
			/////	ARRANGEMENTVELGER SLUTT	/////
		
		
			/////	BILLETVALG START	/////
			
			billvalg = new JPanel();
			top.add(billvalg);
			billvalg.setLayout(new GridLayout(1,4));
			
			antallL = new JLabel("Antall billetter");
			antall = new JTextField();
			
			billvalg.add(tomrom);
			billvalg.add(tomrom);
			billvalg.add(antallL);
			billvalg.add(antall);
			
			/////	BILLETVALG START	/////
			
		
			/////	KUNDEINFO START	/////
		
			kundeinfo1 = new JPanel();
			top.add(kundeinfo1);
			kundeinfo1.setLayout(new GridLayout(1,4));
			
			kundeinfo2 = new JPanel();
			top.add(kundeinfo2);
			kundeinfo2.setLayout(new GridLayout(1,4));
			
			fnavnL = new JLabel("Fornavn:");
			kundeinfo1.add(fnavnL);
			fnavn = new JTextField();
			kundeinfo1.add(fnavn);
			
			enavnL = new JLabel("Etternavn:");
			kundeinfo1.add(enavnL);
			enavn = new JTextField();
			kundeinfo1.add(enavn);
			
			epostL = new JLabel("Epost:");
			kundeinfo2.add(epostL);
			epost = new JTextField();
			kundeinfo2.add(epost);
			
			telefonL = new JLabel("Telefon:");
			kundeinfo2.add(telefonL);
			telefon = new JTextField();
			kundeinfo2.add(telefon);
			
			/////	KUNDEINFO START	/////
		
		
			/////	KNAPPERAD START	/////
		
			knapprad = new JPanel();
			top.add(knapprad);
			knapprad.setLayout(new GridLayout(1,3));
			
			bestillKnapp = new JButton("Bestill");
			bestillKnapp.addActionListener(lytter);
			knapprad.add(bestillKnapp);
			
			
			avbestillKnapp = new JButton("Avbestill");
			avbestillKnapp.addActionListener(lytter);
			knapprad.add(avbestillKnapp);
			
			søkKnapp = new JButton("Søk på billetter");
			søkKnapp.addActionListener(lytter);
			knapprad.add(søkKnapp);
			
		
		
			/////	KNAPPERAD START	/////
		
		/////		TOP-PANEL SLUTT		/////
		/////////////////////////////////////
		
		/////////////////////////////////////
		/////		MIDT-PANEL START	/////
		
		tekstvindu = new JPanel();
		getContentPane().add(tekstvindu, BorderLayout.CENTER);
		tekstvindu.setLayout(new GridLayout(1,1));
		
			/////	MELDINGSVINDU START	/////
		
			melding = new JTextArea();
			meldingsområde = new JScrollPane(melding);
			melding.setEditable(false);
			melding.setMargin(new Insets(10,10,10,10));
			melding.setText("");
			tekstvindu.add(melding);
			
			/////	MELDINGSVINDU SLUTT	/////
		
		/////		MIDT-PANEL SLUTT	/////
		/////////////////////////////////////
	}
	
	
	//////////////////////
	//	METODER START	//
	//////////////////////
	
	public void repainter(int lokNr){
		top.add(lokvalg);
			lokvalg.add(velgLokale);
			velgLokale.setSelectedIndex(lokNr);
		top.add(arrvalg);
			arrvalg.add(velgArrangement);
		top.add(billvalg);
			billvalg.add(tomrom);
			billvalg.add(tomrom);
			billvalg.add(antallL);
			billvalg.add(antall);
		top.add(kundeinfo1);
			kundeinfo1.add(fnavnL);
			kundeinfo1.add(fnavn);
			kundeinfo1.add(enavnL);
			kundeinfo1.add(enavn);
		top.add(kundeinfo2);
			kundeinfo2.add(epostL);
			kundeinfo2.add(epost);
			kundeinfo2.add(telefonL);
			kundeinfo2.add(telefon);
		top.add(knapprad);
			knapprad.add(bestillKnapp);
			knapprad.add(avbestillKnapp);
			knapprad.add(søkKnapp);
	}
	
	//Henter infomasjon fra input og validerer den før bestilling legges inn.
	private void bestill(){
		System.out.println("Starter bstilling()");
		//henter lokale fra combobox
		
		//LEGG INN SJEKK PÅ AT LOKALE ER VALGT
		Lokale l = k.finnType((String)velgLokale.getSelectedItem());
		
		//henter arrangement fra combobox
		
		//LEGG INN SJEKK PÅ AT LOKALE ER VALGT
		Arrangement a;//	LAG METODE FOR Å FINNE ARRANGEMENT
		
		//henter personinfo fra textfelt
		String antallStr = antall.getText(); 
		String fnavnStr = fnavn.getText();
		String enavnStr = enavn.getText();
		String epostStr = epost.getText();
		String telefonStr = telefon.getText();
		if(antallStr.equals("") || fnavnStr.equals("") || enavnStr.equals("") || epostStr.equals("") || telefonStr.equals("")){
			melding.setText("Vennligst fyll ut alle feltene.");
			System.out.println("Tomme felter");
			return;
		}
		//validerer innputdata
		String persOK = Valider.person(fnavnStr, enavnStr, epostStr, telefonStr);
		
		//Sjekker at validering gikk bra
		if(!persOK.equals("")){
			melding.setText(persOK);
			return;
		}else if(!Valider.antall(antallStr)){
			melding.setText("Antall billetter må være et tall mellom 1 og 99999999");
			return;
		}else{
			//oppretter person og bestiller billett
			Person k = new Person(fnavnStr,enavnStr,epostStr,telefonStr);
			System.out.println("Lagrer bestilling");
			//a.bestillBillett(Integer.parseInt(antallStr), k);
		}
	}
	
	//Hneter informasjon fra input og valderer før bestilling fjernes
	private void avbestill(){
		System.out.println("Starter avbestilling");
		//henter lokale fra combobox
		Lokale l = k.finnType((String)velgLokale.getSelectedItem());
		
		//henter arrangement fra combobox
		Arrangement a;//	LAG METODE FOR Å FINNE ARRANGEMENT
		
		//henter personinfo fra textfelt
		String antallStr = antall.getText(); 
		String telefonStr = telefon.getText();
		
		if(antallStr.equals("") || telefonStr.equals("")){
			melding.setText("Vennligst oppgi antall billetter og telefonnr");
			System.out.println("Tomme felter");
		}

		//Validerer input
		else if(!Valider.antall(antallStr)){
			melding.setText("Antall billetter må være et tall mellom 1 og 99999999");
		}else if(!Valider.telefon(telefonStr)){
			melding.setText("Oppgi et gyldig telefonnr\r\n");
		}else{
			System.out.println("Avbestiller billett");
			//LEGGE INN EN "Er du sikker?"-PROMT
			//a.avbestillBillett(Integer.parseInt(antallStr), telefonStr);
			//FIKSE FEEDBACK TIL BRUKER:
			// "Disse Billetter til Arragnement ble slettet"
		}
	}
	
	//Viser alle billetter tilknyttet et telefonnr
	private void søk(){
		System.out.println("Starter søk");
		
		String telefonStr = telefon.getText();
		
		if(telefonStr.equals("")){
			System.out.println("Tomme felter");
			melding.setText("Vennligst fyll ut telefonnr");
		}else if(!Valider.telefon(telefonStr)){
			melding.setText("Oppgi et gyldig telefonnr\r\n");
		}else{
			System.out.println("Søker opp Billetter");
			//LAGE METODE FOR Å LISTE UT BILLETTER
			//melding.setText(k.finnBiletter(telefonStr));
		}
		
	}
	
	//////////////////////
	//	METODER SLUTT	//
	//////////////////////
	
	public class Knappelytter implements ActionListener{
		
		public void actionPerformed( ActionEvent e ){
			if(e.getSource() == velgLokale){
				int lokNr = velgLokale.getSelectedIndex();
				System.out.println("Lokale valgt: " + lokNr + ": " + velgLokale.getSelectedItem());
				System.out.println(k.finnLokale(lokNr).toString());
				top.removeAll();
				top.revalidate();
				top.repaint();
				repainter(lokNr);
				getContentPane().add(top,BorderLayout.NORTH);
			}
			else if(e.getSource() == bestillKnapp){
				bestill();
			}
			else if( e.getSource() == avbestillKnapp){
				avbestill();
			}
			else if( e.getSource() == søkKnapp){
				søk();
			}
		}
	}

}
