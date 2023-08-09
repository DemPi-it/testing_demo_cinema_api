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
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        List<EmployeeModel> employees = getListAndExtract(Employees.getControllerEndpoint(), all.getEndpoint())
                .getList("", EmployeeModel.class);
        Assertions.assertNotNull(employees);
    }
    @Test
    public void getEmployeeByIdTest(){
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        EmployeeModel employee = getSingleAndExtract(Employees.getControllerEndpoint(), getById.getEndpoint(1)).as(EmployeeModel.class);
        Assertions.assertNotNull(employee);
    }
    @Test
    public void getEmployeeByEmailTest(){
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        EmployeeModel employee = getSingleAndExtract(Employees.getControllerEndpoint(), email.getEndpoint("danila@yandex.ru"))
                .as(EmployeeModel.class);
        Assertions.assertNotNull(employee);
    }
    @Test
    public void postNewEmployeeTest(){
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        EmployeeModel employee = postNewEntityAndExtract(new EmployeeModel("Konstantin", "Vinogradov", "Sergeevich"
                , "79057773422"
                , "kostya@yandex.ru"
                , "Golovachev St. 8"), Employees.getControllerEndpoint(), add.getEndpoint()).as(EmployeeModel.class);
    }
    @Test
    public void deleteEmployeeByIdTest(){
        installSpecifications(Specifications.requestSpecification(),Specifications.responseSpecificationOK());
        String message = deleteAndExtractMessage(Employees.getControllerEndpoint(),deleteById.getEndpoint(52));
        Assertions.assertEquals("Deleted successful", message);
    }

}
