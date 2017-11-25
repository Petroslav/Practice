import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ReadingAndWriting {

	public static void main(String[] args) throws IOException {
		File fernando = new File("Blyat/luffy.jpg");
		File fernando2 = new File("Blyat/luffy2.jpg");

		FileInputStream fis = new FileInputStream(fernando);
		FileInputStream fis2 = new FileInputStream(fernando2);
		int bukva = fis.read();
		int bukva2 = fis2.read();
		while(bukva != -1 || bukva2 != -1){
			if(fis.read() == -1 || fis2.read() == -1) System.out.println("They are the same");
			bukva = fis.read();
			bukva2 = fis2.read();
			if(bukva != bukva2) {
				System.out.println("Pictures are different.");
				break;
			}
		}
		
//		try {
//			fernando.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			OutputStream os = new FileOutputStream(fernando);
//			os.write('H');
//			os.write('E');
//			os.write('L');
//			os.write('L');
//			os.write('O');
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found");
//		} catch (IOException e){
//			
//		}
		
	}
}
