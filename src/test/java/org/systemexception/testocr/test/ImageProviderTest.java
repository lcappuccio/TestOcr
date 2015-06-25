package org.systemexception.testocr.test;

import org.junit.Test;
import org.systemexception.testocr.provider.ImageProvider;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * @author leo
 * @date 24/06/15 14:32
 */
public class ImageProviderTest {

	@Test
	public void imageIsCreated() {
		ImageProvider sut = new ImageProvider();
		for (int i = 0; i < 10; i++) {
			sut.drawStringAndSaveFile(String.valueOf(i));
			assertTrue(fileExists(String.valueOf(i)));
		}
	}

	private boolean fileExists(String fileName) {
		String filePathAndName = System.getProperty("user.dir");
		File imageFile = new File(filePathAndName + File.separator + fileName + ".png");
		return imageFile.exists();
	}
}