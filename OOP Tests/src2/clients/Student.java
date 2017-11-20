package clients;
import java.util.ArrayList;

import menu.*;

public class Student extends Client {

	public Student(){
		this.cash = 10;
	}

	@Override
	public void makeOrder() {
		ArrayList<IItem> menu = new ArrayList<IItem>();
		menu = this.getServer().getMenu();
		IItem item = null;
		do{
			item = menu.get(rng.nextInt(menu.size()));
			try{
				item.sell();
				break;
			}
			catch(ItemUnavailableException e){
				continue;
			}
		}while(true);
		if(this.requestBill() + item.getPrice() > this.cash*ORDER_CAP) return;
		this.order.add(item);
		this.getServer().takeOrder(this, order);
	}
}
