import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tests {

	public static void main(String[] args) throws IOException {
		File f = new File("wtf.txt");
		Scanner sc = new Scanner(f);
		String ss = null;
		while(sc.hasNextLine()){
			ss = sc.nextLine();
			ArrayList<String> words = new ArrayList<>();
			String tempString = null;
			for(int i = 0; i < ss.length(); i++){
				if(!Character.isLetter(ss.charAt(i))){
					if(tempString != null) words.add(tempString);
					tempString = null;
					continue;
				}
				String c = Character.toString(ss.charAt(i));				
				if(Character.isLetter(ss.charAt(i)) && ss.charAt(i) != ' '){
					if(!Character.isLetter(ss.charAt(i-1))) tempString = c;
					else tempString += c;
				}
				if(i == ss.length()-1) words.add(tempString);
			}
			if(words.size() > 0) System.out.println(words);
		}
		sc.close();
	}
}
