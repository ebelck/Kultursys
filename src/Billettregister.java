import java.io.Serializable;
import java.util.*;


public class Billettregister implements Serializable{
	
	private List<Billett> reg = new ArrayList<Billett>();
	
	private int nesteNr;
	private int antSolgt;
	
	/////////////////////////////////
	////// Billettmanipulering //////
	
	public void settInnBillett( Billett b) {
		reg.add(b);
	}
	
	public int antallSolgteBilletter() {
		antSolgt = reg.size();
		return antSolgt;
	}
	
	public int nesteLedigeBillett() {
		nesteNr = reg.size() + 1;
		return nesteNr;
	}
	
	
	public Billett finnBillett(int n) {
		n = n - 1;
		try {
			Billett funnet;
			funnet = reg.get(n);
			return funnet;
		} catch(IndexOutOfBoundsException IOOBE){
			return null;
		}
	}
	
	public boolean slettBillett(int n){
		n = n - 1;
		try {
			reg.remove(n);
			return true;
		} catch (IndexOutOfBoundsException IOOBE) {
			return false;
		}
	}
	
	// Billettmanipulering slutt //
	///////////////////////////////
	public String toString() {
		String melding = "";
		for (Billett s : reg) {
			melding += s.toString();
		}
		return melding;
	}
} // Billettregister-klasse slutt
