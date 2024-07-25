package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A14_NthElement {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.bigbasket.com/");
		//mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://www.bigbasket.com/"
		//playwright.$("footer div.container li a")
	    //playwright.$$("footer div.container li a")
		
	    Locator lastEle=page.locator("footer div.container li a >> nth=-1");
		String last_ele=lastEle.textContent();
	    System.out.println(last_ele);
	    
		Locator firstEle=page.locator("footer div.container li a >> nth=0");
		String first_ele=firstEle.textContent();
	    System.out.println(first_ele);
	    firstEle.click();
	}
}