package productionManagement;

public class FinishingMachine extends Machine {

	public FinishingMachine(String name) {
		super(name);
	}

	@Override
	public void execute(ProcessStep ps) {
		if (state != EMachineState.READY) {
			throw new IllegalStateException(name + " not in state READY.");
		}
		
		state = EMachineState.EXECUTING;
		
		System.out.println(name + " : starting " + ps.toString());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			state = EMachineState.ERROR;
			return;
		}
		System.out.println(name + " : finished " + ps.toString());
		
		state = EMachineState.READY;		
	}
	
}
