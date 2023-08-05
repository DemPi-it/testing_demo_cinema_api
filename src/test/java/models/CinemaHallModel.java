package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CinemaHallModel {
    private Integer hallId;
    private String hallName;
    private Integer capacity;
    private String status;
}
