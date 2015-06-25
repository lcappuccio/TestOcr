package org.systemexception.testocr.test;

import org.junit.Test;
import org.systemexception.testocr.provider.ImageProvider;

/**
 * @author leo
 * @date 24/06/15 14:32
 */
public class ImageProviderTest {

	@Test
	public void doStuff() {
		ImageProvider sut = new ImageProvider();
		sut.drawStringAndSaveFile("123");
		sut.drawStringAndSaveFile("19831919");
		sut.drawStringAndSaveFile("456");
		sut.drawStringAndSaveFile("19821");
	}
}