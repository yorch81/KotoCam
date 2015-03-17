package com.kotorreo.cam;

import java.awt.image.BufferedImage;
import java.util.Random;

import com.jhlabs.image.ChannelMixFilter;

/**
 * Crazy
 * 
 * Crazy Implementation of Filter
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
 * @category   Crazy
 * @package    com.kotorreo.cam
 * @copyright  Copyright 2015 JAPT
 * @license    http://www.apache.org/licenses/LICENSE-2.0
 * @version    1.0.0, 2015-17-03
 * @author     <a href="mailto:the.yorch@gmail.com">Jorge Alberto Ponce Turrubiates</a>
 */
public class Crazy extends Filter {

	@Override
	public BufferedImage process(BufferedImage img) {
		return process(img, 50);
	}

	@Override
	public BufferedImage process(BufferedImage img, int scale) {
		ChannelMixFilter filter = new ChannelMixFilter();
		Random rand = new Random();
		
		int seed = rand.nextInt(scale * 20);
		
		int blue = rand.nextInt(seed);
		int green = rand.nextInt(seed);
		int red = rand.nextInt(seed);
		
		filter.setIntoB(blue);
		filter.setIntoG(green);
		filter.setIntoR(red);
		
		BufferedImage imgFilter = filter.filter(img, null);
		
		filter = null;
		
		return imgFilter;
	}

}
