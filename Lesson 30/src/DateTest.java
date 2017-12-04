import java.time.LocalDate;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date();
		LocalDate ldate = LocalDate.now();
		
		System.out.println(ldate);
		System.out.println(date);
	}
}
