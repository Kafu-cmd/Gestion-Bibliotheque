/*
 * Kafuata Efrayim SOMADO , Maty MBOW
 * 
 */

package devoir5;

import java.util.ArrayList;

public class Dictionnaire extends Document {

	//variable de class
	private static ArrayList<Dictionnaire> listeDictionnaires = new ArrayList<Dictionnaire>();
	//méthode de class permettant de retourner la liste des dictionnaire
	public static ArrayList<Dictionnaire> getListeDictionnaires() {
		return listeDictionnaires;
	}

	//variable d'instance 
	private Langue langue;
	
	//constructeur de la class qui utilise le constructeur de sa superclass et y ajoute la variable d'instance spécifique à sa class
	public Dictionnaire(String numEnregistrement, String titre, int nombreCopies, Langue langue) {
		super(numEnregistrement, titre, nombreCopies);
		this.langue = langue;
		//ajoute le nouveau dictionnaire créé à la liste de dicionnaire
		listeDictionnaires.add(this);
	}

	// Suppression du dictionnaire de la liste de documents et de la liste de dictionnaire
	public void supprimer() {
		super.supprimer();
		listeDictionnaires.remove(this);
	}

	//méthode abstract définie ici, description d'un document
	public String description() {
		return " Ce document est de type de dictionnaire, un dictionnaire est un ouvrage didactique constitué par un ensemble d'articles dont l'entrée constitue un mot, indépendants les uns des autres et rangés dans un ordre déterminé, le plus souvent alphabétique.";
	}
	
	// Méthode affichant toutes les caractéristiques d'un dictionnaire
	public String toString() {
		String desc = super.toString();
		desc += "\nLangue : " + langue;
		return desc;
	}

}
