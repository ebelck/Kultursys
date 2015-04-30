import java.util.*;
import java.text.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Kulturhus {
	Lokale f�rste = null;
	Kontaktperson kontaktperson;
	Date dato;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");
	String beskrivelse, navn;
	BufferedImage bilde = null; {
		
		try {
		    bilde = ImageIO.read(new File("navn.*"));
		} catch (IOException e) {
			System.out.println("Finner ikke bilde ved angitt filbane");
		}
	}
	
	/*Minimumskravet for � opprette et arrangement*/
	public Kulturhus (String n, Kontaktperson k) {
		
		navn = n;
		kontaktperson = k;
	}
	
	 /*//////////////////////////
	  BILLETTMANIPULERING START
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
	public String get_Beskrivelse() {
		return beskrivelse;
	}
	public String get_Dato() {
		String datoString = sdf.format(dato);
		return datoString;
	}
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		return navn + " skal holdes " + get_Dato() + ".\n" + "Kontaktperson er: " + kontaktperson + "\n";
	}
	
}
