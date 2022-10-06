package pintutest;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.minidev.json.JSONArray;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.equalTo;

public class StepDefinitions {
    Response response;
    JsonPath jsonResponse;
    ValidatableResponse json;
    public HashMap<Object,Object> map=new HashMap<Object,Object>();

    @Given("client set host")
    public void clientSetHost() {
        RestAssured.baseURI= "https://jsonplaceholder.typicode.com";
    }

    @When("client send a GET endpoint {string}")
    public void clientSendAGETEndpoint(String endpoint) {
        jsonResponse = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(endpoint)
                    .then()
                    .statusCode(200)
                    .extract().jsonPath();
    }

    @Then("response {string} should be {string}")
    public void responseShouldBe(String data, String type) {
        if(type == "integer") {
            assertThat(jsonResponse.get(data) instanceof Integer).isTrue();
        } else if (type == "string") {
            assertThat(jsonResponse.get(data) instanceof String).isTrue();
        }
    }

    @And("client set body {string} with {string} as {string}")
    public void clientSetBodyWithAs(String data, String value, String type) {
        if(type == "integer") {
            map.put(data,Integer.valueOf(value));
        } else {
            map.put(data,value);
        }
    }

    @When("client send a POST endpoint {string}")
    public void clientSendAPOSTEndpointWithBody(String endpoint) {
        jsonResponse = given()
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint)
                .then()
                .statusCode(201)
                .extract().jsonPath();
    }

    @Then("response {string} should matching {string}")
    public void responseShouldMatching(String data, String value) {
//        System.out.println(response.jsonPath().get("id"));
        Integer id = jsonResponse.get("id");
//        System.out.println(id);
//        String datas = data + "[-1]";
        response = given().contentType(ContentType.JSON)
                .when().get("/posts");
        System.out.println(response.prettyPrint());
//        json = response.then().statusCode(200);
//        .then()
//        .assertThat().body(data, equalTo(value));
//                .extract().response();
//        System.out.println(response.asString());
//        assertEquals(jsonResponse.get(data), value);
//        JSONArray JSONResponseBody = new JSONArray(response.body().asString());
//        assertEquals(JSONResponseBody.getJsonObject(0).getString("fieldName"), "TextName");
//        assertEquals(jsonResponse.get(data).toString(), value);
    }

}
