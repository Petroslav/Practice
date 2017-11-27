import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

public class WarAndPeace {

	public static void main(String[] args) throws IOException {

		long start = System.currentTimeMillis();
		
		File war = new File("voina_i_mir.txt");
		HashMap<String, Integer> wordsByTimesSeen = new HashMap<String,Integer>();
		TreeSet<String> wordsByLength = new TreeSet<String>(new LengthComparator());
		int[] warAndPeace = new int[2]; // cell 0 = war cell 1 = peace
		
		Scanner sc = new Scanner(war);
		int wordcount = 0;
		while(sc.hasNextLine()){
			String row = sc.nextLine();
			row = row.toUpperCase();
			ArrayList<String> words = WarAndPeace.splitIntoWords(row);
			wordcount += words.size();
			for(String s : words){
				if(wordsByTimesSeen.get(s) == null) wordsByTimesSeen.put(s, 1);
				else {
					int value = wordsByTimesSeen.get(s);
					wordsByTimesSeen.put(s, ++value);
				}
				wordsByLength.add(s);
				if(s.equalsIgnoreCase("war") || s.equalsIgnoreCase("война")) warAndPeace[0]++;
				if(s.equalsIgnoreCase("peace") || s.equalsIgnoreCase("мир")) warAndPeace[1]++;
			}
		}
		sc.close();
		
		File wordsLength = new File("Blyat/Words by Length.txt");
		File wordsSeen = new File("Blyat/Words times Seen.txt");
		wordsLength.createNewFile();
		wordsSeen.createNewFile();
		PrintStream ps = new PrintStream(wordsLength);
		for(String z : wordsByLength){
			ps.println(z);
		}
		ps.close();
		
		ps = new PrintStream(wordsSeen);
		
		ArrayList<Entry<String, Integer>> sadlife = new ArrayList<>();
		sadlife.addAll(wordsByTimesSeen.entrySet());
		Collections.sort(sadlife, new TimesSeenComparator());
		
		for(Entry<String, Integer> rip : sadlife){
			ps.println(rip.getKey() + " - seen " + rip.getValue() + " times");
			
			File f = new File("nz/" + rip.getKey().length() +" letters.txt");
			if(!f.exists()) f.createNewFile();
			
			BufferedWriter writes = new BufferedWriter(new FileWriter(f, true));
			writes.append(rip.getKey() + " - seen " + rip.getValue() + " times");
			writes.newLine();
			writes.close();
		}
		ps.close();


		System.out.println("words: " + wordcount);
		System.out.println("unique words: " + wordsByTimesSeen.size());
		System.out.println("WAR: " + warAndPeace[0]);
		System.out.println("PEACE: " + warAndPeace[1]);
		System.out.println("Elapsed time: " + ((System.currentTimeMillis() - start)/1000) + " seconds");
	}
	
	private static ArrayList<String> splitIntoWords(String ss) {
		ArrayList<String> words = new ArrayList<>();
		String tempString = null;
		for(int i = 0; i < ss.length(); i++){
			if(!Character.isLetter(ss.charAt(i))){
				if(tempString != null) words.add(tempString);
				tempString = null;
				continue;
			}
			String c = Character.toString(ss.charAt(i));				
			if(Character.isLetter(ss.charAt(i))){
				if(tempString == null) {
					tempString = c;
				}
				else{
					tempString += c;
				}
			}
			if(i == ss.length()-1) words.add(tempString);
		}
		return words;
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