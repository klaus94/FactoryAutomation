package productionmanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crm.Order;
import productionManagement.EMachineState;
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


//	public Product ProduceProduct_old(Order order)
//	{
//		// idea: start new thread for handling this order -> new orders can be handled
//
//		Process process = order2Process(order);
//
//		Machine lastMachine = null;
//		for (ProcessStep ps: process.getProcessSteps())
//		{
//			takeProduct(lastMachine);
//			transport(ps.getMachine().getName());
//			putProduct(ps.getMachine());
//			ps.execute();
//
//			lastMachine = ps.getMachine();
//		}
//
//		return new Product(order.getId(), order.getTitle());
//	}


	@Override
	public Product ProduceProduct(Order order)
	{
		Thread t = new Thread()
		{
		    public void run()
		    {
		    	Process process = order2Process(order);

				Machine lastMachine = null;
				for (ProcessStep ps: process.getProcessSteps())
				{
					takeProduct(lastMachine, order);
					transport(ps.getMachine().getName(), order);
					putProduct(ps.getMachine(), order);
					ps.execute(order);


					lastMachine = ps.getMachine();
				}
		    }
		};

		t.start();


		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Product(order.getId(), order.getTitle());
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

	private void transport(String target, Order order)
	{
		boolean foundFreeRobot = false;

		while(!foundFreeRobot)
		{
			for (MobileRobot rob: mobileRobots)
			{
				if (rob.getState() == ERobotState.READY)
				{
					rob.transportTo(target, order);

					foundFreeRobot = true;
					break;
				}
			}

			if (foundFreeRobot)
				break;

			// wait 1s

			try {
				System.out.println(new Date().toString() + " : " + "manager is waiting for free robot..." + " (" + order + ")");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void takeProduct(Machine machine, Order order)
	{
		if (machine != null)
		{
			boolean foundFreeRobot = false;
			RobotArm arm = robotArms.get(machine.getName());
			if (arm == null)
				return;

			while(!foundFreeRobot)
			{
				if (machine.getState() == EMachineState.READY && arm.getState() == ERobotState.READY)
				{
					arm.takeProduct(order);

					foundFreeRobot = true;
					break;
				}

				if (foundFreeRobot)
					break;

				// wait 1s
				try {
					System.out.println(new Date().toString() + " : " + machine + " is waiting..." + " (" + order + ")");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	private void putProduct(Machine machine, Order order)
	{
		if (machine != null)
		{
			boolean foundFreeRobot = false;
			RobotArm arm = robotArms.get(machine.getName());
			if (arm == null)
				return;

			while(!foundFreeRobot)
			{

				if (machine.getState() == EMachineState.READY && arm.getState() == ERobotState.READY)
				{
					arm.putProduct(order);

					foundFreeRobot = true;
					break;
				}

				if (foundFreeRobot)
					break;

				// wait 1s
				try {
					System.out.println(new Date().toString() + " : " + machine + " is waiting..." + " (" + order + ")");
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}


}
