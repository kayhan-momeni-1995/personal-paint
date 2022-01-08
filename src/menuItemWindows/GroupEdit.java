package menuItemWindows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import group.Group;
import shapes.Shape;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class GroupEdit extends JFrame
{
	private static final long serialVersionUID = -1566081770791408364L;
	private JPanel contentPane;
	static Group group;
	Color borderColor = null;
	Color fillColor = null;

	public GroupEdit(Shape theUppest)
	{
		group=theUppest.getGroup();
		setTitle("Edit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((int) main.GraphicsEngine.cursorPoint.getX(), (int) main.GraphicsEngine.cursorPoint.getY(), 250, 220);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Color");
		label.setBounds(6, 6, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Border color:");
		label_1.setBounds(6, 27, 82, 16);
		contentPane.add(label_1);
		
		JLabel borderColorLbl = new JLabel("");
		borderColorLbl.setOpaque(true);
		borderColorLbl.setBackground((Color) null);
		borderColorLbl.setBounds(92, 27, 15, 15);
		contentPane.add(borderColorLbl);
		
		JButton borderColorBtn = new JButton("Choose Color");
		borderColorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				borderColor= JColorChooser.showDialog(getParent(), "Choose a color", borderColor);
				borderColorLbl.setBackground(borderColor);
			}
		});
		borderColorBtn.setBounds(115, 22, 129, 29);
		contentPane.add(borderColorBtn);
		
		JLabel label_3 = new JLabel("Fill color:");
		label_3.setBounds(6, 52, 82, 16);
		contentPane.add(label_3);
		
		JLabel fillColorLbl = new JLabel("");
		fillColorLbl.setOpaque(true);
		fillColorLbl.setBackground((Color) null);
		fillColorLbl.setBounds(92, 53, 15, 15);
		contentPane.add(fillColorLbl);
		
		JButton fillColorBtn = new JButton("Choose Color");
		fillColorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				fillColor = JColorChooser.showDialog(getParent(), "Choose a color", fillColor);
				fillColorLbl.setBackground(fillColor);
			}
		});
		fillColorBtn.setBounds(115, 47, 129, 29);
		contentPane.add(fillColorBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 74, 238, 12);
		contentPane.add(separator);
		
		JLabel label_5 = new JLabel("Rotate(deg):");
		label_5.setBounds(6, 94, 75, 16);
		contentPane.add(label_5);
		
		JSpinner rotate = new JSpinner();
		rotate.setModel(new SpinnerNumberModel(0, -360, 360, 1));
		rotate.setBounds(92, 88, 65, 28);
		contentPane.add(rotate);
		
		JLabel label_6 = new JLabel("Scale:");
		label_6.setBounds(6, 122, 40, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("X");
		label_7.setBounds(82, 122, 12, 16);
		contentPane.add(label_7);
		
		JSpinner scale = new JSpinner();
		scale.setModel(new SpinnerNumberModel(1, 0.01, 100, 0.01));
		scale.setBounds(92, 116, 65, 28);
		contentPane.add(scale);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 142, 238, 12);
		contentPane.add(separator_1);
		
		JButton okBtn = new JButton("OK");
		okBtn.setIcon(main.MainWindow.okIcon);
		okBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Iterator<Shape> it = group.getList().iterator();
				Shape.clearOfBolds();
				Shape.clearOfSelections();
				while (it.hasNext())
				{
					Shape shape = it.next();
					
					if (borderColor!=null)
						shape.setBorderColor(borderColor);
					
					if (fillColor!=null)
						shape.setFillColor(fillColor);
					
					shape.rotate(((Number)(rotate.getValue())).intValue());
					
					if (shape.getType()>1)
						shape.scale(Math.sqrt(((Number)(scale.getValue())).doubleValue()));
					else
						shape.scale(((Number)(scale.getValue())).doubleValue());
				}
				
				main.MainWindow.mainPanel.repaint();
				CloseFrame();
			}
		});
		okBtn.setBounds(6, 150, 238, 45);
		contentPane.add(okBtn);
	}
	public void CloseFrame()
	{
	    super.dispose();
	}
}
