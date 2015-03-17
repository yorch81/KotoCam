package com.kotorreo.cam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class KotoCamApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to KotoCam");
		
		BufferedImage img = ImageIO.read(new File("/home/yorch/Downloads/test.jpg"));
		Mask gray = new Mask();
		img = gray.process(img, 50);
		
		File imgFile = new File("/home/yorch/Downloads/gray.jpg");
        
        ImageIO.write(img, "jpg", imgFile);
        
	}
}
