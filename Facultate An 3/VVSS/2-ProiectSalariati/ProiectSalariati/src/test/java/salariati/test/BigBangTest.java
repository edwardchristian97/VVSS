package salariati.test;

import org.junit.Before;
import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.enumeration.DidacticFunction;
import salariati.main.StartApp;
import salariati.model.Employee;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BigBangTest {
    private EmployeeRepositoryInterface employeeRepository;
    private EmployeeController controller;
    private EmployeeValidator employeeValidator;
    private StartApp main;


    @Before
    public void setUp() {
        employeeRepository = new EmployeeMock();
        controller = new EmployeeController(employeeRepository);
        employeeValidator = new EmployeeValidator();
        main = new StartApp();
    }

    @Test
    public void testRepositoryMock() {
        assertFalse(controller.getEmployeesList().isEmpty());
        assertEquals(6, controller.getEmployeesList().size());
    }

    @Test
    public void testValidSalary() {
        //Valid salary
        Employee newEmployee = new Employee("lastName", "FirstName", "1910509055057", DidacticFunction.ASISTENT, 3000);
        assertTrue(employeeValidator.isValid(newEmployee));
    }

    @Test
    public void testAsistentCNP() {
        //Valid CNP, Valid Asistent Function
        assertTrue(employeeRepository.updateDidacticFunction("1974567890124", "ASISTENT"));
    }

    @Test
    public void testValidInput() {
        //Valid Criteria
        assertTrue(controller.getEmployeesCriteria("cnp"));
    }

    @Test
    public void testIntegrationBigBang() {
        assertTrue(main.testareIntegrare(employeeRepository, controller));
    }
}
