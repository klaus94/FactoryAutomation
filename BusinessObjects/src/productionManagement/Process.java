package productionManagement;

import java.util.List;

public class Process {
	private List<ProcessStep> processSteps;

	public Process(){}

	public Process(List<ProcessStep> processSteps)
	{
		this.processSteps = processSteps;
	}

	public List<ProcessStep> getProcessSteps()
	{
		return processSteps;
	}
}
