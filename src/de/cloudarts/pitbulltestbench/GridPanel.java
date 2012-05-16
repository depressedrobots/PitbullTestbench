package de.cloudarts.pitbulltestbench;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.Box.Filler;

import de.cloudarts.aibattleai.AITools;

public class GridPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int[] grid;
	
	@Override 
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int intervalX = this.getWidth() / 7;
        int intervalY = this.getHeight() / 6;
        
        for( int x = 1; x < 7; x ++)
        {
        	g.drawLine(x*intervalX, 0, x*intervalX, this.getHeight());
        }
    	for( int y = 1; y < 6; y++)
    	{
            g.drawLine(0, y*intervalY, this.getWidth(), y*intervalY);
    	}
    	
    	for(int i = 0; i < AITools.GRID_COLUMNS*AITools.GRID_ROWS; i++)
    	{
    		if(grid[i] != 0 )
    		{
    			Point p = AITools.indexToCoords(i);
    			p.x *= intervalX;
    			p.y *= intervalY;
    			
    			g.setColor(Color.BLUE);
    			if( grid[i] == 2 )
    			{
    				g.setColor(Color.RED);
    			}
    			
    			g.fillOval(p.x, p.y, intervalX, intervalY);
    		}
    	}
   }

}
