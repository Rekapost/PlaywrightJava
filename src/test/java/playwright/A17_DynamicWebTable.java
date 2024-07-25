package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A17_DynamicWebTable {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
//		page.navigate("https://datatables.net/extensions/select/examples/checkbox/checkbox.html");
//		Locator row=page.locator("table#example tr");
//		row.locator(":scope", new Locator.LocatorOptions()
//				.setHasText("Ashton Cox"))
//					.locator(".dt-select")
//						.click();
//		
//		row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));

		
		page.navigate("https://primeng.org/");
		
		// Wait for the page to load
		//page.waitForLoadState(Page.LoadState.NETWORKIDLE);
		
		// Wait for the table to be visible and interactable
		page.waitForSelector("table#pn_id_1-table");

		// Wait for the table to be visible and interactable
		page.waitForSelector("table#pn_id_1-table td", new Page.WaitForSelectorOptions().setTimeout(60000));
		
		// Scroll to the table
		page.evaluate("document.querySelector('table#pn_id_1-table').scrollIntoView()");

		Locator row=page.locator("table#pn_id_1-table td");
		int noOfRows=row.count();
		System.out.println(noOfRows);
		
		row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
		
		/* **********************  NOT WORKING ***********************/
//		row.locator(":scope", new Locator.LocatorOptions()
//				.setHasText(" Art Venere "))
//					.locator(".p-checkbox p-component")
//						.click();

    }
}
