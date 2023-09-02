package tests;

import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static endpoints.ControllersEndpoints.CinemaHalls;
import static endpoints.ControllersEndpoints.Tickets;
import static endpoints.Endpoints.*;
import static endpoints.Endpoints.deleteById;
import static tests.GeneralMethods.*;
import static tests.GeneralMethods.deleteAndExtractMessage;

public class TicketsTest {
    @Test
    public void getAllTicketsTest(){
        List<TicketModel> tickets = getListAndExtract(Tickets.getControllerEndpoint(), all.getEndpoint()).getList("", TicketModel.class);
        Assertions.assertNotNull(tickets);
        tickets.forEach(System.out::println);
    }

    @Test
    public void getTicketIdTest(){
        TicketModel ticket = getSingleAndExtract(Tickets.getControllerEndpoint(), getById.getEndpoint(1)).as(TicketModel.class);
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void postNewFilmTest(){
        installOkSpecs();
        CinemaHallModel cinema_halls = new CinemaHallModel(1, "Rocket Cinema Lublino", 150, "opened");
        EmployeeModel employees = new EmployeeModel(1,"Danila", "Zubchenko", "Igorevich",
                "79057822293", "danila@yandex.ru", "Krasnodonskaya st. 2");
        ClientModel clients = new ClientModel(1,"79774225555", "daria@yandex.ru");
        FilmModel films = new FilmModel(1, "John Wick", "2014", "thriller, action", 101);

        TicketModel newTicket = new TicketModel(5, "04.09.2023", "14:00", "12", cinema_halls, employees, clients, films);
        TicketModel addedTicket = postNewEntityAndExtract(newTicket, Tickets.getControllerEndpoint(), add.getEndpoint()).as(TicketModel.class);
        Assertions.assertNotNull(addedTicket);
    }

    @Test
    public void deleteTestByIdTest(){
        installOkSpecs();
        String expectedMessage = deleteAndExtractMessage(Tickets.getControllerEndpoint(), deleteById.getEndpoint(5));
        Assertions.assertEquals("Deleted successful", expectedMessage);
    }
}
