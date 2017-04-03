package exercice_B15;

public class Operations extends Noeud{
	public enum Op {MUL,ADD,SUB,DIV};
	private Op oper;
	private Noeud droite,gauche;
	
	public Operations(Op oper, Noeud droite, Noeud gauche){
		this.oper = oper;
		this.droite = droite;
		this.gauche = gauche;
	}
	
	public Op getOper(){
		return oper;
	}
	
	public Noeud opDroite(){
		return droite;
	}
	public Noeud opGauche(){
		return gauche;
	}
	
	public int getNombre(){
		int total = 0;
		
		switch(oper){
		case MUL:
			System.out.println(droite.getNombre() + " * " + gauche.getNombre());
			total = droite.getNombre() * gauche.getNombre();
			break;
		case ADD :
			System.out.println(droite.getNombre() + " + " + gauche.getNombre());
			total = droite.getNombre() + gauche.getNombre();
			break;
		case SUB :
			System.out.println(droite.getNombre() + " - " + gauche.getNombre());
			total = droite.getNombre() - gauche.getNombre();
			break;
		case DIV :
			System.out.println(droite.getNombre() + " / " + gauche.getNombre());
			total = droite.getNombre() / gauche.getNombre();
			break;
		}
		
		return total;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		this.gauche.accept(v);
		this.droite.accept(v);
		
	}
}
