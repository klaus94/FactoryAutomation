package productionManagement;

import crm.Order;

public class ProcessStep {
	private Machine machine;

	public ProcessStep(Machine machine)
	{
		this.machine = machine;
	}

	public void execute(Order order)
	{
		machine.execute(this, order);
	}

	public Machine getMachine()
	{
		return machine;
	}

	@Override
	public String toString()
	{
		return "Process: \"do sth. with machine: " + machine.getName() + "\"";
	}
}
