package shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends Shape
{

	private static final long serialVersionUID = -6099023506002175279L;
	private Point corner1, corner2, corner3;
	private int minX, maxX, minY, maxY;
	private int[] xOfCorners = new int[3];
	private int[] yOfCorners = new int[3];
	private int rotatedSoFar=0;

	public Triangle(String name, int X1, int Y1, int X2, int Y2, int X3, int Y3, Color borderColor, Color fillColor)
	{
		super(name, new Point(), borderColor, fillColor);
		this.center.setLocation((X1+X2+X3)/3, (Y1+Y2+Y3)/3);
		corner1= new Point();
		corner2= new Point();
		corner3= new Point();
		corner1.setLocation(X1, Y1);
		corner2.setLocation(X2, Y2);
		corner3.setLocation(X3, Y3);
		updateMinAndMax();
	}
	public Triangle(String name, int X1, int Y1, int X2, int Y2, int X3, int Y3, Color borderColor, Color fillColor, int priority)
	{
		super(name, new Point(), borderColor, fillColor, priority);
		this.center.setLocation((X1+X2+X3)/3, (Y1+Y2+Y3)/3);
		corner1= new Point();
		corner2= new Point();
		corner3= new Point();
		corner1.setLocation(X1, Y1);
		corner2.setLocation(X2, Y2);
		corner3.setLocation(X3, Y3);
		updateMinAndMax();
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
		corner3.setLocation(curX+difX, curY+difY);
		
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
		double S, s1, s2, s3, s;
		S=Triangle.Area(corner1, corner2, corner3);
		s1=Triangle.Area(p, corner1, corner2);
		s2=Triangle.Area(p, corner2, corner3);
		s3=Triangle.Area(p, corner3, corner1);
		s=s1+s2+s3;
		if (s>S+1)
			return false;
		else
			return true;
	}

	@Override
	public double getArea()
	{
		return Triangle.Area(corner1, corner2, corner3);
	}

	@Override
	public void rotate(double degree)
	{
		rotator (-rotatedSoFar);
		rotatedSoFar+=degree;
		rotatedSoFar%=360;
		rotator (rotatedSoFar);
	}
	private void rotator(double degree)
	{
		double rad = -((Math.PI)*(degree)/180), x, y, newX, newY;

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
		
		updateMinAndMax();
	}

	@Override
	public int getType()
	{
		return 4;
	}

	@Override
	public void Render(Graphics G)
	{
		G.setColor(getFillColor());
		G.fillPolygon(xOfCorners, yOfCorners, 3);
		
		G.setColor(getBorderColor());
		G.drawPolygon(xOfCorners, yOfCorners, 3);
	}
	
	public static double Area(Point A, Point B, Point C)
	{
		double a=Point.distance(A.getX(), A.getY(), B.getX(), B.getY());
		double b=Point.distance(A.getX(), A.getY(), C.getX(), C.getY());
		double c=Point.distance(C.getX(), C.getY(), B.getX(), B.getY());
		double p = (a+b+c)/2;
		double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return area;
	}
	
	private void updateMinAndMax()
	{
		minX=(int)Math.min(corner1.getX(), corner2.getX());
		minX=(int)Math.min(minX, corner3.getX());
		
		maxX=(int)Math.max(corner1.getX(), corner2.getX());
		maxX=(int)Math.max(maxX, corner3.getX());
		
		minY=(int)Math.min(corner1.getY(), corner2.getY());
		minY=(int)Math.min(minY, corner3.getY());
		
		maxY=(int)Math.max(corner1.getY(), corner2.getY());
		maxY=(int)Math.max(maxY, corner3.getY());
		
		xOfCorners[0]=(int) corner1.getX();
		xOfCorners[1]=(int) corner2.getX();
		xOfCorners[2]=(int) corner3.getX();
		
		yOfCorners[0]=(int) corner1.getY();
		yOfCorners[1]=(int) corner2.getY();
		yOfCorners[2]=(int) corner3.getY();
	}
	
	@Override
	public void scale(double scale)
	{
		if (scale <= 0)
			return;
		
		if (scale*Point.distance(corner1.getX(), corner1.getY(), corner2.getX(), corner2.getY()) < 50 ||
			scale*Point.distance(corner1.getX(), corner1.getY(), corner3.getX(), corner3.getY()) < 50 ||
			scale*Point.distance(corner3.getX(), corner3.getY(), corner2.getX(), corner2.getY()) < 50)
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
		
		updateMinAndMax();
	}
}
