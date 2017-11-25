import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

public class WarAndPeace {

	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> wordsByTimesSeen = new HashMap<String,Integer>();
		TreeSet<String> wordsByLength = new TreeSet<String>(new LengthComparator());
		int[] warAndPeace = new int[2]; // cell 0 = war cell 1 = peace
		File war = new File("Blyat/war and peace.txt");
		Scanner sc = new Scanner(war);
		while(sc.hasNextLine()){
			String row = sc.nextLine();
			row = row.toLowerCase();
			String[] words = row.split("[\\p{Punct}\\s]+");
			for(String s : words){
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
		sc.close();
		File swag1 = new File("Blyat/Words by Length.txt");
		File swag2 = new File("Blyat/Words times Seen.txt");
		swag1.createNewFile();
		PrintStream ps = new PrintStream(swag1);
		swag2.createNewFile();
		PrintStream ps2 = new PrintStream(swag2);
		for(String z : wordsByLength){
			ps.println(z);
		}
		ps.close();
		ArrayList<Entry<String, Integer>> sadlife = new ArrayList<>();
		sadlife.addAll(wordsByTimesSeen.entrySet());
		Collections.sort(sadlife, new TimesSeenComparator());
		ps2.close();
		for(Entry<String, Integer> rip : sadlife){
			ps2.println(rip.getKey() + " - seen " + rip.getValue() + " times");
			File f = new File("nz/" + rip.getKey().length() +" letters.txt");
			if(!f.exists()) f.createNewFile();
			BufferedWriter writes = new BufferedWriter(new FileWriter(f, true));
			writes.append(rip.getKey() + " - seen " + rip.getValue() + " times");
			writes.newLine();
			writes.close();
		}
		System.out.println(wordsByTimesSeen.size());
		System.out.println(wordsByLength.size());
		System.out.println("����� �� ����� " + warAndPeace[0] + " ����");
		System.out.println("��� �� ����� " + warAndPeace[1] + " ����");
		
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
 * 1. ������ � ������ ���� ��������� �� ���� ��������, �������� ��� ����
 * 2. ������ ���� ��������� �� �������, �������� ��� ����
 * 3. �� �� ������� ������ "�����" � "���" � �� �� ���� ����� ���� �� ����� �����
 * 4. �� ���� ���� �� ����� ������� ���� - 1������ 2������ � �.�. ����� ���� �� ���� ����� ����.
 */