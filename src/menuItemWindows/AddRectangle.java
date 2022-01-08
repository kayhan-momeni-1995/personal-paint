package menuItemWindows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddRectangle extends JFrame
{
	private static final long serialVersionUID = -3949768557530767817L;
	private JPanel contentPane;
	private JTextField name;
	Color borderColor = new Color(0,0,0);
	Color fillColor = new Color(0,0,0);

	public AddRectangle() {
		setTitle("Add Rectangle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((int) main.GraphicsEngine.cursorPoint.getX(), (int) main.GraphicsEngine.cursorPoint.getY(), 250, 315);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Name:");
		label.setBounds(6, 6, 47, 28);
		contentPane.add(label);
		
		name = new JTextField();
		name.setText("(NoName)");
		name.setColumns(10);
		name.setBounds(51, 6, 193, 28);
		contentPane.add(name);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 39, 238, 12);
		contentPane.add(separator);
		
		JLabel label_1 = new JLabel("Location");
		label_1.setBounds(6, 46, 58, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Center:");
		label_2.setBounds(6, 69, 58, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("X:");
		label_3.setBounds(76, 69, 12, 16);
		contentPane.add(label_3);
		
		JSpinner xOfCenter = new JSpinner();
		xOfCenter.setModel(new SpinnerNumberModel((int) main.GraphicsEngine.cursorPoint.getX(), 0, main.MainWindow.mainPanel.getWidth(), 1 ));
		xOfCenter.setBounds(86, 63, 65, 28);
		contentPane.add(xOfCenter);
		
		JLabel label_4 = new JLabel("Y:");
		label_4.setBounds(168, 69, 12, 16);
		contentPane.add(label_4);
		
		JSpinner yOfCenter = new JSpinner();
		yOfCenter.setModel(new SpinnerNumberModel((int) main.GraphicsEngine.cursorPoint.getY(), 0, main.MainWindow.mainPanel.getHeight(), 1 ));
		yOfCenter.setBounds(179, 63, 65, 28);
		contentPane.add(yOfCenter);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 89, 238, 12);
		contentPane.add(separator_1);
		
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setBounds(6, 103, 47, 16);
		contentPane.add(lblWidth);
		
		JSpinner width = new JSpinner();
		width.setModel(new SpinnerNumberModel(200, 55, 1000, 1));
		width.setBounds(51, 97, 55, 28);
		contentPane.add(width);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(133, 103, 47, 16);
		contentPane.add(lblHeight);
		
		JSpinner height = new JSpinner();
		height.setModel(new SpinnerNumberModel(60, 55, 1000, 1));
		height.setBounds(189, 97, 55, 28);
		contentPane.add(height);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 123, 238, 12);
		contentPane.add(separator_2);
		
		JLabel label_6 = new JLabel("Color");
		label_6.setBounds(6, 131, 61, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Border color:");
		label_7.setBounds(6, 152, 82, 16);
		contentPane.add(label_7);
		
		JLabel borderColorLbl = new JLabel("");
		borderColorLbl.setOpaque(true);
		borderColorLbl.setBackground(Color.BLACK);
		borderColorLbl.setBounds(90, 153, 15, 15);
		contentPane.add(borderColorLbl);
		
		JButton borderColorBtn = new JButton("Choose Color");
		borderColorBtn.addActionListener(new ActionListener()
		{
			Color tmp = new Color(0,0,0);
			public void actionPerformed(ActionEvent e)
			{
				tmp = JColorChooser.showDialog(getParent(), "Choose a color", borderColor);
				if (tmp == null)
					tmp=new Color (borderColor.getRGB());
				else
					borderColor=new Color(tmp.getRGB());
				borderColorLbl.setBackground(borderColor);
			}
		});
		borderColorBtn.setBounds(115, 147, 129, 29);
		contentPane.add(borderColorBtn);
		
		JLabel lblFillColor = new JLabel("Fill color:");
		lblFillColor.setBounds(6, 177, 82, 16);
		contentPane.add(lblFillColor);
		
		JLabel fillColorLbl = new JLabel("");
		fillColorLbl.setOpaque(true);
		fillColorLbl.setBackground(Color.BLACK);
		fillColorLbl.setBounds(90, 178, 15, 15);
		contentPane.add(fillColorLbl);
		
		JButton fillColorBtn = new JButton("Choose Color");
		fillColorBtn.addActionListener(new ActionListener() {
			Color tmp = new Color(0,0,0);
			public void actionPerformed(ActionEvent e)
			{
				tmp = JColorChooser.showDialog(getParent(), "Choose a color", fillColor);
				if (tmp == null)
					tmp=new Color (fillColor.getRGB());
				else
					fillColor=new Color(tmp.getRGB());
				fillColorLbl.setBackground(fillColor);
			}
		});
		fillColorBtn.setBounds(115, 172, 129, 29);
		contentPane.add(fillColorBtn);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 199, 238, 12);
		contentPane.add(separator_3);
		
		JLabel label_11 = new JLabel("Priority:");
		label_11.setBounds(6, 211, 58, 16);
		contentPane.add(label_11);
		
		JSpinner priority = new JSpinner();
		priority.setModel(new SpinnerNumberModel(1, 1, 9999, 1));
		priority.setBounds(59, 205, 65, 28);
		contentPane.add(priority);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(6, 234, 238, 12);
		contentPane.add(separator_4);
		
		JButton okBtn = new JButton("OK");
		okBtn.setIcon(main.MainWindow.okIcon);
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (((Number)priority.getValue()).intValue() == 1)
					new shapes.Rectangle(name.getText(),
							((Number)((xOfCenter).getValue())).intValue(),
							((Number)(yOfCenter.getValue())).intValue(),
							((Number)(width.getValue())).intValue(),
							((Number)(height.getValue())).intValue(),
							borderColor,
							fillColor);

				else
					new shapes.Rectangle(name.getText(),
							((Number)((xOfCenter).getValue())).intValue(),
							((Number)(yOfCenter.getValue())).intValue(),
							((Number)(width.getValue())).intValue(),
							((Number)(height.getValue())).intValue(),
							borderColor,
							fillColor,
							((Number)(priority.getValue())).intValue());				
				main.MainWindow.mainPanel.repaint();
				CloseFrame();
			}
		});
		okBtn.setBounds(6, 246, 238, 45);
		contentPane.add(okBtn);
	}
	public void CloseFrame()
	{
	    super.dispose();
	}
}
