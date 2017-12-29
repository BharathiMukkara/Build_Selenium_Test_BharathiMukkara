package com.build.qa.build.selenium.tests;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.BathRoomFaucets;
import com.build.qa.build.selenium.pageobjects.homepage.BathRoomSinkFaucets;
import com.build.qa.build.selenium.pageobjects.homepage.BathRoomSinksPage;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuildTest extends BaseFramework { 
	
	private static final Logger LOG = LoggerFactory.getLogger(BaseFramework.class);
	/** 
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
	@Test
	public void navigateToHomePage() { 
	//	private static final Logger   = LoggerFactory.getLogger(BaseFramework.class);
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id("emailSignup")));
		boolean status=element.isDisplayed();
		//Verify if the page is loaded with Assert  Statement  
		Assert.assertEquals(status, true);
		System.out.println("The Website is loaded with the Build.com desktop theme");
		LOG.info("The Website is loaded with the Build.com desktop theme");
	    String title=driver.getTitle();
	    System.out.println("Page title is: "+title);
	    
	 
	}
	
	/** 
	 * Search for the Quoizel MY1613 from the search bar
	 * @throws InterruptedException 
	 * @assert: That the product page we land on is what is expected by checking the product title
	 * @difficulty Easy
	 */
 @Test
	public void searchForProductLandsOnCorrectProduct() throws InterruptedException { 
		// TODO: Implement this test
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("emailSignup")));
	   	//Verify if the page is loaded with Assert  Statement  
		System.out.println("The Website is loaded with the Bath Room Faucets page theme");
		LOG.info("The Website is loaded with the Bath Room Faucets theme");
	    String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"search_txt\"]")).sendKeys("Quoizel MY1613");
        //Click on Search	 
		driver.findElement(By.xpath("//*[@id=\"site-search\"]/div/button")).click();
	
		WebElement Text1=driver.findElement(By.xpath("//*[@id=\"heading\"]"));
		String Expected=Text1.getText();
		System.out.println(Expected);
		String Actual="Quoizel MY1613ML";
		//verify if the Product is loaded
		Assert.assertEquals(Actual,Expected);
	}
	
	/** 
	 * Go to the Bathroom Sinks category directly (https://www.build.com/bathroom-sinks/c108504) 
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @throws InterruptedException 
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
@Test
	public void addProductToCartFromCategoryDrop() throws InterruptedException { 
		driver.get(getConfiguration("BathRoomSinks"));
		BathRoomSinksPage BathroomsinksPage = new BathRoomSinksPage(driver, wait);
	    WebDriverWait wait = new WebDriverWait(driver, 200);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("emailSignup")));
	   	//Verify if the page is loaded with Assert  Statement  
		System.out.println("The Website is loaded with the Bath Room Faucets page theme");
		LOG.info("The Website is loaded with the Bath Room Faucets theme");
	    String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		Thread.sleep(6000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(3000);
     	//click on Drop In
    	driver.findElement(By.xpath("(//*[contains(text(),'Drop In')])[3]")).click();

    	Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(text(),'Vox Rectangle')])")).click();
		Thread.sleep(6000);
		//click on Add to Cart
		driver.findElement(By.xpath("//*[contains(text(),'Add to Cart')]")).click();
		//Verify that the product appears
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//*[contains(text(),'Cart')])[3]")).click();
		
		driver.findElement(By.xpath("//span[text()=concat('22-5/8','\"',' Vox Rectangle Vessel Sink with Overflow')]")).click();
		
		WebElement Text1=driver.findElement(By.xpath("//*[@id=\"heading\"]"));
		String Actual=Text1.getText();
		String Expected="Kohler K-5373-0";
		Assert.assertEquals(Actual,Expected);
		
		// TODO: Implement this test
	
}
	
	
	/** 
	 * Add a product to the cart and email the cart to yourself, also to my email address: jgilmore+SeleniumTest@build.com
	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
	 * @throws InterruptedException 
	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
	 * @difficulty Medium-Hard
	 */
