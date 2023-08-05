package endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ControllersEndpoints {
    Clients("/clients"),
    Films("/films"),
    Employees("/employee"),
    CinemaHalls("/halls"),
    Cinemas("/cinemas"),
    Tickets("/tickets");

    private final String controllerEndpoint;
}
