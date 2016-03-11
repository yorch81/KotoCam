package com.kotorreo.cam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

/**
 * KotoCamApp<br>
 * 
 * KotoCamApp Init Application<br><br>
 * 
 * Copyright 2015 Jorge Alberto Ponce Turrubiates
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @version    1.0.0, 2015-16-03
 * @author     <a href="mailto:the.yorch@gmail.com">Jorge Alberto Ponce Turrubiates</a>
 */
public class KotoCamApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to KotoCam");
		
		// Configure Log file
		LogConfig.configure("kotocam.log");
 
        // creates a custom logger and log messages
        Logger logger = Logger.getLogger(KotoCamApp.class);
        logger.info("Welcome to KotoCam");
        
		BufferedImage img;
		
		String[] filters = KotoFilter.getFilters();
		
		BufferedImage imgTmp;
		KotoFilter kotoFilter;
		
		for (int i = 0; i<filters.length; i++) {
			img = ImageIO.read(new File("/home/yorch/tmp/mory.jpg"));
			
			System.out.println("Apply " + filters[i]);
			
			kotoFilter = new KotoFilter(filters[i]);
			imgTmp = kotoFilter.process(img, 70);
			
			String fileName = "/home/yorch/tmp/" + filters[i] + "_mory.jpg";
			
			File imgFile = new File(fileName);
	        
	        try {
				ImageIO.write(imgTmp, "jpg", imgFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	        imgTmp = null;
	        img = null;
	        kotoFilter = null;
		}
	}
}
