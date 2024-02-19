/*
 * Kafuata Efrayim SOMADO , Maty MBOW
 * 
 */

package devoir5;

import java.util.ArrayList;

public class Revue extends Document {
	
	//variable de class
	private static ArrayList<Revue> listeRevues = new ArrayList<Revue>();
	
	//méthode de class permettant de retourner la liste des revues
	public static ArrayList<Revue> getListeRevues() {
		return listeRevues;
	}
	
	//variables d'instances
	protected int mois;
	protected int annee;

	//constructeur de la class qui utilise le constructeur de sa superclass et y ajoute les variables d'instances spécifiques à sa class
	public Revue(String numEnregistrement, String titre, int nombreCopies, int mois, int annee) {
		super(numEnregistrement, titre, nombreCopies);
		this.mois = mois;
		this.annee = annee;
		//ajoute la nouvelle revue créée à la liste de revues
		listeRevues.add(this);
	}
	
	// Suppression de la revue de la liste des documents et de la liste des revues
	public void supprimer() {
		super.supprimer();
		listeRevues.remove(this);
	}
	
	//méthode abstract définie ici, description d'une revue
	public String description () {
		return "Ce document est de type revue, une revue est une publication périodique spécialisée dans un domaine donné.";
	}
	
	// Méthode affichant toutes les caractéristiques de la revue
	public String toString() {
		String desc = super.toString();
		desc += "\nMois de publication : " + mois;
		desc += "\nAnnée de publication : " + annee;
		return desc;
	}

}
