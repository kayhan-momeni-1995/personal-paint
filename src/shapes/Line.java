package shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape
{

	private static final long serialVersionUID = 1721413978325976751L;
	private Point start, end;
	int minX, maxX, minY, maxY;
	
	public Line(String name, int X1, int Y1, int X2, int Y2, Color borderColor)
	{
		super(name, new Point(), borderColor);
		this.center.setLocation((X1+X2)/2, (Y1+Y2)/2);

		start=new Point();
		end=new Point();
		start.setLocation(X1, Y1);
		end.setLocation(X2, Y2);
		updateMinAndMax();
	}
	public Line(String name, int X1, int Y1, int X2, int Y2, Color borderColor, int priority)
	{
		super(name, new Point(), borderColor, borderColor, priority);
		this.center.setLocation((X1+X2)/2, (Y1+Y2)/2);

		start=new Point();
		end=new Point();
		start.setLocation(X1, Y1);
		end.setLocation(X2, Y2);
		updateMinAndMax();

	}
	
	@Override
	public void setCenter(Point newCenter)
	{
		double difX, difY, curX, curY;

		curX=this.center.getX();
		curY=this.center.getY();
		difX=newCenter.getX()-curX;
		difY=newCenter.getY()-curY;
		this.center.setLocation(curX+difX, curY+difY);
		
		curX=this.start.getX();
		curY=this.start.getY();
		start.setLocation(curX+difX, curY+difY);
		
		curX=this.end.getX();
		curY=this.end.getY();
		this.end.setLocation(curX+difX, curY+difY);
		
		updateMinAndMax();
	}
	public void setCenter(int X, int Y)
	{
		Point center = new Point();
		center.setLocation(X, Y);
		this.setCenter(center);
	}
	
	public Point getStart()
	{
		return this.start;
	}
	
	public Point getEnd()
	{
		return this.end;
	}

	@Override
	public boolean isIn(Point p)
	{
		double x1=start.getX();
		double x2=end.getX();
		double y1=start.getY();
		double y2=end.getY();
		
		if (p.getX()>maxX || p.getX()<minX || p.getY()>maxY || p.getY()<minY)
			return false;
		if (x2==x1)
		{
			if (Math.abs(p.getX()-x1)<=3  &&
				p.getY()>=Math.min(y1, y2)-2&&
				p.getY()<=Math.max(y1, y2)+2)
					return true;
			else
				return false;	
		}
		else
		{
			if/****/(p.getY()==(int)(((y2-y1)/(x2-x1))*(p.getX()-x1)+y1)+0)
				return true;
			else if (p.getY()==(int)(((y2-y1)/(x2-x1))*(p.getX()-x1)+y1)+1)
				return true;
			else if (p.getY()==(int)(((y2-y1)/(x2-x1))*(p.getX()-x1)+y1)-1)
				return true;
			else if (p.getY()==(int)(((y2-y1)/(x2-x1))*(p.getX()-x1)+y1)+2)
				return true;
			else if (p.getY()==(int)(((y2-y1)/(x2-x1))*(p.getX()-x1)+y1)-2)
				return true;
			else if (p.getY()==(int)(((y2-y1)/(x2-x1))*(p.getX()-x1)+y1)+3)
				return true;
			else if (p.getY()==(int)(((y2-y1)/(x2-x1))*(p.getX()-x1)+y1)-3)
				return true;
			else
				return false;
		}
	}

	@Override
	public double getArea()
	{
		return 0;
	}
	public double getLenght()
	{
		double x1=start.getX();
		double x2=end.getX();
		double y1=start.getY();
		double y2=end.getY();
		
		double l=0;
		l+= (double)Math.pow((x2-x1), 2);
		l+= (double)Math.pow((y2-y1), 2);
		l= (double)Math.sqrt(l);
		return l;
	}
	
	@Override
	public void rotate (double degree)
	{
		double rad = -((Math.PI)*(degree)/180), x, y, newX, newY;
		Point start,end;
		
		x = this.getStart().getX() - this.getCenter().getX();
		y = this.getStart().getY() - this.getCenter().getY();
		newX = x*Math.cos(rad) - y*Math.sin(rad);
		newY = x*Math.sin(rad) + y*Math.cos(rad);
		newX += this.getCenter().getX();
		newY += this.getCenter().getY();
		start = new Point();
		start.setLocation(newX, newY);
		this.start=start;
		
		x = this.getEnd().getX() - this.getCenter().getX();
		y = this.getEnd().getY() - this.getCenter().getY();
		newX = x*Math.cos(rad) - y*Math.sin(rad);
		newY = x*Math.sin(rad) + y*Math.cos(rad);
		newX += this.getCenter().getX();
		newY += this.getCenter().getY();
		end = new Point();
		end.setLocation(newX, newY);
		this.end=end;
		
		updateMinAndMax();
	}

	@Override
	public int getType()
	{
		return 1;
	}

	@Override
	public void Render(Graphics G)
	{
		int x1=(int) start.getX();
		int x2=(int) end.getX();
		int y1=(int) start.getY();
		int y2=(int) end.getY();
		
		G.setColor(this.getBorderColor());
		G.drawLine((int)this.start.getX(), (int)this.start.getY(), (int)this.end.getX(), (int)this.end.getY());
		if (this.isBold()  || this.isSelected())
		{
			G.drawLine(x1+1, y1, x2+1, y2);
			G.drawLine(x1, y1+1, x2, y2+1);
		}
	}
	
	//It returns (00) if the point (X,Y) is (on----) or (---------------) the line [Start->End]
	//It returns (+1) if the point (X,Y) is (above-) or (to the right of) the line [Start->End]
	//It returns (-1) if the point (X,Y) is (bellow) or (to the left of ) the line [Start->End]
	public static int status(Point Start, Point End, double X, double Y)
	{
		double X1=Start.getX();
		double X2=End.getX();
		double Y1=Start.getY();
		double Y2=End.getY();
		if (X2!=X1)
		{
			double m=(Y2-Y1)/(X2-X1);
			double a=Y1-m*X1;
			if (Y>((m*X)+a))
				return 1;
			else if (Y == ((m*X)+a))
				return 0;
			else
				return -1;
		}
		else
		{
			if (X<X1)
				return -1;
			else if (X==X1)
				return 0;
			else
				return +1;
		}
	}
	private void updateMinAndMax()
	{
		minX=(int)Math.min(start.getX(), end.getX());
		maxX=(int)Math.max(start.getX(), end.getX());
		minY=(int)Math.min(start.getY(), end.getY());
		maxY=(int)Math.max(start.getY(), end.getY());
	}
	
	@Override
	public void scale(double scale)
	{
		if (scale <= 0)
			return;
		
		double distX1, distY1, distX2, distY2;
		
		distX1=this.start.getX()-this.center.getX();
		distY1=this.start.getY()-this.center.getY();
		distX1*=scale;
		distY1*=scale;
		
		distX2=this.end.getX()-this.center.getX();
		distY2=this.end.getY()-this.center.getY();
		distX2*=scale;
		distY2*=scale;
		if (Point.distance(this.center.getX()+distX1, this.center.getY()+distY1, this.center.getX()+distX2, this.center.getY()+distY2)>=30)
		{
			this.start.setLocation(this.center.getX()+distX1, this.center.getY()+distY1);
			this.end.setLocation(this.center.getX()+distX2, this.center.getY()+distY2);
			updateMinAndMax();
		}
	}
}
