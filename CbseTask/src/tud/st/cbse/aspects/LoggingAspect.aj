package tud.st.cbse.aspects;

import tud.st.cbse.task4.main.*;

// 3a
public aspect LoggingAspect
{
	pointcut startRunning() : call(public void ExampleStarter.run());
	before() : startRunning(){
		System.out.println("Start running...");
	}

	pointcut stopRunning() : call(public void ExampleStarter.run());
	after() : stopRunning(){
		System.out.println("Stop running...");
	}

}
