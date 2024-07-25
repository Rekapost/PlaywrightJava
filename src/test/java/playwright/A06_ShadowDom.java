package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A06_ShadowDom {
	public static void main(String[] args) {

	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	
	Page page = browser.newPage();

//	Page -->DOM --> Shadow DOM --> elements
//	page.navigate("https://books-pwakit.appspot.com/");
//	page.locator("book-app[apptitle='BOOKS'] #input").fill("Reka");
//	String text=page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
//	System.out.println(text);

//	Page -->DOM --> iFrame -->Shadow DOM --> elements
	page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
	//page.locator("https://selectorshub.com/xpath-practice-page/");
	page.frameLocator("#pact").locator("div#snacktime #tea").fill("Ginger Masala Tea");
	
	
	}
}
