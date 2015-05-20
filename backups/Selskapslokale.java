// Semesteroppgave i  Programutvikling DATS1600 / ITPE1600
// Høgskolen i Oslo og Akershus 20. mai 2015
//
// Skrevet av:
// Einar Belck-Olsen – s198524
// Roger Bløtekjær Johannessen – s186571
// Halvor Rønneseth – s172589
//
////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen er en subtype av Lokale								//
//////////////////////////////////////////////////////////////////////////

import java.io.*;

public class Selskapslokale extends Lokale implements Serializable {
	
	private static final long serialVersionUID = -5540962613336331489L;
	String info;
	
	public Selskapslokale (String n, String b, String i) {
		super(n,b);
		info = i;
	}
	
	//////////////////////////////
	// Get og Set metoder start //
	//////////////////////////////
	
	public String get_Info() {
		return info;
	}
	
	 //////////////////////////////
	 // Get og Set metoder slutt //
	 //////////////////////////////
	public String toString() {
		String meld = super.toString();
		meld += "Ytterligere info: " + get_Info() + "\n";
		return meld;
	}
} // SELSKAPSLOKALE SLUTT