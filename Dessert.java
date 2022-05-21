public class Dessert extends Item{
	protected String description = "Dessert au chocolat";
	protected float prix = 30;
	public Dessert(){

	}
	public float getPrix(){
		return this.prix;
	}
	public String getItemType(){
		return this.getClass().getName();
	}
}