package playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A07_VisibleElement {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));		
		Page page = browser.newPage();
	  
//	button:visible
//  page.locator("button:visible").textContent();
		
//	button >> visible=true
//	page.locator("button >> visible=true").textContent();
		
		page.navigate("https://www.amazon.com/");
		List <String> linksText =page.locator("a:visible").allInnerTexts();
		for(int i=0;i<linksText.size();i++) {
			System.out.println(linksText.get(i));
		}
			
		int imageCount=page.locator("xpath=//img >> visible=true").count();
		System.out.println(imageCount);
		
		//text=Login >> visible=true
		
	}
}
