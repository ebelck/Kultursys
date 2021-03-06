// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// H�gskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen � s198524
// Roger Bl�tekj�r Johannessen � s186571
// Halvor R�nneseth � s172589
//
////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen er et register over kontaktpersoner.					// 											//
//	Klassen har:														//
// 	# En liste med kontaktpersoner										//
//	# Metoder for � manipulere billettene i registeret					//
//////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.util.*;


public class Personregister implements Serializable {
	private static final long serialVersionUID = 7204488033269860044L;
	private ArrayList<Kontaktperson> reg = new ArrayList<Kontaktperson>();
	private Iterator<Kontaktperson> iterator;
	
	//////////////////
	//	KONSTRUKT�R	//
	//////////////////
	
	public Personregister(){
		ArrayList<Kontaktperson> kreg = null;
		try(ObjectInputStream innfil = new ObjectInputStream( new FileInputStream( "./regfiles/kontreg.dta" ) )){
				kreg = (ArrayList<Kontaktperson>) innfil.readObject();		//feilh�ndtering? Se warning
				innfil.close();
		}catch(FileNotFoundException eofe){
			kreg = null;
		}catch(EOFException eofe){
			eofe.printStackTrace();
		}catch(InvalidClassException ice){
			ice.printStackTrace();
		}
		catch(Exception e){
			System.out.println("Feil i lagReg() i Personregister-klassen konstrukt�r: " + e.getClass());
		}
		if(kreg == null)
			kreg = new ArrayList<Kontaktperson>();
		
		reg = kreg;
	}
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public List<Kontaktperson> get_register(){
		return reg;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////	
	
	//////////////////////////////
	//	MANIPULERINGS-METODER	//
	//////////////////////////////
	
	// Legger til en Kontakperson i Kontakpersonregisteret
	public boolean leggTilKontaktperson( Kontaktperson k){
		if(k == null)
			return false;
		reg.add(k);
		return true;
	}
	
	// Sletter en Kontaktperson fra registeret via Epost
	public boolean slettKontaktpersonViaEpost(String e){
		Kontaktperson funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_Epost().equals(e)) {
	            	reg.remove(funnet);
	            	return true;
	            }
	        }
			
		} catch(Exception ex){
			return false;
		}
		return false;
	}
	
	// Sletter en Kontaktperson fra registeret via Telefonnr
	public boolean slettKontaktpersonViaTelefon(String t){
		Kontaktperson funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_Telefon().equals(t)) {
	            	reg.remove(funnet);
	            	return true;
	            }
	        }
			
		} catch(Exception ex){
			return false;
		}
		return false;
	}
	
	// Finner en Kontaktperson fra registeret via Epost
	public Kontaktperson finnKontaktpersonViaEpost(String e){
		Kontaktperson funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_Epost().equals(e)) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	// Finner en Kontaktperson fra registeret via navn
	public Kontaktperson finnKontaktpersonViaNavn(String fn){
		Kontaktperson funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_Navn().equals(fn)) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}

	// Finner en Kontaktperson fra registeret via telefonnr
	public Kontaktperson finnKontaktpersonViaTlf(String t){
		Kontaktperson funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_Telefon().equals(t)) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	// Sjekker om kontaktperson finnes via telefonnummer
	public boolean sjekkOmFinnesTlf(String t) {
		Kontaktperson funnet = null;
		iterator = reg.iterator();
        while (iterator.hasNext()) {
        	funnet = iterator.next();
            if (funnet.get_Telefon().equals(t)) {
            	return true;
            }
        }
        return false;
	}
	
	// Sjekker om kontaktperson finnes via epost
	public boolean sjekkOmFinnesEpost(String e) {
		Kontaktperson funnet = null;
		iterator = reg.iterator();
        while (iterator.hasNext()) {
        	funnet = iterator.next();
            if (funnet.get_Epost().equals(e)) {
            	return true;
            }
        }
        return false;
	}
	
	// Lister ut alle kontaktpersoner
	public String[] listKontaktpersoner(){
		ArrayList<String> a = new ArrayList<>();
		a.add("Oppdater liste");

		for (Kontaktperson s : reg) {
			a.add(s.get_Navn());
		}
		
	    String[] s = ((ArrayList<String>)a).toArray(new String[a.size()]);
		
		return s;
	}
	
	// Finner st�rste referansenummer for kontaktperson 
	// etter lesing fra fil
	public int finnSt�rstePersNr(){
		int max = 0;
		if(!reg.isEmpty())
			for(Kontaktperson p: reg)
				if(p.get_pId() > max)
					max = p.get_pId();
		return max;
	}
	
	
	//////////////////////////////////
	//	MANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////
	
	public String toString() {
		if (reg.isEmpty()) {
			return "Ingen kontaktpersoner lagret i systemet";
		}
		String melding = "Kontaktpersoner: \r\n";
		for (Kontaktperson k : reg) {
		melding += k.toString() + "\r\n\t<<<<<#>>>>>\r\n";
		}
		return melding;
	}
	
	//////////////////////////////////////////
	//	SKRIVING OG LESING --> KONTREG.DTA	//
	//////////////////////////////////////////
		
	public String lagrePersonregister(){
		try(ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream( "./regfiles/kontreg.dta" ) )){
			utfil.writeObject( reg );
			utfil.close();
		}catch(Exception e){
			return "Feil i lagre(): " + e.getClass() + "\r\n" + e.getCause();
		}
		
		System.out.println("Suksess personregister");
		return "Suksess!";
	}
}// KLASSE BILLETTREGISTER SLUTT
