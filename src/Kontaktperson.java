import java.awt.image.BufferedImage;

////////////////////////////////BESKRIVELSE///////////////////////////////
//	Denne klassen er en utvidelse av klassen Person og inneholder 		//
//	informasjon om kontaktpersoner										//
//	# Den utvider Person med et idnummer								//
//////////////////////////////////////////////////////////////////////////

public class Kontaktperson extends Person {
	
	private int pId;
	private static int nesteId = 1;
	private String bildesti;
	
	//////////////////
	//	KONSTRUKTØR	//
	////////////////// 
	
	public Kontaktperson (String f, String e, String m, String t) {
		super(f,e,m,t);
		pId = nesteId++;
	}
	
	public Kontaktperson (String f, String e, String m, String t, String bilde) {
		super(f,e,m,t);
		bildesti = bilde;
		pId = nesteId++;
	}
	
	//////////////////////
	//	GET/SET-METODER	//
	//////////////////////
	
	public int get_pId(){
		return pId;
	}
	public String get_bildeSti(){
		return bildesti;
	}
	public void set_bildeSti(String s){
		bildesti=s;
	}
	
	//////////////////////////////
	//	GET/SET-METODER SLUTT	//
	//////////////////////////////
	
}//KLASSE KONTAKTPERSON SLUTT