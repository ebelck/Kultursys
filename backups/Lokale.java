
public class Lokale {
	private String navn, beskrivelse;
	private int refNr;
	private static int nrTeller = 1;
	
	public Lokale (String n, String b) {
		navn = n;
		beskrivelse = b;
		refNr = nrTeller;
		nrTeller++;
	}
	
	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public String getNavn() {
		return navn;
	}
	
	public String getBeskrivelse() {
		return beskrivelse;
	}
	
	public int getRefNr() {
		return refNr;
	}
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		String meld = "Navn: " + getNavn() + "\n";
		meld += "Beskrivelse: " + getBeskrivelse() + "\n";
		meld += "Referansenummer " + getRefNr() + "\n";
		return meld;
	}
}
