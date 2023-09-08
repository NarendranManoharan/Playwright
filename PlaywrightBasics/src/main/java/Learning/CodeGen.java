package Learning;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.*;

public class CodeGen {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
      context.tracing().start(new Tracing.StartOptions().setScreenshots(false).setSnapshots(true));
      
      Page page = context.newPage();
      page.navigate("https://lmstest.pilship.com/");
      page.navigate("https://lmstest.pilship.com/opuscntr/SignOn.do");
      page.locator("#j_username").click();
      page.locator("#j_username").fill("INNARMAN");
      page.locator("#j_password").click();
      page.locator("#j_password").fill("July@123");
      page.locator("#j_password").press("Enter");
      
      context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("Trace.zip")));
    }
  }
}