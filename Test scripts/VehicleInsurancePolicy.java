package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import InsurancePages.VehicleInsurance;
import base.BaseTest;

public class VehicleInsurancePolicy extends BaseTest{
	@Test(priority = 1)
    public void NavigateToHomePage() throws InterruptedException {
        webDriver.get(properties.getProperty("testUrl"));
        VehicleInsurance vehicleInsurance=new VehicleInsurance(webDriver);
        vehicleInsurance.setEmail("rizwan@gmail.com");
        vehicleInsurance.setPassword("Rizwan@23");
		Thread.sleep(1000);
		vehicleInsurance.clickOnLoginButton();
		Thread.sleep(1000);
        String alertMessage = webDriver.switchTo().alert().getText();
        System.out.println(alertMessage);
        webDriver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
	@Test(priority = 2)
    public void testVehicleInsurance() throws InterruptedException {
		VehicleInsurance vehicleInsurance=new VehicleInsurance(webDriver);
		vehicleInsurance.clickOnPoliciesTab();
		Thread.sleep(1000);
		vehicleInsurance.clickOnVehicleInsurance();
		Thread.sleep(1000);
		vehicleInsurance.clickOnMotorCycleShield();
		Thread.sleep(1000);
		WebElement CoverageDetails = webDriver.findElement(By.xpath("/html/body/app-root/app-vehicle-buy2-details/div/div[2]"));
		CoverageDetails.isDisplayed();
		WebElement element=webDriver.findElement(By.xpath("/html/body/app-root/app-vehicle-buy2-details/div/div[3]/button"));
	    JavascriptExecutor js=(JavascriptExecutor)webDriver;
	    js.executeScript("arguments[0].scrollIntoView()",element);
		Thread.sleep(1000);
		vehicleInsurance.clickOnAcceptandProceedButton();
		Thread.sleep(1000);
	}
	@Test(priority = 3)
    public void MotorCycleShield() throws InterruptedException {
		WebElement CoverageDetails = webDriver.findElement(By.xpath("/html/body/app-root/app-customer-details/div/div[2]"));
		CoverageDetails.isDisplayed();
		Thread.sleep(1000);
		VehicleInsurance vehicleInsurance=new VehicleInsurance(webDriver);
		vehicleInsurance.setNameInCustomerDetails("Nexa");
		vehicleInsurance.setEmailInCustomerDetails("nexa@gmail.com");
		vehicleInsurance.setMobileNoInCustomerDetails("9897765778");
		vehicleInsurance.setAgeInCustomerDetails("25"); //should be greater than 18
		
		 WebElement element=webDriver.findElement(By.xpath("/html/body/app-root/app-customer-details/div/div[2]/form/input"));
		 JavascriptExecutor js=(JavascriptExecutor)webDriver;
	     js.executeScript("arguments[0].scrollIntoView()",element);
         Thread.sleep(1000);
		    
		WebElement dropdown = webDriver.findElement(By.id("gender"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Female");
		Assert.assertTrue(select.getFirstSelectedOption().getText().equals("Female"));
		Thread.sleep(1000);
		
		WebElement dropdown1 = webDriver.findElement(By.id("policyType"));
		Select select1 = new Select(dropdown1);
		select1.selectByVisibleText("MotorcycleShield");
		Assert.assertTrue(select1.getFirstSelectedOption().getText().equals("MotorcycleShield"));
		Thread.sleep(2000);

		vehicleInsurance.setPremiumInCustomerDetails("1500");
		Thread.sleep(1000);
		vehicleInsurance.clickOnSubmitButton();
		Thread.sleep(2000);
	}
	@Test(priority = 4)
    public void VerificationPage() throws InterruptedException {
		String currUrl=webDriver.getCurrentUrl();
		String expectedUrl="http://localhost:4200/paymentGateway";
		Assert.assertEquals(currUrl, expectedUrl);
		VehicleInsurance vehicleInsurance=new VehicleInsurance(webDriver);
		vehicleInsurance.setPhoneNumberInVerifyPage("9897765778");
		Thread.sleep(1000);
		vehicleInsurance.clickOnPayButton();
		Thread.sleep(5000);
	     
	}
		
	
}
