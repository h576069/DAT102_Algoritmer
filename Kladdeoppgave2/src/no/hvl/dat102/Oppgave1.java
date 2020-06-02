package no.hvl.dat102;

public class Oppgave1 {

	public static void skriv(LinearNode<String> forste) {
		LinearNode<String> denne = forste;
		System.out.print("[ ");
		while (denne != null) {
			System.out.print(denne.getElement() + " ");
			denne = denne.getNeste();
		}
		System.out.println("] --> lengde: " + lengde(forste));
	}
	
	public static int lengde(LinearNode<String> forste) {
		LinearNode<String> denne = forste;
		int l = 0;
		while (denne != null) {
			l++;
			denne = denne.getNeste();
		}
		return l;
	}

	public static void main(String[] args) {
		// Oppretter starten:
		LinearNode<String> start = new LinearNode<String>("Kari");
		start.setNeste(new LinearNode<String>("Per"));
		start.getNeste().setNeste(new LinearNode<String>("Tine"));
		start.getNeste().getNeste().setNeste(new LinearNode<String>("Anne"));
		skriv(start);
		
		// i) Sett inn node nr 2 --> Berit:
		LinearNode<String> b = new LinearNode<String>("Berit");
		b.setNeste(start.getNeste());
		start.setNeste(b);
		skriv(start);

		// ii) Over ti noder:
		LinearNode<String> p = start;
		int n = lengde(start);
		while (p.getNeste() != null) {
			p = p.getNeste();
		}
		for (int i = n+1; i < 15; i++) {
			p.setNeste(new LinearNode<String>("" + i));
			p = p.getNeste();
		}
		skriv(start);
		// Skal sette inn person10 som nr 10:
		p = start;
		int i = 0;
		while (i < 8) { // pga zero-indeksing
			p = p.getNeste();
			i++;
		}
		LinearNode<String> p10 = new LinearNode<String>("Person10");
		p10.setNeste(p.getNeste());
		p.setNeste(p10);
		skriv(start);

		// iii) Setter inn noen på slutten:
		p = start;
		while (p.getNeste() != null) {
			p = p.getNeste();
		}
		p.setNeste(new LinearNode<String>("Sistemann"));
		skriv(start);

		// iv) Fjerner berit:
		p = start;
		boolean funnet = false;
		while (!funnet && p.getNeste() != null) {
			if (p.getNeste().getElement().equals("Berit")) {
				funnet = true;
			} else {
				p = p.getNeste();
			}
		}
		p.setNeste(p.getNeste().getNeste());
		skriv(start);
		
		// v) Fjern siste
		p = start;
		while (p.getNeste().getNeste() != null) {
			p = p.getNeste();
		}
		p.setNeste(null);
		skriv(start);

		/*
		 * // Må lage start: LinearNode<String> start = new LinearNode<String>("Kari");
		 * start.setNeste(new LinearNode<String>("Per")); start.getNeste().setNeste(new
		 * LinearNode<String>("Tine"));
		 * 
		 * String person = "Anne"; LinearNode<String> ny = new
		 * LinearNode<String>(person); ny.setNeste(start); start = ny;
		 * 
		 * System.out.println("ORIGINAL"); skriv(start);
		 * 
		 * // i) // Legg inn en ny node som nr 2 i listen med objekt Berit
		 * LinearNode<String> nyNr2 = new LinearNode<String>("Berit");
		 * nyNr2.setNeste(start.getNeste()); start.setNeste(nyNr2);
		 * 
		 * System.out.println("i)"); skriv(start);
		 * 
		 * // ii) // Anta at listen har over 10 noder // Lag en ny node som nr. 10 //
		 * FOR TESTING SIN DEL: LinearNode<String> denne = start; for (int i = 0; i <
		 * 10; i++) { if (denne.getNeste() == null) { denne.setNeste(new
		 * LinearNode<String>("Roy" + (i+2))); } denne = denne.getNeste(); }
		 * skriv(start);
		 * 
		 * LinearNode<String> nr10 = new LinearNode<String>("Person 10"); // Finner
		 * først den som er nummer 9: LinearNode<String> nr9 = start; for (int i = 1; i
		 * < 9; i++) { nr9 = nr9.getNeste(); } nr10.setNeste(nr9.getNeste());
		 * nr9.setNeste(nr10);
		 * 
		 * System.out.println("ii)"); skriv(start);
		 * 
		 * // iii) // Legg til ny node helt til slutt i listen med "Sistemann"
		 * LinearNode<String> siste = new LinearNode<String>("Sistemann");
		 * LinearNode<String> loop = start; if (start == null) { // tom liste start =
		 * siste; } else { while (loop.getNeste() != null) { loop = loop.getNeste(); }
		 * loop.setNeste(siste); } System.out.println("iii)"); skriv(start);
		 * 
		 * // iv) // Fjern node nr 2 i listen
		 * start.setNeste(start.getNeste().getNeste());
		 * 
		 * System.out.println("iv)"); skriv(start);
		 * 
		 * // v) // Fjern siste node i en lang liste // Antatt at den ikke er tom, må
		 * vanligvis ta hensyn til det og LinearNode<String> allerSiste = start; while
		 * (allerSiste.getNeste().getNeste() != null) { allerSiste =
		 * allerSiste.getNeste(); } allerSiste.setNeste(null);
		 * 
		 * System.out.println("v)"); skriv(start);
		 */
	}
}
