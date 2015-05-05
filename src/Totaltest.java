
public class Totaltest {

	public static void main(String[] args) {
		
		Kulturhus k = new Kulturhus("Testhuset","Dette kulturhuset er laget som en test");

		Lokale l = new Kino("Testkino","Dette er en kinosal opprettet for � teste","Testefilm");
		Lokale l1 = new Konferanse("Testkonferansesal","Dette er en test","Testearrangement",2);
		Lokale l2 = new Konferanse("Testkonferansesal2","Dette er en test2","Testearrangement2",2);
		Lokale l3 = new Cafe("Testkonferansesal2","Dette er en test2",true);

		Kontaktperson kontakt = new Kontaktperson("Partyfiksern Geir","hallis@hollis.no","99999999");
		
		Arrangement a = new Arrangement("Testarrangement",kontakt,"17-05-2015 20:30");
		Arrangement kinoA = new Arrangement("Kinoarrangement",kontakt,"17-05-2015 20:30");
		
		Billett b = new Billett("fornavn","etternavn","epost","tlf");
		Billett b2 = new Billett("fornavn","etternavn","epost","tlf");
		Billett b3 = new Billett("fornavn","etternavn","epost","tlf");
		
		k.leggTilLokale(l);
		k.leggTilLokale(l1);
		k.leggTilLokale(l2);
		k.leggTilLokale(l3);
		l.leggTilArrangement(kinoA);
		kinoA.leggTilBillett(b);
		kinoA.leggTilBillett(b2);
		
		l1.leggTilArrangement(a);
		a.leggTilBillett(b3);
		
		
		
		
		System.out.println(l.get_Navn());
		if(l.getClass().isAssignableFrom(Kino.class))
		System.out.println("kino!");
		if (k.finnesKino())
		System.out.println(k.listLokaler());

		Kulturhusvindu v = new Kulturhusvindu(k.lokalListe());
	}

}