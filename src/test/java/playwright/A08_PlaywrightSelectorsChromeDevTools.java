package playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A08_PlaywrightSelectorsChromeDevTools {
public static void main(String[] args) {

	//folder of the project , open cmd 
	//mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://www.amazon.com/"
	
	//playwright.$(text='Registry')
	//playwright.inspect("text=Registry")
	//playwright.$$("text=Amazon Science")
	//playwright.$$(text="Registry")
	//playwright.$("input#twotabsearchtextbox")
	//playwright.inspect("input#twotabsearchtextbox")
	//playwright.$("//input[@id='twotabsearchtextbox']")
	//playwright.$$("a:has-text('Amazon')")	
	//playwright.$("//a[@class='nav-action-signin-button']")
	//playwright.$("//a[@class='nav-action-signin-button']/span")
	//playwright.$(":has-text('Amazon')")
	//playwright.$$(":has-text('Amazon')")
	
	//https://www.orangehrm.com/30-day-free-trial/
	//playwright.$("#Form_getForm_subdomain")
	//playwright.$("input#Form_getForm_subdomain >> visible=true")
	
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
	Page page = browser.newPage();
	page.navigate("https://www.amazon.com/");
	List<String> amazonLinksList=page.locator("a:has-text('Amazon')").allInnerTexts();
	amazonLinksList.stream().forEach(e -> System.out.println(e));
}
}
