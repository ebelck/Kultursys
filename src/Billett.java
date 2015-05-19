////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen inneholder informasjon om billetter:					//
//	# Billettnummer														//
//	# Neste billetnr													//
//	# Plassinformasjon													//
//	# Om billetten er solgt eller ikke									//
//	# Opplysniger om billettholder										//
//	# Metoder for å manipulere billetter								//
//////////////////////////////////////////////////////////////////////////
import java.io.Serializable;

public class Billett implements Serializable {
	
	
	private static final long serialVersionUID = 818328769517963001L;
	private int bnr;
	private static int nesteNr = 1;	
	private int plassnr;
	boolean solgt = false;
	private Person kunde;
	
	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Billett(int plass){
		bnr = nesteNr++;
		plassnr = plass;
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
	
	public static void set_nesteNr(int nr){
		nesteNr = nr;
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