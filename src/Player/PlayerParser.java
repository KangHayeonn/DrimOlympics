package Player;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import GameInf.SearchVO;

public class PlayerParser {
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
	public static final String WEB_DRIVER_PATH = "src/chromedriver.exe"; // 드라이버 경로
	
	static void PlayerSearch(String name, String event, String country, ArrayList<PlayerVO> SL) {

			WebDriver driver;
			WebElement rank;
			
			String Rank = " ";
			String Carrier = " ";
			
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
			String url = "https://olympics.com/tokyo-2020/olympic-games/ko/results/all-sports/athletes.htm"; // 인물 검색창

			ChromeOptions options = new ChromeOptions();
			
			//options.addArguments("headless");

			driver = new ChromeDriver(options);
			driver.get(url);
			
			try {Thread.sleep(2000);} catch (InterruptedException e) {}
			
			WebElement cookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
			cookies.click();

			//종목
			WebElement eventDrop = driver.findElement(By.id("entries-search-sport"));
			eventDrop.click();
			//event 선택
			for(int i=1;i<=47;i++) {
				WebElement eventSearch1 = driver.findElement(By.xpath("//*[@id=\"medallist-discipline\"]/li["+i+"]"));
				if(event.toString().equals(eventSearch1.getText().toString())) {

					eventSearch1.click();
					break;
				}
			}
			//country 선택
			WebElement countryDrop = driver.findElement(By.id("entries-search-country"));
			countryDrop.click();
			
			for(int i=1;i<=207;i++) {
				String countrySearch = driver.findElement(By.xpath("//*[@id=\"medallist-country\"]/li["+i+"]")).getText();
				if(country.toString().equals(countrySearch.toString())) {

					driver.findElement(By.xpath("//*[@id=\"medallist-country\"]/li["+i+"]")).click();
					break;
				}
			}
			//이름 검색
			WebElement NameSearch = driver.findElement(By.id("entries-search-name"));
			NameSearch.clear();
			NameSearch.sendKeys(name);

			WebElement nameSearchBtn = driver.findElement(By.className("input-group-text"));

			nameSearchBtn.click();
			System.out.println(name + " / " + event + " / " + country);
			
			WebElement primaryName = driver.findElement(By.xpath("/html/body/main/div/div[1]/div[1]/div[3]/div/div[1]/div/table/tbody/tr[1]/td[1]/div/a/span[2]"));
			primaryName.click();
			
			//List<WebElement> el1 = driver.findElements(By.className("col-sm-6"));
			//flex-grow-1
			
			try {Thread.sleep(2000);} catch (InterruptedException e) {}
			
			List<WebElement> el1 = driver.findElements(By.className("eventTagLink"));
		
			
			for (int i = 0; i < el1.size(); i++) {
				int j = 1;
				
					rank = driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div/div[1]/div[1]/div[2]/a[1]/div/table/tbody/tr[" + j + "]/td[3]"));
					Carrier = el1.get(i).getText();
					
					SL.add(new PlayerVO(Carrier, Rank));
					
					j++;
			}
			
			try {Thread.sleep(1000);} catch (InterruptedException e) {}

			try {
				if(driver != null) {
					driver.close(); 
					driver.quit();
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
	}
}