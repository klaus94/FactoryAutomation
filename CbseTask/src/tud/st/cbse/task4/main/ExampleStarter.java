package tud.st.cbse.task4.main;

import Test.Test;
import tud.st.cbse.task4.building.*;
import tud.st.cbse.task4.stakeholder.Person;

public class ExampleStarter {

	private House house;
	private Person owner = new Person("John Doe");
	private Person otherPerson = new Person("Jane Doe");

	public static void main(String[] args){
		ExampleStarter starter = new ExampleStarter();
		starter.run();
	}

	public void run(){
		House h1 = buildSimpleHouse();
		h1.printStructure();
		h1.visit(owner);
		h1.visit(otherPerson);
	}

	private House buildSimpleHouse(){
		House house = new House("Street 1", owner);
		Level l0 = new Level(0);
		Level l1 = new Level(1);

		Room livingRoom = new Room("living room");
		Room sleepingRoom = new Room("sleeping room");
		Room privateRoom = new Room("private room");
		Room bathRoom = new Bathroom();

		Hallway hallway = new Hallway();
		hallway.addPart(sleepingRoom);
		hallway.addPart(bathRoom);
		hallway.addPart(privateRoom);

		l1.addPart(hallway);
		l0.addPart(livingRoom);

		// test 3b)
		l1.addPart(l0);

		house.addPart(l0);
		house.addPart(l1);

		return house;
	}

}
