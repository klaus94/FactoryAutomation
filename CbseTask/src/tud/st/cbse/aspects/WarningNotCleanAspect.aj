package tud.st.cbse.aspects;

import tud.st.cbse.task4.building.*;

// task 3d)
public aspect WarningNotCleanAspect
{
	before(Room r): call(public void Room.enter(*)) && this(r)
    {
		if (!r.isClean())
			System.out.println("Attention, room is not clean!");
	}
}
