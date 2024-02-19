/*
 * Kafuata Efrayim SOMADO , Maty MBOW
 * 
 */

package devoir5;

import java.util.ArrayList;

public class Dictionnaire extends Document {

	//variable de class
	private static ArrayList<Dictionnaire> listeDictionnaires = new ArrayList<Dictionnaire>();
	//m�thode de class permettant de retourner la liste des dictionnaire
	public static ArrayList<Dictionnaire> getListeDictionnaires() {
		return listeDictionnaires;
	}

	//variable d'instance 
	private Langue langue;
	
	//constructeur de la class qui utilise le constructeur de sa superclass et y ajoute la variable d'instance sp�cifique � sa class
	public Dictionnaire(String numEnregistrement, String titre, int nombreCopies, Langue langue) {
		super(numEnregistrement, titre, nombreCopies);
		this.langue = langue;
		//ajoute le nouveau dictionnaire cr�� � la liste de dicionnaire
		listeDictionnaires.add(this);
	}

	// Suppression du dictionnaire de la liste de documents et de la liste de dictionnaire
	public void supprimer() {
		super.supprimer();
		listeDictionnaires.remove(this);
	}

	//m�thode abstract d�finie ici, description d'un document
	public String description() {
		return " Ce document est de type de dictionnaire, un dictionnaire est un ouvrage didactique constitu� par un ensemble d'articles dont l'entr�e constitue un mot, ind�pendants les uns des autres et rang�s dans un ordre d�termin�, le plus souvent alphab�tique.";
	}
	
	// M�thode affichant toutes les caract�ristiques d'un dictionnaire
	public String toString() {
		String desc = super.toString();
		desc += "\nLangue : " + langue;
		return desc;
	}

}
