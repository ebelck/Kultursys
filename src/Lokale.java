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
	
	public boolean tomtRegister(){
		return reg.isEmpty();
	}
	
	public boolean leggTilArrangement( Arrangement a){
		if(a == null)
			return false;
		
		reg.add(a);
		reg.trimToSize();
		return true;
	}
	
	public boolean slettArrangement(int n){
		//Kanskje legge inn en sjekk på om det er solgt billetter til arrangementet før det kan slettes?
		try {
			for(Arrangement slett : reg){
				if(slett.get_aId() == n){
					System.out.println(slett);
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
	
	public String listArrangementer(){
		String melding = "";
		for (Arrangement s : reg)
			melding += s.toString();
		
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
		String meld = "LOKALENR:\t" + get_RefNr() + "\r\n";
		meld += "Navn:\t\t" + get_Navn() + "\r\n";
		meld += "Beskrivelse:\t" + get_Beskrivelse() + "\r\n";
		return meld;
	}
}//KLASSE LOKALE SLUTT
