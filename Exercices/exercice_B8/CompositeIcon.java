package exercice_B8;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.Icon;

public class CompositeIcon  implements Icon{
	
	private int width,height;
	List<Icon> liste;
	List<Point> iconPosition;
	
	public CompositeIcon(int width, int height){
		this.width 	= width;
		this.height = height;
		liste 			= new ArrayList<Icon>();
		iconPosition 	= new ArrayList<Point>();
	}
	
	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		
		int compteur = 0;
		for(Icon o : liste){
			Point point  = iconPosition.get(compteur++);
			o.paintIcon(c, g, (int) point.getX(), (int) point.getY());
		}
	}
	
	public void addIcon(Icon icon,int x, int y){
		liste.add(icon);
		iconPosition.add(new Point(x,y));
	}
}




















