package serializer;

import java.io.Serializable;
import java.util.ArrayList;

import group.Group;
import shapes.Shape;

class ProgramData implements Serializable
{
	private static final long serialVersionUID = 2360716001846679737L;
	ArrayList<Shape> Shapes;
	ArrayList<Group> Groups;
	public ProgramData()
	{
		Shapes = shapes.Shape.allShapes;
		Groups = Group.allGroups;
		
	}
	public void updateProgram()
	{
		Group.allGroups=Groups;
		Shape.allShapes=Shapes;
		main.MainWindow.mainPanel.repaint();
	}
}
