package com.kotorreo.cam;

import java.awt.image.BufferedImage;

import com.jhlabs.image.InvertFilter;

public class Invert extends Filter {

	@Override
	public BufferedImage process(BufferedImage img) {
		InvertFilter filter = new InvertFilter();
		BufferedImage imgFilter = filter.filter(img, null);
		
		filter = null;
		
		return imgFilter;
	}

	@Override
	public BufferedImage process(BufferedImage img, int scale) {
		return process(img);
	}

}
