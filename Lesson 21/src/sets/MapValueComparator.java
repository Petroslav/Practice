package sets;

import java.util.Comparator;
import java.util.Map.Entry;

public class MapValueComparator implements Comparator<Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		if(((int) o1.getValue()) - ((int) o2.getValue()) == 0) return o1.getKey().compareTo(o2.getKey());
		return ((int) o2.getValue()) - ((int) o1.getValue());
	}

}
