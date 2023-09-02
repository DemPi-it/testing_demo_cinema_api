package tests;

import models.CinemaModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static endpoints.ControllersEndpoints.Cinemas;
import static endpoints.Endpoints.*;
import static endpoints.Endpoints.deleteById;
import static tests.GeneralMethods.*;

public class CinemasTest {

    @Test
    public void getAllCinemasTest(){
        List<CinemaModel> cinemas = getListAndExtract(Cinemas.getControllerEndpoint(), all.getEndpoint()).getList("", CinemaModel.class);
        Assertions.assertNotNull(cinemas);
        cinemas.forEach(System.out::println);
    }

    @Test
    public void getCinemaByIdTest(){
        CinemaModel cinema = getSingleAndExtract(Cinemas.getControllerEndpoint(), getById.getEndpoint(1)).as(CinemaModel.class);
        Assertions.assertNotNull(cinema);
        Assertions.assertEquals(1, cinema.getCinemaId());
        Assertions.assertEquals("Rocket Cinema", cinema.getCinemaName());
    }

    @Test
    public void postNewFilmTest(){
        installOkSpecs();
        CinemaModel newCinema = new CinemaModel(3,"Star cinema", "Lublinskaya st. 12", "84953939321");
        CinemaModel addedCinema = postNewEntityAndExtract(newCinema, Cinemas.getControllerEndpoint(), add.getEndpoint()).as(CinemaModel.class);
        Assertions.assertNotNull(addedCinema);
    }

    @Test
    public void deleteTestByIdTest(){
        installOkSpecs();
        String expectedMessage = deleteAndExtractMessage(Cinemas.getControllerEndpoint(), deleteById.getEndpoint(3));
        Assertions.assertEquals("Deleted successful", expectedMessage);
    }
}
