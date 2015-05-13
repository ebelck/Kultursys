import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;

public class Kalenderpanel extends JPanel {
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
		panelHead.add(tid);
		panelHead.add(kalender);
		return panelHead;
	}
}
