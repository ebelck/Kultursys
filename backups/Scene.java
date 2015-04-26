
/* 
 * Valg 2 
 * Subklasse av Lokale.java
 * 
 * */
public class Scene extends Lokale {
	
	private String type;
	private final static int ANTPLASSER = 100;
	private String forestilling;
	
	public Scene(String n, String b, String f) {
		super(n,b);
		type = "Scene";
		forestilling = f;
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
	
	public String getForestilling() {
		return forestilling;
	}
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		String meld = super.toString();
		meld += "Type: " + getType() + "\n";
		meld += "Antall plasser: " + getAntPlasser() + "\n";
		meld += "Forestilling: " + getForestilling() + "\n";
		return meld;
	}
}
