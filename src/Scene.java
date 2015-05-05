
/* 
 * Valg 2 
 * Subklasse av Lokale.java
 * 
 * */
public class Scene extends Lokale {
	
	private String type;
	private final static int ANTPLASSER = 100;
	
	public Scene(String n, String b) {
		super(n,b);
		type = "Scene";
	}
	
	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public String getType() {
		return type;
	}
	
	public int getAntPlasser() {
		return ANTPLASSER;
	}
	
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		String meld = super.toString();
		meld += "Type: " + getType() + "\n";
		meld += "Antall plasser: " + getAntPlasser() + "\n";
		return meld;
	}
}
