package org.systemexception.testocr.test;

import org.junit.Test;
import org.systemexception.testocr.pojo.ImageGenerator;

/**
 * @author leo
 * @date 24/06/15 14:32
 */
public class ImageGeneratorTest {

	@Test
	public void doStuff() {
		ImageGenerator sut = new ImageGenerator();
		sut.drawStringAndSaveFile("123");
		sut.drawStringAndSaveFile("19831919");
		sut.drawStringAndSaveFile("456");
		sut.drawStringAndSaveFile("19821");
	}
}