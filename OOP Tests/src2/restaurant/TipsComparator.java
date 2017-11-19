package restaurant;
import java.util.Comparator;

public class TipsComparator implements Comparator<Waiter> {

	@Override
	public int compare(Waiter o1, Waiter o2) {
		return (int) o1.getTips() - (int) o2.getTips();
	}

	

}
