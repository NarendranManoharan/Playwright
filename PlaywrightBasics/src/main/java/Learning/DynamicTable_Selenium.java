package Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DynamicTable_Selenium {

	public static void main(String[] args) {
	
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext context=browser.newContext();
        Page page=context.newPage();
        
        page.navigate("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html#google_vignette");
  
  //Verify that there are only 4 structure values present in the table with Selenium
        
        List<String> loc=page.locator("//tbody[@style=\"margin:0;padding:0\"]/tr/th").allInnerTexts();
        System.out.println(loc.size());
     
        for (String StructureName : loc) {
			System.out.println(StructureName);
        }
   //Verify that the 6th row of the table (Last Row) has only two columns with Selenium
			
			int RowCount=page.locator("//tfoot[@style=\"margin:0;padding:0\"]/tr/*").count();
			System.out.println(RowCount);
			
  //Find the tallest structure in the table with Selenium
			
			List<Integer> heights=new ArrayList<Integer>();
			 List<String> AllHeightTexts=page.locator("//tbody[@style=\"margin:0;padding:0\"]/tr[*]/td[3]/span").allInnerTexts();
			 
			
			 
			 for(String text: AllHeightTexts ) {
				String ReplacedText=text.replace("m", "");
					heights.add(Integer.parseInt(ReplacedText));
			 }
			 
			Integer maxvalue=Collections.max(heights);
			
			System.out.println(heights);
			
			System.out.println(maxvalue);
			
			//*[text()='829m']/parent::td//preceding-sibling::th
			
			String xpathvalue=maxvalue.toString();
			System.out.println("xpath=//*[text()='"+xpathvalue+"m']/parent::td//preceding-sibling::th/span");
			String finaltext=page.locator("xpath=//*[text()='"+xpathvalue+"m']/parent::td//preceding-sibling::th/span").textContent();
			
			System.out.println(finaltext);
			
			
		}
       

}
