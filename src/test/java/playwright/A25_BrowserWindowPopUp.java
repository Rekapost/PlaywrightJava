package playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A25_BrowserWindowPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		// each browser has many browser context , each browser context has many page context , 
		// each page context having different url and corresponding elements 
		// we can do multi browser and multi tab testing
		
        //Creates a new browser context. 
		//It won't share cookies/cache with other browser contexts. 

		BrowserContext browser1=browser.newContext();	
		BrowserContext browser2=browser.newContext();
		
		// orangehrm browser is openeing one tab/window orangehrmyoutube this is called window popup
		// 1. open a new tab/window popup after clickeing on link on the parent page 
		Page page1=browser1.newPage();
		page1.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Page orangeHRMyoutubePopup=page1.waitForPopup(()->{
			page1.click("a[href='https://www.youtube.com/c/OrangeHRMInc']");						
		});
		orangeHRMyoutubePopup.waitForLoadState();
		System.out.println("pop up window title : "+ orangeHRMyoutubePopup.title());
		System.out.println("pop up window url : "+ orangeHRMyoutubePopup.url());
		orangeHRMyoutubePopup.close();
		System.out.println("Parent window  title : "+ page1.title());
		page1.close();
		

/*		// open new blank window 
        // open new blank tab/window popup and enter the new url  
		Page page2=browser2.newPage();
		page2.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Page popup2=page2.waitForPopup(()->{
			page2.click("a[target='_blank']");	  // open a new tab window 					
		});
		popup2.waitForLoadState();
		popup2.navigate("https://www.amazon.com");
		System.out.println("pop up window title : "+ popup2.title());
		popup2.close();
		System.out.println("Parent window  title : "+ page2.title());
		page2.close();
*/
	}
}
