package Learning;

import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcepts {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext context=browser.newContext();
		Page page=context.newPage();
		 page.navigate("https://lmstest.pilship.com");
	      page.locator("#j_username").click();
	      page.locator("#j_username").fill("INNARMAN");
	      page.locator("#j_password").click();
	      page.locator("#j_password").fill("July@123");
	      page.locator("#j_password").press("Enter");
		
		Locator login=page.locator("//*[@data-list='up-list']");
		login.first().click();
		int count=login.count();
		System.out.println(count);
		
		for (int i = 0; i < count; i++) {
			
			String content=login.nth(i).textContent();
			System.out.println(content);
		}
		
		/*
		 * List<String> listofvalues=login.allTextContents();
		 * 
		 * for (String a : listofvalues) { System.out.println(a); }
		 */
		
		page.navigate("https://lmstest.pilship.com/opuscntr/ESM_BKG_0927_POP.do?bkg_no=SIN300995300&bl_no=SIN300995300&bl_tp_cd=D&imp_vvd_flg=undefined&pgmNo=ESM_BKG_0927");
		
		page.locator("#btn_Print").click();
		page.locator("print-preview-app").click();
	}

}
