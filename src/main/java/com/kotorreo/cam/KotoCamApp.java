package com.kotorreo.cam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.jhlabs.image.ChannelMixFilter;
import com.jhlabs.image.GainFilter;
import com.jhlabs.image.GrayscaleFilter;
import com.jhlabs.image.HSBAdjustFilter;
import com.jhlabs.image.InvertFilter;

import marvin.MarvinDefinitions;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

public class KotoCamApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to KotoCam");
		
		BufferedImage img = ImageIO.read(new File("/home/yorch/Downloads/test.jpg"));
		Invert gray = new Invert();
		img = gray.process(img, 100);
		
		File imgFile = new File("/home/yorch/Downloads/gray.jpg");
        
        ImageIO.write(img, "jpg", imgFile);
        
	}
}
