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

public class UpdateDidacticFunctionTest {
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
    public void testAsistentCNP() {
        //Valid CNP, Valid Asistent Function
        assertTrue(employeeRepository.updateDidacticFunction("1234567890124", "ASISTENT"));
    }

    @Test
    public void testAsistentNoCNP() {
        //Non Valid CNP, Valid Asistent Function
        assertFalse(employeeRepository.updateDidacticFunction("1234567890131", "ASISTENT"));
    }

    @Test
    public void testConferentiarCNP() {
        //Valid CNP, Valid Conferentiar Function
        assertTrue(employeeRepository.updateDidacticFunction("1234567890123", "CONFERENTIAR"));
    }

    @Test
    public void testConferentiarNoCNP() {
        //Non Valid CNP, Valid Conferentiar Function
        assertFalse(employeeRepository.updateDidacticFunction("1234567810123", "CONFERENTIAR"));
    }

    @Test
    public void testLecturerCNP() {
        //Valid CNP, Valid Lecturer Function
        assertTrue(employeeRepository.updateDidacticFunction("1234567890127", "LECTURER"));
    }

    @Test
    public void testTeacherCNP() {
        //Valid CNP, Valid Teacher Function
        assertTrue(employeeRepository.updateDidacticFunction("1234567890123", "TEACHER"));
    }

    @Test
    public void testNonValidFunction() {
        //Non valid Functions
        assertFalse(employeeRepository.updateDidacticFunction("1234567890123", "TEST"));
    }

}
