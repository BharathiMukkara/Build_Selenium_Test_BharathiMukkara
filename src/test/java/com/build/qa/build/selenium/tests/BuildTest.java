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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.BathRoomFaucets;
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
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/nav/div/ul/li[2]/a")));
		boolean status=element.isDisplayed();
		if(status)
		{
			System.out.println("Page is loaded");
		}
		else
		{
			System.out.println("Page is not loaded");
		}
		//Verify if the page is loaded with Assert  Statement  
		Assert.assertEquals(status, true);
		System.out.println("The Website is loaded with the Build.com desktop theme");
		LOG.info("The Website is loaded with the Build.com desktop theme");
	    String title=driver.getTitle();
	    System.out.println("Page title is: "+title);
    
	}
	
	/** 
	 * Search for the Quoizel MY1613 from the search bar
	 * @assert: That the product page we land on is what is expected by checking the product title
	 * @difficulty Easy
	 */
 @Test
	public void searchForProductLandsOnCorrectProduct() { 
		// TODO: Implement this test
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div/div[1]/button")));
		boolean status=element.isDisplayed();
		System.out.println("The Website is loaded with the Build.com desktop theme");
		boolean status1=element.isDisplayed();
		if(status1)
		{
			System.out.println("Page is loaded");
		}
		else
		{
			System.out.println("Page is not loaded");
		}
		//Verify if the page is loaded with Assert  Statement  
		Assert.assertEquals(status1, true);
		System.out.println("The Website is loaded with the Build.com desktop theme");
		LOG.info("The Website is loaded with the Build.com desktop theme");
	    String title=driver.getTitle();
	    System.out.println("Page title is: "+title);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div[1]/button")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"search_txt\"]")).sendKeys("Quoizel MY1613");
		driver.findElement(By.xpath("/html/body/div[2]/header/section[2]/div/div/div/div[2]/div/form/div/button")).click();
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
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	@Test
	public void addProductToCartFromCategoryDrop() { 
		driver.get(getConfiguration("BathRoomSinks"));
		BathRoomSinksPage BathroomsinksPage = new BathRoomSinksPage(driver, wait);
	
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/div[1]/button")));
		boolean status=element.isDisplayed();
		boolean status1=element.isDisplayed();
		if(status1)
		{
			System.out.println("Page is loaded");
		}
		else
		{
			System.out.println("Page is not loaded");
		}
		//Verify if the page is loaded with Assert  Statement  
		Assert.assertEquals(status1, true);
		System.out.println("The Website is loaded with the Bath Room Sinks page theme");
		LOG.info("The Website is loaded with the Bath Room Sinks theme");
	    String title=driver.getTitle();
	    System.out.println("Page title is: "+title);
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/button")).click();
		
		
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[5]/div[2]/div[2]/div/ul/li[1]/a/span")).click();
		//driver.findElement(By.linkText("Shop By Installation Type")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[5]/div[2]/div[2]/div/ul/li[1]/a/span")).click();
		System.out.println("cotrol is here");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[5]/div[2]/div[4]/ul/li[2]/div[2]/a/div[2]")).click();
		
		//click on Add to Cart
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[3]/div[1]/div[2]/div[7]/div/div[2]/button")).click();
				
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/div[2]/header/section[2]/div/div/div/a[2]/button")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement Text1=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/section[2]/div/div[1]/table/tbody/tr[1]/td[2]/a/span"));
			
		String Expected=Text1.getText();
		System.out.println(Expected);
		String Actual="Archer 19-5/8\" Undermount Bathroom Sink with Overflow";
	
		Assert.assertEquals(Actual,Expected);
		
		// TODO: Implement this test
	}
	
	
	
	/** 
	 * Add a product to the cart and email the cart to yourself, also to my email address: jgilmore+SeleniumTest@build.com
	 * Include this message in the "message field" of the email form: "This is {yourName}, sending you a cart from my automation!"
	 * @assert that the "Cart Sent" success message is displayed after emailing the cart
	 * @difficulty Medium-Hard
	 */
