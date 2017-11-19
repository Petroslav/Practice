package people;

import products.Product;
import products.ProductByCount;
import products.ProductByKg;
import shop.Shop;

class Buyer implements IBuyer{
	
	private String name;
	private Shop shop;
	private double money;
	private int maxProducts;//to buy from the shop.
	private Product[] cart;
	private int freePlaces = 0;

	Buyer(String name, Shop shop, int neededProducts, double money) {
		this.maxProducts = neededProducts;
		this.name = name;
		this.shop = shop;
		this.cart = new Product[maxProducts];
		this.money = money;
	}
	

	@Override
	public void addProductByKg(ProductByKg product, double amount) throws CloneNotSupportedException {
		addProduct(product, amount);
	}

	@Override
	public void addProductByCount(ProductByCount product, int amount) throws CloneNotSupportedException {
		addProduct(product, amount);
	}

	@Override
	public void removeProductByKg(ProductByKg product, double amount) {
		removeProduct(product, amount);
	}

	@Override
	public void removeProductByCount(ProductByCount product, int amount) {
		removeProduct(product, amount);
	}

	private void removeProduct(Product product, double amount) {
		//ako v koli4kata nqma tozi produkt - return
		int index = existsProduct(product);
		if(index == -1){
			return;
		}
		//ako go ima:
		double quantityToRemove = amount;
		if(cart[index].getQuantity() < amount){
			quantityToRemove = cart[index].getQuantity();
			cart[index] = null;
		}
		else{
			cart[index].removeQuantity(quantityToRemove);
		}
			//ako v koli4kata nqma tolkova koli4estvo, mahame kolkoto ima i nulirame kletkata ot masiva
			//inache mahame kolkoto e ukazano
		//sled tova v magazina dobavqme kolkoto  sme mahnali ot koli4kata
		shop.getProduct(shop.existsProduct(product)).addQuantity(quantityToRemove);
		
	}

	private void addProduct(Product product, double amount) throws CloneNotSupportedException {
		int index = shop.existsProduct(product);
		//proverka dali produkta e nali4en v magazina
		if(index == -1){//ako go nqma - nqma kakvo da pazaruvame - ai 4ao
			return;
		}
		else{//ako go ima
			Product productInShop = shop.getProduct(index);
			//vzimame produka i proverqvame dali koli4estvoto v magazina e po-golqmo ili ravno na nujnoto
			if(productInShop.getQuantity() >= amount){//ako ima dostatu4no koli4estvo v magazina
				productInShop.removeQuantity(amount);//go namalqme
			}
			else{
				return;//nqma dostatu4no koli4estvo v magazina -reshavame, che nqma da se pazaruva 
				//za po lesno
				//razbira se mojem da vzemem vsi4ki ostanali, no tova ostavqm na vas . haha
			}
			//trqbva da slojim tova koli4estvo ot produkta v koli4kata
			//proverqvame dali v koli4kata ve4e nqma takuv produkt
			int indexInCart = existsProduct(product);
			if(indexInCart == -1){//vzel sym produkta, no go nqma v koli4kata
				//suzdavam kopie na produkta, slagam mu koli4estvo = tova, koeto mi e trqbvalo i go puham v koli4kata
				Product productInCart = product.clone();
				productInCart.setQuantity(amount);
				if(freePlaces >= maxProducts){
					return;
				}
				cart[freePlaces++] = productInCart;
			}
			else{//vzel sum produca i go ima v koli4kata
				//togava samo mu dopulvam koli4estovo
				cart[indexInCart].addQuantity(amount);
			}
		}
		
	}

	@Override
	public void payProducts() {
		double price = 0;
		for (int i = 0; i < cart.length; i++) {
			if(cart[i] != null){
				price += cart[i].getTotalPrice();
			}
		}
		if(price >= money){
			//1: throw exception
			//2: return random products to shop
			//3: for homework.
		}
		this.money-=price;
		shop.pay(price);
	}
	
	/**
	 * searches for a product in the array
	 * @param x - the product to be found
	 * @return -1 if not found, or the index of the product if found
	 */
	private int existsProduct(Product x){
		for (int i = 0; i < cart.length; i++) {
			if(cart[i] != null && cart[i].getName().equals(x.getName())){
				return i;
			}
		}
		return -1;
	}
}
