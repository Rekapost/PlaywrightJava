package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A20_JavaScriptPopUp {
public static void main(String[] args) {
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
	Page page = browser.newPage();
	page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
	// JS Alerts, Prompt, Confirmation pop ups
//	Google.com -> inspect -> console
//	alert('hi this is reka')
//	prompt('hi this is prompt')
//	confirm("are u sure")
	
	//POP UP ALERT
//	page.click("//button[text()='Click for JS Alert']");
//	String alertTextMessage=page.textContent("#result");
//	System.out.println(alertTextMessage);
	
	
	//Listener Entry -> PLAYWRIGHT HANDLER
//	page.onDialog(dialog -> {
//		String text=dialog.message();
//		System.out.println(text);
//		dialog.accept();          //overloaded method 
//		//dialog.dismiss();
//	});
//	page.click("//button[text()='Click for JS Confirm']");
//	String confirmTextMessage=page.textContent("#result");
//	System.out.println(confirmTextMessage);
	
	
	//Listener Entry -> PLAYWRIGHT HANDLER
	page.onDialog(dialog -> {
		String text=dialog.message();
		System.out.println(text);
		dialog.accept("I am Reka");   //overloaded method 
		//dialog.dismiss();
	});
	page.click("//button[text()='Click for JS Prompt']");
	String promptTextMessage=page.textContent("#result");
	System.out.println(promptTextMessage);
	
   }
}
