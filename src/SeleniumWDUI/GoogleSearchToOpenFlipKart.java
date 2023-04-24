package SeleniumWDUI;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearchToOpenFlipKart {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, WebDriverException {

		WebDriver driver = new ChromeDriver();
		ChromeOptions option = new ChromeOptions();
		option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get("https://www.google.com/"); // .get() -> return void
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(4000);

		driver.navigate().refresh();
		Thread.sleep(4000);
		
		boolean flag1 = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
		System.out.println("Present Mail :: " + flag1);

		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Flipkart");

		try {
		
		List<WebElement> listIs = driver.findElements(By.xpath(
				"//div[@role='presentation' and @class='mkHrUc']//ul[@role='listbox']//li//div[@class='wM6W7d' and @role='presentation']//span"));
		
		System.out.println(listIs.size());
		Thread.sleep(9000);

		for (int i = 0; i < listIs.size(); i++) {

			if (listIs.get(i).getText().equals("flipkart")) {
				
				//Actions a = new Actions(driver);
				//a.moveToElement(listIs.get(i)).build().perform();
				listIs.get(i).click();
				System.out.println("Element Clicked Sucessfully");
				break;

			}
		}
		 }
		
		catch (StaleElementReferenceException e) {

		   System.out.println("Execute Remaining Block");
		   List<WebElement> listIs = driver.findElements(By.xpath(
					"//div[@role='presentation' and @class='mkHrUc']//ul[@role='listbox']//li//div[@class='wM6W7d' and @role='presentation']//span"));
			
			System.out.println(listIs.size());
			Thread.sleep(9000);

			for (int i = 0; i < listIs.size(); i++) {

				if (listIs.get(i).getText().equals("flipkart")) {
					
					//Actions a = new Actions(driver);
					//a.moveToElement(listIs.get(i)).build().perform();
					listIs.get(i).click();
					System.out.println("Element Clicked Sucessfully");
					break;

				}
			}
		}

		
		System.out.println("Executing");
		Thread.sleep(4000);
	    driver.findElement(By.xpath("(//a[@href='https://www.flipkart.com/'])[1]")).click();
	    
		Thread.sleep(8000);
	    Actions action = new Actions(driver);
	    action.sendKeys(Keys.ESCAPE).build().perform();
	    
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("Iphone 13");
				
		// Open I-phone 13 Catalogue 

		try {
		
		List<WebElement> ul = driver.findElements(By.xpath("//button[@class='L0Z3Pu']//following::ul//following-sibling::li//div[@class='lrtEPN _17d0yO']"));
				
		for(int i=0; i<ul.size(); i++) {
			
			if(ul.get(i).getText().equalsIgnoreCase("iphone 13")) {
				ul.get(i).click();
			}			
		}
		
		 }
		
		catch (StaleElementReferenceException e) {
			System.out.println("Executing block if Fail");

			List<WebElement> ul = driver.findElements(By.xpath("//button[@class='L0Z3Pu']//following::ul//following-sibling::li//div[@class='lrtEPN _17d0yO']"));
			
			for(int i=0; i<ul.size(); i++) {
				
				if(ul.get(i).getText().equalsIgnoreCase("iphone 13")) {
					ul.get(i).click();
				}			
			}
		}
		
		Thread.sleep(8000);
		
		System.out.println("Checking ");
		String str = "APPLE iPhone 13 (Midnight, 128 GB)";
		boolean d = driver.findElement(By.xpath("//div[text()= '" + str + "']")).isDisplayed();
		System.out.println("Present IPhone :: "+d);
		
		WebElement ele = driver.findElement(By.xpath("//div[text()= '" + str + "']"));
		
		ele.click();
		System.out.println("Clicked Element is  :: "+ele.getText());
		
		
		// Window 
		Thread.sleep(8000);
		
		Set<String> st = driver.getWindowHandles();
		
		Iterator<String> itr = st.iterator();

		/* Iterator >> iterating way 
		 * while(itr.hasNext()) {
		 * 
		 * String value = itr.next(); System.out.println(" Parent "+windowValue);
		 * 
		 * }
		 */	 
		
		 String parent = itr.next();
		 System.out.println("Parent window "+parent);
		 String child =itr.next();
		 System.out.println("ChildWindow "+child);
		 
		 driver.switchTo().window(child);
		 System.out.println("Window Switched Successfully");
		
		Thread.sleep(8000);
		
		try {
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		System.out.println("Added to Cart" +ele.getText());
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")).click();
		
		
		}
		catch (WebDriverException e) {
			
           System.out.println("Added to Checkout Stale Ele");
           driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
   		   System.out.println("Added to Cart" +ele.getText());
   		   Thread.sleep(6000);
		   driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")).click();
		
		}
		
		
		finally {
			
			System.out.println("Ignore Exception");
		}
		
		
	}

}
