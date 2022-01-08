package popupMenus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import shapes.Shape;

public class ShapePopupMenu extends JPopupMenu
{
	private static final long serialVersionUID = 4168076898321600295L;

	public ShapePopupMenu(Shape theUppest)
	{
		JMenuItem individualEdit = new JMenuItem("Edit Shape");
		individualEdit.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.ShapeEdit ie = new menuItemWindows.ShapeEdit(theUppest);
				ie.show();
			}
		});
		add(individualEdit);
		
		addSeparator();
		
		JMenuItem cut = new JMenuItem("Cut Shape");
		cut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				clipBoard.Cut.setShapeToClipboard(theUppest);
			}
		});
		add(cut);
		
		JMenuItem copy = new JMenuItem("Copy Shape");
		copy.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				clipBoard.Copy.setShapeToClipboard(theUppest);
			}
		});
		add(copy);
		
		JMenuItem delete = new JMenuItem("Delete Shape");
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				theUppest.destroy();
				main.MainWindow.mainPanel.repaint();
			}
		});
		add(delete);
		
		addSeparator();
		
		JMenuItem details = new JMenuItem("Shape Details");
		details.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.ShapeDetails sd = new menuItemWindows.ShapeDetails(theUppest);
				sd.show();
			}
		});
		add(details);
	}
}
