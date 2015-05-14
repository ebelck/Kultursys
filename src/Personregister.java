////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen er et register over kontaktpersoner.					// 											//
//	Klassen har:														//
// 	# En liste med kontaktpersoner										//
//	# Metoder for å manipulere billettene i registeret					//
//////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class Personregister {
	
	private List<Kontaktperson> reg = new ArrayList<Kontaktperson>();
	private Iterator<Kontaktperson> iterator;
	
	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Personregister(){
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
	
	//Legger til en Kontakperson i Kontakpersonregisteret
	public boolean leggTilKontaktperson( Kontaktperson k){
		if(k == null)
			return false;
		reg.add(k);
		return true;
	}
	
	//Sletter en Kontaktperson fra registeret via Epost
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
	
	//Sletter en Kontaktperson fra registeret via Telefonnr
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
	
	//finner en Kontaktperson fra registeret via Epost
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
	
	//finner en Kontaktperson fra registeret via navn
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

	//finner en Kontaktperson fra registeret via telefonnr
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
	
	//lister ut alle kontaktpersoner
	public String[] listKontaktpersoner(){
		ArrayList<String> a = new ArrayList<>();
		a.add("Oppdater liste");

		for (Kontaktperson s : reg) {
			//a.add(s.get_Fornavn() + " " + a.add(s.get_Etternavn()));
			a.add(s.get_Navn());
		}
		
	    String[] s = ((ArrayList<String>)a).toArray(new String[a.size()]);
		
		return s;
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
}// KLASSE BILLETTREGISTER SLUTT

