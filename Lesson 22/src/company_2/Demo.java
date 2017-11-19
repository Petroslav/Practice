package company_2;

public class Demo {

	public static void main(String[] args) {
		Company pcloud = new Company("pCloud LTD");
		Employee jani = new Employee("Jani", 23, 2700, 940614, "iOS");
		Employee pepi = new Employee("Pepi", 23, 2500, 940628, "iOS");
		Employee sisi = new Employee("Sisi", 29, 1900, 881225, "Android");
		Employee lili = new Employee("Lili", 44, 3500, 730420, "Desktop");
		Employee momo = new Employee("Momo", 27, 1800, 901211, "Android");
		Employee nini = new Employee("Nini", 28, 1580, 890112, "Marketing");
		Employee bibi = new Employee("Bibi", 33, 1200, 841212, "Desktop");
		Employee jiji = new Employee("Jiji", 25, 1200, 920331, "Android");
		Employee kaja = new Employee("Kaja", 20, 2700, 970812, "Desktop");

		pcloud.hireEmployee(jani);
		pcloud.hireEmployee(pepi);
		pcloud.hireEmployee(sisi);
		pcloud.hireEmployee(lili);
		pcloud.hireEmployee(momo);
		pcloud.hireEmployee(nini);
		pcloud.hireEmployee(bibi);
		pcloud.hireEmployee(jiji);
		pcloud.hireEmployee(kaja);
		
		System.out.println(pcloud.getStaff());
		System.out.println("=====");
		System.out.println(pcloud.getStaffByAge());
		System.out.println("=====");
		System.out.println(pcloud.getStaffBySalary());
		System.out.println("=====");
		System.out.println(pcloud.getStaffByName());
		
	}
}
