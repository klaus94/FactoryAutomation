package productionManagement;

import java.util.Date;

import crm.Order;

public class FinishingMachine extends Machine {

	public FinishingMachine(String name) {
		super(name);
	}

	@Override
	public void execute(ProcessStep ps, Order order)
	{
		if (state != EMachineState.READY) {
			throw new IllegalStateException(name + " not in state READY.");
		}

		state = EMachineState.EXECUTING;

//		System.out.println(new Date().toString() + " : " + name + " : starting " + ps.toString() + " (" + order + ")");
		try {
			System.out.println(new Date().toString() + " : " + name + " : starting " + ps.toString() + " (" + order + ")");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			state = EMachineState.ERROR;
			return;
		}
//		System.out.println(new Date().toString() + " : " + name + " : finished " + ps.toString() + " (" + order + ")");

		state = EMachineState.READY;
	}

}
