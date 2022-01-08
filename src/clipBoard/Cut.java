package clipBoard;

import group.Group;
import shapes.Shape;

public class Cut
{
	public static void setShapeToClipboard(Shape inputShape)
	{
		Copy.setShapeToClipboard(inputShape);
		inputShape.destroy();
		main.MainWindow.mainPanel.repaint();
	}
	public static void setGroupToClipboard(Group inputGroup)
	{
		Copy.setGroupToClipboard(inputGroup);
		while (inputGroup.getList().size()>0)
			inputGroup.getList().get(0).destroy();
		main.MainWindow.mainPanel.repaint();
	}
}
