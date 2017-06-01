package productionManagement;

public class MobileRobot {
	
	protected String name;
	ERobotState state;
	
	public MobileRobot(String name) {
		this.name = name;
		state = ERobotState.READY;
	}
	
	public void transportTo(String machine){
		if (state != ERobotState.READY) {
			throw new IllegalStateException(name + " not in state READY.");
		}
		
		state = ERobotState.TRANSPORTING;
		
		System.out.println(name + " : starting transport to " + machine);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			state = ERobotState.ERROR;
			return;
		}
		System.out.println(name + " : finished transport to " + machine);
		
		state = ERobotState.READY;	
	}
	
	public ERobotState getState() {
		return state;
	}	

}
