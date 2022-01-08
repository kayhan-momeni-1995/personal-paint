package shapes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Dot extends Shape
{

	private static final long serialVersionUID = 1354269714456294010L;

	public Dot(String name,int X, int Y, Color borderColor)
	{
		super(name, X, Y, borderColor);
	}
	public Dot(String name,int X, int Y, Color borderColor, int priority)
	{
		super(name, new Point(), borderColor, borderColor, priority);
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

	@Override
	public boolean isIn(Point p)
	{
		if (p.distance(this.getCenter())<=4)
			return true;
		else
			return false;
	}

	@Override
	public double getArea()
	{
		return 0;
	}
	
	@Override
	public void rotate (double degree)
	{
		return;
	}
	
	@Override
	public int getType()
	{
		return 0;
	}

	@Override
	public void Render (Graphics G)
	{
		G.setColor(this.getBorderColor());
		G.fillOval((int)(this.getCenter().getX()-1.5),
				   (int)(this.getCenter().getY()-1.5),
				   3, 3);
		if (this.isBold()  || this.isSelected())
		{
			G.fillOval((int)(this.getCenter().getX()-1.5),
					   (int)(this.getCenter().getY()-1.5),
					   5, 5);
		}
	}
	
	@Override
	public void scale(double scale)
	{		
	}

}
