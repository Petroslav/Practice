package future_and_callable_tests;

import java.util.concurrent.Callable;

public class Adder implements Callable<Integer> {
	
	private Integer op1;
	private Integer op2;
	
	public Adder(Integer op1, Integer op2){
		this.op1 = op1;
		this.op2 = op2;
	}

	@Override
	public Integer call() throws Exception {
		
		System.out.println("Partial sum for " + op1 + " and " + op2 + " is " + (op1 + op2));
		return op1 + op2;
	}

}
