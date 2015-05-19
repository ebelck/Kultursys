 import javax.swing.*;

import java.io.Serializable;

 public class Gudeklassen extends JPanel implements Serializable {

	private static final long serialVersionUID = 8441157301330300870L;
 
	public static void main(String[] args) {
		
 		Kulturhus k = new Kulturhus("Indre Bortibygda kulturhus","Indre Bortibygda kommunes kulturhus.\r\nStorgata 17, 4891 INDRE BORTIBYGDA\r\nkulturhuset@indrebortibygda.kommune.no - tel: 55 56 67 77");
 		k.settRiktigBillNr();
 		k.settRiktigArrNr();
 		k.settRiktigLokNr();
 		
 		Personregister reg = new Personregister();
 		k.settRiktigPersNr();
 		
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
			//Vinduet ble lukket utan at bruker tok et valg
		}else{
			//Hvordan kom du hit?
		}
	}//MAIN-METODE SLUTT
 }//KLASSE SLUTT
