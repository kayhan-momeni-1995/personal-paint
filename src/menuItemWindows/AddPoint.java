package menuItemWindows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPoint extends JFrame
{
	private static final long serialVersionUID = 8221111086233321674L;
	private JPanel contentPane;
	private JTextField txtNoName;
	Color color = new Color(0,0,0);
	JSpinner CenterX;
	JSpinner CenterY;

	public AddPoint()
	{
		setTitle("Add Point");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((int) main.GraphicsEngine.cursorPoint.getX(), (int) main.GraphicsEngine.cursorPoint.getY(), 250, 215);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(6, 46, 58, 16);
		contentPane.add(lblLocation);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(231, 6, 1, 12);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 30, 238, 16);
		contentPane.add(separator_1);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(76, 46, 12, 16);
		contentPane.add(lblX);
		
		color = new Color(0,0,0);
		int x = (int) main.GraphicsEngine.cursorPoint.getX();
		int y = (int) main.GraphicsEngine.cursorPoint.getY();
		SpinnerNumberModel model1 = new SpinnerNumberModel(x, 0, main.MainWindow.mainPanel.getWidth(), 1);  
		SpinnerNumberModel model2 = new SpinnerNumberModel(y, 0, main.MainWindow.mainPanel.getHeight(), 1);  

		CenterX = new JSpinner();
		CenterX.setBounds(86, 40, 65, 28);
		CenterX.setModel(model1);
		contentPane.add(CenterX);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(168, 46, 12, 16);
		contentPane.add(lblY);
		
		CenterY = new JSpinner();
		CenterY.setBounds(179, 40, 65, 28);
		CenterY.setModel(model2);
		contentPane.add(CenterY);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 6, 47, 28);
		contentPane.add(lblName);
		
		txtNoName = new JTextField();
		txtNoName.setText("(NoName)");
		txtNoName.setBounds(51, 6, 193, 28);
		contentPane.add(txtNoName);
		txtNoName.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 74, 238, 12);
		contentPane.add(separator_2);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(6, 87, 38, 16);
		contentPane.add(lblColor);
		
		JLabel colorLbl = new JLabel("");
		colorLbl.setBackground(Color.BLACK);
		colorLbl.setBounds(49, 88, 15, 15);
		colorLbl.setOpaque(true);
		contentPane.add(colorLbl);
		
		JButton btnChooseColor = new JButton("Choose Color");
		btnChooseColor.addActionListener(new ActionListener()
		{
			Color tmp = new Color(0,0,0);
			public void actionPerformed(ActionEvent e)
			{
				tmp = JColorChooser.showDialog(getParent(), "Choose a color", color);
				if (tmp == null)
					tmp=new Color (color.getRGB());
				else
					color=new Color(tmp.getRGB());
				colorLbl.setBackground(color);
			}
		});
		btnChooseColor.setBounds(76, 82, 168, 29);
		contentPane.add(btnChooseColor);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 104, 238, 12);
		contentPane.add(separator_3);
		
		JLabel lblPriority = new JLabel("Priority:");
		lblPriority.setBounds(6, 115, 58, 16);
		contentPane.add(lblPriority);
		
		SpinnerNumberModel model3 = new SpinnerNumberModel(1, 1, 9999, 1);  
		JSpinner priority = new JSpinner();
		priority.setBounds(59, 109, 65, 28);
		priority.setModel(model3);
		contentPane.add(priority);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(6, 132, 238, 12);
		contentPane.add(separator_4);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(6, 143, 238, 45);
		btnOk.setIcon(main.MainWindow.okIcon);
		contentPane.add(btnOk);
		btnOk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (((Number)priority.getValue()).intValue() == 1)
					new shapes.Dot(txtNoName.getText(), ((Number)(CenterX.getValue())).intValue(), ((Number)(CenterY.getValue())).intValue(), color);
				else
					new shapes.Dot(txtNoName.getText(), ((Number)(CenterX.getValue())).intValue(), ((Number)(CenterY.getValue())).intValue(), color, ((Number)(priority.getValue())).intValue());
				
				main.MainWindow.mainPanel.repaint();
				CloseFrame();
			}
		});
	}
	public void CloseFrame()
	{
	    super.dispose();
	}
}
