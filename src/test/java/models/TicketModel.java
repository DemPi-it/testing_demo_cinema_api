package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class TicketModel {
    private Integer ticketId;
    private String showDate;
    private String showTime;
    private String seat;
    private CinemaHallModel cinema_halls;
    private EmployeeModel employees;
    private ClientModel clients;
    private FilmModel films;
}
