package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A03_BrowserContextTest {
	public static void main(String[] args) {

			Playwright playwright = Playwright.create();
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			
			BrowserContext context1 = browser.newContext();
	        Page page1=context1.newPage();
	        page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
	        page1.fill("#Form_getForm_Name", "Reka");
	        System.out.println(page1.title());
	        
	        BrowserContext context2 = browser.newContext();
	        Page page2=context2.newPage();
	        page2.navigate("https://practice.automationtesting.in/my-account/");
	        page2.fill("#username", "rekaharisri@gmail.com");
	        System.out.println(page2.title());
	               
	        page1.close();
	        context1.close();
	        	        
	        page2.close();
	        context2.close();
	        
	}
}

// it opens in incognito mode , it will not store cookies and caches
