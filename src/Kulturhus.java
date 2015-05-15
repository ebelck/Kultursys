import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Kulturhus implements Serializable {
	private static final long serialVersionUID = 7057756717951866203L;
	private String beskrivelse, navn;
	private ArrayList<Lokale> lreg = new ArrayList<Lokale>();
	private Iterator<Lokale> iterator;
	private Personregister preg = new Personregister();
//	private Billettregister billreg = new Billettregister();
	private Lokale l = new Lokale();
	
	//////////////////////
	//	KONSTRUKTØRER	//
	//////////////////////	
	
	public Kulturhus (String n, String b) {
		navn = n;
		beskrivelse = b;
		ArrayList<Lokale> reg = null;
		try(ObjectInputStream innfil = new ObjectInputStream( new FileInputStream( "./regfiles/lokreg.dta" ) )){	
			reg = (ArrayList<Lokale>) innfil.readObject();
			innfil.close();
		}catch(FileNotFoundException fnfe){
			reg = null;
		}catch(EOFException eofe){
	
		}catch(InvalidClassException ice){
			
		}
		catch(Exception e){
			System.out.println("Feil i lagReg() i Kulturhus-klassens konstruktør: " + e.getClass() + "\r\n" +  e.getCause());
		}
		if(reg == null)
			reg = new ArrayList<Lokale>();
		
		lreg = reg;
	}
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public String get_Navn() {
		return navn;
	}
	public String get_Beskrivelse() {
		return beskrivelse;
	}

	//////////////////////

	public void set_Navn(String n) {
		navn = n;
	}
	public void set_Beskrivelse(String b) {
		beskrivelse = b;
	}

	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
	/////////////////////////////////////////////
	//	LAGRE PERSONREGISTER, BILLETTREGISTER, //
	//  ARRANGEMENTER OG LOKALER TIL FIL	   //
	/////////////////////////////////////////////
	
	public String lagreLok() {
		return lagreLokaler();
		
	}
	public String lagrePerson(){
		return preg.lagrePersonregister();
	}
	

	//////////////////////////////////
	//	LOKALEMANIPULERINGS-METODER	//
	//////////////////////////////////
	
	public boolean leggTilLokale( Lokale l){
		if(l == null)
			return false;
		
		lreg.add(l);
		return true;
	}
	
	public boolean slettLokale(int n){
		n = n - 1;
		try {
			lreg.remove(n);
			return true;
		} catch (IndexOutOfBoundsException IOOBE) {
			return false;
		}
	}
	public boolean finnesLokale(int n) {
		for(Lokale f : lreg) {
			if(f.get_RefNr()==n)
				return true;
		}
		return false;
	}
	
	public Lokale finnLokale(int n){
		Lokale funnet = null;
		try {
			iterator = lreg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_RefNr() == n) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	public String listLokaler(){
		String melding = "";
		for (Lokale s : lreg) {
			melding += s.toString();
		}
		if (melding.equals(""))
			return "Ingen lokaler lagret";
		return melding;
	}
	
	public String listArrangementerILokaler() {
		String melding = "";
		for (Lokale s : lreg) {
			melding += "LOKALE:\t" + s.get_Navn() + "\r\n";
			if(!s.tomtRegister())
				melding += s.listArrangementer();
			else
				melding += "Ingen arrangementer\r\n";
		}
		return melding;
	}
	
	public String listArrangement(String n){
		try{
			for(Lokale l: lreg){
				if(l.get_Navn().equals(n)){
					return l.listArrangementer();
				}
			}
		}catch(Exception e){
			return "Feil: " + e.getMessage();
		}
		
		return "Fant ikke lokale";
	}

	public String[] lokalListe() {
		ArrayList<String> a = new ArrayList<>();
		a.add("Oppdater liste");

		for (Lokale s : lreg) {
			a.add(s.get_Navn());
		}
		
	    String[] s = ((ArrayList<String>)a).toArray(new String[a.size()]);
		
		return s;
	}
	public Lokale arrangementViaK(int n) {
		Lokale l = null;
		
		iterator = lreg.iterator();
        while (iterator.hasNext()) {
        	l = iterator.next();
            if (l.finnArrangement(n) != null) {
            	return l;
            }
        }
        return l;
	}
	
	public Lokale finnType(String s) {
		Lokale funnet = null;
		try {
			iterator = lreg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_Navn().equals(s)) {
	            	return funnet;
	            }
	        }
			
		} catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	public Lokale[] lokaleCombo2() {
		return lreg.toArray(new Lokale[lreg.size()]);
	}
	
	public String[] lokaleCombo() {
		ArrayList<String> liste = new ArrayList<>();
		if(lreg.isEmpty()){
			liste.add("Ingen lokaler i listen");
		}else{
			for (Lokale s : lreg) {
				int lokNr = s.get_RefNr();
				String navn = s.get_Navn();
				liste.add(lokNr, navn);
				//a.add(s.get_Navn());
			}
			liste.add(0, "Velg lokale");
		}
		String[] s = ((ArrayList<String>)liste).toArray(new String[liste.size()]);
		
		return s;
	}
	
	public String[] arrangementCombo(int lokNr) {
		ArrayList<String> liste = new ArrayList<>();
		
		if(lokNr == 0){
			//System.out.println("lokNr == 0");
			liste.add("Velg et lokale først");

		}else if(finnLokale(lokNr).get_reg().isEmpty()){
			liste.add("Ingen arrangement i dette lokalet");
		}else{
			Lokale l = this.finnLokale(lokNr); 
			for (Arrangement a : l.get_reg()) {											//HUSK SJEKK OM BETALING
				if(a.get_Billettsalg()){
					int arrNr = a.get_aId();
					String navn = a.get_Navn() + ": " + a.get_Dato();
					liste.add(arrNr, navn);
				}
			}
			liste.add(0, "Velg arrangement");
		}
		return ((ArrayList<String>)liste).toArray(new String[liste.size()]);
	}
	
	//////////////////////////////////////////
	//	LOKALEMANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////////////

	//////////////////////
	//	BILLETT-METODER	//
	//////////////////////
	
	public boolean bestillBillett(int id, int antall, Person k){
		for(Lokale l : lreg){
			if(l.finnArrangement(id) != null)
				return l.finnArrangement(id).bestillBillett(antall, k);
		}
		return false;
	}
	
	public Billett finnBillett(int nr){
		for(Lokale l: lreg)
			if(l.finnBillett(nr) != null)
				return l.finnBillett(nr);
		return null;
	}
	
	//////////////////////////////
	//	BILLETT-METODER SLUTT	//
	//////////////////////////////
	
	
	//////////////////////////////////////////
	//	PERSONLOKALEMANIPULERINGS-METODER	//
	//////////////////////////////////////////
	
	
/*	public String kontaktDetaljerTlf(String t) {
		String melding = "";
		Kontaktperson person = finnKontaktpersonViaTlf(t);
		melding += person.toString();
		HashSet<Arrangement> arrHash = new HashSet<>();
		for (Lokale l : lreg) {
			arrHash.addAll(l.kontaktOpplysning(person));
		}
		melding += "* Kontaktperson for følgende *";
		Arrangement[] hashToString = arrHash.toArray(new Arrangement[arrHash.size()]);
		for (Arrangement a : hashToString) {
			melding += a.toString();
		}
		return melding;
	}
	
	public String kontaktDetaljerEpost(String e) {
		String melding = "";
		Kontaktperson person = finnKontaktpersonViaEpost(e);
		melding += person.toString();
		HashSet<Arrangement> arrHash = new HashSet<>();
		for (Lokale l : lreg) {
			arrHash.addAll(l.kontaktOpplysning(person));
		}
		melding += "* Kontaktperson for følgende *";
		Arrangement[] hashToString = arrHash.toArray(new Arrangement[arrHash.size()]);
		for (Arrangement a : hashToString) {
			melding += a.toString();
		}
		return melding;
	}
*/
	//////////////////////////////////////////////
	//	PERSONLOKALEMANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////////////////
	

	
	public String toString() {
		return get_Navn() + "- " + get_Beskrivelse();
	}
	
	public String totatlString(){
		String melding = toString() + "\r\n";
		if(!lreg.isEmpty())
			for(Lokale l: lreg){
				melding += l;
				if(!l.get_reg().isEmpty()){
					for(Arrangement a: l.get_reg()){
						melding += a;
//						if(a.reg != null)
//							melding += a.reg + "\r\n";
							
					}
				}
			}
				
		
		
		return melding;
	}
	
	//////////////////////////////////
	//	LAGRE PERSONREGISTER OG 	//
	//	LOKALER TIL FILER			//
	//////////////////////////////////

	public String lagreLokaler() {
		try(ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream( "./regfiles/lokreg.dta" ) )){
			utfil.writeObject( (ArrayList<Lokale>) lreg );
			utfil.close();
		}catch(IOException e){
			return "Feil i lagreLokaler(): " + e.getClass() + "\r\n her er feilen=? " + e.getLocalizedMessage();
		} 
		//System.out.println("Suksess i lagring til lokreg.dta!");
		return "Suksess";
	}
}//KLASSE KULTURHUS SLUTT