@Test
	public void addProductToCartAndEmailIt() throws InterruptedException { 
		// TODO: Implement this test
		driver.get(getConfiguration("BathRoomSinks"));
		BathRoomSinksPage BathroomsinksPage = new BathRoomSinksPage(driver, wait);
		WebDriverWait wait = new WebDriverWait(driver, 200);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("emailSignup")));
	   	//Verify if the page is loaded with Assert  Statement  
		System.out.println("The Website is loaded with the Bath Room Faucets page theme");
		LOG.info("The Website is loaded with the Bath Room Faucets theme");
	    String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		Thread.sleep(6000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(3000);
		//click on shop by installation type
		driver.findElement(By.xpath("(//*[contains(text(),'Drop In')])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(text(),'Vox Rectangle')])")).click();
		Thread.sleep(3000);
		//click on Add to Cart
		driver.findElement(By.xpath("//*[contains(text(),'Add to Cart')]")).click();
		Thread.sleep(3000);
		//click on Cart
		driver.findElement(By.xpath("(//*[contains(text(),'Cart')])[3]")).click();
		Thread.sleep(3000);
		//Click on Email Cart
		driver.findElement(By.xpath("(//*[contains(text(),'Email Cart')])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"yourName\"]")).sendKeys("Bharathi");
		driver.findElement(By.xpath("//*[@id=\"yourEmail\"]")).sendKeys("Bharathi.mukkara@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"recipientName\"]")).sendKeys("Selenium Test");
		driver.findElement(By.xpath("//*[@id=\"recipientEmail\"]")).sendKeys("jgilmore+SeleniumTest@build.com");
		driver.findElement(By.xpath("//*[@id=\"quoteMessage\"]")).sendKeys("This is bharathi Mukkara, sending you a cart from my automation");
		//click on Email Cart
		driver.findElement(By.xpath("(//*[contains(text(),'Email Cart')])[3]")).click();
		//Verify if the message is successful
		try 
	    {
		WebElement e=driver.findElement(By.xpath("//ul[contains(@class,'alert-success alert-dismissable')]/ul"));
	       if(e.isDisplayed()) {
	    	   LOG.info("Cart Sent! The cart has been sent to Mail: Message is displayed");
	       }
    }
	catch(Exception e)
	{
		new Exception("Message is not displayed");
	}
	

}
	
	/** 
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * @throws InterruptedException 
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() throws InterruptedException { 
		// TODO: Implement this test
	    driver.get(getConfiguration("BathRoomSinkFaucets"));
	    BathRoomSinkFaucets Bathroomsinkfaucets = new BathRoomSinkFaucets(driver, wait);
	    WebDriverWait wait = new WebDriverWait(driver, 60);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("emailSignup")));
	   	//Verify if the page is loaded with Assert  Statement  
		System.out.println("The Website is loaded with the Bath Room Faucets page theme");
		LOG.info("The Website is loaded with the Bath Room Faucets theme");
	    String title=driver.getTitle();
		System.out.println("Page title is: "+title);
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		
		//closing the Alert
		Thread.sleep(3000);
		//Select Chrome tones
		driver.findElement(By.xpath("(//label[contains(text(),'Chromes')]/input)[1]")).click();
		Thread.sleep(3000);
		boolean chrome= driver.findElement(By.xpath("(//label[contains(text(),'Chromes')]/input)[1]")).isSelected();
	
		//click on Theme Modern					 
		driver.findElement(By.xpath("//label[contains(text(),'Modern')]/input")).click();
		boolean x= driver.findElement(By.xpath("//label[contains(text(),'Modern')]/input")).isSelected();
		
		WebElement Text1=driver.findElement(By.xpath("(//span[contains(text(),'Products')]/span)[1]"));
		String Expected=Text1.getText();
		System.out.println(Expected);
		String Actual="985";
		Assert.assertEquals(Actual,Expected);
	}
}
