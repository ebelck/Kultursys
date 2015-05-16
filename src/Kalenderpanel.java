import java.awt.GridLayout;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import java.text.ParseException;
import java.io.*;

public class Kalenderpanel extends JPanel implements Serializable {

	private static final long serialVersionUID = 6232934909805443923L;
	JTextField tid = new JTextField("00:00");
	JPanel panelHead = new JPanel(new GridLayout(1,2));
	JXDatePicker kalender;
	private SimpleDateFormat sdf;
	
	public Kalenderpanel() {
		 kalender = new JXDatePicker();
		 kalender.setDate(Calendar.getInstance().getTime());
		 sdf = new SimpleDateFormat("dd.MM.yyyy");
		 kalender.setFormats(sdf);
	}
	public JPanel makePanels() {
		tid.setHorizontalAlignment(JTextField.CENTER);
		panelHead.add(tid);
		panelHead.add(kalender);
		return panelHead;
	}
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
}
