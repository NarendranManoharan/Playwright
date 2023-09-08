package Learning;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class Browser_Context {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();

		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		
		BrowserContext context1=browser.newContext();
		Page lms=context1.newPage();
		lms.navigate("https://lmstest.pilship.com/");
		 lms.locator("#j_username").fill("INNARMAN");
		String lmsTitle=lms.title();
		System.out.println("LMS Title is:"+ lmsTitle);
		context1.close();
		
		
		BrowserContext context2=browser.newContext();
		Page amazon=context2.newPage();
		amazon.navigate("https://www.amazon.in");
		String amazonTitle=amazon.title();
		System.out.println("Amazon Title is:"+ amazonTitle);
		context2.close();
		
		
		playwright.close();

		
	}
}
