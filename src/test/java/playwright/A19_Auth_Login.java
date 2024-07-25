package playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A19_Auth_Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context=	browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLogin.json")));
		Page page = context.newPage();
		page.navigate("https://practice.automationtesting.in/my-account/");
		
	}

}
