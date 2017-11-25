import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NewKek {

	public static void main(String[] args) throws IOException {
		File f = new File("Blyat/voina_i_mir.txt");
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
		/*
		 * 1. Списък с всички думи подредени по броя срещания.
		 * 2. Всички думи подредени по дължина.
		 * 3. Да се извадят думите "война" и "мир" и да се каже 
		 * колко пъти се среща всяка
		 * 4. По един файл за фсяка дължина дума - 1буквен 2буквен и тн.
		 * всеки файл да пише всяка дума.
		 */
	}
}
