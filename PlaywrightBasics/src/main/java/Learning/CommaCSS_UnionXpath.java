package Learning;



import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaCSS_UnionXpath {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext context=browser.newContext();
        Page page=context.newPage();
        
        page.navigate("https://amazon.in/");
 //Comma seperated CSS list 
      
        /*Locator loc=page.locator("span:has-text('cart'), span:has-text('Sign in'), span:has-text('Mothers')");
        Locator loc=page.locator("span:has-text('Mothers')");
        List<String> alltexts=loc.allInnerTexts();
        
        for (String a : alltexts) {
        	System.out.println(a);	
		}*/
        
 //Xpath Union
        
       Locator loc=page.locator("//span[@class='nav-line-2'] | //div[@id='nav-cart-text-container']");
	    List<String> texts= loc.allInnerTexts();
	    
	    for (String b : texts) {
	    	System.out.println(b);
			
		}
	}

}
