package com.kotorreo.cam;

import java.awt.image.BufferedImage;

import com.jhlabs.image.ChannelMixFilter;

public class MixGreen extends Filter {

	@Override
	public BufferedImage process(BufferedImage img) {
		return process(img, 100);
	}

	@Override
	public BufferedImage process(BufferedImage img, int scale) {
		ChannelMixFilter filter = new ChannelMixFilter();
		filter.setIntoG(scale * 20);
		
		BufferedImage imgFilter = filter.filter(img, null);
		
		filter = null;
		
		return imgFilter;
	}

}
