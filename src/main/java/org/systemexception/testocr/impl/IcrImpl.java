package org.systemexception.testocr.impl;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.systemexception.testocr.api.Icr;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author lcappuccio
 * @date 17/06/15 17:46
 */
public class IcrImpl implements Icr {

	private final Tesseract tesseract = new Tesseract();

	public IcrImpl() {
		ArrayList<String> configList = new ArrayList();
		URL configFileUrl = this.getClass().getResource("/config.txt");
		try {
			configList.add(Paths.get(configFileUrl.toURI()).toAbsolutePath().toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		tesseract.setConfigs(configList);
	}

	@Override
	public String recognize(String imagePath) throws TesseractException {
		File imageFile = new File(imagePath);
		String result = tesseract.doOCR(imageFile);
		return result;
	}
}
