package Learning;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Relative_CSS_Selector {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext context=browser.newContext();
        Page page=context.newPage();
        
        page.navigate("https://www.orangehrm.com/en/book-a-free-demo/");
        Locator mail=page.locator("div:above(div[id='Form_getForm_Country_Holder'])").first();
        mail.fill("Narendran");
        
        Locator phnum=page.locator("div:below(div[id='Form_getForm_Country_Holder'])").first();
        phnum.fill("8667036022"); 
        
       Locator leftloc= page.locator("div:left-of(div[id='Form_getForm_Country_Holder'])");
      List<String> leftcontents=leftloc.allInnerTexts();
       for (String left : leftcontents) {
		System.out.println(left);
		
		 Locator rightloc= page.locator("div:right-of(div[id='Form_getForm_Country_Holder'])");
	      List<String> rightcontents=rightloc.allInnerTexts();
	       for (String right : rightcontents) {
			System.out.println(right);
			
			
	}
	}

}
}
