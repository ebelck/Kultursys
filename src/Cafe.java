
/* 
 * Valg 4 
 * Subklasse av Lokale.java
 * 
 * */
public class Cafe extends Lokale {

	private boolean bestilt;
	private int refNr;
	
	public Cafe(String n, String b, boolean c) {
		super(n, b);
		refNr = super.getRefNr();
		if(c){
			bestilt = true;
		} else {
			bestilt = false;
		}
		
	}	
	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public boolean getBestilt() {
		return bestilt;
	}
	
	public int getRefNr() {
		return refNr;
	}
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		String meld = "Cafe: ";
		
		if(!bestilt) {
			meld += "ikke inkludert";
		} else {
			meld += "inkludert.";
		}
		return meld;
	}
}
