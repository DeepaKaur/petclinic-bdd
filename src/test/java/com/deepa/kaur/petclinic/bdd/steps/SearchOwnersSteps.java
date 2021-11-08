package com.deepa.kaur.petclinic.bdd.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchOwnersSteps {
	private WebDriver driver;

	public SearchOwnersSteps(){
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("I am on Home and click Find Owners")
	public void givenALastName() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Given");
		driver.get("http://localhost:8080/");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Find owners')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Find owners')]")).click();
	}
	
	@When("I search for the owner named {string}")
	public void searchForTheOwners(String name) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.name("lastName")).sendKeys(name);
		driver.findElement(By.xpath("//button[contains(text(),'Find Owner')]")).click();
	}
	
	@Then("I can verify the owner with last name {string} exists")
	public void verifyThatUserExists(String lastname) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Inside Then");
		List<WebElement> owners = driver.findElements(By.xpath("//table[@id='ownersTable']/descendant::tr"));
		
		boolean foundOwner = false;
		for (WebElement owner : owners) {
			List<WebElement> details = owner.findElements(By.xpath("./child::*"));
			WebElement names = details.get(0);
			String name = names.getText();
			if(name.contains(lastname)){
				foundOwner = true;
				break;
			}

		}
		Assert.assertTrue(foundOwner);
		driver.close();
	}
	
	
	//Testing non existing owners
	
	@Given("A non existing owner with last name XYZ")
	public void givenNonExistingLastName() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Given non existing last name");
		driver.get("http://localhost:8080/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'Find owners')]")).click();

	}
	
	@When("I search for the non existing owners")
	public void searchForNonExistingOwners() {
		driver.findElement(By.name("lastName")).sendKeys("XYZ");
		driver.findElement(By.xpath("//button[contains(text(),'Find Owner')]")).click();
	}
	
	@Then("I can verify the owner with last name XYZ not present")
	public void verifyThatUserDoesNotExist() {
		System.out.println("Inside Then");
		String errMsg = driver.findElement(By.id("owner.errors")).getText();
		String expectedMsg = "has not been found";
		Assert.assertEquals(expectedMsg, errMsg);
		driver.close();
	}
		
  	
}
