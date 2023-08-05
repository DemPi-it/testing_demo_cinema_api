package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class FilmModel {
    private Integer filmId;
    private String filmTitle;
    private String releaseDate;
    private String genre;
    private Integer duration;
}
