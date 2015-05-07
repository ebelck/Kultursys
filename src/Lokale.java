
public class Lokale {
	private String navn, beskrivelse;
	private int refNr;
	private static int nrTeller = 1;
	Lokale neste = null;
	Arrangement f�rste = null;
	
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
		
		if(f�rste == null){
			f�rste = a;
			return true;
		}
		
		Arrangement peker = f�rste;
		while(peker.neste != null)
			peker = peker.neste;
		
		peker.neste = a;
		return true;
	}
	
	public boolean slettArrangement(int n){
		if(f�rste == null)
			return false;
		
		if(f�rste.get_aId() == n){
			f�rste = f�rste.neste;
			return true;
		}
		
		Arrangement peker = f�rste;
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
		if(f�rste == null)
			return null;
		
		Arrangement peker = f�rste;
		while (peker != null){
			if(peker.get_aId() == n)
				return peker;
			peker = peker.neste;
		}
		return null;
	}
	
	public String listArrangmenter(){
		System.out.println("Er inne i Lokale sin listArrangementer");
		String svar = "";
		if(f�rste == null) {
			System.out.println("Inne i f�rste l�kka. Betyr at lokalet ikke har noen arrangementer registrert p� seg.");
			return "Ingen arrangementer registrert p� " + this.get_Navn() + "\r\n"; 
		}
		
		Arrangement peker = f�rste;
		while(peker != null){
			System.out.println("Inne i " + this.get_Navn() + " sin while-l�kke. Fors�ker � legge Arrangement sin toString til 'Svar'.");
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
