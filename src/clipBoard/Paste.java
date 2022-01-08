package clipBoard;

import java.awt.Point;
import java.util.Iterator;

import javax.swing.JOptionPane;

import main.MainWindow;
import shapes.*;

public class Paste
{
	public static void setDataToTheSheet(Point location)
	{
		if (ShapesData.getList().size() == 0)
			JOptionPane.showMessageDialog(MainWindow.mainPanel, "The clipboard is empty!", "No item available", JOptionPane.PLAIN_MESSAGE, main.GraphicsEngine.failureIcon);

		else if (ShapesData.getList().size() == 1)
			setShapeToTheSheet(location);
		
		else
			setGroupToTheSheet();
	}
	
	private static void setShapeToTheSheet(Point location)
	{
		ShapesData data = ShapesData.getList().get(0);
		///////////////////////Point/////////////////////////////////
		if (data.type==0)
		{
			Dot dot = new Dot(data.name,
					(int)data.center.getX(),
					(int)data.center.getY(),
					data.borderColor);
			dot.setCenter(location);
			ShapesData.getGroup().add(dot);
		}
		
		///////////////////////Line/////////////////////////////////
		else if (data.type==1)
		{
			Line line =new Line (data.name,
								(int)data.corners.get(0).getX(),
								(int)data.corners.get(0).getY(),
								(int)data.corners.get(1).getX(),
								(int)data.corners.get(1).getY(),
								data.borderColor);
			line.setCenter(location);
			ShapesData.getGroup().add(line);
		}
		
		///////////////////////Circle/////////////////////////////////
		else if (data.type==2)
		{
			Circle cir= new Circle (data.name,
								   (int)data.center.getX(),
								   (int)data.center.getY(),
									data.radius,
									data.borderColor,
									data.fillColor);
			cir.setCenter(location);
			ShapesData.getGroup().add(cir);
		}
		
		///////////////////////Rectangle/////////////////////////////////
		else if (data.type==3)
		{
			Rectangle rect = new Rectangle (data.name,
											(int)data.center.getX(),
											(int)data.center.getY(),
											data.height,
											data.width,
											data.borderColor,
											data.fillColor);
			rect.setCenter(location);
			rect.rotate(data.rotatedSoFar);
			ShapesData.getGroup().add(rect);
		}
		
		///////////////////////Triangle/////////////////////////////////
		else if (data.type==4)
		{
			Triangle tri = new Triangle (data.name,
										(int)data.corners.get(0).getX(),
										(int)data.corners.get(0).getY(),
										(int)data.corners.get(1).getX(),
										(int)data.corners.get(1).getY(),
										(int)data.corners.get(2).getX(),
										(int)data.corners.get(2).getY(),
										data.borderColor,
										data.fillColor);
			tri.setCenter(location);
			ShapesData.getGroup().add(tri);
		}
		
		///////////////////////Polygon/////////////////////////////////
		else if (data.type==5)
		{
			Polygon pol = new Polygon (data.name,
									   (int)data.N,
									   (int)data.center.getX(),
									   (int)data.center.getY(),
									   (int)data.L,
									   data.borderColor,
									   data.fillColor);
			pol.setCenter(location);
			pol.rotate(data.rotatedSoFar);
			ShapesData.getGroup().add(pol);
		}
		
		main.MainWindow.mainPanel.theUppest=null;
		main.MainWindow.mainPanel.repaint();
	}
	
	private static void setGroupToTheSheet()
	{
		Iterator<ShapesData> it = ShapesData.getList().iterator();
		while (it.hasNext())
		{
			ShapesData data = it.next();
			
			///////////////////////Point/////////////////////////////////
			if (data.type==0)
			{
				Dot dot = new Dot(data.name,
						(int)data.center.getX(),
						(int)data.center.getY(),
						data.borderColor);
				dot.moveCenter(5, 5);
				ShapesData.getGroup().add(dot);
				dot.setGroup(ShapesData.getGroup().get(0).getGroup());
			}
			
			///////////////////////Line/////////////////////////////////
			else if (data.type==1)
			{
				Line line =new Line (data.name,
									(int)data.corners.get(0).getX(),
									(int)data.corners.get(0).getY(),
									(int)data.corners.get(1).getX(),
									(int)data.corners.get(1).getY(),
									data.borderColor);
				line.moveCenter(5, 5);
				ShapesData.getGroup().add(line);
				line.setGroup(ShapesData.getGroup().get(0).getGroup());
			}
			
			///////////////////////Circle/////////////////////////////////
			else if (data.type==2)
			{
				Circle cir= new Circle (data.name,
									   (int)data.center.getX(),
									   (int)data.center.getY(),
										data.radius,
										data.borderColor,
										data.fillColor);
				cir.moveCenter(5, 5);
				ShapesData.getGroup().add(cir);
				cir.setGroup(ShapesData.getGroup().get(0).getGroup());
			}
			
			///////////////////////Rectangle/////////////////////////////////
			else if (data.type==3)
			{
				Rectangle rect = new Rectangle (data.name,
												(int)data.center.getX(),
												(int)data.center.getY(),
												data.height,
												data.width,
												data.borderColor,
												data.fillColor);
				rect.rotate(data.rotatedSoFar);
				rect.moveCenter(5, 5);
				ShapesData.getGroup().add(rect);
				rect.setGroup(ShapesData.getGroup().get(0).getGroup());
			}
			
			///////////////////////Triangle/////////////////////////////////
			else if (data.type==4)
			{
				Triangle tri = new Triangle (data.name,
											(int)data.corners.get(0).getX(),
											(int)data.corners.get(0).getY(),
											(int)data.corners.get(1).getX(),
											(int)data.corners.get(1).getY(),
											(int)data.corners.get(2).getX(),
											(int)data.corners.get(2).getY(),
											data.borderColor,
											data.fillColor);
				tri.moveCenter(5, 5);
				ShapesData.getGroup().add(tri);
				tri.setGroup(ShapesData.getGroup().get(0).getGroup());
			}
			
			///////////////////////Polygon/////////////////////////////////
			else if (data.type==5)
			{
				Polygon pol = new Polygon (data.name,
										   (int)data.N,
										   (int)data.center.getX(),
										   (int)data.center.getY(),
										   (int)data.L,
										   data.borderColor,
										   data.fillColor);
				pol.rotate(data.rotatedSoFar);
				pol.moveCenter(5, 5);

				ShapesData.getGroup().add(pol);
				pol.setGroup(ShapesData.getGroup().get(0).getGroup());
			}
			main.MainWindow.mainPanel.theUppest=null;
			main.MainWindow.mainPanel.repaint();
		}
		ShapesData.getGroup().clear();
	}
}
