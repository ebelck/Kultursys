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
	private int refNr;
	private static int nesteNr = 1;
	private String navn, beskrivelse;
	private ArrayList<Arrangement> reg = new ArrayList<>();
	private Iterator<Arrangement> iterator;
	
	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Lokale (String n, String b) {
		refNr = nesteNr++;
		navn = n;
		beskrivelse = b;
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
	
	public int get_RefNr() {
		return refNr;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
	//////////////////////////////
	//	MANIPULERINGS-METODER	//
	//////////////////////////////
	
	public boolean leggTilArrangement( Arrangement a){
		if(a == null)
			return false;
		
		reg.add(a);
		return true;
	}
	
	public boolean slettArrangement(int n){
		//Kanskje legge inn en sjekk på om det er solgt billetter til arrangementet før det kan slettes?
		n = n - 1;
		try {
			reg.remove(n);
			return true;
		} catch (IndexOutOfBoundsException IOOBE) {
			return false;
		}
	}
	
	public Arrangement finnArrangement(int n){
		Arrangement funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_aId() == n) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	public String listArrangmenter(){
		String melding = "";
		for (Arrangement s : reg) {
			melding += s.toString();
		}
		return melding;
	}
	
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
		String meld = "Referansenr:\t" + get_RefNr() + "\r\n";
		meld += "Navn:\t" + get_Navn() + "\r\n";
		meld += "Beskrivelse:\t" + get_Beskrivelse() + "\r\n";
		return meld;
	}
}//KLASSE LOKALE SLUTT
