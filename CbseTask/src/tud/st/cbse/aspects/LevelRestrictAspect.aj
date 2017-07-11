package tud.st.cbse.aspects;

import tud.st.cbse.task4.building.HousePart;
import tud.st.cbse.task4.building.Level;

// 3b
public aspect LevelRestrictAspect
{
	pointcut restrictLevel(HousePart hp) : call(public void Level.addPart(*)) && args(hp);
	void around(HousePart hp) : restrictLevel(hp)
	{
		if (hp instanceof Level)
		{
			System.out.println("Error - Level can not have member of type Level");
			return;
		}
		else
		{
			proceed(hp);
		}
	}

}
