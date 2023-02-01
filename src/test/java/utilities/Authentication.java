package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {


    public static void main(String[] args) throws IOException {

        System.out.println(ContentType.BINARY);
        System.out.println(ContentType.ANY);
        System.out.println(ContentType.HTML);
        System.out.println(ContentType.MULTIPART);
        System.out.println(ContentType.TEXT);
        System.out.println(ContentType.URLENC);
        System.out.println(ContentType.XML);
        System.out.println("===================================================");
        String guncelToken = generateToken();
        System.out.println(guncelToken);
    }

    public static String generateToken() {

        RequestSpecification spec;
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("apiURL")).build();

        spec.pathParams("first", "connect", "second", "token");

        //Set the expected data

        Map<String, Object> expectedData = new HashMap<>();
       //   expectedData.put("client_id", "buybaseclientuser");
       //  expectedData.put("client_secret", "1q2w3e**");
       //   expectedData.put("grant_type", "password");
       //  expectedData.put("username", "tahaertasist@gmail.com");
       //   expectedData.put("password", "Te3441");
        String bodyData="client_id=buybaseclientuser&client_secret=1q2w3e**&grant_type=password&username=tahaertasist@gmail.com&password=Te3441";



        //  expectedData.put("phoneNumber", "5444496583");

        //Send the Post request and get the data
         // Response response = given().spec(spec).contentType(ContentType.URLENC).body(expectedData).when().post("/{first}/{second}");

       Response response = given().contentType(ContentType.URLENC).accept("*/*").body(bodyData).when().post(ConfigReader.getProperty("apiURL"));

        //response.prettyPrint();

        JsonPath json = response.jsonPath();


        return json.getString("access_token");

    }

}
