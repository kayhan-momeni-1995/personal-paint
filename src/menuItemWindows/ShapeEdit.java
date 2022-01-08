package menuItemWindows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import shapes.Shape;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShapeEdit extends JFrame
{
	private static final long serialVersionUID = 6095736955244159140L;
	private JPanel contentPane;
	static Shape shape =null;
	private JTextField name;
	Color borderColor;
	Color fillColor;

	public ShapeEdit(Shape s)
	{
		shape=s;
		borderColor = new Color(shape.getBorderColor().getRGB());
		fillColor   = new Color(shape.getFillColor().getRGB());
		
		setTitle("Edit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((int) main.GraphicsEngine.cursorPoint.getX(), (int) main.GraphicsEngine.cursorPoint.getY(), 250, 335);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 12, 40, 16);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(92, 6, 152, 28);
		name.setText(shape.getName());
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(6, 46, 61, 16);
		contentPane.add(lblLocation);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(82, 46, 12, 16);
		contentPane.add(lblX);
		
		JSpinner xOfLocation = new JSpinner();
		xOfLocation.setModel(new SpinnerNumberModel((int)shape.getCenter().getX(), null, null, 1 ));
		xOfLocation.setBounds(92, 40, 65, 28);
		contentPane.add(xOfLocation);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(169, 46, 12, 16);
		contentPane.add(lblY);
		
		JSpinner yOfLocation = new JSpinner();
		yOfLocation.setModel(new SpinnerNumberModel((int)shape.getCenter().getY(), null, null, 1));
		yOfLocation.setBounds(179, 40, 65, 28);
		contentPane.add(yOfLocation);
		
		JLabel label = new JLabel("Color");
		label.setBounds(6, 80, 61, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Border color:");
		label_1.setBounds(6, 101, 82, 16);
		contentPane.add(label_1);
		
		JLabel borderColorLbl = new JLabel("");
		borderColorLbl.setOpaque(true);
		borderColorLbl.setBackground(shape.getBorderColor());
		borderColorLbl.setBounds(92, 101, 15, 15);
		contentPane.add(borderColorLbl);
		
		JLabel fillColorLbl = new JLabel("");
		fillColorLbl.setOpaque(true);
		fillColorLbl.setBackground(shape.getFillColor());
		fillColorLbl.setBounds(92, 127, 15, 15);
		if (shape.getType()<=1)
			fillColorLbl.setBackground((Color)null);
		contentPane.add(fillColorLbl);
		
		JButton borderColorBtn = new JButton("Choose Color");
		borderColorBtn.addActionListener(new ActionListener() {
			Color tmp = new Color(borderColor.getRGB());
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
		borderColorBtn.setBounds(115, 96, 129, 29);			
		contentPane.add(borderColorBtn);
		
		JLabel label_3 = new JLabel("Fill color:");
		label_3.setBounds(6, 126, 82, 16);
		contentPane.add(label_3);
		
		JButton fillColorBtn = new JButton("Choose Color");
		fillColorBtn.addActionListener(new ActionListener() {
			Color tmp = new Color(fillColor.getRGB());
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
		fillColorBtn.setBounds(115, 121, 129, 29);
		if (shape.getType()<=1)
			fillColorBtn.setEnabled(false);
		contentPane.add(fillColorBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 66, 238, 12);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 29, 238, 12);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 148, 238, 12);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel = new JLabel("Priority:");
		lblNewLabel.setBounds(6, 168, 49, 16);
		contentPane.add(lblNewLabel);
		
		JSpinner priority = new JSpinner();
		priority.setModel(new SpinnerNumberModel(shape.getPriority(), 1, 9999, 1));
		priority.setBounds(92, 162, 65, 28);
		contentPane.add(priority);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 191, 238, 12);
		contentPane.add(separator_3);
		
		JLabel lblScaledegree = new JLabel("Rotate(deg):");
		lblScaledegree.setBounds(6, 208, 75, 16);
		contentPane.add(lblScaledegree);
		
		JSpinner rotate = new JSpinner();
		rotate.setModel(new SpinnerNumberModel(0, -360, 360, 1));
		rotate.setBounds(92, 202, 65, 28);
		contentPane.add(rotate);
		
		JLabel lblScale = new JLabel("Scale:");
		lblScale.setBounds(6, 236, 40, 16);
		contentPane.add(lblScale);
		
		JSpinner scale = new JSpinner();
		scale.setModel(new SpinnerNumberModel(1, 0.01, 100, 0.01));
		scale.setBounds(92, 230, 65, 28);
		contentPane.add(scale);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(6, 256, 238, 12);
		contentPane.add(separator_4);
		
		JButton okBtn = new JButton("OK");
		okBtn.setIcon(main.MainWindow.okIcon);
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				shape.setName(name.getText());
				shape.setCenter(((Number)(xOfLocation.getValue())).intValue(),
						((Number)(yOfLocation.getValue())).intValue());
				shape.setBorderColor(borderColor);
				shape.setFillColor(fillColor);
				shape.setPriority(((Number)(priority.getValue())).intValue());
				shape.rotate(((Number)(rotate.getValue())).intValue());
				if (shape.getType()>1)
					shape.scale(Math.sqrt(((Number)(scale.getValue())).doubleValue()));
				else
					shape.scale(((Number)(scale.getValue())).doubleValue());
				
				main.MainWindow.mainPanel.repaint();
				CloseFrame();
			}
		});
		okBtn.setBounds(6, 264, 238, 45);
		contentPane.add(okBtn);
		
		JLabel lblX_1 = new JLabel("X");
		lblX_1.setBounds(82, 236, 12, 16);
		contentPane.add(lblX_1);
	}
	public void CloseFrame()
	{
	    super.dispose();
	}
}
