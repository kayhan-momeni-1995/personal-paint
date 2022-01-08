package menuItemWindows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import group.Group;
import shapes.Shape;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import java.util.Iterator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GroupDetails extends JFrame
{
	private static final long serialVersionUID = 833425647832892001L;
	private JPanel contentPane;

	public GroupDetails(Shape theUppest)
	{
		Group group = theUppest.getGroup();
		setTitle("Details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds((int) main.GraphicsEngine.cursorPoint.getX(), (int) main.GraphicsEngine.cursorPoint.getY(), 250, 340);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		Iterator<Shape> it = group.getList().iterator();
		int dot=0;
		int line=0;
		int circle=0;
		int rectangle=0;
		int triangle=0;
		int polygon=0;
		int total=0;
		Shape tmp;
		while (it.hasNext())
		{
			tmp=it.next();
			switch (tmp.getType())
			{
				case 0:
					dot++;
					total++;
					break;
				case 1:
					line++;
					total++;
					break;
				case 2:
					circle++;
					total++;
					break;
				case 3:
					rectangle++;
					total++;
					break;
				case 4:
					triangle++;
					total++;
					break;
				case 5:
					polygon++;
					total++;
					break;
			}
		}
		JLabel lblNumberOfShapes = new JLabel("Number Of Shapes:");
		lblNumberOfShapes.setBounds(6, 41, 121, 16);
		contentPane.add(lblNumberOfShapes);
		
		JLabel lblPoints = new JLabel("Point(s):");
		lblPoints.setBounds(6, 69, 51, 16);
		contentPane.add(lblPoints);
		
		JLabel lblLines = new JLabel("Line(s):");
		lblLines.setBounds(6, 97, 51, 16);
		contentPane.add(lblLines);
		
		JLabel lblCircles = new JLabel("Circle(s):");
		lblCircles.setBounds(6, 125, 61, 16);
		contentPane.add(lblCircles);
		
		JLabel lblNewLabel = new JLabel("Rectangle(s):");
		lblNewLabel.setBounds(6, 153, 80, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblTriangles = new JLabel("Triangle(s):");
		lblTriangles.setBounds(6, 181, 70, 16);
		contentPane.add(lblTriangles);
		
		JLabel lblPolygons = new JLabel("Polygon(s):");
		lblPolygons.setBounds(6, 209, 80, 16);
		contentPane.add(lblPolygons);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 226, 238, 12);
		contentPane.add(separator_1);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(6, 237, 36, 16);
		contentPane.add(lblTotal);
		
		JButton okBtn = new JButton("OK");
		okBtn.setIcon(main.MainWindow.okIcon);
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
			}
		});
		okBtn.setBounds(6, 265, 238, 45);
		contentPane.add(okBtn);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(6, 256, 238, 12);
		contentPane.add(separator_2);
		
		JLabel rectangleLbl = new JLabel("New label");
		rectangleLbl.setText(Integer.toString(rectangle));
		rectangleLbl.setBounds(98, 153, 146, 16);
		contentPane.add(rectangleLbl);
		
		JLabel pointLbl = new JLabel("New label");
		pointLbl.setText(Integer.toString(dot));
		pointLbl.setBounds(98, 69, 146, 16);
		contentPane.add(pointLbl);
		
		JLabel lineLbl = new JLabel("New label");
		lineLbl.setText(Integer.toString(line));
		lineLbl.setBounds(98, 97, 146, 16);
		contentPane.add(lineLbl);
		
		JLabel circleLbl = new JLabel("New label");
		circleLbl.setText(Integer.toString(circle));
		circleLbl.setBounds(98, 125, 146, 16);
		contentPane.add(circleLbl);
		
		JLabel triangleLbl = new JLabel("New label");
		triangleLbl.setText(Integer.toString(triangle));
		triangleLbl.setBounds(98, 181, 146, 16);
		contentPane.add(triangleLbl);
		
		JLabel polygonLbl = new JLabel("New label");
		polygonLbl.setText(Integer.toString(polygon));
		polygonLbl.setBounds(98, 209, 146, 16);
		contentPane.add(polygonLbl);
		
		JLabel totalLbl = new JLabel("New label");
		totalLbl.setText(Integer.toString(total));
		totalLbl.setBounds(98, 237, 146, 16);
		contentPane.add(totalLbl);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 6, 40, 16);
		contentPane.add(lblName);
		
		JLabel nameLbl = new JLabel("Null");
		if (group.getName().length()>0)
			nameLbl.setText(group.getName());
		nameLbl.setBounds(98, 6, 146, 16);
		contentPane.add(nameLbl);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(6, 34, 238, 12);
		contentPane.add(separator_3);
	}
	public void CloseFrame()
	{
	    super.dispose();
	}
}
