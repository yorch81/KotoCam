package com.kotorreo.cam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		
		BufferedImage img = ImageIO.read(new File("/home/yorch/Downloads/test.jpg"));
		
		KotoFilter kotoFilter = new KotoFilter("Optimize");
        
		img = kotoFilter.process(img, 90);
			
		File imgFile = new File("/home/yorch/Downloads/kotocam.jpg");
        
        ImageIO.write(img, "jpg", imgFile);
	}
}
