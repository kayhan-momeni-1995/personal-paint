package menuItemWindows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Help extends JFrame
{
	private static final long serialVersionUID = 2253410774241831274L;
	private JPanel contentPane;

	public Help()
	{
		setTitle("Help");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((int) (main.MainWindow.mainPanel.getWidth()/2)-250, 10, 500, 740);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblRightclick = new JLabel("<Right-Click> On The Sheet:");
		lblRightclick.setBounds(6, 166, 268, 16);
		contentPane.add(lblRightclick);
		
		JLabel lblSheetsOptions = new JLabel("The sheet's options");
		lblSheetsOptions.setBounds(295, 166, 199, 16);
		contentPane.add(lblSheetsOptions);
		
		JLabel lblRightclick_1 = new JLabel("<Right-Click> On A Shape:");
		lblRightclick_1.setBounds(6, 194, 268, 16);
		contentPane.add(lblRightclick_1);
		
		JLabel lblNewLabel = new JLabel("The shape's options");
		lblNewLabel.setBounds(295, 194, 197, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblcontrolRightclick = new JLabel("\"Control\" + <Right-Click> On A Shape:");
		lblcontrolRightclick.setBounds(6, 222, 268, 16);
		contentPane.add(lblcontrolRightclick);
		
		JLabel lblItsGroupsOptions = new JLabel("Its group's options");
		lblItsGroupsOptions.setBounds(295, 222, 199, 16);
		contentPane.add(lblItsGroupsOptions);
		
		JLabel lblCliclOnA = new JLabel("<Click> On A Selected (Shape/Group):");
		lblCliclOnA.setBounds(8, 6, 248, 16);
		contentPane.add(lblCliclOnA);
		
		JLabel lblSelect = new JLabel("Deselect");
		lblSelect.setBounds(295, 6, 199, 16);
		contentPane.add(lblSelect);
		
		JLabel lblCliclOnAn = new JLabel("<Click> On An Unselected (Shape/Group):");
		lblCliclOnAn.setBounds(8, 34, 266, 16);
		contentPane.add(lblCliclOnAn);
		
		JLabel lblSelect_1 = new JLabel("Select");
		lblSelect_1.setBounds(297, 34, 199, 16);
		contentPane.add(lblSelect_1);
		
		JLabel lblNewLabel_1 = new JLabel("\"Control\" + <Click> On A Shape:");
		lblNewLabel_1.setBounds(8, 62, 248, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblGroupUngroup = new JLabel("Group / Ungroup");
		lblGroupUngroup.setBounds(295, 62, 201, 16);
		contentPane.add(lblGroupUngroup);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 90, 488, 12);
		contentPane.add(separator);
		
		JLabel lblAShape = new JLabel("<Drag> A Shape");
		lblAShape.setBounds(6, 114, 268, 16);
		contentPane.add(lblAShape);
		
		JLabel lblChangeLocation = new JLabel("Change Its Location");
		lblChangeLocation.setBounds(295, 114, 199, 16);
		contentPane.add(lblChangeLocation);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 142, 488, 12);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 250, 488, 12);
		contentPane.add(separator_2);
		
		JLabel lblcontrol = new JLabel("\"Control\" + \"D\":");
		lblcontrol.setBounds(6, 274, 258, 16);
		contentPane.add(lblcontrol);
		
		JLabel lblDeleteAGroup = new JLabel("Delete");
		lblDeleteAGroup.setBounds(295, 274, 199, 16);
		contentPane.add(lblDeleteAGroup);
		
		JLabel lblcontrolc = new JLabel("\"Control\" + \"C\":");
		lblcontrolc.setBounds(6, 302, 258, 16);
		contentPane.add(lblcontrolc);
		
		JLabel lblCopyAGroup = new JLabel("Copy");
		lblCopyAGroup.setBounds(295, 302, 199, 16);
		contentPane.add(lblCopyAGroup);
		
		JLabel lblcontrolx = new JLabel("\"Control\" + \"X\":");
		lblcontrolx.setBounds(6, 330, 258, 16);
		contentPane.add(lblcontrolx);
		
		JLabel lblCutAGroup = new JLabel("Cut");
		lblCutAGroup.setBounds(295, 330, 199, 16);
		contentPane.add(lblCutAGroup);
		
		JLabel lblcontrolv = new JLabel("\"Control\" + \"V\":");
		lblcontrolv.setBounds(6, 358, 250, 16);
		contentPane.add(lblcontrolv);
		
		JLabel lblPaste = new JLabel("Paste");
		lblPaste.setBounds(295, 358, 199, 16);
		contentPane.add(lblPaste);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(6, 386, 488, 12);
		contentPane.add(separator_4);
		
		JLabel lblcontrols = new JLabel("\"Control\" + \"S\":");
		lblcontrols.setBounds(6, 546, 250, 16);
		contentPane.add(lblcontrols);
		
		JLabel lblNewLabel_2 = new JLabel("\"Control\" + \"+\":");
		lblNewLabel_2.setBounds(6, 410, 250, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblZoomIn = new JLabel("Magnify");
		lblZoomIn.setBounds(295, 410, 199, 16);
		contentPane.add(lblZoomIn);
		
		JLabel lblcontrol_1 = new JLabel("\"Control\" + \"-\":");
		lblcontrol_1.setBounds(6, 438, 250, 16);
		contentPane.add(lblcontrol_1);
		
		JLabel lblZoomOut = new JLabel("Minify");
		lblZoomOut.setBounds(295, 438, 199, 16);
		contentPane.add(lblZoomOut);
		
		JLabel lblcontrolr = new JLabel("\"Control\" + \"R\":");
		lblcontrolr.setBounds(6, 466, 250, 16);
		contentPane.add(lblcontrolr);
		
		JLabel lblRotate = new JLabel("Rotate (Clockwise)");
		lblRotate.setBounds(295, 466, 199, 16);
		contentPane.add(lblRotate);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(6, 522, 488, 12);
		contentPane.add(separator_5);
		
		JLabel lblSave = new JLabel("Save");
		lblSave.setBounds(295, 546, 199, 16);
		contentPane.add(lblSave);
		
		JLabel lblcontroll = new JLabel("\"Control\" + \"L\":");
		lblcontroll.setBounds(6, 574, 250, 16);
		contentPane.add(lblcontroll);
		
		JLabel lblLoad = new JLabel("Load");
		lblLoad.setBounds(295, 574, 199, 16);
		contentPane.add(lblLoad);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(6, 602, 488, 12);
		contentPane.add(separator_6);
		
		JLabel lblcontrolh = new JLabel("\"Control\" + \"H\":");
		lblcontrolh.setBounds(6, 626, 250, 16);
		contentPane.add(lblcontrolh);
		
		JLabel lblHelp = new JLabel("Help");
		lblHelp.setBounds(295, 626, 199, 16);
		contentPane.add(lblHelp);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(6, 654, 488, 12);
		contentPane.add(separator_7);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setIcon(main.MainWindow.okIcon);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CloseFrame();
			}
		});
		btnNewButton.setBounds(6, 665, 488, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblcontrolshift = new JLabel("\"Control\" + \"Shift\" + \"R\":");
		lblcontrolshift.setBounds(6, 494, 250, 16);
		contentPane.add(lblcontrolshift);
		
		JLabel lblRotatecounter = new JLabel("Rotate (Counterclockwise)");
		lblRotatecounter.setBounds(295, 494, 199, 16);
		contentPane.add(lblRotatecounter);
	}
	public void CloseFrame()
	{
	    super.dispose();
	}
}
