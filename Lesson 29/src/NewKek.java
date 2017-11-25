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
		 * 1. ������ � ������ ���� ��������� �� ���� ��������.
		 * 2. ������ ���� ��������� �� �������.
		 * 3. �� �� ������� ������ "�����" � "���" � �� �� ���� 
		 * ����� ���� �� ����� �����
		 * 4. �� ���� ���� �� ����� ������� ���� - 1������ 2������ � ��.
		 * ����� ���� �� ���� ����� ����.
		 */
	}
}
