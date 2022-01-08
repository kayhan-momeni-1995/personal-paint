package menuItemWindows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import shapes.*;
import java.awt.event.ActionListener;
import java.awt.Point;
import java.awt.event.ActionEvent;

public class ShapeDetails extends JFrame
{
	private static final long serialVersionUID = 4334305494816284285L;
	private JPanel contentPane;

	public ShapeDetails(Shape shape)
	{
		setTitle("Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((int) main.GraphicsEngine.cursorPoint.getX(), (int) main.GraphicsEngine.cursorPoint.getY(), 270, 305);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 6, 40, 16);
		contentPane.add(lblName);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(6, 62, 63, 16);
		contentPane.add(lblLocation);
		
		JLabel lblFillColor = new JLabel("Fill color:");
		lblFillColor.setBounds(6, 90, 61, 16);
		contentPane.add(lblFillColor);
		
		JLabel lblNewLabel = new JLabel("Border color:");
		lblNewLabel.setBounds(6, 118, 80, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setBounds(6, 146, 32, 16);
		contentPane.add(lblArea);
		
		JLabel lblLengthforLines = new JLabel("Length:");
		if (shape.getType()==2)
			lblLengthforLines.setText("Radius: ");
		if (shape.getType()==3 || shape.getType()==4)
			lblLengthforLines.setText("Lengths: ");
		lblLengthforLines.setBounds(6, 176, 63, 16);
		contentPane.add(lblLengthforLines);
		
		JLabel lblPriority = new JLabel("Priority:");
		lblPriority.setBounds(6, 204, 49, 16);
		contentPane.add(lblPriority);
		
		JButton okBtn = new JButton("OK");
		okBtn.setIcon(main.MainWindow.okIcon);
		okBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				CloseFrame();
			}
		});
		okBtn.setBounds(6, 232, 258, 45);
		contentPane.add(okBtn);
		
		JLabel borderColorLbl = new JLabel("");
		borderColorLbl.setOpaque(true);
		borderColorLbl.setBackground(shape.getBorderColor());
		borderColorLbl.setBounds(98, 118, 166, 16);
		contentPane.add(borderColorLbl);
		
		JLabel nameLbl = new JLabel("<name>");
		nameLbl.setText(shape.getName());
		nameLbl.setBounds(98, 6, 166, 16);
		contentPane.add(nameLbl);
		
		
		int x = (int) shape.getCenter().getX();
		int y = (int) shape.getCenter().getY();
		JLabel locationLbl = new JLabel("<location>");
		locationLbl.setText("("+x+","+y+")");
		locationLbl.setBounds(98, 62, 166, 16);
		contentPane.add(locationLbl);
		
		JLabel fillColorLbl = new JLabel("");
		fillColorLbl.setOpaque(true);
		fillColorLbl.setBackground(shape.getFillColor());
		fillColorLbl.setBounds(98, 90, 166, 16);
		contentPane.add(fillColorLbl);
		
		JLabel areaLbl = new JLabel("Null");
		String area = Double.toString(shape.getArea());
		if (shape.getType()>1)
			areaLbl.setText(area);
		areaLbl.setBounds(98, 146, 166, 16);
		contentPane.add(areaLbl);
		
		JLabel lengthLbl = new JLabel("Null");
		if (shape.getType()==1)
		{
			String length = Double.toString(((Line)shape).getLenght());
			lengthLbl.setText(length);
		}
		if (shape.getType()==2)
		{
			String length = Integer.toString (((Circle)shape).getRadius());
			lengthLbl.setText(length);
		}
		if (shape.getType()==3)
		{
			String length = Integer.toString (((Rectangle)shape).getHeight());
			length+=" and ";
			length+= Integer.toString (((Rectangle)shape).getWidth());
			lengthLbl.setText(length);
		}
		if (shape.getType()==4)
		{
			Triangle tri = (Triangle)shape;
			int dist1 = (int) Point.distance(tri.getCorner1().getX(), tri.getCorner1().getY(),
										  tri.getCorner2().getX(), tri.getCorner2().getY());
			int dist2 = (int) Point.distance(tri.getCorner1().getX(), tri.getCorner1().getY(),
					  tri.getCorner3().getX(), tri.getCorner3().getY());
			int dist3 = (int) Point.distance(tri.getCorner3().getX(), tri.getCorner3().getY(),
					  tri.getCorner2().getX(), tri.getCorner2().getY());
			String length = Integer.toString (dist1);
			length+=" and ";
			length+= Integer.toString (dist2);
			length+=" and ";
			length+= Integer.toString (dist3);
			lengthLbl.setText(length);
		}
		if (shape.getType()==5)
		{
			Polygon pol = (Polygon)shape;
			lengthLbl.setText(Double.toString(pol.getL()));
		}
		lengthLbl.setBounds(98, 176, 166, 16);
		contentPane.add(lengthLbl);
		
		JLabel priorityLbl = new JLabel("<priority>");
		priorityLbl.setText(Integer.toString(shape.getPriority()));
		priorityLbl.setBounds(98, 204, 166, 16);
		contentPane.add(priorityLbl);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(6, 34, 40, 16);
		contentPane.add(lblType);
		
		JLabel typeLbl = new JLabel("Null");
		typeLbl.setBounds(98, 34, 166, 16);
		if (shape.getType()==0)
			typeLbl.setText("Point");
		else if (shape.getType()==1)
			typeLbl.setText("Line");
		else if (shape.getType()==2)
			typeLbl.setText("Circle");
		else if (shape.getType()==3)
			typeLbl.setText("Rectangle");
		else if (shape.getType()==4)
			typeLbl.setText("Triangle");
		else if (shape.getType()==5)
			typeLbl.setText("Polygon");
		contentPane.add(typeLbl);
	}
	public void CloseFrame()
	{
	    super.dispose();
	}
}
