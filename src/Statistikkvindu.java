import java.io.Serializable;

import javax.swing.*;

import org.jdesktop.swingx.painter.AbstractLayoutPainter.HorizontalAlignment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Statistikkvindu extends JApplet implements Serializable{
	private static final long serialVersionUID = 5598407733052246255L;
	private JLabel l;
	
	private JButton stat1,stat2,stat3,stat4,stat5;
	private JTextArea tekstområde1;
	private JTextPane tekstområde;
	private JScrollPane utskriftområde;
	private BorderLayout layout;
	private Container c;;
	public Kulturhus k;

	private String lokalnavn = "Valg";
	private JComponent north,south;
	
	
	public Statistikkvindu(Kulturhus kH) {
			
		k = kH;
		
		l = new JLabel("Click me");
		l.setCursor(new Cursor(Cursor.HAND_CURSOR));
		l.addMouseListener(new MouseAdapter(){
		   public void mouseClicked(MouseEvent me)
		   {
		         l.setText("Clicked!");
		   }
		});
			
		stat1 = new JButton("Beregning1");
		stat2 = new JButton( "Beregning2" );
		stat3 = new JButton( "Beregning3" );
		stat4 = new JButton( "Beregning4" );
		stat5 = new JButton("Beregning5");
		
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
			
			setSize( 550, 500 );
			setVisible( true );
		}
	
		private class Knappelytter implements ActionListener {
		    public void actionPerformed( ActionEvent e )
		    {
		      if ( e.getSource() == stat1 ) {
		    	  tekstområde.insertComponent(l);
		      }
		    }
		}
}
		
	
