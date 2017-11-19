package america;

import java.util.Comparator;

public class CityComparatorByCitizens implements Comparator<City> {

	@Override
	public int compare(City o1, City o2) {
		return o1.getCitizens() - o2.getCitizens();
	}

}
