
/* 
 * Valg 2 
 * Subklasse av Lokale.java
 * 
 * */
public class Scene extends Lokale {
	
	private String info;
	private final static int ANTPLASSER = 100;
	
	public Scene(String n, String b, String i) {
		super(n,b);
		info = i;
	}
	
	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public String get_Info() {
		return info;
	}
	
	public int getAntPlasser() {
		return ANTPLASSER;
	}
	
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		String meld = super.toString();
		meld += "Ytterligere info: " + get_Info() + "\n";
		meld += "Antall plasser: " + getAntPlasser() + "\n";
		return meld;
	}
}
