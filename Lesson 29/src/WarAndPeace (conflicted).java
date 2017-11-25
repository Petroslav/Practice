import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

public class WarAndPeace {

	public static void main(String[] args) throws IOException {
		File war = new File("Blyat/war and peace.txt");
//		String test = "Zashto, iskam. daSi,; Moq? DA";
//		System.out.println(test);
//		String[] test1 = test.split("[\\p{Punct}\\s]+");
//		for(String a : test1){
//			System.out.println("===" + a + "===");
//		}
//		System.out.println(test);
		Scanner sc = new Scanner(war);
		HashMap<String, Integer> wordsByTimesSeen = new HashMap<String,Integer>();
		TreeSet<String> wordsByLength = new TreeSet<String>(new LengthComparator());
		int[] warAndPeace = new int[2]; // cell 0 = war cell 1 = peace
		while(sc.hasNextLine()){
			String row = sc.nextLine();
			String[] words = row.split("[\\p{Punct}\\s]+");
			for(String s : words){
				s = s.toLowerCase();
				if(wordsByTimesSeen.get(s) == null) wordsByTimesSeen.put(s, 1);
				else {
					int value = wordsByTimesSeen.get(s);
					wordsByTimesSeen.put(s, ++value);
				}
				wordsByLength.add(s);
				if(s.equals("war")) warAndPeace[0]++;
				if(s.equals("peace")) warAndPeace[1]++;
			}
		}

		System.out.println("Война се среща " + warAndPeace[0] + " пъти");
		System.out.println("Мир се среща " + warAndPeace[1] + " пъти");
		
	}
	
	public static class LengthComparator implements Comparator<String>{

		@Override
		public int compare(String s1, String s2) {
			if(s1.length() == s2.length()) return s1.compareTo(s2);
			return s1.length() - s2.length();
		}					
	}
	
	public static class TimesSeenComparator implements Comparator<Entry<String, Integer>>{

		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			if(o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
			return o1.getValue() - o2.getValue();
		}
		
	}
}


/*
 * 1. Списък с всички думи подредени по броя срещания, записани във файл
 * 2. Всички думи подредени по дължина, записани във файл
 * 3. Да се извадят думите "война" и "мир" и да се каже колко пъти се среща всяка
 * 4. По един файл за фсяка дължина дума - 1буквен 2буквен и т.н. всеки файл да пише всяка дума.
 */