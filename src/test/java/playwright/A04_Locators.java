package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A04_Locators {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext();
		Page page = context.newPage();


		// Navigate to the specified URL
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");

//************************   SINGLE ELEMENT    ************************ 
		Locator contact = page.locator("text = CONTACT SALES");

		// Get the count of elements matching the locator
		int totalLogins = contact.count();
		System.out.println("Total login buttons: " + totalLogins);

		String innerText = contact.last().innerText();
		System.out.println("InnerText of the first login button: " + innerText);

		contact.last().click();

//************************ MULTIPLE ELEMENTS ******************************
		Locator countryList = page.locator("select#Form_getForm_Country");
		int listOfCountries = countryList.count();
		System.out.println(listOfCountries);
		
		//1
		for (int i = 0; i < listOfCountries; i++) {
			String countriesName = countryList.nth(i).textContent();
			System.out.println(countriesName);
		}
		
		//2
/*		List<String> optionsTextList=countryList.allTextContents();
		for(String e: optionsTextList) {
			System.out.println(e);
		}
*/		
		//3
/*		List<String> optionsTextList=countryList.allTextContents();
		optionsTextList.forEach(ele -> System.out.println(ele));
*/		
		
		//*******************   TEXT Locators *******************************
/*		Locator privacyPolicy = page.locator("text=Privacy Policy");
		int privacyCount=privacyPolicy.count();
		System.out.println(privacyCount);
		for(int i=0;i<privacyCount;i++) {
			String privacyText=privacyPolicy.nth(i).textContent();
			System.out.println(privacyText);
			if(privacyText.contains("Service Privacy Policy")) {
				privacyPolicy.nth(i).click();
				break;
			}			
		}
*/		
		// div.well h1:has-text('Contact Sales')
		// form input:has-text('Login')

		String header = page.locator("h1:has-text('Contact Sales')").textContent();
		System.out.println(header);
		
		//String pageHeader = page.locator("'Unlock the Full Potential of OrangeHRM!'").textContent();
		String pageHeader = page.locator("text=Unlock the Full Potential of OrangeHRM!").textContent();
		System.out.println(pageHeader);
		
		//page.locator(
		browser.close();
		playwright.close();	
	}
}
