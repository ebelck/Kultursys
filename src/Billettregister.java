////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen er et register over billetter som er solgt til et 	//
//	overordnet arrangement. 											//
//	Klassen har:														//
// 	# En liste med billetter											//
// 	# Antall billetter i registeret										//
// 	# Indikator for ledige Billetter									//
//	# Metoder for å manipulere billettene i registeret					//
//////////////////////////////////////////////////////////////////////////

import java.io.Serializable;
import java.util.*;

public class Billettregister implements Serializable{
	
	private List<Billett> reg = new ArrayList<Billett>();
	private Iterator<Billett> iterator;
	
	private int antallBilletter;
	private boolean ledigeBilletter = true;
	
	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Billettregister(int n){
		antallBilletter = n;
		fyllRegister(n);
	}
	public int antallBilletter(){
		return antallBilletter;
	}
	
	public boolean get_ledigeBilletter(){
		return ledigeBilletter;
	}
	
	public int get_antallLedigeBilletter(){
		if(ledigeBilletter)
			return antallBilletter - antallSolgteBilletter();
		
		return 0;
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
	//Finner første ledige billett
		for(Billett b : reg)
			if(!b.get_Solgt())
				return b;
		return null;
	}
	
	public boolean selgBillett(int antall, Person k){
		//Registrerer billetter som solgt hvis det er nok ledige billetter
			if( antallSolgteBilletter() + antall > antallBilletter )
				return false;
			for(int i = 0; i < antall; i++)
				nesteLedigeBillett().selgBillett(k);
			ledigeBilletter = antallBilletter == antallSolgteBilletter();
			return true;
		}
	
	public Billett finnBillett(String tlf) {
	//Søker opp Billett på telefonnr
		Billett funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.kunde.get_Telefon().equals(tlf))
	            	return funnet;
	        }
		}catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	public void avbestillBilletter(int antall, String tlf){
	// avbestiller X billetter med telefonnr
		for(int i = 0; i < antall; i++){
			finnBillett(tlf).avbestillBillett();
		}
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
}// KLASSE BILLETTREGISTER SLUTT
