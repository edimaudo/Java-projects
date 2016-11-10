/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package artist;

/**
 *
 * @author edima
 */

/*
 *	Pseudo-Mondrian Art Generator
 *
 *  Copyright (C) 2002 J. David Eisenberg
 *
 */

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics2D;
import java.util.Random;

class Artist {

	static final Color bright[] = {
		Color.white, Color.black, Color.green, Color.magenta,
		Color.orange, Color.yellow, Color.red
	};
	
	static final Color pastel[] = {
		new Color(0xcccccc), new Color(0x999999),
		new Color(0xccffcc), new Color(0xffccff),
		new Color(0xffcc99), new Color(0xffffcc),
		new Color(0xffcccc)
	};
	
	static final int BRIGHT = 0;
	static final int PASTEL = 1;
	
	static final int VERTICAL = 0;
	static final int HORIZONTAL = 1;

	int		width, height;
	int		currentColor;
	Color	palette[];
	Random	rand;
	
	int		depth;
	
	/**
	 * Artist no-argument constructor
	 * Constructs a 200 by 200 canvas with bright color palette.
	 */
	 public Artist()
	{
		this( 200, 200, BRIGHT );
	}
	
	/**
	 * Artist two-argument constructor
	 * Constructs a canvas of the given width and height
	 * with a bright color palette.
	 * @param width Width of the painting
	 * @param height Height of the painting
	 *
	 */
	public Artist( int width, int height )
	{
		this( width, height, BRIGHT );
	}
	
	/**
	 * Artist three-argument constructor
	 * Constructs a canvas of the given width and height
	 * with the desired color palette
	 * (<code>BRIGHT</code> or <code>PASTEL</code>)
	 * @param width Width of the painting
	 * @param height Height of the painting
	 * @param colorType Palette to use
	 *
	 */
	public Artist( int width, int height, int colorType )
	{
		this.width = width;
		this.height = height;
		
		if (colorType == BRIGHT)
		{
			palette = bright;
		}
		else if (colorType == PASTEL)
		{
			palette = pastel;
		}
		rand = new Random();
		currentColor = rand.nextInt(palette.length);
	}
	
	/**
	 * Paint a Mondrian-style artwork
	 * @param g The <code>Graphics2D</code> environment into which
	 * to draw.
	 */
	public void paint( Graphics2D g )
	{
		depth = 0;
		partition( g, new Rectangle(5, 5, width, height),
			(rand.nextInt(2) == 0) ? VERTICAL : HORIZONTAL );
		g.setColor( Color.black );
		g.draw( new Rectangle( 5, 5, width, height ) );
	}
	
	/**
	 * Partition a rectangle into draw-able sections
	 * If a rectangle is too small, or is the result of the
	 * fourth subdivision of a larger rectangle, we paint it.
	 * Otherwise, we divide it in the direction perpendicular
	 * to the direction in which its parent was divided.
	 * This happens 70% of the time - the other 30% we decide
	 * not to subdivide it, and paint it instead.
	 * The rectangle is divided into either two slices (approx. 75%
	 * of the time) or three slices (the rest of the time).
	 * @param g The <code>Graphics2D</code> environment into which
	 * to draw.
	 * @param r The initial <code>Rectangle2D</code> to be partitioned.
	 * @param direction One of <code>VERTICAL</code> or <code>HORIZONTAL</code>.
	 */
	public void partition( Graphics2D g, Rectangle2D r, int direction )
	{
		boolean		subdivide;

		/*
		 * If an area is too small, or if we've nested to deep,
		 * don't subdivide it; otherwise, subdivide it 70% of the time
		 * or if it's the top level.
		 */
		if (r.getWidth() < 60 || r.getHeight() < 60 || depth > 4 )
		{
			subdivide = false;
		}
		else
		{
			subdivide = (rand.nextFloat() < 0.70) || (depth == 0);
		}
		
		if (subdivide)
		{
			int i;
			int nSlices;
			double percentage[] = new double[3];
			double x, y, height, width;
	
			/*
			 * change slice direction
			 */
			direction = (direction == VERTICAL) ? HORIZONTAL : VERTICAL;
			
			/*
			 * Randomly establish the width or height of the slices.
			 */
			if (rand.nextFloat() < 0.75)
			{
				nSlices = 2;
				percentage[0] = .20 + (rand.nextDouble() * 0.60);
				percentage[1] = 1 - percentage[0];
			}
			else
			{
				nSlices = 3;
				percentage[0] = .20 + (rand.nextDouble() * 0.60);
				percentage[1] = rand.nextDouble() * (1 - percentage[0]);
				percentage[2] = 1 - (percentage[0]+percentage[1]);
			}
			
			x = r.getX();
			y = r.getY();
			width = r.getWidth();
			height = r.getHeight();

			/*
			 * Partition each of the slices.
			 */
			depth++;
			if (direction == HORIZONTAL)
			{
				for (i=0; i < nSlices; i++)
				{
					r.setRect( x, y, width, height * percentage[i] );
					partition( g, r, direction );
					y += height * percentage[i];
				}
			}
			else
			{
				for (i=0; i < nSlices; i++)
				{
					r.setRect( x, y, width * percentage[i], height );
					partition(g, r, direction);
					x += width * percentage[i];
				}
			}
		}
		else 
		{
			/*
			 * Paint this rectangle and outline it in black.
			 */
			g.setColor( palette[currentColor] );
			g.fill( r );
			g.setColor( Color.black );
			g.draw( r );
			currentColor = (currentColor + 1) % palette.length;
		}			
	}
}
