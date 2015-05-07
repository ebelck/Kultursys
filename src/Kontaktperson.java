
public class Kontaktperson {
	private String navn;
	private String epost;
	private String tlf;
	Kontaktperson neste;

	public Kontaktperson (String n, String e, String t) {
		navn = n;
		epost = e;
		tlf = t;
	}
	
	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	public void set_Navn(String n) {
		navn = n;
	}
	public void set_Epost(String e) {
		epost = e;
	}
	public void set_Tlf(String t) {
		tlf = t;
	}
	public String get_Navn() {
		return navn;
	}
	public String get_Epost() {
		return epost;
	}
	public String get_Tlf() {
		return tlf;
	}
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		return navn + "- " + epost + "- " + tlf;
	}
}