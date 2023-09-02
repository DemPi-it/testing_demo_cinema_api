package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyExtractionOptions;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class GeneralMethods<T> {

    public static void installOkSpecs(){
        Specifications.installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
    }
    public static void installUniqueSpecs(Integer expectedStatusCode){
        Specifications.installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationUnique(expectedStatusCode));
    }
    public static JsonPath getListAndExtract(String controllersEndpoint, String endpoint){
        return given().when().get(controllersEndpoint + endpoint).then().extract().body().jsonPath();
    }
    public static ResponseBodyExtractionOptions getSingleAndExtract(String controllersEndpoint, String endpoint){
        return given().when().get(controllersEndpoint + endpoint).then().extract().body();
    }

    public static <T> ResponseBodyExtractionOptions postNewEntityAndExtract(T entity, String controllersEndpoint, String endpoint){
        return given().when().body(entity).post(controllersEndpoint + endpoint).then().log().all().extract().body();
    }
    public static <T> ResponseBodyExtractionOptions putNewInfoAndExtractEntity(T entity, String controllersEndpoint, String endpoint){
        return given().when().body(entity).put(controllersEndpoint + endpoint).then().extract().body();
    }

    public static String deleteAndExtractMessage(String controllersEndpoint, String endpoint){
        return given().when().delete(controllersEndpoint + endpoint).then().extract().body().asString();
    }
}
