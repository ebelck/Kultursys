import java.util.ArrayList;


public class Kulturhus {
	Lokale første = null;
	Kontaktperson førsteK = null;
	private String beskrivelse, navn;

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
		
		if(første == null){
			første = l;
			return true;
		}
		
		Lokale peker = første;
		while(peker.neste != null)
			peker = peker.neste;
		
		peker.neste = l;
		return true;
	}
	
	public boolean slettLokale(int n){
		if(første == null)
			return false;
		
		if(første.get_RefNr() == n){
			første = første.neste;
			return true;
		}
		
		Lokale peker = første;
		while(peker.neste != null){
			if(peker.neste.get_RefNr() == n){
				peker.neste = peker.neste.neste;
				return true;
			}
			peker = peker.neste;
		}
		return false;	
	}
	
	public Lokale finnLokale(int n){
		if(første == null)
			return null;
		
		Lokale peker = første;
		while (peker != null){
			if(peker.get_RefNr() == n)
				return peker;
			peker = peker.neste;
		}
		return null;
	}
	
	public String listLokaler(){
		String svar = "Lokaler:\r\n";
		if(første ==null)
			return svar += "* Ingen lokaler registrert på kulturhus"; 
		
		Lokale peker = første;
		while(peker != null){
			svar += "* " + peker.toString() + "\r\n";
			peker = peker.neste;
		}
		return svar;
	}
	
	
	 /*//////////////////////////////////////////////
	  AVGJØR HVILKE LOKALTYPER SOM ER TILGJENGELIGE
	 *//////////////////////////////////////////////
	
	public boolean finnesKino(){
		if(første ==null)
			return false; 
		
		Lokale peker = første;
		while(peker != null){
			if(peker instanceof Kino)
				return true;
			peker = peker.neste;
		}
		return false;
	}
	public boolean finnesCafe(){
		if(første ==null)
			return false; 
		
		Lokale peker = første;
		while(peker != null){
			if(peker instanceof Cafe)
				return true;
			peker = peker.neste;
		}
		return false;
	}
	public boolean finnesKonferanse(){
		if(første ==null)
			return false; 
		
		Lokale peker = første;
		while(peker != null){
			if(peker instanceof Konferanse)
				return true;
			peker = peker.neste;
		}
		return false;
	}
	public boolean finnesScene(){
		if(første ==null)
			return false; 
		
		Lokale peker = første;
		while(peker != null){
			if(peker instanceof Scene)
				return true;
			peker = peker.neste;
		}
		return false;
	}
	public boolean finnesSelskap(){
		if(første ==null)
			return false; 
		
		Lokale peker = første;
		while(peker != null){
			if(peker instanceof Selskap)
				return true;
			peker = peker.neste;
		}
		return false;
	}
	public String[] lokalListe() {
		
		ArrayList<String> a = new ArrayList<>();
		a.add("Valg");

		if(finnesCafe())
			a.add("Cafe");
		if(finnesKino())
			a.add("Kino");
		if(finnesSelskap())
			a.add("Selskap");
		if(finnesScene())
			a.add("Scene");
		if(finnesKonferanse())
			a.add("Konferanse");
		
	    String[] s = ((ArrayList<String>)a).toArray(new String[a.size()]);
		
		return s;
	}
	
	 /*//////////////////////////
	  LOKALE MANIPULERING FINISH
	 *//////////////////////////
	


	
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
