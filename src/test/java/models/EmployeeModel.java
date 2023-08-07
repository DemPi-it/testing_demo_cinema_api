package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EmployeeModel {
    private Integer employeeId;
    private String firstName;
    private String secondName;
    private String middleName;
    private String phoneNumber;
    private String email;
    private String address;

    public EmployeeModel(String firstName, String secondName, String middleName, String phoneNumber, String email, String address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
