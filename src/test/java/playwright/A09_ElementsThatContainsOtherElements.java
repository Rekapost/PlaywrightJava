package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A09_ElementsThatContainsOtherElements {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage(); 
		
//		page.navigate("https://www.orangehrm.com/30-day-free-trial/");
//		Locator loc=page.locator("select#Form_getForm_Country:has(option[value='India'])");
//	    loc.allInnerTexts().forEach(e->System.out.println(e));
	
	    //playwright.$("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])")
	    page.navigate("https://www.amazon.com/");
	    Locator loc=page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
	    loc.allInnerTexts().forEach(e->System.out.println(e));
	}
}
