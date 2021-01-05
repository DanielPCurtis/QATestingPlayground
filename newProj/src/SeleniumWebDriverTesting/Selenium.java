package SeleniumWebDriverTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import org.openqa.selenium.By;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class Selenium {
	 
	//public WebDriver driver;
	
    public static void main(String[] args) {
    	
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver","C://Users/dcurt/downloads/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","C://Users/dcurt/downloads/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.facebook.com";
		  

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);
    	titleTest(driver);
        locatorTests(driver);
        findElementsTests(driver);
       
        //close Fire fox
        driver.close();
    }
    /**
     * 
     * 
     * @param wd (Chrome Driver)
     */
    private static void titleTest(WebDriver wd)	{
    	String expectedTitle = "Facebook - Log In or Sign Up";
        // get the actual value of the title
        String title = wd.getTitle();
        //System.out.println(title);
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (title.contentEquals(expectedTitle)){
            System.out.println("Title Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
    }

	private static void locatorTests(WebDriver wd) {
		//Different locators:
		//className, cssSelector, id, linkText, name, partialLinkText, tagName, xpath
		//className Example
		WebElement cn = wd.findElement(By.className("_6ltg"));
		String tagName = cn.getTagName();
		if(tagName.contentEquals("div")) {
			System.out.println("className locator test Passed");
		}
		else	{
            System.out.println("Test Failed");
        }
		//cssSelector Example
		//Something interesting I learned was:
		//when entering text you cannot use the getText()
		//to read the text...
		//you need to use getAttribute("value")
		String em = "example@gmail.com";
		WebElement cs = wd.findElement(By.cssSelector("input#email"));
		String select = cs.getAttribute("value");
		if(select.contentEquals(""))	{
			System.out.println("empty...so far so good");
		}
		else	{
			System.out.println(" uh oh something is wrong");
		}
		cs.sendKeys(em);
		select = cs.getAttribute("value");
		//System.out.println(select);
		if(select.contentEquals(em))	{
			System.out.println("Enter email Text Test Passed");
		}
		else	{
			System.out.println(" uh oh something is wrong");
		}
		//id Example
		//The method of testing I prefer
		//is to verify the element is empty
		//then enter text
		//then verify the text has been entered
		String pw = "password";
		WebElement id = wd.findElement(By.id("pass"));
		String passwordAnswer = id.getAttribute("value");
		if( passwordAnswer.contentEquals( "" )) {
			System.out.println("empty...so far so good");
		}
		else	{
			System.out.println(" uh oh something is wrong");
		}
		id.sendKeys(pw);
		passwordAnswer = id.getAttribute("value");
		if( passwordAnswer.contentEquals( pw )) {
			System.out.println("Enter Password Text Test Passed");
		}
		else	{
			System.out.println(" uh oh something is wrong");
		}
		//linkText Example
		//find element by innerText of Create New Button
		//Test: verify the element found is the Create New Account Anchor Tag I wanted
		String cre = "Create New Account";
		WebElement create = wd.findElement( By.linkText( cre ));
		String createAnswer = "a";
		//System.out.println(create.getTagName());
		if( create.getTagName().contentEquals( createAnswer ) ) {
			System.out.println("Create New Account anchor tag Test Passed");
		}
		else	{
			System.out.println(" uh oh something is wrong");
		}
		//name Example
		//Will duplicate test above because it contains name attribute and im lazy
		String ema = "email";
		WebElement e = wd.findElement(By.name(ema));
		String emAnswer = e.getAttribute("value");
		//System.out.println(select);
		if(emAnswer.contentEquals(em))	{
			System.out.println("Enter email Text Test -Name Edition- Passed");
		}
		else	{
			System.out.println(" uh oh something is wrong");
		}
		//xpath Example
		//
		WebElement x = wd.findElement(By.xpath("//*[@id=\"pageFooterChildren\"]/ul/li[1]/a"));
		String xA = x.getText();
		System.out.println(xA);
		if(xA.contentEquals("Sign Up"))	{
			System.out.println("Sign Up Link in the bottom grid Test Passed");
		}
		else	{
			System.out.println(" uh oh something is wrong");
		}
	}
	
	private static void findElementsTests( WebDriver wd )	{
		//Example of getting list of elements
		//findElements will return an empty list if nothing is found
		//will return a list of WebElements that match the Locator
		List<WebElement> listOfElements = wd.findElements(By.xpath("//*[@id=\"pageFooterChildren\"]/ul/li"));
		for(int i=0; i < listOfElements.size(); i++) {
		    System.out.println(listOfElements.get(i).getText());
		}
	}
		
}