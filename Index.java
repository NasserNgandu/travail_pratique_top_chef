import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Index{
	public static void main(String[] args) {
		String option;
		int option_cordon_bleu;
		int option_serveur;
		Scanner sc = new Scanner(System.in);
		boolean quitter = false;
		List<Commande> listeCommande = new ArrayList<Commande>();
		do {
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("Bien venu sur l'application Top Chef");
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			System.out.println("Pour commencer, choisissez qui vous etes :");
			System.out.println("1. Client\n2. Cordon Bleu\n3. Serveur\n4. Manager\n5. Quitter");
			System.out.print(">>> ");
			option = sc.nextLine();
			switch (option){
			case "1":
				Commande commande = new Commande();
				listeCommande.add(commande);
				System.out.println("--------------------------------------");
				System.out.println("Commande reussi");
				System.out.println("--------------------------------------");
				System.out.println("Vous avez commander : \n" + commande.commande + " : " + commande.prix + " $");
			break;
			case "2":
				boolean quitter_cordon_bleu = false;
				do {
					System.out.println("----------------------------------------");
					System.out.println("Voici la liste de commandes(Cordon bleu)");
					System.out.println("---------------------------------------");
					System.out.println("choisissez un commande a preparer.\nLes commandes avec un \"*\" sont deja en preparation.\nLes commandes avec un \"-\" sont deja livrées.");
					int compteur = 0;
					String etat;
					for(compteur = 0; compteur < listeCommande.size(); compteur++){
						etat = listeCommande.get(compteur).etat.equals("en cours de préparation") ? " * " 
						: listeCommande.get(compteur).etat.equals("en cours de préparation") ? " - " 
						: listeCommande.get(compteur).etat.equals("livree") ? " - " : "";
						System.out.println(compteur + 1 + ". " + listeCommande.get(compteur).commande + etat);
					}
					System.out.println(compteur + 1 + ". Quitter");
					System.out.print(">>> ");
					try {
						option_cordon_bleu = Integer.parseInt(sc.nextLine());
						if (option_cordon_bleu < compteur + 1) {
							listeCommande.get(option_cordon_bleu - 1).setEtat("en cours de préparation");
						} else if (option_cordon_bleu == compteur + 1) {
							quitter_cordon_bleu = true;
						}
					} catch (Exception e) {
						System.out.println("Option invalide");
						quitter_cordon_bleu = true;
					}
				} while (!quitter_cordon_bleu);
			break;
			case "3":
				boolean quitter_serveur = false;
				do {
					System.out.println("------------------------------------");
					System.out.println("Voici la liste de commandes(Serveur)");
					System.out.println("------------------------------------");
					System.out.println("choisissez une commande a preparer.\nLes commandes avec un \"*\" sont deja en preparation.\nLes commandes avec un \"-\" sont deja livrées.");
					int compteur = 0;
					String etat;
					for(compteur = 0; compteur < listeCommande.size(); compteur++){
						etat = listeCommande.get(compteur).etat.equals("en cours de préparation") ? " * " 
						: listeCommande.get(compteur).etat.equals("en cours de préparation") ? " - " 
						: listeCommande.get(compteur).etat.equals("livree") ? " - " : "";
						System.out.println(compteur + 1 + ". " + listeCommande.get(compteur).commande + " : " + listeCommande.get(compteur).prix + " $ " + etat);
					}
					System.out.println(compteur + 1 + ". Quitter");
					System.out.print(">>> ");
					try {
						option_serveur = Integer.parseInt(sc.nextLine());
						if (option_serveur < compteur + 1) {
							if (listeCommande.get(option_serveur -1).etat.equals("en cours de préparation")) {
								listeCommande.get(option_serveur - 1).setEtat("livree");	
							} else {
								System.out.println("Commande pas encore preparée");
							}
							
						} else if (option_serveur == compteur + 1) {
							quitter_serveur = true;
						}
					} catch (Exception e) {
						System.out.println("Option invalide");
						quitter_serveur = true;
					}
				} while (!quitter_serveur);
			break;
			case "4":
				boolean quitter_manager = true;
				int nombre_commande_emise = 0;
				float montant_commande_emise = 0;
				int nombre_commande_en_preparation = 0;
				float montant_commande_en_preparation = 0;
				int nombre_commande_livree = 0;
				float montant_journaliere = 0;
				do {
					System.out.println("-----------------------------------------------");
					System.out.println("STATISTIQUE DE LA JOURNEE " + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
					System.out.println("-----------------------------------------------");
					System.out.println("Les commandes avec un \"*\" sont en preparation.\nLes commandes avec un \"-\" sont livrée.");
					String etat;
					for(int compteur = 0; compteur < listeCommande.size(); compteur++){
						etat = listeCommande.get(compteur).etat.equals("en cours de préparation") ? " * " 
						: listeCommande.get(compteur).etat.equals("en cours de préparation") ? " - " 
						: listeCommande.get(compteur).etat.equals("livree") ? " - " : "";
						System.out.println(compteur + 1 + ". " + listeCommande.get(compteur).commande + " : " + listeCommande.get(compteur).prix + etat);
						if (listeCommande.get(compteur).etat.equals("emise")) {
							nombre_commande_emise++;
							montant_commande_emise = montant_commande_emise + listeCommande.get(compteur).prix;

						}else if (listeCommande.get(compteur).etat.equals("en cours de préparation")) {
							nombre_commande_en_preparation++;
							montant_commande_en_preparation = montant_commande_en_preparation + listeCommande.get(compteur).prix;
						} else if (listeCommande.get(compteur).etat.equals("livree")) {
							nombre_commande_livree++;
							montant_journaliere = montant_journaliere + listeCommande.get(compteur).prix;
						}
					}
					System.out.println("-----------------------------------------------");
					System.out.println("COMMANDE EMISE : " + nombre_commande_emise + " : " + montant_commande_emise + " $");
					System.out.println("COMMANDE EN PREPARATION : " + nombre_commande_en_preparation + " : " + montant_commande_en_preparation + " $");
					System.out.println("COMMANDE LIVREE : " + nombre_commande_livree + " : " + montant_journaliere + " $");
					System.out.println("-----------------------------------------------");
				} while (!quitter_manager);
			break;
			case "5":
				quitter = true;
			break;
			default:
				System.out.println("Option invalide");
			}
		} while (!quitter);
	}
}