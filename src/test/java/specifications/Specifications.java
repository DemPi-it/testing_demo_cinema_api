package specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.nio.charset.StandardCharsets;

public class Specifications {
    public static final String URL = "http://localhost:8080";

    public static RequestSpecification requestSpecification(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(URL)
                .build();
    }
    public static RequestSpecification requestSpecificationWithContentTypeTextPlain(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.TEXT.withCharset(StandardCharsets.UTF_8))
                .setBaseUri(URL)
                .build();
    }
    public static ResponseSpecification responseSpecificationOK(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static ResponseSpecification responseSpecificationUnique(Integer statusCode){
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    public static void installSpecifications(RequestSpecification requestSpecification, ResponseSpecification responseSpecification){
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
