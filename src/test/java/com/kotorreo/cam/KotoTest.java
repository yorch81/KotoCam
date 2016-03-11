package com.kotorreo.cam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import junit.framework.TestCase;

/**
 * KotoTest<br>
 * 
 * KotoTest Test for KotoCam<br><br>
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
 * @version    1.0.0, 2015-27-06
 * @author     <a href="mailto:the.yorch@gmail.com">Jorge Alberto Ponce Turrubiates</a>
 */
public class KotoTest extends TestCase {

	/**
	 * Image to Apply Filter
	 */
	BufferedImage img;
	
	/**
	 * Constructor Class
	 */
	public KotoTest() {
	}
	
	/**
	 * Test for All Filters Image
	 */
	public void testFilters() {
		boolean assertValue = false;
				
		String[] filters = KotoFilter.getFilters();
		
		BufferedImage imgTmp;
		KotoFilter kotoFilter;
		
		for (int i = 0; i<filters.length; i++) {
			try {
				img = ImageIO.read(new File("/home/yorch/tmp/mory.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (img == null)
				assertTrue(false);
			
			kotoFilter = new KotoFilter(filters[i]);
			imgTmp = kotoFilter.process(img, 70);
			
			String fileName = "/home/yorch/tmp/" + filters[i] + "_mory.jpg";
			
			File imgFile = new File(fileName);
	        
	        try {
				ImageIO.write(imgTmp, "jpg", imgFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
	        assertValue = imgFile.exists();
	        
	        // Delete image
	        if (assertValue)
	        	imgFile.delete();
	        
	        if (! assertValue)
	        	assertTrue(false);
	        
	        imgTmp = null;
	        img = null;
		}
		
		assertTrue(assertValue);
	}
}
