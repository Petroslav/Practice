import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerAndPrinter {

	public static void main(String[] args) throws FileNotFoundException {
		
		File f = new File("Blyat/war and peace.txt");
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(f);
		int symbols = 0;
		int bukvi = 0;
		int commas = 0;
		while(sc.hasNextLine()){
			String row = sc.nextLine();
			for(char c : row.toCharArray()){
				if(Character.isLetter(c)){
					bukvi++;
				}
				if(c == ','){
					commas++;
				}
			}
			symbols+=row.length();
		}
		System.out.println("Symbols = " + symbols);
		System.out.println("Letters = " + bukvi);
		System.out.println("Commas = " + commas);
		long end = System.currentTimeMillis();
		System.out.println("duration = " + (end - start) + " milliseconds ");
	}
}
