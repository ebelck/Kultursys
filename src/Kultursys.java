import javax.swing.*;
import java.io.*;

 public class Kultursys extends JPanel implements Serializable {

	private static final long serialVersionUID = 8441157301330300870L;
 
	public static void main(String[] args) {
		
		// Oppretter Kulturhus
 		Kulturhus k = new Kulturhus("Indre Bortibygda kulturhus","Indre Bortibygda kommunes kulturhus.\r\nStorgata 17, 4891 INDRE BORTIBYGDA\r\nkulturhuset@indrebortibygda.kommune.no - tel: 55 56 67 77");
 		
 		// Setter riktige referansenummer etter oppretting fra fil
 		k.settRiktigBillNr();
 		k.settRiktigArrNr();
 		k.settRiktigLokNr();
 		
 		// Oppretter Personregister
 		Personregister reg = new Personregister();
 		k.settRiktigPersNr();
 		
 		// Oppretter Adminvindu
		Adminvindu admin = new Adminvindu(k,reg);
		
		Object[] valg = {"Administrasjonen", "Brukerportalen",};
		int n = JOptionPane.showOptionDialog(null,
				"Hvilket system ønsker du å åpne?",
				"Velkommen til Kultursys",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null,
				valg,
				null);
		if(n == JOptionPane.YES_OPTION){
			admin.createAdmin();
		}else if(n == JOptionPane.NO_OPTION){
			admin.createUser();
		}else if(n == JOptionPane.CLOSED_OPTION){
			
		}
	}
 }// Kultursys slutt
