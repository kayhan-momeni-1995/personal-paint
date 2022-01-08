package menuItemWindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class AddLine extends JFrame
{

	private static final long serialVersionUID = 4856068281360019057L;
	private JPanel contentPane;
	private JTextField txtNoName;
	Color color = new Color(0,0,0);

	public AddLine()
	{
		setTitle("Add Line");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((int) main.GraphicsEngine.cursorPoint.getX(), (int) main.GraphicsEngine.cursorPoint.getY(), 250, 265);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 6, 47, 28);
		contentPane.add(lblName);
		
		txtNoName = new JTextField();
		txtNoName.setText("(NoName)");
		txtNoName.setBounds(51, 6, 193, 28);
		contentPane.add(txtNoName);
		txtNoName.setColumns(10);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(6, 46, 58, 16);
		contentPane.add(lblLocation);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(231, 6, 1, 12);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 39, 238, 12);
		contentPane.add(separator_1);
		
		int x = (int) main.GraphicsEngine.cursorPoint.getX();
		int y = (int) main.GraphicsEngine.cursorPoint.getY();
		int otherX;
		if (x+100 <= main.MainWindow.mainPanel.getWidth())
			otherX=x+100;
		else
			otherX=x-100;
		
		JLabel lblStart = new JLabel("Start:");
		lblStart.setBounds(6, 69, 58, 16);
		contentPane.add(lblStart);
		
		SpinnerNumberModel model1 = new SpinnerNumberModel(x, 0, main.MainWindow.mainPanel.getWidth(), 1);  
		JSpinner xOfStart = new JSpinner();
		xOfStart.setModel(model1);
		xOfStart.setBounds(86, 63, 65, 28);
		contentPane.add(xOfStart);
		
		JLabel label_1 = new JLabel("X:");
		label_1.setBounds(76, 69, 12, 16);
		contentPane.add(label_1);
		
		SpinnerNumberModel model2 = new SpinnerNumberModel(y, 0, main.MainWindow.mainPanel.getHeight(), 1);  
		JSpinner yOfStart = new JSpinner();
		yOfStart.setModel(model2);
		yOfStart.setBounds(179, 63, 65, 28);
		contentPane.add(yOfStart);
		
		JLabel label_2 = new JLabel("Y:");
		label_2.setBounds(168, 69, 12, 16);
		contentPane.add(label_2);
		
		JLabel lblEnd = new JLabel("End  :");
		lblEnd.setBounds(6, 94, 58, 16);
		contentPane.add(lblEnd);
		
		SpinnerNumberModel model3 = new SpinnerNumberModel(otherX, 0, main.MainWindow.mainPanel.getWidth(), 1);  
		JSpinner xOfEnd = new JSpinner();
		xOfEnd.setModel(model3);
		xOfEnd.setBounds(86, 88, 65, 28);
		contentPane.add(xOfEnd);
		
		JLabel label_3 = new JLabel("X:");
		label_3.setBounds(76, 94, 12, 16);
		contentPane.add(label_3);
		
		SpinnerNumberModel model4 = new SpinnerNumberModel(y, 0, main.MainWindow.mainPanel.getHeight(), 1);  
		JSpinner yOfEnd = new JSpinner();
		yOfEnd.setModel(model4);
		yOfEnd.setBounds(179, 88, 65, 28);
		contentPane.add(yOfEnd);
		
		JLabel label_4 = new JLabel("Y:");
		label_4.setBounds(168, 94, 12, 16);
		contentPane.add(label_4);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 114, 238, 12);
		contentPane.add(separator_2);
		
		JLabel colorLbl = new JLabel("");
		colorLbl.setOpaque(true);
		colorLbl.setBackground(Color.BLACK);
		colorLbl.setBounds(49, 128, 15, 15);
		contentPane.add(colorLbl);
		
		JLabel label_5 = new JLabel("Color:");
		label_5.setBounds(6, 127, 38, 16);
		contentPane.add(label_5);
		
		JButton btnChooseColor = new JButton("Choose Color");
		btnChooseColor.setBounds(76, 122, 168, 29);
		btnChooseColor.addActionListener(new ActionListener() {
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
		contentPane.add(btnChooseColor);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 150, 238, 12);
		contentPane.add(separator_3);
		
		JLabel label = new JLabel("Priority:");
		label.setBounds(6, 161, 58, 16);
		contentPane.add(label);
		
		JSpinner priority = new JSpinner();
		priority.setBounds(59, 155, 65, 28);
		priority.setModel(new SpinnerNumberModel(1, 1, 9999, 1));
		contentPane.add(priority);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(6, 181, 238, 12);
		contentPane.add(separator_4);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(6, 193, 238, 45);
		btnOk.setIcon(main.MainWindow.okIcon);
		contentPane.add(btnOk);
		btnOk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (((Number)priority.getValue()).intValue() == 1)
					new shapes.Line(txtNoName.getText(), ((Number)(xOfStart.getValue())).intValue(), ((Number)(yOfStart.getValue())).intValue(), ((Number)(xOfEnd.getValue())).intValue(),((Number)(yOfEnd.getValue())).intValue(), color);
				else
					new shapes.Line(txtNoName.getText(), ((Number)(xOfStart.getValue())).intValue(), ((Number)(yOfStart.getValue())).intValue(), ((Number)(xOfEnd.getValue())).intValue(),((Number)(yOfEnd.getValue())).intValue(), color, ((Number)(priority.getValue())).intValue());
				
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
