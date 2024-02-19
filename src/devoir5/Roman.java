/*
 * Kafuata Efrayim SOMADO , Maty MBOW
 * 
 */

package devoir5;

import java.util.ArrayList;

public class Roman extends Livre{
	
	//variable de class
	private static ArrayList<Roman> listeRomans = new ArrayList<Roman>();
	
	//méthode de class permettant de retourner la liste des romans
	public static ArrayList<Roman> getListeRomans() {
		return listeRomans;
	}
	
	//variable d'instance
	private ArrayList<String> prixGagnes = new ArrayList<String>();

	//constructeur de la class qui utilise le constructeur de sa superclass et y ajoute la variable d'instance spécifique à sa class
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
	
	//méthode abstract définie ici, description d'un roman
	public String description () {
		return "Ce document est de type roman, un roman est une oeuvre d'imagination constituée par un récit en prose d'une certaine longueur, dont l'intérêt est dans la narration d'aventures, l'étude de mœurs ou de caractères, l'analyse de sentiments ou de passions, la représentation du réel ou de diverses données objectives et subjectives";
	}
	
	// Méthode affichant la liste des prix gagnés par le roman
	public String printPrixGagnes() {
		String listePrix = "\nPrix gagnés : ";
		for (String prix : prixGagnes) {
			listePrix += "\n              " + prix;
		}
		return listePrix;
	}
	
	// Méthode affichant toutes les caractéristiques du roman
	public String toString() {
		String desc = super.toString();
		desc += printPrixGagnes();
		return desc;
	}

}
