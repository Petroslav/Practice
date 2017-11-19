package Country;

import java.util.Comparator;

public class InhabitantsComparator implements Comparator<City> {

	@Override
	public int compare(City o1, City o2) {
		// TODO Auto-generated method stub
		return o1.getCitizens() - o2.getCitizens();
	}

}
