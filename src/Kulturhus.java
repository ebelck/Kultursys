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
	
	public String listArrangementerILokaler() {
		String svar = "Arrangementer i kulturhuset nå: \r\n";
		if(første == null) {
			svar = "Vi har ingen lokaler, så vi har IHVERTFALL ingen arrangementer. Get your head straight.";
			return svar;
		}
		
		Lokale peker = første;
		while (peker != null) {
			svar += peker.listArrangmenter();
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
	
	
	 /*//////////////////////////
	  KONTAKTPERSON MANIPULERING START
	 *//////////////////////////
	
	public boolean leggTilKontaktperson( Kontaktperson k){
		if(k == null)
			return false;
		
		if(førsteK == null){
			førsteK = k;
			return true;
		}
		
		Kontaktperson peker = førsteK;
		while(peker.neste != null)
			peker = peker.neste;
		
		peker.neste = k;
		return true;
	}
	
	public boolean slettKontaktpersonViaEpost(String e){
		if(førsteK == null)
			return false;
		
		if(førsteK.get_Epost().equalsIgnoreCase(e)){
			førsteK = førsteK.neste;
			return true;
		}
		
		Kontaktperson peker = førsteK;
		while(peker.neste != null){
			if(peker.neste.get_Epost().equalsIgnoreCase(e)){
				peker.neste = peker.neste.neste;
				return true;
			}
			peker = peker.neste;
		}
		return false;	
	}
	public boolean slettKontaktpersonViaTlf(String t){
		if(førsteK == null)
			return false;
		
		if(førsteK.get_Tlf().equalsIgnoreCase(t)){
			førsteK = førsteK.neste;
			return true;
		}
		
		Kontaktperson peker = førsteK;
		while(peker.neste != null){
			if(peker.neste.get_Tlf().equalsIgnoreCase(t)){
				peker.neste = peker.neste.neste;
				return true;
			}
			peker = peker.neste;
		}
		return false;	
	}

	// Disse tre funksjonene blir kanskje utdaterte av en klasse høyere opp i hierarkiet.
	
	public Kontaktperson finnKontaktpersonViaEpost(String e){
		if(førsteK == null)
			return null;
		
		Kontaktperson peker = førsteK;
		while (peker != null){
			if(peker.get_Epost().equalsIgnoreCase(e))
				return peker;
			peker = peker.neste;
		}
		return null;
	}


	public Kontaktperson finnKontaktpersonViaTlf(String t){
		if(førsteK == null)
			return null;
		
		Kontaktperson peker = førsteK;
		while (peker != null){
			if(peker.get_Tlf().equalsIgnoreCase(t))
				return peker;
			peker = peker.neste;
		}
		return null;
	}
	
	public String[] listKontaktpersoner(){
		ArrayList<String> a = new ArrayList<>();
		String[] b = new String[]{"Ingen kontaktpersoner i registeret"};
		if(førsteK == null) {
			return b;
		}
		a.add("Valg");
		Kontaktperson peker = førsteK;
		while(peker != null){
			a.add(peker.get_Navn() + " - " + peker.get_Tlf());
			peker = peker.neste;
		}
	    String[] s = ((ArrayList<String>)a).toArray(new String[a.size()]);
		return s;
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
