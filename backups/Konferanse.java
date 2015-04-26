import javax.swing.*;


/* 
 * Valg 3 
 * Subklasse av Lokale.java
 * 
 * */
public class Konferanse extends Lokale {
	
	Lokale k;
	private int antStoler, antBord, antPersoner; 			// Antall stoler, bord og personer
	private boolean bestilt;
	private String typeArrangement; 						// Type arrangement
	private String typeRom;
	private final static int MIN_LITEN = 1, MAX_LITEN = 50;	// Min og max personer for lite rom
	private final static int MIN_STOR = 50, MAX_STOR = 100; // Min og max personer for stort rom
	
	
	public Konferanse(String n, String b, String tA, int aP, boolean c) {
		super(n,b);
		antPersoner= aP;
		bestilt = c;
		typeArrangement = tA;
		
		if(antPersoner >= MIN_LITEN && antPersoner <= MAX_LITEN) {
			antStoler = MAX_LITEN;
			antBord = 13;
			typeRom = "Lite konferanserom";
		} else if (antPersoner >= MIN_STOR && antPersoner <= MAX_STOR) {
			antStoler = MAX_STOR;
			antBord = 25;
			typeRom = "Stort konferanserom";
		} else {
			JOptionPane.showMessageDialog(null, "Oppgi tall mellom 1 og 100");
		}
	}
	
	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public int getAntPersoner() {
		return antPersoner;
	}
	
	public String getTypeArrangement() {
		return typeArrangement;
	}
	
	public int getAntStoler() {
		return antStoler;
	}
	
	public int getAntBord() {
		return antBord;
	}
	
	public boolean getBestilt() {
		return bestilt;
	}
	
	public String getTypeRom() {
		return typeRom;
	}
	
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////

	
	// IKKE FERDIG, F�R IKKE TAK I OBJEKET
	public Lokale bestiltCafe() {
		k = new Cafe(super.getNavn(), super.getBeskrivelse(), bestilt);
		return k;
		
	}
	
	
	public String toString() {
		String meld = super.toString();
		meld += "Antall personer det er bestilt for: " + getAntPersoner() + "\n";
		meld += "Type arrangement: " + getTypeArrangement() + "\n";
		meld += "Type rom: " + getTypeRom() + "\n";
		meld += "Antall stoler: " + getAntStoler() + "\n";
		meld += "Antall bord: " + getAntBord() + "\n";
		
		if(k != null)
			meld += k.toString();
		
		return meld;
	}
}
