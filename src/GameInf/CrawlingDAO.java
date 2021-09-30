package GameInf;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CrawlingDAO {

	static String url = "https://www.naver.com";

	///////////////////////////////////////// 뉴스 출력 부분

	static void NewsCrawling(String newsSearch, ArrayList<SearchVO> SL) {

		WebDriver driver;
		WebElement apply_btn, title, content;

		String newsTitle = null;
		String newsContent = null;

		Game_Parser game_Parser = new Game_Parser();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		driver = new ChromeDriver(options);
		driver.get(url);

		// 검색창 입력
		WebElement search = driver.findElement(By.id("query"));
		search.clear();
		search.sendKeys(newsSearch);

		// 검색 버튼 클릭
		apply_btn = driver.findElement(By.id("search_btn"));
		apply_btn.click();

		List<WebElement> el1 = driver.findElements(By.className("menu"));

		for (int i = 0; i < el1.size(); i++) {
			if (el1.get(i).getText().equals("뉴스")) {
				el1.get(i).click();
				break;
			}
		}

		// 첫번째 뉴스에서 제목과 내용 받아옴
		title = driver.findElement(By.xpath("//*[@id=\"sp_nws1\"]/div[1]/div/a"));
		content = driver.findElement(By.xpath("//*[@id=\"sp_nws1\"]/div[1]/div/div[2]"));

		if (title != null) {
			newsTitle = title.getText();
		} else {
			newsTitle = "검색어가 없습니다.";
		}
		
		if (content != null) {
			newsContent = content.getText();
		} else {
			newsContent = "검색어가 없습니다.";
		}

		SL.add(new SearchVO(newsTitle, newsContent));

		System.out.println(newsTitle + "\n" + newsContent);

		try {
			if (driver != null) {
				driver.close();
				driver.quit();
			}

		} catch (Exception e1) {
			throw new RuntimeException(e1.getMessage());
		}
	}

	///////////////////////////////////////// 메달 순위 부분

	static void RankCrawling(ArrayList<RankVO> SL) {

		WebDriver driver;
		WebElement apply_btn, country, gold, silver, bronze, total;

		String Country = " ";
		String Gold = " ";
		String Silver = " ";
		String Bronze = " ";
		String Sum = " ";

		Game_Parser game_Parser = new Game_Parser();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		driver = new ChromeDriver(options);
		driver.get(url);

		// 검색창 입력
		WebElement search = driver.findElement(By.id("query"));
		search.clear();
		search.sendKeys("도쿄올림픽");

		// 검색 버튼 클릭
		apply_btn = driver.findElement(By.id("search_btn"));
		apply_btn.click();

		for (int j = 1; j <= 10; j++) {

			country = driver.findElement(
					By.xpath("//*[@id=\"main_pack\"]/section[2]/div/div[2]/div[2]/div[3]/div/div[1]/table/tbody/tr[" + j
							+ "]/td[1]/p/a[2]"));
			gold = driver.findElement(
					By.xpath("//*[@id=\"main_pack\"]/section[2]/div/div[2]/div[2]/div[3]/div/div[1]/table/tbody/tr[" + j
							+ "]/td[2]/p"));
			silver = driver.findElement(
					By.xpath("//*[@id=\"main_pack\"]/section[2]/div/div[2]/div[2]/div[3]/div/div[1]/table/tbody/tr[" + j
							+ "]/td[3]/p"));
			bronze = driver.findElement(
					By.xpath("//*[@id=\"main_pack\"]/section[2]/div/div[2]/div[2]/div[3]/div/div[1]/table/tbody/tr[" + j
							+ "]/td[4]/p"));
			total = driver.findElement(
					By.xpath("//*[@id=\"main_pack\"]/section[2]/div/div[2]/div[2]/div[3]/div/div[1]/table/tbody/tr[" + j
							+ "]/td[5]/p"));

			Country = new String(country.getText());
			Gold = new String(gold.getText());
			Silver = new String(silver.getText());
			Bronze = new String(bronze.getText());
			Sum = new String(total.getText());

			SL.add(new RankVO(Country, Gold, Silver, Bronze, Sum));
		}

		try {
			if (driver != null) {
				driver.close();
				driver.quit();
			}

		} catch (Exception e1) {
			throw new RuntimeException(e1.getMessage());
		}
	}

}
