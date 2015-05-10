////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen er et register over billetter som er solgt til et 	//
//	overordnet arrangement. 											//
//	Klassen har:														//
// 	# En liste med billetter											//
// 	# Antall billetter i registeret										//
// 	# Indikator for ledige Billetter									//
//	# Metoder for � manipulere billettene i registeret					//
//////////////////////////////////////////////////////////////////////////

import java.io.Serializable;
import java.util.*;

public class Billettregister implements Serializable{
	
	private List<Billett> reg = new ArrayList<Billett>();
	private Iterator<Billett> iterator;
	
	private int antallBilletter;
	private boolean ledigeBilletter = true;
	
	//////////////////
	//	KONSTRUKT�R	//
	//////////////////
	
	public Billettregister(int n){
		antallBilletter = n;
		fyllRegister(n);
	}
	
	//////////////////////////////
	//	MANIPULERINGS-METODER	//
	//////////////////////////////
	
	public void fyllRegister(int antall){
	//Fyller registeret med nye billetter
		for(int i = 0; i < antall; i++)
			reg.add(new Billett());
	}
	
	public void leggTilBilletter(int antall){
	//Legger til nye billetter i registeret
		fyllRegister(antall);
		antallBilletter = reg.size();
		ledigeBilletter = true;
	}
	
	public int antallSolgteBilletter() {
	//Finner antallet solgte billetter
		int antSolgt = 0;
		iterator = reg.iterator();
        
		while (iterator.hasNext()) {
			Billett b = iterator.next();
        	if (b.get_Solgt())
            	antSolgt++;
        }
		return antSolgt;
	}
	
	public Billett nesteLedigeBillett() {
	//Finner f�rste ledige billett
		for(Billett b : reg)
			if(!b.get_Solgt())
				return b;
		return null;
	}
	
	public boolean selgBillett(int antall, String f, String e, String eP, String t){
		//Registrerer billetter som solgt hvis det er nok ledige billetter
			if( antallSolgteBilletter() + antall > antallBilletter )
				return false;
			for(int i = 0; i < antall; i++)
				nesteLedigeBillett().selgBillett(f, e, eP, t);
			ledigeBilletter = antallBilletter == antallSolgteBilletter();
			return true;
		}
		
	public Billett finnBillett(String tlf) {
	//S�ker opp Billett p� telefonnr
		Billett funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_Tlf().equals(tlf))
	            	return funnet;
	        }
		}catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	
	//////////////////////////////////
	//	MANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////
	
	public String toString() {
		String melding = "Billetter: \r\n";
		for (Billett b : reg) {
			melding += b.toString() + "\r\n\t<<<<<#>>>>>\r\n";
		}
		return melding;
	}
} // KLASSE BILLETTREGISTER SLUTT
