package models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ClientModel {
    private Integer id;
    private String phoneNumber;
    private String email;

    public ClientModel(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
