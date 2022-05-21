import java.util.Scanner;
public class Cafe extends Item{
	protected String nom = "Boisson chaude";
	protected int prix = 5;
	protected CafeCategory categorie;
	public Cafe(){
		String option;
		Scanner sc = new Scanner(System.in);
		boolean quitter = true;
		do{
			System.out.println("CHOISISSEZ UNE CATEGORIE DE BOISSON CHAUDE");
			System.out.println("-----------------------------------------");
			System.out.println("1. Coffe\n2. Thea\n3. Chocolate\n4. Quitter");
			System.out.print(">>> ");
			option = sc.nextLine();
			switch (option){
			case "1":
				this.categorie = new Coffe();
				quitter = true;
			break;
			case "2":
				this.categorie = new Thea();
				quitter = true;
			break;
			case "3":
				this.categorie = new Chocolate();
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
	public float getPrix(){
		return this.prix;
	}
	public String getItemType(){
		return this.getClass().getName()+"->"+this.categorie.getClass().getName();
	}
}