package com.ulasoft.lanterncorpsacademy;

import java.util.ArrayList;
import java.util.List;
import nextapp.echo.app.Color;
import org.informagen.echo.app.CapacityBar;

/**
 * @author julian ovalle
 *
 *ulasoft echo component
 */

@SuppressWarnings("serial")
public class ProgressBar extends CapacityBar {

	public ProgressBar() {
		//Empty
	}

	public ProgressBar(int height, int width, int type, Color color) {
		super(height, width);
		this.setReflectivity(1.0);
		this.setTickSpacing(20);
		switch (type) {
		case 0: this.setColor(Color.RED); break; //healthbar
		
		case 1: this.setColor(color);
		        this.setShowTicks(false); break; //energy bar,character class dependent color
		        
		case 2: this.setColor(Color.DARKGRAY); break; //exp bar
		}
	}

	public void setCurrValue (int value) {	
		List<Number> values= new ArrayList<Number>(2);
	    values.add(value);
	    values.add(100-value);
	    this.setValues(values);
	}
		
	public void setColor (Color color) {
		List<Color> colors= new ArrayList<Color>(2);
	    colors.add(color);
	    colors.add(Color.WHITE);
	    this.setColors(colors);
	}
}
