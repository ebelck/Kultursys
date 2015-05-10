import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class Lokale {
	private String navn, beskrivelse;
	private int refNr;
	private static int nrTeller = 1;
	private ArrayList<Arrangement> arrangementInhouse = new ArrayList<>();
	private Iterator<Arrangement> iterator;
	
	public Lokale (String n, String b) {
		navn = n;
		beskrivelse = b;
		refNr = nrTeller;
		nrTeller++;
	}
	
	/*//////////////////////////
	  BILLETTMANIPULERING START
	 *//////////////////////////
	
	public boolean leggTilArrangement( Arrangement a){
		if(a == null)
			return false;
		
		arrangementInhouse.add(a);
		return true;
	}
	
	public boolean slettArrangement(int n){
		n = n - 1;
		try {
			arrangementInhouse.remove(n);
			return true;
		} catch (IndexOutOfBoundsException IOOBE) {
			return false;
		}
	}
	
	public Arrangement finnArrangement(int n){
		Arrangement funnet = null;
		try {
			iterator = arrangementInhouse.iterator();
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
		for (Arrangement s : arrangementInhouse) {
			melding += s.toString();
		}
		return melding;
	}
	public HashSet<Arrangement> kontaktOpplysning(Kontaktperson k) {
		HashSet<Arrangement> arrHash = new HashSet<>();
		for (Arrangement s : arrangementInhouse) {
			if (s.get_Kontaktperson().equals(k)) 
				arrHash.add(s);
		}
		return arrHash;
	}

	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public String get_Navn() {
		return navn;
	}
	
	public String get_Beskrivelse() {
		return beskrivelse;
	}
	
	public int get_RefNr() {
		return refNr;
	}
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		String meld = "Navn: " + get_Navn() + "\n";
		meld += "Beskrivelse: " + get_Beskrivelse() + "\n";
		meld += "Referansenummer " + get_RefNr() + "\n";
		return meld;
	}
}
