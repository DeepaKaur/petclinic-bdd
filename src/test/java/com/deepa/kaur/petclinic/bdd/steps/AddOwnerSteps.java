package com.deepa.kaur.petclinic.bdd.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.cucumber.datatable.DataTable;
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

public class AddOwnerSteps {
	private WebDriver driver;
	
	public AddOwnerSteps(){
		System.setProperty("webdriver.chrome.driver", "C:\\Workspace\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Given("New owner details")
	public void givenAddDetails() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Given add details");
		driver.get("http://localhost:8080/");
		driver.findElement(By.xpath("//span[contains(text(),'Find owners')]")).click();
		driver.findElement(By.linkText("Add Owner")).click();
	}

	@When("I add the details and submit")
	public void AddNewOwner(DataTable datatable)  {
		String fName = datatable.cell(1,0);
		System.out.println("Inside addnewowner");
		driver.findElement(By.id("firstName")).sendKeys(datatable.cell(1,0));
		driver.findElement(By.id("lastName")).sendKeys(datatable.cell(1,1));
		driver.findElement(By.id("address")).sendKeys(datatable.cell(1,2));
		driver.findElement(By.id("city")).sendKeys(datatable.cell(1,3));
		driver.findElement(By.id("telephone")).sendKeys(datatable.cell(1,4));
		driver.findElement(By.xpath("//button[contains(text(),\"Add Owner\")]")).click();
	}
	
	@Then("I can verify the owner {string} is present")
	public void verifyNewOwner(String name)  {
		String tableName = "Owner Information";
		String actualTable = driver.findElement(By.id("ownerInformation")).getText();
		Assert.assertEquals(tableName,actualTable);
		List <WebElement> ownerdetails = driver.findElements(By.xpath("//table[@aria-describedby='ownerInformation']/descendant::tr"));
		String labelName = ownerdetails.get(0).findElement(By.xpath("//td[@headers=\"name\"]")).getText();
		System.out.println(labelName);
		Assert.assertEquals(name,labelName);
		driver.close();
	}
}
	
	