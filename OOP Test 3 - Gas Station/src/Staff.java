
public abstract class Staff extends Thread{

	private static GasStation workplace;
	
	public static void setWorkplace(GasStation workplace) {
		Staff.workplace = workplace;
	}
	
	public static GasStation getWorkplace() {
		return workplace;
	}
}
