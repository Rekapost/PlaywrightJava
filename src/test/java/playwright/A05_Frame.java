package playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class A05_Frame {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();

/*		//Single Frame 
		page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
		//Type 1
		String header=page.frameLocator("frame[name='void2_3']").locator("title").textContent();  // xpath = //frame[@name='void2_3']
		System.out.println(header);	
		//Type 2
		String title=page.frame("void2_3").locator("title").textContent();
		System.out.println(title);
*/
		// Iframe
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();
		page.frameLocator("//iframe[contains(@id,'frame-one')]")
		.locator("#RESULT_TextField-8").fill("Reka");	
		
/*      //Multiple frame // nested frame not working
		page.navigate("https://demo.automationtesting.in/Frames.html");
		page.frameLocator("//iframe[contains(@id,'singleframe')]").locator("input").fill("Reka");

		page.navigate("https://demo.automationtesting.in/Frames.html");
		page.locator("//a[@href='#Multiple']").click();
//      This element is inside 2 nested frames.
//		XPath for frame1 = //iframe[@src='MultipleFrames.html'];
//		XPath for frame2 = //iframe[normalize-space()='<p>Your browser does not support iframes.</p>'];
//		XPath for inspectedElement = //input[@type='text'];
		
		// Switch to the first iframe
        Frame frame1 = page.frameByUrl("MultipleFrames.html");
        // Switch to the second iframe within the first iframe
        Frame frame2 = frame1.childFrames().get(0); // Assuming it's the first child frame
        //String bodyText = frame2.evaluate("() => document.body.innerText");
        //Frame frame2 = frame1.frame(frame ->frame.evaluate("document.body.innerText").contains("Your browser does not support iframes."));   
        // Interact with the target element inside the nested iframe
        Locator inputElement = frame2.locator("//input[@type='text']").last();
        inputElement.fill("Reka");  // Replace with the text you want to enter
        System.out.println("Interacted with the target element");
*/
	}
}
