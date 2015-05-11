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
	private static int nesteNr = 1;	//DETTE KAN BLI ET PROBLEM NÅR VI SKAL GJENNOPPRETTE FRA FIL	
	private int plassnr;
	boolean solgt = false;
	private Person kunde;
	
	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Billett(){
		bnr = nesteNr;
		plassnr = nesteNr++;
	}
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////

	public Person get_kunde() {
		return kunde;
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
	
	//////////////////////
	
	public void set_kunde(Person k){
		kunde = k;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
	//////////////////////////////
	//	MANIPULERINGS-METODER	//
	//////////////////////////////
	
	public void selgBillett(Person k){
	//Registrerer opplysninger om billettholder
		kunde = k;
		solgt = true;
	}
	
	public void avbestillBillett(){
	//Fjerner opplysninger om billettholder
		kunde = null;
		solgt = false;
	}
	
	//////////////////////////////////
	//	MANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////
	
	 public String toString(){
		 return	"BILLETNUMMER:\t" + bnr + "\r\n"
				+ "Plassnummer:\t" + plassnr + "\r\n"
		 		+ "Billettholder:\t" + kunde +"\r\n";
	 }
}// KLASSE BILLETT SLUTT