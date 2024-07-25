package playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A18_Auth_AutomaticLogin {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext  context=browser.newContext();
		Page page = context.newPage();
		page.navigate("https://practice.automationtesting.in/my-account/");
	
		page.fill("#username", "rekaharisri@gmail.com");
		page.fill("#password", "Admin123///888'''");
		page.locator("//input[@class='woocommerce-Button button']").first().click();    
	
	    context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLogin.json")));
	
	}		
}
