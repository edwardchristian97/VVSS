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

    public static void main(String[] args) {

        EmployeeRepositoryInterface employeesRepository = new EmployeeMock();
        EmployeeController employeeController = new EmployeeController(employeesRepository);

        for (Employee _employee : employeeController.getEmployeesList())
            System.out.println(_employee.toString());
        System.out.println("-----------------------------------------");

        Employee employee = new Employee("LastName", "FirstName", "1234567894321", DidacticFunction.CONFERENTIAR, 2500);
        employeeController.addEmployee(employee);

        for (Employee _employee : employeeController.getEmployeesList())
            System.out.println(_employee.toString());

        System.out.println("-----------------------------------------");
        System.out.println("CNP = ");
        Scanner scanner = new Scanner(System.in);
        String cnp = scanner.nextLine();
        System.out.println("Didactic Function = ");
        String didacticFunction = scanner.nextLine();
        employeeController.modifyDidacticFunction(cnp, didacticFunction);

        for (Employee _employee : employeeController.getEmployeesList())
            System.out.println(_employee.toString());



    }

}
