package tests;


import io.restassured.http.ContentType;
import models.ClientModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import specifications.Specifications;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static endpoints.ControllersEndpoints.Clients;
import static endpoints.Endpoints.*;
import static io.restassured.RestAssured.given;
import static specifications.Specifications.installSpecifications;

public class ClientsTests {

    @Test
    public void getAllClientsTest(){
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        List<ClientModel> clients = given().when()
                .get(Clients.getControllerEndpoint()+ all.getEndpoint())
                .then().log().all()
                .extract().body().jsonPath().getList("", ClientModel.class);

        Assertions.assertNotNull(clients);
        clients.forEach(x->Assertions.assertNotNull(x.getId()));
    }

    @Test
    public void getClientsByEmail(){
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        List<ClientModel> clients = given()
                .when()
                .get(Clients.getControllerEndpoint()+email.getEndpoint("hihihaha@yande.ru"))
                .then().log().all()
                .extract().body().jsonPath().getList("", ClientModel.class);
        Assertions.assertNotNull(clients);
    }
    @Test
    public void getClientsByPhone(){
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        List<ClientModel> clients = given()
                .when()
                .get(Clients.getControllerEndpoint()+phoneNumber.getEndpoint("79057822222"))
                .then().log().all()
                .extract().body().jsonPath().getList("", ClientModel.class);
        Assertions.assertNotNull(clients);
    }

    @Test
    public void getClientById(){
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        ClientModel client = given()
                .when()
                .get(Clients.getControllerEndpoint()+getById.getEndpoint(1))
                .then().log().all()
                .extract().body().as(ClientModel.class);
        Assertions.assertNotNull(client);
    }
    @Test
    public void postNewClientTest(){
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        ClientModel client = given()
                .when()
                .body(new ClientModel("89774223333", "newemail@yandex.ru"))
                .post(Clients.getControllerEndpoint() + add.getEndpoint())
                .then().log().all()
                .extract().body().as(ClientModel.class);
        Assertions.assertNotNull(client);
    }
    @Test
    public void putNewInfoTest(){
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        ClientModel client = given()
                .when()
                .body(new ClientModel(303,"89774225844","dempi2016@yandex.ru"))
                .put(Clients.getControllerEndpoint()+update.getEndpoint(303))
                .then().log().all()
                .extract().body().as(ClientModel.class);
        Assertions.assertNotNull(client);
    }
    @Test
    public void deleteByIdTest(){
        installSpecifications(Specifications.requestSpecificationWithContentTypeTextPlain(),Specifications.responseSpecificationOK());
        String message = given()
                .when()
                .delete(Clients.getControllerEndpoint()+deleteById.getEndpoint(356))
                .then().log().all()
                .extract().asString();
        Assertions.assertEquals("Deleted successful", message);
    }
}
