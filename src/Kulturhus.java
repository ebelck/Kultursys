import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Kulturhus {
	private String beskrivelse, navn;
	private ArrayList<Lokale> LokalerInhouse = new ArrayList<>();
	private Iterator<Lokale> iterator;
	private ArrayList<Kontaktperson> kontaktInhouse = new ArrayList<>();
	private Iterator<Kontaktperson> kontaktIterator;
	
	public Kulturhus (String n, String b) {
		navn = n;
		beskrivelse = b;	
	}
	
	
	 /*//////////////////////////
	  LOKALE MANIPULERING START
	 *//////////////////////////
	
	public boolean leggTilLokale( Lokale l){
		if(l == null)
			return false;
		
		LokalerInhouse.add(l);
		return true;
	}
	
	public boolean slettLokale(int n){
		n = n - 1;
		try {
			LokalerInhouse.remove(n);
			return true;
		} catch (IndexOutOfBoundsException IOOBE) {
			return false;
		}
	}
	
	public Lokale finnLokale(int n){
		Lokale funnet = null;
		try {
			iterator = LokalerInhouse.iterator();
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
		for (Lokale s : LokalerInhouse) {
			melding += s.toString();
		}
		return melding;
	}
	
	public String listArrangementerILokaler() {
		String melding = "";
		for (Lokale s : LokalerInhouse) {
			melding += s.listArrangmenter();
		}
		return melding;
	}
	

	public String[] lokalListe() {
		ArrayList<String> a = new ArrayList<>();
		a.add("Oppdater liste");

		for (Lokale s : LokalerInhouse) {
			a.add(s.get_Navn());
		}
		
	    String[] s = ((ArrayList<String>)a).toArray(new String[a.size()]);
		
		return s;
	}
	public Lokale arrangementViaK(int n) {
		Lokale l = null;
		
		iterator = LokalerInhouse.iterator();
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
			iterator = LokalerInhouse.iterator();
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
	 /*//////////////////////////
	  LOKALE MANIPULERING FINISH
	 *//////////////////////////
	
	
	 /*//////////////////////////
	  KONTAKTPERSON MANIPULERING START
	 *//////////////////////////
	
	public boolean leggTilKontaktperson( Kontaktperson k){
		if(k == null)
			return false;
		kontaktInhouse.add(k);
		return true;
	}
	
	public boolean slettKontaktpersonViaEpost(String e){
		Kontaktperson funnet = null;
		try {
			kontaktIterator = kontaktInhouse.iterator();
	        while (iterator.hasNext()) {
	        	funnet = kontaktIterator.next();
	            if (funnet.get_Epost().equals(e)) {
	            	kontaktInhouse.remove(funnet);
	            	return true;
	            }
	        }
			
		} catch(Exception ex){
			return false;
		}
		return false;
	}
	
	public boolean slettKontaktpersonViaTelefon(String t){
		Kontaktperson funnet = null;
		try {
			kontaktIterator = kontaktInhouse.iterator();
	        while (iterator.hasNext()) {
	        	funnet = kontaktIterator.next();
	            if (funnet.get_Telefon().equals(t)) {
	            	kontaktInhouse.remove(funnet);
	            	return true;
	            }
	        }
			
		} catch(Exception ex){
			return false;
		}
		return false;
	}
	
	public Kontaktperson finnKontaktpersonViaEpost(String e){
		Kontaktperson funnet = null;
		try {
			kontaktIterator = kontaktInhouse.iterator();
	        while (iterator.hasNext()) {
	        	funnet = kontaktIterator.next();
	            if (funnet.get_Epost().equals(e)) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	public Kontaktperson finnKontaktpersonViaNavn(String fn){
		Kontaktperson funnet = null;
		try {
			kontaktIterator = kontaktInhouse.iterator();
	        while (iterator.hasNext()) {
	        	funnet = kontaktIterator.next();
	            if (funnet.get_Navn().equals(fn)) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}

	public Kontaktperson finnKontaktpersonViaTlf(String t){
		Kontaktperson funnet = null;
		try {
			kontaktIterator = kontaktInhouse.iterator();
	        while (iterator.hasNext()) {
	        	funnet = kontaktIterator.next();
	            if (funnet.get_Telefon().equals(t)) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	public String[] listKontaktpersoner(){
		ArrayList<String> a = new ArrayList<>();
		a.add("Oppdater liste");

		for (Kontaktperson s : kontaktInhouse) {
			a.add(s.get_Fornavn() + " " + a.add(s.get_Navn()));
		}
		
	    String[] s = ((ArrayList<String>)a).toArray(new String[a.size()]);
		
		return s;
	}
	
	public String kontaktDetaljerTlf(String t) {
		String melding = "";
		Kontaktperson person = finnKontaktpersonViaTlf(t);
		melding += person.toString();
		HashSet<Arrangement> arrHash = new HashSet<>();
		for (Lokale l : LokalerInhouse) {
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
		for (Lokale l : LokalerInhouse) {
			arrHash.addAll(l.kontaktOpplysning(person));
		}
		melding += "* Kontaktperson for følgende *";
		Arrangement[] hashToString = arrHash.toArray(new Arrangement[arrHash.size()]);
		for (Arrangement a : hashToString) {
			melding += a.toString();
		}
		return melding;
	}


	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public void set_Navn(String n) {
		navn = n;
	}
	public void set_Beskrivelse(String b) {
		beskrivelse = b;
	}

	public String get_Navn() {
		return navn;
	}
	public String get_Beskrivelse() {
		return beskrivelse;
	}

	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		return get_Navn() + "- " + get_Beskrivelse();
	}
	
}
