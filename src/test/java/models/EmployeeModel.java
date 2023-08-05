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
}
