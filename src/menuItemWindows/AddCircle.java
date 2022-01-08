package menuItemWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Color;

public class AddCircle extends JFrame {

	private static final long serialVersionUID = -7294008126482756556L;
	private JPanel contentPane;
	private JTextField txtNoName;
	Color borderColor = new Color(0,0,0);
	Color fillColor = new Color (0,0,0);

	public AddCircle() {
		setTitle("Add Circle");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((int) main.GraphicsEngine.cursorPoint.getX(), (int) main.GraphicsEngine.cursorPoint.getY(), 250, 320);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		txtNoName = new JTextField();
		txtNoName.setText("(NoName)");
		txtNoName.setColumns(10);
		txtNoName.setBounds(51, 6, 193, 28);
		contentPane.add(txtNoName);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 39, 238, 12);
		contentPane.add(separator);
		
		JLabel label = new JLabel("Name:");
		label.setBounds(6, 6, 47, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Location");
		label_1.setBounds(6, 46, 58, 16);
		contentPane.add(label_1);
		
		JLabel lblCenter = new JLabel("Center:");
		lblCenter.setBounds(6, 69, 58, 16);
		contentPane.add(lblCenter);
		
		int x = (int) main.GraphicsEngine.cursorPoint.getX();
		int y = (int) main.GraphicsEngine.cursorPoint.getY();
		
		JSpinner xOfCenter = new JSpinner();
		xOfCenter.setModel(new SpinnerNumberModel(x, 0, main.MainWindow.mainPanel.getWidth(), 1));
		xOfCenter.setBounds(86, 63, 65, 28);
		contentPane.add(xOfCenter);
		
		JLabel label_3 = new JLabel("X:");
		label_3.setBounds(76, 69, 12, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Y:");
		label_4.setBounds(168, 69, 12, 16);
		contentPane.add(label_4);
		
		JSpinner yOfCenter = new JSpinner();
		yOfCenter.setModel(new SpinnerNumberModel(y, 0, main.MainWindow.mainPanel.getHeight(), 1));
		yOfCenter.setBounds(179, 63, 65, 28);
		contentPane.add(yOfCenter);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 89, 238, 12);
		contentPane.add(separator_1);
		
		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setBounds(6, 103, 61, 16);
		contentPane.add(lblRadius);
		
		JSpinner Radius = new JSpinner();
		Radius.setModel(new SpinnerNumberModel(50, 20, 500, 1));
		Radius.setBounds(86, 97, 65, 28);
		contentPane.add(Radius);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 123, 238, 12);
		contentPane.add(separator_2);
		
		JLabel lblColor1 = new JLabel("");
		lblColor1.setOpaque(true);
		lblColor1.setBackground(Color.BLACK);
		lblColor1.setBounds(90, 153, 15, 15);
		contentPane.add(lblColor1);
		
		JButton button = new JButton("Choose Color");
		button.setBounds(115, 147, 129, 29);
		button.addActionListener(new ActionListener()
		{
			Color tmp = new Color(0,0,0);
			public void actionPerformed(ActionEvent e)
			{
				tmp = JColorChooser.showDialog(getParent(), "Choose a color", borderColor);
				if (tmp == null)
					tmp=new Color (borderColor.getRGB());
				else
					borderColor=new Color(tmp.getRGB());
				lblColor1.setBackground(borderColor);
			}
		});
		contentPane.add(button);
		
		JLabel lblBorderColor = new JLabel("Border color:");
		lblBorderColor.setBounds(6, 152, 82, 16);
		contentPane.add(lblBorderColor);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(6, 131, 61, 16);
		contentPane.add(lblColor);
		
		JLabel lblColor2 = new JLabel("");
		lblColor2.setOpaque(true);
		lblColor2.setBackground(Color.BLACK);
		lblColor2.setBounds(90, 178, 15, 15);
		contentPane.add(lblColor2);
		
		JButton button_1 = new JButton("Choose Color");
		button_1.addActionListener(new ActionListener() {
			Color tmp = new Color(0,0,0);
			public void actionPerformed(ActionEvent e)
			{
				tmp = JColorChooser.showDialog(getParent(), "Choose a color", fillColor);
				if (tmp == null)
					tmp=new Color (fillColor.getRGB());
				else
					fillColor=new Color(tmp.getRGB());
				lblColor2.setBackground(fillColor);
			}
		});
		button_1.setBounds(115, 172, 129, 29);
		contentPane.add(button_1);
		
		JLabel lblFillColor = new JLabel("Fill color     :");
		lblFillColor.setBounds(6, 177, 82, 16);
		contentPane.add(lblFillColor);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 199, 238, 12);
		contentPane.add(separator_3);
		
		JLabel label_2 = new JLabel("Priority:");
		label_2.setBounds(6, 211, 58, 16);
		contentPane.add(label_2);
		
		JSpinner priority = new JSpinner();
		priority.setModel(new SpinnerNumberModel(1, 1, 9999, 1));
		priority.setBounds(59, 205, 65, 28);
		contentPane.add(priority);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(6, 234, 238, 12);
		contentPane.add(separator_4);
		
		JButton button_2 = new JButton("OK");
		button_2.setIcon(main.MainWindow.okIcon);
		button_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (((Number)priority.getValue()).intValue() == 1)
					new shapes.Circle(txtNoName.getText(), ((Number)(xOfCenter.getValue())).intValue(), ((Number)(yOfCenter.getValue())).intValue(),((Number)(Radius.getValue())).intValue(), borderColor, fillColor);
				else
					new shapes.Circle(txtNoName.getText(), ((Number)(xOfCenter.getValue())).intValue(), ((Number)(yOfCenter.getValue())).intValue(),((Number)(Radius.getValue())).intValue(), borderColor, fillColor, ((Number)(priority.getValue())).intValue());
				
				main.MainWindow.mainPanel.repaint();
				CloseFrame();
			}
		});
		button_2.setBounds(6, 246, 238, 45);
		contentPane.add(button_2);
	}
	public void CloseFrame()
	{
	    super.dispose();
	}
}
