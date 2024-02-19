/*
 * Kafuata Efrayim SOMADO , Maty MBOW
 * 
 */
package devoir5;

import java.util.ArrayList;

//class abstract car on ne créer pas d'objet de type document, c'est une superclass
public abstract class Document {
	
	//variable de class
	private static ArrayList<Document> listeDocuments = new ArrayList<Document>();
	//méthode de class permettant de retourner la liste des documents (tous les types de documents)
	public static ArrayList<Document> getListeDocuments() {
		return listeDocuments;
	}
	
	//variable d'instance pour tous les types de documents
	protected String numEnregistrement;
	protected String titre;
	protected int nombreCopies;

	//construteur
	public Document(String numEnregistrement, String titre, int nombreCopies) {
		this.numEnregistrement = numEnregistrement;
		this.titre = titre;
		this.nombreCopies = nombreCopies;
		//ajoute le nouveau document créé à la liste de documents
		listeDocuments.add(this);
	}
	
	//méthode qui permet de retourner le numéro d'enregistrement d'un document
	public String getNumEnregistrement() {
		return numEnregistrement;
	}
	
	//méthode qui permet de retourner le titre d'un document
	public String getTitre() {
		return titre;
	}
	
	//méthode qui permet de donner un titre à un document
	//écrase l'ancien titre le cas échéant
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	// Modification du nombre de copies
	public void ajouterCopies(int quantite) {
		nombreCopies += quantite;
	}
	
	// Suppression du document choisi
	public void supprimer() {
		listeDocuments.remove(this);
	}
	
	// Méthode vide, redéfinie dans les sous-classes
	abstract String description();
	
	// Méthode affichant toutes les caractéristiques d'un document
	public String toString() {
		String desc = description();
		desc += "\nNuméro d'enregistrement : " + numEnregistrement;
		desc += "\nTitre : " + titre;
		desc += "\nNombre de copies : " + nombreCopies;
		return desc;
	}

}
