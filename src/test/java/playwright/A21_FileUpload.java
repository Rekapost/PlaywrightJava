package playwright;
import java.nio.charset.StandardCharsets;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class A21_FileUpload {
public static void main(String[] args) {
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
	Page page = browser.newPage();
	page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
	
	//input type = file  -> Mandatory
/*	
	// Single file 
	page.setInputFiles("input#filesToUpload", Paths.get("appLogin.json"));	
	//deselect file / remove the file
	page.setInputFiles("input#filesToUpload", new Path[0]);
*/
	
	// Multiple file 
/*	page.setInputFiles("input#filesToUpload",new Path[]{Paths.get("appLogin.json"), Paths.get("src/test/resources/ds10.png")});	
	//deselect file / remove the file
	page.setInputFiles("input#filesToUpload", new Path[0]);
	
*/
	//File-Upload  ->create file at run time , text and plain type , with content;
	//page.setInputFiles("input#filesToUpload", new FilePayload("Reka.text", "text/plain", "this is Reka QA Automation tester".getBytes(StandardCharsets.UTF_8)));
	
	//file upload and once uploded , content gets displayed
	//file type : mime
	//https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
	page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
	page.setInputFiles("input[name='upfile']", new FilePayload("Reka.text", "text/plain", "this is Reka QA Automation tester".getBytes(StandardCharsets.UTF_8)));
	page.click("input[value='Press']");

}
}
