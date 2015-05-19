import java.io.Serializable;


/* 
 * Valg 5 
 * Subklasse av Lokale.java
 * 
 * */
import java.io.*;
public class Selskapslokale extends Lokale implements Serializable {
	
	private static final long serialVersionUID = -5540962613336331489L;
	String info;
	
	public Selskapslokale (String n, String b, String i) {
		super(n,b);
		info = i;
	}
	
	
	 /*//////////////////////
	 Get og Set metoder start
	 *//////////////////////
	
	public String get_Info() {
		return info;
	}
	
	 /*//////////////////////
	 Get og Set metoder finish
	 *//////////////////////
	public String toString() {
		String meld = super.toString();
		meld += "Ytterligere info: " + get_Info() + "\n";
		return meld;
	}
}
