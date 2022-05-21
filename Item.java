import java.io.Serializable;
public abstract class Item implements Serializable{
	public float getPrix(){
		return 0;
	}
	public String getItemType(){
		return "";
	}
}