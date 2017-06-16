package productionManagement;

import java.util.Date;

import crm.Order;

public class MobileRobot {

	protected String name;
	ERobotState state;

	public MobileRobot(String name) {
		this.name = name;
		state = ERobotState.READY;
	}

	public void transportTo(String machine, Order order)
	{
//		if (state != ERobotState.READY) {
//			throw new IllegalStateException(name + " not in state READY.");
//		}

		state = ERobotState.TRANSPORTING;

//		System.out.println(new Date().toString() + " : " + name + " : starting transport to " + machine + " (" + order + ")");
		try {
			System.out.println(new Date().toString() + " : " + name + " : starting transport to " + machine + " (" + order + ")");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			state = ERobotState.ERROR;
			return;
		}
//		System.out.println(new Date().toString() + " : " + name + " : finished transport to " + machine + " (" + order + ")");

		state = ERobotState.READY;
	}

	public ERobotState getState() {
		return state;
	}

}
