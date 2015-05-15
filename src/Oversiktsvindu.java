import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Oversiktsvindu extends JApplet {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel top, tekstvindu;
	private JComboBox<String> valgLokale;
	private String[] lokalvalg;
	private JLabel velgL;
	private JButton s�kKnp, tilbakeKnp;
	private JTextArea melding;
	private JScrollPane meldingsomr�de;
	
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
		top.setLayout(new GridLayout(1,4));
		
			/////	VALGMENY START	/////
		
			velgL = new JLabel("Velg lokale:");
			top.add(velgL);
			
			lokalvalg = k.lokalListe();
			valgLokale = new JComboBox<String>(lokalvalg);
			valgLokale.setToolTipText("Liste over lokalene i kulturhuset");
			valgLokale.addActionListener(lytter);
			top.add(valgLokale);
			
			s�kKnp = new JButton("S�k");
			s�kKnp.setToolTipText("S�ker opp alle arrangemnt tilknyttet lokalet");
			s�kKnp.addActionListener(lytter);
			top.add(s�kKnp);
			
			tilbakeKnp = new JButton("Tilbake");
			tilbakeKnp.setToolTipText("Tar deg tilbake til f�rste visning");
			tilbakeKnp.addActionListener(lytter);
			top.add(tilbakeKnp);
		
			/////	VALGMENY SLUTT	/////
			
		/////		TOP-PANEL SLUTT		/////
		/////////////////////////////////////
			
		/////////////////////////////////////
		/////		MIDT-PANEL START	/////	
		
			tekstvindu = new JPanel();
			tekstvindu.setLayout(new GridLayout(1,1));
			getContentPane().add(tekstvindu, BorderLayout.CENTER);
			
			/////	MELDINGSVINDU START	/////
			
				melding = new JTextArea();
				meldingsomr�de = new JScrollPane(melding);
				melding.setEditable(false);
				melding.setMargin(new Insets(10,10,10,10));
				melding.setText("");
				tekstvindu.add(melding);
				
			/////	MELDINGSVINDU SLUTT	/////
			
		/////		MIDT-PANEL SLUTT	/////
		/////////////////////////////////////
	}
	
	
	
	public class Knappelytter implements ActionListener{
		public void actionPerformed( ActionEvent e){
			//s�ker opp Arrangement
			if(e.getSource() == s�kKnp){
				String lokalenavn = (String)valgLokale.getSelectedItem();
				String a = k.listArrangement(lokalenavn);
				melding.setText(a);
				//resultat.setText(lokalenavn);
				//System.out.println(k.totatlString());
				return;
			}
			else if( e.getSource() == tilbakeKnp){
				
				melding.setText("G�r tilbake til defaultvisning");
			}
			else{
				melding.setText("Banan!");
			}
		}
	}
}
