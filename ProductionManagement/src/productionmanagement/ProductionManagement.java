package productionmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crm.Order;
import productionManagement.ERobotState;
import productionManagement.FinishingMachine;
import productionManagement.IProductionManagement;
import productionManagement.Machine;
import productionManagement.MobileRobot;
import productionManagement.PrintingMachine;
import productionManagement.ProcessStep;
import productionManagement.RobotArm;
import productionManagement.Process;
import stockManagement.Product;

public class ProductionManagement implements IProductionManagement{

	private List<MobileRobot> mobileRobots;
	private List<Machine> machines;
	private Map<String, RobotArm> robotArms;

	public ProductionManagement()
	{
		mobileRobots = new ArrayList<MobileRobot>();
		machines = new ArrayList<Machine>();
		robotArms = new HashMap<String, RobotArm>();


		// Test-Data:

		// set mobile robots
		mobileRobots.add(new MobileRobot("mobileRob1"));
		mobileRobots.add(new MobileRobot("mobileRob2"));

		// set machines
		machines.add(new PrintingMachine("printer1"));
		machines.add(new FinishingMachine("finish1"));


		// set robot arms for each machine
		int index = 1;
		for (Machine machine: machines)
		{
			robotArms.put(machine.getName(), new RobotArm("robotarm" + index));
			index += 1;
		}
	}

	@Override
	public Product ProduceProduct(Order order)
	{
		// idea: start new thread for handling this order -> new orders can be handled

		Process process = order2Process(order);

		Machine lastMachine = null;
		for (ProcessStep ps: process.getProcessSteps())
		{
			takeProduct(lastMachine);
			transport(ps.getMachine().getName());
			putProduct(ps.getMachine());
			ps.execute();


			lastMachine = ps.getMachine();
		}

		return new Product(order.getId(), "name=" + order.getTitle());
	}

	@Override
	public String getTest()
	{
		return "test";
	}

	private Process order2Process(Order order)
	{
		ProcessStep ps1 = new ProcessStep(machines.get(0));
		ProcessStep ps2 = new ProcessStep(machines.get(1));
		List<ProcessStep> psList = new ArrayList<>();
		psList.add(ps1);
		psList.add(ps2);
		Process process = new Process(psList);

		return process;
	}

	private void transport(String target)
	{
		boolean foundFreeRobot = false;

		while(!foundFreeRobot)
		{
			for (MobileRobot rob: mobileRobots)
			{
				if (rob.getState() == ERobotState.READY)
				{
					rob.transportTo(target);

					foundFreeRobot = true;
					break;
				}
			}

			// wait 1s
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void takeProduct(Machine machine)
	{
		if (machine != null)
		{
			RobotArm currentArm = robotArms.get(machine.getName());
			if (currentArm != null)
			{
				currentArm.takeProduct();
			}
		}

	}

	private void putProduct(Machine machine)
	{
		if (machine != null)
		{
			RobotArm currentArm = robotArms.get(machine.getName());
			if (currentArm != null)
			{
				currentArm.putProduct();
			}
		}

	}

}
