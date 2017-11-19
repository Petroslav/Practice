package shop;

public class ShopFullException extends Exception {

	@Override
	public String getMessage() {
		return "Shop is full!";
	}
}
