import java.util.Scanner;
public class Drink extends Item{
	protected String nom = "Boisson";
	protected int prix = 2;
	protected DrinkCategory categorie;
	public Drink(){
		String option;
		Scanner sc = new Scanner(System.in);
		boolean quitter = true;
		do{
			System.out.println("CHOISISSEZ UNE CATEGORIE DE BOISSON");
			System.out.println("-----------------------------------------");
			System.out.println("1. Vin\n2. Whisky\n3. Biere\n4. Jus\n5. Eau\n6. Quitter");
			System.out.print(">>> ");
			option = sc.nextLine();
			switch (option){
			case "1":
				this.categorie = new Vin();
				quitter = true;
			break;
			case "2":
				this.categorie = new Whisky();
				quitter = true;
			break;
			case "3":
				this.categorie = new Biere();
				quitter = true;
			break;
			case "4":
				this.categorie = new Jus();
				quitter = true;
			break;
			case "5":
				this.categorie = new Eau();
				quitter = true;
			break;
			case "6":
				quitter = true;
			break;
			default:
				System.out.println("Option invalide");
				quitter = false;
			}
		}while(!quitter);
	}
	public float getPrix(){
		return this.prix;
	}
	public String getItemType(){
		return this.getClass().getName()+"->"+this.categorie.getClass().getName();
	}
}