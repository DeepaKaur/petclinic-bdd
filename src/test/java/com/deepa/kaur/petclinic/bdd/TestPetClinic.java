package com.deepa.kaur.petclinic.bdd;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

 @RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@Ad",
		monochrome = true, 
		features = "classpath:com/deepa/kaur/petclinic/bdd/",
		glue = {"com.deepa.kaur.petclinic.bdd.steps"},
		publish = false)
public class TestPetClinic {
}
