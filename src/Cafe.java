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
