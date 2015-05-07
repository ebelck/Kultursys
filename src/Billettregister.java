import java.io.*;


public class Billettregister implements Serializable{
	private Billett første;
	private Arrangement arrangement;
	private Lokale lokale;
	
	
	public Billettregister(){
		
	}
	
	public int visAntallSolgteBilletter(){
		return 1;
	}
	
	public int visPriser(){
		return 2;
	}
	
	public boolean leggTilBillett( Billett b){
		if(b == null)
			return false;
		
		if(første == null){
			første = b;
			return true;
		}
		
		Billett peker = første;
		while(peker.neste != null)
			peker = peker.neste;
		
		peker.neste = b;
		return true;
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
	
	public String lagre(){
		try(ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream( "reg.dta" ) )){
			utfil.writeObject( this );
		}catch(Exception e){
			return "Feil i lagre(): " + e.getClass();
		}

		return "Suksess!";
	}

	public Billettregister lagReg(){
		Billettregister reg = null;
		try(ObjectInputStream innfil = new ObjectInputStream( new FileInputStream( "reg.dta" ) )){
				reg = (Billettregister) innfil.readObject();
		}catch(FileNotFoundException eofe){
			reg = null;
		}catch(EOFException eofe){
	
		}
		catch(Exception e){
			System.out.println("Feil i lagReg(): " + e.getClass());
		}
		if(reg == null)
			reg = new Billettregister();
		
		return reg;
	}
}
