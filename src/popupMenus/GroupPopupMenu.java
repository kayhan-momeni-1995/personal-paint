package popupMenus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import group.Group;
import shapes.Shape;

public class GroupPopupMenu extends JPopupMenu
{
	private static final long serialVersionUID = 1226419627651964603L;

	public GroupPopupMenu(Shape theUppest)
	{
		Group group = theUppest.getGroup();
		
		JMenuItem GroupEdit = new JMenuItem("Edit Group");
		GroupEdit.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.GroupEdit ge = new menuItemWindows.GroupEdit(theUppest);
				ge.show();
			}
		});
		add(GroupEdit);
		
		addSeparator();
		
		JMenuItem cut = new JMenuItem("Cut Group");
		cut.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				clipBoard.Cut.setGroupToClipboard(theUppest.getGroup());
			}
		});
		add(cut);
		
		JMenuItem copy = new JMenuItem("Copy Group");
		copy.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				clipBoard.Copy.setGroupToClipboard(theUppest.getGroup());
			}
		});
		add(copy);
		
		JMenuItem delete = new JMenuItem("Delete Group");
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				while (group.getSize()>0)
					group.getList().get(0).destroy();
				main.MainWindow.mainPanel.repaint();
			}
		});
		add(delete);
		
		addSeparator();
		
		JMenuItem details = new JMenuItem("Group Details");
		details.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e)
			{
				menuItemWindows.GroupDetails gd = new menuItemWindows.GroupDetails(theUppest);
				gd.show();
			}
		});
		add(details);
	}
}
