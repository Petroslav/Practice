package products;

public class InvalidProductException extends Exception {

	private String productName;
	private String productClassName;
	private double productPrice;
	
	public InvalidProductException(String productClassName, String productName, double price) {
		this.productName = productName;
		this.productClassName = productClassName;
		this.productPrice = price;
	}
	
	@Override
	public String getMessage() {
		return "Invalid parameter when trying to create a product of type " + productClassName + " with name " + productName + " and price " + productPrice;
	}
	
}
