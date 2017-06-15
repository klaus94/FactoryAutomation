package productionManagement;

public class ProcessStep {
	private Machine machine;

	public ProcessStep(Machine machine)
	{
		this.machine = machine;
	}

	public void execute()
	{
		machine.execute(this);
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
