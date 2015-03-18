package com.kotorreo.cam;

import java.awt.image.BufferedImage;

import marvin.image.MarvinImage;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

/**
 * Optimize
 * 
 * Optimize Implementation of Filter
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
 * @category   Optimize
 * @package    com.kotorreo.cam
 * @copyright  Copyright 2015 JAPT
 * @license    http://www.apache.org/licenses/LICENSE-2.0
 * @version    1.0.0, 2015-16-03
 * @author     <a href="mailto:the.yorch@gmail.com">Jorge Alberto Ponce Turrubiates</a>
 */
public class Optimize extends Filter {

	@Override
	public BufferedImage process(BufferedImage img) {
		return process(img, 50);
	}

	@Override
	public BufferedImage process(BufferedImage img, int scale) {
		MarvinImagePlugin imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.brightnessAndContrast.jar");
		MarvinImage image = new MarvinImage(img);
		
		imagePlugin.setAttribute("bightness", scale / 2);
		imagePlugin.setAttribute("contrast", scale / 2);
		imagePlugin.process(image, image);
		image.update();
		
		return image.getBufferedImage();
	}

}
