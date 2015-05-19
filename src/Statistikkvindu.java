import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Statistikkvindu extends JApplet implements Serializable{
	private static final long serialVersionUID = 5598407733052246255L;
	
	private JButton stat1,stat2,stat3,stat4,stat5;
	private JTextPane tekstområde;
	private JScrollPane utskriftområde;
	private BorderLayout layout;
	private Container c;;
	public Kulturhus k;

	private JComponent north,south;
	
	public Statistikkvindu(Kulturhus kH) {
			
		k = kH;
			
		stat1 = new JButton("Detaljert inntekt");
		stat2 = new JButton( "Total inntekt" );
		stat3 = new JButton( "!=Beregning 3" );
		stat4 = new JButton( "!=Beregning 4" );
		stat5 = new JButton("!=Beregning 5");
		
		//////////////////////////////////////////
		/////////// GUI LAYOUT START /////////////
		
		layout = new BorderLayout(50, 50);
		Font font = new Font("Verdana", Font.PLAIN, 50);
		
		// TOP GRID START
		north = new JPanel();
		JLabel header = new JLabel("STATISTIKK");
		north.add(header);
		north.setAlignmentY(CENTER_ALIGNMENT);
		header.setFont(font);
		// TOP GRID END
		
		// CENTER GRID START
		tekstområde = new JTextPane();
		utskriftområde = new JScrollPane(tekstområde);
		tekstområde.setEditable(false);
		utskriftområde.setForeground(Color.BLACK);
		tekstområde.setMargin(new Insets(10,10,10,10));
		tekstområde.setBackground(Color.decode("#FFFFDE"));
		Font breadfont = new Font("Monospaced", Font.PLAIN, 13);
		tekstområde.setFont(breadfont);
		// CENTER GRID END
		
		//BOTTOM GRID START
		south = new JPanel();
		south.add(stat1);
		south.add(stat2);
		south.add(stat3);
		south.add(stat4);
		south.add(stat5);
		// BOTTOM GRID END
		
		c = getContentPane();
		c.setLayout(layout);
		c.add(north, BorderLayout.PAGE_START);
		c.add(new JLabel(""), BorderLayout.LINE_START);
		c.add(new JLabel(""), BorderLayout.LINE_END);
		c.add(utskriftområde, BorderLayout.CENTER);
		c.add(south, BorderLayout.PAGE_END);
		
		/////////// GUI LAYOUT SLUTT /////////////
		//////////////////////////////////////////
			
		Knappelytter lytter = new Knappelytter();
		
		stat1.addActionListener(lytter);
		stat2.addActionListener(lytter);
		stat3.addActionListener(lytter);
		stat4.addActionListener(lytter);
		stat5.addActionListener(lytter);
			
			setSize( 550, 500 );
			setVisible( true );
		}
	
		// Oppretter knappelytter
		private class Knappelytter implements ActionListener {
		    public void actionPerformed( ActionEvent e )
		    {
		      if ( e.getSource() == stat1 ) {
		    	  tekstområde.setText(k.totalInntektForAlleLokaler());
		      } else if ( e.getSource() == stat2) {
		    	  tekstområde.setText("Totalinntekt på tvers av alle lokaler "+Integer.toString(k.totaltSolgtAlleLokaler()));
		      } else if ( e.getSource() == stat3) {
		    	  tekstområde.setText("Her ville statistikk nummer 3 ha blitt presentert");
		      } else if ( e.getSource() == stat4) {
		    	  tekstområde.setText("Her ville statistikk nummer 4 ha blitt presentert");
		      } else if ( e.getSource() == stat5) {
		    	  tekstområde.setText("Her ville statistikk nummer 5 ha blitt presentert");
		      }
		    }
	  }
} // STATISTIKKVINDU SLUTT