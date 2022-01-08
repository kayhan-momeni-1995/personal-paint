package shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Circle extends Shape
{

	private static final long serialVersionUID = -3255809624762537177L;
	private int radius;
	public Circle(String name, int X, int Y, int radius, Color borderColor, Color fillColor)
	{
		super(name, new Point(), borderColor, fillColor);
		this.radius=radius;
		this.center.setLocation(X, Y);
	}
	public Circle(String name, int X, int Y, int radius, Color borderColor, Color fillColor, int priority)
	{
		super(name, new Point(), borderColor, fillColor, priority);
		this.radius=radius;
		this.center.setLocation(X, Y);
	}

	@Override
	public void setCenter(Point center)
	{
		this.center=center;
	}
	
	@Override
	public void setCenter(int X, int Y)
	{
		this.center.setLocation(X, Y);
	}
	public void setRadius(int radius)
	{
		this.radius=radius;
	}
	public int getRadius()
	{
		return radius;
	}
	
	@Override
	public boolean isIn(Point p)
	{
		if (p.distance(this.getCenter()) <= this.getRadius())
			return true;
		else
			return false;
	}

	@Override
	public double getArea()
	{
		return (Math.PI*Math.pow(this.getRadius(), 2));
	}

	@Override
	public void rotate (double degree)
	{
		return;
	}
	
	@Override
	public int getType()
	{
		return 2;
	}

	@Override
	public void Render(Graphics G)
	{
		G.setColor(this.getFillColor());
		G.fillOval((int)(this.getCenter().getX()-this.getRadius()),
				   (int)(this.getCenter().getY()-this.getRadius()),
				   (int)(2*this.getRadius()),
				   (int)(2*this.getRadius())
				   );
		
		G.setColor(this.getBorderColor());
		G.drawOval((int)(this.getCenter().getX()-this.getRadius()),
				   (int)(this.getCenter().getY()-this.getRadius()),
				   (int)(2*this.getRadius()),
				   (int)(2*this.getRadius())
				   );
	}
	
	@Override
	public void scale(double scale)
	{
		if (scale <= 0)
			return;
		if (radius*scale >= 20)
			this.radius *= scale;
	}
}
