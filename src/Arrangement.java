import java.util.*;
import java.text.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Arrangement {
	Billett f�rste = null;
	Arrangement neste = null;
	Kontaktperson kontaktperson;
	private static int aId = 0;
	private int pris;
	private boolean betalbar = true;
	private Date dato;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");
	private String beskrivelse, navn;
	BufferedImage bilde = null; {
		
		try {
		    bilde = ImageIO.read(new File("navn.*"));
		} catch (IOException e) {
			System.out.println("Finner ikke bilde ved angitt filbane");
		}
	}
	
	/*Minimumskravet for � opprette et arrangement*/
	public Arrangement (String n, Kontaktperson k) {
		
		navn = n;
		kontaktperson = k;
		aId++;
	}
	/*Minimumskrav + dato er satt + pris ikke oppgitt*/
	public Arrangement (String n, Kontaktperson k, String d) {
		
		
		/*String for dato skal v�re innsatt i f�lgende format: "31-08-1982 10:20";*/
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no s�nt j�vlig.");
		}
		
		navn = n;
		kontaktperson = k;
		betalbar = false;
	}
	/*All informasjon satt*/
	public Arrangement (String n, String b, Kontaktperson k, String d, int vP) {
		
		
		/*String for dato skal v�re innsatt i f�lgende format: "31-08-1982 10:20";*/
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no s�nt j�vlig.");
		}
		beskrivelse = b;
		navn = n;
		kontaktperson = k;
		pris = vP;
	}
	
	
	 /*//////////////////////////
	  BILLETTMANIPULERING START
	 *//////////////////////////
	
	public boolean leggTilBillett( Billett b){
		if(b == null)
			return false;
		
		if(f�rste == null){
			f�rste = b;
			return true;
		}
		
		Billett peker = f�rste;
		while(peker.neste != null)
			peker = peker.neste;
		
		peker.neste = b;
		return true;
	}
	
	public boolean slettBillett(int n){
		if(f�rste == null)
			return false;
		
		if(f�rste.get_Nummer() == n){
			f�rste = f�rste.neste;
			return true;
		}
		
		Billett peker = f�rste;
		while(peker.neste != null){
			if(peker.neste.get_Nummer() == n){
				peker.neste = peker.neste.neste;
				return true;
			}
			peker = peker.neste;
		}
		return false;	
	}
	
	public Billett finnBillett(int n){
		if(f�rste == null)
			return null;
		
		Billett peker = f�rste;
		while (peker != null){
			if(peker.get_Nummer() == n)
				return peker;
			peker = peker.neste;
		}
		return null;
	}	

	 /*//////////////////////////
	  BILLETTMANIPULERING FINISH
	 *//////////////////////////
	
	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public void set_Navn(String n) {
		navn = n;
	}
	public void set_Beskrivelse(String b) {
		beskrivelse = b;
	}
	/*String for dato skal v�re innsatt i f�lgende format: "31-08-1982 10:20";*/
	public void set_Dato(String d) {
		try {
		dato = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("Input-stringen for dato-objektet er oppgitt i feil format eller no s�nt j�vlig.");
		}
	}
	public String get_Navn() {
		return navn;
	}
	public int get_aId() {
		return aId;
	}
	public String get_Beskrivelse() {
		return beskrivelse;
	}
	public String get_Dato() {
		String datoString = sdf.format(dato);
		return datoString;
	}
	public int get_Pris() {
		return pris;
	}
	public boolean get_Betalbar() {
		return betalbar;
	}
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		return navn + " skal holdes " + get_Dato() + ".\n" + "Kontaktperson er: " + kontaktperson + "\n";
	}
	
}
