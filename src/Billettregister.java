import java.io.Serializable;

public class Billettregister implements Serializable{
	
	private Billett første;
	private Kino k;
	private int nummer;
	
	public Billettregister() {
		første = null;
	}
	
	public boolean leggTilBillett(Billett b) {
		if(b == null){
			return false;
		}
		
		if(første == null){
			første = b;
		} else {
			Billett peker = første;
			while(peker.neste != null)
				peker = peker.neste;
		
			peker.neste = b;
		}
		return true;
	}
	
	public int nesteLedigeSete(){
		if(første == null)
			return nummer;
		
		Billett peker = første;
		while(peker.neste != null) {
			peker = peker.neste;
		}
		peker.get_Setenummer();
		nummer = peker.get_Setenummer() + 1;
		return nummer;
	}
	
	public int antallSolgteBilletter(){
		if(første == null)
			return nummer;
		
		Billett peker = første;
		while(peker.neste != null) {
			peker = peker.neste;
		}
		peker.get_Setenummer();
		nummer = peker.get_Nummer();
		return nummer;
	}
	
	public boolean slettBillett(int n){
		if(første == null)
			return false;
		
		if(første.get_Nummer() == n){
			første = første.neste;
			return true;
		}
		
		Billett peker = første;
		while(peker.neste != null){
			if(peker.neste.get_Nummer() == n){
				peker.neste = peker.neste.neste;
				return true;
			}
			peker = peker.neste;
		}
		return false;	
	}
	
	public Billett finnBillett(int n){
		if(første == null)
			return null;
		
		Billett peker = første;
		while (peker != null){
			if(peker.get_Nummer() == n)
				return peker;
			peker = peker.neste;
		}
		return null;
	}	
	
	public String toString(){
		String svar = "Billetter:\r\n";
		if(første == null)
			return svar += "* Ingen billetter kjøpt"; 
		
		Billett peker = første;
		while(peker != null){
			svar += "* " + peker.toString() + "\r\n";
			peker = peker.neste;
		}
		return svar;
	}
	
}
