package com.deepa.kaur.petclinic.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.internal.misc.FileSystemOption;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class PetApisTest {
    @Test
    public void testCreatePetType() {
        String pettype = "reptile";
        baseURI = "http://localhost:9966";
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"name\": \"" + pettype + "\"\n" +
                        "}")
                .when()
                .post("petclinic/api/pettypes")
                .then()
                .assertThat().statusCode(201).extract().response();

        System.out.println("Response is : " + response.asString());
        JsonPath js = new JsonPath(response.asString());//for parsing json
        Assert.assertEquals(js.getString("name"), pettype);
        String name = js.getString("name");
        System.out.println("Name is " + name);
    }

    @Test
    public void testGetPetType() {
        baseURI = "http://localhost:9966";
        Response response = given()
                .when()
                .get("petclinic/api/pets/pettypes")
                .then()
                .assertThat().statusCode(200).extract().response();
        System.out.println("Response is" + response.asString());
        JsonPath js1 = new JsonPath(response.asString());//for parsing json
        // JsonPath js1 = new JsonPath(Payload.PetTypes());
        int ids = js1.getInt("id.size()");
        System.out.println("number of ids = " + ids);
        String petType1 = js1.get("[0].name");
        System.out.println(petType1);

    }

    //@Test
    public void testDeletePetType() {
        baseURI = "http://localhost:9966";
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete("petclinic/api/pettypes/8")
                .then()
                .assertThat().statusCode(204).extract().response();

    }
}
