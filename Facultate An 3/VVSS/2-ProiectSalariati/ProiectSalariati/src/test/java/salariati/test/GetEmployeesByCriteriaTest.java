package salariati.test;

import org.junit.Before;
import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.repository.interfaces.EmployeeRepositoryInterface;
import salariati.repository.mock.EmployeeMock;
import salariati.validator.EmployeeValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GetEmployeesByCriteriaTest {
    private EmployeeRepositoryInterface employeeRepository;
    private EmployeeController controller;
    private EmployeeValidator employeeValidator;

    @Before
    public void setUp() {
        employeeRepository = new EmployeeMock();
        controller = new EmployeeController(employeeRepository);
        employeeValidator = new EmployeeValidator();
    }

    @Test
    public void testRepositoryMock() {
        assertFalse(controller.getEmployeesList().isEmpty());
        assertEquals(6, controller.getEmployeesList().size());
    }

    @Test
    public void testValidInput() {
        assertTrue(controller.getEmployeesCriteria("cnp"));
        assertTrue(controller.getEmployeesCriteria("salariu"));
        assertTrue(controller.getEmployeesCriteria("SALARIU"));
        assertTrue(controller.getEmployeesCriteria("CNP"));
    }

    @Test
    public void testInvalidInput() {
        assertFalse(controller.getEmployeesCriteria("test"));
        assertFalse(controller.getEmployeesCriteria("dsahjdhasdhas"));
        assertFalse(controller.getEmployeesCriteria("cnpp"));
        assertFalse(controller.getEmployeesCriteria("SALARY"));
    }
}
