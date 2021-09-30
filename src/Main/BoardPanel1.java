package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.awt.Desktop;


public class BoardPanel1 extends JPanel {

	int page;
	
	public BoardPanel1(JFrame frame) {
		super();
		PanelInit(frame);
	}

	private void PanelInit(JFrame frame) {

		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 0, 1280, 300);
		this.setLayout(null);
		
		Document doc = null;
		Elements elem = new Elements();
		Element href, text;
		String imagehref, imageTitle;
		String URL = "https://olympics.com/tokyo-2020/ko/"; // 도쿄올림픽 사이트
		
		try {
			Connection connection = Jsoup.connect(URL);
					
			doc = connection.get();
			
			elem = doc.select(".tk-homepage__slider");
			
			page = 0;
			
			for(int i=0; i<5; i++) {
				switch(i) {
					 case 0:
						href = elem.select("a").get(0);
						text = elem.select("img").get(0);
					    
						imagehref = href.attr("href").toString();
						imageTitle = text.attr("alt").toString();
						
						String url0 = text.getElementsByAttribute("src").attr("src");

						try {
							URL imgUrl = new URL(url0);
							BufferedImage jpg = ImageIO.read(imgUrl);
							File file = new File("./img/"+page+".jpg");
							ImageIO.write(jpg, "jpg", file);
							ImagePrint(page, imagehref, imageTitle);
						
						} catch(IOException e1) {
							e1.printStackTrace();
						}
						break;
					 case 1:
						href = elem.select("a").get(1);
						text = elem.select("img").get(1);
					    
						imagehref = href.attr("href").toString();
						imageTitle = text.attr("alt").toString();
						
						String url1 = text.getElementsByAttribute("src").attr("src");

						try {
							URL imgUrl = new URL(url1);
							BufferedImage jpg = ImageIO.read(imgUrl);
							File file = new File("./img\\"+page+".jpg");
							ImageIO.write(jpg, "jpg", file);
							ImagePrint(page, imagehref, imageTitle);
						
						} catch(IOException e1) {
							e1.printStackTrace();
						}
						break;
					 case 2:
						href = elem.select("a").get(2);
						text = elem.select("img").get(2);
					    
						imagehref = href.attr("href").toString();
						imageTitle = text.attr("alt").toString();
						
						String url2 = text.getElementsByAttribute("src").attr("src");

						try {
							URL imgUrl = new URL(url2);
							BufferedImage jpg = ImageIO.read(imgUrl);
							File file = new File("./img\\"+page+".jpg");
							ImageIO.write(jpg, "jpg", file);
							ImagePrint(page, imagehref, imageTitle);
						
						} catch(IOException e1) {
							e1.printStackTrace();
						}
						break;
					 case 3:
						href = elem.select("a").get(3);
						text = elem.select("img").get(3);
					    
						imagehref = href.attr("href").toString();
						imageTitle = text.attr("alt").toString();
						
						String url3 = text.getElementsByAttribute("src").attr("src");
						
						try {
							URL imgUrl = new URL(url3);
							BufferedImage jpg = ImageIO.read(imgUrl);
							File file = new File("./img\\"+page+".jpg");
							ImageIO.write(jpg, "jpg", file);
							ImagePrint(page, imagehref, imageTitle);
						
						} catch(IOException e1) {
							e1.printStackTrace();
						}
						break;
					 case 4:
						href = elem.select("a").get(4);
						text = elem.select("img").get(4);
					    
						imagehref = href.attr("href").toString();
						imageTitle = text.attr("alt").toString();
						
						String url4 = text.getElementsByAttribute("src").attr("src");

						try {
							URL imgUrl = new URL(url4);
							BufferedImage jpg = ImageIO.read(imgUrl);
							File file = new File("./img\\"+page+".jpg");
							ImageIO.write(jpg, "jpg", file);
							ImagePrint(page, imagehref, imageTitle);
						
						} catch(IOException e1) {
							e1.printStackTrace();
						}
						break;
				}
				
				page += 1;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	public void ImagePrint(int page, String imagehref, String imageTitle) {
		
		ImageIcon icon1 = new ImageIcon("./img/"+page+".jpg");
		
		Image playerImg = icon1.getImage();
		Image changeImg = playerImg.getScaledInstance(200, 140, Image.SCALE_SMOOTH);
		
		ImageIcon changeIcon = new ImageIcon(changeImg);
		
		JLabel pictureLabel1 = new JLabel(changeIcon);
		pictureLabel1.setBounds(40+(230*page), 0, 200, 140);
		this.add(pictureLabel1);
		TitlePrint(pictureLabel1, imageTitle);
		
		pictureLabel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
			         
			        Desktop.getDesktop().browse(new URI(imagehref));
			         
			    } catch (IOException | URISyntaxException e1) {
			        e1.printStackTrace();
			    }
			}
		});
	}
	
	public void TitlePrint(JLabel image, String imageTitle) {
		
		JLabel text1 = new JLabel("이미지라벨");
		text1.setBounds(10, 0, 200, 140);
		text1.setFont(new Font("맑은고딕", Font.BOLD, 16));
		text1.setForeground(Color.white);
		text1.setText(imageTitle);
		image.add(text1);
		text1 = new JLabel("");
		
	}
}