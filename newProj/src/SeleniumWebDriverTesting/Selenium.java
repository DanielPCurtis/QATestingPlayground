package SeleniumWebDriverTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        System.out.println(title);
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
		System.out.println(create.getTagName());
		if( create.getTagName().contentEquals( createAnswer ) ) {
			System.out.println("Create New Account anchor tag Test Passed");
		}
		else	{
			System.out.println(" uh oh something is wrong");
		}
		//name Example
		//asdfasf
		
	}
		
}