package commands;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import group.Group;
import shapes.*;

public class Progress
{
	static void apply (String line)
	{
		String parameters = String.valueOf(line);
		if (!line.endsWith(";"))
		{
			error("; expected at the end of line: "+line);
			return;
		}
		if (line.indexOf(" ") <= 0)
		{
			error("Cannot determine any command at the line: "+line);
			return;
		}
		String command = line.substring(0,line.indexOf(" "));
		line = line.substring(line.indexOf(" ")+1);
		ArrayList<String> blocks = new ArrayList<String>();	
		
		if (command.equals("add") || command.equals("delete") || command.equals("scale") || command.equals("rotate") || command.equals("locate") ||
		command.equals("cut") || command.equals("paste") || command.equals("addToGroup") || command.equals("changeBorder") ||
		command.equals("disband") || command.equals("priority") || command.equals("changeFillColor") ||
		command.equals("deleteFromGroup") || command.equals("copy"))
		{
			for (; ; )
			{
				int i=line.indexOf(',');
				if (i != -1)
				{
					blocks.add(line.substring(0, line.indexOf(',')));
					line = line.substring(line.indexOf(',')+1);
				}
				else
				{
					blocks.add(line.substring(0, line.indexOf(';')));
					break;
				}
			}
			if (blocks.size()==0)
			{
				error("Input parameters");
				return;
			}
			if (command.equals("add"))
			{
				if (blocks.get(0).equals("Circle"))
				{
					if (blocks.size()==7 && isInteger(blocks.get(2)) && isInteger(blocks.get(3)) && isInteger(blocks.get(4)) 
					&& isColor(blocks.get(5)) && isColor(blocks.get(6)))
					{
							String name=blocks.get(1);
							int x=toInteger (blocks.get(2));
							int y=toInteger (blocks.get(3));
							int r=toInteger (blocks.get(4));
							Color borderColor=toColor(blocks.get(5));
							Color fillColor  =toColor(blocks.get(6));
							
							new Circle(name, x, y, r, borderColor, fillColor);
					}
					else if (blocks.size()==8 && isInteger(blocks.get(2)) && isInteger(blocks.get(3)) && isInteger(blocks.get(4)) 
					&& isColor(blocks.get(5)) && isColor(blocks.get(6)) && isInteger(blocks.get(7)))
					{
							String name=blocks.get(1);
							int x=toInteger (blocks.get(2));
							int y=toInteger (blocks.get(3));
							int r=toInteger (blocks.get(4));
							Color borderColor=toColor(blocks.get(5));
							Color fillColor  =toColor(blocks.get(6));
							int priority = toInteger(blocks.get(7));
							
							new Circle(name, x, y, r, borderColor, fillColor, priority);
					}
					else
					{
						error(parameters);
						return;
					}
					
				}
				else if (blocks.get(0).equals("Point"))
				{
					if (blocks.size()==5 && isInteger(blocks.get(2)) && isInteger(blocks.get(3)) && isColor(blocks.get(4)))
					{
						String name=blocks.get(1);
						int x=toInteger(blocks.get(2));
						int y=toInteger(blocks.get(3));
						Color borderColor = toColor(blocks.get(4));
						
						new Dot (name, x, y, borderColor);
					}
					else if (blocks.size()==6 && isInteger(blocks.get(2)) && isInteger(blocks.get(3)) && isColor(blocks.get(4)) && isInteger(blocks.get(5)))
					{
						String name=blocks.get(1);
						int x=toInteger(blocks.get(2));
						int y=toInteger(blocks.get(3));
						Color borderColor = toColor(blocks.get(4));
						int priority = toInteger(blocks.get(5));
						
						new Dot (name, x, y, borderColor, priority);
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else if (blocks.get(0).equals("Line"))
				{
					if (blocks.size()==7 && isInteger(blocks.get(2)) && isInteger(blocks.get(3)) && isInteger(blocks.get(4)) && isInteger(blocks.get(5))
					&& isColor(blocks.get(6)))
					{
						String name = blocks.get(1);
						int x1 = toInteger(blocks.get(2));
						int y1 = toInteger(blocks.get(3));
						int x2 = toInteger(blocks.get(4));
						int y2 = toInteger(blocks.get(5));
						Color borderColor = toColor(blocks.get(6));
						
						new Line(name, x1, y1, x2, y2, borderColor);
					}
					else if (blocks.size()==8 && isInteger(blocks.get(2)) && isInteger(blocks.get(3)) && isInteger(blocks.get(4)) && isInteger(blocks.get(5))
					&& isColor(blocks.get(6)) && isInteger(blocks.get(7)))
					{
						String name = blocks.get(1);
						int x1 = toInteger(blocks.get(2));
						int y1 = toInteger(blocks.get(3));
						int x2 = toInteger(blocks.get(4));
						int y2 = toInteger(blocks.get(5));
						Color borderColor = toColor(blocks.get(6));
						int priority = toInteger(blocks.get(7));
						new Line(name, x1, y1, x2, y2, borderColor, priority);
					}
					else
					{
						error(parameters);
						return;
					}
					
				}
				else if (blocks.get(0).equals("Polygon"))
				{
					if (blocks.size()==8 && isInteger(blocks.get(1)) && isInteger(blocks.get(3)) && isInteger(blocks.get(4)) && isInteger(blocks.get(5))
					&& isColor(blocks.get(6)) && isColor(blocks.get(7)))
					{
						int n = toInteger(blocks.get(1));
						String name = blocks.get(2);
						int x = toInteger(blocks.get(3));
						int y = toInteger(blocks.get(4));
						int l = toInteger(blocks.get(5));
						Color borderColor = toColor(blocks.get(6));
						Color fillColor = toColor(blocks.get(7));
						
						new Polygon(name, n, x, y, l, borderColor, fillColor);
					}
					else if (blocks.size()==9 && isInteger(blocks.get(1)) && isInteger(blocks.get(3)) && isInteger(blocks.get(4)) && isInteger(blocks.get(5))
					&& isColor(blocks.get(6)) && isColor(blocks.get(7)) && isInteger(blocks.get(8)))
					{
						int n = toInteger(blocks.get(1));
						String name = blocks.get(2);
						int x = toInteger(blocks.get(3));
						int y = toInteger(blocks.get(4));
						int l = toInteger(blocks.get(5));
						Color borderColor = toColor(blocks.get(6));
						Color fillColor = toColor(blocks.get(7));
						int priority = toInteger(blocks.get(8));
						
						new Polygon(name, n, x, y, l, borderColor, fillColor, priority);
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else if (blocks.get(0).equals("Rectangle"))
				{
					if (blocks.size()==8 && isInteger(blocks.get(2)) && isInteger(blocks.get(3)) && isInteger(blocks.get(4)) && isInteger(blocks.get(5))
					&& isColor(blocks.get(6)) && isColor(blocks.get(7)))
					{
						String name = blocks.get(1);
						int x=toInteger(blocks.get(2));
						int y=toInteger(blocks.get(3));
						int a=toInteger(blocks.get(4));
						int b=toInteger(blocks.get(5));
						Color borderColor= toColor(blocks.get(6));
						Color fillColor = toColor(blocks.get(7));
						
						new Rectangle(name, x, y, a, b, borderColor, fillColor);
					}
					else if (blocks.size()==9 && isInteger(blocks.get(2)) && isInteger(blocks.get(3)) && isInteger(blocks.get(4)) && isInteger(blocks.get(5))
					&& isColor(blocks.get(6)) && isColor(blocks.get(7)) && isInteger(blocks.get(8)))
					{
						String name = blocks.get(1);
						int x=toInteger(blocks.get(2));
						int y=toInteger(blocks.get(3));
						int a=toInteger(blocks.get(4));
						int b=toInteger(blocks.get(5));
						Color borderColor= toColor(blocks.get(6));
						Color fillColor = toColor(blocks.get(7));
						int priority = toInteger(blocks.get(8));
						
						new Rectangle(name, x, y, a, b, borderColor, fillColor, priority);
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else if (blocks.get(0).equals("Triangle"))
				{
					if (blocks.size()==10 && isInteger(blocks.get(2)) && isInteger(blocks.get(3)) && isInteger(blocks.get(4)) && isInteger(blocks.get(5)) 
					&&isInteger(blocks.get(6)) && isInteger(blocks.get(7)) && isColor(blocks.get(8)) && isColor(blocks.get(9)))
					{
						String name = blocks.get(1);
						int x1=toInteger(blocks.get(2));
						int y1=toInteger(blocks.get(3));
						int x2=toInteger(blocks.get(4));
						int y2=toInteger(blocks.get(5));
						int x3=toInteger(blocks.get(6));
						int y3=toInteger(blocks.get(7));
						Color borderColor = toColor(blocks.get(8));
						Color fillColor = toColor(blocks.get(9));
						
						new Triangle(name, x1, y1, x2, y2, x3, y3, borderColor, fillColor);
					}
					else if (blocks.size()==11 && isInteger(blocks.get(2)) && isInteger(blocks.get(3)) && isInteger(blocks.get(4)) && isInteger(blocks.get(5)) 
					&&isInteger(blocks.get(6)) && isInteger(blocks.get(7)) && isColor(blocks.get(8)) && isColor(blocks.get(9)) && isInteger(blocks.get(10)))
					{
						String name = blocks.get(1);
						int x1=toInteger(blocks.get(2));
						int y1=toInteger(blocks.get(3));
						int x2=toInteger(blocks.get(4));
						int y2=toInteger(blocks.get(5));
						int x3=toInteger(blocks.get(6));
						int y3=toInteger(blocks.get(7));
						Color borderColor = toColor(blocks.get(8));
						Color fillColor = toColor(blocks.get(9));
						int priority = toInteger(blocks.get(10));
						
						new Triangle(name, x1, y1, x2, y2, x3, y3, borderColor, fillColor, priority);
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
			}
			else if (command.equals("delete"))
			{
				if (blocks.size()==1)
				{
					Shape shape = toShape(blocks.get(0));
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (shape!=null)
					{
						shape.destroy();
					}
					else if (group != null)
					{
						for (int i=group.getSize()-1; i>=0; i--)
						{
							group.getList().get(i).destroy();
						}
						Group.updateList();
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
				
			}
			else if (command.equals("scale"))
			{
				if (blocks.size()==2)
				{
					Shape shape=toShape(blocks.get(0));
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (shape!=null && isDouble(blocks.get(1)))
					{
						shape.scale (Math.sqrt(toDouble(blocks.get(1))));
					}
					else if (group!=null && isDouble(blocks.get(1)))
					{
						for (int i=group.getSize()-1; i>=0; i--)
						{
							group.getList().get(i).scale (Math.sqrt(toDouble(blocks.get(1))));
						}
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
			}
			else if (command.equals("rotate"))
			{
				if (blocks.size()==2)
				{
					Shape shape=toShape(blocks.get(0));
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (shape!=null && isInteger(blocks.get(1)))
					{
						shape.rotate(toInteger(blocks.get(1)));
					}
					else if (group!= null && isInteger(blocks.get(1)))
					{
						for (int i=group.getSize()-1; i>=0; i--)
						{
							group.getList().get(i).rotate(toInteger(blocks.get(1)));
						}
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
			}
			else if (command.equals("locate"))
			{
				if (blocks.size()==3)
				{
					Shape shape = toShape(blocks.get(0));
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (shape!=null && isInteger(blocks.get(1)) && isInteger(blocks.get(2)))
					{
						shape.setCenter(toInteger(blocks.get(1)), toInteger(blocks.get(2)));
					}
					else if (group!=null && isInteger(blocks.get(1)) && isInteger(blocks.get(2)))
					{
						shape = group.getList().get(0);
						double x0 = shape.getCenter().getX();
						double y0 = shape.getCenter().getY();
						double difX=toInteger(blocks.get(1))-x0;
						double difY=toInteger(blocks.get(2))-y0;
						for (int i=group.getSize()-1; i>=0; i--)
						{
							group.getList().get(i).moveCenter(difX, difY);
						}
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
			}
			else if (command.equals("cut"))
			{
				if (blocks.size()==1)
				{
					Shape shape = toShape(blocks.get(0));
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (shape!=null)
					{
						clipBoard.Cut.setShapeToClipboard(shape);
					}
					else if (group!=null)
					{
						clipBoard.Cut.setGroupToClipboard(group);
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
				
			}
			else if (command.equals("paste"))
			{
				if (blocks.size()==2 && isInteger(blocks.get(0)) && isInteger(blocks.get(1)))
				{
					Point location = new Point();
					location.setLocation(toInteger(blocks.get(0)), toInteger(blocks.get(1)));
					clipBoard.Paste.setDataToTheSheet(location);
				}
				else
				{
					error(parameters);
					return;
				}
				
			}
			else if (command.equals("addToGroup"))
			{
				if (blocks.size()>=2)
				{
					Group group = toGroup(blocks.get(blocks.size()-1));
					if (group==null)
					{
						group = new Group();
						group.setName(blocks.get(blocks.size()-1));
					}
					for (int i=blocks.size()-2; i>=0; i--)
					{
						Shape shape = toShape(blocks.get(i));
						if (shape != null)
						{
							shape.setGroup(group);
						}
						else
						{
							error(parameters);
							return;
						}
					}
				}
				else
				{
					error(parameters);
					return;
				}
			}
			else if (command.equals("changeBorder"))
			{
				if (blocks.size()==2)
				{
					Shape shape=toShape(blocks.get(0));
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (shape!=null && isColor(blocks.get(1)))
					{
						shape.setBorderColor(toColor(blocks.get(1)));
					}
					else if (group!=null && isColor(blocks.get(1)))
					{
						for (int i=group.getSize()-1; i>=0; i--)
						{
							group.getList().get(i).setBorderColor(toColor(blocks.get(1)));
						}
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
			}
			else if (command.equals("disband"))
			{
				if (blocks.size()==1)
				{
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (group!=null)
					{
						int n = group.getSize();
						for (int i=n-1; i>=0; i--)
						{
							group.getList().get(i).setGroup(new Group());
						}
						Group.updateList();
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
				
			}
			else if (command.equals("priority"))
			{
				if (blocks.size()==2)
				{
					Shape shape=toShape(blocks.get(0));
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (shape!=null && isInteger(blocks.get(1)))
					{
						shape.setPriority(toInteger(blocks.get(1)));
					}
					else if (group!=null && isInteger(blocks.get(1)))
					{
						Collections.sort(group.getList());
						for (int i=group.getSize()-1; i>=0; i--)
						{
							group.getList().get(i).setPriority(toInteger(blocks.get(1)));
						}
					}

					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
			}
			else if (command.equals("changeFillColor"))
			{
				if (blocks.size()==2)
				{
					Shape shape=toShape(blocks.get(0));
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (shape!=null && isColor(blocks.get(1)))
					{
						shape.setFillColor(toColor(blocks.get(1)));
					}
					else if (group!=null && isColor(blocks.get(1)))
					{
						for (int i=group.getSize()-1; i>=0; i--)
						{
							group.getList().get(i).setFillColor(toColor(blocks.get(1)));
						}
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
			}
			else if (command.equals("deleteFromGroup"))
			{
				if (blocks.size()>=2)
				{
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (group!=null)
					{
						for (int i=1; i<blocks.size(); i++)
						{
							Shape shape = toShape(blocks.get(i));
							if (shape!=null && shape.getGroup()==group)
							{
								shape.setGroup(new Group());
							}
							else
							{
								error(parameters);
								return;
							}
						}
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
			}
			else if (command.equals("copy"))
			{
				if (blocks.size()==1)
				{
					Shape shape = toShape(blocks.get(0));
					Group.updateList();
					Group group = toGroup(blocks.get(0));
					if (shape!=null)
					{
						clipBoard.Copy.setShapeToClipboard(shape);
					}
					else if (group!=null)
					{
						clipBoard.Copy.setGroupToClipboard(group);
					}
					else
					{
						error(parameters);
						return;
					}
				}
				else
				{
					error(parameters);
					return;
				}
			}	
		}
		else
		{
			error("Command ("+command+") is not declared");
			return;
		}
	}
	
	private static void error(String line)
	{
		Performer.isErrorFound=true;
		System.out.println("Warning- "+line);
	}
	
	private static boolean isInteger(String s)
	{
	    return isInteger(s,10);
	}
	private static boolean isInteger(String s, int radix)
	{
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}
	private static int toInteger(String s)
	{
		return Integer.parseInt(s);
	}
	private static boolean isColor(String s)
	{
		if (s.length()!=6)
			return false;
		for (int i=0; i<6; i++)
		{
			if (s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || s.charAt(i)=='3' || s.charAt(i)=='4' || s.charAt(i)=='5' ||
				s.charAt(i)=='6' || s.charAt(i)=='7' || s.charAt(i)=='8' || s.charAt(i)=='9' || s.charAt(i)=='a' || s.charAt(i)=='b' || 
				s.charAt(i)=='c' || s.charAt(i)=='d' || s.charAt(i)=='e' || s.charAt(i)=='f' || s.charAt(i)=='A' || s.charAt(i)=='B' || 
				s.charAt(i)=='C' || s.charAt(i)=='D' || s.charAt(i)=='E' || s.charAt(i)=='F')
					continue;
			else
				return false;
		}
		return true;
	}
	private static Color toColor(String colorStr)
	{
	    return  new Color(
	            Integer.valueOf(colorStr.substring(0, 2), 16),
	            Integer.valueOf(colorStr.substring(2, 4), 16),
	            Integer.valueOf(colorStr.substring(4, 6), 16));
	}
	private static Shape toShape(String name)
	{
		Shape shape = null;
		Shape tmp = null;
		Iterator<Shape> it = Shape.allShapes.iterator();
		while (it.hasNext())
		{
			tmp=it.next();
			if (tmp.getName().equals(name))
				shape=tmp;
		}
		return shape;
	}
	private static Group toGroup(String name)
	{
		Group tmp = null;
		Iterator<Group> it = Group.allGroups.iterator();
		while (it.hasNext())
		{
			tmp=it.next();
			if (tmp.getName().equals(name))
				return tmp;
		}
		return null;
	}
	private static boolean isDouble(String s)
	{
		try
		{
		  Double.parseDouble(s);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		return true;
	}
	private static double toDouble(String s)
	{
		return Double.parseDouble(s);
	}
}
