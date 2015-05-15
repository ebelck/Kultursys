////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen er et register over billetter som er solgt til et 	//
//	overordnet arrangement. 											//
//	Klassen har:														//
// 	# En liste med billetter											//
// 	# Antall billetter i registeret										//
// 	# Indikator for ledige Billetter									//
//	# Metoder for å manipulere billettene i registeret					//
//////////////////////////////////////////////////////////////////////////

import java.io.*;
import java.util.*;

public class Billettregister implements Serializable {

	private static final long serialVersionUID = 6559197877098881762L;
	private ArrayList<Billett> reg = new ArrayList<Billett>();
	private Iterator<Billett> iterator;
	
	private int antallBilletter;
	private boolean ledigeBilletter = true;
	
	//////////////////
	//	KONSTRUKTØR	//
	//////////////////
	
	public Billettregister(){
		// Opprettes et tomt register hvis fil er tom
	}
	
	public Billettregister(int n){
		antallBilletter = n;
		fyllRegister(n);
	}
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public int get_antallBilletter(){
		return antallBilletter;
	}
	
	public boolean get_ledigeBilletter(){
		return ledigeBilletter;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////	
	
	//////////////////////////////
	//	MANIPULERINGS-METODER	//
	//////////////////////////////
	
	//Fyller registeret med nye billetter
	public boolean fyllRegister(int antall){
		try{
			int x = reg.size();
			for(int i = 1; i <= antall; i++)
				reg.add(new Billett(i+x));
			return true;
		}catch(Exception e){
			return false;
		}
	}
		
	//Finner antallet usolgte billetter
	public int antallLedigeBilletter(){
		if(ledigeBilletter)
			return antallBilletter - antallSolgteBilletter();
		return 0;
	}
	
	//Finner antallet solgte billetter
	public int antallSolgteBilletter() {
		int antSolgt = 0;
		iterator = reg.iterator();
        
		while (iterator.hasNext()) {
			Billett b = iterator.next();
        	if (b.get_Solgt())
            	antSolgt++;
        }
		return antSolgt;
	}
	
	//Legger til nye billetter til i registeret
	public boolean leggTilBilletter(int antall){
		if(fyllRegister(antall)){
			antallBilletter = reg.size();
			ledigeBilletter = true;
			return true;
		}
		else
			return false;
	}
	
	//Fjerner billetter fra registeret
	public boolean fjernBilletter(int antall){
		if(antall > antallLedigeBilletter())
			return false;
		else{
			for(int i = 0; i < antall; i++)
				if(nesteLedigeBillett() != null)
					reg.remove(nesteLedigeBillett());
				
			antallBilletter = reg.size();
			ledigeBilletter = antallLedigeBilletter() != 0;
			return true;	
		}
	}
			
	//Finner første ledige billett
	public Billett nesteLedigeBillett() {
		for(Billett b : reg)
			if(!b.get_Solgt())
				return b;
		return null;
	}
	
	//Registrerer billetter som solgt hvis det er nok ledige billetter
	public boolean kjøpBillett(int antall, Person k){
		if( (antallSolgteBilletter() + antall) > antallBilletter )
			return false;
		for(int i = 0; i < antall; i++)
			nesteLedigeBillett().selgBillett(k);
		ledigeBilletter = antallBilletter != antallSolgteBilletter();
		return true;
	}
	
	//Søker opp Billett som matcher søk
	public ArrayList<Billett> finnBilletter(String søk){
		ArrayList<Billett> resultat = new ArrayList<Billett>();
		try{
			for(Billett b : reg){
				if(b.get_kunde() != null){
					if( b.get_kunde().get_Fornavn().equals(søk) ||
						b.get_kunde().get_Etternavn().equals(søk) ||
						(b.get_kunde().get_Fornavn() + " " + b.get_kunde().get_Etternavn()).equals(søk) ||
						b.get_kunde().get_Epost().equals(søk) ||
						b.get_kunde().get_Telefon().equals(søk)){
						
						resultat.add(b);
					}
				}
			}
			return resultat;
		}catch(Exception e){
			return resultat;
		}
	}
	
	//Søker opp Billett som matcher telefonnr
	public Billett finnBillett(String tlf) {
		Billett funnet = null;
		try {
			iterator = reg.iterator();
	        while (iterator.hasNext()) {
	        	funnet = iterator.next();
	            if (funnet.get_kunde().get_Telefon().equals(tlf))
	            	return funnet;
	        }
		}catch(Exception ex){
			return funnet;
		}
		return funnet;
	}
	
	//Søker opp Billett på telefonnr
	public Billett finnBillett(int nr) {
		try{
			for(Billett b: reg)
				if(b.get_Billettnummer() == nr)
					return b;
			return null;
		}catch(Exception e){
			return null;
		}
	}
	
	// avbestiller X billetter med telefonnr
	public boolean avbestillBilletter(int antall, String tlf){
		int teller = 0;
		if(finnBillett(tlf) == null)
			return false;
		try{
			for(Billett b : reg){
				if(teller < antall){
					if(b.get_kunde().get_Telefon() == tlf){
						b.avbestillBillett();
						teller++;						
					}
				}
			}
			return true;
			
		}catch(Exception e){
			return false;
		}
	}
	
	public String listSolgteBilletter(){
		String retur = "Solgte billetter: " + antallSolgteBilletter() + " av " + antallBilletter + "\r\n\r\n";
				for(Billett b : reg)
					retur += (b.get_Solgt()) ? b : "";
		return retur;
	}
	
	
	//////////////////////////////////
	//	MANIPULERINGS-METODER SLUTT	//
	//////////////////////////////////
	
	public String toString() {
		String melding = "Billetter: \r\n";
		for (Billett b : reg) {
			melding += b.toString() + "\r\n\t<<<<<#>>>>>\r\n";
		}
		return melding;
	}
	
	//////////////////////////////////////////
	//	SKRIVING OG LESING --> BILLREG.DTA	//
	//////////////////////////////////////////
	
	public String lagreBillettregister(){
		try(ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream( "./regfiles/billreg.dta" ) )){
			System.out.println(reg);
			utfil.writeObject( reg );
			utfil.close();
		}catch(Exception e){
			return "Feil i lagre(): " + e.getClass() + "\r\n" + e.getCause();
		}
		
		System.out.println("Suksess i lagreBilletter");
		return "Suksess!";
	}

	public ArrayList<Billett> lagBillettregister(){
		ArrayList<Billett> breg = null;
		try(ObjectInputStream innfil = new ObjectInputStream( new FileInputStream( "./regfiles/billreg.dta" ) )){
				breg = (ArrayList<Billett>) innfil.readObject();
				innfil.close();
		}catch(FileNotFoundException eofe){
			breg = null;
		}catch(EOFException eofe){
	
		}catch(InvalidClassException ice){
			
		}
		catch(Exception e){
			System.out.println("Feil i lagReg(): " + e.getClass());
		}
		if(breg == null)
			breg = new ArrayList<Billett>();
		
		return reg = (ArrayList<Billett>) breg;
	}
	
	///////////////////////////////////////////////
	//	SKRIVING OG LESING --> BILLREG.DTA SLUTT //
	///////////////////////////////////////////////
	
}// KLASSE BILLETTREGISTER SLUTT
