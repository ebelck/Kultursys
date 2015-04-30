import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Kulturhusvindu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] lokalvalg = {"Velg lokale", "Cafe", "Scene", "Kino", "Konferanse", "Selskap"};
	private JTextField eierfelt, adressefelt, regnrfelt, merkefelt, �rsmodellfelt,
    lengdefelt, hpfelt, fargefelt, medlnrfelt;
	private JButton regEier, regB�t, slettEier, slettB�t, byttEier, visRegister, hentRegnr, medlnr;
	private JTextArea utskriftomr�de;
	JComboBox<String> lokalvelger;

	public Kulturhusvindu() {
		super( "Registrer lokale" );

			medlnrfelt = new JTextField( 16);
			eierfelt = new JTextField( 18 );
			adressefelt = new JTextField( 18 );
			regnrfelt = new JTextField( 12 );
			merkefelt = new JTextField( 18 );
			�rsmodellfelt = new JTextField( 18 );
			lengdefelt = new JTextField( 18 );
			hpfelt = new JTextField( 18 );
			fargefelt = new JTextField( 18 );
			
			lokalvelger = new JComboBox<>(lokalvalg);
			lokalvelger.setSelectedIndex(0);
			
			medlnr = new JButton("Finn eier");
			regEier = new JButton( "Registrer eier" );
			regB�t = new JButton( "Registrer b�t" );
			slettEier = new JButton( "Slette eier" );
			slettB�t = new JButton( "Slette b�t" );
			byttEier = new JButton( "Bytt eier" );
			visRegister = new JButton( "Vis b�tregister" );
			hentRegnr = new JButton( "Hent eier via regNR" );
			utskriftomr�de = new JTextArea( 15, 45 );
			utskriftomr�de.setEditable( false );
	
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
			c.add( new JLabel( "�rsmodell:" ) );
			c.add( �rsmodellfelt );
			c.add( new JLabel( "Lengde:" ) );
			c.add( lengdefelt );
			c.add( new JLabel( "HP:" ) );
			c.add( hpfelt );
			c.add( new JLabel( "Farge:" ) );
			c.add( fargefelt );
			c.add(new JLabel("             "));
			c.add( regEier );
			c.add( regB�t );
			c.add( slettEier );
			c.add( slettB�t );
			c.add( byttEier );
			c.add( visRegister );
			c.add( hentRegnr );
			c.add( new JScrollPane( utskriftomr�de ) );
	
			Knappelytter lytter = new Knappelytter();
			
			medlnr.addActionListener( lytter );
			regEier.addActionListener( lytter );
			regB�t.addActionListener( lytter );
			slettEier.addActionListener( lytter );
			slettB�t.addActionListener( lytter );
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
	    	  utskriftomr�de.setText("");
	      else if ( e.getSource() == regB�t )
	    	  utskriftomr�de.setText("");
	      else if ( e.getSource() == slettEier )
	    	  utskriftomr�de.setText("");
	      else if ( e.getSource() == slettB�t )
	    	  utskriftomr�de.setText("");
	      else if ( e.getSource() == byttEier )
	    	  utskriftomr�de.setText("");
	      else if ( e.getSource() == visRegister )
	    	  utskriftomr�de.setText("");
	      else if ( e.getSource() == hentRegnr )
	    	  utskriftomr�de.setText("");
	      else if ( e.getSource() == medlnr )
	    	  utskriftomr�de.setText("");
	    }
	  }
	
}
