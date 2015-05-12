////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen er en utvidelse av klassen Person og inneholder 		//
//	informasjon om kontaktpersoner										//
//	# Den utvider Person med et idnummer								//
//////////////////////////////////////////////////////////////////////////

public class Kontaktperson extends Person {
	
	private int pId;
	private static int nesteId = 1;
	

	//////////////////
	//	KONSTRUKTØR	//
	////////////////// 
	
	public Kontaktperson (String f, String e, String m, String t) {
		super(f,e,m,t);
		pId = nesteId++;
	}
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public int get_pId(){
		return pId;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
}//KLASSE KONTAKTPERSON SLUTT