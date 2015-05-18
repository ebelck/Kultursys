import java.io.Serializable;

import javax.swing.*;

import org.jdesktop.swingx.painter.AbstractLayoutPainter.HorizontalAlignment;

import java.awt.*;


public class Statistikkvindu extends JApplet implements Serializable{
	private static final long serialVersionUID = 5598407733052246255L;
	private JLabel melding = new JLabel("Denne funksjonaliteten er ikke implementert enda.", JLabel.CENTER);
	
	public Statistikkvindu(){
		getContentPane().setLayout(new GridLayout(1,1));
		getContentPane().add(melding);
		setSize( 550, 500 );
		setVisible(true);
	}
}
