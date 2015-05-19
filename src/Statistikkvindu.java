import java.io.Serializable;

import javax.swing.*;

import org.jdesktop.swingx.painter.AbstractLayoutPainter.HorizontalAlignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Statistikkvindu extends JApplet implements Serializable{
	private static final long serialVersionUID = 5598407733052246255L;
	private JLabel melding = new JLabel("Denne funksjonaliteten er ikke implementert enda.", JLabel.CENTER);
	
	private JButton stat1,stat2,stat3,stat4,stat5;
	private JTextArea tekstområde;
	private JScrollPane utskriftområde;
	private BorderLayout layout;
	private Container c;;
	public Kulturhus k;

	private String lokalnavn = "Valg";
	private JComponent north,south;
	
	
	public Statistikkvindu(Kulturhus kH) {
		
			k = kH;


			
			stat1 = new JButton("Beregning");
			stat2 = new JButton( "Beregning" );
			stat3 = new JButton( "Beregning" );
			stat4 = new JButton( "Beregning" );
			stat5 = new JButton("Beregning");
			
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
			tekstområde = new JTextArea();
			utskriftområde = new JScrollPane(tekstområde);
			tekstområde.setEditable(false);
			utskriftområde.setForeground(Color.BLACK);
			tekstområde.setMargin(new Insets(10,10,10,10));
			tekstområde.setBackground(Color.decode("#FFFFDE"));
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
			c.add(utskriftområde, BorderLayout.CENTER);
			c.add(south, BorderLayout.PAGE_END);
			
			/////////// GUI LAYOUT SLUTT /////////////
			//////////////////////////////////////////
				
			
	
			Knappelytter lytter = new Knappelytter();
			
			//oppdaterKnapp.addActionListener(lytter);
				
				setSize( 550, 500 );
				setVisible( true );
			}
		
		private class Knappelytter implements ActionListener {
		    public void actionPerformed( ActionEvent e )
		    {
		      if ( e.getSource() == stat1 ) {
		      }
		    }
		}
}
		
	
