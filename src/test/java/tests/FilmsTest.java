package tests;

import endpoints.ControllersEndpoints;
import endpoints.Endpoints;
import models.FilmModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static endpoints.ControllersEndpoints.Films;
import static endpoints.Endpoints.*;
import static tests.GeneralMethods.*;

public class FilmsTest {

    @Test
    public void getAllFilmsTest(){
        installOkSpecs();
        List<FilmModel> films = getListAndExtract(Films.getControllerEndpoint(), all.getEndpoint()).getList("", FilmModel.class);
        Assertions.assertNotNull(films);
    }

    @Test
    public void getFilmByIdTest(){
        installOkSpecs();
        FilmModel film = getSingleAndExtract(Films.getControllerEndpoint(), getById.getEndpoint(1)).as(FilmModel.class);
        Integer expectedId = 1;
        String expectedTitle = "John Wick";
        Assertions.assertEquals(expectedId, film.getFilmId());
        Assertions.assertEquals(expectedTitle, film.getFilmTitle());
    }

    @Test
    public void postNewFilmTest(){
        installOkSpecs();
        FilmModel newFilm = new FilmModel(5, "Gentlemen", "2020", "action, comedian", 140);
        FilmModel createdFilm = postNewEntityAndExtract(newFilm, Films.getControllerEndpoint(), add.getEndpoint()).as(FilmModel.class);
        Assertions.assertNotNull(createdFilm);
    }

    @Test
    public void deleteTestByIdTest(){
        installOkSpecs();
        String expectedMessage = deleteAndExtractMessage(Films.getControllerEndpoint(), deleteById.getEndpoint(1));
        Assertions.assertEquals("Deleted successful", expectedMessage);
    }
}
