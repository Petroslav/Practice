package idk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class WarAndPeace2 {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		
		File war = new File("voina_i_mir.txt");
		ArrayList<String> words = new ArrayList<String>();
		TreeSet<String> wordsByLength = new TreeSet<String>(new Comparator<String>(){	
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) return s1.compareTo(s2);
				return s1.length() - s2.length();
			}		
		});
		
		Scanner sc = null;
		try {
			sc = new Scanner(war);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		while(sc.hasNextLine()){
			String[] byWord = sc.nextLine().split("[\\s+\\-*_*?*!*,*.*:*;*_*$*\"*'*«*»*)*(*¤*є*]");
			for(String s : byWord) words.add(s);
		}
		sc.close();
		
		wordsByLength.addAll(words);
		ArrayList<String> wowo = new ArrayList<String>();
		int curL = 1;
		for(String s : wordsByLength){
			if(curL != s.length()){
				File f = new File("nz/" + curL + " chars.txt");
				PrintStream ps = getPS(f);
				for(String ss : wowo){
					ps.println(ss);
				}
				curL = s.length();
				wowo.clear();
			}else wowo.add(s);
		}
		System.out.println("Elapsed time: " + ((System.currentTimeMillis() - start)/1000) + " seconds");
	}
	
	public static PrintStream getPS(File f){
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Could not create file.");
			}
		}
		
		PrintStream ps = null;
		
		try {
			ps = new PrintStream(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		return ps;
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
}