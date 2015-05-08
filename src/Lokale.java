
public class Lokale {
	private String navn, beskrivelse;
	private int refNr;
	private static int nrTeller = 1;
	Lokale neste = null;
	Arrangement første = null;
	
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
		
		if(første == null){
			første = a;
			return true;
		}
		
		Arrangement peker = første;
		while(peker.neste != null)
			peker = peker.neste;
		
		peker.neste = a;
		return true;
	}
	
	public boolean slettArrangement(int n){
		if(første == null)
			return false;
		
		if(første.get_aId() == n){
			første = første.neste;
			return true;
		}
		
		Arrangement peker = første;
		while(peker.neste != null){
			if(peker.neste.get_aId() == n){
				peker.neste = peker.neste.neste;
				return true;
			}
			peker = peker.neste;
		}
		return false;	
	}
	
	public Arrangement finnArrangement(int n){
		if(første == null)
			return null;
		
		Arrangement peker = første;
		while (peker != null){
			if(peker.get_aId() == n)
				return peker;
			peker = peker.neste;
		}
		return null;
	}
	
	public String listArrangmenter(){
		String svar = "";
		if(første == null) {
			svar = "Ingen arrangementer registrert på " + this.get_Navn() + "\r\n";
			return svar; 
		}
		
		Arrangement peker = første;
		while(peker != null){
			svar += "* " + peker.toString() + "\r\n";
			peker = peker.neste;
		}
		return svar;
	}

	 /*//////////////////////////
	  BILLETTMANIPULERING FINISH
	 *//////////////////////////
	
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
