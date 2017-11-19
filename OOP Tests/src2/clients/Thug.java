package clients;
import java.util.ArrayList;

import menu.*;

public class Thug extends Client {

	public Thug(){
		this.cash = 50;
	}

	@Override
	public void makeOrder() {
		ArrayList<IItem> menu = new ArrayList<IItem>();
		menu = this.getServer().getMenu();
		IItem item = null;
		do{
			item = menu.get(rng.nextInt(menu.size()));
			if(item instanceof MainDish || item instanceof Alcohol) {
				try{
					item.sell();
					break;
				}
				catch(ItemUnavailableException e){
					continue;
				}
			}
		}while(true);
		if(this.requestBill() + item.getPrice() > this.cash*ORDER_CAP) return;
		this.order.add(item);
		this.getServer().takeOrder(this, order);
	}
}
