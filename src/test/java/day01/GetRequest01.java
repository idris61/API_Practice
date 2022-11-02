package day01;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    @Test
    public void test01(){

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response = given().when().get(url);

        // given().when().get(url); ==> end point'e göndermek için request oluşturmuş olduk.
        // Response response ==> api tarafından bize dönen response

        // Response response = given().auth().basic("username", "password").when().get(url);
        // basic auth ile request göndermek için

        // response.prettyPrint(); ==>

        // response.prettyPeeks(); ==>

        // response.peek(); ==> tüm veriyi string olarak verir.

        // response.print(); ==> sadce bodyi string olarak yazdırır

    }
}
