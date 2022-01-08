package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape
{
	private static final long serialVersionUID = -1262170137381544243L;
	private int height, width, minX, maxX, minY, maxY;
	private Point corner1, corner2, corner3, corner4;
	private int[] xOfCorners = new int[4];
	private int[] yOfCorners = new int[4];
	private int rotatedSoFar=0;
	public Rectangle(String name, int X, int Y, int A, int B, Color borderColor, Color fillColor)
	{
		super(name, new Point(), borderColor, fillColor);
		this.center.setLocation(X, Y);
		this.height=A;
		this.width =B;
		corner1= new Point();
		corner2= new Point();
		corner3= new Point();
		corner4= new Point();
		corner1.setLocation(X-(height/2), Y+(width/2));
		corner2.setLocation(X-(height/2), Y-(width/2));
		corner3.setLocation(X+(height/2), Y-(width/2));
		corner4.setLocation(X+(height/2), Y+(width/2));
		updateMinAndMax();
	}
	public Rectangle(String name, int X, int Y, int A, int B, Color borderColor, Color fillColor, int priority)
	{
		super(name, new Point(), borderColor, fillColor, priority);
		this.center.setLocation(X, Y);
		this.height=A;
		this.width =B;
		corner1= new Point();
		corner2= new Point();
		corner3= new Point();
		corner4= new Point();
		corner1.setLocation(X-(height/2), Y+(width/2));
		corner2.setLocation(X-(height/2), Y-(width/2));
		corner3.setLocation(X+(height/2), Y-(width/2));
		corner4.setLocation(X+(height/2), Y+(width/2));
		updateMinAndMax();
	}
	public int getHeight()
	{
		return height;
	}
	public int getWidth()
	{
		return width;
	}
	public Point getCorner1()
	{
		return corner1;
	}
	public Point getCorner2()
	{
		return corner2;
	}
	public Point getCorner3()
	{
		return corner3;
	}
	public Point getCorner4()
	{
		return corner4;
	}
	public int getRotatedSoFar()
	{
		return rotatedSoFar;
	}
	
	@Override
	public void setCenter(Point center)
	{
		double difX, difY, curX, curY;
		
		curX=this.center.getX();
		curY=this.center.getY();
		difX=center.getX()-curX;
		difY=center.getY()-curY;
		this.center.setLocation(curX+difX, curY+difY);
		
		curX=corner1.getX();
		curY=corner1.getY();
		corner1.setLocation(curX+difX, curY+difY);
		
		curX=corner2.getX();
		curY=corner2.getY();
		corner2.setLocation(curX+difX, curY+difY);
		
		curX=corner3.getX();
		curY=corner3.getY();
		corner3.setLocation(curX+difX,  curY+difY);
		
		curX=corner4.getX();
		curY=corner4.getY();
		corner4.setLocation(curX+difX,  curY+difY);
		
		updateMinAndMax();
	}

	@Override
	public void setCenter(int X, int Y)
	{
		Point newCenter = new Point();
		newCenter.setLocation(X, Y);
		setCenter(newCenter);
	}
	
	@Override
	public boolean isIn(Point p)
	{
		double X=p.getX();
		double Y=p.getY();
		if (
		   (Line.status(corner1, corner2, X, Y)+
			Line.status(corner2, corner3, X, Y)+
			Line.status(corner3, corner4, X, Y)+
			Line.status(corner4, corner1, X, Y))
			== 0 && X<=maxX && X>=minX && Y<=maxY && Y>=minY)
			return true;
		else
			return false;
	}

	@Override
	public double getArea()
	{
		return height*width;
	}

	@Override
	public void rotate (double degree)
	{
		rotator (-rotatedSoFar);
		rotatedSoFar+=degree;
		rotatedSoFar%=360;
		rotator (rotatedSoFar);
	}
	
	private void rotator(double degree)
	{
		double rad = -((Math.PI)*(degree)/180), x, y, newX, newY;
		double dl=2;
		
		x = this.corner1.getX() - this.getCenter().getX();
		y = this.corner1.getY() - this.getCenter().getY();
		newX = x*Math.cos(rad) - y*Math.sin(rad);
		newY = x*Math.sin(rad) + y*Math.cos(rad);
		newX += this.getCenter().getX();
		newY += this.getCenter().getY();
		this.corner1.setLocation(newX, newY);
		
		x = this.corner2.getX() - this.getCenter().getX();
		y = this.corner2.getY() - this.getCenter().getY();
		newX = x*Math.cos(rad) - y*Math.sin(rad);
		newY = x*Math.sin(rad) + y*Math.cos(rad);
		newX += this.getCenter().getX();
		newY += this.getCenter().getY();
		this.corner2.setLocation(newX, newY);
		
		x = this.corner3.getX() - this.getCenter().getX();
		y = this.corner3.getY() - this.getCenter().getY();
		newX = x*Math.cos(rad) - y*Math.sin(rad);
		newY = x*Math.sin(rad) + y*Math.cos(rad);
		newX += this.getCenter().getX();
		newY += this.getCenter().getY();
		this.corner3.setLocation(newX, newY);
		
		x = this.corner4.getX() - this.getCenter().getX();
		y = this.corner4.getY() - this.getCenter().getY();
		newX = x*Math.cos(rad) - y*Math.sin(rad);
		newY = x*Math.sin(rad) + y*Math.cos(rad);
		newX += this.getCenter().getX();
		newY += this.getCenter().getY();
		this.corner4.setLocation(newX, newY);
		
		if (Math.abs(corner1.getX()-corner2.getX()) <= dl)
			corner1.setLocation(corner2.getX(), corner1.getY());
		if (Math.abs(corner1.getY()-corner2.getY()) <= dl)
			corner1.setLocation(corner1.getX(), corner2.getY());
		
		if (Math.abs(corner1.getX()-corner4.getX()) <= dl)
			corner1.setLocation(corner4.getX(), corner1.getY());
		if (Math.abs(corner1.getY()-corner4.getY()) <= dl)
			corner1.setLocation(corner1.getX(), corner4.getY());
		
		if (Math.abs(corner3.getX()-corner4.getX()) <= dl)
			corner3.setLocation(corner4.getX(), corner3.getY());
		if (Math.abs(corner3.getY()-corner4.getY()) <= dl)
			corner3.setLocation(corner3.getX(), corner4.getY());
		
		if (Math.abs(corner3.getX()-corner2.getX()) <= dl)
			corner3.setLocation(corner2.getX(), corner3.getY());
		if (Math.abs(corner3.getY()-corner2.getY()) <= dl)
			corner3.setLocation(corner3.getX(), corner2.getY());
		
		updateMinAndMax();
	}

	@Override
	public int getType()
	{
		return 3;
	}

	@Override
	public void Render(Graphics G)
	{
		G.setColor(getFillColor());
		G.fillPolygon(xOfCorners, yOfCorners, 4);
		
		G.setColor(getBorderColor());
		G.drawPolygon(xOfCorners, yOfCorners, 4);
	}
	private void updateMinAndMax()
	{
		minX=(int)Math.min(corner1.getX(), corner2.getX());
		minX=(int)Math.min(minX, corner3.getX());
		minX=(int)Math.min(minX, corner4.getX());
		
		maxX=(int)Math.max(corner1.getX(), corner2.getX());
		maxX=(int)Math.max(maxX, corner3.getX());
		maxX=(int)Math.max(maxX, corner4.getX());
		
		minY=(int)Math.min(corner1.getY(), corner2.getY());
		minY=(int)Math.min(minY, corner3.getY());
		minY=(int)Math.min(minY, corner4.getY());
		
		maxY=(int)Math.max(corner1.getY(), corner2.getY());
		maxY=(int)Math.max(maxY, corner3.getY());
		maxY=(int)Math.max(maxY, corner4.getY());
		
		xOfCorners[0]=(int) corner1.getX();
		xOfCorners[1]=(int) corner2.getX();
		xOfCorners[2]=(int) corner3.getX();
		xOfCorners[3]=(int) corner4.getX();
		
		yOfCorners[0]=(int) corner1.getY();
		yOfCorners[1]=(int) corner2.getY();
		yOfCorners[2]=(int) corner3.getY();
		yOfCorners[3]=(int) corner4.getY();
		
		height=(int) Point.distance(corner3.getX(), corner3.getY(), corner2.getX(), corner2.getY());
		width =(int) Point.distance(corner1.getX(), corner1.getY(), corner2.getX(), corner2.getY());
	}
	@Override
	public void scale(double scale)
	{
		if (scale <= 0)
			return;
		if (height*scale <50 || width*scale < 50)
			return;
		
		double distX, distY;
		
		distX=this.corner1.getX()-this.center.getX();
		distY=this.corner1.getY()-this.center.getY();
		distX*=scale;
		distY*=scale;
		this.corner1.setLocation(this.center.getX()+distX, this.center.getY()+distY);
		
		distX=this.corner2.getX()-this.center.getX();
		distY=this.corner2.getY()-this.center.getY();
		distX*=scale;
		distY*=scale;
		this.corner2.setLocation(this.center.getX()+distX, this.center.getY()+distY);
		
		distX=this.corner3.getX()-this.center.getX();
		distY=this.corner3.getY()-this.center.getY();
		distX*=scale;
		distY*=scale;
		this.corner3.setLocation(this.center.getX()+distX, this.center.getY()+distY);
		
		distX=this.corner4.getX()-this.center.getX();
		distY=this.corner4.getY()-this.center.getY();
		distX*=scale;
		distY*=scale;
		this.corner4.setLocation(this.center.getX()+distX, this.center.getY()+distY);
		
		updateMinAndMax();
	}	
}
