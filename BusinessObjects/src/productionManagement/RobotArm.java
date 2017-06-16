package productionManagement;

import java.util.Date;

import crm.Order;

public class RobotArm{

	protected String name;
	ERobotState state;

	public RobotArm(String name) {
		this.name = name;
		state = ERobotState.READY;
	}

	public ERobotState getState() {
		return state;
	}

	public void takeProduct(Order order)
	{
//		System.out.println(new Date().toString() + " : " + name + ": taking product from order: " + order);

		state = ERobotState.TRANSPORTING;
		try {
			System.out.println(new Date().toString() + " : " + name + ": taking product from order: " + order);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		state = ERobotState.READY;

//		System.out.println(new Date().toString() + " : " + name + ": finished taking product from order: " + order);
	}

	public void putProduct(Order order)
	{
//		System.out.println(new Date().toString() + " : " + name + ": putting product from order: " + order);

		state = ERobotState.TRANSPORTING;
		try {
			System.out.println(new Date().toString() + " : " + name + ": putting product from order: " + order);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		state = ERobotState.READY;

//		System.out.println(new Date().toString() + " : " + name + ": finished putting product from order: " + order);

	}

}
