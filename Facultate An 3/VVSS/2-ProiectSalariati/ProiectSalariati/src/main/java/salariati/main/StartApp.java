package salariati.main;

import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;

import java.io.Reader;
import java.util.Scanner;

//functionalitati
//F01.	 adaugarea unui nou angajat (nume, prenume, CNP, functia didactica, salariul de incadrare);
//F02.	 modificarea functiei didactice (asistent/lector/conferentiar/profesor) a unui angajat;
//F03.	 afisarea salariatilor ordonati descrescator dupa salariu si crescator dupa varsta (CNP).

public class StartApp {

    public boolean testareIntegrare(EmployeeRepositoryInterface employeesRepository, EmployeeController employeeController) {
        employeesRepository = new EmployeeMock();
        employeeController = new EmployeeController(employeesRepository);

        Employee employee = new Employee("LastName", "FirstName", "1704567894321", DidacticFunction.CONFERENTIAR, 6600);
        if (!employeeController.addEmployee(employee))
            return false;

        if (!employeeController.modifyDidacticFunction("1704567894321", "TEACHER"))
            return false;

        if (!employeeController.getEmployeesCriteria("salariu"))
            return false;

        for (Employee _employee : employeeController.getEmployeesList())
            System.out.println(_employee.toString());

        return true;
    }

    public boolean testareIntegrarePA(EmployeeRepositoryInterface employeesRepository, EmployeeController employeeController) {
        employeesRepository = new EmployeeMock();
        employeeController = new EmployeeController(employeesRepository);

        Employee employee = new Employee("LastName", "FirstName", "1704567894321", DidacticFunction.CONFERENTIAR, 6600);
        if (!employeeController.addEmployee(employee))
            return false;

        return true;
    }

    public boolean testareIntegrarePAB(EmployeeRepositoryInterface employeesRepository, EmployeeController employeeController) {
        employeesRepository = new EmployeeMock();
        employeeController = new EmployeeController(employeesRepository);

        Employee employee = new Employee("LastName", "FirstName", "1704567894321", DidacticFunction.CONFERENTIAR, 6600);
        if (!employeeController.addEmployee(employee))
            return false;

        if (!employeeController.modifyDidacticFunction("1704567894321", "TEACHER"))
            return false;

        return true;

    }

    public static void main(String[] args) {
    }

}
