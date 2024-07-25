package playwright;
import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

	public class A02_Inspector_TracerTest {
	  public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	    		  //browser.newContext();            
	       
		   // Start tracing before creating / navigating a page.
		      context.tracing().start(new Tracing.StartOptions()
		        .setScreenshots(true)
		        .setSnapshots(true)
		        .setSources(true));
		      	      
	      Page page = context.newPage();	 	      
	      page.navigate("https://practice.automationtesting.in/my-account/");
	      page.getByLabel("Username or email address *").click();
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
	      page.getByLabel("Username or email address *").click();
	      page.getByLabel("Username or email address *").fill("rekaharisri@gmail.com");
	      page.locator("#password").click();
	      page.locator("#password").fill("Admin123///888'''");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Account Details").setExact(true)).click();
	      page.getByLabel("First name *").click();
	      page.getByLabel("First name *").fill("reka");
	      page.getByLabel("Current Password (leave blank").click();
	      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
	      
	   // Stop tracing and export it into a zip archive.
	      context.tracing().stop(new Tracing.StopOptions()
	        .setPath(Paths.get("trace.zip")));
	      
	    }
	  }
}

// To open inspector and generate scripts 
//C:\Users\nreka\eclipse-workspace\Playwright-java>mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://practice.automationtesting.in/my-account/"
	
//to debug : run as -> run configuararion -> environment -> PWDEBUG=1 -> run
	
//got to -> https://trace.playwright.dev/  drag drop trace.zip 
//OR	
// mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"