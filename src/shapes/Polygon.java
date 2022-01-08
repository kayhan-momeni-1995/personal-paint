package shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class Polygon extends Shape
{

	private static final long serialVersionUID = 5480447087428390578L;
	private double teta, ang, r;
	private ArrayList<Point> corners = new ArrayList<Point>();
	private int n, l, minX, maxX, minY, maxY;
	private int[] xOfCorners = new int[100];
	private int[] yOfCorners = new int[100];
	private int rotatedSoFar=0;

	public Polygon(String name, int n, int X, int Y, int l, Color borderColor, Color fillColor)
	{
		super(name, new Point(), borderColor, fillColor);
		this.center.setLocation(X, Y);
		this.n=n;
		this.l=l;
		this.teta = ((n-2)*180)/n;
		ang = (Math.PI*teta)/180;
		this.r= (this.l)/Math.sqrt(2+2*Math.cos(ang));
		Point start = new Point();
		start.setLocation(this.center.getX()+r, this.center.getY());
		corners.add(new Point(start));
		double tmp=Math.PI-(ang/2);
		for (int i=2; i<=n; i++)
		{
			corners.add(new Point(nextPoint(corners.get(i-2), l, tmp)));
			tmp+=Math.PI-ang;
		}
		rotate (-teta/2);
		rotatedSoFar=0;
		updateMinAndMax();

	}

	public Polygon(String name, int n, int X, int Y, int l, Color borderColor, Color fillColor, int priority)
	{
		super(name, new Point(), borderColor, fillColor, priority);

		this.center.setLocation(X, Y);
		this.n=n;
		this.l=l;
		this.teta = ((n-2)*180)/n;
		ang = (Math.PI*teta)/180;
		this.r= (this.l)/Math.sqrt(2+2*Math.cos(ang));
		Point start = new Point();
		start.setLocation(this.center.getX()+r, this.center.getY());
		corners.add(new Point(start));
		double tmp=Math.PI-(ang/2);
		for (int i=2; i<=n; i++)
		{
			corners.add(new Point(nextPoint(corners.get(i-2), l, tmp)));
			tmp+=Math.PI-ang;
		}
		rotate (-teta/2);
		rotatedSoFar=0;
		updateMinAndMax();
	}
	public int getN()
	{
		return n;
	}
	public int getL()
	{
		return l;
	}
	public ArrayList<Point> getCorners()
	{
		return corners;
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
		
		Iterator<Point> it = corners.iterator();
		while(it.hasNext())
		{
			Point p = it.next();
			curX=p.getX();
			curY=p.getY();
			p.setLocation(curX+difX, curY+difY);
		}
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
		int centerStatus = Line.status(corners.get(0), corners.get(corners.size()-1), this.center.getX(), this.center.getY());
		for (int i=0; i<corners.size()-1; i++)
			centerStatus+=	Line.status(corners.get(i), corners.get(i+1), this.center.getX(), this.center.getY());
		
		int pStatus = Line.status(corners.get(0), corners.get(corners.size()-1), p.getX(), p.getY());
		for (int i=0; i<corners.size()-1; i++)
			pStatus+= Line.status(corners.get(i), corners.get(i+1), p.getX(), p.getY());
		
		if (centerStatus==pStatus && X<=maxX && X>=minX && Y<=maxY && Y>=minY)
			return true;
		else
			return false;
	}

	@Override
	public double getArea()
	{
		double area=Triangle.Area(this.center, corners.get(0), corners.get(corners.size()-1));
		for (int i=0; i<corners.size()-1; i++)
			area += Triangle.Area(this.center, corners.get(i), corners.get(i+1));
		return area;
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
		
		for (int i=0; i<corners.size(); i++)
		{
			x = corners.get(i).getX() - this.getCenter().getX();
			y = corners.get(i).getY() - this.getCenter().getY();
			newX = x*Math.cos(rad) - y*Math.sin(rad);
			newY = x*Math.sin(rad) + y*Math.cos(rad);
			newX += this.getCenter().getX();
			newY += this.getCenter().getY();
			corners.get(i).setLocation(newX, newY);
		}
		
		updateMinAndMax();
	}
	public int getRotatedSoFar()
	{
		return rotatedSoFar;
	}

	@Override
	public int getType()
	{
		return 5;
	}

	@Override
	public void Render(Graphics G)
	{
		G.setColor(getFillColor());
		G.fillPolygon(xOfCorners, yOfCorners, n);
		
		G.setColor(getBorderColor());
		G.drawPolygon(xOfCorners, yOfCorners, n);	
	}

	@Override
	public void scale(double scale)
	{
		if (scale <= 0)
			return;
		if (scale*l < 50)
			return;
		
		double distX, distY;
		
		for (int i=0; i<corners.size(); i++)
		{
			distX=corners.get(i).getX()-this.center.getX();
			distY=corners.get(i).getY()-this.center.getY();
			distX*=scale;
			distY*=scale;
			corners.get(i).setLocation(this.center.getX()+distX, this.center.getY()+distY);
		}
		l*=scale;
		updateMinAndMax();
	}
	private void updateMinAndMax()
	{
		minX=(int) Math.min(corners.get(0).getX(), corners.get(1).getX());
		maxX=(int) Math.max(corners.get(0).getX(), corners.get(1).getX());
		minY=(int) Math.min(corners.get(0).getY(), corners.get(1).getY());
		maxY=(int) Math.max(corners.get(0).getY(), corners.get(1).getY());
		
		xOfCorners[0] = (int) corners.get(0).getX();
		xOfCorners[1] = (int) corners.get(1).getX();
		yOfCorners[0] = (int) corners.get(0).getY();
		yOfCorners[1] = (int) corners.get(1).getY();
		for (int i=2; i<corners.size(); i++)
		{
			minX=(int) Math.min(minX, corners.get(i).getX());
			maxX=(int) Math.max(maxX, corners.get(i).getX());
			minY=(int) Math.min(minY, corners.get(i).getY());
			maxY=(int) Math.max(maxY, corners.get(i).getY());
			xOfCorners[i] = (int) corners.get(i).getX();
			yOfCorners[i] = (int) corners.get(i).getY();
		}

	}
	private Point nextPoint(Point start, int length, double ang)
	{
		Point end = new Point();
		double x1=start.getX();
		double y1=start.getY();
		double x2=x1+(length*Math.cos(ang));
		double y2=y1+(length*Math.sin(ang));
		end.setLocation(x2, y2);
		return end;
	}

}
