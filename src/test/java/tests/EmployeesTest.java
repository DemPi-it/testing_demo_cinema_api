package tests;

import models.EmployeeModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import specifications.Specifications;

import java.util.List;

import static endpoints.ControllersEndpoints.Employees;
import static endpoints.Endpoints.*;
import static specifications.Specifications.installSpecifications;
import static tests.GeneralMethods.*;

public class EmployeesTest {
    @Test
    public void getAllEmployeesListTest(){
        installOkSpecs();
        List<EmployeeModel> employees = getListAndExtract(Employees.getControllerEndpoint(), all.getEndpoint())
                .getList("", EmployeeModel.class);
        Assertions.assertNotNull(employees);
    }
    @Test
    public void getEmployeeByIdTest(){
        installOkSpecs();
        EmployeeModel employee = getSingleAndExtract(Employees.getControllerEndpoint(), getById.getEndpoint(1)).as(EmployeeModel.class);
        Assertions.assertNotNull(employee);
    }
    @Test
    public void getEmployeeByEmailTest(){
        installOkSpecs();
        EmployeeModel employee = getSingleAndExtract(Employees.getControllerEndpoint(), email.getEndpoint("danila@yandex.ru"))
                .as(EmployeeModel.class);
        Assertions.assertNotNull(employee);
    }
    @Test
    public void postNewEmployeeTest(){
        installOkSpecs();
        EmployeeModel employee = postNewEntityAndExtract(new EmployeeModel("Konstantin", "Vinogradov", "Sergeevich"
                , "79057773422"
                , "kostya@yandex.ru"
                , "Golovachev St. 8"), Employees.getControllerEndpoint(), add.getEndpoint()).as(EmployeeModel.class);
    }
    @Test
    public void deleteEmployeeByIdTest(){
        installOkSpecs();
        String message = deleteAndExtractMessage(Employees.getControllerEndpoint(),deleteById.getEndpoint(52));
        Assertions.assertEquals("Deleted successful", message);
    }

}
