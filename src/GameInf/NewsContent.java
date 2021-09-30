package GameInf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class NewsContent extends JPanel {

	String Fd = " ";
	String Ud = " ";
	String Zd = " ";

	public void setFd(String x) {
		this.Fd = x;
	}

	public void setUd(String y) {
		this.Ud = y;
	}

	public void setZd(String z) {
		this.Zd = z;
	}

	// ÁÙ¹Ù²Þ ÇÔ¼ö
	private void drawString(Graphics g, String text, int x, int y) {

		AttributedString attributedString = new AttributedString(text);

		Graphics2D g2d = (Graphics2D) g;

		AttributedCharacterIterator characterIterator = attributedString.getIterator();
		FontRenderContext fontRenderContext = g2d.getFontRenderContext();
		LineBreakMeasurer measurer = new LineBreakMeasurer(characterIterator, fontRenderContext);

		while (measurer.getPosition() < characterIterator.getEndIndex()) {
			TextLayout textLayout = measurer.nextLayout(480);
			y += textLayout.getAscent();
			textLayout.draw(g2d, x, y);
			y += textLayout.getDescent() + textLayout.getLeading();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15)); // Font
		g.drawString(Fd, 10, 30);

		g.setColor(Color.BLACK);
		g.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15)); // Font
		drawString(g, Ud, 10, 80);

		try {
			Image img = new ImageIcon(new URL(Zd)).getImage();

			g.drawImage(img, 10, 50, 480, 130, this);

		} catch (Exception e) {
		}

	}
}
