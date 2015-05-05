

/* 
 * Valg 1
 * Subklasse av Lokale.java
 * 
 * */
public class Kino extends Lokale {

	private final static int ANTPLASSER = 150;
	private String film;
	private String type;
	
	
	public Kino(String n, String b, String f) {
		super(n,b);
		film = f;
		type = "Kino";
		
	}

	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public int getAntPlasser() {
		return ANTPLASSER;
	}
	
	public String getFilm() {
		return film;
	}
	
	public String getType() {
		return type;
	}
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	
	public String toString() {
		String meld = super.toString();
		meld += "Type: " + getType() + "\n";
		meld += "Antall plasser: " + getAntPlasser() + "\n";
		meld += "Film: " + getFilm() + "\n";
		return meld;
	}
}
