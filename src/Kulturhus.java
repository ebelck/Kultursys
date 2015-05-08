import java.util.ArrayList;


public class Kulturhus {
	Lokale f�rste = null;
	Kontaktperson f�rsteK = null;
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
		
		if(f�rste == null){
			f�rste = l;
			return true;
		}
		
		Lokale peker = f�rste;
		while(peker.neste != null)
			peker = peker.neste;
		
		peker.neste = l;
		return true;
	}
	
	public boolean slettLokale(int n){
		if(f�rste == null)
			return false;
		
		if(f�rste.get_RefNr() == n){
			f�rste = f�rste.neste;
			return true;
		}
		
		Lokale peker = f�rste;
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
		if(f�rste == null)
			return null;
		
		Lokale peker = f�rste;
		while (peker != null){
			if(peker.get_RefNr() == n)
				return peker;
			peker = peker.neste;
		}
		return null;
	}
	
	public String listLokaler(){
		String svar = "Lokaler:\r\n";
		if(f�rste ==null)
			return svar += "* Ingen lokaler registrert p� kulturhus"; 
		
		Lokale peker = f�rste;
		while(peker != null){
			svar += "* " + peker.toString() + "\r\n";
			peker = peker.neste;
		}
		return svar;
	}
	
	public String listArrangementerILokaler() {
		String svar = "Arrangementer i kulturhuset n�: \r\n";
		if(f�rste == null) {
			svar = "Vi har ingen lokaler, s� vi har IHVERTFALL ingen arrangementer. Get your head straight.";
			return svar;
		}
		
		Lokale peker = f�rste;
		while (peker != null) {
			svar += peker.listArrangmenter();
			peker = peker.neste;
		}
		return svar;
	}
	
	
	 /*//////////////////////////////////////////////
	  AVGJ�R HVILKE LOKALTYPER SOM ER TILGJENGELIGE
	 *//////////////////////////////////////////////
	
	public boolean finnesKino(){
		if(f�rste ==null)
			return false; 
		
		Lokale peker = f�rste;
		while(peker != null){
			if(peker instanceof Kino)
				return true;
			peker = peker.neste;
		}
		return false;
	}
	public boolean finnesCafe(){
		if(f�rste ==null)
			return false; 
		
		Lokale peker = f�rste;
		while(peker != null){
			if(peker instanceof Cafe)
				return true;
			peker = peker.neste;
		}
		return false;
	}
	public boolean finnesKonferanse(){
		if(f�rste ==null)
			return false; 
		
		Lokale peker = f�rste;
		while(peker != null){
			if(peker instanceof Konferanse)
				return true;
			peker = peker.neste;
		}
		return false;
	}
	public boolean finnesScene(){
		if(f�rste ==null)
			return false; 
		
		Lokale peker = f�rste;
		while(peker != null){
			if(peker instanceof Scene)
				return true;
			peker = peker.neste;
		}
		return false;
	}
	public boolean finnesSelskap(){
		if(f�rste ==null)
			return false; 
		
		Lokale peker = f�rste;
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
		
		if(f�rsteK == null){
			f�rsteK = k;
			return true;
		}
		
		Kontaktperson peker = f�rsteK;
		while(peker.neste != null)
			peker = peker.neste;
		
		peker.neste = k;
		return true;
	}
	
	public boolean slettKontaktpersonViaEpost(String e){
		if(f�rsteK == null)
			return false;
		
		if(f�rsteK.get_Epost().equalsIgnoreCase(e)){
			f�rsteK = f�rsteK.neste;
			return true;
		}
		
		Kontaktperson peker = f�rsteK;
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
		if(f�rsteK == null)
			return false;
		
		if(f�rsteK.get_Tlf().equalsIgnoreCase(t)){
			f�rsteK = f�rsteK.neste;
			return true;
		}
		
		Kontaktperson peker = f�rsteK;
		while(peker.neste != null){
			if(peker.neste.get_Tlf().equalsIgnoreCase(t)){
				peker.neste = peker.neste.neste;
				return true;
			}
			peker = peker.neste;
		}
		return false;	
	}

	// Disse tre funksjonene blir kanskje utdaterte av en klasse h�yere opp i hierarkiet.
	
	public Kontaktperson finnKontaktpersonViaEpost(String e){
		if(f�rsteK == null)
			return null;
		
		Kontaktperson peker = f�rsteK;
		while (peker != null){
			if(peker.get_Epost().equalsIgnoreCase(e))
				return peker;
			peker = peker.neste;
		}
		return null;
	}


	public Kontaktperson finnKontaktpersonViaTlf(String t){
		if(f�rsteK == null)
			return null;
		
		Kontaktperson peker = f�rsteK;
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
		if(f�rsteK == null) {
			return b;
		}
		a.add("Valg");
		Kontaktperson peker = f�rsteK;
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
