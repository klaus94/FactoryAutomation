package tud.st.cbse.aspects;

import tud.st.cbse.task4.building.*;
import tud.st.cbse.task4.stakeholder.Person;

public aspect PrivateRoomAspect
{
	// task 3f)
	after(Room r, Person p): call(public void Room.enter(Person)) && this(r) && args(p)
    {
		if (r.getRoomName().equals("private room"))
		{
			House house = findHouse(r);
			if (house == null || house.getOwner() != p)
			{
				System.out.println("entering the private room is prohibited! (3f)");
			}
		}
	}

	private House findHouse(Room r)
	{
		if (r == null)
			throw new NullPointerException("room is null");

		HousePart currentHousePart = r;
		boolean searching = true;
		House result = null;
		while (searching)
		{
			HousePart parentPart = currentHousePart.getSuperPart();

			if (parentPart == null)
				break;

			if (parentPart instanceof House)
			{
				result = (House)parentPart;
				searching = false;
			}
			else
			{
				currentHousePart = parentPart;
			}
		}

		return result;
	}
}
