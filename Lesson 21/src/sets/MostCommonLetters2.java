package sets;

import java.util.*;
import java.util.Map.Entry;
public class MostCommonLetters2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		sc.close();
		text = text.toUpperCase();
		int numberOfLetters = 0;
		HashMap<String, Integer> letters = new HashMap<String, Integer>();
		
		for (int i = 0; i < text.length(); i++) {
			if(!Character.isLetter(text.charAt(i))) continue;
			numberOfLetters++;
			String t1 = Character.toString(text.charAt(i));
			if(letters.get(t1) == null) letters.put(t1, 1);
			else{
				int count = letters.get(t1);
				letters.put(t1, ++count);
			}			
		}
		
		ArrayList<Entry<String, Integer>> sortedLetters = new ArrayList<Entry<String, Integer>>();
		sortedLetters.addAll(letters.entrySet());
		Collections.sort(sortedLetters, new MapValueComparator());
		
		for (int i = 0; i < sortedLetters.size(); i++) {
			System.out.print(sortedLetters.get(i).getKey() + " - " + sortedLetters.get(i).getValue() + " : ");
			double end = (int) sortedLetters.get(i).getValue();
			end = (end/numberOfLetters)*100;
			end = Math.round(end);
			for (int j = 0; j < end; j++) {
				System.out.print("#");
			}
			System.out.print(" - " + end + "%");
			System.out.println();
		}
	}
}