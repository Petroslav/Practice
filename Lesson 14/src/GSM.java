
public class GSM {

	String model;
	boolean hasSimCard = false;
	String simMobileNumber;
	double outgoingCallsDuration = 0;
	Call lastIncomingCall = new Call();
	Call lastOutgoingCall = new Call();
	
	void insertSimCard(String simNum){
		if(simNum.charAt(0) == '0' && simNum.charAt(1) == '8' && simNum.length() == 10){
			simMobileNumber = simNum;
			hasSimCard = true;
		}else{
			System.out.println("Invalid mobile number");
		}
	}
	
	void call(GSM receiver, double duration){
		if(duration > 0 && !(this.simMobileNumber.contains(receiver.simMobileNumber)) && receiver.hasSimCard && this.hasSimCard){
			receiver.lastIncomingCall.duration = duration;
			receiver.lastIncomingCall.caller = this.simMobileNumber;
			receiver.lastIncomingCall.receiver = receiver.simMobileNumber;
			this.outgoingCallsDuration+= duration;
			this.lastOutgoingCall.duration = duration;
			this.lastOutgoingCall.caller = this.simMobileNumber;
			this.lastOutgoingCall.receiver = receiver.simMobileNumber;
			
		}else{
			System.out.println("Incorrect call");
		}
	}
	
	void getSumForCall(){
		System.out.println("The last call you made cost: "+this.outgoingCallsDuration*this.lastIncomingCall.pPM);
	}
	
	void printInfoForTheLastOutgoingCall(){
		System.out.println("Duration of the call: "+this.lastOutgoingCall.duration);
		System.out.println("Number called: "+this.lastOutgoingCall.receiver);
	}
	void printInfoForTheLastIncomingCall(){
		System.out.println("Duration of the call: "+this.lastIncomingCall.duration);
		System.out.println("Number called: "+this.lastIncomingCall.caller);
	}
}
