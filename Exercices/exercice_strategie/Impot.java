package exercice_strategie;

public class Impot {
	private Calculateur c;
	
	public Impot(Calculateur c) {
		this.c = c;
	}
	
	public double calculerRevenuNet(int age, double revenuBrut) {
		double taxes = c.calculerTaxes(age, revenuBrut);
		double revenuNet = revenuBrut - taxes;
		if (revenuNet < 0.0) revenuNet = 0.0;
		return revenuNet;
	}
}
