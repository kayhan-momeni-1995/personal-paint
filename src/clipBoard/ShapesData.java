package clipBoard;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import shapes.Shape;

class ShapesData implements Comparable<ShapesData>
{
	int type=-1;
	int radius=0;
	int priority=0;
	int N=0;
	int L=0;
	int width=0;
	int height=0;
	int rotatedSoFar=0;
	ArrayList<Point> corners = new ArrayList<Point>();
	Point center=null;
	Color borderColor=null;
	Color fillColor=null;
	String name="";
	
	private static ArrayList<Shape> group = new ArrayList<Shape>();
	private static ArrayList<ShapesData> collection = new ArrayList<ShapesData>();
	
	static void clear()
	{
		collection.clear();
		group.clear();
	}
	static ArrayList<ShapesData> getList()
	{
		return collection;
	}
	static void addToCollection(ShapesData data)
	{
		collection.add(data);
	}
	
	public int compareTo(ShapesData sd)
	{
		if (sd.priority > this.priority)
			return 1;
		else if (sd.priority < this.priority)
			return -1;
		else
			return 0;
	}
	public static ArrayList<Shape> getGroup()
	{
		return group;
	}
}
