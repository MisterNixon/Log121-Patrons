package exemple_2_Bottin;
import java.awt.event.ActionEvent;

import javax.swing.Icon;

public class FicheActionFermer extends BottinAbstractAction {
    private FicheDialog dialog;
	
	public FicheActionFermer(Bottin bottin, 
			VuePrincipale vue, String texte, Icon icon, 
			String description, Integer mnemonic) {
		super(bottin, vue, texte, icon, description, mnemonic);
	}

	public void actionPerformed(ActionEvent e) {
		gdc.faireCommande(new FicheCommandeFermer(bottin));
	}
}
