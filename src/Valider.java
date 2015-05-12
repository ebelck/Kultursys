////////////////////////////////BESKRIVELSE///////////////////////////////
//	Dette er en statisk klasse med metoder for å validere input			//
//////////////////////////////////////////////////////////////////////////

public final class Valider {
	
	//////////////////////
	//	KONSTRUKTØRER	//
	//////////////////////	
	
	private Valider(){
	}
	
	//////////////
	//	METODER	//
	//////////////
	
	public static boolean dato(String d){
		return d.matches("\\d{2}-\\d{2}-\\d{4}\\s{1}\\d{2}:\\d{2}");
	}
	
	public static boolean navn(String d){
		return d.matches("[A-Z]'?[- a-zA-Z]( [a-zA-Z])");
	}
	
	public static boolean epost(String d){
		return d.matches("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
	}
	
	public static boolean telefon(String d){
		return d.matches("[0-9]{8}");
	}
}//KLASSE VALIDER SLUTT
