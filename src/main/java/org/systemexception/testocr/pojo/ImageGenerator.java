package org.systemexception.testocr.pojo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author leo
 * @date 24/06/15 14:23
 */
public class ImageGenerator {

	private final BufferedImage image;
	private final Graphics graphics;

	public ImageGenerator() {
		image = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY);
		Font fontMonospace = new Font(Font.MONOSPACED, Font.PLAIN, 24);
		FontRenderContext fontRenderContext = image.getGraphics().getFontMetrics().getFontRenderContext();

		Rectangle2D rectangle = fontMonospace.getStringBounds("123", fontRenderContext);
		int imageWidth = (int) (rectangle.getWidth() + rectangle.getWidth() * 0.1);
		int imageHeight = (int) (rectangle.getHeight() + rectangle.getHeight() * 0.1);
		BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_BYTE_GRAY);
		graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, imageWidth, imageHeight);
		graphics.setColor(Color.BLACK);
		graphics.setFont(fontMonospace);
		graphics.drawString("123", 0, (int) (imageHeight * 0.9));
		// release resources
		graphics.dispose();
		try {
			ImageIO.write(image, "png", new File("image.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
