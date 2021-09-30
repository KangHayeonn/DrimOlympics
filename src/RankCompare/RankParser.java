package RankCompare;

import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RankParser {
   
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; //드라이버 ID
    public static final String WEB_DRIVER_PATH = "src/chromedriver.exe"; //드라이버 경로
	WebDriver driver;
	
	//테이블에 사용할 데이터 넘겨주는 목적의 리스트 
	ArrayList<String> game_s = new ArrayList<>();
	ArrayList<String> m_players = new ArrayList<>();
	ArrayList<String> m_ranks = new ArrayList<>();
	ArrayList<String> f_players = new ArrayList<>();
	ArrayList<String> f_ranks = new ArrayList<>();
    
	public void addList() {

	 //드라이버 설정
		
		try {
	 			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		
	         //크롬 설정을 담은 객체 생성
	 		ChromeOptions options = new ChromeOptions();
	 		//options.addArguments("--disable-popup-blocking");
	 	//	options.addArguments("--headless"); 
	 		//options.addArguments("--no-sandbox");

	 		
	 		//위에서 설정한 옵션을 담은 드라이버 객체 생성
	 		driver = new ChromeDriver(options);
	 		
	 		//과정 보이게 함
	 		//options.addArguments("headless");

	 		//이동을 원하는 url(나무위키)
	 		String url = "https://namu.wiki/w/%EB%8C%80%ED%95%9C%EB%AF%BC%EA%B5%AD%20%EC%98%AC%EB%A6%BC%ED%94%BD%20%EB%8C%80%ED%91%9C%ED%8C%80";
	 		
	 		//WebDriver을 해당 url로 이동한다.
	 		driver.get(url);
	 		
	 		//브라우저 이동시 생기는 로드시간을 기다린다.
	 		try {Thread.sleep(1000);} catch (InterruptedException e) {}
	 		
	 		List<WebElement> game = new ArrayList<>();
	 		List<WebElement> m_player = new ArrayList<>();
	 		List<WebElement> m_rank = new ArrayList<>();
	 		List<WebElement> f_player = new ArrayList<>();
	 		List<WebElement> f_rank = new ArrayList<>();
	 		List<String> game_l = new ArrayList<>();
	 		
	 		//나무위키 표 크롤링
	 		for(int i = 3; i < 39; i++) {
	 		    String game_xpath ="//*[@id=\"app\"]/div/div[2]/article/div[3]/div[2]/div/div/div[12]/div/div[1]/div/table/tbody/tr[" + i+ "]/td[1]/div/strong";
	 		    game.add(driver.findElement(By.xpath(game_xpath)));
	 		    String m_player_xpath ="//*[@id=\"app\"]/div/div[2]/article/div[3]/div[2]/div/div/div[12]/div/div[1]/div/table/tbody/tr[" + i +"]/td[2]/div";
	 		    m_player.add(driver.findElement(By.xpath(m_player_xpath)));
	 		    String m_rank_xpath ="//*[@id=\"app\"]/div/div[2]/article/div[3]/div[2]/div/div/div[12]/div/div[1]/div/table/tbody/tr[" + i + "]/td[4]/div";
	 		    m_rank.add(driver.findElement(By.xpath(m_rank_xpath)));
	 		    String f_player_xpath ="//*[@id=\"app\"]/div/div[2]/article/div[3]/div[2]/div/div/div[12]/div/div[1]/div/table/tbody/tr[" + i +"]/td[5]/div";
	 		    f_player.add(driver.findElement(By.xpath(f_player_xpath)));
	 		    String f_rank_xpath ="//*[@id=\"app\"]/div/div[2]/article/div[3]/div[2]/div/div/div[12]/div/div[1]/div/table/tbody/tr[" + i + "]/td[7]/div";
	 		    f_rank.add(driver.findElement(By.xpath(f_rank_xpath)));
	 		    
	 		}
	 	

		   for(int j = 0; j < game.size(); j++) {

			   game_s.add(game.get(j).getText());
			   m_players.add(m_player.get(j).getText());
			   m_ranks.add(m_rank.get(j).getText());
			   f_players.add(f_player.get(j).getText());
			   f_ranks.add(f_rank.get(j).getText());
		    
			}
		   
			//1초 대기
			try {Thread.sleep(1000);} catch (InterruptedException e) {}

			
			try {
				//드라이버가 null이 아니라면
				if(driver != null) {
					//드라이버 연결 종료
					driver.close(); //드라이버 연결 해제
					
					//프로세스 종료
					driver.quit();
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
	}
	
	//데이터 넘겨주기
	public void setListGame(ArrayList game_s) {
		this.game_s = game_s;
	}
	
	public ArrayList getListGame() {
		return game_s;
	}
	
    public void setListMP(ArrayList m_players) {
		this.m_players = m_players;
    }
		
    public ArrayList getListMP() {
		return m_players;
	}
     
    public void setListMR(ArrayList m_ranks) {
		this.m_ranks = m_ranks;
    }
		
    public ArrayList getListMR() {
		return m_ranks;
	}
    
    public void setListFP(ArrayList f_players) {
		this.f_players = f_players;
    }
    
    public ArrayList getListFP() {
	    return f_players;
	}
    
    public void setListFR(ArrayList f_ranks) {
		this.f_ranks = f_ranks;
    }
	
    public ArrayList getListFR() {
	     return f_ranks;
    }
}