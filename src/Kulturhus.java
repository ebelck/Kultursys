import java.awt.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class Kulturhus implements Serializable {
	private static final long serialVersionUID = 7057756717951866203L;
	private String beskrivelse, navn;
	private ArrayList<Lokale> lreg = new ArrayList<Lokale>();
	private Iterator<Lokale> iterator;
	private Personregister preg = new Personregister();
	
	//////////////////////
	//	KONSTRUKTØRER	//
	//////////////////////	
	
	public Kulturhus (String n, String b) {
		navn = n;
		beskrivelse = b;
		ArrayList<Lokale> reg = null;
		try(ObjectInputStream innfil = new ObjectInputStream( new FileInputStream( "./regfiles/lokreg.dta" ) )){	
			reg = (ArrayList<Lokale>) innfil.readObject(); //feilhåndtering? Se warning
			innfil.close();
		}catch(FileNotFoundException fnfe){
			reg = null;
		}catch(EOFException eofe){
	
		}catch(InvalidClassException ice){
			System.out.println(ice);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		catch(Exception e){
			e.getClass();
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
	
	// Lister ut lokaler
	public String listLokaler(){
		String melding = "";
		for (Lokale s : lreg) {
			melding += s.toString();
		}
		if (melding.equals(""))
			return "Ingen lokaler lagret";
		return melding;
	}
	
	// Lister ut arrangemeter i lokaler
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
	
	public Map<String,Arrangement> listArrangementerMap() {	
		Map<String,Arrangement> m = new HashMap<>();
		for (Lokale s : lreg) {
			if(!s.tomtRegister()) {
				int i = 1;
				for (Arrangement arr : s.listArrangementer1()) {
					m.put(s.get_Navn()+" "+i, arr);
					i++;
				}
			}
		}
		return m;
	}
	
	// Lister ut arrangemeter etter navn
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
	
	
	//Lister ut Arrangement innenfor et tidsrom etter dato
	public String hentArrNesteDager(int dager){
		
		String svar = "Ingen arrangement i tidsperioden";
		if(!lreg.isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			Date nå = new Date();
			Date da = new Date((nå.getTime() + (dager * 86400000) ));
			ArrayList<Arrangement> arrList= new ArrayList<Arrangement>();
			for(Lokale l : lreg){
				if(!l.get_reg().isEmpty()){
					for(Arrangement a: l.get_reg()){
						
						try{
							Date tid = sdf.parse(a.get_Dato());
							if(tid.after(nå) && tid.before(da)){
								if(arrList.isEmpty())
									arrList.add(a);
								else{
									int index = -1;
									Iterator<Arrangement> it = arrList.iterator();		//ITTERATOR
									while(it.hasNext() && index < 0){
										Arrangement b = it.next();
										Date sjekk = sdf.parse(b.get_Dato());
										if(sjekk.after(tid))
											index = arrList.indexOf(b);
									}
									arrList.add(index, a);
								}
							}
						}catch(Exception e){
							svar += "En feil har oppstått, prøv igjen";
						}
					}
				}
			}
			
			svar = "Arrangement de neste " + dager + " dagene:\r\n";
			for(Arrangement a: arrList)
				svar += a.toString() + "\r\n";
		}
		return svar;
	}

	// Legger lokaler i combobox
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
	
	// Legger lokale i combobox 2
	public Lokale[] lokaleCombo2() {
		return lreg.toArray(new Lokale[lreg.size()]);
	}
	
	// Lagrer lokaler i combobox
	public String[] lokaleCombo() {
		ArrayList<String> liste = new ArrayList<>();
		if(lreg.isEmpty()){
			liste.add("Ingen lokaler i listen");
		}else{
			for (Lokale s : lreg) {
				int lokNr = s.get_RefNr();
				String navn = lokNr +" "+ s.get_Navn();
				liste.add( navn);
				//a.add(s.get_Navn());
			}
			liste.add(0, "Velg lokale");
		}
		String[] s = ((ArrayList<String>)liste).toArray(new String[liste.size()]);
		
		return s;
	}
	
	// Legger arrangementer i combobox
	public String[] arrangementCombo(int lokNr) {
		ArrayList<String> liste = new ArrayList<>();
		
		if(lokNr == 0){
			//System.out.println("lokNr == 0");
			liste.add("Velg et lokale først");

		}else if(finnLokale(lokNr).get_reg().isEmpty()){
			liste.add("Ingen arrangement i dette lokalet");
		}else{
			Lokale l = this.finnLokale(lokNr); 
			for (Arrangement a : l.get_reg()) {
				if(a.get_Billettsalg()){
					int arrNr = a.get_aId();
					String navn = a.get_Navn() + ": " + a.get_Dato();
					liste.add( arrNr + " " + navn);
				}
			}
			if(liste.isEmpty())
				liste.add(0, "Ingen arragnement med billettsalg i dette lokalet");
			else
				liste.add(0, "Velg arrangement");
		}
		return ((ArrayList<String>)liste).toArray(new String[liste.size()]);
	}
	
	// Setter riktig referansenummer på billett 
	public void settRiktigBillNr(){
		if(lreg.isEmpty())
			return;
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(Lokale l: lreg)
			liste.addAll(l.finnStørsteBillettNr());
		int max = 0;
		for(Integer i: liste)
			if(i.intValue() > max)
				max = i.intValue();
		Billett.set_nesteNr(max+1);
	}
	
	// Setter riktig referansenummer på arrangementer
	public void settRiktigArrNr(){
		if(lreg.isEmpty())
			return;
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(Lokale l: lreg)
			liste.add(l.finnStørsteArrNr());
		int max = 0;
		for(Integer i: liste)
			if(i.intValue() > max)
				max = i.intValue();
		Arrangement.set_nesteId(max+1);
	}
	
	// Setter riktig referansenummer på lokale
	public void settRiktigLokNr(){
		if(lreg.isEmpty())
			return;
		ArrayList<Integer> liste = new ArrayList<Integer>();
		for(Lokale l: lreg)
			liste.add(l.get_RefNr());
		int max = 0;
		for(Integer i: liste)
			if(i.intValue() > max)
				max = i.intValue();
		Lokale.set_nesteNr(max+1);
	}
	
	// Setter riktig referansenummer på kontakter
	public void settRiktigPersNr(){
		if(preg.get_register().isEmpty())
			return;
		Kontaktperson.set_nesteId(preg.finnStørstePersNr());
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

	
	//////////////////////////////
	//	STATISTIKKMETODER START	//
	//////////////////////////////
	
	// Finner totalt anntall solgte for det bestemte lokale
	public int totaltSolgteBilletterForLokale(int n) {
		int sum = 0;
		for(Lokale l : lreg) {
			if(l.get_RefNr() == n){
				sum = l.arrangementSolgteBilletter();
			}
		}
		return sum;
	}
	
	// Total inntekt for alle billetter i alle lokaler
	public int totalInntektAlleLokaler() {
		int sum = 0;
		for(Lokale l : lreg) {
			sum += l.inntektSolgteBilletter();
		}
		return sum;
	}
	
	// Antallet solgte billetter for alle arrangementer
	public int totaltSolgtAlleLokaler() {
		int sum = 0;
		for(Lokale l : lreg) {
			sum += l.totaltSolgteAlleLokaler();
		}
		return sum;
	}
	
	// Totaloversikt for hvert lokales inntekt og dets inntekt opp mot Kulturhuset totalt
	// Gunstig å innføre mer på et senere tidspunkt
	public String totalInntektForAlleLokaler() {
		String meld = "Inntekt og prosent for hvert arrangement i hvert lokale: \r\n";
		double tot = totaltSolgtAlleLokaler();
		double pros;
		for(Lokale l : lreg) {
			meld += "Lokalnummer "+ l.get_RefNr() + " - " +l.get_Navn() + "\r\n";
			meld += "Antall billetter solgt på alle arrangementer: " + 
					 totaltSolgteBilletterForLokale(l.get_RefNr()) + " billetter \r\n";
			meld += "Total inntekt for kulturhuset: " + l.inntektSolgteBilletter() + " kr\r\n";
			if(l.totaltSolgteBilletter() > 0) {
				pros = (double) ((l.totaltSolgteBilletter() * 100) / tot);
				meld += "Total prosent av alle solgte billetter: " + pros + " %\r\n";
			}
			meld += "----------------------------------------\r\n";
		}
		return meld;
	}
	
	//////////////////////////////
	//	STATISTIKKMETODER SLUTT	//
	//////////////////////////////
	
	// toString-metode for å liste ut alt
	public String totatlString(){
		String melding = toString() + "\r\n";
		if(!lreg.isEmpty())
			for(Lokale l: lreg){
				melding += l;
				if(!l.get_reg().isEmpty()){
					for(Arrangement a: l.get_reg()){
						melding += a;							
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
		String m = "";
		try(ObjectOutputStream utfil = new ObjectOutputStream(new FileOutputStream( "./regfiles/lokreg.dta" ) )){
			utfil.writeObject( (ArrayList<Lokale>) lreg );
			utfil.close();
		}catch(IOException e){
			 
			m +="Feil i lagreLokaler(): " + e.getClass() + "\r\n her er feilen=? " + e.getLocalizedMessage();
			System.out.println(e);
		}
		m += "Suksess";
		return m;
	}
	
	public String toString() {
		return get_Navn() + "- " + get_Beskrivelse();
	}
}//KLASSE KULTURHUS SLUTT
