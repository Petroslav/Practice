package immigrants;

import java.util.Comparator;

public class MoneyComparator implements Comparator<Immigrant> {

	@Override
	public int compare(Immigrant arg0, Immigrant arg1) {
		return arg0.getCash() - arg1.getCash();
	}

}
