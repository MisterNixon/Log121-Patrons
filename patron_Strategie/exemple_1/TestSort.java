package exemple_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestSort {
	public static void main(String[] args) {
		List<Employe> liste = new ArrayList<Employe>();
		
		liste.add(new Employe("Gendron", "Yves",     LocalDate.of(1990, 10, 18), LocalDate.of(2015,  2, 28),  40000.0));
		liste.add(new Employe("Beaupre", "Remi",     LocalDate.of(1991,  3, 24), LocalDate.of(2014,  5, 10),  45000.0));
		liste.add(new Employe("Lacasse", "Vincent",  LocalDate.of(1961,  1, 11), LocalDate.of(1984,  1,  1), 250000.0));
		liste.add(new Employe("El Ayadi", "Azedine", LocalDate.of(1987,  5,  3), LocalDate.of(2010,  9, 22),  70000.0));
		liste.add(new Employe("Michaud", "Eve",      LocalDate.of(1988, 12, 31), LocalDate.of(2016, 12,  1),  55000.0));
		liste.add(new Employe("Jean", "Hector",      LocalDate.of(1993,  6, 28), LocalDate.of(2015, 10, 10),  42000.0));
		liste.add(new Employe("Tremblay", "Lea",     LocalDate.of(1990,  4,  3), LocalDate.of(2015,  6, 13),  56000.0));
		
		Collections.sort(liste, new AgeComparator());
//		Collections.sort(liste, new EmbaucheComparator());
//		Collections.sort(liste, new SalaireComparator());
		
		for (Iterator<Employe> i = liste.iterator(); i.hasNext();)
			System.out.println(i.next().toString());
	}
}
