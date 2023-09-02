package tests;

import models.CinemaHallModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static endpoints.ControllersEndpoints.CinemaHalls;
import static endpoints.Endpoints.*;
import static endpoints.Endpoints.deleteById;
import static tests.GeneralMethods.*;

public class CinemaHallsTest {

    @Test
    public void getAllCinemaHallsTest(){
        List<CinemaHallModel> cinemaHalls = getListAndExtract(CinemaHalls.getControllerEndpoint(), all.getEndpoint()).getList("", CinemaHallModel.class);
        Assertions.assertNotNull(cinemaHalls);
        cinemaHalls.forEach(System.out::println);
    }

    @Test
    public void getCinemaByIdTest(){
        CinemaHallModel cinemaHall = getSingleAndExtract(CinemaHalls.getControllerEndpoint(), getById.getEndpoint(1)).as(CinemaHallModel.class);
        Assertions.assertNotNull(cinemaHall);
    }

    @Test
    public void postNewFilmTest(){
        installOkSpecs();
        CinemaHallModel newCinemaHall = new CinemaHallModel(3, "Rocket Cinema Bratislavskaya", 150, "opened");
        CinemaHallModel addedCinemaHall = postNewEntityAndExtract(newCinemaHall, CinemaHalls.getControllerEndpoint(), add.getEndpoint()).as(CinemaHallModel.class);
        Assertions.assertNotNull(addedCinemaHall);
    }

    @Test
    public void deleteTestByIdTest(){
        installOkSpecs();
        String expectedMessage = deleteAndExtractMessage(CinemaHalls.getControllerEndpoint(), deleteById.getEndpoint(3));
        Assertions.assertEquals("Deleted successful", expectedMessage);
    }
}
