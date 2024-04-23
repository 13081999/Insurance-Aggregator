package ui;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import InsurancePages.ViewAndEditProfile;
import base.BaseTest;

public class ViewAndEditProfilePom extends BaseTest {
	
	@Test(priority = 1)
    public void NavigateToHomePage() throws InterruptedException {
        webDriver.get(properties.getProperty("testUrl"));
        ViewAndEditProfile viewAndEditProfile=new ViewAndEditProfile(webDriver);
        viewAndEditProfile.setEmail("nexa@gmail.com");
        viewAndEditProfile.setPassword("Maragatham@1314");
		Thread.sleep(1000);
		viewAndEditProfile.clickOnLoginButton();
		Thread.sleep(1000);
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
	/*@Test(priority = 2)
    public void testInValidDataEditProfileTab() throws InterruptedException {
		ViewAndEditProfile viewAndEditProfile=new ViewAndEditProfile(webDriver);
		viewAndEditProfile.clickOnProfileTab();
		Thread.sleep(1000);
		viewAndEditProfile.clickOnViewAndEditProfileTab();
		
		WebElement ExpectedTitle = webDriver.findElement(By.xpath("/html/body/app-root/app-profile-edit/div/div[2]/h1")); //for "View and Edit Profile" header
        Assert.assertTrue(ExpectedTitle.isDisplayed());
        viewAndEditProfile.setUserName("");
        Thread.sleep(1000);
        viewAndEditProfile.setaddress("");
        Thread.sleep(1000);
        viewAndEditProfile.setDecription("");
        Thread.sleep(1000); 
        
        WebElement element=webDriver.findElement(By.xpath("/html/body/app-root/app-profile-edit/div/div[2]/form/button"));
	    JavascriptExecutor js=(JavascriptExecutor)webDriver;
	    js.executeScript("arguments[0].scrollIntoView()",element);
		 
	    Thread.sleep(1000);
        
        viewAndEditProfile.clickOnSaveChangesButton();
        Thread.sleep(1000);
        WebElement errorMessageUserName= webDriver.findElement(By.xpath("/html/body/app-root/app-profile-edit/div/div[2]/form/div[1]/div/div"));
        Assert.assertTrue(errorMessageUserName.isDisplayed(),"Username is required.");
        WebElement errorMessageAddress= webDriver.findElement(By.xpath("/html/body/app-root/app-profile-edit/div/div[2]/form/div[4]/div/div"));
        Assert.assertTrue(errorMessageAddress.isDisplayed(),"Address is required.");
        WebElement errorMessageDescription= webDriver.findElement(By.xpath("/html/body/app-root/app-profile-edit/div/div[2]/form/div[5]/div/div"));
        Assert.assertTrue(errorMessageDescription.isDisplayed(),"Description is required.");
        
        Thread.sleep(2000); 
        /*viewAndEditProfile.setDecription("Test");
        Thread.sleep(1000); 
        WebElement element1=webDriver.findElement(By.xpath("/html/body/app-root/app-profile-edit/div/div[2]/form/button"));
	    JavascriptExecutor js1=(JavascriptExecutor)webDriver;
	    js1.executeScript("arguments[0].scrollIntoView()",element1);
	    
        viewAndEditProfile.clickOnSaveChangesButton();
        Thread.sleep(1000); 
        WebElement errorMessageDescription1= webDriver.findElement(By.xpath("/html/body/app-root/app-profile-edit/div/div[2]/form/div[5]/div/div"));
        Assert.assertTrue(errorMessageDescription1.isDisplayed(),"Description must be at least 100 characters long.");
        viewAndEditProfile.clickOnLogo();
        Thread.sleep(2000); 
        
	} */
	@Test(priority = 3)
    public void testEditProfileTab() throws InterruptedException {
		
		ViewAndEditProfile viewAndEditProfile=new ViewAndEditProfile(webDriver);
		viewAndEditProfile.clickOnProfileTab();
		Thread.sleep(1000);
		viewAndEditProfile.clickOnViewAndEditProfileTab();
		
        viewAndEditProfile.setUserName("Mounika");
        Thread.sleep(1000);
        viewAndEditProfile.setaddress("Coimbatore");
        Thread.sleep(1000);
        viewAndEditProfile.setDecription("Test Edit profile");

        WebElement element=webDriver.findElement(By.xpath("/html/body/app-root/app-profile-edit/div/div[2]/form/button"));
	    JavascriptExecutor js=(JavascriptExecutor)webDriver;
	    js.executeScript("arguments[0].scrollIntoView()",element);
        
        viewAndEditProfile.clickOnSaveChangesButton();
        Thread.sleep(1000);
        String alertMessage1 = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage1);
        webDriver.switchTo().alert().accept();
        viewAndEditProfile.clickOnLogo();
        Thread.sleep(1000);
	}   
	@Test(priority = 4)
    public void testEditProfileTabUpdated() throws InterruptedException {
		webDriver.get(properties.getProperty("testUrl"));
		ViewAndEditProfile viewAndEditProfile=new ViewAndEditProfile(webDriver);
		viewAndEditProfile.setEmail("rizwan@gmail.com");
		viewAndEditProfile.setPassword("Rizwan@23");
		Thread.sleep(1000);
		viewAndEditProfile.clickOnLoginButton();
		Thread.sleep(1000);
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
		viewAndEditProfile.clickOnProfileTab();
		Thread.sleep(1000);
		viewAndEditProfile.clickOnViewAndEditProfileTab();
		Thread.sleep(1000);
		viewAndEditProfile.clickOnLogo(); 
	}
		
		
        
        
		
        
        
		
		
	
}
