// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// Høgskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen – s198524
// Roger Bløtekjær Johannessen – s186571
// Halvor Rønneseth – s172589
//
////////////////////////////////BESKRIVELSE///////////////////////////////
// Denne klassen lager fanen til Adminpanelet hvor administrator kan	// 
// opprette, endre og slette Kontaktpersoner							//
//////////////////////////////////////////////////////////////////////////

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class Kontaktvindu extends JApplet implements Serializable {
	private static final long serialVersionUID = 5852295657639809254L;
	private JTextField fornavnFelt, etternavnFelt, epostFelt,tlfFelt,bildeNavnFelt;
	private JButton finnKnapp, slettKnapp, regKnapp, listeKnapp, bildeKnapp,oppdaterKnapp;
	private JTextArea tekstområde;
	private JScrollPane utskriftområde;
	private BorderLayout layout,leftBottomBorder;
	private Container c;
	private Personregister reg;
	private GridLayout rightGrid,bottomGrid,leftGrid;
	public Bildehandler bildehandlerK;
	private JCheckBox checkbox;
	private StretchIcon bildeIconK;
	private BufferedImage bilde = null;
	private BufferedImage placeholder_img;
	private boolean kunMedArr;						//Brukes aldri. Kan den fjernes?
	private EmptyBorder border;
	private File bildeFil;
	private JComponent leftBottom, right, bottom,leftSplit;
	private JLabel bildeLabelK;
	public Kulturhus KH;
	
	// Viser bilde av kontaktperson
	public void visBilde(Kontaktperson k) {
		try {
			File bildeFil = new File(k.get_bildeSti());
			bilde = ImageIO.read(bildeFil);
			bildeIconK.setImage(bilde);
			bildeNavnFelt.setText(bildeFil.getName());
			bildeLabelK.repaint();
  	  } catch(Exception ex) {
		  tekstområde.setText("Noe gikk galt.");
	  }
	}
	
	// Setter placeholder
	public void setPlaceHolderImg() {
		try {
			placeholder_img = ImageIO.read(new File("./images/placeholder_img.png"));
			bildeIconK.setImage(placeholder_img);
			bildeLabelK.repaint();
  	  } catch(Exception ex) {
		  tekstområde.setText("Noe gikk galt.");
	  }
	}
	
	// Sletter bilde
	public boolean slettFil(Kontaktperson k) {
    	try{
    		 
    		String bildeSti = k.get_bildeSti();
    		if (bildeSti==null) {
    			return false;
    		}
    		File file = new File(k.get_bildeSti());
 
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    			return true;
    		}else{
    			System.out.println("Delete operation is failed.");
    			return false;
    		}
 
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
	}
	
	// Fjerner tekst fra inputfelter
	public void clearFields() {
		fornavnFelt.setText("");
		etternavnFelt.setText("");
		epostFelt.setText("");
		tlfFelt.setText("");
		bildeNavnFelt.setText("");
		setPlaceHolderImg();
	}
	
	// Oppretter Kontaktvindu
	public Kontaktvindu(Personregister pr, Kulturhus k) {
			KH=k;
			reg = pr;

			fornavnFelt = new JTextField( 18 );
			etternavnFelt = new JTextField( 18 );
			epostFelt = new JTextField( 18 );
			tlfFelt = new JTextField( 18 );
			
			checkbox = new JCheckBox("Kun kontaktpersoner med ansvar");

			bildeNavnFelt = new JTextField( 18 );
      		bildeIconK = new StretchIcon("");
      		bildeLabelK = new JLabel(bildeIconK);
			
			bildeNavnFelt.setEditable(false);
			bildeNavnFelt.setForeground(Color.BLACK);
			bildeNavnFelt.setMargin(new Insets(10,10,10,10));
			
			finnKnapp = new JButton(" Finn kontaktperson.");
			slettKnapp = new JButton( " Slett kontaktperson" );
			regKnapp = new JButton( " Registrer kontaktperson" );
			listeKnapp = new JButton( " List kontaktpersoner" );
			bildeKnapp = new JButton(" Last inn bilde");
			bildeNavnFelt.setText("");
			oppdaterKnapp = new JButton("Oppdater kontaktperson");
			
			//////////////////////////////////////////
			/////////// GUI LAYOUT START /////////////
			
			// DECLARATIONS START
			layout = new BorderLayout(5, 5);
			leftGrid = new GridLayout(2,1);
			leftBottomBorder = new BorderLayout(5,5);
			rightGrid = new GridLayout(5, 3);
			bottomGrid = new GridLayout(1,5);
			border = new EmptyBorder(5,5,5,5);
			// DECLARATIONS END
			
			// LEFT PANEL START
			leftSplit = new JPanel();
			leftSplit.setLayout(leftGrid);
			leftSplit.setBorder(border);
			leftBottom = new JPanel();
			leftBottom.setLayout(leftBottomBorder);

			JPanel ekstra = new JPanel();
			ekstra.setLayout(new GridLayout(2,1));
			
			ekstra.add(bildeKnapp);
			ekstra.add(bildeNavnFelt);
			bildeLabelK.setBorder(border);
			
			leftBottom.add(ekstra,BorderLayout.PAGE_START);
			leftBottom.add(checkbox,BorderLayout.CENTER);
			
			leftSplit.add(bildeLabelK,BorderLayout.CENTER);
			leftSplit.add(leftBottom,BorderLayout.PAGE_END);
			// LEFT PANEL END
			
			// RIGHT PANEL START
			right = new JPanel();
			right.setLayout(rightGrid);
			right.setBorder(border);
			right.add(new JLabel(" Fornavn "));
			right.add(fornavnFelt);
			right.add(new JLabel(" Etternavn: "));
			right.add(etternavnFelt);
			right.add(new JLabel(" Telefon:   "));
			right.add(tlfFelt);
			right.add(new JLabel(" Epost:     "));
			right.add(epostFelt);
			// RIGHT PANEL END
			
			// BOTTOM PANEL START
			bottom = new JPanel();
			bottom.setLayout(bottomGrid);
			bottom.add(finnKnapp);
			bottom.add(slettKnapp);
			bottom.add(regKnapp);
			bottom.add(listeKnapp);
			bottom.add(oppdaterKnapp);
			// BOTTOM PANEL END
			
			// CENTER TEXT PANEL START
			tekstområde = new JTextArea();
			utskriftområde = new JScrollPane(tekstområde);
			tekstområde.setEditable(false);
			utskriftområde.setForeground(Color.BLACK);
			tekstområde.setMargin(new Insets(10,10,10,10));
			// CENTER TEXT PANEL END
			
			c = getContentPane();
			c.setLayout(layout);
			c.add(new JLabel("Kontaktperson:"), BorderLayout.PAGE_START);
			c.add(leftSplit, BorderLayout.LINE_START);
			c.add(right, BorderLayout.PAGE_START);
			c.add(utskriftområde, BorderLayout.CENTER);
			c.add(bottom,BorderLayout.PAGE_END);
			setPlaceHolderImg();
			
			/////////// GUI LAYOUT SLUTT /////////////
			//////////////////////////////////////////
				
			
	
			Knappelytter lytter = new Knappelytter();
			Typelytter tLytter = new Typelytter();
			
			finnKnapp.addActionListener( lytter );
			slettKnapp.addActionListener( lytter );
			regKnapp.addActionListener( lytter );
			listeKnapp.addActionListener(lytter);
			bildeKnapp.addActionListener(lytter);
			oppdaterKnapp.addActionListener(lytter);
			
			checkbox.addItemListener(tLytter);
			
			setSize( 550, 500 );
			setVisible( true );
		}
	
	// Oppretter Typelytter
    private class Typelytter implements ItemListener
    {
      public void itemStateChanged( ItemEvent e )
      {
    	  if ( checkbox.isSelected() ) {
    		  try {
    			  kunMedArr = true;

    		  } catch(Exception ex) {
    			  tekstområde.setText("Her oppsto det en feil.");
    		  }
    	 } else {
    		 try {
   			  kunMedArr = false;
     		  } catch(Exception ex) {
     			  tekstområde.setText("Her oppsto det en feil.");
     		  }
    	 }
      }
    }
    
    // Oppretter knappelytter
	private class Knappelytter implements ActionListener
	  {
	    public void actionPerformed( ActionEvent e )
	    {
	    	// Legger til kontakt
	      if ( e.getSource() == regKnapp ) {
	    	  try {
	    		  String fornavn = fornavnFelt.getText();
	    		  String etternavn = etternavnFelt.getText();
	    		  String tlf = tlfFelt.getText();
	    		  String epost = epostFelt.getText();
	    		  
	    		  if (reg.sjekkOmFinnesEpost(epost) || reg.sjekkOmFinnesTlf(tlf)){
	    			  tekstområde.setText("Telefon eller epost allerede i bruk");
	    			  return;
	    		  }
	    		  
	    		  if (fornavn.equals("") || etternavn.equals("") || tlf.equals("") || epost.equals("")) {
	    			  tekstområde.setText("Du må fylle ut alle feltene for å registrere en kontaktperson ( bilde kan være tomt ).");
	    			  return;
	    		  }
	    		  if (bildeNavnFelt.getText().equals("")) {
		    		  Kontaktperson kontakt = new Kontaktperson(fornavn,etternavn,epost,tlf);
		    		  if (reg.leggTilKontaktperson(kontakt)) {
		    			  tekstområde.setText(kontakt.get_Navn() + " ble lagt til i registeret.");
		    		  }
		    		  clearFields();
		    		  return;
	    		  } else {
	    			  try {
		    			  String bildenavn = "./images/"+fornavn+"-"+tlf+"-"+"bilde.png";
	    				  File outputfile = new File(bildenavn);
	    				  ImageIO.write(bilde, "png", outputfile);
	    				  Kontaktperson kontakt = new Kontaktperson(fornavn,etternavn,epost,tlf,bildenavn);
			    		  if (reg.leggTilKontaktperson(kontakt)) {
			    			  tekstområde.setText(kontakt.get_Navn() + " ble lagt til i registeret.");
			    		  }
			    		  clearFields();
	    				  return;
	    			  } catch (IOException ex) {
	    				  tekstområde.setText("Vi kunne ikke bruke dette bilde, noe gikk galt");
	    			  }
	    		  }
	    	  } catch (Exception ex) {
	    		  tekstområde.setText("Det oppsto en feil, vennligst prøv på nytt" + e.getClass());
	    	  }
	      }
	      
	      // Sletter kontakt
	      else if ( e.getSource() == slettKnapp ) {
	    	  if (tlfFelt.getText().equals("") && epostFelt.getText().equals("")) {
	    		  tekstområde.setText("Du må bruke telefonnummer eller epost for å slette.");  
	    	  } else {
	    		  if (!tlfFelt.getText().equals("")) {
	    			  try {
	    				  String refNr = tlfFelt.getText();
	    				  Kontaktperson kontaktFunnet = reg.finnKontaktpersonViaTlf(refNr);
	    				  if (kontaktFunnet != null) {
	    					  Object[] options = {"Ja",
							                    "Avbryt",};
	    					  int n = JOptionPane.showOptionDialog(null,
							    "Er du sikker på at du vil slette denne kontaktpersonen?",
							    "Advarsel",
							    JOptionPane.OK_CANCEL_OPTION,
							    JOptionPane.WARNING_MESSAGE,
							    null,
							    options,
							    options[0]);
	    					  if (n == 1) {
	    						  tekstområde.setText("Kontaktpersonen ble ikke slettet");
	    						  return;
	    					  }
	    				  }
						if (reg.slettKontaktpersonViaTelefon(refNr)) {
							slettFil(kontaktFunnet);
							clearFields();
							tekstområde.setText("Kontaktperson med navn "
									+ kontaktFunnet.get_Navn() + " og telefonnummer / referanse "
									+ kontaktFunnet.get_Telefon()
									+ " er slettet fra kulturhuset.");
						} else {
							tekstområde
									.setText(" Kunne ikke slette "
											+ kontaktFunnet.get_Navn() + " siden systemet vårt er for dårlig. :(");
						}
					} catch (Exception ex) {
						tekstområde.setText("En feil har oppstått, prøv igjen.");
					}
	    			  
	    		  } else if (!epostFelt.getText().equals("")) {
		  				try {
							String refNr = epostFelt.getText();
							Kontaktperson kontaktFunnet = reg.finnKontaktpersonViaEpost(refNr);
							if (kontaktFunnet != null) {
								Object[] options = {"Ja",
								                    "Avbryt",};
								int n = JOptionPane.showOptionDialog(null,
								    "Er du sikker på at du vil slette denne kontaktpersonen?",
								    "Advarsel",
								    JOptionPane.OK_CANCEL_OPTION,
								    JOptionPane.WARNING_MESSAGE,
								    null,
								    options,
								    options[0]);
								if (n == 1) {
									tekstområde.setText("Kontaktpersonen ble ikke slettet");
									return;
								}
							}
							if (reg.slettKontaktpersonViaTelefon(refNr)) {
								slettFil(kontaktFunnet);
								clearFields();
								tekstområde.setText("Kontaktperson med navn "
										+ kontaktFunnet.get_Navn() + " og epost / referanse "
										+ kontaktFunnet.get_Epost()
										+ " er slettet fra kulturhuset.");
							} else {
								tekstområde
										.setText(" Kunne ikke slette "
												+ kontaktFunnet.get_Navn() + " siden systemet vårt er for dårlig. :(");
							}
						} catch (Exception ex) {
							tekstområde.setText("En feil har oppstått, prøv igjen.");
						}
	    	  }
	    	}
	      }
	      
	      // Lister ut kontakter
	      else if ( e.getSource() == listeKnapp ) {
	    	  if (kunMedArr==true) {
	    		  tekstområde.setText(KH.kunKontaktMedAnsvar());
	    	  } else {
	    	  	tekstområde.setText(reg.toString());
	    	  }
	      }
	      
	      // Finner kontakt
	      else if ( e.getSource() == finnKnapp ) {
	    	  if (tlfFelt.getText().equals("") && epostFelt.getText().equals("")) {
	    		  tekstområde.setText("Du må bruke telefonnummer eller epost for å finne en kontaktperson.");  
	    	  } else {
	    		  if (!tlfFelt.getText().equals("")) {
	    			  Kontaktperson kontaktFunnet = reg.finnKontaktpersonViaTlf(tlfFelt.getText());
	    			  tekstområde.setText(kontaktFunnet.toString());
	    			  if (kontaktFunnet.get_bildeSti() != null)
	    			  visBilde(kontaktFunnet);
	    			  return;
	    		  } else if (!epostFelt.getText().equals("")) {
	    			  Kontaktperson kontaktFunnet = reg.finnKontaktpersonViaEpost(epostFelt.getText());
	    			  tekstområde.setText(kontaktFunnet.toString());
	    			  if (kontaktFunnet.get_bildeSti() != null)
	    			  visBilde(kontaktFunnet);
	    			  return;
	    		  }
	    	  }
	      }
	      
	      // Åpner opp filvelger slik at bruker kan velge bilde
	      else if ( e.getSource() == bildeKnapp ) {
	    	  try {
	      		bildehandlerK = new Bildehandler();
	      		bildeFil = bildehandlerK.hentFil();
	      		bilde = ImageIO.read(bildeFil);
	      		bildeIconK.setImage(bilde);
	      		bildeNavnFelt.setText(bildeFil.getName());
	      		bildeLabelK.repaint();
	      		
	    	  } catch(Exception ex) {
	    		  tekstområde.setText("Noe gikk galt.");
	    	  }
	      }
	      
	      // Oppdaterer kontakt
	      else if ( e.getSource() == oppdaterKnapp ) {
	    	  String fornavn = fornavnFelt.getText();
	    	  String etternavn = etternavnFelt.getText();
	    	  String tlf = tlfFelt.getText();
	    	  String epost = epostFelt.getText();
	    	  String bildeB = bildeNavnFelt.getText();
	    	  Kontaktperson kontaktFunnet;
	    	  
	    	  if (tlf.equals("") && epost.equals("")) {
	    		  tekstområde.setText("Du må bruke telefonnummer eller epost for å oppdatere en kontaktperson.");  
	    	  } else {
	    		  if (!tlf.equals("") && !epost.equals("")) {
	    			  kontaktFunnet = reg.finnKontaktpersonViaTlf(tlf);
	    			  if (kontaktFunnet!=null)
	    				  kontaktFunnet.set_Epost(epost);
	    			  kontaktFunnet = reg.finnKontaktpersonViaEpost(epost);
	    			  if (kontaktFunnet!=null)
	    				  kontaktFunnet.set_Telefon(tlf);
	    		  }
	    		  if (!tlfFelt.getText().equals("")) {
	    			  kontaktFunnet = reg.finnKontaktpersonViaTlf(tlfFelt.getText());
	    			  
	    	    	  if (!fornavn.equals(""))
	    	    		  kontaktFunnet.set_Fornavn(fornavn);
	    	    	  if (!etternavn.equals(""))
	    	    		  kontaktFunnet.set_Etternavn(etternavn);
	    	    	  if (!epost.equals(""))
	    	    		  kontaktFunnet.set_Epost(epost);
	    	    	  if (!bildeB.equals("")) {
							if (kontaktFunnet != null) {
								Object[] options = {"Ja",
								                    "Nei",};
								int n = JOptionPane.showOptionDialog(null,
								    "Vil du erstatte bildet med et nytt?",
								    "Hei bruker.",
								    JOptionPane.OK_CANCEL_OPTION,
								    JOptionPane.INFORMATION_MESSAGE,
								    null,
								    options,
								    options[0]);
								if (n == 1) {
									tekstområde.setText("* Bildet ble ikke erstattet *\r\n");
									tekstområde.append(kontaktFunnet.toString());
					    	    	clearFields();
									return;
								}
								slettFil(kontaktFunnet);
								String bildenavn = "./images/"+kontaktFunnet.get_Fornavn()+"-"+kontaktFunnet.get_Telefon()+"-"+"bilde.png";
			    				File outputfile = new File(bildenavn);
			    	    		kontaktFunnet.set_bildeSti(bildenavn);
			    				try {
									ImageIO.write(bilde, "png", outputfile);
								} catch (IOException e1) {
									e1.printStackTrace();
								};
							}
	    	    	  }

	    	    	  tekstområde.setText(kontaktFunnet.toString());
	    	    	  clearFields();
	    	    	  setPlaceHolderImg();
	 
	    		  } else if (!epostFelt.getText().equals("")) {
	    			  kontaktFunnet = reg.finnKontaktpersonViaEpost(epostFelt.getText());
	    			  
	    	    	  if (!fornavn.equals(""))
	    	    		  kontaktFunnet.set_Fornavn(fornavn);
	    	    	  if (!etternavn.equals(""))
	    	    		  kontaktFunnet.set_Etternavn(etternavn);
	    	    	  if (!tlf.equals(""))
	    	    		  kontaktFunnet.set_Telefon(tlf);
	    	    	  if (!bildeB.equals("")) {
							if (kontaktFunnet != null) {
								Object[] options = {"Ja",
								                    "Nei",};
								int n = JOptionPane.showOptionDialog(null,
								    "Vil du erstatte bildet med et nytt?",
								    "Hei bruker.",
								    JOptionPane.OK_CANCEL_OPTION,
								    JOptionPane.INFORMATION_MESSAGE,
								    null,
								    options,
								    options[0]);
								if (n == 1) {
									tekstområde.setText("* Bildet ble ikke erstattet *\r\n");
									tekstområde.append(kontaktFunnet.toString());
					    	    	clearFields();
									return;
								}
								slettFil(kontaktFunnet);
								String bildenavn = "./images/"+fornavn+"-"+tlf+"-"+"bilde.png";
			    				File outputfile = new File(bildenavn);
			    	    		kontaktFunnet.set_bildeSti(bildenavn);
			    				try {
									ImageIO.write(bilde, "png", outputfile);
								} catch (IOException e1) {
									e1.printStackTrace();
								};
							}
	    	    	  }
	    	    	  tekstområde.setText(kontaktFunnet.toString());
	    	    	  clearFields();
	    	    	  setPlaceHolderImg();
	    		  }
	    	  }
	      }
	   }
	}
} // Kontaktvindu slutt
