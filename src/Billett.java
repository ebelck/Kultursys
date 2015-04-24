
public class Billett {
	
	int nummer = 0;
	String fornavn,etternavn,epost,tlf;
	Billett neste = null;
	
	public Billett (String f, String e, String eP, String t) {
		fornavn = f;
		etternavn = e;
		epost = eP;
		tlf = t;
		nummer = nummer++;
	}
	
	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	public void set_Fornavn(String f) {
		fornavn = f;
	}
	public void set_Etternavn(String e) {
		etternavn = e;
	}
	public void set_Epost(String e) {
		epost = e;
	}
	public void set_Tlf(String t) {
		tlf = t;
	}
	public String get_Fornavn() {
		return fornavn;
	}
	public String get_Etternavn() {
		return etternavn;
	}
	public String get_FulltNavn() {
		return fornavn + " " + etternavn;
	}
	public String get_Epost() {
		return epost;
	}
	public String get_Tlf() {
		return tlf;
	}
	public int get_Nummer() {
		return nummer;
	}
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	 public String toString(){
		 return	 "BILLETNUMMER - " + nummer + "\r\n"
		 		+ "Billettholder: " + fornavn +" "+etternavn +"\r\n"
				 + "Epost: " + epost + "\r\n" + "Telefon: " + tlf;
	 }
}