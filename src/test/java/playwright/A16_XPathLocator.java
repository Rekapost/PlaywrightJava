package playwright;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A16_XPathLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
//		page.navigate("https://www.amazon.com/");
//		 1.
//		page.locator("//input[@id='twotabsearchtextbox']").fill("Android");
//		 2.
//		Locator totalAmazonLinks=page.locator("//a[contains(text(),'Amazon')]");
//	    System.out.println(totalAmazonLinks.count());
		
//	    List<String> textList= totalAmazonLinks.allInnerTexts();	
//	    for (String e:textList ) {
//	    	System.out.println(e);
//	    }
	    //3.
		page.navigate("https://selectorshub.com/xpath-practice-page/");
//	    1.
//		page.locator("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']").click();
	
		Locator  checkboxes=page.locator("//table[@id='resultTable']//input[@type='checkbox']");
		for(int i=0; i<checkboxes.count(); i++) {
			checkboxes.nth(i).click();
		}
	}

}
