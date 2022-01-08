package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

import group.Group;
import popupMenus.AddItems;
import popupMenus.GroupPopupMenu;
import popupMenus.ShapePopupMenu;
import shapes.Shape;


public class GraphicsEngine extends JPanel
{
	private static final long serialVersionUID = -4549213858915766718L;
	
	public static ImageIcon successIcon = new ImageIcon("tick.png");
	public static ImageIcon failureIcon = new ImageIcon("cross.png");
	public static ImageIcon warningIcon = new ImageIcon("warning.png");

	public PaintListener listener = new PaintListener();
	Point prvPoint=null;
	public static Point cursorPoint = null;
	private boolean ctrlIsDown = false;
	private boolean rIsDown = false;
	private boolean plusIsDown=false;
	private boolean minusIsDown=false;
	private boolean shiftIsDown=false;
	public ArrayList<Shape> currentSelectedShapes = new ArrayList<Shape>();
	public Shape theUppest = null;
	GraphicsEngine g=null;
	public Point rightClick = new Point();
	public GraphicsEngine()
	{
		addMouseListener(listener);
		addMouseMotionListener(listener);
		setFocusable(true);
		addKeyListener(listener);
		addFocusListener(listener);
		g=this;
	}
	
	public void paintComponent(Graphics G)
	{
		super.paintComponent(G);
		Render(G);
	}
	public void Render(Graphics G)
	{
		G.setColor(new Color(255,255,255));
		G.fillRect(0, 0, this.getWidth(), this.getHeight());
		G.setColor(Color.BLACK);
		G.drawRect(0, 0, this.getWidth(), this.getHeight());
		////////////////////////////
		Iterator<Shape> it = Shape.allShapes.iterator();
		while (it.hasNext())
		{
			it.next().Render(G);
		}
		///////////////////////////
		G.setColor(Color.darkGray);
		if (cursorPoint == null)
			G.drawString("Cursor location: Null", 5, this.getHeight()-7);
		else
			G.drawString("Cursor location: (" + cursorPoint.getX() + "," + cursorPoint.getY() + ")", 5, this.getHeight()-7);
	}
	public Shape theUppestShapeUnderAPoint(Point p)
	{
		Shape s=null;
		for (int i=Shape.allShapes.size()-1; i>=0; i--)
		{
			if (Shape.allShapes.get(i).isIn(p))
			{
				s=Shape.allShapes.get(i);
				break;
			}
		}
		return s;
	}
	class PaintListener implements MouseListener, MouseMotionListener, KeyListener, FocusListener
	{
		@Override
		public void mouseDragged(MouseEvent e)
		{
			cursorPoint = new Point (e.getPoint());
			Point currentPoint = new Point (e.getPoint());
			int difX, difY;
			difX=(int) (currentPoint.getX()-prvPoint.getX());
			difY=(int) (currentPoint.getY()-prvPoint.getY());
			prvPoint = new Point(currentPoint);

			if (theUppest!=null)
			{
				Shape.clearOfSelections();
				currentSelectedShapes.clear();
			
				theUppest.setSelected(true);
				currentSelectedShapes.add(theUppest);
				Iterator<Shape> it = theUppest.getGroup().getList().iterator();
				while(it.hasNext())
				{
					Shape tmp = it.next();
					tmp.setSelected(true);
					currentSelectedShapes.add(tmp);
					tmp.moveCenter(difX, difY);
				}
			}
			else
			{
				Shape.clearOfSelections();
				currentSelectedShapes.clear();
			}

			repaint();
		}
	
		@Override
		public void mouseMoved(MouseEvent e)
		{			
			cursorPoint = new Point (e.getPoint());
			Shape.clearOfBolds();
			Shape s=theUppestShapeUnderAPoint(e.getPoint());
			if (s != null)
			{
				s.setBold(true);
				Iterator<Shape> it=s.getGroup().getList().iterator();
				while(it.hasNext())
					it.next().setBold(true);
			}
			prvPoint = new Point(e.getPoint());
			repaint();
		}

