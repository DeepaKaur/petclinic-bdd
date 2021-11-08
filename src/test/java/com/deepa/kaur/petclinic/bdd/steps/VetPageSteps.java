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

public class VetPageSteps {
	private WebDriver driver;

	public VetPageSteps(){
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Given("Veterinarians page")
	public void givenVetPageclicked() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Given vet page clicked");
		driver.get("http://localhost:8080/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='veterinarians']")).click();
	}
	
	@When("I go to Veterinarians page")
	public void DisplayVets()  {
		System.out.println("Inside Display vets");
	}
	
	@Then("Veterinarians page is shown with name and specialies table")
	public void VerifyVets()  {
		System.out.println("Inside verify vets");
		String tableName = "Veterinarians";
		String actualTable = driver.findElement(By.cssSelector("h2#veterinarians")).getText();
		Assert.assertEquals(tableName,actualTable);
		List <WebElement> vetDetails = driver.findElements(By.cssSelector("table#vetsTable tr"));
		String actualName = "Helen Leary";
		List<String> vetNames = new ArrayList<>();
		for(WebElement w : vetDetails) {
			List<WebElement> details = w.findElements(By.xpath("./child::*"));
			WebElement vets = details.get(0);
			System.out.println(vets.getText());
			vetNames.add(vets.getText());
		}
		Assert.assertTrue(vetNames.contains(actualName));
		driver.close();
	}
}
	
	