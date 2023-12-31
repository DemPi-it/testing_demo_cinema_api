package tests;

import models.ClientModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import specifications.Specifications;

import java.util.List;

import static endpoints.ControllersEndpoints.Clients;
import static endpoints.Endpoints.*;
import static specifications.Specifications.installSpecifications;
import static tests.GeneralMethods.*;

public class ClientsTests {

    @Test
    public void getAllClientsTest(){
        installOkSpecs();
        List<ClientModel> clients = getListAndExtract(Clients.getControllerEndpoint(), all.getEndpoint()).getList("", ClientModel.class);
        Assertions.assertNotNull(clients);
        clients.forEach(x->Assertions.assertNotNull(x.getId()));
    }
    @Test
    public void getClientsByEmail(){
        installOkSpecs();
        List<ClientModel> clients = getListAndExtract(Clients.getControllerEndpoint(),email.getEndpoint("hihihaha@yande.ru"))
                .getList("", ClientModel.class);
        Assertions.assertNotNull(clients);
    }
    @Test
    public void getClientById(){
        installOkSpecs();
        ClientModel client = getSingleAndExtract(Clients.getControllerEndpoint(),getById.getEndpoint(1)).as(ClientModel.class);
        Assertions.assertNotNull(client);
    }
    @Test
    public void postNewClientTest(){
        installOkSpecs();
        ClientModel client = postNewEntityAndExtract(new ClientModel("89774223333", "newemail@yandex.ru")
                , Clients.getControllerEndpoint(), add.getEndpoint()).as(ClientModel.class);
        Assertions.assertNotNull(client);
    }
    @Test
    public void putNewInfoTest(){
        installOkSpecs();
        ClientModel client = putNewInfoAndExtractEntity(new ClientModel(303,"89774225844","dempi2016@yandex.ru"),
                Clients.getControllerEndpoint(), update.getEndpoint(303)).as(ClientModel.class);
        Assertions.assertNotNull(client);
    }
    @Test
    public void deleteByIdTest(){
        installOkSpecs();
        String message = deleteAndExtractMessage(Clients.getControllerEndpoint(),deleteById.getEndpoint(402));
        Assertions.assertEquals("Deleted successful", message);
    }
}
