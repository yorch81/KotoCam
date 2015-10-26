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
		try {
			img = ImageIO.read(new File("/home/yorch/tmp/mory.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			img = null;
		}
	}
	
	/**
	 * Test for Filter Image
	 */
	public void testFilter() {
		boolean assertValue = false;
		
		if (img == null)
			assertTrue( false );
		
		KotoFilter kotoFilter = new KotoFilter("Crazy");
        
		img = kotoFilter.process(img, 80);
			
		File imgFile = new File("/home/yorch/tmp/kotomory.jpg");
        
        try {
			ImageIO.write(img, "jpg", imgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
        assertValue = imgFile.exists();
        
        if (assertValue)
        	imgFile.delete();
        
		assertTrue( assertValue );
	}
}
