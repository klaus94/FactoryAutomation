package productionManagement;

public class RobotArm {
	
	protected String name;
	ERobotState state;
	
	public RobotArm(String name) {
		this.name = name;
		state = ERobotState.READY;
	}
	
	public ERobotState getState() {
		return state;
	}	

}
