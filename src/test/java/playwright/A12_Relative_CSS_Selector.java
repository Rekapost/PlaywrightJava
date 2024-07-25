package playwright;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A12_Relative_CSS_Selector {
	static Page page;
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
		page = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		//  mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://selectorshub.com/xpath-practice-page/"
		//  selecting elements based on layout -Relative Locators
		//	left of
		//	right of
		//	below
		//	above
		//	near
		//	near,200
		//  playwright.$("input[type='checkbox']:left-of(:text('Joe.Root'))")	
		//  playwright.$$("input[type='checkbox']:left-of(:text('Joe.Root'))")
		
		// LEFT OF
		//page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();
		selectUser("Joe.Root");
		selectUser("Jasmine.Morgan");
		
		//RIGHT OF
		// String userRole=page.locator("td:left-of(:text('Joe.Root'))").first().textContent();
		// System.out.println(userRole);
		System.out.println(getUserRole("Joe.Root"));
		
		//ABOVE
		//playwright.$("a:above(:text('Joe.Root'))")
	    String aboveUser=page.locator("a:above(:text('Joe.Root'))").first().textContent();
		System.out.println(aboveUser);
		
		//BELOW
		String belowUser=page.locator("a:below(:text('Joe.Root'))").first().textContent();
		System.out.println(belowUser);
		
		//NEAR 
		//near joe.root give me all td's
		//playwright.$$("td:near(:text('Joe.Root'))")
		String nearUser=page.locator("td:near(:text('Joe.Root'))").first().textContent();
		System.out.println(nearUser);
		
		List<String> nearLocators=page.locator("td:near(:text('Joe.Root'))").allInnerTexts();
		nearLocators.stream().forEach(e -> System.out.println(e));
		
		//within 400 pixel
		//playwright.$$("td:near(:text('Joe.Root'),400)")
		String nearUser400=page.locator("td:near(:text('Joe.Root'),400)").first().textContent();
		System.out.println(nearUser400);
		
		List<String> nearLocators400=page.locator("td:near(:text('Joe.Root'),400)").allInnerTexts();
		nearLocators400.stream().forEach(e -> System.out.println(e));
		
		for(String e :nearLocators400) {
			System.out.println(e);
		}
		
	}
	public static void selectUser(String userName) {
		//page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))");
		page.locator("input[type='checkbox']:left-of(:text('"+userName+"'))").first().click();
	}
	
	public static String getUserRole(String userRole) {
		return page.locator("td:right-of(:text('"+userRole+"'))").first().textContent();	
	}
	
	
}
