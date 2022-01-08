package popupMenus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import shapes.Shape;

public class AddItems extends JPopupMenu
{
	private static final long serialVersionUID = 6479961630901907784L;

	public AddItems()
	{
		JMenuItem addPoint = new JMenuItem("Add Point");
		addPoint.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.AddPoint ac = new menuItemWindows.AddPoint();
				ac.show();
			}
		});
		add(addPoint);
		
		JMenuItem AddLine = new JMenuItem("Add Line");
		AddLine.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.AddLine al = new menuItemWindows.AddLine();
				al.show();
			}
		});
		add(AddLine);
		
		JMenuItem AddCircle = new JMenuItem("Add Circle");
		AddCircle.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.AddCircle ac = new menuItemWindows.AddCircle();
				ac.show();
			}
		});
		add(AddCircle);
		
		JMenuItem AddRectangle = new JMenuItem("Add Rectangle");
		AddRectangle.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.AddRectangle ar = new menuItemWindows.AddRectangle();
				ar.show();
			}
		});
		add(AddRectangle);
		
		JMenuItem AddTriangle = new JMenuItem("Add Triangle");
		AddTriangle.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.AddTriangle at = new menuItemWindows.AddTriangle();
				at.show();
			}
		});
		add(AddTriangle);
		
		JMenuItem AddPolygon = new JMenuItem("Add Polygon");
		AddPolygon.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.AddPolygon ap = new menuItemWindows.AddPolygon();
				ap.show();
			}
		});
		add(AddPolygon);
		
		addSeparator();
		
		JMenuItem paste = new JMenuItem("Paste");
		paste.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				clipBoard.Paste.setDataToTheSheet(main.MainWindow.mainPanel.rightClick);
			}
		});
		add(paste);
		
		addSeparator();
		
		JMenuItem help = new JMenuItem("Help");
		help.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.Help h = new menuItemWindows.Help();
				h.show();
			}
		});
		add(help);
		
		addSeparator();
		
		JMenuItem clearSheet = new JMenuItem("Clear Sheet");
		clearSheet.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				while (Shape.allShapes.size()>0)
				{
					Shape.allShapes.get(0).destroy();
				}
				main.MainWindow.mainPanel.repaint();
			}
		});
		add(clearSheet);
	}
}
