package productionManagement;

import crm.Order;

public abstract class Machine {
	protected String name;
	protected EMachineState state;

	public Machine(String name) {
		this.name = name;
		state = EMachineState.READY;
	}

	public abstract void execute(ProcessStep ps, Order order);

	public EMachineState getState() {
		return state;
	}

	public String getName() {
		return name;
	}

}
