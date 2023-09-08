package Learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class First_test {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright=Playwright.create();
		
		
		  LaunchOptions launchOptions=new LaunchOptions();
		  launchOptions.setHeadless(false); 
		 // launchOptions.setChannel("chrome");
		 

			Browser browser=playwright.firefox().launch(launchOptions);
			BrowserContext context=browser.newContext();
			
			Page page=context.newPage();
			
			page.navigate("https://lmstest.pilship.com/");
			Thread.sleep(2000);
			String Pagetitle=page.title();
			System.out.println(Pagetitle);
			
		    browser.close();
			playwright.close();


	}

}
