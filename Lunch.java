import java.util.Scanner;
public class Lunch extends Menu{
	private Item item;
	public Lunch(){
		String option;
		Scanner sc = new Scanner(System.in);
		boolean quitter = true;
		do{
			System.out.println("CHOISISSEZ UN ITEM");
			System.out.println("------------------");
			System.out.println("1. Appetizer\n2. Dish\n3. Dessert\n4. Cafe\n5. Drink\n6. Quitter");
			System.out.print(">>> ");
			option = sc.nextLine();
			switch (option){
			case "1":
				this.item = new Appetizer();
				quitter = true;
			break;
			case "2":
				this.item = new Dish();
				quitter = true;
			break;
			case "3":
				this.item = new Dessert();
				quitter = true;
			break;
			case "4":
				this.item = new Cafe();
			break;
			case "5":
				this.item = new Drink();
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
	public Item getItem(){
		return this.item;
	}
}