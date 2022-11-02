package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;


public class GetRequest03 {

     /* Matchers ile dataları doğrulayınız
              "id": 5,
             "email": "charles.morris@reqres.in",
             "first_name": "Charles",
             "last_name": "Morris",
             "avatar": "https://reqres.in/img/faces/5-image.jpg"
      */

     @Test
     public void test01() {
         String url = "https://reqres.in/api/users";
         Response response = given().when().get(url);

         // HEADER TEST
            // 1) JUnit Assert
         assertEquals(200, response.getStatusCode());
         assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
         assertEquals("application/json; charset=utf-8", response.getContentType());

            // 2) assertthat ile
         response.then().assertThat().
                 statusCode(200).
                 statusLine("HTTP/1.1 200 OK").
                 contentType("application/json; charset=utf-8");

         //BODY TEST ICIN
            // 3) Matcher Class ile
         response.then().body("data[0].id",equalTo(1));
         response.then().body("data[0].email",equalTo("george.bluth@reqres.in"));
         response.then().body("data[0].first_name",equalTo("George"));
         response.then().body("data[0].last_name",equalTo("Bluth"));
         response.then().body("data[0].avatar",equalTo("https://reqres.in/img/faces/1-image.jpg"));
         response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
         response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

            // altnernative
         response.then().body("data[0].id",equalTo(1),
                 "data[0].email",equalTo("george.bluth@reqres.in"),
                 "data[0].first_name",equalTo("George"),
                 "data[0].last_name",equalTo("Bluth"),
                 "data[0].avatar",equalTo("https://reqres.in/img/faces/1-image.jpg"));
         response.then().body("support.url",equalTo("https://reqres.in/#support-heading"),
                 "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
     }

    @Test
    public void test02(){
        /*
          {
           "data": {
               "id": 2,
               "email": "janet.weaver@reqres.in",
               "first_name": "Janet",
               "last_name": "Weaver",
               "avatar": "https://reqres.in/img/faces/2-image.jpg"
           },
           "support": {
               "url": "https://reqres.in/#support-heading",
               "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
           }
            }
         */
        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        //HEADER TEST ICIN
        // 1) JUnit Assert
        assertEquals(200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertEquals("application/json; charset=utf-8", response.getContentType());

        // 2) assertThat ile
        response.then().assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType("application/json; charset=utf-8");


        //BODY TEST ICIN
        // 3) Matcher Class ile
        response.then().body("data[1].id",equalTo(2));
        response.then().body("data[1].email",equalTo("janet.weaver@reqres.in"));
        response.then().body("data[1].first_name",equalTo("Janet"));
        response.then().body("data[1].last_name",equalTo("Weaver"));
        response.then().body("data[1].avatar",equalTo("https://reqres.in/img/faces/2-image.jpg"));
        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        // altnernative
        response.then().body("data[1].id",equalTo(2),
                "data[1].email",equalTo("janet.weaver@reqres.in"),
                "data[1].first_name",equalTo("Janet"),
                "data[1].last_name",equalTo("Weaver"),
                "data[1].avatar",equalTo("https://reqres.in/img/faces/2-image.jpg"));
        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"),
                "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
    @Test
    public void test03(){
        /*
            {
        "data": {
            "id": 3,
            "email": "emma.wong@reqres.in",
            "first_name": "Emma",
            "last_name": "Wong",
            "avatar": "https://reqres.in/img/faces/3-image.jpg"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
            }
        }
         */
        String url = "https://reqres.in/api/users";
        Response response =given().when().get(url);

        //HEADER TEST ICIN
        // 1) JUnit Assert
        assertEquals(200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertEquals("application/json; charset=utf-8", response.contentType());

        // 2) assertThat ile
        response.then().assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType("application/json; charset=utf-8");

        //BODY TEST ICIN
        // 3) Matcher Class ile
        response.then().body("data[2].id",equalTo(3));
        response.then().body("data[2].email",equalTo("emma.wong@reqres.in"));
        response.then().body("data[2].first_name",equalTo("Emma"));
        response.then().body("data[2].last_name",equalTo("Wong"));
        response.then().body("data[2].avatar",equalTo("https://reqres.in/img/faces/3-image.jpg"));
        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        // altnernative
        response.then().body("data[2].id",equalTo(3),
                "data[2].email",equalTo("emma.wong@reqres.in"),
                "data[2].first_name",equalTo("Emma"),
                "data[2].last_name",equalTo("Wong"),
                "data[2].avatar",equalTo("https://reqres.in/img/faces/3-image.jpg"));
        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"),
                "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }

    @Test
    public void test04(){
        /*
        {
            "data": {
                "id": 4,
                "email": "eve.holt@reqres.in",
                "first_name": "Eve",
                "last_name": "Holt",
                "avatar": "https://reqres.in/img/faces/4-image.jpg"
            },
            "support": {
                "url": "https://reqres.in/#support-heading",
                "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
            }
        }
         */
        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        //HEADER TEST ICIN
        // 1) JUnit Assert
        assertEquals(200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertEquals("application/json; charset=utf-8", response.getContentType());

        // 2) assertThat ile
        response.then().assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType("application/json; charset=utf-8");

        // 3) Matcher Class ile
        response.then().body("data[3].id",equalTo(4));
        response.then().body("data[3].email",equalTo("eve.holt@reqres.in"));
        response.then().body("data[3].first_name",equalTo("Eve"));
        response.then().body("data[3].last_name",equalTo("Holt"));
        response.then().body("data[3].avatar",equalTo("https://reqres.in/img/faces/4-image.jpg"));
        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        // altnernative
        response.then().body("data[3].id",equalTo(4),
                "data[3].email",equalTo("eve.holt@reqres.in"),
                "data[3].first_name",equalTo("Eve"),
                "data[3].last_name",equalTo("Holt"),
                "data[3].avatar",equalTo("https://reqres.in/img/faces/4-image.jpg"));
        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"),
                "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }

    @Test
    public void test05(){

        /*
        {
            "data": {
                "id": 5,
                "email": "charles.morris@reqres.in",
                "first_name": "Charles",
                "last_name": "Morris",
                "avatar": "https://reqres.in/img/faces/5-image.jpg"
            },
            "support": {
                "url": "https://reqres.in/#support-heading",
                "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
            }
        }
         */
        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        //HEADER TEST ICIN

        // 1) JUnit Assert
        assertEquals(200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertEquals("application/json; charset=utf-8", response.getContentType());

        // 2) assertThat ile
        response.then().assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType("application/json; charset=utf-8");

        // BODY TEST ICIN

        // 3) Matcher Class ile

        response.then().body("data[4].id",equalTo(5));
        response.then().body("data[4].email",equalTo("charles.morris@reqres.in"));
        response.then().body("data[4].first_name",equalTo("Charles"));
        response.then().body("data[4].last_name",equalTo("Morris"));
        response.then().body("data[4].avatar",equalTo("https://reqres.in/img/faces/5-image.jpg"));

        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


        // altnernative
        response.then().body("data[4].id",equalTo(5),
                "data[4].email",equalTo("charles.morris@reqres.in"),
                "data[4].first_name",equalTo("Charles"),
                "data[4].last_name",equalTo("Morris"),
                "data[4].avatar",equalTo("https://reqres.in/img/faces/5-image.jpg"));

        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"),
                "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }


    @Test
    public void test06(){
        /*
        {
            "data": {
                "id": 6,
                "email": "tracey.ramos@reqres.in",
                "first_name": "Tracey",
                "last_name": "Ramos",
                "avatar": "https://reqres.in/img/faces/6-image.jpg"
            },
            "support": {
                "url": "https://reqres.in/#support-heading",
                "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
            }
        }
         */
        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        // HEADER TEST ICIN

        // 1) JUnit Assert ile
        assertEquals(200, response.getStatusCode());
        assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
        assertEquals("application/json; charset=utf-8", response.getContentType());

        // 2) assertThat ile
        response.then().assertThat().
                statusCode(200).
                statusLine("HTTP/1.1 200 OK").
                contentType("application/json; charset=utf-8");


        // BODY TEST ICIN

        // 3) Matcher Class ile

        response.then().body("data[5].id",equalTo(6));
        response.then().body("data[5].email",equalTo("tracey.ramos@reqres.in"));
        response.then().body("data[5].first_name",equalTo("Tracey"));
        response.then().body("data[5].last_name",equalTo("Ramos"));
        response.then().body("data[5].avatar",equalTo("https://reqres.in/img/faces/6-image.jpg"));

        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"));
        response.then().body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


        // altnernative
        response.then().body("data[5].id", equalTo(6),
                "data[5].email", equalTo("tracey.ramos@reqres.in"),
                "data[5].first_name",equalTo("Tracey"),
                "data[5].last_name",equalTo("Ramos"),
                "data[5].avatar",equalTo("https://reqres.in/img/faces/6-image.jpg"));

        response.then().body("support.url",equalTo("https://reqres.in/#support-heading"),
                "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }
}

