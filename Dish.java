public class Dish extends Item{
	protected String description = "Les boulettes aux oeufs";
	protected float prix = 80;
	public Dish(){

	}
	public float getPrix(){
		return this.prix;
	}
	public String getItemType(){
		return this.getClass().getName();
	}
}