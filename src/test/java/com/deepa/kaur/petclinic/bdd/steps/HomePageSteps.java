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

public class HomePageSteps  {
	private WebDriver driver;

	public HomePageSteps(){
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("URL for PetClinic Home page")
	public void givenALastName() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Given");
		driver.get("http://localhost:8080/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("I browse to the URL")
	public void browseToHomePage() throws InterruptedException {
		System.out.println("Inside When");
	}
	
	@Then("Home page is shown with Welcome message")
	public void verifyTheWelcomeMessage() {
		System.out.println("Inside Then");
		String expectedMsg = "Welcome";
		String actualMsg = driver.findElement(By.xpath("//h2[text()=\"Welcome\"]")).getText();
		Assert.assertEquals(expectedMsg,actualMsg);
		System.out.println(actualMsg);
		driver.close();
	}
		
  	
}
