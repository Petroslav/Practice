
public class Computer {

	int year;
	double price;
	boolean isNotebook;
	double hDDMem;
	double freeMem = hDDMem;
	String opSys;
	
	void changeOpSys(String newSys){
		opSys = newSys;
	}
	
	void useMem(int mem){
		if(mem > freeMem){
			System.out.println("Not enough space!");
		}else{
			freeMem-= mem;
		}
	}
	
	Computer(){
		this.isNotebook = false;
		this.opSys = "Win XP";
	}
	
	Computer(int year, double price, double mem, double freeMem){
		if((year > 1970 && year < 2018) && (mem > 0) && (price > 0) && (freeMem <= mem)){
			this.year = year;
			this.hDDMem = mem;
			this.freeMem = freeMem;
			this.price = price;
		}
	}
	
	Computer(int year, double price, boolean isNotebook, double mem, double freeMem, String opSys){
		this(year, price, mem, freeMem);
		this.isNotebook = isNotebook;
		this.opSys = opSys;
		
	}
	
	int comparePrice(Computer c){
		if(this.price == c.price){
			return 0;
		}
		if(this.price > c.price){
			return -1;
		}else{
			return 1;
		}
	}
}
