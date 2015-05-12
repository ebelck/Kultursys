public class KulturhusTest {

	public static void main(String[] args) {

		Kulturhus hus = new Kulturhus("Bortibygda kulturhus", "Et sted langt ut i gokk");
		
		Lokale kino1, kino2, kino3, scene, konf1, konf2, cafe;
		
		hus.leggTilLokale(new Lokale("Sal 1", "Stor kinosal"));
		hus.leggTilLokale(new Lokale("Sal 2", "Liten kinosal"));
		hus.leggTilLokale(new Lokale("Sal 3", "Liten kinosal"));
		hus.leggTilLokale(new Lokale("Storstuen", "Stort konferanserom"));
		hus.leggTilLokale(new Lokale("Lillestuen", "Lite konferanserom"));
		hus.leggTilLokale(new Lokale("Revyscenen", "Scene for teater, revy og konserter"));
		hus.leggTilLokale(new Lokale("Kaffekroken", "Bokkafe"));
		
		//System.out.println(hus.listLokaler());
		
		hus.leggTilKontaktperson(new Kontaktperson("Per","Hansen","per@hansen.no", "12345678"));
		hus.leggTilKontaktperson(new Kontaktperson("Finn","Normann","finn@normann.no", "22334455"));
		hus.leggTilKontaktperson(new Kontaktperson("Kirsten","Giftekniv","kirsten@giftekniv.no", "90099009"));
		
		String beskrivelse;
		
		beskrivelse = "Batman (også kjent som Tim Burton's Batman) er en amerikansk actionthriller og film noir fra 1989 regissert av Tim Burton.";
		hus.finnLokale(1).leggTilArrangement(new Arrangement("Film: Batman (1989)", hus.finnKontaktpersonViaTlf("12345678"), "12-05-2015 18:00", beskrivelse, 100, 200));
		
		hus.finnLokale(1).leggTilArrangement(new Arrangement("Film: Batman (1989)", hus.finnKontaktpersonViaTlf("12345678"), "12-05-2015 20:30", beskrivelse, 100, 200));
		hus.finnLokale(1).leggTilArrangement(new Arrangement("Film: Batman (1989)", hus.finnKontaktpersonViaTlf("12345678"), "12-05-2015 23:00", beskrivelse, 100, 200));
		
		beskrivelse = "Tatt av vinden (originaltittel Gone with the Wind) er en amerikansk film fra 1939";
		hus.finnLokale(2).leggTilArrangement(new Arrangement("Film: Tatt av Vinden (1939)", hus.finnKontaktpersonViaTlf("12345678"), "12-05-2015 18:00", beskrivelse, 100, 100));
		hus.finnLokale(2).leggTilArrangement(new Arrangement("Film: Tatt av Vinden (1939)", hus.finnKontaktpersonViaTlf("12345678"), "12-05-2015 20:30", beskrivelse, 100, 100));
		hus.finnLokale(2).leggTilArrangement(new Arrangement("Film: Tatt av Vinden (1939)", hus.finnKontaktpersonViaTlf("12345678"), "12-05-2015 23:00", beskrivelse, 100, 100));
		
		beskrivelse = "Toy Story er en amerikansk dataanimert (CGI) film produsert av Pixar Animation Studios og gitt ut av Walt Disney Pictures og Buena Vista Distribution i USA den 22. november 1995 og i Europa den 22. mars 1996.";
		hus.finnLokale(3).leggTilArrangement(new Arrangement("Film: Toy Story (1996)", hus.finnKontaktpersonViaTlf("12345678"), "12-05-2015 16:00", beskrivelse, 100, 100));
		hus.finnLokale(3).leggTilArrangement(new Arrangement("Film: Toy Story (1996)", hus.finnKontaktpersonViaTlf("12345678"), "12-05-2015 18:30", beskrivelse, 100, 100));
		hus.finnLokale(3).leggTilArrangement(new Arrangement("Film: Toy Story (1996)", hus.finnKontaktpersonViaTlf("12345678"), "12-05-2015 21:00", beskrivelse, 100, 100));
		
		beskrivelse = "Behandlinjg av Kulturhusets budsjett og presentasjon av det nye IT-systemet";
		hus.finnLokale(4).leggTilArrangement(new Arrangement("Kommunestyremøte nr. 15/08", hus.finnKontaktpersonViaTlf("22334455"), "14-05-2015 17:00", beskrivelse));
		
		beskrivelse = "Styremøte i velforeningen Heisann";
		hus.finnLokale(5).leggTilArrangement(new Arrangement("Styremøte i velforeningen Heisann", hus.finnKontaktpersonViaTlf("22334455"), "20-05-2015 17:00", beskrivelse));
		
		beskrivelse = "Mannskoret Fjørnissene synger kjente og kjære nasjonalromantiske sanger";
		hus.finnLokale(6).leggTilArrangement(new Arrangement("17. Mai-konsert", hus.finnKontaktpersonViaTlf("90099009"), "17-05-2015 19:00", beskrivelse, 200, 300));
		
		beskrivelse = "Trude Bollerud leser fra den nye boken sin \"Vår i Bortibygda\"";
		hus.finnLokale(7).leggTilArrangement(new Arrangement("Månedes forfatter", hus.finnKontaktpersonViaTlf("90099009"), "25-05-2015 15:00", beskrivelse));
		
		hus.bestillBillett(1, 15, new Person("Jan","Olsen","mail1@norge.no","20010001"));
		hus.bestillBillett(1, 24, new Person("Knut","Jensen","mail2@norge.no","20010002"));
		hus.bestillBillett(1, 17, new Person("Lene","Sæter","mail3@norge.no","20010003"));
		hus.bestillBillett(1, 8, new Person("Ingrid","Korneliussen","mail4@norge.no","20010004"));
		
		//System.out.println(hus.listArrangementerILokaler());
		
		//System.out.println(hus.finnLokale(1).finnArrangement(1).listBilletter());
		
		System.out.println(hus.finnBillett(6));
	}
}
