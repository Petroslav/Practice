package Company;

public class JobDemo {

	public static void main(String[] args) {
		
		Employee pesho = new Employee("Pesho");
		Task hlqb = new Task("Hlqb", 2);
		pesho.setCurrentTask(hlqb);
		pesho.showReport();
		System.out.println("======= after working on the task =====");
		pesho.work();
		pesho.showReport();
	}
}
