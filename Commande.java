import java.util.Scanner;
import java.io.Serializable;

public class Commande implements Serializable{
	protected String etat = "emise";
	protected String commande;
	protected float prix;
	protected Menu menu;
	public Commande(){
		String option;
		Scanner sc = new Scanner(System.in);
		boolean quitter = false;
		do{
			System.out.println("CHOISISSEZ UNE OPTION");
			System.out.println("---------------------");
			System.out.println("1. Breakfast\n2. Lunch\n3. Dinner\n4. Quitter");
			System.out.print(">>> ");
			option = sc.nextLine();
			switch (option){
			case "1":
				menu = new Breakfast();
				prix =  menu.getPrix();
				commande = "Breakfast";
				quitter = true;
			break;
			case "2":
				menu = new Lunch();
				prix =  menu.getItem().getPrix();
				commande = "Lunch->"+menu.getItem().getItemType();
				quitter = true;
			break;
			case "3":
				menu = new Dinner();
				prix =  menu.getItem().getPrix();
				commande = "Dinner->"+menu.getItem().getItemType();
				quitter = true;
			break;
			case "4":
				quitter = true;
			break;
			default:
				System.out.println("Option invalide");
				quitter = false;
			}
		}while(!quitter);
	}
	public void setEtat(String etat){
		this.etat = etat;
	}
}