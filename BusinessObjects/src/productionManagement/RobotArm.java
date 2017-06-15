package productionManagement;

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

	public void takeProduct()
	{
		System.out.println(name + ": taking product");

		state = ERobotState.TRANSPORTING;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		state = ERobotState.READY;

		System.out.println(name + ": finished taking product");
	}

	public void putProduct()
	{
		System.out.println(name + ": putting product");

		state = ERobotState.TRANSPORTING;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		state = ERobotState.READY;

		System.out.println(name + ": finished putting product");

	}

}
