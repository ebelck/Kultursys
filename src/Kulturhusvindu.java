import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Kulturhusvindu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] lokalvalg = {"Velg lokale", "Cafe", "Scene", "Kino", "Konferanse", "Selskap"};
	private JTextField eierfelt, adressefelt, regnrfelt, merkefelt, årsmodellfelt,
    lengdefelt, hpfelt, fargefelt, medlnrfelt;
	private JButton regEier, regBåt, slettEier, slettBåt, byttEier, visRegister, hentRegnr, medlnr;
	private JTextArea utskriftområde;
	JComboBox<String> lokalvelger;

	public Kulturhusvindu() {
		super( "Registrer lokale" );

			medlnrfelt = new JTextField( 16);
			eierfelt = new JTextField( 18 );
			adressefelt = new JTextField( 18 );
			regnrfelt = new JTextField( 12 );
			merkefelt = new JTextField( 18 );
			årsmodellfelt = new JTextField( 18 );
			lengdefelt = new JTextField( 18 );
			hpfelt = new JTextField( 18 );
			fargefelt = new JTextField( 18 );
			
			lokalvelger = new JComboBox<>(lokalvalg);
			lokalvelger.setSelectedIndex(0);
			
			medlnr = new JButton("Finn eier");
			regEier = new JButton( "Registrer eier" );
			regBåt = new JButton( "Registrer båt" );
			slettEier = new JButton( "Slette eier" );
			slettBåt = new JButton( "Slette båt" );
			byttEier = new JButton( "Bytt eier" );
			visRegister = new JButton( "Vis båtregister" );
			hentRegnr = new JButton( "Hent eier via regNR" );
			utskriftområde = new JTextArea( 15, 45 );
			utskriftområde.setEditable( false );
	
			Container c = getContentPane();
			c.setLayout( new FlowLayout() );
			c.add( new JLabel(" Allerede registrert? Skriv medlemsnr her:") );
			c.add( medlnrfelt );
			c.add(medlnr);
			c.add( new JLabel( "Navn:" ) );
			c.add( eierfelt );
			c.add( new JLabel( "Adresse:" ) );
			c.add( adressefelt );
			
			c.add(new JLabel("Scroll bitch"));
			c.add(lokalvelger);
			
			c.add( new JLabel( "Registreringsnummer:" ) );
			c.add( regnrfelt );
			c.add( new JLabel( "Merke:" ) );
			c.add( merkefelt );
			c.add( new JLabel( "Årsmodell:" ) );
			c.add( årsmodellfelt );
			c.add( new JLabel( "Lengde:" ) );
			c.add( lengdefelt );
			c.add( new JLabel( "HP:" ) );
			c.add( hpfelt );
			c.add( new JLabel( "Farge:" ) );
			c.add( fargefelt );
			c.add(new JLabel("             "));
			c.add( regEier );
			c.add( regBåt );
			c.add( slettEier );
			c.add( slettBåt );
			c.add( byttEier );
			c.add( visRegister );
			c.add( hentRegnr );
			c.add( new JScrollPane( utskriftområde ) );
	
			Knappelytter lytter = new Knappelytter();
			
			medlnr.addActionListener( lytter );
			regEier.addActionListener( lytter );
			regBåt.addActionListener( lytter );
			slettEier.addActionListener( lytter );
			slettBåt.addActionListener( lytter );
			byttEier.addActionListener( lytter );
			visRegister.addActionListener( lytter );
			hentRegnr.addActionListener( lytter );
			
			lokalvelger.addActionListener( lytter );
			
			setSize( 550, 500 );
			setVisible( true );
		}
	
	
		
	private class Knappelytter implements ActionListener
	  {
	    public void actionPerformed( ActionEvent e )
	    {
	      if ( e.getSource() == regEier )
	    	  utskriftområde.setText("");
	      else if ( e.getSource() == regBåt )
	    	  utskriftområde.setText("");
	      else if ( e.getSource() == slettEier )
	    	  utskriftområde.setText("");
	      else if ( e.getSource() == slettBåt )
	    	  utskriftområde.setText("");
	      else if ( e.getSource() == byttEier )
	    	  utskriftområde.setText("");
	      else if ( e.getSource() == visRegister )
	    	  utskriftområde.setText("");
	      else if ( e.getSource() == hentRegnr )
	    	  utskriftområde.setText("");
	      else if ( e.getSource() == medlnr )
	    	  utskriftområde.setText("");
	    }
	  }
	
}
