import java.io.Serializable;

public class Billettregister implements Serializable{
	
	private Billett f�rste;
	private Kino k;
	private int nummer;
	
	public Billettregister() {
		f�rste = null;
	}
	
	public boolean leggTilBillett(Billett b) {
		if(b == null){
			return false;
		}
		
		if(f�rste == null){
			f�rste = b;
		} else {
			Billett peker = f�rste;
			while(peker.neste != null)
				peker = peker.neste;
		
			peker.neste = b;
		}
		return true;
	}
	
	public int nesteLedigeSete(){
		if(f�rste == null)
			return nummer;
		
		Billett peker = f�rste;
		while(peker.neste != null) {
			peker = peker.neste;
		}
		peker.get_Setenummer();
		nummer = peker.get_Setenummer() + 1;
		return nummer;
	}
	
	public int antallSolgteBilletter(){
		if(f�rste == null)
			return nummer;
		
		Billett peker = f�rste;
		while(peker.neste != null) {
			peker = peker.neste;
		}
		peker.get_Setenummer();
		nummer = peker.get_Nummer();
		return nummer;
	}
	
	public boolean slettBillett(int n){
		if(f�rste == null)
			return false;
		
		if(f�rste.get_Nummer() == n){
			f�rste = f�rste.neste;
			return true;
		}
		
		Billett peker = f�rste;
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
		if(f�rste == null)
			return null;
		
		Billett peker = f�rste;
		while (peker != null){
			if(peker.get_Nummer() == n)
				return peker;
			peker = peker.neste;
		}
		return null;
	}	
	
	public String toString(){
		String svar = "Billetter:\r\n";
		if(f�rste == null)
			return svar += "* Ingen billetter kj�pt"; 
		
		Billett peker = f�rste;
		while(peker != null){
			svar += "* " + peker.toString() + "\r\n";
			peker = peker.neste;
		}
		return svar;
	}
	
}
