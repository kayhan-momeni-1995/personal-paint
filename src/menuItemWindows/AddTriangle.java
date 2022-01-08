package menuItemWindows;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTriangle extends JFrame
{

	private static final long serialVersionUID = -6329823685049779721L;
	private JPanel contentPane;
	Color borderColor = new Color(0,0,0);
	Color fillColor = new Color(0,0,0);
	private JTextField name;
	
	public AddTriangle()
	{
		setTitle("Add Triangle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((int) main.GraphicsEngine.cursorPoint.getX(), (int) main.GraphicsEngine.cursorPoint.getY(), 250, 335);
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
		
		JLabel lblstCorner = new JLabel("1st Corner:");
		lblstCorner.setBounds(6, 69, 70, 16);
		contentPane.add(lblstCorner);
		
		JLabel label_3 = new JLabel("X:");
		label_3.setBounds(88, 69, 12, 16);
		contentPane.add(label_3);
		
		JSpinner xOfCorner1 = new JSpinner();
		xOfCorner1.setModel(new SpinnerNumberModel((int) main.GraphicsEngine.cursorPoint.getX(), 0, main.MainWindow.mainPanel.getWidth(), 1 ));
		xOfCorner1.setBounds(98, 63, 65, 28);
		contentPane.add(xOfCorner1);
		
		JLabel label_4 = new JLabel("Y:");
		label_4.setBounds(168, 69, 12, 16);
		contentPane.add(label_4);
		
		JSpinner yOfCorner1 = new JSpinner();
		yOfCorner1.setModel(new SpinnerNumberModel((int) main.GraphicsEngine.cursorPoint.getY(), 0, main.MainWindow.mainPanel.getHeight(), 1 ));
		yOfCorner1.setBounds(179, 63, 65, 28);
		contentPane.add(yOfCorner1);
		
		JSpinner yOfCorner2 = new JSpinner();
		yOfCorner2.setModel(new SpinnerNumberModel((int) main.GraphicsEngine.cursorPoint.getY()+100, 0, main.MainWindow.mainPanel.getHeight()+100, 1 ));
		yOfCorner2.setBounds(179, 89, 65, 28);
		contentPane.add(yOfCorner2);
		
		JLabel label_2 = new JLabel("Y:");
		label_2.setBounds(168, 95, 12, 16);
		contentPane.add(label_2);
		
		JSpinner xOfCorner2 = new JSpinner();
		xOfCorner2.setModel(new SpinnerNumberModel((int) main.GraphicsEngine.cursorPoint.getX()-70, -70, main.MainWindow.mainPanel.getWidth(), 1 ));
		xOfCorner2.setBounds(98, 89, 65, 28);
		contentPane.add(xOfCorner2);
		
		JLabel label_5 = new JLabel("X:");
		label_5.setBounds(88, 95, 12, 16);
		contentPane.add(label_5);
		
		JLabel lblndCorner = new JLabel("2nd Corner:");
		lblndCorner.setBounds(6, 95, 79, 16);
		contentPane.add(lblndCorner);
		
		JSpinner yOfCorner3 = new JSpinner();
		yOfCorner3.setModel(new SpinnerNumberModel((int) main.GraphicsEngine.cursorPoint.getY()+100, 0, main.MainWindow.mainPanel.getHeight()+100, 1 ));
		yOfCorner3.setBounds(179, 114, 65, 28);
		contentPane.add(yOfCorner3);
		
		JLabel label_6 = new JLabel("Y:");
		label_6.setBounds(168, 120, 12, 16);
		contentPane.add(label_6);
		
		JSpinner xOfCorner3 = new JSpinner();
		xOfCorner3.setModel(new SpinnerNumberModel((int) main.GraphicsEngine.cursorPoint.getX()+70, 0, main.MainWindow.mainPanel.getWidth()+70, 1 ));
		xOfCorner3.setBounds(98, 114, 65, 28);
		contentPane.add(xOfCorner3);
		
		JLabel label_7 = new JLabel("X:");
		label_7.setBounds(88, 120, 12, 16);
		contentPane.add(label_7);
		
		JLabel lblrdCorner = new JLabel("3rd Corner:");
		lblrdCorner.setBounds(6, 120, 79, 16);
		contentPane.add(lblrdCorner);
		
		JLabel label_8 = new JLabel("Color");
		label_8.setBounds(6, 148, 61, 16);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Border color:");
		label_9.setBounds(6, 169, 82, 16);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Fill color:");
		label_10.setBounds(6, 194, 82, 16);
		contentPane.add(label_10);
		
		JLabel fillColorLbl = new JLabel("");
		fillColorLbl.setOpaque(true);
		fillColorLbl.setBackground(Color.BLACK);
		fillColorLbl.setBounds(90, 195, 15, 15);
		contentPane.add(fillColorLbl);
		
		JLabel borderColorLbl = new JLabel("");
		borderColorLbl.setOpaque(true);
		borderColorLbl.setBackground(Color.BLACK);
		borderColorLbl.setBounds(90, 170, 15, 15);
		contentPane.add(borderColorLbl);
		
		JButton borderColorBtn = new JButton("Choose Color");
		borderColorBtn.addActionListener(new ActionListener() {
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
		borderColorBtn.setBounds(115, 164, 129, 29);
		contentPane.add(borderColorBtn);
		
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
		fillColorBtn.setBounds(115, 189, 129, 29);
		contentPane.add(fillColorBtn);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 216, 238, 12);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 140, 238, 12);
		contentPane.add(separator_2);
		
		JLabel label_13 = new JLabel("Priority:");
		label_13.setBounds(6, 228, 58, 16);
		contentPane.add(label_13);
		
		JSpinner priority = new JSpinner();
		priority.setModel(new SpinnerNumberModel(1, 1, 9999, 1));
		priority.setBounds(59, 222, 65, 28);
		contentPane.add(priority);
		
		JButton okBtn = new JButton("OK");
		okBtn.setIcon(main.MainWindow.okIcon);
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (((Number)priority.getValue()).intValue() == 1)
					new shapes.Triangle(name.getText(),
							((Number)((xOfCorner1).getValue())).intValue(),
							((Number)(yOfCorner1.getValue())).intValue(),
							((Number)((xOfCorner2).getValue())).intValue(),
							((Number)((yOfCorner2).getValue())).intValue(),
							((Number)((xOfCorner3).getValue())).intValue(),
							((Number)((yOfCorner3).getValue())).intValue(),
							borderColor,
							fillColor);

				else
					new shapes.Triangle(name.getText(),
							((Number)((xOfCorner1).getValue())).intValue(),
							((Number)(yOfCorner1.getValue())).intValue(),
							((Number)((xOfCorner2).getValue())).intValue(),
							((Number)((yOfCorner2).getValue())).intValue(),
							((Number)((xOfCorner3).getValue())).intValue(),
							((Number)((yOfCorner3).getValue())).intValue(),
							borderColor,
							fillColor,
							((Number)(priority.getValue())).intValue());				
				main.MainWindow.mainPanel.repaint();
				CloseFrame();
			}
		});
		okBtn.setBounds(6, 263, 238, 45);
		contentPane.add(okBtn);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 251, 238, 12);
		contentPane.add(separator_3);
	}
	public void CloseFrame()
	{
	    super.dispose();
	}
}
