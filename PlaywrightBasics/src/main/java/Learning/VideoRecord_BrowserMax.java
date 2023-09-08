package Learning;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecord_BrowserMax {
	

	public static void main(String[] args) {
		
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int height=(int)screensize.getHeight();
		int width=(int)screensize.getWidth();
		
		Playwright playwright=Playwright.create();
	Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
     BrowserContext context= browser.newContext(new Browser.NewContextOptions().setViewportSize(1366, 768).setRecordVideoDir(Paths.get("videorecord/")));
     Page page=  context.newPage();
       page.navigate("https://lmstest.pilship.com/");
       page.navigate("https://lmstest.pilship.com/opuscntr/SignOn.do");
       page.locator("#j_username").click();
       page.locator("#j_username").fill("INNARMAN");
       page.locator("#j_password").click();
       page.locator("#j_password").fill("July@123");
       page.locator("#j_password").press("Enter");
       
       page.close();
       context.close();
       playwright.close();
       
	}

}
