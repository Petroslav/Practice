package Company;

public class AllWork {

	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;
	
	public AllWork(){
		this.tasks = new Task[10];
		this.freePlacesForTasks = 10;
		this.currentUnassignedTask = 0;
	}
	
	public void addTask(Task task){
		if(this.freePlacesForTasks == 0){
			System.out.println("We're overrun with tasks! We can't handle any more!");
		}else{
			for (int i = 0; i < tasks.length; i++) {
				if(tasks[i] == null){
					tasks[i] = task;
					this.freePlacesForTasks--;
					break;
				}
			}
		}
	}
	
	public Task getNextTask(){
		Task ph = null;
		if(this.currentUnassignedTask < 10){
			if(this.currentUnassignedTask >= 10) return ph;
			ph = this.tasks[this.currentUnassignedTask];
			this.currentUnassignedTask++;
		}
		
		return ph;
	}
	
	public boolean isAllWorkDone(){
		boolean done = false;
		for (int i = 0; i < tasks.length; i++) {
			if(tasks[i].getWorkingHours() == 0) done = true;
			else done = false;
		}
		return done;
	}
	
}
