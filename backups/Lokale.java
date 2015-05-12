////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen inneholder informasjon om lokalene:					//
//	# Referansenr for lokalet											//
//	# Neste referansenummer												//
//	# Navn på lokalet													//
//	# Beskrivelse av lokalet											//
//	# Register over arrangement til knyttet lokalet						//
//	# Metoder for å manipulere arrangementet og bilettregisteret		//
//////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class Lokale {
	private int plasser, refNr;
	private static int nesteNr = 1;
	private String navn, beskrivelse, type;
	
	
	private ArrayList<Arrangement> reg = new ArrayList<>();
	private Iterator<Arrangement> iterator;
	
	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Lokale (String n, String b) { // her kommer String t, int p
		refNr = nesteNr++;
		navn = n;
		beskrivelse = b;
//		type = t;
//		plasser = p
	}
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public String get_Navn() {
		return navn;
	}
	
	public String get_Beskrivelse() {
		return beskrivelse;
	}
	
	public String get_Type() {
		return type;
	}
	public int get_RefNr() {
		return refNr;
	}
	
	public int get_Plasser() {
		return plasser;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
	//////////////////////////////
	//	MANIPULERINGS-METODER	//
	//////////////////////////////
	
	// Sjekker om registere for de forskjellige arrangementene er tomme
	public boolean tomtRegister(){
		return reg.isEmpty();
	}
	
	//legger til et nytt arrangement
	public boolean leggTilArrangement( Arrangement a){
		if(a == null)
			return false;
		
		reg.add(a);
		return true;
	}
	
	//sletter arangement med get_aId = n
	public boolean slettArrangement(int n){
		try {
			for(Arrangement slett : reg){
				if(slett.get_aId() == n){
					//kontrollerer at det ikke er solgt billetter til arrangementet
					//if(slett.antallSolgteBilletter() > 0)
						//return false;
					
					// Kommentert ut fordi vi må sende med rikitge parametere slik at 
					// funksjonen returnerer en verdi.
					////////////////////////
					
					reg.remove(slett);
					reg.trimToSize();
					return true;
				}
			}
		} catch (IndexOutOfBoundsException IOOBE) {
			return false;
		}
		return false;
	}
	
	//finner arrangement med index n
	public Arrangement finnArrangement(int n){

		try {
			for(Arrangement funnet : reg)
				if(funnet.get_aId() == n)
					return funnet;
	        
			
		} catch(Exception ex){
			return null;
		}
		return null;
	}
	
	//lister ut alle arrangementene tilknyttet lokalet
	public String listArrangementer(){
		if(reg.isEmpty())
			return "Ingen arrangementer lagret";
		
		String melding = "";
		for (Arrangement s : reg) {
			melding += s.toString();
		}
		return melding;
	}
	
	//VAT IZ DIZ?
	public HashSet<Arrangement> kontaktOpplysning(Kontaktperson k) {
		HashSet<Arrangement> arrHash = new HashSet<>();
		for (Arrangement s : reg) {
			if (s.get_Kontaktperson().equals(k)) 
				arrHash.add(s);
		}
		return arrHash;
	}
	
	//////////////////////////////////
	//	MANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////
	
	public String toString() {
		String meld = "LOKALENR:\t" + get_RefNr() + "\r\n";
		meld += "Navn:\t\t" + get_Navn() + "\r\n";
		meld += "Beskrivelse:\t" + get_Beskrivelse() + "\r\n";
		return meld;
	}
}//KLASSE LOKALE SLUTT
