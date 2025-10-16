package projectActivity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestassuredProjectActivity {
	RequestSpecification reqSpec;
	ResponseSpecification responseSpec;
	String sshkey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIESmk7I8iCDE8e6enYAGOEtbAOfVNQj+tNUMr9B59woT";
	int keyId;

	@BeforeClass
	public void setUp() {
		reqSpec = new RequestSpecBuilder().
				setBaseUri("https://api.github.com/user/keys")
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "token <github token>")
				.addHeader("X-GitHub-Api-Version", "2022-11-28")
				.build();

		responseSpec = new ResponseSpecBuilder().expectBody("title", equalTo("TestKey"))
				.expectBody("key", equalTo(sshkey)).build();
	}

	@Test(priority = 1)
	public void postRequestTest() {
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("title", "TestKey");
		reqBody.put("key", sshkey);

		Response response = given().spec(reqSpec).body(reqBody).when().post();

		// this.keyId = responseSpec.then().extract().path("id");
		this.keyId = response.then().extract().path("id");

		// Assertion
		responseSpec.then().spec(responseSpec);
	}

	@Test(priority = 2)
	public void getRequestTest() {
		Response response = given().spec(reqSpec).pathParam("keyId", this.keyId).when().get("/{keyId}");

		response.then().spec(responseSpec).statusCode(200);

		Reporter.log("GET Response Body: " + response.getBody().asString());

		System.out.println("GET Response Body: " + response.getBody().asPrettyString());
	}

	@Test(priority = 3)
	public void deleteRequestTest() {
		Response response = given().spec(reqSpec).pathParam("keyId", this.keyId).when().delete("/{keyId}");

		// Validate status code
		response.then().statusCode(204);

		// Log response to TestNG report
		Reporter.log("DELETE Response Body: " + response.getBody().asString());
	}

}