		@Override
		public void mouseClicked(MouseEvent e)
		{
			main.MainWindow.mainPanel.requestFocus();
			cursorPoint = new Point (e.getPoint());
			theUppest=theUppestShapeUnderAPoint(e.getPoint());
			
			if (e.getButton()==MouseEvent.BUTTON1)
			{
				if (theUppest==null)
				{
					if (!ctrlIsDown)
					{
						Shape.clearOfSelections();
						currentSelectedShapes.clear();
					}
				}
				else
				{
					if (ctrlIsDown)
					{
						if (theUppest.isSelected())
						{
							theUppest.setSelected(false);
							currentSelectedShapes.remove(theUppest);
							theUppest.setGroup(new Group());
						}
						else
						{
							theUppest.setSelected(true);
							currentSelectedShapes.add(theUppest);
							Iterator<Shape> it = currentSelectedShapes.iterator();
							while (it.hasNext())
								it.next().setGroup(theUppest.getGroup());
						}
					}
					else
					{
						if (theUppest.isSelected())
						{
							Shape.clearOfSelections();
							currentSelectedShapes.clear();
							theUppest.setSelected(false);
						}
						else
						{
							Shape.clearOfSelections();
							currentSelectedShapes.clear();
						
							theUppest.setSelected(true);
							currentSelectedShapes.add(theUppest);
							Iterator<Shape> it = theUppest.getGroup().getList().iterator();
							while(it.hasNext())
							{
								Shape tmp = it.next();
								tmp.setSelected(true);
								currentSelectedShapes.add(tmp);
							}
						}
					}
				}
			}
			else if (e.getButton()==MouseEvent.BUTTON3)
			{
				rightClick = new Point(e.getPoint());
				if (theUppest==null)
				{
					Shape.clearOfSelections();
					currentSelectedShapes.clear();
					
					AddItems popup = new AddItems();
					popup.show(getParent(), e.getX(), e.getY());
				}
				else
				{
					if (!ctrlIsDown)
					{
						Shape.clearOfSelections();
						currentSelectedShapes.clear();
					
						theUppest.setSelected(true);
						currentSelectedShapes.add(theUppest);
												
						ShapePopupMenu popup = new ShapePopupMenu(theUppest);
						popup.show(getParent(), e.getX(), e.getY());
						
						repaint();
					}
					else
					{
						GroupPopupMenu popup = new GroupPopupMenu(theUppest);
						popup.show(getParent(), e.getX(), e.getY());
						
						repaint();
					}
				}
				prvPoint = new Point(e.getPoint());
			}
			repaint();
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			cursorPoint = new Point (e.getPoint());
			theUppest=theUppestShapeUnderAPoint(e.getPoint());
			prvPoint=new Point (e.getPoint());
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{		
			cursorPoint = new Point (e.getPoint());
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{			
		}

		@Override
		public void mouseExited(MouseEvent e)
		{			
		}

		@Override
		public void keyTyped(KeyEvent e)
		{

		}

		@SuppressWarnings("deprecation")
		@Override
		public void keyPressed(KeyEvent e)
		{
			if (e.getKeyCode()==KeyEvent.VK_CONTROL || e.getKeyCode()==157)
				ctrlIsDown=true;
			
			if (e.getKeyCode()==KeyEvent.VK_SHIFT)
				shiftIsDown=true;
			
			if (e.getKeyCode()==KeyEvent.VK_R)
			{
				rIsDown=true;
				if (ctrlIsDown && !shiftIsDown)
				{
					Timer rotator = new Timer(200, null);
					rotator.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e)
						{
							Iterator<Shape> it = currentSelectedShapes.iterator();
							while (it.hasNext())
							{
								it.next().rotate(2);
							}
							repaint();
							if (!rIsDown)
								rotator.stop();
						}
					});
					rotator.start();
				}
				if (ctrlIsDown && shiftIsDown)
				{
					Timer rotator = new Timer(200, null);
					rotator.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e)
						{
							Iterator<Shape> it = currentSelectedShapes.iterator();
							while (it.hasNext())
							{
								it.next().rotate(-2);
							}
							repaint();
							if (!rIsDown)
								rotator.stop();
						}
					});
					rotator.start();
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_EQUALS || e.getKeyCode()==KeyEvent.VK_PLUS)
			{
				plusIsDown=true;
				if (ctrlIsDown)
				{
					Timer zoomInner = new Timer(150, null);
					zoomInner.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e)
						{
							Iterator<Shape> it = currentSelectedShapes.iterator();
							while (it.hasNext())
							{
								it.next().scale(1.03);
							}
							repaint();
							if (!plusIsDown)
								zoomInner.stop();
						}
					});
					zoomInner.start();
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_MINUS)
			{
				minusIsDown=true;
				if (ctrlIsDown)
				{
					Timer zoomOuter = new Timer(150, null);
					zoomOuter.addActionListener(new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e)
						{
							Iterator<Shape> it = currentSelectedShapes.iterator();
							while (it.hasNext())
							{
								it.next().scale(0.97087);
							}
							repaint();
							if (!minusIsDown)
								zoomOuter.stop();
						}
					});
					zoomOuter.start();
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_C)
			{
				if (currentSelectedShapes.size()>0 && ctrlIsDown)
				{
					clipBoard.Copy.setGroupToClipboard(currentSelectedShapes.get(0).getGroup());
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_X)
			{
				if (currentSelectedShapes.size()>0 && ctrlIsDown)
				{
					clipBoard.Cut.setGroupToClipboard(currentSelectedShapes.get(0).getGroup());
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_V)
			{
				if (ctrlIsDown)
				{
					clipBoard.Paste.setDataToTheSheet(main.MainWindow.mainPanel.getMousePosition());
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_D)
			{
				if (currentSelectedShapes.size()>0 && ctrlIsDown)
				{
					Group group=currentSelectedShapes.get(0).getGroup();
					while (group.getSize()>0)
						group.getList().get(0).destroy();
					repaint();
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_H)
			{
				if (ctrlIsDown)
				{
					menuItemWindows.Help help = new menuItemWindows.Help();
					help.show();
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_S)
			{
				if (ctrlIsDown)
				{
					if (Shape.allShapes.size()==0)
						JOptionPane.showMessageDialog(MainWindow.mainPanel, "The Sheet Is Empty.", "SAVE ERROR", JOptionPane.ERROR_MESSAGE);
					else
					{
						JFileChooser fc = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Sheet files", "sheet");
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
						}
					}
				}
			}
			if (e.getKeyCode()==KeyEvent.VK_L)
			{
				if (ctrlIsDown)
				{
					JFileChooser fc = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter(
				            "Sheet files", "sheet");
				    fc.setFileFilter(filter);
				    fc.setApproveButtonText("Load");
				    fc.setAcceptAllFileFilterUsed(false);
				    //fc.addChoosableFileFilter
					int returnVal = fc.showOpenDialog(main.MainWindow.mainPanel);
					if (returnVal==0)
					{
						File file = fc.getSelectedFile();
						serializer.Load.loadFile(file);
					}
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			if (e.getKeyCode()==KeyEvent.VK_CONTROL || e.getKeyCode()==157)
				ctrlIsDown=false;
			if (e.getKeyCode()==KeyEvent.VK_R)
				rIsDown=false;
			if (e.getKeyCode()==KeyEvent.VK_EQUALS || e.getKeyCode()==KeyEvent.VK_PLUS)
				plusIsDown=false;
			if (e.getKeyCode()==KeyEvent.VK_MINUS)
				minusIsDown=false;
			if (e.getKeyCode()==KeyEvent.VK_SHIFT)
				shiftIsDown=false;
			
		}

		@Override
		public void focusGained(FocusEvent e)
		{
		}

		@Override
		public void focusLost(FocusEvent e)
		{
			ctrlIsDown=false;
			rIsDown=false;
			plusIsDown=false;
			minusIsDown=false;
			shiftIsDown=false;
			//System.out.println("Lost");
		}
	}
}
