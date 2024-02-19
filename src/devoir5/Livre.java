/*
 * Kafuata Efrayim SOMADO , Maty MBOW
 * 
 */

package devoir5;

import java.util.ArrayList;

//class abstract car on ne créer pas d'objet de type livre, c'est une superclass, sachant qu'un livre est aussi un document
public abstract class Livre extends Document {
	
	//variable de class
	private static ArrayList<Livre> listeLivres = new ArrayList<Livre>();
	
	//méthode de class permettant de retourner la liste des Livres (tous les types de livre)
	public static ArrayList<Livre> getListeLivres() {
		return listeLivres;
	}
	
	//variable d'instance pour tous les types de livre
	protected String nomAuteur;
	protected int nombrePages;
	
	//constructeur de la class qui utilise le constructeur de sa superclass et y ajoute les varibles d'instances spécifiques à la class
	public Livre(String numEnregistrement, String titre, int nombreCopies, String nomAuteur, int nombrePages) {
		super(numEnregistrement, titre, nombreCopies);
		this.nomAuteur = nomAuteur;
		this.nombrePages = nombrePages;
		//ajoute le nouveau Livre créé à la liste de Livre
		listeLivres.add(this);
	}
	
	//méthode qui permet de retourner le nom de l'auteur
	public String getNomAuteur() {
		return nomAuteur;
	}
	
	//méthode qui permet de d'attribuer un nom d'auteur
	//écrase l'ancien nom le cas échéant
	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	// Suppression du livre de la liste de document et de la liste de livre
	public void supprimer() {
		super.supprimer();
		listeLivres.remove(this);
	}

	// Méthode affichant toutes les caractéristiques d'un livre
	public String toString() {
		String desc = super.toString();
		desc += "\nNom de l'auteur : " + nomAuteur;
		desc += "\nNombre de pages : " + nombrePages;
		return desc;
	}

}
