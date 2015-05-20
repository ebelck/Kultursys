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
public class Cafe  extends Lokale implements Serializable {

	private static final long serialVersionUID = -8364958424541858105L;
	private int refNr;
	private int gjesteplass;
	
	public Cafe(String n, String b, int i) {
		super(n, b);
		refNr = super.get_RefNr();
		gjesteplass = i;
		
	}	
	
	 //////////////////////////////
	 // Get og Set metoder start //
	 //////////////////////////////

	public int get_Gjesteplass() {
		return gjesteplass;
	}
	
	public int get_RefNr() {
		return refNr;
	}
	
	////////////////
	
	public void set_Gjesteplass(int n) {
		gjesteplass = n;
	}
	
	 //////////////////////////////
	 // Get og Set metoder slutt //
	 //////////////////////////////
	
	public String toString() {
		String meld = super.toString();
		meld += "Gjesteplass: " + get_Gjesteplass() + "\r\n";
		return meld;
	}
}
