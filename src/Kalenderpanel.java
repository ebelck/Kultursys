// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// Høgskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen – s198524
// Roger Bløtekjær Johannessen – s186571
// Halvor Rønneseth – s172589
//
////////////////////////////////BESKRIVELSE///////////////////////////////
// Denne klassen håndterer Dato input fra bruker						//
//////////////////////////////////////////////////////////////////////////

import java.awt.*;
import java.util.*;
import java.text.*;
import javax.swing.*;
import org.jdesktop.swingx.JXDatePicker;
import java.io.*;

public class Kalenderpanel extends JPanel implements Serializable {

	private static final long serialVersionUID = 6232934909805443923L;
	JTextField tid = new JTextField("00:00");
	JPanel panelHead = new JPanel(new GridLayout(1,2));
	JXDatePicker kalender;
	private SimpleDateFormat sdf;
	
	// Oppretter Kalenderpanelet
	public Kalenderpanel() {
		 kalender = new JXDatePicker();
		 kalender.setDate(Calendar.getInstance().getTime());
		 sdf = new SimpleDateFormat("dd.MM.yyyy");
		 kalender.setFormats(sdf);
	}
	
	// Lager paneler
	public JPanel makePanels() {
		tid.setHorizontalAlignment(JTextField.CENTER);
		panelHead.add(tid);
		panelHead.add(kalender);
		return panelHead;
	}
	
	// Henter dato fra bruker
	public Date hentDato() {
		Date dato = kalender.getDate();
		String s = sdf.format(dato);
		s += " " + tid.getText();
		try {
			sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
			dato = sdf.parse(s);
			return dato;
		} catch (ParseException e) {
			e.printStackTrace();
			return dato;
		}
	}
} // Kalenderpanel slutt
