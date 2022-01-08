package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Performer
{
	static boolean isErrorFound=false;
	public Performer(File file) throws FileNotFoundException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
		    String line;
		    while ((line = br.readLine()) != null)
		    {
		    	Progress.apply(line);
		    }
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		if (isErrorFound)
		{
			//Frame[] frames = main.MainWindow.getFrames();
			JOptionPane.showMessageDialog(main.MainWindow.mainPanel, "Commands did not performed successfully.", "Invalid Command Found", JOptionPane.PLAIN_MESSAGE, main.GraphicsEngine.failureIcon);
			isErrorFound=false;
		}
		else
		{
			JOptionPane.showMessageDialog(main.MainWindow.mainPanel, "Commands performed successfully.", "Commands Performed", JOptionPane.PLAIN_MESSAGE, main.GraphicsEngine.successIcon);
		}
		main.MainWindow.mainPanel.repaint();
		main.MainWindow.mainPanel.requestFocus();

	}
}
