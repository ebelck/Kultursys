////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen inneholder informasjon om billetter:					//
//	# Billettnummer														//
//	# Neste billetnr													//
//	# Plassinformasjon													//
//	# Om billetten er solgt eller ikke									//
//	# Opplysniger om billettholder										//
//	# Metoder for å manipulere billetter								//
//////////////////////////////////////////////////////////////////////////

public class Billett {
	
	private int bnr;
	private static int teller = 1;				
	private int plassnr;
	boolean solgt = false;
	private String fornavn,etternavn,epost,tlf;
	
	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Billett(){
		bnr = teller;
		plassnr = teller;
		teller++;
	}
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////

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
	
	//////////////////////
	
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
	public int get_Billettnummer() {
		return bnr;
	}
	public int get_Plassnummer() {
		return plassnr;
	}
	
	public boolean get_Solgt() {
		return solgt;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
	//////////////////////////////
	//	MANIPULERINGS-METODER	//
	//////////////////////////////
	
	public void selgBillett(String f, String e, String eP, String t){
	//Registrerer opplysninger om billettholder
		fornavn = f;
		etternavn = e;
		epost = eP;
		tlf = t;
		solgt = true;
	}
	
	public void avbestillBillett(){
	//Fjerner opplysninger om billettholder
		fornavn = null;
		etternavn = null;
		epost = null;
		tlf = null;
		solgt = false;
	}
	
	//////////////////////////////////
	//	MANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////
	
	 public String toString(){
		 return	"BILLETNUMMER:\t" + bnr + "\r\n"
				+ "Plassnummer:\t" + plassnr + "\r\n"
		 		+ "Billettholder:\t" + fornavn +" "+etternavn +"\r\n"
				+ "Epost:\t\t" + epost + "\r\n" + "Telefon:\t" + tlf;
	 }
}// KLASSE BILLETT SLUTT