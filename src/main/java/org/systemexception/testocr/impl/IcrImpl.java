package org.systemexception.testocr.impl;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.systemexception.testocr.api.Icr;

import java.io.File;

/**
 * @author lcappuccio
 * @date 17/06/15 17:46
 */
public class IcrImpl implements Icr {

	private final Tesseract tesseract = new Tesseract();

	@Override
	public String recognize(String imagePath) throws TesseractException {
		File imageFile = new File(imagePath);
		String result = tesseract.doOCR(imageFile);
		return result;
	}
}
