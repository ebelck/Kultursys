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
public class Kino extends Lokale implements Serializable {

	private static final long serialVersionUID = 7773380699922293409L;
	private int antPlasser = 150;
	private String info;
	private String type;
	
	// Oppretter Kino
	public Kino(String n, String b, String f) {
		super(n,b);
		info = f;
		type = "Kino";
		
	}

	 //////////////////////////////
	 // Get og Set metoder start //
	 //////////////////////////////
	
	public int get_AntPlasser() {
		return antPlasser;
	}
	
	public String get_Info() {
		return info;
	}
	
	public String get_Type() {
		return type;
	}
	
	 //////////////////////////////
	 // Get og Set metoder slutt //
	 //////////////////////////////
	
	public String toString() {
		String meld = super.toString();
		meld += "Type: " + get_Type() + "\n";
		meld += "Antall plasser: " + get_AntPlasser() + "\n";
		meld += "Ytterligere info: " + get_Info() + "\n";
		return meld;
	}
} // KINO SLUTT
