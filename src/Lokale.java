////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen inneholder informasjon om lokalene:					//
//	# Referansenr for lokalet											//
//	# Neste referansenummer												//
//	# Navn på lokalet													//
//	# Beskrivelse av lokalet											//
//	# Register over arrangement til knyttet lokalet						//
//	# Metoder for å manipulere arrangementet og bilettregisteret		//
//////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.io.*;


public class Lokale implements Serializable{

	private static final long serialVersionUID = 1382938975339463705L;
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
	
	public Lokale(){
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
	
	public ArrayList<Arrangement> get_reg(){
		return reg;
	}
	public void set_Navn(String s) {
		navn = s;
	}
	public void set_Besk(String s) {
		beskrivelse = s;
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
	public boolean slettArrangement(int n){ //mottar en arrangementsID
		try {
			for(Arrangement slett : reg){
				if(slett.get_aId() == n){		//Finner matchende ID
					//Hvis billettsalg er false eller antall solgte billetter er 0
					if(!slett.get_Billettsalg() || slett.antallSolgteBilletter() == 0) {
						reg.remove(slett);
						reg.trimToSize();
						return true;
					}
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
		System.out.println("Lister ut arrangement");
		if(reg.isEmpty())
			return "Ingen arrangementer lagret";
		
		String melding = "";
		for (Arrangement s : reg) {
			melding += s.toString();
		}
		return melding;
	}
	
	public ArrayList<Arrangement> hentArrObjekter(){
		ArrayList<Arrangement> arrReg = new ArrayList<Arrangement>();
		System.out.println("Lister ut arrangement");
		if(reg.isEmpty()) {
			System.out.println("reg er null");
			return null;
		}
		
		for (Arrangement s : reg) {
			System.out.println("inne i hentARrObjekter sin for");
			if(s != null)
				arrReg.add(s);
		}
		return arrReg;
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
	
	//////////////////////
	//	BILLETT-METODER	//
	//////////////////////
	
	public Billett finnBillett(int nr){
		try{
			for(Arrangement a: reg)
				if(a.finnBillett(nr) != null)
					return a.finnBillett(nr);
		}catch(Exception e){
			return null;
		}
		return null;
	}
	
	//////////////////////////////
	//	BILLETT-METODER SLUTT	//
	//////////////////////////////
	
	public String toString() {
		String meld = "LOKALENR:\t" + get_RefNr() + "\r\n";
		meld += "Navn:\t\t" + get_Navn() + "\r\n";
		meld += "Beskrivelse:\t" + get_Beskrivelse() + "\r\n";
		return meld;
	}
}//KLASSE LOKALE SLUTT
