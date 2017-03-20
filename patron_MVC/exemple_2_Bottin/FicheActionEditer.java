package exemple_2_Bottin;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.Icon;

public class FicheActionEditer extends BottinAbstractAction {
    private FicheDialog dialog;
	
	public FicheActionEditer(Bottin bottin, 
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		int index = vue.getIndex();
		gdc.faireCommande(new FicheCommandeEditer(bottin, index));
	}
}
