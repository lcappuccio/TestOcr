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
		for (int i = 100; i < 200; i++) {
			sut.drawStringAndSaveFile(String.valueOf(i));
		}
	}
}