/*@Test
	public void addProductToCartAndEmailIt() { 
		// TODO: Implement this test
		driver.get(getConfiguration("BathRoomSinks"));
		BathRoomSinksPage BathroomsinksPage = new BathRoomSinksPage(driver, wait);
		System.out.println("The Website is loaded with the Bath Room Sinks page theme");
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//closing the Alert
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/button")).click();
		//click on shop by installation type
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[5]/div[2]/div[2]/div/ul/li[1]/a/span")).click();
		//click on DropIn
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[5]/div[2]/div[2]/div/div/div[1]/div/div[1]/a/div[2]/h5")).click();
									 
		System.out.println("cotrol is here");
		//selecting the second item
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[5]/div[2]/div[4]/ul/li[2]/div[2]/a/div[2]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//click on Add to Cart							 
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div[2]/div[4]/div[2]/div[3]/div[1]/div[2]/div[7]/div/div[2]/button")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//click on Cart
		driver.findElement(By.xpath("/html/body/div[2]/header/section[2]/div/div/div/a[2]/button")).click();
		//Click on Email Cart
		if(driver.findElements(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/section[2]/div/div[1]/table/tbody/tr[2]/td/div[1]/div/button")).size()!=0)
				{
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/section[2]/div/div[1]/table/tbody/tr[2]/td/div[1]/div/button")).click();
			System.out.println(("Email Cart is clicked1"));
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/section[2]/div/div[1]/table/tbody/tr[2]/td/div[1]/div/div/button[1]")).click();
			System.out.println("Element is Present");
		}
		
				
		
		if(driver.findElements(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/section[2]/div/div[1]/table/tbody/tr[2]/td/button[1]")).size()!=0) {
			
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/section[2]/div/div[1]/table/tbody/tr[2]/td/button[1]")).click();
			System.out.println(("Email Cart is clicked"));
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"yourName\"]")).sendKeys("Bharathi");
	
	driver.findElement(By.xpath("//*[@id=\"yourEmail\"]")).sendKeys("Bharathi.mukkara@gmail.com");

	driver.findElement(By.xpath("//*[@id=\"recipientName\"]")).sendKeys("Selenium Test");
	
	driver.findElement(By.xpath("//*[@id=\"recipientEmail\"]")).sendKeys("jgilmore+SeleniumTest@build.com");
	driver.findElement(By.xpath("//*[@id=\"quoteMessage\"]")).sendKeys("This is bharathi Mukkara, sending you a cart from my automation");
	//click on Email Cart
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/div/div[2]/div[2]/form/div[4]/button")).click();
	
	}*/
	
	/** 
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Theme=Modern
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	/*@Test
	public void facetNarrowBysResultInCorrectProductCounts() { 
		// TODO: Implement this test
	    driver.get(getConfiguration("BathRoomFaucets"));
		 BathRoomFaucets Bathroomfaucet = new BathRoomFaucets(driver, wait);
		System.out.println("The Website is loaded with the Bath Room Sinks page theme");
	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//closing the Alert
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/button")).click();
		//driver.findElement(By.xpath("/html/body/div[2]/header/nav/div/ul/li[2]/a")).click();
		//click on Bathroom Faucets
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/div[1]/div/div/div[2]/a[3]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);						 
		System.out.println("cotrol is here");
		//Click on Shop By Finish
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[5]/div[1]/div[1]/div/ul[2]/li[2]/ul/li[2]/label")).click();
		boolean chrome= driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[5]/div[1]/div[1]/div/ul[2]/li[2]/ul/li[2]/label")).isSelected();
		if (chrome=true)
		{
			System.out.println("Chromes Tones is selected");
		}
		else
		{
			System.out.println("Chromes Tones is not selected");
		}
		//click on Theme Modern					 
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[5]/div[1]/div[1]/div/ul[2]/li[4]/ul/li[1]/label")).click();
		
		boolean x= driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[5]/div[1]/div[1]/div/ul[2]/li[4]/ul/li[1]/label")).isSelected();
		if (x=true)
		{
			System.out.println("Modern Theme is selected");
		}
		else
		{
			System.out.println("Modern Theme is not selected");
		}
		
		
		
	}*/
}
