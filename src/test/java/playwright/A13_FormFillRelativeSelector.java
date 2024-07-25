package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A13_FormFillRelativeSelector {
	static Page page;
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
		page = browser.newPage();
		
		page.navigate("https://demo.automationtesting.in/Register.html");
		// mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://www.orangehrm.com/en/30-day-free-trial/"
		// playwright.$("input:below(:text('Full Name'))")
	     page.locator("input:below(label:text('Full Name* '))").first().fill("Reka");
	     page.locator("input:below(label:text('Address'))").first().fill("Reka");
	     page.locator("input:below(label:text('Email address*'))").first().fill("Reka");

//	https://automationpractice.com/index.php
//	page.locator("input:near(:text('Newsletter'))").fill("reka");
//	page.locator("span.price.product-price:below(:text('Faded Short Sleeve T-Shirts'))");
	
	
	
	}
}
