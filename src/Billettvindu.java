import java.awt.*;

import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.imageio.ImageIO;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Billettvindu extends JApplet {
	
	private JLabel tomrom = new JLabel(" ");
	private JPanel top, lokvalg, arrvalg, billvalg, kundeinfo1, kundeinfo2, knapprad, tekstvindu;
	private JComboBox velgLokale, velgArrangement;
	private String[] lokalvalg, arrangementvalg;
	private JLabel antallL, fnavnL,enavnL,epostL,telefonL;
	private JTextField antall, fnavn, enavn, epost, telefon;
	private JButton bestillKnapp, avbestillKnapp;
	private JTextArea melding;
	private JScrollPane meldingsområde;

	private Kulturhus k;
	private ActionListener lytter;
	
	
	private String[] ekstraInput(){
		HashSet<String> a = new HashSet<>(Arrays.asList(k.lokalListe()));
		HashSet<String> b = new HashSet<>(Arrays.asList(lokalvalg));
		lokalvalg = k.lokalListe();
		a.removeAll(b);
		String[] ab = a.toArray(new String[a.size()]);
		return ab;
	}
	
	public Billettvindu(Kulturhus hus) {
		
		k = hus;
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		//TOP-PANEL START
		top = new JPanel();
		getContentPane().add(top, BorderLayout.NORTH);
		top.setLayout(new GridLayout(6, 1, 0, 0));
		
		//LOAKLEVELGER START
		lokvalg = new JPanel();
		top.add(lokvalg);
		lokvalg.setLayout(new GridLayout(1, 1, 0, 0));
		
		lokalvalg = k.lokalListe();
		velgLokale = new JComboBox<String>(lokalvalg);
		velgLokale.addActionListener(lytter);
		lokvalg.add(velgLokale);
		
		//LOAKLEVELGER SLUTT
		
		//ARRANGEMENTVELGER START
		arrvalg = new JPanel();
		top.add(arrvalg);
		arrvalg.setLayout(new GridLayout(1, 0, 0, 0));
		
		//arrangementvalg = MÅ LAGE METODE FOR ÅÅ HENTE UT ARRANGEMENT 
		velgArrangement = new JComboBox<String>(/*arrangementvalg*/);
		velgArrangement.addActionListener(lytter);
		arrvalg.add(velgArrangement);
		
		//ARRANGREMENTVELGER SLUTT
		
		//BILLETVALG START
		billvalg = new JPanel();
		top.add(billvalg);
		billvalg.setLayout(new GridLayout(1,4,0,0));
		
		antallL = new JLabel("Antall billetter");
		antall = new JTextField();
		
		billvalg.add(tomrom);
		billvalg.add(tomrom);
		billvalg.add(antallL);
		billvalg.add(antall);
		//BILLETVALG START
		
		//KUNDEINFO START
		
		kundeinfo1 = new JPanel();
		top.add(kundeinfo1);
		kundeinfo1.setLayout(new GridLayout(1,4,0,0));
		
		kundeinfo2 = new JPanel();
		top.add(kundeinfo2);
		kundeinfo2.setLayout(new GridLayout(1,4,0,0));
		
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
		//KUNDEINFO SLUTT
		
		//KNAPPERAD START
		knapprad = new JPanel();
		top.add(knapprad);
		knapprad.setLayout(new GridLayout(1, 2, 0, 0));
		
		bestillKnapp = new JButton("Bestill");
		bestillKnapp.addActionListener(lytter);
		knapprad.add(bestillKnapp);
		
		avbestillKnapp = new JButton("Avbestill");
		avbestillKnapp.addActionListener(lytter);
		knapprad.add(avbestillKnapp);
		
		//KNAPPERAD SLUTT
		//TOPP-PANEL SLUTT
		
		//MIDT-PANEL START
		tekstvindu = new JPanel();
		getContentPane().add(tekstvindu, BorderLayout.CENTER);
		tekstvindu.setLayout(new GridLayout(1, 1, 0, 0));
		
		melding = new JTextArea();
		meldingsområde = new JScrollPane(melding);
		melding.setEditable(false);
		melding.setMargin(new Insets(10,10,10,10));
		melding.setText("");
		tekstvindu.add(melding);
		
		//MIDT-PANEL SLUTT
		
		lytter = new Knappelytter();
		
	}
	
	private void bestill(){
		
		
		Lokale l = k.finnType((String)velgLokale.getSelectedItem());
		Arrangement a;//	LAG METODE FOR Å FINNE ARRANGEMENT
		String antallStr = antall.getText(); 
		String fnavnStr = fnavn.getText();
		String enavnStr = enavn.getText();
		String epostStr = epost.getText();
		String telefonStr = telefon.getText();
		String persOK = Valider.person(fnavnStr, enavnStr, epostStr, telefonStr);
		if(!persOK.equals(""))
			melding.setText(persOK);
		else if(!Valider.antall(antallStr))
			melding.setText("Antall billetter må være et tall mellom 1 og 99999999");
		else{
			Person k = new Person(fnavnStr,enavnStr,epostStr,telefonStr);
			//a.bestillBillett(Integer.parseInt(antallStr), k);
		}
		
	}
	
	public class Knappelytter implements ActionListener{
		
		public void actionPerformed( ActionEvent e ){
			if(e.getSource() == velgLokale){
				JComboBox cb = (JComboBox)e.getSource();
				
			}
			else if(e.getSource() == bestillKnapp){
				melding.setText("starter bestilling");
			}
			else if( e.getSource() == avbestillKnapp){
				melding.setText("starter avbestilling");
			}
		}
	}
}
