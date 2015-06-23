package org.systemexception.testocr.test;

import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;
import org.systemexception.testocr.api.Icr;
import org.systemexception.testocr.impl.IcrImpl;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author lcappuccio
 * @date 17/06/15 17:49
 */
public class IcrImplTest {

	private final Icr sut = new IcrImpl();

	@Test
	public void matchNumbers50Pct() throws URISyntaxException, TesseractException {
		File[] imageFiles = getFiles("/numbers");
		int matches = 0;
		for (File imageFile : imageFiles) {
			String readedNumber = sut.recognize(imageFile.getAbsolutePath());
			String numberInFile = getFileNameWithoutPathAndExtension(imageFile.getName());
			if (readedNumber.equals(numberInFile)) {
				matches++;
			}
		}
		assertTrue(matches * 100 / imageFiles.length > 50);
	}

	private File[] getFiles(String path) throws URISyntaxException {
		URL fileUrl = this.getClass().getResource(path);
		Path runningPath = Paths.get(fileUrl.toURI()).toAbsolutePath();
		return runningPath.toAbsolutePath().toFile().listFiles();
	}

	private String getFileNameWithoutPathAndExtension(final String fileNamePath) {
		return fileNamePath.substring(0, fileNamePath.lastIndexOf(".")).replaceFirst("^0+(?!$)", "");
	}
}