import java.awt.*;

import javax.swing.*;

import java.util.*;

import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class Kontaktvindu extends JApplet {
	private static final long serialVersionUID = 1L;
	private JLabel placeholder;
	private JTextField fornavnFelt, etternavnFelt, epostFelt,tlfFelt,bildeNavnFelt;
	private JButton finnKnapp, slettKnapp, regKnapp, listeKnapp, bildeKnapp;
	private JTextArea tekstomr�de;
	private JScrollPane utskriftomr�de;
	private BorderLayout layout,leftBorder,leftBottomBorder;
	private Container c;
	private Personregister reg;
	private GridLayout leftGridTop,leftGridBottom,rightGrid,bottomGrid,leftGrid;
	public Bildehandler bildehandlerK;
	private JCheckBox checkbox;
	private EmptyBorder border;
	private StretchIcon bildeIconK;
	private String[] kontaktvalg;
	private BufferedImage bilde = null;
	private Boolean kunMedArr;

	private JComponent leftTop, leftBottom, right, bottom,leftSplit;
	private JLabel bildeLabelK;
	
	
	/*private void repainter() {	// Maler opp grunnelementer p� GUI ved behov ( removeAll() )	
		north.add(new JLabel(" Referansenummer:"));
		north.add(refFelt);
		north.add(new JLabel(" Navn p� arrangement:"));
		north.add(navnFelt);
		north.add(new JLabel(" Arrangementsbeskrivelse:"));
		north.add(beskFelt);
		north.add(new JLabel(" Velg type lokale:"));
		north.add(lokalvelger);
		north.add(new JLabel("Velg kontaktperson"));
		north.add(kontaktvelger);
	}*/
	
	
	public Kontaktvindu() {

			fornavnFelt = new JTextField( 18 );
			etternavnFelt = new JTextField( 18 );
			epostFelt = new JTextField( 18 );
			tlfFelt = new JTextField( 18 );
			
			checkbox = new JCheckBox("Kun kontaktpersoner med ansvar");

			bildeNavnFelt = new JTextField( 18 );
      		bildeIconK = new StretchIcon("");
      		bildeLabelK = new JLabel(bildeIconK);
			placeholder = new JLabel(" ");
			border = new EmptyBorder(5,5,5,5);
			
			bildeNavnFelt.setEditable(false);
			bildeNavnFelt.setForeground(Color.BLACK);
			bildeNavnFelt.setMargin(new Insets(10,10,10,10));
			
			finnKnapp = new JButton(" Finn kontaktperson.");
			slettKnapp = new JButton( " Slett kontaktperson" );
			regKnapp = new JButton( " Registrer kontaktperson" );
			listeKnapp = new JButton( " List kontaktpersoner" );
			bildeKnapp = new JButton(" Last inn bilde");
			
			//////////////////////////////////////////
			/////////// GUI LAYOUT START /////////////
			
			// DECLARATIONS START
			layout = new BorderLayout(5, 5);
			leftGrid = new GridLayout(2,1);
			leftBottomBorder = new BorderLayout(5,5);
			leftGridTop = new GridLayout(2, 1);
			leftGridBottom = new GridLayout(2, 1);
			rightGrid = new GridLayout(5, 2);
			bottomGrid = new GridLayout(1,4);
			// DECLARATIONS END
			
			// LEFT PANEL START
			leftSplit = new JPanel();
			leftSplit.setLayout(leftGrid);
			leftBottom = new JPanel();
			leftBottom.setLayout(leftBottomBorder);

			JPanel ekstra = new JPanel();
			ekstra.setLayout(new GridLayout(2,1));
			

			
			ekstra.add(bildeKnapp);
			ekstra.add(bildeNavnFelt);
			
			leftBottom.add(ekstra,BorderLayout.PAGE_START);
			leftBottom.add(checkbox,BorderLayout.CENTER);
			
			leftSplit.add(bildeLabelK,BorderLayout.CENTER);
			leftSplit.add(leftBottom,BorderLayout.PAGE_END);
			// LEFT PANEL END
			
			// RIGHT PANEL START
			right = new JPanel();
			right.setLayout(rightGrid);
			right.add(new JLabel(" Fornavn:"));
			right.add(fornavnFelt);
			right.add(new JLabel(" Etternavn:"));
			right.add(etternavnFelt);
			right.add(new JLabel(" Telefon:"));
			right.add(tlfFelt);
			right.add(new JLabel(" Epost:"));
			right.add(epostFelt);
			// RIGHT PANEL END
			
			// BOTTOM PANEL START
			bottom = new JPanel();
			bottom.setLayout(bottomGrid);
			bottom.add(finnKnapp);
			bottom.add(slettKnapp);
			bottom.add(regKnapp);
			bottom.add(listeKnapp);
			// BOTTOM PANEL END
			
			// CENTER TEXT PANEL START
			tekstomr�de = new JTextArea();
			utskriftomr�de = new JScrollPane(tekstomr�de);
			tekstomr�de.setEditable(false);
			utskriftomr�de.setForeground(Color.BLACK);
			tekstomr�de.setMargin(new Insets(10,10,10,10));
			// CENTER TEXT PANEL END
			
			c = getContentPane();
			c.setLayout(layout);
			c.add(new JLabel("Kontaktperson: <- La oss pr�ve � pynte denne tittelen knis"), BorderLayout.PAGE_START);
			c.add(leftSplit, BorderLayout.LINE_START);
			c.add(right, BorderLayout.PAGE_START);
			c.add(utskriftomr�de, BorderLayout.CENTER);
			c.add(bottom,BorderLayout.PAGE_END);
			
			/////////// GUI LAYOUT SLUTT /////////////
			//////////////////////////////////////////
				
			
	
			Knappelytter lytter = new Knappelytter();
			Typelytter tLytter = new Typelytter();
			
			finnKnapp.addActionListener( lytter );
			slettKnapp.addActionListener( lytter );
			regKnapp.addActionListener( lytter );
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
    			  kunMedArr = true;

    		  } catch(Exception ex) {
    			  tekstomr�de.setText("Her oppsto det en feil gitt.");
    		  }
    	 } else {
    		 try {
   			  kunMedArr = false;
     		  } catch(Exception ex) {
     			  tekstomr�de.setText("Her oppsto det en feil gitt.");
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
	    		  String fornavn = fornavnFelt.getText();
	    		  String etternavn = etternavnFelt.getText();
	    		  String tlf = tlfFelt.getText();
	    		  String epost = epostFelt.getText();

	    		  if (fornavn.equals("") || etternavn.equals("") || tlf.equals("") || epost.equals("")) {
	    			  tekstomr�de.setText("Du m� fylle ut alle feltene for � registrere en kontaktperson ( bilde kan v�re tomt ).");
	    			  return;
	    		  }
	    			  if (!bildeNavnFelt.equals("")) {
	    				  String bildenavn = fornavn+"_"+tlf+"_"+"bilde.png";
	    				  try {
	    					    File outputfile = new File(bildenavn);
	    					    ImageIO.write(bilde, "png", outputfile);
	    				    	Kontaktperson kontakt = new Kontaktperson(fornavn,etternavn,epost,tlf,bildenavn);
	    				    	reg.leggTilKontaktperson(kontakt);
	    			    		return;
	    					} catch (IOException ex) {
	    					    tekstomr�de.setText("Vi kunne ikke bruke dette bilde, noe gikk galt");
	    					}
	    			  }
			    Kontaktperson kontakt = new Kontaktperson(fornavn,etternavn,epost,tlf);
			    reg.leggTilKontaktperson(kontakt);  		  
	    	  } catch (Exception ex) {
	    		  tekstomr�de.setText("Det oppsto en feil, vennligst pr�v p� nytt" + e.getClass());
	    	  }
	      }

	      else if ( e.getSource() == slettKnapp ) {
	    	  if (tlfFelt.getText().equals("") && epostFelt.getText().equals("")) {
	    		  tekstomr�de.setText("Du m� bruke telefonnummer eller epost for � slette.");  
	    	  } else {
	    		  if (!tlfFelt.getText().equals("")) {
	  				try {
						String refNr = tlfFelt.getText();
						Kontaktperson kontaktFunnet = reg.finnKontaktpersonViaTlf(refNr);
						if (kontaktFunnet != null) {
							Object[] options = {"Ja",
							                    "Avbryt",};
							int n = JOptionPane.showOptionDialog(null,
							    "Er du sikker p� at du vil slette denne kontaktpersonen?",
							    "Advarsel",
							    JOptionPane.OK_CANCEL_OPTION,
							    JOptionPane.WARNING_MESSAGE,
							    null,
							    options,
							    options[0]);
							if (n == 1) {
								tekstomr�de.setText("Kontaktpersonen ble ikke slettet");
								return;
							}
						}
						if (reg.slettKontaktpersonViaTelefon(refNr)) {
							tekstomr�de.setText("Arrangement med navn "
									+ kontaktFunnet.get_Navn() + " og telefonnummer / referanse "
									+ kontaktFunnet.get_Telefon()
									+ " er slettet fra kulturhuset.");
						} else {
							tekstomr�de
									.setText(" Kunne ikke slette "
											+ kontaktFunnet.get_Navn() + " siden systemet v�rt er for d�rlig. :(");
						}
					} catch (Exception ex) {
						tekstomr�de.setText("En feil har oppst�tt, pr�v igjen.");
					}
	    			  
	    		  } else if (!epostFelt.getText().equals("")) {
		  				try {
							String refNr = epostFelt.getText();
							Kontaktperson kontaktFunnet = reg.finnKontaktpersonViaEpost(refNr);
							if (kontaktFunnet != null) {
								Object[] options = {"Ja",
								                    "Avbryt",};
								int n = JOptionPane.showOptionDialog(null,
								    "Er du sikker p� at du vil slette denne kontaktpersonen?",
								    "Advarsel",
								    JOptionPane.OK_CANCEL_OPTION,
								    JOptionPane.WARNING_MESSAGE,
								    null,
								    options,
								    options[0]);
								if (n == 1) {
									tekstomr�de.setText("Kontaktpersonen ble ikke slettet");
									return;
								}
							}
							if (reg.slettKontaktpersonViaTelefon(refNr)) {
								tekstomr�de.setText("Arrangement med navn "
										+ kontaktFunnet.get_Navn() + " og epost / referanse "
										+ kontaktFunnet.get_Epost()
										+ " er slettet fra kulturhuset.");
							} else {
								tekstomr�de
										.setText(" Kunne ikke slette "
												+ kontaktFunnet.get_Navn() + " siden systemet v�rt er for d�rlig. :(");
							}
						} catch (Exception ex) {
							tekstomr�de.setText("En feil har oppst�tt, pr�v igjen.");
						}
	    	  }
	    	}
	      }
	      else if ( e.getSource() == listeKnapp ) {
	    	  	tekstomr�de.setText(reg.toString());
	      }
	      else if ( e.getSource() == finnKnapp ) {
	    	  if (tlfFelt.getText().equals("") && epostFelt.getText().equals("")) {
	    		  tekstomr�de.setText("Du m� bruke telefonnummer eller epost for � finne en kontaktperson.");  
	    	  } else {
	    		  if (!tlfFelt.getText().equals("")) {
	    			  tekstomr�de.setText(reg.finnKontaktpersonViaTlf(tlfFelt.getText()).toString());
	    		  } else if (!epostFelt.getText().equals("")) {
	    			  tekstomr�de.setText(reg.finnKontaktpersonViaEpost(epostFelt.getText()).toString());
	    		  }
	    	  }
	      }
	      else if ( e.getSource() == bildeKnapp ) {
	    	  try {
	      		bildehandlerK = new Bildehandler();
	      		File bildeFil = bildehandlerK.hentFil();
	      		bilde = ImageIO.read(bildeFil);
	      		bildeIconK.setImage(bilde);
	      		bildeNavnFelt.setText(bildeFil.getName());
	      		bildeLabelK.repaint();
	      		
	    	  } catch(Exception ex) {
	    		  tekstomr�de.setText("Noe gikk galt.");
	    	  }
	      }
	    }
	  }
}
