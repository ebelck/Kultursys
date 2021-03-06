// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// H�gskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen � s198524
// Roger Bl�tekj�r Johannessen � s186571
// Halvor R�nneseth � s172589
//
////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen inneholder informasjon om arrangementene:				//
//	# Referansenummer for arrangementet									//
//	# Neste referansenummer												//
//	# Navn/tittel p� arrangementet										//
//	# Beskrivelse av arrangementet										//
//	# Bilde for arrangementet											//
//	# Dato for arrangementet											//
//	# Indikator for billettsalg											//
//	# Billettpris														//
//  # Inntekt fra antall solgte billeter for arrangementet				//
//	# Kontaktperson for arrangementet									//
//	# Register over alle solgte billetter								//
//	# Metoder for � manipulere arrangementet og bilettregisteret		//
//////////////////////////////////////////////////////////////////////////

import java.util.*;
import java.text.*;
import java.io.*;

public class Arrangement implements Serializable {

	private static final long serialVersionUID = -8249020595875511272L;

	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	private  int aId = 0;
	private static int nesteId = 1;
	private String navn, beskrivelse, dato;
	private String bildeSti,info1,info2;
	private boolean billettsalg = false;
	private int pris = 0;
	Kontaktperson kontakt;
	Billettregister reg;

	
	//////////////////////
	//	KONSTRUKT�RER	//
	//////////////////////
	// UTEN BILDER
	
	//Minimumskarv + dato - dato sendes med uansett.
	public Arrangement (String n, Kontaktperson k, Date d) {
		//RegEx-validering: str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")
		dato = sdf.format(d);
		aId = nesteId;
		nesteId++;
		navn = n;
		kontakt = k;
		reg = new Billettregister();
	}
	
	//Minimumskarv + dato + beskrivelse	
	public Arrangement (String n, Kontaktperson k, Date d, String b) {
		//RegEx-validering: str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")
		
		dato = sdf.format(d);
		aId = nesteId;
		nesteId++;
		navn = n;
		kontakt = k;
		beskrivelse = b;
		reg = new Billettregister();
	}
	
	//Minimumskarv + dato + beskrivelse + pris og antall billetter	
	public Arrangement (String n, Kontaktperson k, Date d, String b, int p, int a) {
		//RegEx-validering: str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")
		dato = sdf.format(d);
		aId = nesteId;
		nesteId++;
		navn = n;
		kontakt = k;
		beskrivelse = b;
		billettsalg = true;
		pris = p;
		reg = new Billettregister(a);
	}
	//Minimumskarv + dato + pris og antall billetter	
	public Arrangement (String n, Kontaktperson k, Date d, int p, int a) {
		//RegEx-validering: str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")
		dato = sdf.format(d);
		aId = nesteId;
		nesteId++;
		navn = n;
		kontakt = k;
		billettsalg = true;
		pris = p;
		reg = new Billettregister(a);
	}
	
	//////////////////////
	//	KONSTRUKT�RER	//
	//////////////////////
	// MED BILDER
	
	//Minimumskrav + dato - dato sendes med uansett. + bilde
	public Arrangement (String n,String bilde, Kontaktperson k, Date d) {
		//RegEx-validering: str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")

		dato = sdf.format(d);
		aId = nesteId;
		nesteId++;
		navn = n;
		kontakt = k;
		bildeSti = bilde;
		reg = new Billettregister();
	}
	
	//Minimumskarv + dato + beskrivelse	+ bilde
	public Arrangement (String n, Kontaktperson k, Date d, String b,String bilde) {
		//RegEx-validering: str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")
		dato = sdf.format(d);
		aId = nesteId;
		nesteId++;
		navn = n;
		kontakt = k;
		beskrivelse = b;
		bildeSti = bilde;
		reg = new Billettregister();
	}
	
	//Minimumskarv + dato + beskrivelse + pris og antall billetter	
	public Arrangement (String n, Kontaktperson k, Date d, String b, int p, int a,String bilde) {
		//RegEx-validering: str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")
		dato = sdf.format(d);
		aId = nesteId;
		nesteId++;
		navn = n;
		kontakt = k;
		beskrivelse = b;
		billettsalg = true;
		pris = p;
		reg = new Billettregister(a);
		bildeSti = bilde;
	}
	//Minimumskarv + dato + pris og antall billetter
	
	public Arrangement (String n, Kontaktperson k, Date d, int p, int a,String bilde) {
		//RegEx-validering: str.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}")
		dato = sdf.format(d);
		aId = nesteId;
		nesteId++;
		navn = n;
		kontakt = k;
		billettsalg = true;
		pris = p;
		reg = new Billettregister(a);
		bildeSti=bilde;
	}

