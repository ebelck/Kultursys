import java.io.Serializable;
import java.util.*;


public class Billettregister implements Serializable{
	
	private List<Billett> reg = new ArrayList<Billett>();
	private Iterator<Billett> iterator;
	
	private int antallBilletter;
	private boolean utsolgt = false;
	
	//private int nesteNr;	//neste ledige billett
	//private int antSolgt;	//antall billetter som er solgt
	
	public Billettregister(int n){
		antallBilletter = n;
		fyllRegister(n);	//fyller registeret med usolgte billetter
	}
	
	/////////////////////////////////
	////// Billettmanipulering //////
	
	/////Fyller registeret med nye billetter/////
	public void fyllRegister(int antall){
		for(int i = 0; i < antall; i++)
			reg.add(new Billett());
	}
	
	
	//Lage metode for å legge til flere billetter
	
	/////Registrerer billetter som solgt/////
	public boolean selgBillett(int antall, String f, String e, String eP, String t){
		if( antall + antallSolgteBilletter() > antallBilletter)
			return false;
		else{
			for(int i = 0; i < antall; i++){
				System.out.println("Kjører løkke "+ (i+1) + " gang");
				nesteLedigeBillett().selgBillett(f, e, eP, t);
			}
			return true;
		}
	}
	
	/////Finner antallet solgte billetter/////
	public int antallSolgteBilletter() {
		int antSolgt = 0;
		iterator = reg.iterator();
        while (iterator.hasNext()) {
        	Billett billett = iterator.next();
            if (billett.get_Solgt()) {
            	antSolgt++;
            }
        }
		return antSolgt;
	}
	
	/////Finner første ledige billett/////
	public Billett nesteLedigeBillett() {
		for(Billett b : reg)
			if(!b.get_Solgt())
				return b;
		return null;
	}
	
	/////Søker opp Billett på telefonnr/////
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
	
//	public boolean slettBillett(int n){
//		n = n - 1;
//		try {
//			reg.remove(n);
//			return true;
//		} catch (IndexOutOfBoundsException IOOBE) {
//			return false;
//		}
//	}
	
	// Billettmanipulering slutt //
	///////////////////////////////
	public String toString() {
		String melding = "Billetter: \r\n";
		for (Billett b : reg) {
			melding += b.toString() + "\r\n";
		}
		return melding;
	}
} // Billettregister-klasse slutt
