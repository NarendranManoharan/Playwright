package Learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DynamicTable_handling {
   
	
	public static void main(String[] args) {

		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext context=browser.newContext();
        Page page=context.newPage();
        
        page.navigate("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html#google_vignette");
  //select particular value in table
        Locator table=page.locator("//table[@class='tsc_table_s13']//tr");
       String text= table.locator(":scope", new Locator.LocatorOptions().setHasText("Financial Center")).locator("tr td >> nth=2").textContent();
       System.out.println(text);
     
       //select all the locators in webtable
       table.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
}
}
