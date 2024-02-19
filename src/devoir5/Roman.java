/*
 * Kafuata Efrayim SOMADO , Maty MBOW
 * 
 */

package devoir5;

import java.util.ArrayList;

public class Roman extends Livre{
	
	//variable de class
	private static ArrayList<Roman> listeRomans = new ArrayList<Roman>();
	
	//m�thode de class permettant de retourner la liste des romans
	public static ArrayList<Roman> getListeRomans() {
		return listeRomans;
	}
	
	//variable d'instance
	private ArrayList<String> prixGagnes = new ArrayList<String>();

	//constructeur de la class qui utilise le constructeur de sa superclass et y ajoute la variable d'instance sp�cifique � sa class
	public Roman(String numEnregistrement, String titre, int nombreCopies, String nomAuteur, int nombrePages, ArrayList<String> prix) {
		super( numEnregistrement, titre, nombreCopies, nomAuteur, nombrePages);
		this.prixGagnes = prix;
		
		listeRomans.add(this);
	}
	
	// Suppression du roman de la liste des documents et de la liste des livres et de la liste de romans
	public void supprimer() {
		super.supprimer();
		listeRomans.remove(this);
	}
	
	//m�thode abstract d�finie ici, description d'un roman
	public String description () {
		return "Ce document est de type roman, un roman est une oeuvre d'imagination constitu�e par un r�cit en prose d'une certaine longueur, dont l'int�r�t est dans la narration d'aventures, l'�tude de m�urs ou de caract�res, l'analyse de sentiments ou de passions, la repr�sentation du r�el ou de diverses donn�es objectives et subjectives";
	}
	
	// M�thode affichant la liste des prix gagn�s par le roman
	public String printPrixGagnes() {
		String listePrix = "\nPrix gagn�s : ";
		for (String prix : prixGagnes) {
			listePrix += "\n              " + prix;
		}
		return listePrix;
	}
	
	// M�thode affichant toutes les caract�ristiques du roman
	public String toString() {
		String desc = super.toString();
		desc += printPrixGagnes();
		return desc;
	}

}
