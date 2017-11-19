package Company;

public class Company {

	public static void main(String[] args) {
		AllWork work = new AllWork();
		Employee.setAllWork(work);
		Employee pesho = new Employee("Pesho");
		Employee mara = new Employee("Mariq \"Marcheto\" Fandykova");
		Employee freeman = new Employee("Morgan Freeman");
		
//
//		Task odit = new Task("Odit", 11);
//		Task copy = new Task("Copy papers", 14);
//
//		work.addTask(odit);
//		work.addTask(copy);
//		
		Task mail = new Task("Send e-mails", 60);
		Task junk = new Task("Spam old co-workers", 18);
		Task ailqk = new Task("Myrzeluvane", 31);
		Task lunch = new Task("Lunch", 13);
		Task betray = new Task("Betraying the company's trust", 40);
		Task bathroom = new Task("Constipation", 11);
		Task runaway = new Task("Running away from work", 5);
		Task shani = new Task("Shanq kompaniqta", 22);
		Task miskinin = new Task("Mizerstvane", 40);
		Task zashtoIzobshto = new Task("Misli shto raboti tuka izobshto", 80);

		work.addTask(mail);
		work.addTask(junk);
		work.addTask(ailqk);
		work.addTask(lunch);
		work.addTask(betray);
		work.addTask(bathroom);
		work.addTask(runaway);
		work.addTask(shani);
		work.addTask(miskinin);
		work.addTask(zashtoIzobshto);
		
		int day = 0;

		System.out.println(work.getNextTask().getName());
		System.out.println(work.getNextTask().getName());
		System.out.println(work.getNextTask().getName());
		while(true){
			day++;
			System.out.println("Day " + day);
			System.out.println("==========");
			pesho.startWorkingDay();
			mara.startWorkingDay();
			freeman.startWorkingDay();
			
			pesho.work();
			mara.work();
			freeman.work();
			
			System.out.println("==========");
			System.out.println("Day " + day + " has ended!");
			System.out.println("Current status of the employees: ");
			System.out.println();
			pesho.showReport();
			System.out.println();
			mara.showReport();
			System.out.println();
			freeman.showReport();
			if(work.isAllWorkDone()) break;
		}
	}
}
