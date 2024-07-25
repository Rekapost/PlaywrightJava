package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A10_CommaSelectors {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
	    //mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://academy.naveenautomationlabs.com/"
		page.navigate("https://academy.naveenautomationlabs.com/");
	    //playwright.$("span:has-text('SignIn'), span:has-text('Login')")
		//playwright.$("text='Login'")		
	    //page.locator("a:has-text('Login'), a:has-text('LogIn'), a:has-text('SignIn')")).click();
		page.locator("a:has-text('Login'), "
				+ "a:has-text('LogIn'),"
				+ " a:has-text('SignIn')").click();
		//playwright.$("a:has-text('Login'), a:has-text('WebDriver APIs'), a:has-text('Webinars')")
	    //playwright.$$("a:has-text('Login'), a:has-text('WebDriver APIs'), a:has-text('Webinars')")
	   Locator ele= page.locator("a:has-text('Login'), "
	    		+ "a:has-text('WebDriver APIs'), "
	    		+ "a:has-text('Webinars')");
		System.out.println(ele.count());
		if(ele.count()==3) {
			System.out.println("PASS");
			}
		else {
			System.out.println("FAIL");
			}
		}
}
