
public class Billett {
	
	private int nummer;							//serienummer på billett
	private static int teller = 1;				//holder styr på neste serienummer				
	private String fornavn,etternavn,epost,tlf;	//Info om kunde
	//Billettregister bR;
	boolean solgt = false;						//indikerer om billetten er solgt eller ikke.
	private int setenummer;						//Det bør være mulig å lage billetter som ikke har nummererte plasser
	
	//lag konstruktor for usolgt billett ( uten personinfo )
	
	public Billett(){
		nummer = teller;
		setenummer = teller;
		teller++;
	}
	
//	public Billett (String f, String e, String eP, String t) {
//		fornavn = f;
//		etternavn = e;
//		epost = eP;
//		tlf = t;
//		nummer = teller;
//		setenummer = teller;
//		teller++;
//	}
	
	
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
	public int get_Setenummer() {
		return setenummer;
	}
	
	public boolean get_Solgt() {
		return solgt;
	}
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public void selgBillett(String f, String e, String eP, String t){
		fornavn = f;
		etternavn = e;
		epost = eP;
		tlf = t;
		solgt = true;
	}
	
	 public String toString(){
		 return	 "BILLETNUMMER - " + nummer + "\r\n"
				+ "Setenummer - " + setenummer + "\r\n"
		 		+ "Billettholder: " + fornavn +" "+etternavn +"\r\n"
				 + "Epost: " + epost + "\r\n" + "Telefon: " + tlf;
	 }
}