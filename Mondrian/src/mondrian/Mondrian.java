//
// Mondrian - applet that draws modern art
//
//  Written by: Richie Bielak    5/16/1996
//  	http://www.netlabs.net/hp/richieb
//
//  -- This program maybe freely copied --
//  -- Just please keep my name in.     --
//

import java.applet.*;
import java.awt.*;


public class Mondrian extends Applet {

// Width of picture
private int pic_width;

// Height of picture
private int pic_height;

// init applet
public void init() {
	// Get parameters that describe the size of our window
	String pvalue;

	pvalue = getParameter ("width");
	pic_width = Integer.parseInt (pvalue, 10);
	pvalue = getParameter ("height");
	pic_height = Integer.parseInt (pvalue, 10);
	//
} // init


public void paint (Graphics g) {

	g.setColor (Color.white);
	g.fillRect (1, 1, pic_width, pic_height);
	mondrian_vertical (g, 1, 1, pic_width, pic_height, 4);


} // paint


public void mondrian_vertical (Graphics g, 
				int x, 
				int y, 
				int width,	
				int height,
				int depth) {

	int middle;

	if (depth > 0) {
		// split in two
		middle = (int)(Math.random() * width);
		// Draw dividing line
		g.setColor (Color.black);
		g.fillRect (x + middle, y, depth*2, height);
		// Handle sub-rectangles
		mondrian_horizontal (g, x, y, middle, height, depth-1);
		mondrian_horizontal (g, x+middle+depth*2, y, 
				     width - middle, height, depth-1);

		}
	else {
		// Fill in with random color
		if (Math.random () < .2) {
			setRandomColor (g);
			g.fillRect (x, y, width, height);
		}
	
	}
} // mondrian_horizontal

public void mondrian_horizontal (Graphics g, 
				int x, 
				int y, 
				int width,	
				int height,
				int depth) {
	int middle;

	if (depth > 0) {
		middle = (int)(Math.random() * height);
		g.setColor (Color.black);
		g.fillRect (x, y+middle , width, depth*2);
		// Deal with the sub-rectangles
		mondrian_vertical (g, x, y+middle+depth*2, width, 
					height - middle, depth-1);
		mondrian_vertical (g, x, y, width, middle, depth-1);
	}
	else {
		if (Math.random() < .2) {
			setRandomColor (g);
			g.fillRect (x, y, width, height);
		}
	}
	
} // mondrian_horizontal


public void setRandomColor (Graphics g) {
	double x;

	x = Math.random ();
	if (x < .3)
		g.setColor (Color.blue);
	else if (x < .6)
		g.setColor (Color.red);
	else
		g.setColor (Color.yellow);
}


public boolean mouseDown (Event e, int x, int y) {
	Graphics g = getGraphics ();
	paint (g);
	return true;
}


}