	//////////////////////////
	//	KONSTRUKT�RER SLUTT	//
	//////////////////////////
	
	// Setter et arrangement til � kunne ta inn penger, 
	// og oppretter antall billetter og setter prisen for disse
	public void bliBetalbar(int p,int a) {
		billettsalg = true;
		pris = p;
		reg = new Billettregister(a);
	}
	

	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public String get_Navn() {
		return navn;
	}
	public String get_bildeSti() {
		return bildeSti;
	}	
	
	public int get_aId() {
		return aId;
	}
	
	public String get_Beskrivelse() {
		return beskrivelse;
	}
	
	public String get_Dato() {
		if (dato==null)
			return "";
		return dato;
	}
	
	public int get_Pris() {
		return pris;
	}
	
	public boolean get_Billettsalg() {
		return billettsalg;
	}
	
	public Billettregister get_reg(){
		return reg;
	}
	
	public Kontaktperson get_Kontaktperson() {
		return kontakt;
	}
	
	//////////////////////
	
	public static void set_nesteId(int nr){
		nesteId = nr;
	}
	
	public void set_Navn(String n) {
		navn = n;
	}
	public void set_Info(String n) {
		info1 = n;
	}
	public void set_Info2(String n) {
		info2 = n;
	}
	public void set_Pris(int n) {
		pris = n;
	}
	public void set_Bildesti(String n) {
		bildeSti = n;
	}
	public void set_Kontaktperson(Kontaktperson k) {
		kontakt = k;
	}
	
	public void set_Beskrivelse(String b) {
		beskrivelse = b;
	}
	
	public void set_Dato(String d) {
	/*String for dato skal v�re innsatt i f�lgende format: "31-08-1982 10:20";*/
		dato = sdf.format(d);
	}

	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
	//////////////////////////////
	//	MANIPULERINGS-METODER	//
	//////////////////////////////
	
	public boolean leggTilBilletter(int antall){
		return reg.leggTilBilletter(antall);
	}
	
	public boolean fjernBilletter(int antall){
		return reg.fjernBilletter(antall);
	}
	
	public boolean bestillBillett(int antall, Person k){
		return reg.kj�pBillett(antall, k);
	}
	
	public boolean avbestillBillett(int antall, String tlf){
		return reg.avbestillBilletter(antall, tlf);
	}
	
	public ArrayList<Billett> finnBilletter(String tlf){
		return reg.finnBilletter(tlf);
	}
	
	public Billett finnBillett(int nr){
		return reg.finnBillett(nr);
	}
	
	public int antallSolgteBilletter(){
		return reg.antallSolgteBilletter();
	}
	
	public int inntektSolgteBilletter() {
		int tot = reg.antallSolgteBilletter() * get_Pris();
		return tot;
	}
	
	public String listBilletter(){
		return "ARRANGEMENTNR:\t" + aId + "\r\nArrangement:\t" + navn + "\r\n" + reg.listSolgteBilletter();
	}
	
	public int finnH�yesteBillettNr(){
		return reg.finn_h�yeste_bNr();
	}
		
	//////////////////////////////////
	//	MANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////
	
	public String toString(){
		String melding = "ARRANGEMENTNR:\t" + aId + "\r\n";
		melding += "Arrangement:\t" + navn + "\r\n";
		melding += (beskrivelse != null) ? "Beskrivelse:\t" + beskrivelse + "\r\n" : "Ingen beskrivelse" + "\r\n";
		melding += (bildeSti != null) ? "Bilde:\t" + bildeSti + "\r\n" : "Mangler bilde" + "\r\n";
		melding += (info1 != null) ? info1 + "\r\n" : "";
		melding += (info2 != null) ? info2 + "\r\n" : "";
		melding += (dato != null) ? "Dato:\t"+ get_Dato() + "\r\n" : "Dato ikke satt" + "\r\n";
		melding += (!billettsalg) ? "Pris:\tGratis\r\n" : "Pris:\tkr " + pris +".00\r\n";
		melding += (billettsalg) ? "Ledige bill.:\t" + (reg.get_antallBilletter() - reg.antallSolgteBilletter()) + "/" + reg.get_antallBilletter() + "\r\n": "";
		melding += "Kontaktperson:\t" + kontakt + "\r\n";
		
		return melding;
	}
	
}//KLASSE ARRANGEMENT SLUTT
