package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;

import static io.restassured.RestAssured.given;

public class GeneralMethods<T> {

    public static JsonPath getListAndExtract(String controllersEndpoint, String endpoint){
        return given().when().get(controllersEndpoint + endpoint).then().extract().body().jsonPath();
    }
    public static ResponseBodyExtractionOptions getSingleAndExtract(String controllersEndpoint, String endpoint){
        return given().when().get(controllersEndpoint + endpoint).then().log().all().extract().body();
    }

    public static <T> ResponseBodyExtractionOptions postNewEntityAndExtract(T entity, String controllersEndpoint, String endpoint){
        return given().when().body(entity).post(controllersEndpoint + endpoint).then().extract().body();
    }
    public static <T> ResponseBodyExtractionOptions putNewInfoAndExtractEntity(T entity, String controllersEndpoint, String endpoint){
        return given().when().body(entity).put(controllersEndpoint + endpoint).then().extract().body();
    }

    public static String deleteByIdAndExtractMessage(String controllersEndpoint, String endpoint){
        return given().when().delete(controllersEndpoint + endpoint).then().extract().body().asString();
    }
}
