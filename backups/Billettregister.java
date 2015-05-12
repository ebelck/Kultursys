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
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public int get_antallBilletter(){
		return antallBilletter;
	}
	
	public boolean get_ledigeBilletter(){
		return ledigeBilletter;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////	
	
	//////////////////////////////
	//	MANIPULERINGS-METODER	//
	//////////////////////////////
	
	//Fyller registeret med nye billetter
	public boolean fyllRegister(int antall){
		try{
			for(int i = 0; i < antall; i++)
				reg.add(new Billett());
		}catch(Exception e){
			return false;
		}return true;
	}
		
	//Finner antallet usolgte billetter
	public int antallLedigeBilletter(){
		if(ledigeBilletter)
			return antallBilletter - antallSolgteBilletter();
		return 0;
	}
	
	//Finner antallet solgte billetter
	public int antallSolgteBilletter() {
		int antSolgt = 0;
		iterator = reg.iterator();
        
		while (iterator.hasNext()) {
			Billett b = iterator.next();
        	if (b.get_Solgt())
            	antSolgt++;
        }
		return antSolgt;
	}
	
	//Legger til nye billetter til i registeret
	public boolean leggTilBilletter(int antall){
		if(fyllRegister(antall)){
			antallBilletter = reg.size();
			ledigeBilletter = true;
			return true;
		}
		else
			return false;
	}
	
	//Fjerner billetter fra registeret
	public boolean fjernBilletter(int antall){
		if(antall > antallLedigeBilletter())
			return false;
		else{
			for(int i = 0; i < antall; i++)
				if(nesteLedigeBillett() != null)
					reg.remove(nesteLedigeBillett());
				
			antallBilletter = reg.size();
			ledigeBilletter = antallLedigeBilletter() != 0;
			return true;	
		}
	}
			
	//Finner f�rste ledige billett
	public Billett nesteLedigeBillett() {
		for(Billett b : reg)
			if(!b.get_Solgt())
				return b;
		return null;
	}
	
	//Registrerer billetter som solgt hvis det er nok ledige billetter
	public boolean kj�pBillett(int antall, Person k){
		if( (antallSolgteBilletter() + antall) > antallBilletter )
			return false;
		for(int i = 0; i < antall; i++)
			nesteLedigeBillett().selgBillett(k);
		ledigeBilletter = antallBilletter != antallSolgteBilletter();
		return true;
	}
	
	//S�ker opp Billett p� telefonnr
	public Billett finnBillett(String tlf) {
		Billett funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_kunde().get_Telefon().equals(tlf))
	            	return funnet;
	        }
		}catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	// avbestiller X billetter med telefonnr
	public boolean avbestillBilletter(int antall, String tlf){
		if(finnBillett(tlf) == null)
			return false;
		try{
			for(int i = 0; i < antall; i++)
				finnBillett(tlf).avbestillBillett();
		}catch(Exception e){
			return false;
		}
		return true;
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
