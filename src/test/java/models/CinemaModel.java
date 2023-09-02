package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CinemaModel {
    private Integer cinemaId;
    private String cinemaName;
    private String address;
    private String phoneNumber;

    public CinemaModel(String cinemaName, String address, String phoneNumber) {
        this.cinemaName = cinemaName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
