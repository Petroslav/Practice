
public class ComputerDemo {

	public static void main(String[] args) {
		Computer pc1 = new Computer();
		Computer pc2 = new Computer();
		
		pc1.year = 2016;
		pc1.price = 1425.99;
		pc1.hDDMem = 250;
		pc1.freeMem = 250;
		pc1.opSys = "Windows 10";
		pc1.isNotebook = true;
		
		pc2.year = 2017;
		pc2.price = 2199.99;
		pc2.hDDMem = 1024;
		pc2.freeMem = 1024;
		pc1.opSys = "Mac OS X";
		
		pc1.useMem(100);
		pc2.changeOpSys("Windows 10.1");
		
		System.out.println("PC 1 SPECS");
		System.out.println("Cost: "+pc1.price+";");
		System.out.println("Year: "+pc1.year);
		System.out.println("Total space: "+pc1.hDDMem+"; Free space: "+pc1.freeMem);
		System.out.println("OS: "+pc1.opSys);
		System.out.println();
		System.out.println("===PC 2 SPECS===");
		System.out.println("Cost: "+pc2.price+";");
		System.out.println("Year: "+pc2.year);
		System.out.println("Total space: "+pc2.hDDMem+"; Free space: "+pc2.freeMem);
		System.out.println("OS: "+pc2.opSys);
	}
}
