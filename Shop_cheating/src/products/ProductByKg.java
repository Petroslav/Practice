package products;

public abstract class ProductByKg extends Product {

	public ProductByKg(String name, double price, double quantity) throws InvalidProductException {
		super(name, price);
		if(quantity < 0){
			throw new InvalidProductException(getClass().getName(), name, price);
		}
		this.quantity = quantity;
	}

	private double quantity;
	
	@Override
	public double getQuantity() {
		return this.quantity;
	}
	
	@Override
	public void addQuantity(double quantity) {
		if(quantity > 0)
			this.quantity+=quantity;
	}
	
	@Override
	public void setQuantity(double quantity) {
		if(quantity > 0){
			this.quantity = quantity;
		}
	}
	
	@Override
	public void removeQuantity(double quantity) {
		if(quantity > 0 && this.quantity >= quantity)
			this.quantity-=quantity;
	}
}
