package menu;

public interface IItem {

	public void sell() throws ItemUnavailableException;
	public int getPrice();
	
}
