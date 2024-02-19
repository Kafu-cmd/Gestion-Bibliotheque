/*
 * Kafuata Efrayim SOMADO , Maty MBOW
 * 
 */

package devoir5;

import java.util.ArrayList;

public class Manuel extends Livre {
	
	//variable de class
	private static ArrayList<Manuel> listeManuels = new ArrayList<Manuel>();
	
	//méthode de class permettant de retourner la liste des manuels
	public static ArrayList<Manuel> getListeManuels() {
		return listeManuels;
	}

	//variable d'instance
	private Domaine domaine;

	//constructeur de la class qui utilise le constructeur de sa superclass et y ajoute les varibles d'instances spécifiques à la class
	public Manuel(String numEnregistrement, String titre, int nombreCopies, String nomAuteur, int nombrePages,
			Domaine domaine) {
		super(numEnregistrement, titre, nombreCopies, nomAuteur, nombrePages);
		this.domaine = domaine;
		//ajoute le nouveau manuel créé à la liste de manuels
		listeManuels.add(this);
	}

	// Suppression du manuel de la liste des documents et de la liste des livres et de la liste de manuels
	public void supprimer() {
		super.supprimer();
		listeManuels.remove(this);
	}

	//méthode abstract définie ici, description d'un manuel
	public String description() {
		return " Ce document est de type manuel, un manuel  est un ouvrage didactique ou scolaire, renfermant les notions essentielles d'un art, d'une science, d'une technique";
	}
	
	// Méthode affichant toutes les caractéristiques d'un manuel
	public String toString() {
		String desc = super.toString();
		desc += "\nDomaine : " + domaine;
		return desc;
	}

}
