package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A11_XpathUnion {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		//playwright.$("//a[text()='Signin'] | //a[text()='Login']")
		Locator login=page.locator("//a[text()='Signin'] | //a[text()='Login']");
		System.out.println(login.textContent());
		login.click();
		}
}
