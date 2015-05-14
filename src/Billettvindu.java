import java.awt.*;
import java.util.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Billettvindu extends JApplet {
	
	private JPanel top, lokvalg, arrvalg, knapprad, tekstvindu;
	private JComboBox velgLokale, velgArrangement;
	private JButton bestillKnapp, avbestillKnapp;
	private JTextArea melding;
	
	public Billettvindu() {
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		//TOP-PANEL START
		top = new JPanel();
		getContentPane().add(top, BorderLayout.NORTH);
		top.setLayout(new GridLayout(3, 1, 0, 0));
		
		//LOAKLEVELGER START
		lokvalg = new JPanel();
		top.add(lokvalg);
		lokvalg.setLayout(new GridLayout(1, 1, 0, 0));
		
		velgLokale = new JComboBox();
		lokvalg.add(velgLokale);
		
		//LOAKLEVELGER SLUTT
		
		//ARRANGEMENTVELGER START
		arrvalg = new JPanel();
		top.add(arrvalg);
		arrvalg.setLayout(new GridLayout(1, 0, 0, 0));
		
		velgArrangement = new JComboBox();
		arrvalg.add(velgArrangement);
		
		//ARRANGREMENTVELGER SLUTT
		
		//KNAPPERAD START
		knapprad = new JPanel();
		top.add(knapprad);
		knapprad.setLayout(new GridLayout(1, 2, 0, 0));
		
		bestillKnapp = new JButton("Bestill");
		knapprad.add(bestillKnapp);
		
		avbestillKnapp = new JButton("Avbestill");
		knapprad.add(avbestillKnapp);
		
		//KNAPPERAD SLUTT
		//TOPP-PANEL SLUTT
		
		//MIDT-PANEL START
		JPanel tekstvindu = new JPanel();
		getContentPane().add(tekstvindu, BorderLayout.CENTER);
		tekstvindu.setLayout(new GridLayout(1, 1, 0, 0));
		
		melding = new JTextArea();
		melding.setEditable(false);
		melding.setText("");
		tekstvindu.add(melding);
		
		//MIDT-PANEL SLUTT
	}
}
