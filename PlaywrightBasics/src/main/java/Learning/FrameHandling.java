package Learning;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class FrameHandling {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
					.setHeadless(false).setChannel("chrome"));
			BrowserContext context = browser.newContext();
			Page lms = context.newPage();
			
			/*page.navigate("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
			
			page.frameLocator("//iframe[@name='globalSqa']").locator("'Selenium 3.0 Training'").click();*/
		
			//String namecontent=content.textContent();
		   // System.out.println(namecontent);
		    
			lms.navigate("https://lmstest.pilship.com");
			lms.locator("#j_username").click();
			lms.locator("#j_username").fill("INNARMAN");
			lms.locator("#j_password").click();
			lms.locator("#j_password").fill("July@123");
			lms.locator("#j_password").press("Enter");
		    //Shadow - DOM
			lms.navigate("https://lmstest.pilship.com/opuscntr/ESM_BKG_0927_POP.do?bkg_no=SIN300995300&bl_no=SIN300995300&bl_tp_cd=D&imp_vvd_flg=undefined&pgmNo=ESM_BKG_0927");
	
			lms.locator("#btn_Print").click();
			System.out.println("not success");
		}
	}

}
