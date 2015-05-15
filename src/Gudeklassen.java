 import javax.swing.*;

import java.io.Serializable;

 public class Gudeklassen extends JPanel implements Serializable {

	private static final long serialVersionUID = 8441157301330300870L;
 
	public static void main(String[] args) {
		
 		Kulturhus k = new Kulturhus("Testehuset","This is fucked");
 		Personregister reg = new Personregister();
		Adminvindu admin = new Adminvindu(k,reg);
		
		Object[] options = {"Administrasjonen",
                "Brukerportalen",};
		int n = JOptionPane.showOptionDialog(null,
		"Hvilket system ønsker du å åpne?",
		"Velkommen til " + k.get_Navn(),
		JOptionPane.OK_CANCEL_OPTION,
		JOptionPane.PLAIN_MESSAGE,
		null,
		options,
		options[0]);
		if (n == 1) {
			admin.createUser();
		} else {
			admin.createAdmin();
		}


	}

 }
