////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen inneholder informasjon om kontaktpersoner				//
//	# Navn på kontaktperson												//
//	# Epost til kontaktperson											//
//	# Telefonnummer til kontaktperson									//
//	# Metoder for å manipulere arrangementet og bilettregisteret		//
//////////////////////////////////////////////////////////////////////////

public class Kontaktperson {
	private String navn;
	private String epost;
	private String tlf;

	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Kontaktperson (String n, String e, String t) {
		navn = n;
		epost = e;
		tlf = t;
	}
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public void set_Navn(String n) {
		navn = n;
	}
	public void set_Epost(String e) {
		epost = e;
	}
	public void set_Tlf(String t) {
		tlf = t;
	}
	
	//////////////////////
	
	public String get_Navn() {
		return navn;
	}
	public String get_Epost() {
		return epost;
	}
	public String get_Tlf() {
		return tlf;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
	public String toString() {
		return navn + ", " + epost + ", Tlf: " + tlf + "\r\n";
	}
}//KLASSE KONTAKTPERSON SLUTT