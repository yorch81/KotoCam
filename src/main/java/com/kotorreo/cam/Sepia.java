package com.kotorreo.cam;

import java.awt.image.BufferedImage;

import marvin.image.MarvinImage;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

public class Sepia extends Filter {
	
	@Override
	public BufferedImage process(BufferedImage img) {
		MarvinImagePlugin imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.sepia.jar");
		MarvinImage image = new MarvinImage(img);
		imagePlugin.process(image, image);
		image.update();
		
		return image.getBufferedImage();
	}

	@Override
	public BufferedImage process(BufferedImage img, int scale) {
		return process(img);
	}

}
