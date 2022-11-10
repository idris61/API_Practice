package day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.GMIBankBaseURL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest07 extends GMIBankBaseURL {

    /*
    http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın
   “firstName”: “Melva”,
   “lastName”: “Bernhard”,
   “email”: “chas.kuhlman@yahoo.com”
   “zipCode”: “40207"
   “country” “name”: “San Jose”
   “login”: “delilah.metz”
     */

    @Test
    public void test07(){

        // 1- Set the Url
        spec01.pathParams("first","tp-customers","second",110472);

        // 2- Set the Expected Data

        // 3- Send the Request and Get the Response
        Response response = given().spec(spec01).headers("Authorization","Bearer " +generateToken()).when().get("/{first}/{second}");
        response.prettyPrint();

        //Response response = given().spec(spec).headers("Authorization","Bearer " + Authentication.generateToken()).when().get("/{first}/{second}");
        //extend etmeden su sekilde yazilabilir

        // 4- Do Authentications
        // Matcher ile doğrulama
        response.then().assertThat().body("firstName", equalTo("Melva"),"lastName", equalTo("Bernhard"),
                "email", equalTo("chas.kuhlman@yahoo.com"),"zipCode",equalTo("40207"),"country.name",equalTo("San Jose"),
                "user.login", equalTo("delilah.metz"));

        // Json Path ile doğrulama
        JsonPath json = response.jsonPath();
        Assert.assertEquals("Melva", json.getString("firstName"));
        Assert.assertEquals("Bernhard", json.getString("lastName"));
        Assert.assertEquals("chas.kuhlman@yahoo.com", json.getString("email"));
        Assert.assertEquals("40207", json.getString("zipCode"));
        Assert.assertEquals("San Jose", json.getString("country.name"));
        Assert.assertEquals("delilah.metz", json.getString("user.login"));
    }
}
