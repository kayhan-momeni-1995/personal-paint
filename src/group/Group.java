package group;
import java.io.Serializable;
import java.util.ArrayList;

import shapes.Shape;

public class Group implements Serializable
{
	private static final long serialVersionUID = 3792401513431224275L;
	private ArrayList<Shape> groupedShapes = new ArrayList<Shape>();
	private String name = "";
	public static ArrayList<Group> allGroups = new ArrayList<Group>();
	
	public Group() 
	{
		allGroups.add(this);
	}
	
	public ArrayList<Shape> getList()
	{
		return groupedShapes;
	}
	public int getSize()
	{
		return groupedShapes.size();
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public static void updateList()
	{
		for (int i=0;;)
		{
			if (i<allGroups.size())
			{
				if (allGroups.get(i).getList().size()==0)
					allGroups.remove(i);
				else
					i++;
			}
			else
				break;
		}
	}
}