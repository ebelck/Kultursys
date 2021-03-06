// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// H�gskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen � s198524
// Roger Bl�tekj�r Johannessen � s186571
// Halvor R�nneseth � s172589
//
////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen er et register over billetter som er solgt til et 	//
//	overordnet arrangement. 											//
//	Klassen har:														//
// 	# En liste med billetter											//
// 	# Antall billetter i registeret										//
// 	# Indikator for ledige Billetter									//
//	# Metoder for � manipulere billettene i registeret					//
//////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.util.*;

public class Billettregister implements Serializable {

	private static final long serialVersionUID = 6559197877098881762L;
	private ArrayList<Billett> reg = new ArrayList<Billett>();
	
	private int antallBilletter;
	private boolean ledigeBilletter = true;
	
	//////////////////
	//	KONSTRUKT�R	//
	//////////////////
	public Billettregister() {
		// Opprettes for ikke-betalbare arrangement, for � hindre konflikt ved skriving til fil.
	}
	
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
			int x = reg.size();
			for(int i = 1; i <= antall; i++)
				reg.add(new Billett(i+x));
			return true;
		}catch(Exception e){
			return false;
		}
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
		for(Billett b : reg){
			if(b.get_Solgt())
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
	
	//S�ker opp Billett som matcher s�k
	public ArrayList<Billett> finnBilletter(String tlf){
		ArrayList<Billett> resultat = new ArrayList<Billett>();
		try{
			for(Billett b : reg){
				if(b.get_kunde() != null){
					if( b.get_kunde().get_Telefon().equals(tlf) ){
						resultat.add(b);
					}
				}
			}
			return resultat;
		}catch(Exception e){
			return resultat;
		}
	}
	
	//S�ker opp Billett som matcher telefonnr
	public Billett finnBillett(String tlf) {
		try {
			for(Billett funnet : reg){
				if(funnet.get_kunde().get_Telefon().equals(tlf)){
					return funnet;
				}
			}
		}catch(Exception ex){
			return null;
		}
		return null;
	}
	
	//S�ker opp Billett p� telefonnr
	public Billett finnBillett(int nr) {
		try{
			for(Billett b: reg)
				if(b.get_Billettnummer() == nr)
					return b;
			return null;
		}catch(Exception e){
			return null;
		}
	}
	
	// Avbestiller X billetter med telefonnr
	public boolean avbestillBilletter(int antall, String tlf){
		if(finnBillett(tlf) == null && antall > 0)
			return false;
		try{
			for(Billett b : reg){
				if(b.solgt && b.get_kunde().get_Telefon().equals(tlf)){
					b.avbestillBillett();
				}
			}
			return true;
			
		}catch(Exception e){
			return false;
		}
	}
	
	// Lister solgte billetter
	public String listSolgteBilletter(){
		String retur = "Solgte billetter: " + antallSolgteBilletter() + " av " + antallBilletter + "\r\n\r\n";
				for(Billett b : reg)
					retur += (b.get_Solgt()) ? b : "";
		return retur;
	}
	
	// Finner h�yeste billettnummer
	public int finn_h�yeste_bNr(){
		if(reg.isEmpty())
			return 0;
		else{
			int max = reg.get(0).get_Billettnummer();
			for(Billett b: reg)
				if(b.get_Billettnummer() > max)
					max = b.get_Billettnummer();
			return max;
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
