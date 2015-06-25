package org.systemexception.testocr.provider;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author leo
 * @date 24/06/15 14:23
 */
public class ImageGenerator {

	private Font fontMonospace;
	private final FontRenderContext fontRenderContext;
	private BufferedImage image;

	public ImageGenerator() {
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY);
		fontMonospace = new Font(Font.MONOSPACED, Font.PLAIN, 24);
		fontRenderContext = image.getGraphics().getFontMetrics().getFontRenderContext();
	}

	/**
	 * Draws the string to the graphics object and invoke a file save
	 *
	 * @param text the text to be drawn, will be the filename
	 */
	public void drawStringAndSaveFile(String text) {
		changeFontMonospaceSize();
		Rectangle2D rectangle = fontMonospace.getStringBounds(text, fontRenderContext);
		int imageWidth = (int) (rectangle.getWidth() + rectangle.getWidth() * 0.1);
		int imageHeight = (int) (rectangle.getHeight() + rectangle.getHeight() * 0.1);
		image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_BYTE_GRAY);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, imageWidth, imageHeight);
		graphics.setColor(Color.BLACK);
		graphics.setFont(fontMonospace);
		graphics.drawString(text, 0, (int) (imageHeight * 0.9));
		// release resources
		graphics.dispose();
		saveFile(text);
	}

	/**
	 * Changes the font to a new randomized size
	 */
	private void changeFontMonospaceSize() {
		Random random = new Random();
		int fontSize = random.nextInt(256);
		fontMonospace = new Font(Font.MONOSPACED, Font.PLAIN, fontSize);
	}

	/**
	 * Saves the file to disk
	 *
	 * @param fileName the filename, in this case the string drawn will be the filename
	 */
	private void saveFile(final String fileName) {
		String finalFileName = fileName + ".png";
		try {
			String runningPath = System.getProperty("user.dir");
			ImageIO.write(image, "png", new File(finalFileName));
			System.out.println("Saving file " + runningPath + File.pathSeparator + finalFileName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
