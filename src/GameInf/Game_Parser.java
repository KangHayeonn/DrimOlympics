package GameInf;

public class Game_Parser {
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
	public static final String WEB_DRIVER_PATH = "src/chromedriver.exe"; // 드라이버 경로
	
	public Game_Parser() {
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
