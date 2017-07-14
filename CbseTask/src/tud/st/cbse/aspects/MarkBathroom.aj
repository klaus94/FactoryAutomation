package tud.st.cbse.aspects;

import tud.st.cbse.task4.building.*;

// task 3c
public aspect MarkBathroom
{

	// 1) define method-join point by parent (where method is defined)
	// 2) narrow pointcut to calls from Bathroom-objects with target(Bathroom)
	after(Bathroom br): call(public void Room.enter(*)) && target(Bathroom) && this(br)
    {
		System.out.println("mark bathroom not clean (3c)");
	    br.setClean(false);
	}

}
