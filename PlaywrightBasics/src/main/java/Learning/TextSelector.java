package Learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page=browser.newContext().newPage();
		
		page.navigate("https://lmstest.pilship.com/");
		String AddonText=page.locator("'OuR Website'").textContent();
		System.out.println(AddonText);

	}

}
