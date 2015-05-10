import java.io.Serializable;
import java.util.*;


public class Billettregister implements Serializable{
	
	private List<Billett> reg = new ArrayList<Billett>();
	private Iterator<Billett> iterator;
	
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
	
	
	public Billett finnBillett(String s) {
		Billett funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_Tlf().equals(s)) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
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
