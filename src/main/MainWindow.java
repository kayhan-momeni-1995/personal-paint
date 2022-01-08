package main;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import shapes.Shape;

public class MainWindow
{
	public static GraphicsEngine mainPanel=null;
	private static JPanel contentPane;
	public static ImageIcon saveIcon = new ImageIcon("save.png");
	public static ImageIcon loadIcon = new ImageIcon("load.png");
	public static ImageIcon polygonIcon = new ImageIcon("polygon.png");
	public static ImageIcon okIcon = new ImageIcon("ok.png");

	public static void main(String[] args)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight()-104;

		JFrame mainWindow = new JFrame("AP Project");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setResizable(false);
		mainWindow.setBounds(0, 0, (int)width, (int)height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainWindow.setContentPane(contentPane);
		mainWindow.setIconImage(polygonIcon.getImage());
		contentPane.setLayout(null);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(6, (int)height-76, (int)width-12, 12);
		contentPane.add(separator1);
		
		mainPanel = new GraphicsEngine();
		mainPanel.setBounds(6, 17, (int)width-12, (int)height - 91);
		contentPane.add(mainPanel);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(6, 6, (int)width-12, 12);
		contentPane.add(separator2);
		
		JPanel subPanel = new JPanel();
		subPanel.setBounds(6, (int)height-70, (int)width-12, 45);
		contentPane.add(subPanel);
		subPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton save = new JButton("Save");
		save.setIcon(saveIcon);
		subPanel.add(save);
		save.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{		
				if (Shape.allShapes.size()==0)
					JOptionPane.showMessageDialog(MainWindow.mainPanel, "The Sheet Is Empty.", "SAVING ERROR", JOptionPane.PLAIN_MESSAGE, main.GraphicsEngine.failureIcon);
				else
				{
					JFileChooser fc = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Sheet file", "sheet");
					fc.setFileFilter(filter);
					fc.setAcceptAllFileFilterUsed(false);
					int returnVal = fc.showSaveDialog(main.MainWindow.mainPanel);
					if (returnVal==0)
					{
						File file = fc.getSelectedFile();
						String file_name = file.toString();
						if (!file_name.endsWith(".sheet"))
							file_name += ".sheet";
						serializer.Save.saveTo(new File(file_name));
						JOptionPane.showMessageDialog(main.MainWindow.mainPanel, "Sheet saved successfully.", "Sheet saved", JOptionPane.PLAIN_MESSAGE, main.GraphicsEngine.successIcon);
					}
					mainPanel.requestFocus();
				}
			}
		});
		
		JButton load = new JButton("Load");
		load.setIcon(loadIcon);
		subPanel.add(load);
		load.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{			
				JFileChooser fc = new JFileChooser();
			    FileNameExtensionFilter filter1 = new FileNameExtensionFilter(
			            "Sheet file", "sheet");
			    fc.addChoosableFileFilter(filter1);
			    FileNameExtensionFilter filter2 = new FileNameExtensionFilter(
			            "Commands file", "txt");
			    fc.addChoosableFileFilter(filter2);
			    fc.setApproveButtonText("Load");
			    fc.setAcceptAllFileFilterUsed(false);
			    //fc.addChoosableFileFilter
				int returnVal = fc.showOpenDialog(main.MainWindow.mainPanel);
				if (returnVal==0)
				{
					File file = fc.getSelectedFile();
					if (file.getAbsolutePath().endsWith("sheet"))
					{
						serializer.Load.loadFile(file);
						JOptionPane.showMessageDialog(main.MainWindow.mainPanel, "Sheet loaded successfully.", "Sheet loaded", JOptionPane.PLAIN_MESSAGE, main.GraphicsEngine.successIcon);
					}
					else if (file.getAbsolutePath().endsWith("txt"))
					{
						try
						{
							new commands.Performer(file);
						}
						catch (FileNotFoundException e1)
						{
							e1.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(main.MainWindow.mainPanel, "Sheet has not been loaded successfully.", "LOADING ERROR", JOptionPane.PLAIN_MESSAGE, main.GraphicsEngine.failureIcon);
					}
				}
				mainPanel.requestFocus();
			}
		});
		
		mainWindow.setVisible(true);
	}
}
