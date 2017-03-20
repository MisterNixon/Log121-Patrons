package exemple_1_Simple;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contrôleur 
 * L'objectif du controleur est d'exécuter la logique de fonctionnement 
 * particulière à cette application.
 * 
 * Ce controleur implémente l'interface ActionListener, ce qui permet
 * à la vue d'enregistrer MonControleur auprès d'un bouton ou d'un
 * champ de texte.
 * 
 * Lorsque qu'une instance de MonControleur est enregistée par un JButton
 * avec addActionListener(), alors la méthode actionPerformed() de 
 * MonControleur est appelée lorsque l'utilisateur presse et relache le bouton.
 * Dans le cas d'un JTexteField, actionPerformed() est appelé lorsque
 * l'utilisteur presse la clé "Enter".
 * 
 * @author Vincent Lacasse
 *
 */
public class MonControleur implements ActionListener {

	private MaVue maVue;
	private MonModele monModele;
	
	public MonControleur(MaVue maVue, MonModele monModele) {
		this.maVue = maVue;
		this.monModele = monModele;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String actionCommand = e.getActionCommand();
		
		// l'utilisateur a pressé "Enter" dans la boite de texte
		if (actionCommand.equals(MaVue.ACTION_TEXTE)) {
			
			// Prendre le texte de la vue de ce controleur (celle d'où provient
			// l'événement) et l'envoyer au modèle.
			// Cette opération modifie l'état du modèle et, en conséquence, 
			// le modèle devrait envoyer des notifications à toutes les vues
			// qui se sont inscrites à lui via le mécanisme observateur-sujet.
			rafraichirTexte();
		}
		
		// l'utilisateur a pressé le bouton "Nouvelle Fenêtre"
		else if (actionCommand.equals(MaVue.NOUVELLE_FENETRE)) {
			rafraichirTexte();
			
			// On crée une nouvelle vue, qui elle, créera sa propre instance
			// de MonControleur.
			new MaVue(monModele);
		}
		
		// l'utilisateur a pressé le bouton "Changer Couleur"
		else if (actionCommand.equals(MaVue.CHANGER_COULEUR)) {
			rafraichirTexte();
			
			// Modifier la couleur du texte, et envoyer la nouvelle couleur au
			// au modèle.
			// Cette opération modifie l'état du modèle et, en conséquence, 
			// le modèle devrait envoyer des notifications à toutes les vues
			// qui se sont inscrites à lui via le mécanisme observateur-sujet.
			Color couleurActuelle = monModele.getLaCouleur();
			
			if (couleurActuelle == Color.BLACK)
				monModele.setLaCouleur(Color.GREEN);
			else if 	(couleurActuelle == Color.GREEN)
				monModele.setLaCouleur(Color.YELLOW);
			else if 	(couleurActuelle == Color.YELLOW)
				monModele.setLaCouleur(Color.RED);
			else 
				monModele.setLaCouleur(Color.BLACK);
		}
	}
	
	private void rafraichirTexte() {
		String texte = maVue.getMonTexte();
		monModele.setLeTexte(texte);		
	}
}
