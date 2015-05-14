import java.awt.*;

import javax.swing.*;

import java.util.*;

import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Oversiktsvindu extends JApplet {
	
	private static final long serialVersionUID = 1L; //hva skal jeg sette her?
	
	//private JTextField søk;
	private JButton søkKnp, tilbake;
	private JTextArea resultat;
	private JScrollPane resultatVisning;
	private BorderLayout layout, centerLayout, centerPageStartLayout;
	private Container c;
	private GridLayout bottomGrid, topGrid,centerBot;
	public Kulturhus k;
	private JComboBox<String> lokalvelger;
	public Lokale l;
	public Arrangement a;
	public Bildehandler bildehandler;
	private EmptyBorder border;
	private StretchIcon bildeIcon;
	private String[] lokalvalg;
	private BufferedImage bilde = null;
	
	private String lokalnavn = "Valg";
	private JComponent north,south,center,centerLineEnd,centerPageStart,centerPageStartTopPanel;
	private JLabel bildeLabel, bildeContainer;
	
	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Oversiktsvindu(Kulturhus hus){
		
		k = hus;
		lokalvalg = k.lokalListe();
		lokalvelger = new JComboBox<String>(lokalvalg);
		
		søkKnp = new JButton("Søk etter arrangement");
		tilbake = new JButton("Tilbake");
		border = new EmptyBorder(5,5,5,5);
		
		//LAYOUT START
		
		layout = new BorderLayout(5,5);
		centerLayout = new BorderLayout(5,5);
		centerPageStartLayout = new BorderLayout(6,5);
		
		bottomGrid = new GridLayout(1,1);
		topGrid = new GridLayout(1,3);
		centerBot = new GridLayout(1,1);
		
		//TOPP GRID START
		north = new JPanel();
		north.setLayout(topGrid);
		north.add(new JLabel("Velg lokale:"));
		north.add(lokalvelger);
		north.add(søkKnp);
		north.setBorder(border);
		//TOPP GRID SLUTT
		
		//CENTER GRID START
		center = new JPanel();
		centerLineEnd = new JPanel();
		centerPageStartTopPanel = new JPanel();
		
		centerPageStart = new JPanel();
		center.setBorder(new EmptyBorder(0,0,5,5));
		
		center.setLayout(centerLayout);
		centerLineEnd.setLayout(centerBot);
		centerPageStart.setLayout(centerPageStartLayout);
		centerPageStartTopPanel.setLayout(new GridLayout(2,2));
		
//		bildeContainer = new JLabel();
//		bildeIcon = new StretchIcon("");
//		bildeLabel = new JLabel(bildeIcon);
//		centerPageStart.add(bildeLabel,BorderLayout.CENTER);
		
		resultat = new JTextArea();
		resultatVisning = new JScrollPane(resultat);
		resultat.setEditable(false);
		resultatVisning.setForeground(Color.BLACK);
		resultat.setMargin(new Insets(10,10,10,10));
		
		centerPageStart.add(centerPageStartTopPanel,BorderLayout.PAGE_START);
		
		center.add(resultatVisning, BorderLayout.CENTER);
		center.add(centerLineEnd, BorderLayout.PAGE_END);
		center.add(centerPageStart,BorderLayout.LINE_START);
		
		//CENTER GRID SLUTT
		
		//BOTTOM GRID START
		
		south = new JPanel();
		south.setLayout(bottomGrid);
		south.add(tilbake);
		
		//BOTTOM GRID SLUTT
		
		c = getContentPane();
		c.setLayout(layout);
		c.add(north, BorderLayout.PAGE_START);
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.PAGE_END);
		
		//LAYOUT SLUTT
		
		Knappelytter klytter = new Knappelytter();
		
		søkKnp.addActionListener( klytter );
		tilbake.addActionListener( klytter );
		
		setSize(550,500);
		setVisible(true);
	}
	
	
	
	public class Knappelytter implements ActionListener{
		public void actionPerformed( ActionEvent e){
			//søker opp Arrangement
			if(e.getSource() == søkKnp){
				String lokalenavn = (String)lokalvelger.getSelectedItem();
				String a = k.listArrangement(lokalenavn);
				resultat.setText(a);
				//resultat.setText(lokalenavn);
				System.out.println(k.totatlString());
				return;
			}
			else if( e.getSource() == tilbake){
				
				resultat.setText("Går tilbake til defaultvisning");
			}
			else{
				resultat.setText("Banan!");
			}
		}
	}
}
