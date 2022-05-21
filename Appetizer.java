public class Appetizer extends Item{
	protected String description = "apéritif a base des fruits";
	protected float prix = 20;
	public Appetizer(){
	}
	public float getPrix(){
		return this.prix;
	}
	public String getItemType(){
		return this.getClass().getName();
	}
}