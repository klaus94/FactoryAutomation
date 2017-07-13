package tud.st.cbse.aspects;

import tud.st.cbse.task4.building.*;

public aspect ProhibitDirtyBathAspect
{
	before(Bathroom br): call(public void Room.enter(*)) && this(br)
    {
		if (!br.isClean())
			throw new IllegalStateException("Bath is not clean!");
	}
}
