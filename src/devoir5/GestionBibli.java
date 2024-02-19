/*Kafuata Efrayim SOMADO , Maty MBOW
* 
* Simulation d'un programme de gestion d'une biblioth�que
* 
*/

package devoir5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GestionBibli {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choixMenu;

		// Boucle principale du menu
		do {

			System.out.println("\n\nBienvenue dans ce programme de gestion de bibliotheque.\n");
			System.out.println("Veuillez choisir parmi ces options : ");
			System.out.println("1 - Ajouter un nouveau document");
			System.out.println("2 - supprimer un document");
			System.out.println("3 - Afficher la liste de tous les documents");
			System.out.println("4 - Afficher les caracteristiques concernant un document");
			System.out.println("5 - Afficher la liste des prix litterarires d'un roman");
			System.out.println("6 - Augmenter ou diminuer le nombre de copies d'un document");
			System.out.println("7 - Modifier le titre d'un document");
			System.out.println("8 - Modifier l'auteur d'un livre");
			System.out.println("9 - Ajouter un document predefini");
			System.out.println("10 - Quitter");

			// Saisie de l'utilisateur
			System.out.print("\nVotre choix : ");
			choixMenu = sc.nextInt();
			sc.nextLine();

			// Redirection vers la m�thode appropri�w en fonction du choix de l'utilisateur
			// chaque m�thode est comment�e plus bas lors de sa d�finition

			switch (choixMenu) {
				case 1:
					ajoutDoc(sc);
					break;
				case 2:
					supprDoc(sc);
					break;
				case 3:
					afficherListeDocs();
					break;
				case 4:
					afficherCaracteristiques(sc);
					break;
				case 5:
					afficherPrixRoman(sc);
					break;
				case 6:
					changerNombreCopies(sc);
					break;
				case 7:
					modifierTitre(sc);
					break;
				case 8:
					modifierAuteur(sc);
					break;
				case 9:
					ajouterPredefinis();
					break;
				case 10:
					// Quitter le menu : Le code est � la fin de la boucle
					break;
				default:
					System.out.println("Veuillez choisir une option entre 1 et 10.");
			}

		} while (choixMenu != 10);

		// Fin du programme
		System.out.println("Merci d'avoir utilis� ce programme.");
	}

	/*
	 * Ajout d'un roman, manuel, revue ou dictionnaire
	 * 
	 * Cette m�thode est commune � tous les documents
	 * Car ils sont tous des documents
	 */
	public static void ajoutDoc(Scanner sc) {
		System.out.println("Que voulez-vous ajouter ?");
		System.out.println("1 - Roman");
		System.out.println("2 - Manuel");
		System.out.println("3 - Revue");
		System.out.println("4 - Dictionnaire");

		// Saisie de l'utilisateur
		System.out.print("\nVotre choix : ");
		int choixDoc = sc.nextInt();
		sc.nextLine();

		// Saisie du num�ro d'enregistrement et du titre
		System.out.println(
				"\nVeuillez saisir le num�ro d'enregistrement, le titre et le nombre de copies du nouveau document.");
		String numEnregistrement;
		boolean numValide = true;
		do { // boucle tant que le num�ro est faux
			System.out.print("Num. d'enregistrement : ");
			numEnregistrement = sc.nextLine();
			if (!verifNumEnregistrement(numEnregistrement)) {
				numValide = false; // la m�thode verifNumEnregistrement est d�finie plus bas
				// le num�ro est faux s'il ne respecte pas les crit�res alphanum�riques
				System.out.println("Veuillez saisir un num�ro d'enrengistrement de 10 caract�res alphanum�riques.");
			}
			// V�rification de l'unicit� du num�ro d'enregistrement
			for (Document doc : Document.getListeDocuments()) {
				if (numEnregistrement.equals(doc.getNumEnregistrement())) {
					numValide = false;
					System.out.println("Ce num�ro d'enregistrement appartient d�j� � un document.");
					System.out.println("Veuillez choisir un num�ro d'enregistrement unique.");
				}
			}
		} while (!numValide);
		System.out.print("Titre : ");
		String titre = sc.next();
		sc.nextLine();
		System.out.print("Nombre de copies : ");
		int nombreCopies = sc.nextInt();
		sc.nextLine();

		switch (choixDoc) {
			// ajout d'un roman (m�thode d�finie plus bas)
			case 1:
				ajoutRoman(sc, numEnregistrement, titre, nombreCopies);
				break;
			// ajout d'un manuel (m�thode d�finie plus bas)
			case 2:
				ajoutManuel(sc, numEnregistrement, titre, nombreCopies);
				break;
			// ajout d'une revue (m�thode d�finie plus bas)
			case 3:
				ajoutRevue(sc, numEnregistrement, titre, nombreCopies);
				break;
			// ajout d'un dictionnaire (m�thode d�finie plus bas)
			case 4:
				ajoutDictionnaire(sc, numEnregistrement, titre, nombreCopies);
				break;
			// s'ex�cute si autre chose qu'un chiffre compris entr 1 et 4 est saisie par
			// l'utilisateur
			default:
				System.out.println("Erreur. Veuillez choisir une option entre 1 et 4");
		}

	}

	// m�thode qui permet de cr�er et ajouter un roman � partir des donn�ees entr�es
	// par l'utilisateur
	public static void ajoutRoman(Scanner sc, String numEnregistrement, String titre, int nombreCopies) {
		// cr�ation d'une liste pour les prix gagn�s
		ArrayList<String> prixGagnes = new ArrayList<String>();

		// Demande succesivement � l'utilisateur de rentr� les informations requis pour
		// cr�er un roman
		System.out.println("\nVeuillez saisir le nombre de pages, le nom de l'auteur et le prix du roman.");
		System.out.print("Nombre de pages : ");
		int nombrePages = sc.nextInt();
		sc.nextLine();
		System.out.print("Nom de l'auteur : ");
		String nomAuteur = sc.nextLine();

		// demande le nombre de prix � ajouter
		System.out.print("\nVeuillez saisir le nombre de prix gagn�s: ");
		int nbrPrixGagnes = sc.nextInt();
		sc.nextLine();
		// on boucle tant que le nombre de prix � ajouter � la liste n'est pas atteint
		for (int i = 0; i < nbrPrixGagnes; i++) {
			System.out.print("  Nom du " + (i + 1) + "e prix gagn� : ");
			String nomPrixGagne = sc.nextLine();
			// on enregistre et ajoute chaque prix entr�s � la liste des prix gagn�s
			prixGagnes.add(nomPrixGagne);
		}
		// on cr�er un nouveau roman � partir des donn�ees entr�es par l'utilisateur
		new Roman(numEnregistrement, titre, nombreCopies, nomAuteur, nombrePages, prixGagnes);
		System.out.println("\nNouveau roman ajout�.");
	}

	/*
	 * m�thode qui permet de cr�er et ajouter un manuel � partir des donn�ees
	 * entr�es par l'utilisateur
	 * le programme demande successivement � l'utilisateur de rentrer les
	 * informations sp�cifique � un manuel
	 * et l'enregistre dans des variables pr�vues � cet effet, gr�ce au scanner
	 */
	public static void ajoutManuel(Scanner sc, String numEnregistrement, String titre, int nombreCopies) {

		System.out.println("\nVeuillez saisir le nom de l'auteur et le nombre de pages du manuel : ");
		System.out.print("Nom de l'auteur : ");
		String nomAuteur = sc.nextLine();
		System.out.print("Nombre de pages : ");
		int nombrePages = sc.nextInt();
		sc.nextLine();

		System.out.println("Veuillez choisir le domaine du manuel : ");
		// parcours les valeurs de la class enum Domaine et les affiches
		for (int i = 0; i < Domaine.values().length; i++) {
			System.out.println("" + (i + 1) + " : " + Domaine.values()[i]);
		}
		System.out.print("Votre choix : ");
		int choixDomaine = sc.nextInt();
		sc.nextLine();
		// stock dans la variable domaine cr��e la valeur de l'enum � l'index
		// correspondant
		// au choix de l'utilisateur (pour �a le -1)
		Domaine domaine = Domaine.values()[choixDomaine - 1];

		// cr�er un nouveau roman � partir des donn�ees entr�es par l'utilisateur
		new Manuel(numEnregistrement, titre, nombreCopies, nomAuteur, nombrePages, domaine);
		System.out.println("\nNouveau manuel ajout�.");
	}

	/*
	 * m�thode qui permet de cr�er et ajouter une revue � partir des donn�ees
	 * entr�es par l'utilisateur
	 * le programme demande successivement � l'utilisateur de rentrer les
	 * informations sp�cifique � une revue
	 * et l'enregistre dans des variables pr�vues � cet effet, gr�ce au scanner
	 */
	public static void ajoutRevue(Scanner sc, String numEnregistrement, String titre, int nombreCopies) {
		System.out.println("\nVeuillez saisir le mois et l'ann�e de publication de la revue : ");
		int mois;
		do { // cette boucle se r�p�te tant que le mois entr� par l'utilisateur est inf�rieur
				// � 1
				// ou sup�rieur � 12
			System.out.print("mois (1-12) : ");
			mois = sc.nextInt();
			sc.nextLine();
			if (1 > mois || 12 < mois) {
				System.out.println("Veuillez choisir un mois de 1 � 12 (janvier � d�cembre)");
			}
		} while (1 > mois || 12 < mois);
		System.out.print("Ann�e : ");
		int annee = sc.nextInt();
		sc.nextLine();

		// cr�er une nouvelle revue � partir des donn�ees entr�es par l'utilisateur
		new Revue(numEnregistrement, titre, nombreCopies, mois, annee);
		System.out.println("\nNouvelle revue ajout�.");
	}

	/*
	 * m�thode qui permet de cr�er et ajouter une revue � partir des donn�ees
	 * entr�es par l'utilisateur
	 * le programme demande successivement � l'utilisateur de rentrer les
	 * informations sp�cifique � une revue
	 * et l'enregistre dans des variables pr�vues � cet effet, gr�ce au scanner
	 */
	public static void ajoutDictionnaire(Scanner sc, String numEnregistrement, String titre, int nombreCopies) {
		System.out.println("Veuillez choisir la langue du dictionnaire : ");
		// parcours les valeurs de la class enum Langue et les affiches
		for (int i = 0; i < Langue.values().length; i++) {
			System.out.println("" + (i + 1) + " : " + Langue.values()[i]);
		}
		System.out.print("Votre choix : ");
		int choixLangue = sc.nextInt();
		sc.nextLine();
		// stock dans la variable domaine cr��e la valeur de l'enum � l'index
		// correspondant
		// au choix de l'utilisateur (pour �a le -1)
		Langue langue = Langue.values()[choixLangue - 1];

		// cr�er un nouveau dictionnaire � partir des donn�ees entr�es par l'utilisateur
		new Dictionnaire(numEnregistrement, titre, nombreCopies, langue);
		System.out.println("\nNouveau dictionnaire ajout�.");
	}

	// Suppression d'un document
	public static void supprDoc(Scanner sc) {
		if (Document.getListeDocuments().size() < 1) {
			System.out.println("La biblioth�que ne contient aucun document.");
			System.out.println("Veuillez ajouter au moins un document � supprimer.");
		} else {
			// Affichage de tous les documents
			afficherListeDocs();

			// Saisie du document � supprimer
			System.out.println("\nVeuillez saisir le num�ro d'enregistrement du document � supprimer : ");
			System.out.print("Num. d'enregistrement : ");
			String numEnregistrement = sc.nextLine();

			// V�rification de l'existence du document saisi
			Document aSupprimer = null;
			boolean docTrouve = false;
			for (Document doc : Document.getListeDocuments()) {
				if (numEnregistrement.equals(doc.getNumEnregistrement())) {
					docTrouve = true;
					aSupprimer = doc;
				}
			}

			if (!docTrouve) {
				System.out.println("\nLe num�ro d'enregistrement saisi ne correspond � aucun document.");
				System.out.println("Suppression annul�e.");
			} else {
				// Avertissement
				System.out.println("Voulez-vous vraiment supprimer : " + aSupprimer.getTitre() + " ?");
				System.out.println("Cette action est irr�versible.");
				System.out.print("Saisissez 'SUPPRIMMER' pour confirmer : ");
				String confirmation = sc.nextLine();

				if (!confirmation.equals("SUPPRIMER")) {
					System.out.println("Confirmation incorrecte.");
					System.out.println("Le document n'a pas �t� supprim�.");
				} else {
					// Suppression du document
					aSupprimer.supprimer();
					System.out.println("Le document a �t� supprim�.");
				}
			}
		}
	}

	// Affichage de la liste de tous les documents
	public static void afficherListeDocs() {
		if (Document.getListeDocuments().size() < 1) {
			System.out.println("La biblioth�que ne contient aucun document.");
			System.out.println("Veuillez ajouter au moins un document � afficher.");
		} else {
			System.out.println("Voici la liste des documents : ");
			for (int i = 0; i < Document.getListeDocuments().size(); i++) {
				// Format d'affichage : "{numEnregistrement} : {titre}"
				System.out.println("\n" + Document.getListeDocuments().get(i).getNumEnregistrement() + " : "
						+ Document.getListeDocuments().get(i).getTitre());
			}
		}
	}

	// Affichage des diff�rentes caract�ristiques concernant un document
	public static void afficherCaracteristiques(Scanner sc) {
		if (Document.getListeDocuments().size() < 1) {
			System.out.println("La biblioth�que ne contient aucun document.");
			System.out.println("Veuillez ajouter au moins un document � afficher.");
		} else {
			// Affichage de tous les documents
			afficherListeDocs();

			// Saisie du document � afficher
			System.out.println("\nVeuillez saisir le num�ro d'enregistrement du document � afficher : ");
			System.out.print("Num. d'enregistrement : ");
			String numEnregistrement = sc.nextLine();

			// V�rification de l'existence du document saisi
			Document aAfficher = null;
			boolean docTrouve = false;
			for (Document doc : Document.getListeDocuments()) {
				if (numEnregistrement.equals(doc.getNumEnregistrement())) {
					docTrouve = true;
					aAfficher = doc;
				}
			}

			if (!docTrouve) {
				System.out.println("\nLe num�ro d'enregistrement saisi ne correspond � aucun document.");
				System.out.println("Affichage annul�.");
			} else {
				// Affichage des informations
				System.out.println("\nInformations sur le document choisi : \n");
				System.out.println(aAfficher.toString());
			}
		}
	}

	// Affichage de la liste de prix litt�raires pour un roman
	// si la liste est vide, l<utilisateur en est inform� et est
	// invit� � en ajouter au moins 1
	public static void afficherPrixRoman(Scanner sc) {
		if (Roman.getListeRomans().size() < 1) {
			System.out.println("La biblioth�que ne contient aucun roman.");
			System.out.println("Veuillez ajouter au moins un roman � afficher.");
		} else {
			System.out.println("Voici la liste des romans : ");

			// lorsqu'il y a au moins un roman ayant une liste de prix,
			// il/s s'affichent avec un num�ro
			for (int i = 0; i < Roman.getListeRomans().size(); i++) {
				Roman actuel = Roman.getListeRomans().get(i);
				System.out.println("\n" + (i + 1) + " - \t" + actuel.getTitre());
				System.out.println("    \tPar " + Roman.getListeRomans().get(i).getNomAuteur());
			}

			System.out.println("\nVeuillez saisir le nombre correspondant au roman � afficher.");
			int indexAAfficher;
			do { // cette boucle se r�p�te tant et au tant que le nombre entr� par l'utilisateur
					// est inf�rieur � 1
					// ou sup�rieur au dernier �l�ment de la liste
				System.out.print("Votre choix : ");
				indexAAfficher = sc.nextInt() - 1;
				sc.nextLine();

				if (indexAAfficher < 0 || indexAAfficher > (Roman.getListeRomans().size() - 1)) {
					System.out.println("Veuillez saisir un nombre parmi ceux affich�s � c�t� des titres ci-haut.");
				}
			} while (indexAAfficher < 0 || indexAAfficher > (Roman.getListeRomans().size() - 1));

			// une variable roman est cr��e afin de stocker le roman s�lectionn�
			Roman aAfficher = Roman.getListeRomans().get(indexAAfficher);
			System.out.println(aAfficher.printPrixGagnes());
		}
	}

	// Augmentation ou diminution du nombre de copies d'un document
	public static void changerNombreCopies(Scanner sc) {
		if (Document.getListeDocuments().size() < 1) {
			System.out.println("La biblioth�que ne contient aucun document.");
			System.out.println("Veuillez ajouter au moins un document � modifier.");
		} else {
			// Affichage de tous les documents
			afficherListeDocs();

			// Saisie du document � supprimer
			System.out.println("\nVeuillez saisir le num�ro d'enregistrement du document � modifier : ");
			System.out.print("Num. d'enregistrement : ");
			String numEnregistrement = sc.nextLine();

			// V�rification de l'existence du document saisi
			Document aModifier = null;
			boolean docTrouve = false;
			for (Document doc : Document.getListeDocuments()) {
				if (numEnregistrement.equals(doc.getNumEnregistrement())) {
					docTrouve = true;
					aModifier = doc;
				}
			}

			if (!docTrouve) {
				System.out.println("\nLe num�ro d'enregistrement saisi ne correspond � aucun document.");
				System.out.println("Modification annul�e.");
			} else {
				// Saisie du nombre de copies � ajouter ou enlever
				System.out.println("Veuillez saisir la quantit� de copies � ajouter.");
				System.out.println("Pour diminuer le nombre de copies, saisissez un nombre n�gatif.");
				System.out.print("Quantit� : ");
				int copiesAAjouter = sc.nextInt();
				sc.nextLine();

				// Modification du nombre de copies
				aModifier.ajouterCopies(copiesAAjouter);
			}

		}
	}

	// Modification du titre d�un document
	public static void modifierTitre(Scanner sc) {
		if (Document.getListeDocuments().size() < 1) {
			System.out.println("La biblioth�que ne contient aucun document.");
			System.out.println("Veuillez ajouter au moins un document � modifier.");
		} else {
			// Affichage de tous les documents
			afficherListeDocs();

			// Saisie du document � supprimer
			System.out.println("\nVeuillez saisir le num�ro d'enregistrement du document � modifier : ");
			System.out.print("Num. d'enregistrement : ");
			String numEnregistrement = sc.nextLine();

			// V�rification de l'existence du document saisi
			Document aModifier = null;
			boolean docTrouve = false;
			for (Document doc : Document.getListeDocuments()) {
				if (numEnregistrement.equals(doc.getNumEnregistrement())) {
					docTrouve = true;
					aModifier = doc;
				}
			}

			if (!docTrouve) {
				System.out.println("\nLe num�ro d'enregistrement saisi ne correspond � aucun document.");
				System.out.println("Modification annul�e.");
			} else {
				// Saisie du nouveau titre
				System.out.println("Veuillez saisir le nouveau titre � donner � ce document.");
				System.out.print("Titre : ");
				String nouveauTitre = sc.nextLine();

				// Avertissement
				System.out.println("Voulez-vous vraiment modifier le titre de : " + aModifier.getTitre() + " ?");
				System.out.println("Cette action est irr�versible.");
				System.out.print("Saisissez 'MODIFIER' pour confirmer : ");
				String confirmation = sc.nextLine();

				if (!confirmation.equals("MODIFIER")) {
					System.out.println("Confirmation incorrecte.");
					System.out.println("Le document n'a pas �t� modifi�.");
				} else {
					// Modification du titre
					aModifier.setTitre(nouveauTitre);
					System.out.println("Le titre du document est maintenant " + nouveauTitre + ".");
				}
			}
		}
	}

	// Modification de l�auteur d�un livre
	public static void modifierAuteur(Scanner sc) {
		if (Livre.getListeLivres().size() < 1) {
			System.out.println("La biblioth�que ne contient aucun livre.");
			System.out.println("Veuillez ajouter au moins un livre � afficher.");
		} else {
			System.out.println("Voici la liste des livres : ");

			for (int i = 0; i < Livre.getListeLivres().size(); i++) {
				System.out.println("\n" + (i + 1) + " - \t" + Livre.getListeLivres().get(i).getTitre());
				System.out.println("    \tPar " + Livre.getListeLivres().get(i).getNomAuteur());
			}

			System.out.println("\nVeuillez saisir le nombre correspondant au livre � afficher.");
			int indexAModifier;
			do {
				System.out.print("Votre choix : ");
				indexAModifier = sc.nextInt() - 1;
				sc.nextLine();

				if (indexAModifier < 0 || indexAModifier > (Livre.getListeLivres().size() - 1)) {
					System.out.println("Veuillez saisir un nombre parmi ceux affich�s � c�t� des titres ci-haut.");
				}
			} while (indexAModifier < 0 || indexAModifier > (Livre.getListeLivres().size() - 1));

			Livre aModifier = Livre.getListeLivres().get(indexAModifier);

			// Saisie du nouvel auteur
			System.out.println("Veuillez saisir le nom du nouvel auteur de ce livre.");
			System.out.print("Auteur : ");
			String nouvelAuteur = sc.nextLine();

			// Avertissement
			System.out.println("Voulez-vous vraiment modifier l'auteur de : " + aModifier.getTitre() + " ?");
			System.out.println("Cette action est irr�versible.");
			System.out.print("Saisissez 'MODIFIER' pour confirmer : ");
			String confirmation = sc.nextLine();

			if (!confirmation.equals("MODIFIER")) {
				System.out.println("Confirmation incorrecte.");
				System.out.println("Le document n'a pas �t� modifi�.");
			} else {
				// Modification de l'auteur
				aModifier.setNomAuteur(nouvelAuteur);
				System.out.println("L'auteur du livre est maintenant " + nouvelAuteur + ".");
			}
		}
	}

	// Cr�ation et ajout de documents pr�d�finis
	public static void ajouterPredefinis() {
		// Romans
		new Roman("1605DonQui", "Don Quichotte", 16, "Miguel de Cervantes", 426, new ArrayList<String>(
				Arrays.asList("Roman le plus populaire", "Meilleure histoire chevaleresque", "Coup de coeur 1605")));
		new Roman("1865AlPaMe", "Alice au pays des merveilles", 18, "Lewis Caroll", 181,
				new ArrayList<String>(Arrays.asList("Meilleure histoire pour enfants", "Meilleur roman britannique")));

		// Manuels
		new Manuel("ChimieOrg2", "Chimie organique : Les grands principes", 25, "John McMurry", 672, Domaine.CHIMIE);
		new Manuel("2019Java9e", "Java Software Solutions: Foundations of Program Design", 30, "John Lewis", 784,
				Domaine.INFORMATIQUE);

		// Revues
		new Revue("ZoneCampus", "Zone campus #1", 9, 9, 2005);
		new Revue("Curium2016", "Curium #17", 7, 4, 2016);

		// Dictionnaires
		new Dictionnaire("Larousse07", "Le petit Larousse illustr� 2007", 14, Langue.FRANCAIS);
		new Dictionnaire("MerriWebst", "The Merriam-Webster Dictionary", 8, Langue.ANGLAIS);

		System.out.println("2 documents de chaque cat�gorie ont �t� ajout�s.");
	}

	// V�rification du num�ro d'enregistrement (10 caract�res alphanum�riques)
	public static boolean verifNumEnregistrement(String numSaisi) {
		boolean numValide = true;

		if (numSaisi.length() != 10) {
			numValide = false;
		}
		// analyse le num enregistrement de l'utilisateur, pour faire simple,
		// s'il n'y a aucune lettre le num�ro d'enregistrement n'est pas alphanum�rique
		// donc il est faux
		for (int i = 0; i < numSaisi.length(); i++) {
			if (!Character.isLetterOrDigit(numSaisi.charAt(i))) {
				numValide = false;
				break;
			}
		}
		// si le num�ro d'enregistrement contient et des lettres et des num�ro, il est
		// valide
		return numValide;
	}

}
