package clipBoard;

import java.awt.Color;
import java.awt.Point;
import java.util.Collections;
import java.util.Iterator;

import group.Group;
import shapes.*;

public class Copy
{
	public static void setShapeToClipboard(Shape inputShape)
	{
		ShapesData.clear();
		ShapesData newData = new ShapesData();
		newData.type=inputShape.getType();
		//////////////////////////Point/////////////////////////////
		if (newData.type==0)
		{
			Dot dot = (Dot)inputShape;
			newData.name  = dot.getName();
			newData.center=new Point(dot.getCenter());
			newData.borderColor=new Color(dot.getBorderColor().getRGB());
			newData.priority=dot.getPriority();
		}
		
		//////////////////////////Line//////////////////////////////
		else if (newData.type==1)
		{
			Line line = (Line)inputShape;
			newData.name = line.getName();
			newData.center = new Point(line.getCenter());
			newData.borderColor = new Color(line.getBorderColor().getRGB());
			newData.priority= line.getPriority();
			newData.corners.add(line.getStart());
			newData.corners.add(line.getEnd());
		}
		
		//////////////////////////Circle//////////////////////////////
		else if (newData.type==2)
		{
			Circle circle = (Circle)inputShape;
			newData.name=circle.getName();
			newData.center= new Point(circle.getCenter());
			newData.borderColor = new Color (circle.getBorderColor().getRGB());
			newData.fillColor = new Color (circle.getFillColor().getRGB());
			newData.priority=circle.getPriority();
			newData.radius=circle.getRadius();
		}
		
		/////////////////////////Rectangle/////////////////////////////
		else if (newData.type==3)
		{
			Rectangle rect = (Rectangle)inputShape;
			newData.name = rect.getName();
			newData.center= rect.getCenter();
			newData.borderColor= new Color(rect.getBorderColor().getRGB());
			newData.fillColor = new Color (rect.getFillColor().getRGB());
			newData.priority = rect.getPriority();
			newData.width=rect.getWidth();
			newData.height=rect.getHeight();
			newData.rotatedSoFar=rect.getRotatedSoFar();
		}
		
		/////////////////////////Triangle/////////////////////////////
		else if (newData.type==4)
		{
			Triangle tri = (Triangle)inputShape;
			newData.name=tri.getName();
			newData.center=tri.getCenter();
			newData.borderColor=tri.getBorderColor();
			newData.fillColor=tri.getFillColor();
			newData.priority=tri.getPriority();
			newData.corners.add(tri.getCorner1());
			newData.corners.add(tri.getCorner2());
			newData.corners.add(tri.getCorner3());
		}
		
		/////////////////////////Polygon/////////////////////////////
		else if (newData.type==5)
		{
			Polygon pol = (Polygon)inputShape;
			newData.name=pol.getName();
			newData.center=pol.getCenter();
			newData.borderColor=pol.getBorderColor();
			newData.fillColor=pol.getFillColor();
			newData.priority=pol.getPriority();
			newData.N=pol.getN();
			newData.L=pol.getL();
			newData.rotatedSoFar=pol.getRotatedSoFar();
		}
		
		ShapesData.addToCollection(newData);
	}
	
	public static void setGroupToClipboard(Group inputGroup)
	{
		ShapesData.clear();
		Iterator<Shape> it = inputGroup.getList().iterator();
		while (it.hasNext())
		{
			Shape inputShape = it.next();
			ShapesData newData = new ShapesData();
			newData.type=inputShape.getType();
			//////////////////////////Point/////////////////////////////
			if (newData.type==0)
			{
				Dot dot = (Dot)inputShape;
				newData.name  = dot.getName();
				newData.center=new Point(dot.getCenter());
				newData.borderColor=new Color(dot.getBorderColor().getRGB());
				newData.priority=dot.getPriority();
			}
			
			//////////////////////////Line//////////////////////////////
			else if (newData.type==1)
			{
				Line line = (Line)inputShape;
				newData.name = line.getName();
				newData.center = new Point(line.getCenter());
				newData.borderColor = new Color(line.getBorderColor().getRGB());
				newData.priority= line.getPriority();
				newData.corners.add(line.getStart());
				newData.corners.add(line.getEnd());
			}
			
			//////////////////////////Circle//////////////////////////////
			else if (newData.type==2)
			{
				Circle circle = (Circle)inputShape;
				newData.name=circle.getName();
				newData.center= new Point(circle.getCenter());
				newData.borderColor = new Color (circle.getBorderColor().getRGB());
				newData.fillColor = new Color (circle.getFillColor().getRGB());
				newData.priority=circle.getPriority();
				newData.radius=circle.getRadius();
			}
			
			/////////////////////////Rectangle/////////////////////////////
			else if (newData.type==3)
			{
				Rectangle rect = (Rectangle)inputShape;
				newData.name = rect.getName();
				newData.center= rect.getCenter();
				newData.borderColor= new Color(rect.getBorderColor().getRGB());
				newData.fillColor = new Color (rect.getFillColor().getRGB());
				newData.priority = rect.getPriority();
				newData.width=rect.getWidth();
				newData.height=rect.getHeight();
				newData.rotatedSoFar=rect.getRotatedSoFar();
			}
			
			/////////////////////////Triangle/////////////////////////////
			else if (newData.type==4)
			{
				Triangle tri = (Triangle)inputShape;
				newData.name=tri.getName();
				newData.center=tri.getCenter();
				newData.borderColor=tri.getBorderColor();
				newData.fillColor=tri.getFillColor();
				newData.priority=tri.getPriority();
				newData.corners.add(tri.getCorner1());
				newData.corners.add(tri.getCorner2());
				newData.corners.add(tri.getCorner3());
			}
			
			/////////////////////////Polygon/////////////////////////////
			else if (newData.type==5)
			{
				Polygon pol = (Polygon)inputShape;
				newData.name=pol.getName();
				newData.center=pol.getCenter();
				newData.borderColor=pol.getBorderColor();
				newData.fillColor=pol.getFillColor();
				newData.priority=pol.getPriority();
				newData.N=pol.getN();
				newData.L=pol.getL();
				newData.rotatedSoFar=pol.getRotatedSoFar();
			}
			
			ShapesData.addToCollection(newData);
		}
		
		Collections.sort(ShapesData.getList());
	}
}
