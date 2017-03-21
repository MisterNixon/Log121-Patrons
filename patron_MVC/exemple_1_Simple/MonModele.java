package exemple_1_Simple;

import java.awt.Color;
import java.io.File;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Données de l'application.
 * Dans cet exemple, il n'y a qu'une instance de la classe MonModele.
 * Sa superclasse est Observable du Java API. Elle hérite de la Classe 
 * Observable les membres et les méthodes qui permettent d'enregistrer
 * et de notifier des objets de type Observer.
 *  
 * @author Vincent Lacasse
 *
 */
public class MonModele extends Observable {
	private String leTexte;	
	private Color laCouleur;
	private ImageIcon image;
	
	public MonModele() {
		leTexte = "";	
		laCouleur = Color.BLACK;	
	}

	public ImageIcon getImage(){
		return image;
	}
	
	public String getLeTexte() {
		return leTexte;
	}

	public void setLeTexte(String leTexte) {
		this.leTexte = leTexte;
		// Il faut avertir les observateurs si l'état de MonModele a changé
		triggerObservers();
	}
	
	public Color getLaCouleur() {
		return laCouleur;
	}
	
	public void setLaCouleur(Color laCouleur) {
		this.laCouleur = laCouleur;
		// Il faut avertir les observateurs si l'état de MonModele a changé
		triggerObservers();
	}
	
	public void triggerObservers() {
		/*
		 *  setChanged() et notifyObservers() sont des méthodes de la classe
		 *  Observable.  setChanged() doit être appelée avant notifyObservers()
		 *  pour que les observateurs soient réellement notifiés
		 */
		setChanged();
		notifyObservers();				
	}
}
