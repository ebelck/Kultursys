

/* 
 * Valg 1
 * Subklasse av Lokale.java
 * 
 * */
public class Kino extends Lokale {

	private int antPlasser = 150;
	private String info;
	private String type;
	
	
	public Kino(String n, String b, String f) {
		super(n,b);
		info = f;
		type = "Kino";
		
	}

	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public int get_AntPlasser() {
		return antPlasser;
	}
	
	public String get_Info() {
		return info;
	}
	
	public String get_Type() {
		return type;
	}
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		String meld = super.toString();
		meld += "Type: " + get_Type() + "\n";
		meld += "Antall plasser: " + get_AntPlasser() + "\n";
		meld += "Ytterligere info: " + get_Info() + "\n";
		return meld;
	}
}
