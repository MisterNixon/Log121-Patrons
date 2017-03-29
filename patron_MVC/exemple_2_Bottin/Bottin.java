package exemple_2_Bottin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;

/**
 * Bottin - Bottin téléphonique
 * @author Vincent Lacasse
 *
 */
@SuppressWarnings("serial")
public class Bottin extends DefaultListModel<Fiche> {
	public final static String NOM_FICHIER = "bottin.txt";

	/**
	 * Constructeur du bottin 
	 */
	public Bottin() {
		super();
	}
		            
    /**
     * Lire le bottin à partir d'un fichier texte
     * @param fichier - File spécifiant le fichier
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void lire() throws FileNotFoundException, IOException {
	    	File fichier = new File(NOM_FICHIER);
	    	if (fichier.exists()) {
	    		BufferedReader in = new BufferedReader(new FileReader(fichier));
	    		
	    		/*
	    		 * Donc ici, on lit le fichier et lorsqu'une fiche est pleine, on l'ajoute
	    		 * au bottin. On obtient donc plusieurs fiches contenant les informations 
	    		 * necessaire pour identifier quelqu'un.
	    		 */
	    		while(in.ready()) addElement(Fiche.lire(in));
	    		in.close();
	    	}
    }
    
    /**
     * Écrire le bottin dans un fichier texte
     * @param fichier - File spécifiant le fichier
     * @throws IOException
     */
    public void ecrire() throws IOException {
	    	File fichier = new File(NOM_FICHIER);
	    	PrintWriter out
	    	   = new PrintWriter(new BufferedWriter(new FileWriter(fichier, false)));
	    	for (int i = 0; i < size(); i++) {
	    		get(i).ecrire(out);
	    	}
	    	out.close();
    }
}
