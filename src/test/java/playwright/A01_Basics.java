package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A01_Basics {
	public static void main(String[] args) {
		Playwright playwright= Playwright.create();
		LaunchOptions options = new LaunchOptions();
		options.setChannel("chrome");
		options.setHeadless(false);
		Browser browser=playwright.chromium().launch(options);
		//Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.amazon.com");
		String title=page.title();	
		System.out.println(" Title : "+title);
		String url= page.url();
		System.out.println(" URL : "+url);
		browser.close();
		playwright.close();		
	}
}

