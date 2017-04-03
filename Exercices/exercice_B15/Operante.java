package exercice_B15;

public class Operante extends Noeud{

	private int nombre;
	
	public Operante(int nombre){
		this.nombre = nombre;
	}

	public int getNombre(){
		return nombre;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
	}
}
