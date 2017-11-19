package bob;

public class PriBaba {

	public static void main(String[] args) {
		
		Pot gurne = new Pot();
		
		Baba baba = new Baba(gurne);
		Vnuche vnuche = new Vnuche(gurne);
		
		baba.start();
		vnuche.start();
		
		
	}
}
