package products;

public class Product implements Cloneable{
	
	private String name;
	private int quantity;
	private ProductType type;
	
	public Product(String name, ProductType type) {
		
		this.name = name;
		this.quantity = 15;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public ProductType getType() {
		return type;
	}
	
	//Methods:
	
	public void supplyProduct(int amount) {
		this.quantity += amount;
	}
	
	public void sellProduct(int amount) {
		this.quantity -= amount;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return name + " - " + quantity;
	}
	
	@Override
	public Product clone() throws CloneNotSupportedException {
		return (Product) super.clone();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
}
