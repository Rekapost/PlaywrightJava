package playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A22_DownloadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
		Page page = browser.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");
		
		Download download=page.waitForDownload(()-> { 
			page.click("a:text('chromedriver_win32.zip')");
		});
		
		// cancel the download , if u run , u will get null pointer exception
		// download.cancel(); 
		
		// to check if download is failure 
		String failureMessage=download.failure();
		System.out.println("Failure Message "+ failureMessage);
		
		System.out.println(download.url());
		//System.out.println(download.page().title());
		
		String path=download.path().toString();
		System.out.println(path);
		
		download.saveAs(Paths.get("Reka_chrome.zip"));
		
		// GIVE ME THE FILE NAME
		download.suggestedFilename();
	}

}
