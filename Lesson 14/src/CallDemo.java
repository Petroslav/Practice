
public class CallDemo {

	public static void main(String[] args) {
		GSM iPhone = new GSM();
		GSM huawei = new GSM();
		
		iPhone.insertSimCard("0889997676");
		huawei.insertSimCard("0886839133");
		
		iPhone.call(huawei, 5.32);
		iPhone.getSumForCall();
		
		huawei.printInfoForTheLastIncomingCall();
		
		
	}
}
