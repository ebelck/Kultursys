
public class Lokale {
	private String navn, beskrivelse;
	private int refNr;
	private static int nrTeller = 1;
	Lokale neste = null;
	
	public Lokale (String n, String b) {
		navn = n;
		beskrivelse = b;
		refNr = nrTeller;
		nrTeller++;
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
