package tud.st.cbse.aspects;

import tud.st.cbse.task4.main.*;

// task 3a
public aspect LoggingAspect
{
	pointcut startRunning() : call(public void ExampleStarter.run());
	before() : startRunning(){
		System.out.println("Start running... (3a)");
	}

	pointcut stopRunning() : call(public void ExampleStarter.run());
	after() : stopRunning(){
		System.out.println("Stop running... (3a)");
	}

}
