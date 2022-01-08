package shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JOptionPane;

import group.Group;
import main.MainWindow;

public abstract class Shape implements Comparable<Shape>, Serializable
{

	private static final long serialVersionUID = 1919193875466046502L;
	protected Point center;
	private String name;
	private Color fillColor;
	private Color borderColor;
	private boolean isSelected;
	private boolean isBold;
	private int priority;
	private Group group;
	public static ArrayList<Shape> allShapes = new ArrayList<Shape>();
	
	public Shape(String name, Point center,Color borderColor, Color fillColor)
	{
		this.isSelected=false;
		group = new Group();
		group.getList().add(this);
		this.center=center;
		this.name=name;
		isBold=false;
		fillColor = new Color (fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue(), 200);
		this.fillColor=fillColor;
		this.borderColor=borderColor;
		this.priority=1;
		Shape.allShapes.add(this);
		int n = allShapes.size();
		if (n>1)
		{
			if (allShapes.get(n-2).priority == allShapes.get(n-1).priority)
				for (int i=n-2; allShapes.get(i).priority==allShapes.get(i+1).priority; i--)
				{
					allShapes.get(i).priority ++;
					if (i==0)
						break;
				}
		}
	}
	public Shape(String name, Point center,Color borderColor, Color fillColor, int priority)
	{
		boolean possibility=true;
		for (int i=0; i<allShapes.size(); i++)
		{
			if (allShapes.get(i).priority==priority)
			{
				possibility=false;
				break;
			}
		}
		if (possibility == false)
		{
			if (priority != 1)
				JOptionPane.showMessageDialog(MainWindow.mainPanel, "Priority "+priority+" is not available.\nShape "+name+" created with the default priority.", "Priority warning", JOptionPane.PLAIN_MESSAGE, main.GraphicsEngine.warningIcon);

			this.isSelected=false;
			group = new Group();
			group.getList().add(this);
			this.center=center;
			this.name=name;
			isBold=true;
			fillColor = new Color (fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue(), 200);
			this.fillColor=fillColor;
			this.borderColor=borderColor;
			this.priority=1;
			Shape.allShapes.add(this);
			int n = allShapes.size();
			if (n>1)
			{
				if (allShapes.get(n-2).priority == allShapes.get(n-1).priority)
					for (int i=n-2; allShapes.get(i).priority==allShapes.get(i+1).priority; i--)
					{
						allShapes.get(i).priority ++;
						if (i==0)
							break;
					}
			}		
		}
		else
		{
			this.isSelected=false;
			group = new Group();
			group.getList().add(this);
			this.center=center;
			this.name=name;
			isBold=true;
			fillColor = new Color (fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue(), 200);
			this.fillColor=fillColor;
			this.borderColor=borderColor;
			this.priority=priority;
			Shape.allShapes.add(this);
			Collections.sort(allShapes);
		}
	}

	public Shape(String name, Point center, Color borderColor)
	{
		this(name, center, borderColor, borderColor);
	}
	public Shape(String name, int X, int Y, Color borderColor)
	{
		this(name, new Point(), borderColor, borderColor);
		this.center.setLocation(X, Y);
	}
	public Shape(String name, int X, int Y, Color borderColor, Color fillColor)
	{
		this(name, new Point(), borderColor, fillColor);
		this.center.setLocation(X, Y);
	}
	
	
	public void setFillColor(Color fillColor)
	{
		if (isBold || isSelected)
			fillColor = new Color (fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue(), 250);
		else
			fillColor = new Color (fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue(), 200);
		
		this.fillColor=fillColor;
	}
	public Color getFillColor()
	{
		return fillColor;
	}
	
	public void setBorderColor(Color borderColor)
	{
		this.borderColor=borderColor;
	}
	public Color getBorderColor()
	{
		return borderColor;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	public Point getCenter()
	{
		return center;
	}
	public static void clearOfSelections()
	{
		Iterator<Shape> it = Shape.allShapes.iterator();
		while (it.hasNext())
			it.next().setSelected(false);
	}
	public boolean isSelected()
	{
		return isSelected;
	}
	public void setSelected (boolean selectionStatus)
	{
		this.isSelected = selectionStatus;
		this.setFillColor(fillColor);
	}
	public static void clearOfBolds()
	{
		Iterator<Shape> it = Shape.allShapes.iterator();
		while (it.hasNext())
			it.next().setBold(false);
	}
	public void setBold(boolean isBold)
	{
		this.isBold=isBold;
		this.setFillColor(fillColor);
	}

	public boolean isBold()
	{
		return isBold;
	}
	
	public void setPriority(int priority)
	{
		if (priority == this.priority)
			return;
		boolean possibility=true;
		for (int i=0; i<allShapes.size(); i++)
		{
			if (allShapes.get(i).priority==priority)
			{
				possibility=false;
				break;
			}
		}
		if (possibility == false)
		{
			if (priority != 1)
				JOptionPane.showMessageDialog(MainWindow.mainPanel, "Priority "+priority+" is not available for the shape "+name+".\nNew priority is now: 01", "Priority warning", JOptionPane.PLAIN_MESSAGE, main.GraphicsEngine.warningIcon);
			
			allShapes.remove(this);
			this.priority=1;
			for (int i=0; i<allShapes.size(); i++)
			{
				allShapes.get(i).priority++;
			}
			allShapes.add(this);
		}
		else
		{
			this.priority=priority;
			Collections.sort(allShapes);
		}
		
	}
	public int getPriority()
	{
		return priority;
	}
	
	public void setGroup(Group g)
	{
		Group prv = new Group();
		prv = this.getGroup();
		if (prv.getList().contains(this))
			prv.getList().remove(this);
		
		this.group = g;
		g.getList().add(this);
		
	}
	public Group getGroup()
	{
		return group;
	}
	
	public String toString()
	{
		return ("Shape: "+name+" | Location: ("+center.getX()+","+center.getY()+")");
	}
	public int compareTo(Shape shape)
	{
		if (this.priority>shape.getPriority())
			return -1;
		else if (this.priority==shape.priority)
			return 0;
		else
			return +1;
	}
	public void delete()
	{
		allShapes.remove(this);
	}
	public void moveCenter(double dx, double dy)
	{
		double newX=(this.getCenter().getX()+dx);
		double newY=(this.getCenter().getY()+dy);
		Point p = new Point();
		p.setLocation(newX,  newY);
		this.setCenter(p);
	}
	public void destroy()
	{
		Group prvGroup = new Group();
		prvGroup = this.getGroup();
		this.group=null;
		if (prvGroup.getList().contains(this))
			prvGroup.getList().remove(this);
		
		if (Shape.allShapes.contains(this))
			Shape.allShapes.remove(this);
	}
	
	public abstract void setCenter(Point center);
	public abstract void setCenter(int X, int Y);
	public abstract boolean isIn(Point p);
	public abstract double getArea();
	public abstract void rotate (double degree);
	public abstract void scale(double scale);
	public abstract int getType();
	public abstract void Render(Graphics G);
}
