import java.io.*;
import java.util.*;

public class Kulturhus implements Serializable {
	Lokale l;
	private String beskrivelse, navn;
	private ArrayList<Lokale> lreg = new ArrayList<Lokale>();
	private Iterator<Lokale> iterator;
	private Personregister preg = new Personregister();
	
	//////////////////////
	//	KONSTRUKTØRER	//
	//////////////////////	
	
	public Kulturhus (String n, String b) {
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

	//////////////////////

	public void set_Navn(String n) {
		navn = n;
	}
	public void set_Beskrivelse(String b) {
		beskrivelse = b;
	}

	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
	/////////////////////////////////////////////
	//	LAGRE PERSONREGISTER, BILLETTREGISTER, //
	//  ARRANGEMENTER OG LOKALER TIL FIL	   //
	/////////////////////////////////////////////
	
	public void lagre() {
		lagreLokaler();
		//preg.lagrePersonregister();
		//l.lagre();
		
	}

	
	
	//////////////////////////////////
	//	LOKALEMANIPULERINGS-METODER	//
	//////////////////////////////////
	
	public boolean leggTilLokale( Lokale l){
		if(l == null)
			return false;
		
		lreg.add(l);
		return true;
	}
	
	public boolean slettLokale(int n){
		n = n - 1;
		try {
			lreg.remove(n);
			return true;
		} catch (IndexOutOfBoundsException IOOBE) {
			return false;
		}
	}
	
	public Lokale finnLokale(int n){
		Lokale funnet = null;
		try {
			iterator = lreg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_RefNr() == n) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	public String listLokaler(){
		String melding = "";
		for (Lokale s : lreg) {
			melding += s.toString();
		}
		return melding;
	}
	
	public String listArrangementerILokaler() {
		String melding = "";
		for (Lokale s : lreg) {
			melding += "LOKALE:\t" + s.get_Navn() + "\r\n";
			if(!s.tomtRegister())
				melding += s.listArrangementer();
			else
				melding += "Ingen arrangementer\r\n";
		}
		return melding;
	}
	
	public String listArrangement(String n){
		for(Lokale l: lreg)
			if(l.get_Navn().equals(n))
				return l.listArrangementer();
		
		return "Fant ikke lokale";
	}
	
	public String listArrangementDato(){
		String melding = "";
		LinkedList<Arrangement >liste = new LinkedList<Arrangement>();
		Iterator<Arrangement> knut = liste.iterator();
		for(Lokale l : lreg)
			liste.addAll(l.get_reg());
		
		Date idag = new Date();
		while(knut.hasNext())
			Arrangement a = knut.next();
		}
	}
	

	public String[] lokalListe() {
		ArrayList<String> a = new ArrayList<>();
		a.add("Oppdater liste");

		for (Lokale s : lreg) {
			a.add(s.get_Navn());
		}
		
	    String[] s = ((ArrayList<String>)a).toArray(new String[a.size()]);
		
		return s;
	}
	public Lokale arrangementViaK(int n) {
		Lokale l = null;
		
		iterator = lreg.iterator();
        while (iterator.hasNext()) {
        	l = iterator.next();
            if (l.finnArrangement(n) != null) {
            	return l;
            }
        }
        return l;
	}
	
	public Lokale finnType(String s) {
		Lokale funnet = null;
		try {
			iterator = lreg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_Navn().equals(s)) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	//////////////////////////////////////////
	//	LOKALEMANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////////////

	//////////////////////
	//	BILLETT-METODER	//
	//////////////////////
	
	public boolean bestillBillett(int id, int antall, Person k){
		for(Lokale l : lreg){
			if(l.finnArrangement(id) != null)
				return l.finnArrangement(id).bestillBillett(antall, k);
		}
		return false;
	}
	
	public Billett finnBillett(int nr){
		for(Lokale l: lreg)
			if(l.finnBillett(nr) != null)
				return l.finnBillett(nr);
		return null;
	}
	
	//////////////////////////////
	//	BILLETT-METODER SLUTT	//
	//////////////////////////////
	
	
	//////////////////////////////////////////
	//	PERSONLOKALEMANIPULERINGS-METODER	//
	//////////////////////////////////////////
	
	//Legger til en Kontakperson i Kontakpersonregisteret
	public boolean leggTilKontaktperson( Kontaktperson k){
		return preg.leggTilKontaktperson(k);
//		if(k == null)
//			return false;
//		kontaktInhouse.add(k);
//		return true;
	}

	//Sletter en Kontaktperson fra registeret via Epost
	public boolean slettKontaktpersonViaEpost(String e){
		return preg.slettKontaktpersonViaEpost(e);
//		Kontaktperson funnet = null;
//		try {
//			kontaktIterator = kontaktInhouse.iterator();
//	        while (iterator.hasNext()) {
//	        	funnet = kontaktIterator.next();
//	            if (funnet.get_Epost().equals(e)) {
//	            	kontaktInhouse.remove(funnet);
//	            	return true;
//	            }
//	        }
//			
//		} catch(Exception ex){
//			return false;
//		}
//		return false;
	}
	
	//Sletter en Kontaktperson fra registeret via Telefonnr
	public boolean slettKontaktpersonViaTelefon(String t){
		return preg.slettKontaktpersonViaTelefon(t);
//		Kontaktperson funnet = null;
//		try {
//			kontaktIterator = kontaktInhouse.iterator();
//	        while (iterator.hasNext()) {
//	        	funnet = kontaktIterator.next();
//	            if (funnet.get_Telefon().equals(t)) {
//	            	kontaktInhouse.remove(funnet);
//	            	return true;
//	            }
//	        }
//			
//		} catch(Exception ex){
//			return false;
//		}
//		return false;
	}
	
	//finner en Kontaktperson fra registeret via Epost
	public Kontaktperson finnKontaktpersonViaEpost(String e){	
		return preg.finnKontaktpersonViaEpost(e);
//		Kontaktperson funnet = null;
//		try {
//			kontaktIterator = kontaktInhouse.iterator();
//	        while (iterator.hasNext()) {
//	        	funnet = kontaktIterator.next();
//	            if (funnet.get_Epost().equals(e)) {
//	            	return funnet;
//	            }
//	        }
//			
//		} catch(Exception ex){
//			return funnet;
//		}
//		return funnet;
	}
	
	//finner en Kontaktperson fra registeret via navn
	public Kontaktperson finnKontaktpersonViaNavn(String fn){	//OBS! OBS! Må justeres til ny Personklasse
		return preg.finnKontaktpersonViaNavn(fn);
//		Kontaktperson funnet = null;
//		try {
//			kontaktIterator = kontaktInhouse.iterator();
//	        while (iterator.hasNext()) {
//	        	funnet = kontaktIterator.next();
//	            if (funnet.get_Navn().equals(fn)) {
//	            	return funnet;
//	            }
//	        }
//			
//		} catch(Exception ex){
//			return funnet;
//		}
//		return funnet;
	}

	//finner en Kontaktperson fra registeret via telefonnr
	public Kontaktperson finnKontaktpersonViaTlf(String t){
		return preg.finnKontaktpersonViaTlf(t);
//		Kontaktperson funnet = null;
//		try {
//			kontaktIterator = kontaktInhouse.iterator();
//	        while (iterator.hasNext()) {
//	        	funnet = kontaktIterator.next();
//	            if (funnet.get_Telefon().equals(t)) {
//	            	return funnet;
//	            }
//	        }
//			
//		} catch(Exception ex){
//			return funnet;
//		}
//		return funnet;
	}
	
	//lister ut alle kontaktpersoner
	public String[] listKontaktpersoner(){
		return preg.listKontaktpersoner();
//		ArrayList<String> a = new ArrayList<>();
//		a.add("Oppdater liste");
//
//		for (Kontaktperson s : kontaktInhouse) {
//			a.add(s.get_Fornavn() + " " + a.add(s.get_Etternavn()));
//		}
//		
//	    String[] s = ((ArrayList<String>)a).toArray(new String[a.size()]);
//		
//		return s;
	}
	
	public String kontaktDetaljerTlf(String t) {
		String melding = "";
		Kontaktperson person = finnKontaktpersonViaTlf(t);
		melding += person.toString();
		HashSet<Arrangement> arrHash = new HashSet<>();
		for (Lokale l : lreg) {
			arrHash.addAll(l.kontaktOpplysning(person));
		}
		melding += "* Kontaktperson for følgende *";
		Arrangement[] hashToString = arrHash.toArray(new Arrangement[arrHash.size()]);
		for (Arrangement a : hashToString) {
			melding += a.toString();
		}
		return melding;
	}
	
	public String kontaktDetaljerEpost(String e) {
		String melding = "";
		Kontaktperson person = finnKontaktpersonViaEpost(e);
		melding += person.toString();
		HashSet<Arrangement> arrHash = new HashSet<>();
		for (Lokale l : lreg) {
			arrHash.addAll(l.kontaktOpplysning(person));
		}
		melding += "* Kontaktperson for følgende *";
		Arrangement[] hashToString = arrHash.toArray(new Arrangement[arrHash.size()]);
		for (Arrangement a : hashToString) {
			melding += a.toString();
		}
		return melding;
	}

	//////////////////////////////////////////////
	//	PERSONLOKALEMANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////////////////
	

	
	public String toString() {
		return get_Navn() + "- " + get_Beskrivelse();
	}
	
	//////////////////////////////////
	//	LAGRE PERSONREGISTER OG 	//
	//	LOKALER TIL FILER			//
	//////////////////////////////////

	public String lagreLokaler() {
		try(ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream( "./regfiles/lokreg.dta" ) )){

				utfil.writeObject( lreg );
				utfil.close();
				
		}catch(IOException e){
			return "Feil i lagre(): " + e.getClass() + "\r\n" + e.getCause() ;
		} 
		
		System.out.println("Suksett\r\n");
		return "Suksess!";
	}

	public ArrayList<Lokale> lagLokaler(){
		List<Lokale> reg = null;
		try(ObjectInputStream innfil = new ObjectInputStream( new FileInputStream( "./regfiles/lokreg.dta" ) )){	
			reg = (ArrayList<Lokale>) innfil.readObject();
			innfil.close();
		}catch(FileNotFoundException fnfe){
			reg = null;
		}catch(EOFException eofe){
	
		}catch(InvalidClassException ice){
			
		}
		catch(Exception e){
			System.out.println("Feil i lagReg(): " + e.getClass() + "\r\n" +  e.getCause());
		}
		if(reg == null)
			reg = new ArrayList<Lokale>();
		
		return lreg = (ArrayList<Lokale>) reg;
	}
	
	
}//KLASSE KULTURHUS SLUTT
