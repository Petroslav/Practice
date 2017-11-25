import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		File fs = new File("Blyat");
		fs.mkdir();
		File f1 = new File("Blyat/jojo.txt");
		File f2 = new File("Blyat/jojo2.txt");
		File f3 = new File("Blyat/jojo3.txt");
		File f4 = new File("Blyat/jojo4.txt");
		File f5 = new File("Blyat/jojo5.txt");
		
		try {
			f1.createNewFile();
			f2.createNewFile();
			f3.createNewFile();
			f4.createNewFile();
			f5.createNewFile();
		} catch (IOException e) {
			System.out.println("Kekleon - it ded");
		}		
		
		for(File f : fs.listFiles()){
			System.out.println(f.getAbsolutePath());
		}
	}
}
