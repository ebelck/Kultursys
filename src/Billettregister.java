import java.io.*;


public class Billettregister implements Serializable{
	private Billett f�rste;
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
		
		if(f�rste == null){
			f�rste = b;
			return true;
		}
		
		Billett peker = f�rste;
		while(peker.neste != null)
			peker = peker.neste;
		
		peker.neste = b;
		return true;
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
