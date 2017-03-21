package exemple_1_Simple;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

/**
 * Vue de l'application.
 * MaVue implémente l'interface Observer du Java API afin qu'elle puisse
 * s'enregistrer auprès de MonModèle. Le mécanisme observateur-sujet permet
 * à plusieurs vues (observateur) de s'enregistrer à un modèle (sujet).
 * 
 * De plus, le constructeur de MaVue crée le contrôleur MonControleur. MaVue
 * délègue le traitement des événements qu'elle génère (par ex. clique sur 
 * un bouton) au controleur MonControleur.  Il y a une instance de 
 * MonControleur pour chaque instance de MaVue. 
 * 
 * @author Vincent Lacasse
 *
 */
@SuppressWarnings("serial")
public class MaVue extends JFrame implements Observer {

	public static final String ACTION_TEXTE = "AT"; 
	public static final String NOUVELLE_FENETRE = "NF";
	public static final String CHANGER_COULEUR = "CC";
	
	private JPanel contentPane;
	private JTextField txtMonTexte;
	private MonModele monModele;
	private static int compteurFenetre = 1;

	/**
	 * Create the frame.
	 */
	public MaVue(MonModele monModele) {
		super("Exemple MVC " + compteurFenetre++);
		this.monModele = monModele;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		
		// Placer la fenetre dans un endroit aléatoire sur l'écran
		Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
		int positionX = (int)(Math.random() * (screenSize.width - 450));
		int positionY = (int)(Math.random() * (screenSize.height - 100));
		setLocation(positionX, positionY);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		txtMonTexte = new JTextField();
		txtMonTexte.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		
		contentPane.add(txtMonTexte);
		txtMonTexte.setColumns(10);
		/*
		 * À la création de la vue, il faut initialiser les éléments de la vue
		 * (i.e. txtMonTexte) avec les informations contenues dans le modèle.
		 */
		update(null, null);
		
		JButton btnNouvelleFenetre = new JButton("Nouvelle Fenetre");
		contentPane.add(btnNouvelleFenetre);
		
		JButton btnChangerCouleur = new JButton("Changer Couleur");
		contentPane.add(btnChangerCouleur);
		
		/*
		 * Enregistrement de cette vue à la liste des observateurs du modèle
		 */
		monModele.addObserver(this);
		
		/*
		 * Création du controleur de cette vue.
		 */
		MonControleur monControleur = new MonControleur(this, monModele);

		/*
		 * On inscrit le controleur comme ActionListener auprés du JTextField,
		 * et des deux JButton
		 */
		txtMonTexte.setActionCommand(ACTION_TEXTE);
		txtMonTexte.addActionListener(monControleur);
		
		btnNouvelleFenetre.setActionCommand(NOUVELLE_FENETRE);
		btnNouvelleFenetre.addActionListener(monControleur);
		
		btnChangerCouleur.setActionCommand(CHANGER_COULEUR);
		btnChangerCouleur.addActionListener(monControleur);
		
		setVisible(true);		
		btnNouvelleFenetre.requestFocus();	
	}

	/*
	 * La méthode update() fait partie de l'interface Observer et elle doit 
	 * être implémentée par cette classe. update() est appelée par le modèle
	 * lorsque l'état du modèle a été modifié. 
	 */
	@Override
	public void update(Observable o, Object arg) {
		String texte = monModele.getLeTexte();
		Color couleur = monModele.getLaCouleur();
		txtMonTexte.setText(texte);
		txtMonTexte.setForeground(couleur);
		
	}
	
	public String getMonTexte() {
		return txtMonTexte.getText();
	}
}
