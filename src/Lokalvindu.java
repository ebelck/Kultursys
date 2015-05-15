import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Lokalvindu extends JApplet implements Serializable {
	private static final long serialVersionUID = 1L;
	private JTextField navnFelt, beskFelt, refFelt, altFelt1, altFelt2;
	private JButton finnKnapp, slettKnapp, regKnapp, listeKnapp,oppdaterKnapp;
	private JTextArea tekstområde;
	private JScrollPane utskriftområde;
	private BorderLayout layout;
	private Container c;
	JComboBox<String> lokalvelger;
	private GridLayout bottomGrid,topGrid;
	public Kulturhus k;

	private String lokalnavn = "Valg";
	private JComponent north,south;
	
	public void clearFields() {
		navnFelt.setText("");
		beskFelt.setText("");
		refFelt.setText("");
		refFelt.setText("");
		altFelt1.setText("");
		altFelt2.setText("");
	}
	private void addSpecificC(String l) {
		if (l.equals("Kino")) {
			north.setLayout(new GridLayout(6, 2)); // 5 rows 2 columns; no gaps);
			north.add(new JLabel(" Ytterligere info: "));
			north.add(altFelt1);
		}
		else if (l.equals("Cafe")) {
			north.setLayout(new GridLayout(6, 2)); // 5 rows 2 columns; no gaps);
			north.add(new JLabel(" Antall gjester det er plass til: "));
			north.add(altFelt1);
		}
		else if (l.equals("Konferanse")) {
			north.setLayout(new GridLayout(7, 2)); // 6 rows 2 columns; no gaps);
			north.add(new JLabel(" Antall gjester det er plass til: "));
			north.add(altFelt1);
		}
		else if (l.equals("Selskapslokale")) {
			north.setLayout(new GridLayout(6, 2)); // 5 rows 2 columns; no gaps);
			north.add(new JLabel(" Ytterligere info: "));
			north.add(altFelt1);
		}
		else if (l.equals("Scene")) {
			north.setLayout(new GridLayout(6, 2)); // 5 rows 2 columns; no gaps);
			north.add(new JLabel(" Ytterligere info: "));
			north.add(altFelt1);
		}
		else if (l.equals("Valg")) {
			north.setLayout(new GridLayout(6, 1)); // 5 rows 2 columns; no gaps);
			north.add(new JLabel(""));
			north.add(new JLabel("Velg type!"));
		}
		else {
			System.out.println("Aner ikke hvorfor du endte opp her");
		}
	}
	private void repainter() {
		north.add(new JLabel(" Referansenummer:"));
		north.add(refFelt);
		north.add(new JLabel(" Navn:"));
		north.add(navnFelt);
		north.add(new JLabel(" Beskrivelse:"));
		north.add(beskFelt);
		north.add(new JLabel(" Velg type lokale:"));
		north.add(lokalvelger);	
		
	}
	
	public Lokalvindu(Kulturhus kH) {
		
			k = kH;
		
			String[] lokalvalg = new String[]{"Valg","Kino","Scene","Konferanse","Cafe","Selskapslokale"};

			navnFelt = new JTextField( 18 );
			beskFelt = new JTextField( 18 );
			refFelt = new JTextField( 18 );
			altFelt1 = new JTextField( 18 );
			altFelt2 = new JTextField( 18 );



			
			lokalvelger = new JComboBox<>(lokalvalg);
			lokalvelger.setSelectedIndex(0);
			
			finnKnapp = new JButton("Lokaliser lokale");
			slettKnapp = new JButton( "Slett lokale" );
			regKnapp = new JButton( "Registrer lokale" );
			listeKnapp = new JButton( "List ut lokaler" );
			oppdaterKnapp = new JButton("Oppdater lokale");
			
			//////////////////////////////////////////
			/////////// GUI LAYOUT START /////////////
			
			layout = new BorderLayout(5, 5);
			bottomGrid = new GridLayout(1, 5);
			topGrid = new GridLayout(5, 2);


			
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
			// TOP GRID END
			
			
			// CENTER GRID START
			tekstområde = new JTextArea();
			utskriftområde = new JScrollPane(tekstområde);
			tekstområde.setEditable(false);
			utskriftområde.setForeground(Color.BLACK);
			tekstområde.setMargin(new Insets(10,10,10,10));
			// CENTER GRID END
			
			//BOTTOM GRID START
			south = new JPanel();
			south.setLayout(bottomGrid);
			south.add(finnKnapp);
			south.add(slettKnapp);
			south.add(regKnapp);
			south.add(listeKnapp);
			south.add(oppdaterKnapp);
			// BOTTOM GRID END
			
			c = getContentPane();
			c.setLayout(layout);
			c.add(north, BorderLayout.PAGE_START);
			c.add(utskriftområde, BorderLayout.CENTER);
			c.add(south, BorderLayout.PAGE_END);
			
			/////////// GUI LAYOUT SLUTT /////////////
			//////////////////////////////////////////
				
			
	
			Knappelytter lytter = new Knappelytter();
			
			finnKnapp.addActionListener( lytter );
			slettKnapp.addActionListener( lytter );
			regKnapp.addActionListener( lytter );
			lokalvelger.addActionListener( lytter );
			listeKnapp.addActionListener(lytter);
			oppdaterKnapp.addActionListener(lytter);
			
			setSize( 550, 500 );
			setVisible( true );
		}
	
	
		
	private class Knappelytter implements ActionListener
	  {
	    public void actionPerformed( ActionEvent e )
	    {
	      if ( e.getSource() == regKnapp ) {
	    	  try {
	    		  String navn = navnFelt.getText();
	    		  String besk = beskFelt.getText();
	    		  if (navn.equals("") || besk.equals("")) {
	    			  tekstområde.setText("Du må fylle ut navn og beskrivelse.");
	    			  return;
	    		  }
	    		  if (lokalnavn.equals("Kino")) {
	    			  String film = altFelt1.getText();
	    			  Kino kino = new Kino(navn,besk,film);
	    			  if (k.leggTilLokale(kino)) {
	    				  tekstområde.setText("Lokalet "+ navn + " ble lagt til i kulturhuset");
	    		    	  clearFields();
	    			  }
	    			}
	    			else if (lokalnavn.equals("Cafe")) {
		    			  int gjesteplass = Integer.parseInt(altFelt1.getText());
		    			  Cafe cafe = new Cafe(navn,besk,gjesteplass);
		    			  if (k.leggTilLokale(cafe)) {
		    				  tekstområde.setText("Lokalet "+ navn + " ble lagt til i kulturhuset");
		    		    	  clearFields();
		    			  }
	    			}
	    			else if (lokalnavn.equals("Konferanse")) {
	    				  int gjesteplass = Integer.parseInt(altFelt1.getText());
		    			  Konferanse konf = new Konferanse(navn,besk,gjesteplass);
		    			  if (k.leggTilLokale(konf)) {
		    				  tekstområde.setText("Lokalet "+ navn + " ble lagt til i kulturhuset");
		    		    	  clearFields();
		    			  }
	    			}
	    			else if (lokalnavn.equals("Selskapslokale")) {
		    				Selskapslokale selskapslokale = new Selskapslokale(navn,besk,altFelt1.getText());
			    			  if (k.leggTilLokale(selskapslokale)) {
			    				  tekstområde.setText("Lokalet "+ navn + " ble lagt til i kulturhuset");
			    		    	  clearFields();
			    			  }	
			    			}
	    			else if (lokalnavn.equals("Scene")) {
		    			  Scene scene = new Scene(navn,besk,altFelt1.getText());
		    			  if (k.leggTilLokale(scene)) {
		    				  tekstområde.setText("Lokalet "+ navn + " ble lagt til i kulturhuset");
		    		    	  clearFields();
		    			  }
	    			}
	    			else if (lokalnavn.equals("Valg")) {
	    				 tekstområde.setText("Du må liksom velge noe davel...");
	    			}
	    			else {
	    				System.out.println("Aner ikke hvorfor du endte opp her");
	    		}
	    	  } catch (Exception ex) {
		    	  	tekstområde.setText("Det oppsto en feil, vennligst prøv på nytt");
	    	  }
	      }

	      else if ( e.getSource() == slettKnapp ) {
	    	  if (refFelt.getText().equals("")) {
	    		  tekstområde.setText("Du må bruke referansenummer for å slette.");
	    		  
	    	  } else {
				try {
					Lokale lokalFunnet = k.finnLokale(Integer.parseInt(refFelt.getText()));
					if (lokalFunnet != null) {
						Object[] options = {"Ja",
						                    "Avbryt",};
						int n = JOptionPane.showOptionDialog(null,
						    "Er du sikker på at du vil slette dette rommet?",
						    "Advarsel",
						    JOptionPane.OK_CANCEL_OPTION,
						    JOptionPane.WARNING_MESSAGE,
						    null,
						    options,
						    options[0]);
						if (n == 1) {
							tekstområde.setText("Lokalet ble ikke slettet");
							return;
						}
					}
					if (k.slettLokale(Integer.parseInt(refFelt.getText()))) {
						tekstområde.setText("Lokalet med navn "
								+ lokalFunnet.get_Navn() + " og referanse "
								+ lokalFunnet.get_RefNr()
								+ " er slettet fra kulturhuset.");
				    	  clearFields();
					} else {
						tekstområde
								.setText("Vi kunne ikke finne et lokale med referanse "
										+ refFelt.getText() + " i kulturhuset.");
					}
				} catch (Exception ex) {
					tekstområde.setText("En feil har oppstått, prøv igjen.");
				}
	    	  }
	      }
	      else if ( e.getSource() == listeKnapp )
	    	  	tekstområde.setText(k.listLokaler());
	      
	      else if ( e.getSource() == finnKnapp ) {
	    	  try {
	    		int n = Integer.parseInt(refFelt.getText());
	      		Lokale lokalFunnet = k.finnLokale(n);
	      		String s = lokalFunnet.toString();
	      		
	      		if (!k.finnesLokale(n)) {
	      			System.out.println("Skrev fra if'en");
	      			tekstområde.setText("Fant ikke lokale med dette referansenummer.");
	      			return;
	      		}
	      			tekstområde.setText(s);
	    	  } catch(Exception ex) {
	    		  System.out.println("Skrev fra exception");
	    		  tekstområde.setText("Fant ikke lokale med dette referansenummer.");
	    	  }
	      } else if ( e.getSource() == oppdaterKnapp ) {
	    	  if (refFelt.getText().equals("")) {
	    		  tekstområde.setText("Du må bruke referansenummer for å oppdatere ett arrangement");
	    		  return;
	    	  }
	    	  String navn = navnFelt.getText();
	    	  String besk = beskFelt.getText();
	    	  String alt = altFelt1.getText();
	    	  String alt2 = altFelt2.getText();

	    	  int refNr = Integer.parseInt(refFelt.getText());
	    	  Lokale lokFunnet = k.arrangementViaK(refNr);
	    	  if (!navn.equals(""))
	    		  lokFunnet.set_Navn(navn);
	    	  if (!besk.equals(""))
	    		  lokFunnet.set_Besk(besk);
	    	  tekstområde.setText(lokFunnet.toString());
	    	  clearFields();
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
			c.add(utskriftområde, BorderLayout.CENTER);
			c.add(south, BorderLayout.PAGE_END);
		    c.revalidate();
		    c.repaint();
	    }
	  }
	
}
