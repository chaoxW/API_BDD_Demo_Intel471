package step.definitions;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;


public class DemoRestAPITest {

    private Scenario scenario;
    private Response response;
    private final String BASE_URL = "https://dummy.restapiexample.com/";

    private ArrayList<String> employee30 = new ArrayList<String>();

    @Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
    }

    @Given("Get Call to {string}")
    public void get_call_to_url(String url) throws Exception {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification req = RestAssured.given();
        response = req.when().get(new URI(url));
    }

    @Given("Delete Call to {string}")
    public void delete_call_to_url(String url) throws Exception {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification req = RestAssured.given();
        response = req.when().delete(new URI(url));
    }

    @Given("Post Call to {string} with payload new employee")
    public void post_call_to_url(String url) throws Exception {
        RestAssured.baseURI = BASE_URL;
        File jsonData = new File("src/test/resources/Payloads/NewEmployee.json");
        RequestSpecification req = RestAssured.given().body(jsonData).contentType(ContentType.JSON);
        response = req.when().post(new URI(url));
    }

    @Given("Update Call to {string} with payload employee updated")
    public void update_call_to_url(String url) throws Exception {
        RestAssured.baseURI = BASE_URL;
        File jsonData = new File("src/test/resources/Payloads/UpdateEmployee.json");
        RequestSpecification req = RestAssured.given().body(jsonData).contentType(ContentType.JSON);
        response = req.when().put(new URI(url));
    }

    @Then("Response Code {string} is validated")
    public void response_is_validated(String responseMessage) {
        int responseCode = response.then().extract().statusCode();
        Assert.assertEquals(responseMessage, String.valueOf(responseCode));
    }

    @Then("There are {string} employees with age more than 30")
    public void calculateNumberOfEmployeeOverThirty(String num) {
        response.then().statusCode(200);
        response = response.then().extract().response();
        JsonPath j = new JsonPath(response.asString());
        int s = j.getInt("data.size()");
//        scenario.log(String.valueOf(s));
        for(int i = 0; i < s; i++) {
            String name = j.getString("data["+i+"].employee_name");
            String age = j.getString("data["+i+"].employee_age");
            String id = j.getString("data["+i+"].id");
//            System.out.println(name);
//            System.out.println(id);
//            System.out.println(age);
            if(Integer.valueOf(age)>30){
                employee30.add(id);
            }
        }
//        System.out.println(employee30.size());
        Assert.assertEquals(String.valueOf(employee30.size()),num);
    }

}

