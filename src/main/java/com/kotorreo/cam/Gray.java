package com.kotorreo.cam;

import java.awt.image.BufferedImage;

import com.jhlabs.image.GrayscaleFilter;

public class Gray extends Filter{
	
	@Override
	public BufferedImage process(BufferedImage img) {
		GrayscaleFilter filter = new GrayscaleFilter();
		BufferedImage imgFilter = filter.filter(img, null);
		
		filter = null;
		
		return imgFilter;
	}

	@Override
	public BufferedImage process(BufferedImage img, int scale) {		
		return process(img);
	}

}
