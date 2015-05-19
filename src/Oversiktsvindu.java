import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Oversiktsvindu extends JApplet implements Serializable {
	private static final long serialVersionUID = -7739980805136500639L;
	private JPanel top, tekstvindu;
	private JComboBox<String> velgLokale;
	private String[] lokalvalg;
	private JLabel velgL;
	private JTextArea melding;
	private JScrollPane meldingsomr�de;
	private String standardmelding = "Velkommen til Publikumsportalen!";
	
	private Kulturhus k;
	private ActionListener lytter;
	
	//////////////////
	//	KONSTRUKT�R	//
	//////////////////
	
	public Oversiktsvindu(Kulturhus hus){
		
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
		top.setLayout(new GridLayout(2,1));
		
			/////	VALGMENY START	/////
		
			velgL = new JLabel("Velg lokale i menyen for � vise arrangement:");
			top.add(velgL);
			
			lokalvalg = k.lokaleCombo();
			velgLokale = new JComboBox<String>(lokalvalg);
			velgLokale.setToolTipText("Liste over lokalene i kulturhuset");
			velgLokale.addActionListener(lytter);
			top.add(velgLokale);
			
		
			/////	VALGMENY SLUTT	/////
			
		/////		TOP-PANEL SLUTT		/////
		/////////////////////////////////////
			
		/////////////////////////////////////
		/////		MIDT-PANEL START	/////	
		
			tekstvindu = new JPanel();
			tekstvindu.setLayout(new GridLayout(1,1));
			getContentPane().add(tekstvindu, BorderLayout.CENTER);
			
			/////	MELDINGSVINDU START	/////
			
				melding = new JTextArea(standardmelding);
				meldingsomr�de = new JScrollPane(melding);
				melding.setEditable(false);
				melding.setMargin(new Insets(10,10,10,10));
				melding.setText("");
				tekstvindu.add(meldingsomr�de);
				
			/////	MELDINGSVINDU SLUTT	/////
			
		/////		MIDT-PANEL SLUTT	/////
		/////////////////////////////////////
	}
	
	/////////////////////////
	//	KONSTRUKT�R	SLUTT  //
	/////////////////////////
	
	// Henter ut arrangementer 3 m�neder frem i tid
	public String hentArr3mnd(){
		String svar = k.hentArrNesteDager(90);
		return svar;
	}
	
	// Oppretter Knappelytter
	public class Knappelytter implements ActionListener{
		
		public void actionPerformed( ActionEvent e){
			//s�ker opp Arrangement
			if(e.getSource() == velgLokale){
				if(velgLokale.getSelectedItem().equals("Velg lokale")){
					melding.setText(standardmelding);
					return;
				}
					
				String valg = (String)velgLokale.getSelectedItem();
				String[] deler = valg.split(" ");
				Lokale l = k.finnLokale(Integer.parseInt(deler[0]));
				String a = l.listArrangementer();	//k.listArrangement(lokalenavn);
				melding.setText(a);
				return;
			}
			else{
				melding.setText("En feil har oppst�tt. Pr�v igjen!");
			}
		}
	}
} // Oversiktsvindu slutt
