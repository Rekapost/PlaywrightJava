package playwright;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A24_VideoRecording {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
		
		// Create directory if it doesn't exist
				Path videoDir = Paths.get("myvideos");
				if (Files.notExists(videoDir)) {
				    Files.createDirectory(videoDir);
				}
				
		// Configure context for video recording		
//		BrowserContext context=browser.newContext(new Browser
//												.NewContextOptions()
//													.setRecordVideoDir(Paths.get("myvideos")));
		
				BrowserContext context = browser.newContext(new Browser.NewContextOptions()
		                .setRecordVideoDir(videoDir)
		                 .setRecordVideoSize(1280, 720)); // Optional: Set video size
		            
				
		Page page = context.newPage();
		page.navigate("https://practice.automationtesting.in/my-account/");
		
		page.fill("#username", "rekaharisri@gmail.com");
		page.fill("#password", "Admin123///888'''");
		page.locator("//input[@class='woocommerce-Button button']").first().click();    
	
		// Wait for a bit to ensure recording happens
        page.waitForTimeout(5000); // 5 seconds
        
		context.close();
		page.close();
		playwright.close();
	}

}
