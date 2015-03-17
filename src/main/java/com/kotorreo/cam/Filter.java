package com.kotorreo.cam;

import java.awt.image.BufferedImage;

public abstract class Filter {

	public abstract BufferedImage process (BufferedImage img);
	
	public abstract BufferedImage process (BufferedImage img, int scale);
}
