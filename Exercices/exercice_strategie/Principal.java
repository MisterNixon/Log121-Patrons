package exercice_strategie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	public static void main(String[] args) throws NumberFormatException, IOException {
		double revenuBrut;
		int age;
		String pays;
		Impot impot;
		
    		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Revenu brut: ");
		revenuBrut = Double.parseDouble(in.readLine());

		System.out.print("Age: ");
		age = Integer.parseInt(in.readLine());
		
		System.out.print("Pays: ");
		pays = in.readLine();
		
		// La classe Principal est le contexte.  
		// La classe Impot accepte une stratégie qui est le calculateur de taxes
		// Le code de la classe Impot n'est pas modifié afin de traiter l'un ou
		// l'autre des cas.
		if (pays.equals("CANADA"))
			impot = new Impot(new CalculateurCanadien());
		else
			impot = new Impot(new CalculateurAmericain());

		System.out.println("Le salaire net est: " + impot.calculerRevenuNet(age, revenuBrut));

	}

}
