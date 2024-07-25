package playwright;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A23_MaximizeBrowser {
	public static void main(String[] args) {
		Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
		//double width= screenSize.getWidth();
		int width=(int)screenSize.getWidth();  // double to int , u need to typecast to send to setViewportSize(width,height)
		int height=(int)screenSize.getHeight();
		System.out.println(width+":"+height);
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//BrowserContext  context=browser.newContext(new Browser.NewContextOptions().setViewportSize(780, 500));	
		BrowserContext  context=browser.newContext(new Browser.NewContextOptions().setViewportSize(width,height));
		Page page = context.newPage();
		page.navigate("https://www.google.com/");
		// to check screesn size
		// https://whatismyviewport.com/
	}
}
