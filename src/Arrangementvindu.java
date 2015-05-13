import java.awt.*;

import javax.swing.*;

import java.util.*;

import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class Arrangementvindu extends JApplet {
	private static final long serialVersionUID = 1L;
	private JLabel placeholder;
	private JTextField kNavnFelt, kEpostFelt, kTlfFelt, navnFelt, beskFelt, prisFelt, refFelt,altFelt1,altFelt2,bildeNavnFelt;
	private JButton finnKnapp, slettKnapp, regKnapp, listeKnapp, kontaktKnapp, kontaktListeKnapp,bildeKnapp;
	private JTextArea tekstområde;
	private JScrollPane utskriftområde;
	private BorderLayout layout,centerLayout,centerPageStartLayout;
	private Container c;
	private GridLayout bottomGrid,topGrid,centerBot;
	public Kulturhus k;
	private JComboBox<String> lokalvelger,kontaktvelger;
	public Lokale l;
	public Arrangement a;
	public Bildehandler bildehandler;
	private JCheckBox checkbox;
	private EmptyBorder border;
	private StretchIcon bildeIcon;
	private String[] lokalvalg,kontaktvalg;
	private BufferedImage bilde = null;

	private String lokalnavn = "Valg";
	private JComponent north,south,center,centerLineEnd,centerPageStart,centerPageStartTopPanel;
	private JLabel bildeLabel, bildeContainer;
	
	private String[] ekstraInput() {
		HashSet<String> a = new HashSet<>(Arrays.asList(k.lokalListe()));
		HashSet<String> b = new HashSet<>(Arrays.asList(lokalvalg));
		lokalvalg = k.lokalListe();
		a.removeAll(b);
		String[] ab = a.toArray(new String[a.size()]);
		return ab;
	}
	
	private void addSpecificC(String l) {
		
		Lokale lok = k.finnType(l);
		
		if (l.equalsIgnoreCase("oppdater liste")) {
			north.setLayout(new GridLayout(7, 1)); // 5 rows 2 columns; no gaps);
			
			for (String s : ekstraInput()) {
				lokalvelger.addItem(s);
			}
			lokalvelger.revalidate();
			System.out.println(ekstraInput());
			north.add(new JLabel(""));
			north.add(new JLabel("Lokal-liste er oppdatert!"));
		}
		else if (lok instanceof Cafe) {
			north.setLayout(new GridLayout(7, 2)); // 5 rows 2 columns; no gaps);
			north.add(new JLabel(" Hvor mange gjester er det plass til: "));
			north.add(altFelt1);
		}
		else if (lok instanceof Konferanse) {
			north.setLayout(new GridLayout(8, 2)); // 6 rows 2 columns; no gaps);
			north.add(new JLabel(" Antall gjester det er plass til: "));
			north.add(altFelt1);
			north.add(new JLabel(" Hvilken type konferanse er det: "));
			north.add(altFelt2);
		}
		else if (lok instanceof Selskapslokale) {
		}
		else if (lok instanceof Scene) {
			north.setLayout(new GridLayout(7, 2)); // 5 rows 2 columns; no gaps);
			north.add(new JLabel(" Forestilling som skal holdes: "));
			north.add(altFelt1);
		}
		else if (lok instanceof Kino) {
			north.setLayout(new GridLayout(7, 2)); // 5 rows 2 columns; no gaps);
			north.add(new JLabel(" Ytterligere info: "));
			north.add(altFelt1);
		}
		else {
			System.out.println("Aner ikke hvorfor du endte opp her");
		}
	}
	
	private void repainter() {		
		north.add(new JLabel(" Referansenummer:"));
		north.add(refFelt);
		north.add(new JLabel(" Navn på arrangement:"));
		north.add(navnFelt);
		north.add(new JLabel(" Arrangementsbeskrivelse:"));
		north.add(beskFelt);
		north.add(new JLabel(" Velg type lokale:"));
		north.add(lokalvelger);
		north.add(new JLabel("Velg kontaktperson"));
		north.add(kontaktvelger);
	}
	
	
	public Arrangementvindu(Kulturhus kH) {
		
			k = kH;
			lokalvalg = k.lokalListe();
			kontaktvalg = k.listKontaktpersoner();
			System.out.println("Lokalvalg blir opprettet. Den inneholder " + lokalvalg.length);
			
			lokalvelger = new JComboBox<String>(lokalvalg);
			kontaktvelger = new JComboBox<String>(kontaktvalg);

			navnFelt = new JTextField( 18 );
			beskFelt = new JTextField( 18 );
			checkbox = new JCheckBox("Er arrangementet betalbart?");
			prisFelt = new JTextField( 18 ); 
			refFelt = new JTextField( 18 );
			altFelt1 = new JTextField( 18 );
			altFelt2 = new JTextField( 18 );
			kNavnFelt = new JTextField( 18 );
			kEpostFelt = new JTextField( 18 );
			kTlfFelt = new JTextField( 18 );
			bildeNavnFelt = new JTextField( 18 );
			placeholder = new JLabel(" ");
			border = new EmptyBorder(5,5,5,5);
			
			bildeNavnFelt.setEditable(false);
			bildeNavnFelt.setForeground(Color.BLACK);
			bildeNavnFelt.setMargin(new Insets(10,10,10,10));
			
			finnKnapp = new JButton("Finn arrangement.");
			slettKnapp = new JButton( "Slett arrangement" );
			regKnapp = new JButton( "Registrer arrangement" );
			listeKnapp = new JButton( "List arrangement" );
			kontaktKnapp = new JButton("Kontaktpersoninfo");
			kontaktListeKnapp = new JButton("List kontaktpersoner");
			bildeKnapp = new JButton("Last inn bilde");
			
			//////////////////////////////////////////
			/////////// GUI LAYOUT START /////////////
			
			layout = new BorderLayout(5, 5);
			centerLayout = new BorderLayout(5,5);
			centerPageStartLayout = new BorderLayout(6,5);
			
			bottomGrid = new GridLayout(1, 4);
			topGrid = new GridLayout(5, 2);
			centerBot = new GridLayout(1,1);
			


			
			// TOP GRID START
			north = new JPanel();
			north.setLayout(topGrid);
			north.add(new JLabel(" Referansenummer:"));
			north.add(refFelt);
			north.add(new JLabel(" Navn:"));
			north.add(navnFelt);
			north.add(new JLabel(" Beskrivelse:"));
			north.add(beskFelt);
			north.add(new JLabel(" Velg type lokale:"));
			north.add(lokalvelger);
			north.add(new JLabel("Velg kontaktperson"));
			north.add(kontaktvelger);
			north.setBorder(border);
			// TOP GRID END
			
			// CENTER GRID START

			center = new JPanel();
			centerLineEnd = new JPanel();
			centerPageStartTopPanel = new JPanel();
			
			centerPageStart = new JPanel();
			center.setBorder(new EmptyBorder(0,0,5,5));
			
			center.setLayout(centerLayout);
			centerLineEnd.setLayout(centerBot);
			centerPageStart.setLayout(centerPageStartLayout);
			centerPageStartTopPanel.setLayout(new GridLayout(2,2));
			
			bildeContainer = new JLabel();
      		bildeIcon = new StretchIcon("");
      		bildeLabel = new JLabel(bildeIcon);
      		centerPageStart.add(bildeLabel,BorderLayout.CENTER);

			centerPageStartTopPanel.add(bildeKnapp);
			centerPageStartTopPanel.add(bildeNavnFelt);

			tekstområde = new JTextArea();
			utskriftområde = new JScrollPane(tekstområde);
			tekstområde.setEditable(false);
			utskriftområde.setForeground(Color.BLACK);
			tekstområde.setMargin(new Insets(10,10,10,10));
			
			centerPageStart.add(centerPageStartTopPanel,BorderLayout.PAGE_START);
			
			
			center.add(utskriftområde, BorderLayout.CENTER);
			center.add(centerLineEnd, BorderLayout.PAGE_END);
			center.add(centerPageStart,BorderLayout.LINE_START);
			centerLineEnd.add(checkbox,placeholder);
			

			// CENTER GRID END
			
			//BOTTOM GRID START
			south = new JPanel();
			south.setLayout(bottomGrid);
			south.add(finnKnapp);
			south.add(slettKnapp);
			south.add(regKnapp);
			south.add(listeKnapp);
			// BOTTOM GRID END
			
			c = getContentPane();
			c.setLayout(layout);
			c.add(north, BorderLayout.PAGE_START);
			c.add(center, BorderLayout.CENTER);
			c.add(south, BorderLayout.PAGE_END);
			
			/////////// GUI LAYOUT SLUTT /////////////
			//////////////////////////////////////////
				
			
	
			Knappelytter lytter = new Knappelytter();
			Typelytter tLytter = new Typelytter();
			
			finnKnapp.addActionListener( lytter );
			slettKnapp.addActionListener( lytter );
			regKnapp.addActionListener( lytter );
			lokalvelger.addActionListener( lytter );
			listeKnapp.addActionListener(lytter);
			bildeKnapp.addActionListener(lytter);			
			
			checkbox.addItemListener(tLytter);
			
			setSize( 550, 500 );
			setVisible( true );
		}
	
	
    private class Typelytter implements ItemListener
    {
      public void itemStateChanged( ItemEvent e )
      {
    	  if ( checkbox.isSelected() ) {
    		  try {
    			System.out.println("checkbox trykket på");
    	 		centerLineEnd.remove(placeholder);
    	 		centerLineEnd.revalidate();
    	 		centerLineEnd.repaint();
    	 		centerLineEnd.add(prisFelt);
    	 		centerLineEnd.revalidate();
    	 		centerLineEnd.repaint();
    		  } catch(Exception ex) {
    			  tekstområde.setText("Her oppsto det en feil gitt.");
    		  }
    	 } else {
    		 try {
     			System.out.println("checkbox trykket av");
     			centerLineEnd.remove(prisFelt);
     			centerLineEnd.revalidate();
     			centerLineEnd.repaint();
     			centerLineEnd.add(placeholder);
     			centerLineEnd.revalidate();
     			centerLineEnd.repaint();
     		  } catch(Exception ex) {
     			  tekstområde.setText("Her oppsto det en feil gitt.");
     		  }
    	 }
      }
    }
    
    
	private class Knappelytter implements ActionListener
	  {
	    public void actionPerformed( ActionEvent e )
	    {
	    	// Legger til arrangement
	      if ( e.getSource() == regKnapp ) {
	    	  try {
	    		  String navn = navnFelt.getText();
	    		  String besk = beskFelt.getText();
	    		  if (navn.equals("") || besk.equals("")) {
	    			  tekstområde.setText("Du må fylle ut navn og beskrivelse.");
	    			  return;
	    		  }
	    		  String lokNavn = (String) lokalvelger.getSelectedItem();
	    		  System.out.println(lokNavn);
	    		  String kontaktNavn = (String) kontaktvelger.getSelectedItem();
	    		  Lokale lokale = k.finnType(lokNavn);
	    		  if (!lokNavn.equalsIgnoreCase("oppdater liste")){
	    			  if (!bildeNavnFelt.equals("")) {
	    				  String bildenavn = navn+"_"+"bilde.png";
	    				  try {
	    					    File outputfile = new File(bildenavn);
	    					    ImageIO.write(bilde, "png", outputfile);
	    			    		Kontaktperson kontakt = k.finnKontaktpersonViaNavn(kontaktNavn);
	    			    		Arrangement arr = new Arrangement(navn,kontakt,bildenavn);
	    			    		lokale.leggTilArrangement(arr);
	    			    		tekstområde.setText("Arrangementet ble opprettet!\r\nLykke til med " + arr.get_Navn());
	    			    		return;
	    					} catch (IOException ex) {
	    					    tekstområde.setText("Vi kunne ikke bruke dette bilde, noe gikk galt");
	    					}
  			    		Kontaktperson kontakt = k.finnKontaktpersonViaNavn(kontaktNavn);
  			    		Arrangement arr = new Arrangement(navn,kontakt,bildenavn);
  			    		lokale.leggTilArrangement(arr);
	    			  }
	    		  } else {
	    			  tekstområde.setText("Velg hvilket lokale det skal holdes på!");
	    			  return;
	    		  }
	    		  
	    	  } catch (Exception ex) {
	    		  tekstområde.setText("Det oppsto en feil, vennligst prøv på nytt" + e.getClass());
	    	  }
	      }

	      else if ( e.getSource() == slettKnapp ) {
	    	  if (refFelt.getText().equals("")) {
	    		  tekstområde.setText("Du må bruke referansenummer for å slette.");
	    		  
	    	  } else {
				try {
					int refNr = Integer.parseInt(refFelt.getText());
					Lokale lokFunnet = k.arrangementViaK(refNr);
					if (lokFunnet != null) {
						Object[] options = {"Ja",
						                    "Avbryt",};
						int n = JOptionPane.showOptionDialog(null,
						    "Er du sikker på at du vil slette dette arrangement?",
						    "Advarsel",
						    JOptionPane.OK_CANCEL_OPTION,
						    JOptionPane.WARNING_MESSAGE,
						    null,
						    options,
						    options[0]);
						if (n == 1) {
							tekstområde.setText("Arrangementet ble ikke slettet");
							return;
						}
					}
					Arrangement arrFunnet = lokFunnet.finnArrangement(refNr);
					if (lokFunnet.slettArrangement(refNr)) {
						tekstområde.setText("Arrangement med navn "
								+ arrFunnet.get_Navn() + " og referanse "
								+ arrFunnet.get_aId()
								+ " er slettet fra kulturhuset.");
					} else {
						tekstområde
								.setText(" Kunne ikke slette arrangement nr. "
										+ refNr + " siden det har solgt billetter, eller ikke finnes. ");
					}
				} catch (Exception ex) {
					tekstområde.setText("En feil har oppstått, prøv igjen.");
				}
	    	  }
	      }
	      else if ( e.getSource() == listeKnapp ) {
	    	  System.out.println("Knappen er trykket og jeg ber om k.listArrangementer.");
	    	  	tekstområde.setText(k.listArrangementerILokaler());
	      }
	      else if ( e.getSource() == finnKnapp ) {
	    	  try {
	    		  int refNr = Integer.parseInt(refFelt.getText());
					Lokale lokFunnet = k.arrangementViaK(refNr);
					if (lokFunnet != null) {
						Arrangement arrFunnet = lokFunnet.finnArrangement(refNr);
						tekstområde.setText(arrFunnet.toString());
					}
	    	  } catch(Exception ex) {
	    		  tekstområde.setText("Fant ikke Arrangement med dette referansenummer.");
	    	  }
	      }
	      else if ( e.getSource() == bildeKnapp ) {
	    	  try {
	      		bildehandler = new Bildehandler();
	      		File bildeFil = bildehandler.hentFil();
	      		bilde = ImageIO.read(bildeFil);
	      		bildeIcon.setImage(bilde);
	      		bildeNavnFelt.setText(bildeFil.getName());
	    	  } catch(Exception ex) {
	    		  tekstområde.setText("Noe gikk galt.");
	    	  }
	      }
	      
		    int n = lokalvelger.getSelectedIndex();
		    lokalnavn = lokalvelger.getItemAt(n);
		    System.out.println(lokalnavn);
		    
		    north.removeAll();
		    north.revalidate();
		    north.repaint();
		    repainter();
			c.add(north, BorderLayout.PAGE_START);
			addSpecificC(lokalnavn);
			c.add(center, BorderLayout.CENTER);
			c.add(south, BorderLayout.PAGE_END);
		    c.revalidate();
		    c.repaint();
	    }
	  }
}

/*
 * 
 * MÅ LAGE EN NY GREIE FOR KONTAKTPERSONEN
 * 
 * 
			centerPageStartTopPanel.add(new JLabel("Kontaktperson"));
			centerPageStartTopPanel.add(new JLabel(""));
			centerPageStartTopPanel.add(new JLabel("Navn:"));
			centerPageStartTopPanel.add(kNavnFelt);
			centerPageStartTopPanel.add(new JLabel("Epost:"));
			centerPageStartTopPanel.add(kEpostFelt);
			centerPageStartTopPanel.add(new JLabel("Telefon:"));
			centerPageStartTopPanel.add(kTlfFelt);
 */
