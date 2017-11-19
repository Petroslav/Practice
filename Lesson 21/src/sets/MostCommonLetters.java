package sets;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MostCommonLetters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		double times = 0;
		
		Map<Character, Integer> letters = new HashMap<Character, Integer>();
		text = text.toUpperCase();
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if(!Character.isLetter(text.charAt(i))) continue;
			times++;
			if(letters.get(text.charAt(i)) == null) letters.put(text.charAt(i), 1);
			else{
				count = letters.get(text.charAt(i));
				letters.put(text.charAt(i), ++count);
			}
		}
		
		letters = sortByValue(letters);
		
		for(Entry<Character, Integer> it : letters.entrySet()){
			System.out.print(it.getKey() + ": " + it.getValue() + " ");
			double end = (int) it.getValue();
			end = (end / times)*100;
			for (double i = 0; i < end; i++) {
				System.out.print("#");
			}
			System.out.println(" - " + Math.round(end) + "%");
			System.out.println();
		}
	}
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	    return map.entrySet()
	              .stream()
	              .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              ));
	}
}
